package eu.wxrlds.beetifulgarden.item;

import eu.wxrlds.beetifulgarden.BeetifulGarden;
import eu.wxrlds.beetifulgarden.ModGroup;
import eu.wxrlds.beetifulgarden.config.BeetifulGardenCommonConfigs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BeetifulGarden.MOD_ID);

    public static final RegistryObject<Item> CLOUDY_BEETIFUL = ITEMS.register("cloudy_beetiful",
            () -> new BeetifulFruitItem(
                    new Item.Properties().tab(ModGroup.BEETIFULGARDEN_GROUP),
                    BeetifulGardenCommonConfigs.CLOUDY_EFFECTS::get,
                    BeetifulGardenCommonConfigs.CLOUDY_NUTRITION::get,
                    BeetifulGardenCommonConfigs.CLOUDY_SATURATION::get
            ));

    public static final RegistryObject<Item> EMINENCE_BEETIFUL = ITEMS.register("eminence_beetiful",
            () -> new BeetifulFruitItem(
                    new Item.Properties().tab(ModGroup.BEETIFULGARDEN_GROUP),
                    BeetifulGardenCommonConfigs.EMINENCE_EFFECTS::get,
                    BeetifulGardenCommonConfigs.EMINENCE_NUTRITION::get,
                    BeetifulGardenCommonConfigs.EMINENCE_SATURATION::get
            ));

    public static final RegistryObject<Item> MARINE_BEETIFUL = ITEMS.register("marine_beetiful",
            () -> new BeetifulFruitItem(
                    new Item.Properties().tab(ModGroup.BEETIFULGARDEN_GROUP),
                    BeetifulGardenCommonConfigs.MARINE_EFFECTS::get,
                    BeetifulGardenCommonConfigs.MARINE_NUTRITION::get,
                    BeetifulGardenCommonConfigs.MARINE_SATURATION::get
            ));

    public static final RegistryObject<Item> OLIVE_BEETIFUL = ITEMS.register("olive_beetiful",
            () -> new BeetifulFruitItem(
                    new Item.Properties().tab(ModGroup.BEETIFULGARDEN_GROUP),
                    BeetifulGardenCommonConfigs.OLIVE_EFFECTS::get,
                    BeetifulGardenCommonConfigs.OLIVE_NUTRITION::get,
                    BeetifulGardenCommonConfigs.OLIVE_SATURATION::get
            ));

    public static final RegistryObject<Item> PISTACHIO_BEETIFUL = ITEMS.register("pistachio_beetiful",
            () -> new BeetifulFruitItem(
                    new Item.Properties().tab(ModGroup.BEETIFULGARDEN_GROUP),
                    BeetifulGardenCommonConfigs.PISTACHIO_EFFECTS::get,
                    BeetifulGardenCommonConfigs.PISTACHIO_NUTRITION::get,
                    BeetifulGardenCommonConfigs.PISTACHIO_SATURATION::get
            ));

    public static final RegistryObject<Item> PIXIE_BEETIFUL = ITEMS.register("pixie_beetiful",
            () -> new BeetifulFruitItem(
                    new Item.Properties().tab(ModGroup.BEETIFULGARDEN_GROUP),
                    BeetifulGardenCommonConfigs.PIXIE_EFFECTS::get,
                    BeetifulGardenCommonConfigs.PIXIE_NUTRITION::get,
                    BeetifulGardenCommonConfigs.PIXIE_SATURATION::get
            ));

    public static final RegistryObject<Item> SIENNA_BEETIFUL = ITEMS.register("sienna_beetiful",
            () -> new BeetifulFruitItem(
                    new Item.Properties().tab(ModGroup.BEETIFULGARDEN_GROUP),
                    BeetifulGardenCommonConfigs.SIENNA_EFFECTS::get,
                    BeetifulGardenCommonConfigs.SIENNA_NUTRITION::get,
                    BeetifulGardenCommonConfigs.SIENNA_SATURATION::get
            ));

    public static final RegistryObject<Item> VELVET_BEETIFUL = ITEMS.register("velvet_beetiful",
            () -> new BeetifulFruitItem(
                    new Item.Properties().tab(ModGroup.BEETIFULGARDEN_GROUP),
                    BeetifulGardenCommonConfigs.VELVET_EFFECTS::get,
                    BeetifulGardenCommonConfigs.VELVET_NUTRITION::get,
                    BeetifulGardenCommonConfigs.VELVET_SATURATION::get
            ));

    public static final RegistryObject<Item> VERDANT_BEETIFUL = ITEMS.register("verdant_beetiful",
            () -> new BeetifulFruitItem(
                    new Item.Properties().tab(ModGroup.BEETIFULGARDEN_GROUP),
                    BeetifulGardenCommonConfigs.VERDANT_EFFECTS::get,
                    BeetifulGardenCommonConfigs.VERDANT_NUTRITION::get,
                    BeetifulGardenCommonConfigs.VERDANT_SATURATION::get
            ));

    public static final RegistryObject<Item> VERDIGRIS_BEETIFUL = ITEMS.register("verdigris_beetiful",
            () -> new BeetifulFruitItem(
                    new Item.Properties().tab(ModGroup.BEETIFULGARDEN_GROUP),
                    BeetifulGardenCommonConfigs.VERDIGRIS_EFFECTS::get,
                    BeetifulGardenCommonConfigs.VERDIGRIS_NUTRITION::get,
                    BeetifulGardenCommonConfigs.VERDIGRIS_SATURATION::get
            ));


    public static final RegistryObject<Item> BEETIFUL_SEEDS = ITEMS.register("beetiful_seeds",
            () -> new BeetifulSeed(
                    new Item.Properties().tab(ModGroup.BEETIFULGARDEN_GROUP)
            ));

    public static final RegistryObject<Item> BEETZZA = ITEMS.register("beetzza",
            () -> new Beetzza(
                    new Item.Properties()
                            .tab(ModGroup.BEETIFULGARDEN_GROUP)
                            .stacksTo(1)
                            .rarity(Rarity.EPIC)
            ));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}