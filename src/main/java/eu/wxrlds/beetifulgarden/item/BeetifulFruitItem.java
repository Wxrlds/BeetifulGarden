package eu.wxrlds.beetifulgarden.item;

import eu.wxrlds.beetifulgarden.config.BeetifulGardenCommonConfigs;
import eu.wxrlds.beetifulgarden.util.Effects;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Supplier;

public class BeetifulFruitItem extends Item {
    private final Supplier<String> effectsConfig;
    private final Supplier<Integer> nutritionConfig;
    private final Supplier<Double> saturationConfig;

    public BeetifulFruitItem(Properties properties, Supplier<String> effects, Supplier<Integer> nutrition, Supplier<Double> saturation) {
        super(properties.food(new FoodProperties.Builder().alwaysEat().build()));
        this.effectsConfig = effects;
        this.nutritionConfig = nutrition;
        this.saturationConfig = saturation;
    }

    public String getEffectString() {
        return effectsConfig.get();
    }

    public int getNutrition() {
        return nutritionConfig.get();
    }

    public float getSaturation() {
        return saturationConfig.get().floatValue();
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        List<MobEffectInstance> mobEffects = Effects.ConfigEffectsToEffectInstanceList(getEffectString());
        PotionUtils.addPotionTooltip(mobEffects, tooltip, 1.0F, worldIn == null ? 20.0F : worldIn.tickRateManager().tickrate());
    }
}
