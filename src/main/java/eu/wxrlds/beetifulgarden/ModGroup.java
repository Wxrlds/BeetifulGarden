package eu.wxrlds.beetifulgarden;

import eu.wxrlds.beetifulgarden.item.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModGroup {

    public static final ItemGroup BEETIFULGARDEN_GROUP = new net.minecraft.item.ItemGroup("beetifulgarden") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.BEETIFUL_FRUITS.get(BeetType.VELVET).get());
        }
    };
}
