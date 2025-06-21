package eu.wxrlds.beetifulgarden.item;

import eu.wxrlds.beetifulgarden.config.BeetifulGardenCommonConfigs;
import eu.wxrlds.beetifulgarden.util.Tooltips;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.Optional;

public class Beetzza extends Item {
    public Beetzza(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if (!BeetifulGardenCommonConfigs.BEETZZA_NEGATES_EFFECT.get().isEmpty()) {
            tooltipComponents.add(Component.translatable("tooltip.beetifulgarden.beetzza_negates_alt").withStyle(ChatFormatting.GRAY));
            Tooltips.addCuresTooltip(tooltipComponents);
        }
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level world, Entity entity, int slot, boolean selected) {
        if (!BeetifulGardenCommonConfigs.BEETZZA_NEGATES_EFFECT.get().isEmpty() && !world.isClientSide && entity instanceof Player player) {
            String[] effectStrings = BeetifulGardenCommonConfigs.BEETZZA_NEGATES_EFFECT.get().split("\\|");
            for (String effectString : effectStrings) {
                ResourceLocation id = ResourceLocation.parse(effectString);
                ResourceKey<MobEffect> key = ResourceKey.create(Registries.MOB_EFFECT, id);
                Optional<? extends Holder<MobEffect>> holder = BuiltInRegistries.MOB_EFFECT.getHolder(key);

                holder.ifPresent(player::removeEffect);
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }
}
