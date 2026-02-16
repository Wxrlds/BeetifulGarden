package eu.wxrlds.beetifulgarden.block;

import eu.wxrlds.beetifulgarden.BeetifulGarden;
import eu.wxrlds.beetifulgarden.config.BeetifulGardenCommonConfigs;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = BeetifulGarden.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, BeetifulGarden.MOD_ID);

    public static Block ParseConfigPlantableBlock(String blockString) {
        return ForgeRegistries.BLOCKS.getValue(ResourceLocation.parse(blockString));
    }

    public static final RegistryObject<Block> CLOUDY_CROP = BLOCKS.register("cloudy_crop",
            () -> new BeetifulCropBlock(
                    BlockBehaviour.Properties.copy(Blocks.BEETROOTS),
                    BeetifulGardenCommonConfigs.CLOUDY_PLANTABLE_ON::get
            ));

    public static final RegistryObject<Block> EMINENCE_CROP = BLOCKS.register("eminence_crop",
            () -> new BeetifulCropBlock(
                    BlockBehaviour.Properties.copy(Blocks.BEETROOTS),
                    BeetifulGardenCommonConfigs.EMINENCE_PLANTABLE_ON::get
            ));

    public static final RegistryObject<Block> MARINE_CROP = BLOCKS.register("marine_crop",
            () -> new BeetifulCropBlock(
                    BlockBehaviour.Properties.copy(Blocks.BEETROOTS),
                    BeetifulGardenCommonConfigs.MARINE_PLANTABLE_ON::get
            ));

    public static final RegistryObject<Block> OLIVE_CROP = BLOCKS.register("olive_crop",
            () -> new BeetifulCropBlock(
                    BlockBehaviour.Properties.copy(Blocks.BEETROOTS),
                    BeetifulGardenCommonConfigs.OLIVE_PLANTABLE_ON::get
            ));

    public static final RegistryObject<Block> PISTACHIO_CROP = BLOCKS.register("pistachio_crop",
            () -> new BeetifulCropBlock(
                    BlockBehaviour.Properties.copy(Blocks.BEETROOTS),
                    BeetifulGardenCommonConfigs.PISTACHIO_PLANTABLE_ON::get
            ));

    public static final RegistryObject<Block> PIXIE_CROP = BLOCKS.register("pixie_crop",
            () -> new BeetifulCropBlock(
                    BlockBehaviour.Properties.copy(Blocks.BEETROOTS),
                    BeetifulGardenCommonConfigs.PIXIE_PLANTABLE_ON::get
            ));

    public static final RegistryObject<Block> SIENNA_CROP = BLOCKS.register("sienna_crop",
            () -> new BeetifulCropBlock(
                    BlockBehaviour.Properties.copy(Blocks.BEETROOTS),
                    BeetifulGardenCommonConfigs.SIENNA_PLANTABLE_ON::get
            ));

    public static final RegistryObject<Block> VELVET_CROP = BLOCKS.register("velvet_crop",
            () -> new BeetifulCropBlock(
                    BlockBehaviour.Properties.copy(Blocks.BEETROOTS),
                    BeetifulGardenCommonConfigs.VELVET_PLANTABLE_ON::get
            ));

    public static final RegistryObject<Block> VERDANT_CROP = BLOCKS.register("verdant_crop",
            () -> new BeetifulCropBlock(
                    BlockBehaviour.Properties.copy(Blocks.BEETROOTS),
                    BeetifulGardenCommonConfigs.VERDANT_PLANTABLE_ON::get
            ));

    public static final RegistryObject<Block> VERDIGRIS_CROP = BLOCKS.register("verdigris_crop",
            () -> new BeetifulCropBlock(
                    BlockBehaviour.Properties.copy(Blocks.BEETROOTS),
                    BeetifulGardenCommonConfigs.VERDIGRIS_PLANTABLE_ON::get
            ));


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
