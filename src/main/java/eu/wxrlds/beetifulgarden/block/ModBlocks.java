package eu.wxrlds.beetifulgarden.block;

import eu.wxrlds.beetifulgarden.BeetType;
import eu.wxrlds.beetifulgarden.BeetifulGarden;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.EnumMap;
import java.util.Map;

@Mod.EventBusSubscriber(modid = BeetifulGarden.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, BeetifulGarden.MOD_ID);

    public static final Map<BeetType, RegistryObject<Block>> CROP_BLOCKS = new EnumMap<>(BeetType.class);

    public static void registerBlocks() {
        for (BeetType type : BeetType.values()) {
            CROP_BLOCKS.put(type, BLOCKS.register(type.getName() + "_crop",
                    () -> new BeetifulCropBlock(
                            BlockBehaviour.Properties.copy(Blocks.BEETROOTS), type)));
        }
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
