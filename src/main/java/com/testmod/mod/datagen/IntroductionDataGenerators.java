package com.testmod.mod.datagen;

import com.testmod.mod.IntroductionMod;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/*IntroductionItemModelProviderの機能をここで実装する*/
/*Textureさえあればコードを書くと、jsonファイルを書かなくとも自動で生成してくれるようにする*/

@Mod.EventBusSubscriber(modid = IntroductionMod.MODID,bus = Mod.EventBusSubscriber.Bus.MOD)
public class IntroductionDataGenerators {

    //@SubscribeEvent:アノテーション
    //上の@Mod.EventBusSubscriberと合わせることで
    //GatherDataEventが走った時にこのメソッドを実行する。と指示できる
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){
        DataGenerator generator = event.getGenerator();

        //この二つはIntroductionItemModelProviderクラスのインスタンスを作成するために必要
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        //IntroductionItemModelProviderクラスのインスタンスを生成し、generatorに登録
        //gradleでビルドするとsrc/generated/resourcesの所にモデルを生成してくれる
        generator.addProvider(event.includeClient(),new IntroductionItemModelProvider(packOutput,existingFileHelper)); //modelのjsonファイルを作成
        generator.addProvider(event.includeClient(),new IntroductionBlockStateProvider(packOutput,existingFileHelper)); //blockStatesのjsonファイルを作成

        //langのjsonファイルを作成
        generator.addProvider(event.includeClient(),new ENUSLanguageProvider(packOutput));
        generator.addProvider(event.includeClient(),new JAJPLanguageProvider(packOutput));

    }
}
