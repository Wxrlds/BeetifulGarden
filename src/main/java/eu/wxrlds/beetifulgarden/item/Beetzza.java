package eu.wxrlds.beetifulgarden.item;

import eu.wxrlds.beetifulgarden.util.EffectsParser;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class Beetzza extends Item {
    public Beetzza(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        List<Effect> negated = EffectsParser.getNegatedEffects();

        if (!negated.isEmpty()) {
            tooltip.add(new TranslationTextComponent("tooltip.beetifulgarden.beetzza_negates_alt").withStyle(TextFormatting.GRAY));

            if (Screen.hasAltDown()) {
                for (Effect effect : negated) {
                    tooltip.add(new StringTextComponent("- ")
                            .append(effect.getDisplayName())
                            .withStyle(TextFormatting.GRAY));
                }
            }
        }
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClientSide && entity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entity;
            List<Effect> toRemove = EffectsParser.getNegatedEffects();
            for (Effect effect : toRemove) {
                if (player.hasEffect(effect)) {
                    player.removeEffect(effect);
                }
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }
}
