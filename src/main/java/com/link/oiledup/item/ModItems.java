package com.link.oiledup.item;
import com.link.oiledup.OiledUp;
import com.link.oiledup.item.advitems.DetectorItem;
import com.link.oiledup.item.advitems.RubberChickenItem;
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
    public static final Item COKE = registerItem("coke", new Item(new Item.Settings()));
    public static final Item DETECTOR = registerItem("detector", new DetectorItem(new Item.Settings().maxCount(1)));
    public static final Item RUBBER_CHICKEN = registerItem("rubber_chicken", new RubberChickenItem(new Item.Settings().maxCount(1)));


    public static void registerModItems() {
        OiledUp.LOGGER.info("Registering Items for " + OiledUp.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(PLASTIC);
            entries.add(CRUDE_OIL);
            entries.add(COKE);
        });
    }
}