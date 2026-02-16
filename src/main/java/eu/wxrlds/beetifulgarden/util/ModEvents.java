package eu.wxrlds.beetifulgarden.util;

import eu.wxrlds.beetifulgarden.BeetifulGarden;
import eu.wxrlds.beetifulgarden.item.BeetifulFruitItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent;

import java.util.List;

@EventBusSubscriber(modid = BeetifulGarden.MOD_ID)
public class ModEvents {
    @SubscribeEvent
    public static void applyBeetifulEffectOnEaten(LivingEntityUseItemEvent.Finish event) {
        // Only execute on server
        // Make sure this only triggers for players and not Wandering Traders
        if (event.getEntity().level().isClientSide() || !(event.getEntity() instanceof Player player)) {
            return;
        }

        Item item = event.getItem().getItem();

        if (item instanceof BeetifulFruitItem) {
            BeetifulFruitItem fruit = (BeetifulFruitItem) item;

            // Apply effects
            List<MobEffectInstance> effects = Effects.ConfigEffectsToEffectInstanceList(fruit.getEffectString());

            for (MobEffectInstance effect : effects) {
                player.addEffect(new MobEffectInstance(effect));
            }

            FoodData foodData = player.getFoodData();
            float saturation = fruit.getSaturation();
            int nutrition = fruit.getNutrition();

            // We need to cap it at 20 or the food value can go over the vanilla limit
            foodData.setSaturation(Math.min(20, foodData.getSaturationLevel() + saturation));
            foodData.setFoodLevel(Math.min(20, foodData.getFoodLevel() + nutrition));
        }
    }
}