package eu.wxrlds.beetifulgarden.block;

import eu.wxrlds.beetifulgarden.BeetType;
import eu.wxrlds.beetifulgarden.BeetifulGarden;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.EnumMap;
import java.util.Map;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(BeetifulGarden.MOD_ID);

    public static final Map<BeetType, DeferredBlock<Block>> CROP_BLOCKS = new EnumMap<>(BeetType.class);

    public static void register() {
        for (BeetType type : BeetType.values()) {
            CROP_BLOCKS.put(type, BLOCKS.register(type.getName() + "_crop",
                    () -> new BeetifulCropBlock(
                            BlockBehaviour.Properties.ofFullCopy(Blocks.BEETROOTS), type)));
        }
    }
}
