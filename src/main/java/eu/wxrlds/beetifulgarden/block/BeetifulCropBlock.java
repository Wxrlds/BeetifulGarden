package eu.wxrlds.beetifulgarden.block;

import eu.wxrlds.beetifulgarden.item.ModItems;
import eu.wxrlds.beetifulgarden.util.PlantableOnParser;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.BeetrootBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.IPlantable;

import java.util.function.Supplier;

public class BeetifulCropBlock extends BeetrootBlock implements IPlantable {
    private final Supplier<String> plantableOnConfig;

    public BeetifulCropBlock(Properties properties, Supplier<String> plantableOnConfig) {
        super(properties);
        this.plantableOnConfig = plantableOnConfig;
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return PlantableOnParser.isAllowed(state.getBlock(), plantableOnConfig.get());
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.BEETIFUL_SEEDS.get();
    }
}
