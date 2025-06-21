package eu.wxrlds.beetifulgarden.util;

import eu.wxrlds.beetifulgarden.config.BeetifulGardenCommonConfigs;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;

import java.util.ArrayList;
import java.util.List;

public class Tooltips {
    public static List<MobEffectInstance> getMobEffects(String effectString) {
        List<MobEffectInstance> effectInstanceList = new ArrayList<>();
        if (effectString.isEmpty()) {
            return effectInstanceList;
        }
        String[] effectStrings = effectString.split("\\|");
        for (String effects : effectStrings) {
            String[] parts = effects.split(":");

            String modID = parts[0];
            String effectID = parts[1];
            int durationInTicks = Integer.parseInt(parts[2]);
            int amplifier = Integer.parseInt(parts[3]);

            ResourceLocation id = ResourceLocation.fromNamespaceAndPath(modID, effectID);
            ResourceKey<MobEffect> key = ResourceKey.create(Registries.MOB_EFFECT, id);
            Holder<MobEffect> holder = BuiltInRegistries.MOB_EFFECT.getHolder(key).get();

            effectInstanceList.add(new MobEffectInstance(holder, durationInTicks, amplifier));
        }
        return effectInstanceList;
    }

    public static void addCuresTooltip(List<Component> tooltip) {
        if (Screen.hasAltDown()) {
            String[] effectStrings = BeetifulGardenCommonConfigs.BEETZZA_NEGATES_EFFECT.get().split("\\|");
            for (String effectString : effectStrings) {

                ResourceLocation effectRL = ResourceLocation.parse(effectString);
                MobEffect mobEffect = BuiltInRegistries.MOB_EFFECT.get(effectRL);

                String translationKey = mobEffect.getDescriptionId();
                String displayName = I18n.get(translationKey);
                tooltip.add(Component.nullToEmpty(displayName).copy().withStyle(ChatFormatting.GRAY));
            }
        }
    }
}
