package eu.wxrlds.beetifulgarden;

import eu.wxrlds.beetifulgarden.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;


@Mod.EventBusSubscriber(modid = BeetifulGarden.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BeetifulGarden.MOD_ID);

    public static final RegistryObject<CreativeModeTab> BEETIFULGARDEN_GROUP = CREATIVE_MODE_TABS.register("beetifulgarden",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.VELVET_BEETIFUL.get()))
                    .title(Component.translatable("itemGroup.beetifulgarden"))
                    .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
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
