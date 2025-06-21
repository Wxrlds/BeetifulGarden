package eu.wxrlds.beetifulgarden.item;

import eu.wxrlds.beetifulgarden.BeetifulGarden;
import eu.wxrlds.beetifulgarden.item.fruit.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BeetifulGarden.MOD_ID);

    public static final DeferredItem<Item> CLOUDY_BEETIFUL = ITEMS.register("cloudy_beetiful",
            () -> new CloudyBeetiful(
                    new Item.Properties()));

    public static final DeferredItem<Item> EMINENCE_BEETIFUL = ITEMS.register("eminence_beetiful",
            () -> new EminenceBeetiful(
                    new Item.Properties()));

    public static final DeferredItem<Item> MARINE_BEETIFUL = ITEMS.register("marine_beetiful",
            () -> new MarineBeetiful(
                    new Item.Properties()));

    public static final DeferredItem<Item> OLIVE_BEETIFUL = ITEMS.register("olive_beetiful",
            () -> new OliveBeetiful(
                    new Item.Properties()));

    public static final DeferredItem<Item> PISTACHIO_BEETIFUL = ITEMS.register("pistachio_beetiful",
            () -> new PistachioBeetiful(
                    new Item.Properties()));

    public static final DeferredItem<Item> PIXIE_BEETIFUL = ITEMS.register("pixie_beetiful",
            () -> new PixieBeetiful(
                    new Item.Properties()));

    public static final DeferredItem<Item> SIENNA_BEETIFUL = ITEMS.register("sienna_beetiful",
            () -> new SiennaBeetiful(
                    new Item.Properties()));

    public static final DeferredItem<Item> VELVET_BEETIFUL = ITEMS.register("velvet_beetiful",
            () -> new VelvetBeetiful(
                    new Item.Properties()));

    public static final DeferredItem<Item> VERDANT_BEETIFUL = ITEMS.register("verdant_beetiful",
            () -> new VerdantBeetiful(
                    new Item.Properties()));

    public static final DeferredItem<Item> VERDIGRIS_BEETIFUL = ITEMS.register("verdigris_beetiful",
            () -> new VerdigrisBeetiful(
                    new Item.Properties()));

    public static final DeferredItem<Item> BEETIFUL_SEEDS = ITEMS.register("beetiful_seeds",
            () -> new BeetifulSeed(
                    new Item.Properties()
            ));

    public static final DeferredItem<Item> BEETZZA = ITEMS.register("beetzza",
            () -> new Beetzza(
                    new Item.Properties()
                            .stacksTo(1)
                            .rarity(Rarity.EPIC)
            ));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}