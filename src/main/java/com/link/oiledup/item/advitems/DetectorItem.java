package com.link.oiledup.item.advitems;

import com.link.oiledup.sounds.ModSounds;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class DetectorItem extends Item {
    public DetectorItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), ModSounds.DETECTOR_PING, SoundCategory.NEUTRAL, 1f, 1f);
        user.getItemCooldownManager().set(this, 100);
        return TypedActionResult.success(itemStack, world.isClient());
    }
}
