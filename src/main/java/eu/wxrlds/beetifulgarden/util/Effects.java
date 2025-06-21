package eu.wxrlds.beetifulgarden.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraftforge.registries.ForgeRegistries;

public class Effects {
    public static MobEffectInstance[] ConfigEffectsToEffectInstanceList(String effectString) {
        if (!effectString.isEmpty()) {
            String[] effectStrings = effectString.split("\\|");
            MobEffectInstance[] effectInstances = new MobEffectInstance[effectStrings.length];
            for (int i = 0; i < effectStrings.length; i++) {
                String[] parts = effectStrings[i].split(":");
                String modID = parts[0];
                String effectID = parts[1];
                int duration = Integer.parseInt(parts[2]);
                int amplifier = Integer.parseInt(parts[3]);
                effectInstances[i] = new MobEffectInstance(ForgeRegistries.MOB_EFFECTS.getValue(new ResourceLocation(modID, effectID)), duration, amplifier);
            }
            return effectInstances;
        }
        return new MobEffectInstance[0];
    }
}
