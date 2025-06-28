package eu.wxrlds.beetifulgarden.util;

import eu.wxrlds.beetifulgarden.config.BeetifulGardenCommonConfigs;
import eu.wxrlds.beetifulgarden.item.ModItems;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.SubscribeEvent;
import squeek.appleskin.api.event.FoodValuesEvent;
import squeek.appleskin.api.food.FoodValues;

public class AppleSkinEventHandler {
    @SubscribeEvent
    public void onFoodValuesEvent(FoodValuesEvent event) {
        Item item = event.itemStack.getItem();

        int nutritionValue;
        double saturationValue;

        if (item == ModItems.CLOUDY_BEETIFUL.get()) {
            nutritionValue = BeetifulGardenCommonConfigs.CLOUDY_NUTRITION.get();
            saturationValue = BeetifulGardenCommonConfigs.CLOUDY_SATURATION.get();
        } else if (item == ModItems.EMINENCE_BEETIFUL.get()) {
            nutritionValue = BeetifulGardenCommonConfigs.EMINENCE_NUTRITION.get();
            saturationValue = BeetifulGardenCommonConfigs.EMINENCE_SATURATION.get();
        } else if (item == ModItems.MARINE_BEETIFUL.get()) {
            nutritionValue = BeetifulGardenCommonConfigs.MARINE_NUTRITION.get();
            saturationValue = BeetifulGardenCommonConfigs.MARINE_SATURATION.get();
        } else if (item == ModItems.OLIVE_BEETIFUL.get()) {
            nutritionValue = BeetifulGardenCommonConfigs.OLIVE_NUTRITION.get();
            saturationValue = BeetifulGardenCommonConfigs.OLIVE_SATURATION.get();
        } else if (item == ModItems.PISTACHIO_BEETIFUL.get()) {
            nutritionValue = BeetifulGardenCommonConfigs.PISTACHIO_NUTRITION.get();
            saturationValue = BeetifulGardenCommonConfigs.PISTACHIO_SATURATION.get();
        } else if (item == ModItems.PIXIE_BEETIFUL.get()) {
            nutritionValue = BeetifulGardenCommonConfigs.PIXIE_NUTRITION.get();
            saturationValue = BeetifulGardenCommonConfigs.PIXIE_SATURATION.get();
        } else if (item == ModItems.SIENNA_BEETIFUL.get()) {
            nutritionValue = BeetifulGardenCommonConfigs.SIENNA_NUTRITION.get();
            saturationValue = BeetifulGardenCommonConfigs.SIENNA_SATURATION.get();
        } else if (item == ModItems.VELVET_BEETIFUL.get()) {
            nutritionValue = BeetifulGardenCommonConfigs.VELVET_NUTRITION.get();
            saturationValue = BeetifulGardenCommonConfigs.VELVET_SATURATION.get();
        } else if (item == ModItems.VERDANT_BEETIFUL.get()) {
            nutritionValue = BeetifulGardenCommonConfigs.VERDANT_NUTRITION.get();
            saturationValue = BeetifulGardenCommonConfigs.VERDANT_SATURATION.get();
        } else if (item == ModItems.VERDIGRIS_BEETIFUL.get()) {
            nutritionValue = BeetifulGardenCommonConfigs.VERDIGRIS_NUTRITION.get();
            saturationValue = BeetifulGardenCommonConfigs.VERDIGRIS_SATURATION.get();
        } else {
            // If the item is not one of the Beetifuls, then do not execute the other code
            return;
        }
        event.modifiedFoodValues = new FoodValues(nutritionValue, (float) saturationValue);
    }
}
