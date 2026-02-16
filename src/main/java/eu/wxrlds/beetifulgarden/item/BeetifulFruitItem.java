package eu.wxrlds.beetifulgarden.item;

import eu.wxrlds.beetifulgarden.util.EffectsParser;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.alchemy.PotionContents;

import java.util.List;
import java.util.function.Supplier;

public class BeetifulFruitItem extends Item {
    private final Supplier<String> effectsConfig;
    private final Supplier<Integer> nutritionConfig;
    private final Supplier<Double> saturationConfig;

    public BeetifulFruitItem(Properties properties, Supplier<String> effects, Supplier<Integer> nutrition, Supplier<Double> saturation) {
        super(properties.food(new FoodProperties.Builder().alwaysEdible().build()));
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
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        List<MobEffectInstance> mobEffects = EffectsParser.ConfigEffectsToEffectInstanceList(getEffectString());
        PotionContents.addPotionTooltip(mobEffects, tooltipComponents::add, 1.0F, context.tickRate());
    }
}
