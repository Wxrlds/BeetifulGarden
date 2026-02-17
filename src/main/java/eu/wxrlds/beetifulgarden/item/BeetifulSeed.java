package eu.wxrlds.beetifulgarden.item;

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
    public InteractionResult useOn(UseOnContext context) {
        Level world = context.getLevel();
        BlockPos clickPos = context.getClickedPos();
        BlockPos spawnPos = clickPos.above();
        Block blockBelow = world.getBlockState(clickPos).getBlock();

        // Check if we can actually place something in the spot above
        if (!world.getBlockState(spawnPos).getMaterial().isReplaceable()) {
            return InteractionResult.PASS;
        }

        // Loop through the rules to see if the block clicked is valid for any crop
        for (Map.Entry<Supplier<String>, RegistryObject<Block>> rule : PLANTING_RULES.entrySet()) {
            if (PlantableOnParser.isAllowed(blockBelow, rule.getKey().get())) {
                world.setBlockAndUpdate(spawnPos, rule.getValue().get().defaultBlockState());

                if (context.getPlayer() != null && !context.getPlayer().isCreative()) {
                    context.getItemInHand().shrink(1);
                }
                return InteractionResult.SUCCESS;
            }
        }

        return InteractionResult.PASS;
    }
}
