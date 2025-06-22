package eu.wxrlds.beetifulgarden.util;

import eu.wxrlds.beetifulgarden.config.BeetifulGardenCommonConfigs;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

public class Tooltips {
    public static void addCuresTooltip(List<Component> tooltip) {
        if (Screen.hasAltDown()) {
            String[] effectStrings = BeetifulGardenCommonConfigs.BEETZZA_NEGATES_EFFECT.get().split("\\|");
            for (String effectString : effectStrings) {
                MobEffectInstance effects = new MobEffectInstance(ForgeRegistries.MOB_EFFECTS.getValue(ResourceLocation.parse(effectString)));

                String translationKey = effects.getEffect().getDescriptionId();
                String displayName = I18n.get(translationKey);
                tooltip.add(Component.nullToEmpty(displayName).copy().withStyle(ChatFormatting.GRAY));
            }
        }
    }
}
