package eu.wxrlds.beetifulgarden;

import eu.wxrlds.beetifulgarden.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod(BeetifulGarden.MOD_ID)
public class ModCreativeModTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BeetifulGarden.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> BEETIFULGARDEN_CREATIVE_MODE_TAB = CREATIVE_MODE_TABS.register("beetifulgarden_creative_mode_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> ModItems.VELVET_BEETIFUL.get().getDefaultInstance())
                    .title(Component.translatable("item_group.beetifulgarden_creative_mode_tab"))
                    .withTabsBefore(CreativeModeTabs.COMBAT)
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.CLOUDY_BEETIFUL.get());
                        output.accept(ModItems.EMINENCE_BEETIFUL.get());
                        output.accept(ModItems.MARINE_BEETIFUL.get());
                        output.accept(ModItems.OLIVE_BEETIFUL.get());
                        output.accept(ModItems.PISTACHIO_BEETIFUL.get());
                        output.accept(ModItems.PIXIE_BEETIFUL.get());
                        output.accept(ModItems.SIENNA_BEETIFUL.get());
                        output.accept(ModItems.VELVET_BEETIFUL.get());
                        output.accept(ModItems.VERDANT_BEETIFUL.get());
                        output.accept(ModItems.VERDIGRIS_BEETIFUL.get());
                        output.accept(ModItems.BEETIFUL_SEEDS.get());
                        output.accept(ModItems.BEETZZA.get());
                    }).build()
    );

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
