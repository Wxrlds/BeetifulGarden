package eu.wxrlds.beetifulgarden.item;

import eu.wxrlds.beetifulgarden.BeetType;
import eu.wxrlds.beetifulgarden.block.ModBlocks;
import eu.wxrlds.beetifulgarden.config.BeetifulGardenCommonConfigs;
import eu.wxrlds.beetifulgarden.util.PlantableOnParser;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;

public class BeetifulSeed extends Item {

    public BeetifulSeed(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level world = context.getLevel();
        BlockPos clickPos = context.getClickedPos();
        BlockPos spawnPos = clickPos.above();
        Block blockBelow = world.getBlockState(clickPos).getBlock();

        // Ensure the space above is air/replaceable
        if (!world.getBlockState(spawnPos).getMaterial().isReplaceable()) {
            return InteractionResult.PASS;
        }

        for (BeetType type : BeetType.values()) {
            if (PlantableOnParser.isAllowed(blockBelow, type.getPlantableOn())) {
                Block blockToPlace = ModBlocks.CROP_BLOCKS.get(type).get();
                world.setBlockAndUpdate(spawnPos, blockToPlace.defaultBlockState());

                if (context.getPlayer() != null && !context.getPlayer().isCreative()) {
                    context.getItemInHand().shrink(1);
                }
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.PASS;
    }
}
