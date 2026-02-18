package eu.wxrlds.beetifulgarden.item;

import eu.wxrlds.beetifulgarden.BeetType;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class BeetifulFruitItem extends Item {
    private final BeetType type;

    public BeetifulFruitItem(Properties properties, BeetType type) {
        super(properties.food(new FoodProperties.Builder().alwaysEat().build()));
        this.type = type;
    }

    public int getNutrition() {
        return type.getNutrition();
    }

    public float getSaturation() {
        return type.getSaturation();
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        PotionUtils.addPotionTooltip(type.getParsedEffects(), tooltip, 1.0F, worldIn == null ? 20.0F : worldIn.tickRateManager().tickrate());
    }

    // We need to define this here, instead of the Food Builder above
    // because our config file is not loaded by the time the Food Builder above runs
    // causing the saturation values to not be configurable
    @Override
    public FoodProperties getFoodProperties() {
        return new FoodProperties.Builder()
                .nutrition(getNutrition())
                .saturationMod(getSaturation())
                .alwaysEat()
                .build();
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity entity) {
        if (!world.isClientSide && entity instanceof Player player) {

            for (MobEffectInstance effect : type.getParsedEffects()) {
                player.addEffect(new MobEffectInstance(effect));
            }
        }
        return super.finishUsingItem(stack, world, entity);
    }
}
