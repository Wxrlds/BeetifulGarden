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

public class PistachioCrop extends BeetrootBlock implements IPlantable {
    private Block getPlantableOn() {
        String configValue = BeetifulGardenCommonConfigs.PISTACHIO_PLANTABLE_ON.get();
        return ForgeRegistries.BLOCKS.getValue(new ResourceLocation(configValue));
    }

    public PistachioCrop(Properties properties) {
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