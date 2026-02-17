package eu.wxrlds.beetifulgarden;

import eu.wxrlds.beetifulgarden.config.BeetifulGardenCommonConfigs;
import net.neoforged.neoforge.common.ModConfigSpec;

import java.util.function.Supplier;

public enum BeetType {
    CLOUDY("cloudy", BeetifulGardenCommonConfigs.CLOUDY_NUTRITION, BeetifulGardenCommonConfigs.CLOUDY_SATURATION, BeetifulGardenCommonConfigs.CLOUDY_EFFECTS, BeetifulGardenCommonConfigs.CLOUDY_PLANTABLE_ON),
    EMINENCE("eminence", BeetifulGardenCommonConfigs.EMINENCE_NUTRITION, BeetifulGardenCommonConfigs.EMINENCE_SATURATION, BeetifulGardenCommonConfigs.EMINENCE_EFFECTS, BeetifulGardenCommonConfigs.EMINENCE_PLANTABLE_ON),
    MARINE("marine", BeetifulGardenCommonConfigs.MARINE_NUTRITION, BeetifulGardenCommonConfigs.MARINE_SATURATION, BeetifulGardenCommonConfigs.MARINE_EFFECTS, BeetifulGardenCommonConfigs.MARINE_PLANTABLE_ON),
    OLIVE("olive", BeetifulGardenCommonConfigs.OLIVE_NUTRITION, BeetifulGardenCommonConfigs.OLIVE_SATURATION, BeetifulGardenCommonConfigs.OLIVE_EFFECTS, BeetifulGardenCommonConfigs.OLIVE_PLANTABLE_ON),
    PISTACHIO("pistachio", BeetifulGardenCommonConfigs.PISTACHIO_NUTRITION, BeetifulGardenCommonConfigs.PISTACHIO_SATURATION, BeetifulGardenCommonConfigs.PISTACHIO_EFFECTS, BeetifulGardenCommonConfigs.PISTACHIO_PLANTABLE_ON),
    PIXIE("pixie", BeetifulGardenCommonConfigs.PIXIE_NUTRITION, BeetifulGardenCommonConfigs.PIXIE_SATURATION, BeetifulGardenCommonConfigs.PIXIE_EFFECTS, BeetifulGardenCommonConfigs.PIXIE_PLANTABLE_ON),
    SIENNA("sienna", BeetifulGardenCommonConfigs.SIENNA_NUTRITION, BeetifulGardenCommonConfigs.SIENNA_SATURATION, BeetifulGardenCommonConfigs.SIENNA_EFFECTS, BeetifulGardenCommonConfigs.SIENNA_PLANTABLE_ON),
    VELVET("velvet", BeetifulGardenCommonConfigs.VELVET_NUTRITION, BeetifulGardenCommonConfigs.VELVET_SATURATION, BeetifulGardenCommonConfigs.VELVET_EFFECTS, BeetifulGardenCommonConfigs.VELVET_PLANTABLE_ON),
    VERDANT("verdant", BeetifulGardenCommonConfigs.VERDANT_NUTRITION, BeetifulGardenCommonConfigs.VERDANT_SATURATION, BeetifulGardenCommonConfigs.VERDANT_EFFECTS, BeetifulGardenCommonConfigs.VERDANT_PLANTABLE_ON),
    VERDIGRIS("verdigris", BeetifulGardenCommonConfigs.VERDIGRIS_NUTRITION, BeetifulGardenCommonConfigs.VERDIGRIS_SATURATION, BeetifulGardenCommonConfigs.VERDIGRIS_EFFECTS, BeetifulGardenCommonConfigs.VERDIGRIS_PLANTABLE_ON);

    private final String name;
    private final Supplier<Integer> nutrition;
    private final Supplier<Double> saturation;
    private final Supplier<String> effects;
    private final Supplier<String> plantableOn;

    BeetType(String name, ModConfigSpec.ConfigValue<Integer> nutrition, ModConfigSpec.ConfigValue<Double> saturation, ModConfigSpec.ConfigValue<String> effects, ModConfigSpec.ConfigValue<String> plantableOn) {
        this.name = name;
        this.nutrition = nutrition;
        this.saturation = saturation;
        this.effects = effects;
        this.plantableOn = plantableOn;
    }

    public String getName() {
        return name;
    }

    public int getNutrition() {
        return nutrition.get();
    }

    public float getSaturation() {
        return saturation.get().floatValue();
    }

    public String getEffects() {
        return effects.get();
    }

    public String getPlantableOn() {
        return plantableOn.get();
    }
}
