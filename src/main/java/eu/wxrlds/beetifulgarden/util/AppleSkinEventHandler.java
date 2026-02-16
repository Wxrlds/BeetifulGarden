package eu.wxrlds.beetifulgarden.util;

import eu.wxrlds.beetifulgarden.item.BeetifulFruitItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.SubscribeEvent;
import squeek.appleskin.api.event.FoodValuesEvent;

public class AppleSkinEventHandler {
    @SubscribeEvent
    public void onFoodValuesEvent(FoodValuesEvent event) {
        Item item = event.itemStack.getItem();

        if (item instanceof BeetifulFruitItem fruit) {
            event.modifiedFoodProperties = new FoodProperties.Builder().nutrition(fruit.getNutrition()).saturationModifier(fruit.getSaturation()).build();
        }
    }
}
