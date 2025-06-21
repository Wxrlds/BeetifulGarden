package eu.wxrlds.beetifulgarden.config;


import net.neoforged.neoforge.common.ModConfigSpec;

public class BeetifulGardenCommonConfigs {
    public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    public static final ModConfigSpec SPEC;
    public static final ModConfigSpec.ConfigValue<Integer> CLOUDY_NUTRITION;
    public static final ModConfigSpec.ConfigValue<Double> CLOUDY_SATURATION;
    public static final ModConfigSpec.ConfigValue<String> CLOUDY_EFFECTS;
    public static final ModConfigSpec.ConfigValue<String> CLOUDY_PLANTABLE_ON;
    public static final ModConfigSpec.ConfigValue<Integer> EMINENCE_NUTRITION;
    public static final ModConfigSpec.ConfigValue<Double> EMINENCE_SATURATION;
    public static final ModConfigSpec.ConfigValue<String> EMINENCE_EFFECTS;
    public static final ModConfigSpec.ConfigValue<String> EMINENCE_PLANTABLE_ON;
    public static final ModConfigSpec.ConfigValue<Integer> MARINE_NUTRITION;
    public static final ModConfigSpec.ConfigValue<Double> MARINE_SATURATION;
    public static final ModConfigSpec.ConfigValue<String> MARINE_EFFECTS;
    public static final ModConfigSpec.ConfigValue<String> MARINE_PLANTABLE_ON;
    public static final ModConfigSpec.ConfigValue<Integer> OLIVE_NUTRITION;
    public static final ModConfigSpec.ConfigValue<Double> OLIVE_SATURATION;
    public static final ModConfigSpec.ConfigValue<String> OLIVE_EFFECTS;
    public static final ModConfigSpec.ConfigValue<String> OLIVE_PLANTABLE_ON;
    public static final ModConfigSpec.ConfigValue<Integer> PISTACHIO_NUTRITION;
    public static final ModConfigSpec.ConfigValue<Double> PISTACHIO_SATURATION;
    public static final ModConfigSpec.ConfigValue<String> PISTACHIO_EFFECTS;
    public static final ModConfigSpec.ConfigValue<String> PISTACHIO_PLANTABLE_ON;
    public static final ModConfigSpec.ConfigValue<Integer> PIXIE_NUTRITION;
    public static final ModConfigSpec.ConfigValue<Double> PIXIE_SATURATION;
    public static final ModConfigSpec.ConfigValue<String> PIXIE_EFFECTS;
    public static final ModConfigSpec.ConfigValue<String> PIXIE_PLANTABLE_ON;
    public static final ModConfigSpec.ConfigValue<Integer> SIENNA_NUTRITION;
    public static final ModConfigSpec.ConfigValue<Double> SIENNA_SATURATION;
    public static final ModConfigSpec.ConfigValue<String> SIENNA_EFFECTS;
    public static final ModConfigSpec.ConfigValue<String> SIENNA_PLANTABLE_ON;
    public static final ModConfigSpec.ConfigValue<Integer> VELVET_NUTRITION;
    public static final ModConfigSpec.ConfigValue<Double> VELVET_SATURATION;
    public static final ModConfigSpec.ConfigValue<String> VELVET_EFFECTS;
    public static final ModConfigSpec.ConfigValue<String> VELVET_PLANTABLE_ON;
    public static final ModConfigSpec.ConfigValue<Integer> VERDANT_NUTRITION;
    public static final ModConfigSpec.ConfigValue<Double> VERDANT_SATURATION;
    public static final ModConfigSpec.ConfigValue<String> VERDANT_EFFECTS;
    public static final ModConfigSpec.ConfigValue<String> VERDANT_PLANTABLE_ON;
    public static final ModConfigSpec.ConfigValue<Integer> VERDIGRIS_NUTRITION;
    public static final ModConfigSpec.ConfigValue<Double> VERDIGRIS_SATURATION;
    public static final ModConfigSpec.ConfigValue<String> VERDIGRIS_EFFECTS;
    public static final ModConfigSpec.ConfigValue<String> VERDIGRIS_PLANTABLE_ON;
    public static final ModConfigSpec.ConfigValue<String> BEETZZA_NEGATES_EFFECT;

    static {
        BUILDER.comment("Configs for the Beetiful Fruits");
        BUILDER.push("Beetiful");
        String plantName = "Cloudy";
        BUILDER.push(plantName);
        CLOUDY_NUTRITION = BUILDER
                .comment("Nutrition value for " + plantName + " Beetiful")
                .defineInRange(plantName.toLowerCase() + "Nutrition", 1, 0, 20);
        CLOUDY_SATURATION = BUILDER
                .comment("Saturation value for " + plantName + " Beetiful")
                .defineInRange(plantName.toLowerCase() + "Saturation", 0.6, 0.0, 20.0);
        CLOUDY_EFFECTS = BUILDER
                .comment("Effects of " + plantName + " Beetiful\nCan be empty string to disable effects \"\"\nEffects separated by pipe (|)\nmodID:effectID:durationInTicks:amplifier|modID:effectID:durationInTicks:amplifier")
                .define(plantName.toLowerCase() + "Effects", "minecraft:speed:6000:1|minecraft:weakness:1800:0");
        CLOUDY_PLANTABLE_ON = BUILDER
                .comment("Which block the " + plantName + " Beetiful is plantable on\nCan be empty string to disable planting \"\"\nmodID:blockID")
                .define(plantName.toLowerCase() + "PlantableOn", "minecraft:blue_ice");
        BUILDER.pop();

        plantName = "Eminence";
        BUILDER.push(plantName);
        EMINENCE_NUTRITION = BUILDER
                .comment("Nutrition value for " + plantName + " Beetiful")
                .defineInRange(plantName.toLowerCase() + "Nutrition", 1, 0, 20);
        EMINENCE_SATURATION = BUILDER
                .comment("Saturation value for " + plantName + " Beetiful")
                .defineInRange(plantName.toLowerCase() + "Saturation", 0.6, 0.0, 20.0);
        EMINENCE_EFFECTS = BUILDER
                .comment("Effects of " + plantName + " Beetiful\nCan be empty string to disable effects \"\"\nEffects separated by pipe (|)\nmodID:effectID:durationInTicks:amplifier|modID:effectID:durationInTicks:amplifier")
                .define(plantName.toLowerCase() + "Effects", "minecraft:fire_resistance:6000:0|minecraft:poison:1800:0");
        EMINENCE_PLANTABLE_ON = BUILDER
                .comment("Which block the " + plantName + " Beetiful is plantable on\nCan be empty string to disable planting \"\"\nmodID:blockID")
                .define(plantName.toLowerCase() + "PlantableOn", "minecraft:crying_obsidian");
        BUILDER.pop();

        plantName = "Marine";
        BUILDER.push(plantName);
        MARINE_NUTRITION = BUILDER
                .comment("Nutrition value for " + plantName + " Beetiful")
                .defineInRange(plantName.toLowerCase() + "Nutrition", 1, 0, 20);
        MARINE_SATURATION = BUILDER
                .comment("Saturation value for " + plantName + " Beetiful")
                .defineInRange(plantName.toLowerCase() + "Saturation", 0.6, 0.0, 20.0);
        MARINE_EFFECTS = BUILDER
                .comment("Effects of " + plantName + " Beetiful\nCan be empty string to disable effects \"\"\nEffects separated by pipe (|)\nmodID:effectID:durationInTicks:amplifier|modID:effectID:durationInTicks:amplifier")
                .define(plantName.toLowerCase() + "Effects", "minecraft:resistance:6000:3|minecraft:blindness:300:0|minecraft:slowness:1200:1|minecraft:bad_omen:20:4");
        MARINE_PLANTABLE_ON = BUILDER
                .comment("Which block the " + plantName + " Beetiful is plantable on\nCan be empty string to disable planting \"\"\nmodID:blockID")
                .define(plantName.toLowerCase() + "PlantableOn", "minecraft:blue_glazed_terracotta");
        BUILDER.pop();

        plantName = "Olive";
        BUILDER.push(plantName);
        OLIVE_NUTRITION = BUILDER
                .comment("Nutrition value for " + plantName + " Beetiful")
                .defineInRange(plantName.toLowerCase() + "Nutrition", 1, 0, 20);
        OLIVE_SATURATION = BUILDER
                .comment("Saturation value for " + plantName + " Beetiful")
                .defineInRange(plantName.toLowerCase() + "Saturation", 0.6, 0.0, 20.0);
        OLIVE_EFFECTS = BUILDER
                .comment("Effects of " + plantName + " Beetiful\nCan be empty string to disable effects \"\"\nEffects separated by pipe (|)\nmodID:effectID:durationInTicks:amplifier|modID:effectID:durationInTicks:amplifier")
                .define(plantName.toLowerCase() + "Effects", "minecraft:saturation:6000:0|minecraft:instant_damage:20:0");
        OLIVE_PLANTABLE_ON = BUILDER
                .comment("Which block the " + plantName + " Beetiful is plantable on\nCan be empty string to disable planting \"\"\nmodID:blockID")
                .define(plantName.toLowerCase() + "PlantableOn", "minecraft:hay_block");
        BUILDER.pop();

        plantName = "Pistachio";
        BUILDER.push(plantName);
        PISTACHIO_NUTRITION = BUILDER
                .comment("Nutrition value for " + plantName + " Beetiful")
                .defineInRange(plantName.toLowerCase() + "Nutrition", 1, 0, 20);
        PISTACHIO_SATURATION = BUILDER
                .comment("Saturation value for " + plantName + " Beetiful")
                .defineInRange(plantName.toLowerCase() + "Saturation", 0.6, 0.0, 20.0);
        PISTACHIO_EFFECTS = BUILDER
                .comment("Effects of " + plantName + " Beetiful\nCan be empty string to disable effects \"\"\nEffects separated by pipe (|)\nmodID:effectID:durationInTicks:amplifier|modID:effectID:durationInTicks:amplifier")
                .define(plantName.toLowerCase() + "Effects", "minecraft:strength:6000:2|minecraft:slowness:1200:3");
        PISTACHIO_PLANTABLE_ON = BUILDER
                .comment("Which block the " + plantName + " Beetiful is plantable on\nCan be empty string to disable planting \"\"\nmodID:blockID")
                .define(plantName.toLowerCase() + "PlantableOn", "minecraft:wet_sponge");
        BUILDER.pop();

        plantName = "Pixie";
        BUILDER.push(plantName);
        PIXIE_NUTRITION = BUILDER
                .comment("Nutrition value for " + plantName + " Beetiful")
                .defineInRange(plantName.toLowerCase() + "Nutrition", 1, 0, 20);
        PIXIE_SATURATION = BUILDER
                .comment("Saturation value for " + plantName + " Beetiful")
                .defineInRange(plantName.toLowerCase() + "Saturation", 0.6, 0.0, 20.0);
        PIXIE_EFFECTS = BUILDER
                .comment("Effects of " + plantName + " Beetiful\nCan be empty string to disable effects \"\"\nEffects separated by pipe (|)\nmodID:effectID:durationInTicks:amplifier|modID:effectID:durationInTicks:amplifier")
                .define(plantName.toLowerCase() + "Effects", "minecraft:regeneration:6000:0|minecraft:hunger:600:5");
        PIXIE_PLANTABLE_ON = BUILDER
                .comment("Which block the " + plantName + " Beetiful is plantable on\nCan be empty string to disable planting \"\"\nmodID:blockID")
                .define(plantName.toLowerCase() + "PlantableOn", "minecraft:melon");
        BUILDER.pop();

        plantName = "Sienna";
        BUILDER.push(plantName);
        SIENNA_NUTRITION = BUILDER
                .comment("Nutrition value for " + plantName + " Beetiful")
                .defineInRange(plantName.toLowerCase() + "Nutrition", 1, 0, 20);
        SIENNA_SATURATION = BUILDER
                .comment("Saturation value for " + plantName + " Beetiful")
                .defineInRange(plantName.toLowerCase() + "Saturation", 0.6, 0.0, 20.0);
        SIENNA_EFFECTS = BUILDER
                .comment("Effects of " + plantName + " Beetiful\nCan be empty string to disable effects \"\"\nEffects separated by pipe (|)\nmodID:effectID:durationInTicks:amplifier|modID:effectID:durationInTicks:amplifier")
                .define(plantName.toLowerCase() + "Effects", "minecraft:slow_falling:6000:0|minecraft:slowness:600:1");
        SIENNA_PLANTABLE_ON = BUILDER
                .comment("Which block the " + plantName + " Beetiful is plantable on\nCan be empty string to disable planting \"\"\nmodID:blockID")
                .define(plantName.toLowerCase() + "PlantableOn", "minecraft:honeycomb_block");
        BUILDER.pop();

        plantName = "Velvet";
        BUILDER.push(plantName);
        VELVET_NUTRITION = BUILDER
                .comment("Nutrition value for " + plantName + " Beetiful")
                .defineInRange(plantName.toLowerCase() + "Nutrition", 1, 0, 20);
        VELVET_SATURATION = BUILDER
                .comment("Saturation value for " + plantName + " Beetiful")
                .defineInRange(plantName.toLowerCase() + "Saturation", 0.6, 0.0, 20.0);
        VELVET_EFFECTS = BUILDER
                .comment("Effects of " + plantName + " Beetiful\nCan be empty string to disable effects \"\"\nEffects separated by pipe (|)\nmodID:effectID:durationInTicks:amplifier|modID:effectID:durationInTicks:amplifier")
                .define(plantName.toLowerCase() + "Effects", "minecraft:night_vision:6000:0|minecraft:invisibility:4500:0|minecraft:blindness:600:0");
        VELVET_PLANTABLE_ON = BUILDER
                .comment("Which block the " + plantName + " Beetiful is plantable on\nCan be empty string to disable planting \"\"\nmodID:blockID")
                .define(plantName.toLowerCase() + "PlantableOn", "minecraft:bubble_coral_block");
        BUILDER.pop();

        plantName = "Verdant";
        BUILDER.push(plantName);
        VERDANT_NUTRITION = BUILDER
                .comment("Nutrition value for " + plantName + " Beetiful")
                .defineInRange(plantName.toLowerCase() + "Nutrition", 1, 0, 20);
        VERDANT_SATURATION = BUILDER
                .comment("Saturation value for " + plantName + " Beetiful")
                .defineInRange(plantName.toLowerCase() + "Saturation", 0.6, 0.0, 20.0);
        VERDANT_EFFECTS = BUILDER
                .comment("Effects of " + plantName + " Beetiful\nCan be empty string to disable effects \"\"\nEffects separated by pipe (|)\nmodID:effectID:durationInTicks:amplifier|modID:effectID:durationInTicks:amplifier")
                .define(plantName.toLowerCase() + "Effects", "minecraft:jump_boost:6000:2|minecraft:nausea:1200:1");
        VERDANT_PLANTABLE_ON = BUILDER
                .comment("Which block the " + plantName + " Beetiful is plantable on\nCan be empty string to disable planting \"\"\nmodID:blockID")
                .define(plantName.toLowerCase() + "PlantableOn", "minecraft:slime_block");
        BUILDER.pop();

        plantName = "Verdigris";
        BUILDER.push(plantName);
        VERDIGRIS_NUTRITION = BUILDER
                .comment("Nutrition value for " + plantName + " Beetiful")
                .defineInRange(plantName.toLowerCase() + "Nutrition", 1, 0, 20);
        VERDIGRIS_SATURATION = BUILDER
                .comment("Saturation value for " + plantName + " Beetiful")
                .defineInRange(plantName.toLowerCase() + "Saturation", 0.6, 0.0, 20.0);
        VERDIGRIS_EFFECTS = BUILDER
                .comment("Effects of " + plantName + " Beetiful\nCan be empty string to disable effects \"\"\nEffects separated by pipe (|)\nmodID:effectID:durationInTicks:amplifier|modID:effectID:durationInTicks:amplifier")
                .define(plantName.toLowerCase() + "Effects", "minecraft:water_breathing:6000:0|minecraft:mining_fatigue:3000:0");
        VERDIGRIS_PLANTABLE_ON = BUILDER
                .comment("Which block the " + plantName + " Beetiful is plantable on\nCan be empty string to disable planting \"\"\nmodID:blockID")
                .define(plantName.toLowerCase() + "PlantableOn", "minecraft:sea_lantern");
        BUILDER.pop();
        BUILDER.pop();

        BUILDER.comment("Configs for the Beetzza");
        BUILDER.push("Beetzza");
        BEETZZA_NEGATES_EFFECT = BUILDER
                .comment("Which effects the Beetzza removes when in the inventory\nCan be empty string to disable removing effects \"\"\nEffects separated by pipe (|)\nmodID:effectID|modID:effectID")
                .define("beetzzaNegatesEffects", "minecraft:wither");
        BUILDER.pop();

        SPEC = BUILDER.build();
    }
}
