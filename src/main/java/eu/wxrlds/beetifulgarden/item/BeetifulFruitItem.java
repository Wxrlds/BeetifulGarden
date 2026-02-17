package eu.wxrlds.beetifulgarden.item;

import eu.wxrlds.beetifulgarden.BeetType;
import eu.wxrlds.beetifulgarden.util.EffectsParser;
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

public class BeetifulFruitItem extends Item {
    private final BeetType type;

    public BeetifulFruitItem(Properties properties, BeetType type) {
        super(properties.food(new FoodProperties.Builder().alwaysEat().build()));
        this.type = type;
    }

    public String getEffectString() {
        return type.getEffects();
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
}
