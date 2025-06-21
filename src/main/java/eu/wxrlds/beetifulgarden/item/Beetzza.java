package eu.wxrlds.beetifulgarden.item;

import eu.wxrlds.beetifulgarden.config.BeetifulGardenCommonConfigs;
import eu.wxrlds.beetifulgarden.util.Tooltips;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.List;

public class Beetzza extends Item {
    public Beetzza(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        if (!BeetifulGardenCommonConfigs.BEETZZA_NEGATES_EFFECT.get().isEmpty()) {
            tooltip.add(Component.translatable("tooltip.beetifulgarden.beetzza_negates_alt").withStyle(ChatFormatting.GRAY));
            Tooltips.addCuresTooltip(tooltip);
        }
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level world, Entity entity, int slot, boolean selected) {
        if (!BeetifulGardenCommonConfigs.BEETZZA_NEGATES_EFFECT.get().isEmpty())
            if (!world.isClientSide) {
                if (entity instanceof Player) {
                    String[] effectStrings = BeetifulGardenCommonConfigs.BEETZZA_NEGATES_EFFECT.get().split("\\|");
                    MobEffectInstance[] effects = new MobEffectInstance[effectStrings.length];
                    for (int i = 0; i < effectStrings.length; i++) {
                        String[] parts = effectStrings[i].split(":");
                        String modID = parts[0];
                        String effectID = parts[1];
                        effects[i] = new MobEffectInstance(ForgeRegistries.MOB_EFFECTS.getValue(new ResourceLocation(modID, effectID)));

                        Player player = (Player) entity;
                        player.removeEffect(effects[i].getEffect());
                    }
                }
            }
        super.inventoryTick(stack, world, entity, slot, selected);
    }
}
