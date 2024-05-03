package com.testmod.mod.datagen;

import com.testmod.mod.IntroductionMod;
import com.testmod.mod.Item.IntroductionItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

/*Itemをjson形式に自動生成するクラス*/
public class IntroductionItemModelProvider extends ItemModelProvider {

    //ItemModelProviderを継承する時にはコンストラクタが必要
    //ItemModelProviderクラスが抽象クラスなのでインスタンスメソッドを使う時、子クラスでコンストラクタを定義しないといけない
    public IntroductionItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, IntroductionMod.MODID, existingFileHelper);
    }

    //ItemModelProviderを継承する時に必要なメソッド
    @Override
    protected void registerModels() {
        basicItem(IntroductionItems.RAW_ORIHALCON.get());
        basicItem(IntroductionItems.FISH_INGOT.get());
    }
}
