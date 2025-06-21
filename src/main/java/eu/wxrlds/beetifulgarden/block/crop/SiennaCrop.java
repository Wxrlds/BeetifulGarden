package eu.wxrlds.beetifulgarden.block.crop;

import eu.wxrlds.beetifulgarden.config.BeetifulGardenCommonConfigs;
import eu.wxrlds.beetifulgarden.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.BeetrootBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.PlantType;
import net.minecraftforge.registries.ForgeRegistries;

public class SiennaCrop extends BeetrootBlock implements IPlantable {
    private Block getPlantableOn() {
        String configValue = BeetifulGardenCommonConfigs.SIENNA_PLANTABLE_ON.get();
        return ForgeRegistries.BLOCKS.getValue(new ResourceLocation(configValue));
    }

    public SiennaCrop(Properties properties) {
        super(properties);
    }

    // Remove the plant type so that it cannot be placed on farmland
    @Override
    public PlantType getPlantType(BlockGetter world, BlockPos pos) {
        return null;
    }

    @Override
    public boolean canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction facing, IPlantable plantable) {
        return state.is(getPlantableOn());
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return state.is(getPlantableOn());
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.BEETIFUL_SEEDS.get();
    }
}