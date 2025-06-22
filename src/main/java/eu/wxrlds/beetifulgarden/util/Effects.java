package eu.wxrlds.beetifulgarden.util;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;

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

            ResourceLocation id = ResourceLocation.fromNamespaceAndPath(modID, effectID);
            ResourceKey<MobEffect> key = ResourceKey.create(Registries.MOB_EFFECT, id);
            Holder<MobEffect> holder = BuiltInRegistries.MOB_EFFECT.getHolder(key).get();
            MobEffectInstance effects = new MobEffectInstance(holder, duration, amplifier);
            effectInstanceList.add(effects);
        }
        return effectInstanceList;
    }
}
