package eu.wxrlds.beetifulgarden.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;

public class Effects {
    public static List<MobEffectInstance> ConfigEffectsToEffectInstanceList(String effectString) {
        List<MobEffectInstance> effectInstanceList = new ArrayList<>();
        if (effectString.isEmpty()) {
            return effectInstanceList;
        }
        String[] effectStrings = effectString.split("\\|");
        for (String effect : effectStrings) {
            String[] parts = effect.split(":");

            String modID = parts[0];
            String effectID = parts[1];
            int duration = Integer.parseInt(parts[2]);
            int amplifier = Integer.parseInt(parts[3]);

            MobEffectInstance effects = new MobEffectInstance(ForgeRegistries.MOB_EFFECTS.getValue(ResourceLocation.fromNamespaceAndPath(modID, effectID)), duration, amplifier);
            effectInstanceList.add(effects);
        }
        return effectInstanceList;
    }
}
