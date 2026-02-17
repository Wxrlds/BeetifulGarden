package eu.wxrlds.beetifulgarden.util;

import com.mojang.logging.LogUtils;
import eu.wxrlds.beetifulgarden.config.BeetifulGardenCommonConfigs;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class EffectsParser {
    private static final Logger LOGGER = LogUtils.getLogger();
    private static String lastNegatedConfig = null;
    private static List<MobEffect> cachedNegatedEffects = null;

    public static List<MobEffectInstance> ConfigEffectsToEffectInstanceList(String effectString) {
        // Allow empty string
        if (effectString == null || effectString.trim().isEmpty()) {
            return Collections.emptyList();
        }

        List<MobEffectInstance> effectInstanceList = new ArrayList<>();
        String[] effectEntries = effectString.split("\\|");

        for (String entry : effectEntries) {
            entry = entry.trim();
            if (entry.isEmpty()) continue;

            try {
                String[] parts = entry.split(":");

                // Needs modid, name, duration, amplifier
                if (parts.length < 4) {
                    LOGGER.error("Skipping invalid effect config: '{}'. Expected 4 parts separated by colons.", entry);
                    continue;
                }

                ResourceLocation effectRL = new ResourceLocation(parts[0], parts[1]);

                // Check if the effect actually exists in the game
                Optional<MobEffect> effect = BuiltInRegistries.MOB_EFFECT.getOptional(effectRL);

                if (effect.isPresent()) {
                    int duration = Integer.parseInt(parts[2]);
                    int amplifier = Integer.parseInt(parts[3]);

                    effectInstanceList.add(new MobEffectInstance(effect.get(), duration, amplifier));
                } else {
                    LOGGER.warn("MobEffect '{}' not found in registry. Skipping entry.", effectRL);
                }

            } catch (NumberFormatException e) {
                LOGGER.error("Duration or Amplifier is not a number in effect config: '{}'", entry);
            } catch (Exception e) {
                LOGGER.error("An unexpected error occurred parsing effect: '{}' - {}", entry, e.getMessage());
            }
        }

        return effectInstanceList;
    }

    public static List<MobEffect> getNegatedEffects() {
        String currentConfig = BeetifulGardenCommonConfigs.BEETZZA_NEGATES_EFFECT.get();

        // The mod loads the config, before initialising it. This causes it to read the default value.
        if (lastNegatedConfig != null && lastNegatedConfig.equals(currentConfig)) {
            return cachedNegatedEffects;
        }
        lastNegatedConfig = currentConfig;
        cachedNegatedEffects = new ArrayList<>();

        if (currentConfig == null || currentConfig.trim().isEmpty()) {
            return cachedNegatedEffects;
        }

        String[] entries = currentConfig.split("\\|");

        for (String entry : entries) {
            entry = entry.trim();
            if (entry.isEmpty()) continue;
            ResourceLocation rl = ResourceLocation.tryParse(entry);
            if (rl == null) {
                LOGGER.error("Invalid ResourceLocation in Beetzza negate config: {}", entry);
                continue;
            }

            if (BuiltInRegistries.MOB_EFFECT.containsKey(rl)) {
                MobEffect effect = BuiltInRegistries.MOB_EFFECT.get(rl);
                if (effect != null) {
                    cachedNegatedEffects.add(effect);
                }
            } else {
                LOGGER.warn("Potion effect not found for Beetzza config: {}", entry);
            }
        }
        return cachedNegatedEffects;
    }
}
