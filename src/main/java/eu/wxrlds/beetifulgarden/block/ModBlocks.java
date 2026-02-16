package eu.wxrlds.beetifulgarden.block;

import eu.wxrlds.beetifulgarden.BeetifulGarden;
import eu.wxrlds.beetifulgarden.config.BeetifulGardenCommonConfigs;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(BeetifulGarden.MOD_ID);

    public static Block ParseConfigPlantableBlock(String blockString) {
        return BuiltInRegistries.BLOCK.get(new ResourceLocation(blockString));
    }

    public static final DeferredBlock<Block> CLOUDY_CROP = BLOCKS.register("cloudy_crop",
            () -> new BeetifulCropBlock(
                    BlockBehaviour.Properties.ofFullCopy(Blocks.BEETROOTS),
                    BeetifulGardenCommonConfigs.CLOUDY_PLANTABLE_ON::get
            ));

    public static final DeferredBlock<Block> EMINENCE_CROP = BLOCKS.register("eminence_crop",
            () -> new BeetifulCropBlock(
                    BlockBehaviour.Properties.ofFullCopy(Blocks.BEETROOTS),
                    BeetifulGardenCommonConfigs.EMINENCE_PLANTABLE_ON::get
            ));

    public static final DeferredBlock<Block> MARINE_CROP = BLOCKS.register("marine_crop",
            () -> new BeetifulCropBlock(
                    BlockBehaviour.Properties.ofFullCopy(Blocks.BEETROOTS),
                    BeetifulGardenCommonConfigs.MARINE_PLANTABLE_ON::get
            ));

    public static final DeferredBlock<Block> OLIVE_CROP = BLOCKS.register("olive_crop",
            () -> new BeetifulCropBlock(
                    BlockBehaviour.Properties.ofFullCopy(Blocks.BEETROOTS),
                    BeetifulGardenCommonConfigs.OLIVE_PLANTABLE_ON::get
            ));

    public static final DeferredBlock<Block> PISTACHIO_CROP = BLOCKS.register("pistachio_crop",
            () -> new BeetifulCropBlock(
                    BlockBehaviour.Properties.ofFullCopy(Blocks.BEETROOTS),
                    BeetifulGardenCommonConfigs.PISTACHIO_PLANTABLE_ON::get
            ));

    public static final DeferredBlock<Block> PIXIE_CROP = BLOCKS.register("pixie_crop",
            () -> new BeetifulCropBlock(
                    BlockBehaviour.Properties.ofFullCopy(Blocks.BEETROOTS),
                    BeetifulGardenCommonConfigs.PIXIE_PLANTABLE_ON::get
            ));

    public static final DeferredBlock<Block> SIENNA_CROP = BLOCKS.register("sienna_crop",
            () -> new BeetifulCropBlock(
                    BlockBehaviour.Properties.ofFullCopy(Blocks.BEETROOTS),
                    BeetifulGardenCommonConfigs.SIENNA_PLANTABLE_ON::get
            ));

    public static final DeferredBlock<Block> VELVET_CROP = BLOCKS.register("velvet_crop",
            () -> new BeetifulCropBlock(
                    BlockBehaviour.Properties.ofFullCopy(Blocks.BEETROOTS),
                    BeetifulGardenCommonConfigs.VELVET_PLANTABLE_ON::get
            ));

    public static final DeferredBlock<Block> VERDANT_CROP = BLOCKS.register("verdant_crop",
            () -> new BeetifulCropBlock(
                    BlockBehaviour.Properties.ofFullCopy(Blocks.BEETROOTS),
                    BeetifulGardenCommonConfigs.VERDANT_PLANTABLE_ON::get
            ));

    public static final DeferredBlock<Block> VERDIGRIS_CROP = BLOCKS.register("verdigris_crop",
            () -> new BeetifulCropBlock(
                    BlockBehaviour.Properties.ofFullCopy(Blocks.BEETROOTS),
                    BeetifulGardenCommonConfigs.VERDIGRIS_PLANTABLE_ON::get
            ));


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
