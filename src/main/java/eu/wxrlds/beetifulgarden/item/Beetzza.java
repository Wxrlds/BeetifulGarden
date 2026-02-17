package eu.wxrlds.beetifulgarden.item;

import eu.wxrlds.beetifulgarden.util.EffectsParser;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class Beetzza extends Item {
    public Beetzza(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        List<Holder<MobEffect>> negated = EffectsParser.getNegatedEffects();
        if (!negated.isEmpty()) {
            tooltipComponents.add(Component.translatable("tooltip.beetifulgarden.beetzza_negates_alt").withStyle(ChatFormatting.GRAY));
            if (Screen.hasAltDown()) {
                for (Holder<MobEffect> effect : negated) {
                    tooltipComponents.add(Component.literal("- ")
                            .append(effect.value().getDisplayName())
                            .withStyle(ChatFormatting.GRAY));
                }
            }
        }
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level world, Entity entity, int slot, boolean selected) {
        if (!world.isClientSide && entity instanceof Player player) {
            List<Holder<MobEffect>> toRemove = EffectsParser.getNegatedEffects();
            for (Holder<MobEffect> effect : toRemove) {
                if (player.hasEffect(effect)) {
                    player.removeEffect(effect);
                }
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }
}
