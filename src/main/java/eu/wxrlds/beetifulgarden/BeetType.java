package eu.wxrlds.beetifulgarden;

import eu.wxrlds.beetifulgarden.config.BeetifulGardenCommonConfigs;
import eu.wxrlds.beetifulgarden.util.EffectsParser;
import net.minecraft.world.effect.MobEffectInstance;

import java.util.List;

public enum BeetType {
    CLOUDY("cloudy", "minecraft:speed:6000:1|minecraft:weakness:1800:0", "minecraft:blue_ice"),
    EMINENCE("eminence", "minecraft:fire_resistance:6000:0|minecraft:poison:1800:0", "minecraft:crying_obsidian"),
    MARINE("marine", "minecraft:resistance:6000:3|minecraft:blindness:300:0|minecraft:slowness:1200:1|minecraft:bad_omen:20:4", "minecraft:blue_glazed_terracotta"),
    OLIVE("olive", "minecraft:saturation:6000:0|minecraft:instant_damage:20:0", "minecraft:hay_block"),
    PISTACHIO("pistachio", "minecraft:strength:6000:2|minecraft:slowness:1200:3", "minecraft:wet_sponge"),
    PIXIE("pixie", "minecraft:regeneration:6000:0|minecraft:hunger:600:5", "minecraft:melon"),
    SIENNA("sienna", "minecraft:slow_falling:6000:0|minecraft:slowness:600:1", "minecraft:honeycomb_block"),
    VELVET("velvet", "minecraft:night_vision:6000:0|minecraft:invisibility:4500:0|minecraft:blindness:600:0", "minecraft:bubble_coral_block"),
    VERDANT("verdant", "minecraft:jump_boost:6000:2|minecraft:nausea:1200:1", "minecraft:slime_block"),
    VERDIGRIS("verdigris", "minecraft:water_breathing:6000:0|minecraft:mining_fatigue:3000:0", "minecraft:sea_lantern");

    private final String name;
    private final String baseEffects;
    private final String basePlantableOn;
    private List<MobEffectInstance> cachedEffectInstances = null;

    BeetType(String name, String baseEffects, String basePlantableOn) {
        this.name = name;
        this.baseEffects = baseEffects;
        this.basePlantableOn = basePlantableOn;
    }

    public String getName() {
        return name;
    }

    // These are used for the config builder
    public String getBaseEffects() {
        return baseEffects;
    }

    public String getBasePlantableOn() {
        return basePlantableOn;
    }

    // These are actually used when reading the config
    public String getEffects() {
        return getConfig().effects.get();
    }

    public String getPlantableOn() {
        return getConfig().plantableOn.get();
    }

    public int getNutrition() {
        return getConfig().nutrition.get();
    }

    public float getSaturation() {
        return getConfig().saturation.get().floatValue();
    }

    // Used by the tooltip
    public List<MobEffectInstance> getParsedEffects() {
        if (cachedEffectInstances == null) {
            cachedEffectInstances = EffectsParser.ConfigEffectsToEffectInstanceList(getEffects());
        }
        return cachedEffectInstances;
    }

    private BeetifulGardenCommonConfigs.BeetConfig getConfig() {
        return BeetifulGardenCommonConfigs.BEET_CONFIGS.get(this);
    }
}
