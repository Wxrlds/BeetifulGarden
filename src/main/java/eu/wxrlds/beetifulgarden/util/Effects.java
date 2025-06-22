package eu.wxrlds.beetifulgarden.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;

public class Effects {
    public static MobEffectInstance[] ConfigEffectsToEffectInstanceList(String effectString) {
        if (effectString.isEmpty()) {
            return new MobEffectInstance[0];
        }
        String[] effectStrings = effectString.split("\\|");
        List<MobEffectInstance> effectList = new ArrayList<>();
        for (String effect : effectStrings) {
            String[] parts = effect.split(":");

            String modID = parts[0];
            String effectID = parts[1];
            int duration = Integer.parseInt(parts[2]);
            int amplifier = Integer.parseInt(parts[3]);

            effectList.add(new MobEffectInstance(ForgeRegistries.MOB_EFFECTS.getValue(new ResourceLocation(modID, effectID)), duration, amplifier));
        }
        return effectList.toArray(new MobEffectInstance[0]);
    }
}
