package eu.wxrlds.beetifulgarden.util;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class PlantableOnParser {
    private static final Logger LOGGER = LogManager.getLogger();

    public static List<Block> getBlocksFromConfig(String config) {
        List<Block> blocks = new ArrayList<>();

        // Allow empty list
        if (config == null || config.trim().isEmpty()) {
            return blocks;
        }

        String[] entries = config.split("\\|");
        for (String entry : entries) {
            entry = entry.trim();
            if (entry.isEmpty()) continue;

            ResourceLocation rl = ResourceLocation.tryParse(entry);
            if (rl == null) {
                LOGGER.error("Invalid ResourceLocation in config: {}", entry);
                continue;
            }

            // Check if the block actually exists in the game
            var blockOptional = BuiltInRegistries.BLOCK.getOptional(rl);
            if (blockOptional.isPresent()) {
                blocks.add(blockOptional.get());
            } else {
                LOGGER.warn("Block not found for config entry: {}", entry);
            }
        }
        return blocks;
    }

    public static boolean isAllowed(Block block, String config) {
        List<Block> allowedBlocks = getBlocksFromConfig(config);
        return allowedBlocks.contains(block);
    }
}
