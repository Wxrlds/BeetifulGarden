package eu.wxrlds.beetifulgarden.util;

import eu.wxrlds.beetifulgarden.config.BeetifulGardenCommonConfigs;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EffectsParser {
    private static final Logger LOGGER = LogManager.getLogger();
    private static String lastNegatedConfig = null;
    private static List<Effect> cachedNegatedEffects = null;

    public static List<EffectInstance> ConfigEffectsToEffectInstanceList(String effectString) {
        // Allow empty string
        if (effectString == null || effectString.trim().isEmpty()) {
            return Collections.emptyList();
        }

        List<EffectInstance> effectInstanceList = new ArrayList<>();
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
                if (!ForgeRegistries.POTIONS.containsKey(effectRL)) {
                    LOGGER.warn("Effect '{}' does not exist! Skipping.", effectRL);
                    continue;
                }

                Effect effect = ForgeRegistries.POTIONS.getValue(effectRL);
                if (effect == null) continue;

                int duration = Integer.parseInt(parts[2]);
                int amplifier = Integer.parseInt(parts[3]);

                effectInstanceList.add(new EffectInstance(effect, duration, amplifier));

            } catch (NumberFormatException e) {
                LOGGER.error("Duration or Amplifier is not a number in effect config: '{}'", entry);
            } catch (Exception e) {
                LOGGER.error("An unexpected error occurred parsing effect: '{}' - {}", entry, e.getMessage());
            }
        }

        return effectInstanceList;
    }

    public static List<Effect> getNegatedEffects() {
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

            if (ForgeRegistries.POTIONS.containsKey(rl)) {
                Effect effect = ForgeRegistries.POTIONS.getValue(rl);
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
