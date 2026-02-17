package eu.wxrlds.beetifulgarden;

import eu.wxrlds.beetifulgarden.item.ModItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModGroup {

    public static final CreativeModeTab BEETIFULGARDEN_GROUP = new CreativeModeTab("beetifulgarden") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.BEETIFUL_FRUITS.get(BeetType.VELVET).get());
        }
    };
}
