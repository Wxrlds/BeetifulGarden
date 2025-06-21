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

            ResourceLocation id = ResourceLocation.fromNamespaceAndPath(modID, effectID);
            ResourceKey<MobEffect> key = ResourceKey.create(Registries.MOB_EFFECT, id);
            Holder<MobEffect> holder = BuiltInRegistries.MOB_EFFECT.getHolder(key).get();

            effectList.add(new MobEffectInstance(holder, duration, amplifier));

        }
        return effectList.toArray(new MobEffectInstance[0]);
    }
}
