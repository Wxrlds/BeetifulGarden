package eu.wxrlds.beetifulgarden.util;

import eu.wxrlds.beetifulgarden.BeetifulGarden;
import eu.wxrlds.beetifulgarden.item.BeetifulFruitItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.FoodStats;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = BeetifulGarden.MOD_ID)
public class ModEvents {
    @SubscribeEvent
    public static void applyBeetifulEffectOnEaten(LivingEntityUseItemEvent.Finish event) {
        // Only execute on server
        // Make sure this only triggers for players and not Wandering Traders
        if (event.getEntity().level.isClientSide() || !(event.getEntityLiving() instanceof PlayerEntity)) {
            return;
        }

        Item item = event.getItem().getItem();

        if (item instanceof BeetifulFruitItem) {
            BeetifulFruitItem fruit = (BeetifulFruitItem) item;
            PlayerEntity player = (PlayerEntity) event.getEntityLiving();

            // Apply effects
            List<EffectInstance> effects = EffectsParser.ConfigEffectsToEffectInstanceList(fruit.getEffectString());

            for (EffectInstance effect : effects) {
                player.addEffect(new EffectInstance(effect));
            }

            FoodStats foodStats = player.getFoodData();
            float saturation = fruit.getSaturation();
            int nutrition = fruit.getNutrition();

            // We need to cap it at 20 or the food value can go over the vanilla limit
            foodStats.setSaturation(Math.min(20, foodStats.getSaturationLevel() + saturation));
            foodStats.setFoodLevel(Math.min(20, foodStats.getFoodLevel() + nutrition));
        }
    }
}