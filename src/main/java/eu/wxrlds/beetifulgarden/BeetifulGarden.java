package eu.wxrlds.beetifulgarden;

import eu.wxrlds.beetifulgarden.block.ModBlocks;
import eu.wxrlds.beetifulgarden.config.BeetifulGardenCommonConfigs;
import eu.wxrlds.beetifulgarden.item.ModItems;
import eu.wxrlds.beetifulgarden.util.AppleSkinEventHandler;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotTypeMessage;
import top.theillusivec4.curios.api.SlotTypePreset;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(BeetifulGarden.MOD_ID)
public class BeetifulGarden {
    public static final String MOD_ID = "beetifulgarden";
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public BeetifulGarden(FMLJavaModLoadingContext context) {
        // Register the setup method for modloading
        IEventBus eventBus = context.getModEventBus();

        // Config file
        context.registerConfig(ModConfig.Type.COMMON, BeetifulGardenCommonConfigs.SPEC, "beetifulgarden-common.toml");

        // Register items and blocks
        ModItems.register(eventBus);
        ModBlocks.register(eventBus);

        eventBus.addListener(this::setup);
        // Register the enqueueIMC method for modloading
        eventBus.addListener(this::enqueueIMC);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        eventBus.addListener(this::addCreative);
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == ModCreativeModTabs.BEETIFULGARDEN_GROUP) {
            event.accept(ModItems.CLOUDY_BEETIFUL);
            event.accept(ModItems.EMINENCE_BEETIFUL);
            event.accept(ModItems.MARINE_BEETIFUL);
            event.accept(ModItems.OLIVE_BEETIFUL);
            event.accept(ModItems.PISTACHIO_BEETIFUL);
            event.accept(ModItems.PIXIE_BEETIFUL);
            event.accept(ModItems.SIENNA_BEETIFUL);
            event.accept(ModItems.VELVET_BEETIFUL);
            event.accept(ModItems.VERDANT_BEETIFUL);
            event.accept(ModItems.VERDIGRIS_BEETIFUL);
            event.accept(ModItems.BEETIFUL_SEEDS);
            event.accept(ModItems.BEETZZA);
        }
    }

    private void setup(final FMLCommonSetupEvent event) {
        // some preinit code
        LOGGER.info("HELLO FROM THE BEETIFUL WORLD");
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            // AppleSkin
            if (ModList.get().isLoaded("appleskin")) {
                MinecraftForge.EVENT_BUS.register(new AppleSkinEventHandler());
            }
        }
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
        InterModComms.sendTo(CuriosApi.MODID, SlotTypeMessage.REGISTER_TYPE,
                () -> SlotTypePreset.CURIO.getMessageBuilder().build());
    }
}
