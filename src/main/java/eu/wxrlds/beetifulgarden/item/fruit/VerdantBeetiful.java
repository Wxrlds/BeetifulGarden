package eu.wxrlds.beetifulgarden.item.fruit;

import eu.wxrlds.beetifulgarden.config.BeetifulGardenCommonConfigs;
import eu.wxrlds.beetifulgarden.util.Effects;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.alchemy.PotionContents;

import java.util.List;

public class VerdantBeetiful extends Item {
    public VerdantBeetiful(Properties properties) {
        super(properties.food(new FoodProperties.Builder().alwaysEdible().build()));
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        String effectString = BeetifulGardenCommonConfigs.VERDANT_EFFECTS.get();
        List<MobEffectInstance> mobEffects = Effects.ConfigEffectsToEffectInstanceList(effectString);
        PotionContents.addPotionTooltip(mobEffects, tooltipComponents::add, 1.0F, context.tickRate());
    }
}
