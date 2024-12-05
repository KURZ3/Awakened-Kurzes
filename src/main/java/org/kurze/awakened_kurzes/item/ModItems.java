package org.kurze.awakened_kurzes.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.kurze.awakened_kurzes.Awakened_Kurzes;
import org.kurze.awakened_kurzes.item.custom.ChiselItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Awakened_Kurzes.MODID);
    //-----------------------ITEMS---------------------------------------------------------------------

    public static final RegistryObject<Item> KURZARITE_CLUSTER = ITEMS.register("kurzarite_cluster",
            ()->new Item(new Item.Properties()));


    //-----------------------CUSTOM ITEMS---------------------------------------------------------------------
    public static final RegistryObject<Item> CHISEL = ITEMS.register("chisel",
            () -> new ChiselItem(new Item.Properties().durability(32)));

    //-----------------------EVENT BUS---------------------------------------------------------------------
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
