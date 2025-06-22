package eu.wxrlds.beetifulgarden.util;

import eu.wxrlds.beetifulgarden.BeetifulGarden;
import eu.wxrlds.beetifulgarden.config.BeetifulGardenCommonConfigs;
import eu.wxrlds.beetifulgarden.item.ModItems;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BeetifulGarden.MOD_ID)
public class ModEvents {
    @SubscribeEvent
    public static void applyBeetifulEffectOnEaten(LivingEntityUseItemEvent.Finish event) {
        // Only execute on server
        if (!event.getEntity().level().isClientSide()) {

            Player player = (Player) event.getEntity();

            MobEffectInstance[] effects;
            FoodData foodData = player.getFoodData();
            int nutritionValue;
            double saturationValue;

            // Get potion effects and food values
            Item item = event.getItem().getItem();
            if (item == ModItems.CLOUDY_BEETIFUL.get()) {
                effects = Effects.ConfigEffectsToEffectInstanceList(BeetifulGardenCommonConfigs.CLOUDY_EFFECTS.get()).toArray(new MobEffectInstance[0]);
                nutritionValue = BeetifulGardenCommonConfigs.CLOUDY_NUTRITION.get();
                saturationValue = BeetifulGardenCommonConfigs.CLOUDY_SATURATION.get();
            } else if (item == ModItems.EMINENCE_BEETIFUL.get()) {
                effects = Effects.ConfigEffectsToEffectInstanceList(BeetifulGardenCommonConfigs.EMINENCE_EFFECTS.get()).toArray(new MobEffectInstance[0]);
                nutritionValue = BeetifulGardenCommonConfigs.EMINENCE_NUTRITION.get();
                saturationValue = BeetifulGardenCommonConfigs.EMINENCE_SATURATION.get();
            } else if (item == ModItems.MARINE_BEETIFUL.get()) {
                effects = Effects.ConfigEffectsToEffectInstanceList(BeetifulGardenCommonConfigs.MARINE_EFFECTS.get()).toArray(new MobEffectInstance[0]);
                nutritionValue = BeetifulGardenCommonConfigs.MARINE_NUTRITION.get();
                saturationValue = BeetifulGardenCommonConfigs.MARINE_SATURATION.get();
            } else if (item == ModItems.OLIVE_BEETIFUL.get()) {
                effects = Effects.ConfigEffectsToEffectInstanceList(BeetifulGardenCommonConfigs.OLIVE_EFFECTS.get()).toArray(new MobEffectInstance[0]);
                nutritionValue = BeetifulGardenCommonConfigs.OLIVE_NUTRITION.get();
                saturationValue = BeetifulGardenCommonConfigs.OLIVE_SATURATION.get();
            } else if (item == ModItems.PISTACHIO_BEETIFUL.get()) {
                effects = Effects.ConfigEffectsToEffectInstanceList(BeetifulGardenCommonConfigs.PISTACHIO_EFFECTS.get()).toArray(new MobEffectInstance[0]);
                nutritionValue = BeetifulGardenCommonConfigs.PISTACHIO_NUTRITION.get();
                saturationValue = BeetifulGardenCommonConfigs.PISTACHIO_SATURATION.get();
            } else if (item == ModItems.PIXIE_BEETIFUL.get()) {
                effects = Effects.ConfigEffectsToEffectInstanceList(BeetifulGardenCommonConfigs.PIXIE_EFFECTS.get()).toArray(new MobEffectInstance[0]);
                nutritionValue = BeetifulGardenCommonConfigs.PIXIE_NUTRITION.get();
                saturationValue = BeetifulGardenCommonConfigs.PIXIE_SATURATION.get();
            } else if (item == ModItems.SIENNA_BEETIFUL.get()) {
                effects = Effects.ConfigEffectsToEffectInstanceList(BeetifulGardenCommonConfigs.SIENNA_EFFECTS.get()).toArray(new MobEffectInstance[0]);
                nutritionValue = BeetifulGardenCommonConfigs.SIENNA_NUTRITION.get();
                saturationValue = BeetifulGardenCommonConfigs.SIENNA_SATURATION.get();
            } else if (item == ModItems.VELVET_BEETIFUL.get()) {
                effects = Effects.ConfigEffectsToEffectInstanceList(BeetifulGardenCommonConfigs.VELVET_EFFECTS.get()).toArray(new MobEffectInstance[0]);
                nutritionValue = BeetifulGardenCommonConfigs.VELVET_NUTRITION.get();
                saturationValue = BeetifulGardenCommonConfigs.VELVET_SATURATION.get();
            } else if (item == ModItems.VERDANT_BEETIFUL.get()) {
                effects = Effects.ConfigEffectsToEffectInstanceList(BeetifulGardenCommonConfigs.VERDANT_EFFECTS.get()).toArray(new MobEffectInstance[0]);
                nutritionValue = BeetifulGardenCommonConfigs.VERDANT_NUTRITION.get();
                saturationValue = BeetifulGardenCommonConfigs.VERDANT_SATURATION.get();
            } else if (item == ModItems.VERDIGRIS_BEETIFUL.get()) {
                effects = Effects.ConfigEffectsToEffectInstanceList(BeetifulGardenCommonConfigs.VERDIGRIS_EFFECTS.get()).toArray(new MobEffectInstance[0]);
                nutritionValue = BeetifulGardenCommonConfigs.VERDIGRIS_NUTRITION.get();
                saturationValue = BeetifulGardenCommonConfigs.VERDIGRIS_SATURATION.get();
            } else {
                // If the item is not one of the Beetifuls, then do not execute the other code
                return;
            }

            for (MobEffectInstance effect : effects) {
                player.addEffect(effect);
            }
            // We need to cap it at 20 or the food value can go over the vanilla limit
            foodData.setSaturation(Math.min(20, foodData.getSaturationLevel() + (float) saturationValue));
            foodData.setFoodLevel(Math.min(20, foodData.getFoodLevel() + nutritionValue));
        }
    }
}