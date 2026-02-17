package eu.wxrlds.beetifulgarden.item;

import eu.wxrlds.beetifulgarden.BeetType;
import eu.wxrlds.beetifulgarden.block.ModBlocks;
import eu.wxrlds.beetifulgarden.util.PlantableOnParser;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BeetifulSeed extends Item {

    public BeetifulSeed(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResultType useOn(ItemUseContext context) {
        World world = context.getLevel();
        BlockPos clickPos = context.getClickedPos();
        if (context.getClickedFace() != Direction.UP) {
            return ActionResultType.PASS;
        }
        BlockPos spawnPos = clickPos.above();
        Block blockBelow = world.getBlockState(clickPos).getBlock();

        // Ensure the space above is air/replaceable
        if (!world.getBlockState(spawnPos).canBeReplaced(new BlockItemUseContext(context))) {
            return ActionResultType.PASS;
        }

        for (BeetType type : BeetType.values()) {
            if (PlantableOnParser.isAllowed(blockBelow, type.getPlantableOn())) {
                Block blockToPlace = ModBlocks.CROP_BLOCKS.get(type).get();
                world.setBlockAndUpdate(spawnPos, blockToPlace.defaultBlockState());

                if (context.getPlayer() != null && !context.getPlayer().isCreative()) {
                    context.getItemInHand().shrink(1);
                }
                return ActionResultType.SUCCESS;
            }
        }
        return ActionResultType.PASS;
    }
}
