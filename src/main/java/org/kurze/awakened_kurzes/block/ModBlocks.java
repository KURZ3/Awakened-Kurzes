package org.kurze.awakened_kurzes.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.kurze.awakened_kurzes.Awakened_Kurzes;
import org.kurze.awakened_kurzes.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Awakened_Kurzes.MODID);
    //-----------------------BLOCKS---------------------------------------------------------------------

    public static final RegistryObject<Block> KURZARITE_ORE = registerBlock("kurzarite_ore",
            ()-> new DropExperienceBlock(UniformInt.of(2, 4), BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST_CLUSTER)));

    public static final RegistryObject<Block> KURZARITE_DEEPSLATEORE = registerBlock("kurzarite_deepslateore",
            ()-> new DropExperienceBlock(UniformInt.of(4, 8), BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST_CLUSTER)));

    public static final RegistryObject<Block> KURZARITE_BLOCK = registerBlock("kurzarite_block",
            ()-> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST_CLUSTER)));

    /*public static final RegistryObject<Block> KURZARITE_ORE = registerBlock("kurzarite_ore",
            ()-> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST_CLUSTER)));
    */
    //-----------------------REGISTROS EXTRAÑOS DE BLOQUE E ITEM---------------------------------------------------------------------

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block){
        ModItems.ITEMS.register(name, ()-> new BlockItem(block.get(), new Item.Properties()));

    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    //-----------------------EVENT BUS---------------------------------------------------------------------
    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
