package com.butteredtoasts.coursemod.item;

import com.butteredtoasts.coursemod.CourseMod;
import com.butteredtoasts.coursemod.item.custom.ChainsawItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CourseMod.MODID);

    public static final DeferredItem<Item> BLACK_OPAL = ITEMS.registerSimpleItem("black_opal");
    public static final DeferredItem<Item> RAW_BLACK_OPAL =
            ITEMS.registerItem("raw_black_opal", Item::new, new Item.Properties());

    public static final DeferredItem<Item> CHAINSAW =
            ITEMS.register("chainsaw", () -> new ChainsawItem(new Item.Properties().durability(32)));

    public static final DeferredItem<Item> TOMATO =
            ITEMS.register("tomato", () -> new Item(new Item.Properties().food(ModFoodProperties.TOMATO)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}