package eu.wxrlds.beetifulgarden.item.fruit;

import eu.wxrlds.beetifulgarden.config.BeetifulGardenCommonConfigs;
import eu.wxrlds.beetifulgarden.util.Tooltips;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.alchemy.PotionContents;

import java.util.List;

public class OliveBeetiful extends Item {
    public OliveBeetiful(Properties properties) {
        super(properties.food(new FoodProperties.Builder().alwaysEdible().build()));
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        String effectsString = BeetifulGardenCommonConfigs.OLIVE_EFFECTS.get();
        List<MobEffectInstance> mob_effects = Tooltips.getMobEffects(effectsString);
        PotionContents.addPotionTooltip(mob_effects, tooltipComponents::add, 1.0F, context.tickRate());
    }
}