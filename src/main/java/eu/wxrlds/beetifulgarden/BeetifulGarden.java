package eu.wxrlds.beetifulgarden;

import eu.wxrlds.beetifulgarden.block.ModBlocks;
import eu.wxrlds.beetifulgarden.config.BeetifulGardenCommonConfigs;
import eu.wxrlds.beetifulgarden.item.ModItems;
import eu.wxrlds.beetifulgarden.util.AppleSkinEventHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotTypeMessage;
import top.theillusivec4.curios.api.SlotTypePreset;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(BeetifulGarden.MOD_ID)
public class BeetifulGarden {
    public static final String MOD_ID = "beetifulgarden";
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public BeetifulGarden() {
        // Register the setup method for modloading
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Config file
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, BeetifulGardenCommonConfigs.SPEC, "beetifulgarden-common.toml");

        // Register items and blocks
        ModItems.register(eventBus);
        ModBlocks.register(eventBus);

        eventBus.addListener(this::setup);
        // Register the enqueueIMC method for modloading
        eventBus.addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        eventBus.addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        eventBus.addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        // some preinit code
        LOGGER.info("HELLO FROM THE BEETIFUL WORLD");
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // Configure rendering of the crops
        RenderTypeLookup.setRenderLayer(ModBlocks.CLOUDY_CROP.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.EMINENCE_CROP.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.MARINE_CROP.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.OLIVE_CROP.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.PISTACHIO_CROP.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.PIXIE_CROP.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.SIENNA_CROP.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.VELVET_CROP.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.VERDANT_CROP.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.VERDIGRIS_CROP.get(), RenderType.cutout());

        // AppleSkin
        if (ModList.get().isLoaded("appleskin")) {
            MinecraftForge.EVENT_BUS.register(new AppleSkinEventHandler());
        }
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
        InterModComms.sendTo(CuriosApi.MODID, SlotTypeMessage.REGISTER_TYPE,
                () -> SlotTypePreset.CURIO.getMessageBuilder().build());
    }

    private void processIMC(final InterModProcessEvent event) {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Beetiful Garden got IMC {}", event.getIMCStream().
                map(m -> m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        // LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            // LOGGER.info("HELLO from Register Block");
        }
    }
}
