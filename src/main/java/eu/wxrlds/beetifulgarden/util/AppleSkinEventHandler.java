package eu.wxrlds.beetifulgarden.util;

import eu.wxrlds.beetifulgarden.item.BeetifulFruitItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import squeek.appleskin.api.event.FoodValuesEvent;
import squeek.appleskin.api.food.FoodValues;

public class AppleSkinEventHandler {
    @SubscribeEvent
    public void onFoodValuesEvent(FoodValuesEvent event) {
        Item item = event.itemStack.getItem();

        if (item instanceof BeetifulFruitItem) {
            BeetifulFruitItem fruit = (BeetifulFruitItem) item;
            event.modifiedFoodValues = new FoodValues(fruit.getNutrition(), fruit.getSaturation());
        }
    }
}
