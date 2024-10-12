package com.oily;

import com.oily.block.ModBlocks;
import com.oily.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OiledUp implements ModInitializer {
	public static final String MOD_ID = "oiled_up";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final ItemGroup OILED_UP_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
			Identifier.of(OiledUp.MOD_ID, "oiled_up_item_group"),
			FabricItemGroup.builder().icon(()-> new ItemStack(ModItems.PLASTIC))
					.displayName(Text.translatable("itemgroup.oiled_up.oiled_up_item_group"))
					.entries((displayContext, entries) -> {
						entries.add(ModItems.PLASTIC);
						entries.add(ModItems.CRUDE_OIL);
						entries.add(ModBlocks.OIL_LAMP);
					}).build());

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		LOGGER.info("hello");
	}
}