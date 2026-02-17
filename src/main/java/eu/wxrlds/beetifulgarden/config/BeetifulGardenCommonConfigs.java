package eu.wxrlds.beetifulgarden.config;

import eu.wxrlds.beetifulgarden.BeetType;
import net.neoforged.neoforge.common.ModConfigSpec;

import java.util.EnumMap;
import java.util.Map;

public class BeetifulGardenCommonConfigs {
    public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    public static final ModConfigSpec SPEC;

    public static final Map<BeetType, BeetConfig> BEET_CONFIGS = new EnumMap<>(BeetType.class);
    public static final ModConfigSpec.ConfigValue<String> BEETZZA_NEGATES_EFFECT;

    static {
        BUILDER.comment(" Configs for the Beetiful Fruits");
        BUILDER.push("Beetiful");

        for (BeetType type : BeetType.values()) {
            BEET_CONFIGS.put(type, new BeetConfig(type, BUILDER));
        }

        BUILDER.pop();

        BUILDER.comment(" Configs for the Beetzza");
        BUILDER.push("Beetzza");
        String beetzzaDefaultNegates = "minecraft:wither";
        BEETZZA_NEGATES_EFFECT = BUILDER
                .comment(" Which effects the Beetzza removes when in the inventory\n Can be empty string to disable removing effects \"\"\n Effects separated by pipe (|)\n modID:effectID|modID:effectID\n Default: " + beetzzaDefaultNegates)
                .define("beetzzaNegatesEffects", beetzzaDefaultNegates);
        BUILDER.pop();

        SPEC = BUILDER.build();
    }

    public static class BeetConfig {
        public final ModConfigSpec.ConfigValue<Integer> nutrition;
        public final ModConfigSpec.ConfigValue<Double> saturation;
        public final ModConfigSpec.ConfigValue<String> effects;
        public final ModConfigSpec.ConfigValue<String> plantableOn;

        public BeetConfig(BeetType type, ModConfigSpec.Builder builder) {
            String name = type.getName();
            String category = name.substring(0, 1).toUpperCase() + name.substring(1);
            builder.push(category);
            int nutritionDefaultValue = 1;
            double saturationDefaultValue = 0.6;

            nutrition = builder
                    .comment(" Nutrition value for " + category + " Beetiful\n Default: " + nutritionDefaultValue)
                    .defineInRange(name + "Nutrition", nutritionDefaultValue, 0, 20);

            saturation = builder
                    .comment(" Saturation value for " + category + " Beetiful\n Default: " + saturationDefaultValue)
                    .defineInRange(name + "Saturation", saturationDefaultValue, 0.0, 20.0);

            effects = builder
                    .comment(" Effects of " + category + " Beetiful\n Can be empty string to disable effects \"\"\n Effects separated by pipe (|)\n modID:effectID:durationInTicks:amplifier|modID:effectID:durationInTicks:amplifier\n Default: " + type.getBaseEffects())
                    .define(name + "Effects", type.getBaseEffects());

            plantableOn = builder
                    .comment(" Which block the " + category + " Beetiful is plantable on\n Can be empty string to disable effects \"\"\n Blocks separated by pipe (|)\n modID:blockID|modID:blockID\n Default: " + type.getBasePlantableOn())
                    .define(name + "PlantableOn", type.getBasePlantableOn());

            builder.pop();
        }
    }
}
