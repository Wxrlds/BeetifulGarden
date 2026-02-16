package eu.wxrlds.beetifulgarden.block;

import eu.wxrlds.beetifulgarden.item.ModItems;
import net.minecraft.block.BeetrootBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class BeetifulCropBlock extends BeetrootBlock {
    private final Supplier<String> plantableOnConfig;

    public BeetifulCropBlock(Properties properties, Supplier<String> plantableOnConfig) {
        super(properties);
        this.plantableOnConfig = plantableOnConfig;
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, IBlockReader worldIn, BlockPos pos) {
        String configValue = plantableOnConfig.get();
        Block block = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(configValue));
        return state.is(block);
    }

    @Override
    protected IItemProvider getBaseSeedId() {
        return ModItems.BEETIFUL_SEEDS.get();
    }
}
