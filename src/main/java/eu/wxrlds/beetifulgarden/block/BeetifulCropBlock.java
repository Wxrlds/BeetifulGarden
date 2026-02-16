package eu.wxrlds.beetifulgarden.block;

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

import java.util.function.Supplier;

public class BeetifulCropBlock extends BeetrootBlock implements IPlantable {
    private final Supplier<String> plantableOnConfig;

    public BeetifulCropBlock(Properties properties, Supplier<String> plantableOnConfig) {
        super(properties);
        this.plantableOnConfig = plantableOnConfig;
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter worldIn, BlockPos pos) {
        String configValue = plantableOnConfig.get();
        Block block = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(configValue));
        return state.is(block);
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.BEETIFUL_SEEDS.get();
    }
}
