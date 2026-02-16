package eu.wxrlds.beetifulgarden.item;

import eu.wxrlds.beetifulgarden.block.ModBlocks;
import eu.wxrlds.beetifulgarden.config.BeetifulGardenCommonConfigs;
import eu.wxrlds.beetifulgarden.util.PlantableOnParser;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.RegistryObject;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;

public class BeetifulSeed extends Item {
    private static final Map<Supplier<String>, RegistryObject<Block>> PLANTING_RULES = new LinkedHashMap<>();

    public BeetifulSeed(Properties properties) {
        super(properties);
        setupRules();
    }

    private void setupRules() {
        if (!PLANTING_RULES.isEmpty()) return;

        PLANTING_RULES.put(BeetifulGardenCommonConfigs.CLOUDY_PLANTABLE_ON::get, ModBlocks.CLOUDY_CROP);
        PLANTING_RULES.put(BeetifulGardenCommonConfigs.EMINENCE_PLANTABLE_ON::get, ModBlocks.EMINENCE_CROP);
        PLANTING_RULES.put(BeetifulGardenCommonConfigs.MARINE_PLANTABLE_ON::get, ModBlocks.MARINE_CROP);
        PLANTING_RULES.put(BeetifulGardenCommonConfigs.OLIVE_PLANTABLE_ON::get, ModBlocks.OLIVE_CROP);
        PLANTING_RULES.put(BeetifulGardenCommonConfigs.PISTACHIO_PLANTABLE_ON::get, ModBlocks.PISTACHIO_CROP);
        PLANTING_RULES.put(BeetifulGardenCommonConfigs.PIXIE_PLANTABLE_ON::get, ModBlocks.PIXIE_CROP);
        PLANTING_RULES.put(BeetifulGardenCommonConfigs.SIENNA_PLANTABLE_ON::get, ModBlocks.SIENNA_CROP);
        PLANTING_RULES.put(BeetifulGardenCommonConfigs.VELVET_PLANTABLE_ON::get, ModBlocks.VELVET_CROP);
        PLANTING_RULES.put(BeetifulGardenCommonConfigs.VERDANT_PLANTABLE_ON::get, ModBlocks.VERDANT_CROP);
        PLANTING_RULES.put(BeetifulGardenCommonConfigs.VERDIGRIS_PLANTABLE_ON::get, ModBlocks.VERDIGRIS_CROP);
    }


    @Override
    public ActionResultType useOn(ItemUseContext context) {
        World world = context.getLevel();
        BlockPos clickPos = context.getClickedPos();
        BlockPos spawnPos = clickPos.above();
        Block blockBelow = world.getBlockState(clickPos).getBlock();

        // Ensure the space above is air/replaceable
        if (!world.getBlockState(spawnPos).getMaterial().isReplaceable()) {
            return ActionResultType.PASS;
        }

        // Iterate through all possible crops
        for (Map.Entry<Supplier<String>, RegistryObject<Block>> rule : PLANTING_RULES.entrySet()) {
            String configValue = rule.getKey().get();

            // If the block we clicked is allowed by this specific crop config we place it
            if (PlantableOnParser.isAllowed(blockBelow, configValue)) {
                world.setBlockAndUpdate(spawnPos, rule.getValue().get().defaultBlockState());

                if (context.getPlayer() != null && !context.getPlayer().isCreative()) {
                    context.getItemInHand().shrink(1);
                }
                return ActionResultType.SUCCESS;
            }
        }

        return ActionResultType.PASS;
    }
}
