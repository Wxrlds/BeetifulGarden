package eu.wxrlds.beetifulgarden.block;

import eu.wxrlds.beetifulgarden.BeetType;
import eu.wxrlds.beetifulgarden.item.ModItems;
import eu.wxrlds.beetifulgarden.util.PlantableOnParser;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.BeetrootBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.IPlantable;

public class BeetifulCropBlock extends BeetrootBlock implements IPlantable {
    private final BeetType type;

    public BeetifulCropBlock(Properties properties, BeetType type) {
        super(properties);
        this.type = type;
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return PlantableOnParser.isAllowed(state.getBlock(), type.getPlantableOn());
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.BEETIFUL_SEEDS.get();
    }
}
