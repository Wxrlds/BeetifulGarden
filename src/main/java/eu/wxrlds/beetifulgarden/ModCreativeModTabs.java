package eu.wxrlds.beetifulgarden;

import eu.wxrlds.beetifulgarden.item.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BeetifulGarden.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModTabs {

    public static CreativeModeTab BEETIFULGARDEN_GROUP;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        BEETIFULGARDEN_GROUP = event.registerCreativeModeTab(
                ResourceLocation.fromNamespaceAndPath(BeetifulGarden.MOD_ID, "beetifulgarden"),
                builder -> builder.icon(() -> new ItemStack(ModItems.VELVET_BEETIFUL.get()))
                        .title(Component.translatable("item_group.beetifulgarden_creative_mode_tab")));
    }
}
