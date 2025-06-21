package eu.wxrlds.beetifulgarden.util;

import com.google.common.collect.Lists;
import com.mojang.datafixers.util.Pair;
import eu.wxrlds.beetifulgarden.config.BeetifulGardenCommonConfigs;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectUtil;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.Map;

public class Tooltips {
    private static final Component NO_EFFECT = (Component.translatable("effect.none")).withStyle(ChatFormatting.GRAY);

    // PotionUtils.addPotionTooltip
    @OnlyIn(Dist.CLIENT)
    public static void addPotionTooltip(List<Component> tooltip, float value, String effectString) {
        List<MobEffectInstance> list = getMobEffects(effectString);
        List<Pair<Attribute, AttributeModifier>> list1 = Lists.newArrayList();
        if (list.isEmpty()) {
            tooltip.add(NO_EFFECT);
        } else {
            for (MobEffectInstance mobeffectinstance : list) {
                MutableComponent mutablecomponent = Component.translatable(mobeffectinstance.getDescriptionId());
                MobEffect mobeffect = mobeffectinstance.getEffect();
                Map<Attribute, AttributeModifier> map = mobeffect.getAttributeModifiers();
                if (!map.isEmpty()) {
                    for (Map.Entry<Attribute, AttributeModifier> entry : map.entrySet()) {
                        AttributeModifier attributemodifier = entry.getValue();
                        AttributeModifier attributemodifier1 = new AttributeModifier(attributemodifier.getName(), mobeffect.getAttributeModifierValue(mobeffectinstance.getAmplifier(), attributemodifier), attributemodifier.getOperation());
                        list1.add(new Pair<>(entry.getKey(), attributemodifier1));
                    }
                }

                if (mobeffectinstance.getAmplifier() > 0) {
                    mutablecomponent = Component.translatable("potion.withAmplifier", mutablecomponent, Component.translatable("potion.potency." + mobeffectinstance.getAmplifier()));
                }

                if (mobeffectinstance.getDuration() > 20) {
                    mutablecomponent = Component.translatable("potion.withDuration", mutablecomponent, MobEffectUtil.formatDuration(mobeffectinstance, value));
                }

                tooltip.add(mutablecomponent.withStyle(mobeffect.getCategory().getTooltipFormatting()));
            }
        }

        if (!list1.isEmpty()) {
            tooltip.add(Component.empty());
            tooltip.add((Component.translatable("potion.whenDrank")).withStyle(ChatFormatting.DARK_PURPLE));

            for (Pair<Attribute, AttributeModifier> pair : list1) {
                AttributeModifier attributemodifier2 = pair.getSecond();
                double d0 = attributemodifier2.getAmount();
                double d1;
                if (attributemodifier2.getOperation() != AttributeModifier.Operation.MULTIPLY_BASE && attributemodifier2.getOperation() != AttributeModifier.Operation.MULTIPLY_TOTAL) {
                    d1 = attributemodifier2.getAmount();
                } else {
                    d1 = attributemodifier2.getAmount() * 100.0D;
                }

                if (d0 > 0.0D) {
                    tooltip.add((Component.translatable("attribute.modifier.plus." + attributemodifier2.getOperation().toValue(), ItemStack.ATTRIBUTE_MODIFIER_FORMAT.format(d1), Component.translatable(pair.getFirst().getDescriptionId()))).withStyle(ChatFormatting.BLUE));
                } else if (d0 < 0.0D) {
                    d1 = d1 * -1.0D;
                    tooltip.add((Component.translatable("attribute.modifier.take." + attributemodifier2.getOperation().toValue(), ItemStack.ATTRIBUTE_MODIFIER_FORMAT.format(d1), Component.translatable(pair.getFirst().getDescriptionId()))).withStyle(ChatFormatting.RED));
                }
            }
        }

    }

    public static List<MobEffectInstance> getMobEffects(String effectString) {
        List<MobEffectInstance> effectInstanceList = Lists.newArrayList();
        if (!effectString.isEmpty()) {
            String[] effectStrings = effectString.split("\\|");
            for (String effects : effectStrings) {
                String[] parts = effects.split(":");
                String modID = parts[0];
                String effectID = parts[1];
                int durationInTicks = Integer.parseInt(parts[2]);
                int amplifier = Integer.parseInt(parts[3]);

                MobEffectInstance effect = new MobEffectInstance(ForgeRegistries.MOB_EFFECTS.getValue(new ResourceLocation(modID, effectID)), durationInTicks, amplifier);
                effectInstanceList.add(effect);
            }
        }
        return effectInstanceList;
    }

    public static void addCuresTooltip(List<Component> tooltip) {
        if (Screen.hasAltDown()) {
            String[] effectStrings = BeetifulGardenCommonConfigs.BEETZZA_NEGATES_EFFECT.get().split("\\|");
            MobEffectInstance[] effects = new MobEffectInstance[effectStrings.length];
            for (int i = 0; i < effectStrings.length; i++) {
                String[] parts = effectStrings[i].split(":");
                String modID = parts[0];
                String effectID = parts[1];

                effects[i] = new MobEffectInstance(ForgeRegistries.MOB_EFFECTS.getValue(new ResourceLocation(modID, effectID)));
                String translationKey = effects[i].getEffect().getDescriptionId();
                String displayName = I18n.get(translationKey);
                tooltip.add(Component.nullToEmpty(displayName).copy().withStyle(ChatFormatting.GRAY));
            }
        }
    }
}
