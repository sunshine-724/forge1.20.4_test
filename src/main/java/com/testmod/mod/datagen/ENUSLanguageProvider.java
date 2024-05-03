package com.testmod.mod.datagen;

import com.testmod.mod.IntroductionMod;
import com.testmod.mod.Item.IntroductionItems;
import com.testmod.mod.block.IntroductionBlocks;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.Locale;

public class ENUSLanguageProvider extends LanguageProvider {


    public ENUSLanguageProvider(PackOutput output) {
        super(output, IntroductionMod.MODID, Locale.US.toString().toLowerCase());
    }

    @Override
    protected void addTranslations() {
        //書式 1:アイテムの変数 2:アイテムの名前
        addItem(IntroductionItems.RAW_ORIHALCON,"Raw Orihalcon");
        addItem(IntroductionItems.FISH_INGOT,"Fish Ingot");

        add("creativetabs.introduction_tab","Introduction"); //1:jsonのキー 2:jsonの値

        addBlock(IntroductionBlocks.ORIHALCON_BLOCK,"Orihalcon Block");
    }
}
