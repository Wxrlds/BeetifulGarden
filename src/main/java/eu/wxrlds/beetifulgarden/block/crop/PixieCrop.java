package eu.wxrlds.beetifulgarden.block.crop;

import eu.wxrlds.beetifulgarden.config.BeetifulGardenCommonConfigs;
import eu.wxrlds.beetifulgarden.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.BeetrootBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.registries.ForgeRegistries;

public class PixieCrop extends BeetrootBlock implements IPlantable {
    private Block getPlantableOn() {
        String configValue = BeetifulGardenCommonConfigs.PIXIE_PLANTABLE_ON.get();
        return ForgeRegistries.BLOCKS.getValue(new ResourceLocation(configValue));
    }

    public PixieCrop(Properties properties) {
        super(properties);
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