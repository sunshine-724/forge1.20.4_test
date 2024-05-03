package com.testmod.mod.Item;

import com.testmod.mod.IntroductionMod;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

public class IntroductionItems {
    //レジストリを作成
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,IntroductionMod.MODID);

    //レジストリにアイテムを追加(string,Itemのインスタンスを生成して格納)
    public static final RegistryObject<Item> RAW_ORIHALCON = ITEMS.register("raw_orihalcon",() -> new Item(new Item.Properties()));

    //アイテム追加
    public static final RegistryObject<Item> FISH_INGOT = ITEMS.register("fish_ingot",() -> new Item(new Item.Properties()));


    //自作静的メソッド
    public static void register(IEventBus eventBus){
        //レジストリをイベントバスに登録
        ITEMS.register(eventBus);
    }
}
