package eu.wxrlds.beetifulgarden.item.fruit;

import eu.wxrlds.beetifulgarden.config.BeetifulGardenCommonConfigs;
import eu.wxrlds.beetifulgarden.util.Effects;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class VerdigrisBeetiful extends Item {
    public VerdigrisBeetiful(Properties properties) {
        super(properties.food(new FoodProperties.Builder().alwaysEat().build()));
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        String effectString = BeetifulGardenCommonConfigs.VERDIGRIS_EFFECTS.get();
        List<MobEffectInstance> mobEffects = Effects.ConfigEffectsToEffectInstanceList(effectString);
        PotionUtils.addPotionTooltip(mobEffects, tooltip, 1.0F, worldIn == null ? 20.0F : worldIn.tickRateManager().tickrate());
    }
}