package org.kurze.awakened_kurzes.item;

import org.kurze.awakened_kurzes.Awakened_Kurzes;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.kurze.awakened_kurzes.block.ModBlocks;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab>CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Awakened_Kurzes.MODID);

//------------------------------------------------KURZARITE TAB------------------------------------------
    public static final RegistryObject<CreativeModeTab> KURZARITE_MOD_TAB = CREATIVE_MODE_TABS.register("kurzarite_mod_tab",
            ()-> CreativeModeTab.builder().icon(()->new ItemStack(ModItems.KURZARITE_CLUSTER.get()))
                    .title(Component.translatable("creativetab.awakened_kurzes.kurzarite"))
                    .displayItems((itemDisplayParameters, output) -> { //Aqui se meten los items
                        //Items-------------------
                        output.accept(ModItems.KURZARITE_CLUSTER.get());
                        //Custom Items------------
                        output.accept(ModItems.CHISEL.get());
                        //Custom Blocks------------
                        output.accept(ModBlocks.KURZARITE_ORE.get());
                        output.accept(ModBlocks.KURZARITE_DEEPSLATEORE.get());
                        output.accept(ModBlocks.KURZARITE_BLOCK.get());
                    })
                    .build());

//------------------------------------------------EVENT BUS------------------------------------------
    public static void register (IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
