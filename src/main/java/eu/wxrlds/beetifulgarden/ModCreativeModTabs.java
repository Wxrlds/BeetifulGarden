package eu.wxrlds.beetifulgarden;

import eu.wxrlds.beetifulgarden.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;


public class ModCreativeModTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BeetifulGarden.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> BEETIFULGARDEN_CREATIVE_MODE_TAB = CREATIVE_MODE_TABS.register("beetifulgarden",
            () -> CreativeModeTab.builder()
                    .icon(() -> ModItems.BEETIFUL_FRUITS.get(BeetType.VELVET).get().getDefaultInstance())
                    .title(Component.translatable("itemGroup.beetifulgarden"))
                    .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                    .displayItems((parameters, output) -> {
                        ModItems.BEETIFUL_FRUITS.values().forEach(registryObject -> {
                            output.accept(registryObject.get());
                        });
                        output.accept(ModItems.BEETIFUL_SEEDS.get());
                        output.accept(ModItems.BEETZZA.get());
                    }).build()
    );

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
