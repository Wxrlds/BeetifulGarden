package eu.wxrlds.beetifulgarden.item;

import eu.wxrlds.beetifulgarden.config.BeetifulGardenCommonConfigs;
import eu.wxrlds.beetifulgarden.util.Effects;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Supplier;

public class BeetifulFruitItem extends Item {

    private final Supplier<String> effectsConfig;
    private final Supplier<Integer> nutritionConfig;
    private final Supplier<Double> saturationConfig;

    public BeetifulFruitItem(Properties properties, Supplier<String> effects, Supplier<Integer> nutrition, Supplier<Double> saturation) {
        super(properties.food(new Food.Builder().alwaysEat().build()));
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
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        List<EffectInstance> mobEffects = Effects.ConfigEffectsToEffectInstanceList(getEffectString());

        // Create a fake potion ItemStack to generate tooltip with custom effects.
        // The actual item can't store effects directly since we load the effect from the config file,
        // but PotionUtils.addPotionTooltip expects effects to be pulled from the ItemStack's NBT.
        // So we simulate a real potion item here with our desired effects baked in,
        // just to borrow its tooltip logic.
        ItemStack fakeStack = new ItemStack(Items.POTION);
        PotionUtils.setCustomEffects(fakeStack, mobEffects);
        PotionUtils.addPotionTooltip(fakeStack, tooltip, 1.0F);
    }
}
