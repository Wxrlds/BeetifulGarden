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
                    .icon(() -> new ItemStack(ModItems.BEETIFUL_FRUITS.get(BeetType.VELVET).get()))
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
