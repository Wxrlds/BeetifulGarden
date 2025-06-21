package eu.wxrlds.beetifulgarden.block;

import eu.wxrlds.beetifulgarden.BeetifulGarden;
import eu.wxrlds.beetifulgarden.block.crop.*;
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
        return BuiltInRegistries.BLOCK.get(ResourceLocation.parse(blockString));
    }

    public static final DeferredBlock<Block> CLOUDY_CROP = BLOCKS.register("cloudy_crop",
            () -> new CloudyCrop(BlockBehaviour.Properties.ofFullCopy(Blocks.BEETROOTS)));

    public static final DeferredBlock<Block> EMINENCE_CROP = BLOCKS.register("eminence_crop",
            () -> new EminenceCrop(BlockBehaviour.Properties.ofFullCopy(Blocks.BEETROOTS)));

    public static final DeferredBlock<Block> MARINE_CROP = BLOCKS.register("marine_crop",
            () -> new MarineCrop(BlockBehaviour.Properties.ofFullCopy(Blocks.BEETROOTS)));

    public static final DeferredBlock<Block> OLIVE_CROP = BLOCKS.register("olive_crop",
            () -> new OliveCrop(BlockBehaviour.Properties.ofFullCopy(Blocks.BEETROOTS)));

    public static final DeferredBlock<Block> PISTACHIO_CROP = BLOCKS.register("pistachio_crop",
            () -> new PistachioCrop(BlockBehaviour.Properties.ofFullCopy(Blocks.BEETROOTS)));

    public static final DeferredBlock<Block> PIXIE_CROP = BLOCKS.register("pixie_crop",
            () -> new PixieCrop(BlockBehaviour.Properties.ofFullCopy(Blocks.BEETROOTS)));

    public static final DeferredBlock<Block> SIENNA_CROP = BLOCKS.register("sienna_crop",
            () -> new SiennaCrop(BlockBehaviour.Properties.ofFullCopy(Blocks.BEETROOTS)));

    public static final DeferredBlock<Block> VELVET_CROP = BLOCKS.register("velvet_crop",
            () -> new VelvetCrop(BlockBehaviour.Properties.ofFullCopy(Blocks.BEETROOTS)));

    public static final DeferredBlock<Block> VERDANT_CROP = BLOCKS.register("verdant_crop",
            () -> new VerdantCrop(BlockBehaviour.Properties.ofFullCopy(Blocks.BEETROOTS)));

    public static final DeferredBlock<Block> VERDIGRIS_CROP = BLOCKS.register("verdigris_crop",
            () -> new VerdigrisCrop(BlockBehaviour.Properties.ofFullCopy(Blocks.BEETROOTS)));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
