package eu.wxrlds.beetifulgarden;

import eu.wxrlds.beetifulgarden.block.ModBlocks;
import eu.wxrlds.beetifulgarden.config.BeetifulGardenCommonConfigs;
import eu.wxrlds.beetifulgarden.item.ModItems;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod(BeetifulGarden.MOD_ID)
public class BeetifulGarden {
    public static final String MOD_ID = "beetifulgarden";
    private static final Logger LOGGER = LogManager.getLogger();

    public BeetifulGarden(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        // Config file
        modContainer.registerConfig(ModConfig.Type.COMMON, BeetifulGardenCommonConfigs.SPEC);

        // Register items and blocks
        ModItems.ITEMS.register(modEventBus);
        ModItems.register();
        ModBlocks.BLOCKS.register(modEventBus);
        ModBlocks.register();
        ModCreativeModTabs.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM THE BEETIFUL WORLD");
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // this is required or the game won't launch
    }
}
