package com.butteredtoasts.coursemod.datagen;

import com.butteredtoasts.coursemod.CourseMod;
import com.butteredtoasts.coursemod.block.ModBlocks;
import com.butteredtoasts.coursemod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, CourseMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.BLACK_OPAL.get());
        basicItem(ModItems.RAW_BLACK_OPAL.get());
        basicItem(ModItems.CHAINSAW.get());
        basicItem(ModItems.FROSTFIRE_ICE.get());
        basicItem(ModItems.TOMATO.get());

        buttonItem(ModBlocks.BLACK_OPAL_BUTTON, ModBlocks.BLACK_OPAL_BLOCK);

        fenceItem(ModBlocks.BLACK_OPAL_FENCE, ModBlocks.BLACK_OPAL_BLOCK);
        wallItem(ModBlocks.BLACK_OPAL_WALL,ModBlocks.BLACK_OPAL_BLOCK);

        basicItem(ModBlocks.BLACK_OPAL_DOOR.asItem());

        handheldItem(ModItems.BLACK_OPAL_SWORD);
        handheldItem(ModItems.BLACK_OPAL_PICKAXE);
        handheldItem(ModItems.BLACK_OPAL_SHOVEL);
        handheldItem(ModItems.BLACK_OPAL_AXE);
        handheldItem(ModItems.BLACK_OPAL_HOE);

        handheldItem(ModItems.BLACK_OPAL_PAXEL);
        handheldItem(ModItems.BLACK_OPAL_HAMMER);

        basicItem(ModItems.BLACK_OPAL_HELMET.get());
        basicItem(ModItems.BLACK_OPAL_CHESTPLATE.get());
        basicItem(ModItems.BLACK_OPAL_LEGGINGS.get());
        basicItem(ModItems.BLACK_OPAL_BOOTS.get());

        basicItem(ModItems.TOMATO_SEEDS.get());

        flowerItem(ModBlocks.PETUNIA);
    }

    public void flowerItem(DeferredBlock<Block> block) {
        this.withExistingParent(block.getId().getPath(), mcLoc("item/generated"))
                .texture("layer0",  ResourceLocation.fromNamespaceAndPath(CourseMod.MODID,
                        "block/" + block.getId().getPath()));
    }

    public void buttonItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(CourseMod.MODID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void fenceItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(CourseMod.MODID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void wallItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath(CourseMod.MODID,
                        "block/" + baseBlock.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(DeferredItem<Item> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(CourseMod.MODID,"item/" + item.getId().getPath()));
    }
}