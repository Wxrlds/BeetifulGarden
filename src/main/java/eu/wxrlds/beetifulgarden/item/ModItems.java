package eu.wxrlds.beetifulgarden.item;

import eu.wxrlds.beetifulgarden.BeetType;
import eu.wxrlds.beetifulgarden.BeetifulGarden;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.EnumMap;
import java.util.Map;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BeetifulGarden.MOD_ID);

    public static final Map<BeetType, DeferredItem<Item>> BEETIFUL_FRUITS = new EnumMap<>(BeetType.class);

    public static final DeferredItem<Item> BEETIFUL_SEEDS = ITEMS.register("beetiful_seeds",
            () -> new BeetifulSeed(
                    new Item.Properties()));

    public static final DeferredItem<Item> BEETZZA = ITEMS.register("beetzza",
            () -> new Beetzza(
                    new Item.Properties()
                            .stacksTo(1)
                            .rarity(Rarity.EPIC)));

    public static void register() {
        for (BeetType type : BeetType.values()) {
            BEETIFUL_FRUITS.put(type, ITEMS.register(type.getName() + "_beetiful",
                    () -> new BeetifulFruitItem(new Item.Properties(), type)));
        }
    }
}
