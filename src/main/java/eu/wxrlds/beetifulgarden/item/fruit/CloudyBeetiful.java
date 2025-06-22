package eu.wxrlds.beetifulgarden.item.fruit;

import eu.wxrlds.beetifulgarden.config.BeetifulGardenCommonConfigs;
import eu.wxrlds.beetifulgarden.util.Tooltips;
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

public class CloudyBeetiful extends Item {
    public CloudyBeetiful(Properties properties) {
        super(properties.food(new FoodProperties.Builder().alwaysEat().build()));
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        String effectString = BeetifulGardenCommonConfigs.CLOUDY_EFFECTS.get();
        List<MobEffectInstance> mobEffects = Tooltips.getMobEffects(effectString);
        PotionUtils.addPotionTooltip(mobEffects, tooltip, 1.0F);
    }
}
