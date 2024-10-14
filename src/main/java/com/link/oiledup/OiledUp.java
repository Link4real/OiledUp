package com.link.oiledup;

import com.link.oiledup.item.ModItems;
import com.link.oiledup.block.ModBlocks;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.registry.FuelRegistry;
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
	public static final Logger LOGGER = LoggerFactory.getLogger("Oiled Up");

	public static final ItemGroup OILED_UP_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
			Identifier.of(OiledUp.MOD_ID, "oiled_up_item_group"),
			FabricItemGroup.builder().icon(()-> new ItemStack(ModItems.PLASTIC))
					.displayName(Text.translatable("itemgroup.oiled_up.oiled_up_item_group"))
					.entries((displayContext, entries) -> {
						entries.add(ModItems.PLASTIC);
						entries.add(ModItems.CRUDE_OIL);
						entries.add(ModBlocks.OIL_LAMP);
						entries.add(ModItems.COKE);
						entries.add(ModBlocks.REFINERY);
					}).build());

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		FuelRegistry.INSTANCE.add(ModItems.COKE, 2000);
		LOGGER.info("Oiled Up is loaded");
	}
}