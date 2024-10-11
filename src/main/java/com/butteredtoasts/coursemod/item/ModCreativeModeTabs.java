package com.butteredtoasts.coursemod.item;

import com.butteredtoasts.coursemod.CourseMod;
import com.butteredtoasts.coursemod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CourseMod.MODID);

    public static final Supplier<CreativeModeTab> BLACK_OPAL_ITEMS_TAB =
            CREATIVE_MODE_TABS.register("black_opal_item_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.coursemod.black_opal_item_tab"))
                    .icon(() -> new ItemStack(ModItems.BLACK_OPAL.get()))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.BLACK_OPAL);
                        output.accept(ModItems.RAW_BLACK_OPAL);

                        output.accept(ModItems.CHAINSAW);

                        output.accept(ModItems.TOMATO);

                        output.accept(ModItems.FROSTFIRE_ICE);

                        output.accept(ModItems.BLACK_OPAL_SWORD);
                        output.accept(ModItems.BLACK_OPAL_PICKAXE);
                        output.accept(ModItems.BLACK_OPAL_SHOVEL);
                        output.accept(ModItems.BLACK_OPAL_AXE);
                        output.accept(ModItems.BLACK_OPAL_HOE);

                        output.accept(ModItems.BLACK_OPAL_PAXEL);
                        output.accept(ModItems.BLACK_OPAL_HAMMER);

                        output.accept(ModItems.BLACK_OPAL_HELMET);
                        output.accept(ModItems.BLACK_OPAL_CHESTPLATE);
                        output.accept(ModItems.BLACK_OPAL_LEGGINGS);
                        output.accept(ModItems.BLACK_OPAL_BOOTS);

                        output.accept(ModItems.TOMATO_SEEDS);
                        output.accept(ModBlocks.PETUNIA);
                    }).build());

    public static final Supplier<CreativeModeTab> BLACK_OPAL_BLOCKS_TAB =
            CREATIVE_MODE_TABS.register("black_opal_blocks_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.coursemod.black_opal_blocks_tab"))
                    .icon(() -> new ItemStack(ModBlocks.BLACK_OPAL_BLOCK.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(CourseMod.MODID, "black_opal_item_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.BLACK_OPAL_BLOCK);
                        output.accept(ModBlocks.RAW_BLACK_OPAL_BLOCK);

                        output.accept(ModBlocks.BLACK_OPAL_ORE);
                        output.accept(ModBlocks.BLACK_OPAL_DEEPSLATE_ORE);
                        output.accept(ModBlocks.BLACK_OPAL_END_ORE);
                        output.accept(ModBlocks.BLACK_OPAL_NETHER_ORE);

                        output.accept(ModBlocks.MAGIC_BLOCK);

                        output.accept(ModBlocks.BLACK_OPAL_STAIRS);
                        output.accept(ModBlocks.BLACK_OPAL_SLAB);

                        output.accept(ModBlocks.BLACK_OPAL_BUTTON);
                        output.accept(ModBlocks.BLACK_OPAL_PRESSURE_PLATE);

                        output.accept(ModBlocks.BLACK_OPAL_FENCE);
                        output.accept(ModBlocks.BLACK_OPAL_FENCE_GATE);
                        output.accept(ModBlocks.BLACK_OPAL_WALL);

                        output.accept(ModBlocks.BLACK_OPAL_DOOR);
                        output.accept(ModBlocks.BLACK_OPAL_TRAPDOOR);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}