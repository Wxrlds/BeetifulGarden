package eu.wxrlds.beetifulgarden.block;

import eu.wxrlds.beetifulgarden.BeetType;
import eu.wxrlds.beetifulgarden.item.ModItems;
import eu.wxrlds.beetifulgarden.util.PlantableOnParser;
import net.minecraft.block.BeetrootBlock;
import net.minecraft.block.BlockState;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class BeetifulCropBlock extends BeetrootBlock {
    private final BeetType type;

    public BeetifulCropBlock(Properties properties, BeetType type) {
        super(properties);
        this.type = type;
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return PlantableOnParser.isAllowed(state.getBlock(), type.getPlantableOn());
    }

    @Override
    protected IItemProvider getBaseSeedId() {
        return ModItems.BEETIFUL_SEEDS.get();
    }
}
