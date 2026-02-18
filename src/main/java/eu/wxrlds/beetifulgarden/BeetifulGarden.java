package eu.wxrlds.beetifulgarden;

import eu.wxrlds.beetifulgarden.block.ModBlocks;
import eu.wxrlds.beetifulgarden.config.BeetifulGardenCommonConfigs;
import eu.wxrlds.beetifulgarden.item.ModItems;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModLoadingContext;
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

    public BeetifulGarden() {
        // Register the setup method for modloading
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Config file
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, BeetifulGardenCommonConfigs.SPEC, "beetifulgarden-common.toml");

        // Register items and blocks
        ModItems.ITEMS.register(eventBus);
        ModItems.register();
        ModBlocks.BLOCKS.register(eventBus);
        ModBlocks.register();

        eventBus.addListener(this::setup);
        // Register the enqueueIMC method for modloading
        eventBus.addListener(this::enqueueIMC);
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
        ModBlocks.CROP_BLOCKS.values().forEach(registryObject -> {
            ItemBlockRenderTypes.setRenderLayer(registryObject.get(), RenderType.cutout());
        });
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
        InterModComms.sendTo(CuriosApi.MODID, SlotTypeMessage.REGISTER_TYPE, () -> SlotTypePreset.CURIO.getMessageBuilder().build());
    }
}
