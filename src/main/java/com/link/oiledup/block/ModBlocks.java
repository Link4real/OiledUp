package com.link.oiledup.block;

import com.link.oiledup.OiledUp;
import com.link.oiledup.block.advblocks.OilLampBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.ToIntFunction;

public class ModBlocks {
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(OiledUp.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(OiledUp.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static final Block OIL_LAMP = registerBlock("oil_lamp",
            new OilLampBlock(AbstractBlock.Settings.create().strength(1f).luminance(value -> 15).sounds(BlockSoundGroup.LANTERN)));

    public static final Block REFINERY = registerBlock("refinery",
            new Block(AbstractBlock.Settings.create().strength(1f).sounds(BlockSoundGroup.LODESTONE)));

    public static void registerModBlocks() {
        OiledUp.LOGGER.info("Registering Blocks for " + OiledUp.MOD_ID);
    }
}
