package com.testmod.mod.Item;

import com.testmod.mod.IntroductionMod;
import com.testmod.mod.block.IntroductionBlocks;
import net.minecraft.client.gui.components.tabs.Tab;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class IntroductionTabs {
    //レジストリを作成
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, IntroductionMod.MODID);

    //レジストリにタブを登録
    //Component.translatable:言語ファイルを使って、タイトル(タブの名前)を設定することを指す) 引数はjsonのキー(タブの名前)
    public static final RegistryObject<CreativeModeTab> INTRODUCTION_TAB = TABS.register("introduction_tab",
            () -> CreativeModeTab.builder().title(Component.translatable("creativetabs.introduction_tab"))
                    .icon(IntroductionItems.RAW_ORIHALCON.get()::getDefaultInstance) //タブのアイコン
                    //タブに追加したいアイテムを入れる
                    .displayItems(((pParameters,pOutput) -> {
                        pOutput.accept(IntroductionItems.RAW_ORIHALCON.get());
                        pOutput.accept(IntroductionItems.FISH_INGOT.get());
                        pOutput.accept(IntroductionBlocks.ORIHALCON_BLOCK.get());
                    }))
                    .build());

    //イベントバスにレジストリを登録する
    public static void register(IEventBus eventBus){
        TABS.register(eventBus);
    }
}
