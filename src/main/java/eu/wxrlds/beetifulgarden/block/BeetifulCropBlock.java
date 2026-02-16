package eu.wxrlds.beetifulgarden.block;

import eu.wxrlds.beetifulgarden.item.ModItems;
import eu.wxrlds.beetifulgarden.util.PlantableOnParser;
import net.minecraft.block.BeetrootBlock;
import net.minecraft.block.BlockState;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

import java.util.function.Supplier;

public class BeetifulCropBlock extends BeetrootBlock {
    private final Supplier<String> plantableOnConfig;

    public BeetifulCropBlock(Properties properties, Supplier<String> plantableOnConfig) {
        super(properties);
        this.plantableOnConfig = plantableOnConfig;
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return PlantableOnParser.isAllowed(state.getBlock(), plantableOnConfig.get());
    }

    @Override
    protected IItemProvider getBaseSeedId() {
        return ModItems.BEETIFUL_SEEDS.get();
    }
}
