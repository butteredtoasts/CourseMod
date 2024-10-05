package com.butteredtoasts.coursemod.item.custom;

import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class ModEffectSwordItem extends SwordItem {
    private final Holder<MobEffect> effect;

    public ModEffectSwordItem(Tier p_tier, Properties p_properties, Holder<MobEffect> effect) {
        super(p_tier, p_properties);
        this.effect = effect;
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        if(entity instanceof LivingEntity livingEntity) {
            livingEntity.addEffect(new MobEffectInstance(effect, 200), player);
        }

        return super.onLeftClickEntity(stack, player, entity);
    }
}