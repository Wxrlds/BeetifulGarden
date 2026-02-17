package eu.wxrlds.beetifulgarden.item;

import eu.wxrlds.beetifulgarden.BeetType;
import eu.wxrlds.beetifulgarden.BeetifulGarden;
import eu.wxrlds.beetifulgarden.ModGroup;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.EnumMap;
import java.util.Map;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BeetifulGarden.MOD_ID);

    public static final Map<BeetType, RegistryObject<Item>> BEETIFUL_FRUITS = new EnumMap<>(BeetType.class);

    public static final RegistryObject<Item> BEETIFUL_SEEDS = ITEMS.register("beetiful_seeds",
            () -> new BeetifulSeed(
                    new Item.Properties().tab(ModGroup.BEETIFULGARDEN_GROUP)));

    public static final RegistryObject<Item> BEETZZA = ITEMS.register("beetzza",
            () -> new Beetzza(
                    new Item.Properties()
                            .tab(ModGroup.BEETIFULGARDEN_GROUP)
                            .stacksTo(1)
                            .rarity(Rarity.EPIC)));

    static {
        for (BeetType type : BeetType.values()) {
            BEETIFUL_FRUITS.put(type, ITEMS.register(type.getName() + "_beetiful",
                    () -> new BeetifulFruitItem(new Item.Properties().tab(ModGroup.BEETIFULGARDEN_GROUP), type)));
        }
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
