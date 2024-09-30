package com.butteredtoasts.coursemod.item;

import com.butteredtoasts.coursemod.CourseMod;
import com.butteredtoasts.coursemod.item.custom.ChainsawItem;
import com.butteredtoasts.coursemod.item.custom.FuelItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CourseMod.MODID);

    public static final DeferredItem<Item> BLACK_OPAL = ITEMS.registerSimpleItem("black_opal");
    public static final DeferredItem<Item> RAW_BLACK_OPAL =
            ITEMS.registerItem("raw_black_opal", Item::new, new Item.Properties());

    public static final DeferredItem<Item> CHAINSAW =
            ITEMS.register("chainsaw", () -> new ChainsawItem(new Item.Properties().durability(32)));

    public static final DeferredItem<Item> TOMATO =
            ITEMS.register("tomato", () -> new Item(new Item.Properties().food(ModFoodProperties.TOMATO)) {
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.coursemod.tomato.1"));

                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    public static final DeferredItem<Item> FROSTFIRE_ICE =
            ITEMS.register("frostfire_ice", () -> new FuelItem(new Item.Properties(),600));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}