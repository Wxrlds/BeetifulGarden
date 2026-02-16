package eu.wxrlds.beetifulgarden.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EffectsParser {
    private static final Logger LOGGER = LogManager.getLogger();

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
                if (!ForgeRegistries.MOB_EFFECTS.containsKey(effectRL)) {
                    LOGGER.warn("Effect '{}' does not exist! Skipping.", effectRL);
                    continue;
                }

                MobEffect effect = ForgeRegistries.MOB_EFFECTS.getValue(effectRL);
                if (effect == null) continue;

                int duration = Integer.parseInt(parts[2]);
                int amplifier = Integer.parseInt(parts[3]);

                effectInstanceList.add(new MobEffectInstance(effect, duration, amplifier));

            } catch (NumberFormatException e) {
                LOGGER.error("Duration or Amplifier is not a number in effect config: '{}'", entry);
            } catch (Exception e) {
                LOGGER.error("An unexpected error occurred parsing effect: '{}' - {}", entry, e.getMessage());
            }
        }

        return effectInstanceList;
    }
}
