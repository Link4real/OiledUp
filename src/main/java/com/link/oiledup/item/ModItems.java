package com.link.oiledup.item;
import com.link.oiledup.OiledUp;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
public class ModItems {

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(OiledUp.MOD_ID, name), item);
    }


    public static final Item PLASTIC = registerItem("plastic", new Item(new Item.Settings()));
    public static final Item CRUDE_OIL = registerItem("crude_oil", new Item(new Item.Settings()));


    public static void registerModItems() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(PLASTIC);
            entries.add(CRUDE_OIL);
        });
    }
}