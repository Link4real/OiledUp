package com.link.oiledup.item.advitems;

import com.link.oiledup.sounds.ModSounds;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.*;
import net.minecraft.world.World;



public class RubberChickenItem extends Item {


    public RubberChickenItem(Settings settings) {
        super(settings);
    }

    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BRUSH;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), ModSounds.RUBBER_CHICKEN_SCREAM, SoundCategory.NEUTRAL, 0.3f, 1f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
        if (!world.isClient) {
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 100, 3));
        }
        user.getItemCooldownManager().set(this, 10);
        return TypedActionResult.success(itemStack, world.isClient());
    }
}
