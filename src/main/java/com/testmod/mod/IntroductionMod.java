package com.testmod.mod;

import com.mojang.logging.LogUtils;
import com.testmod.mod.Item.IntroductionItems;
import com.testmod.mod.Item.IntroductionTabs;
import com.testmod.mod.block.IntroductionBlocks;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(IntroductionMod.MODID)
public class IntroductionMod {
    public static final String MODID = "kazuki724";
    private static final Logger LOGGER = LogUtils.getLogger();


    /*モッドが起動した時にこのメソッドを起動するにする*/
    public IntroductionMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);

        //アイテムレジストリをイベントバスに登録
        IntroductionItems.register(modEventBus);

        //ブロックレジストリをイベントバスに登録
        IntroductionBlocks.register(modEventBus);

        //クリエイティブタブレジストリをイベントバスに登録
        IntroductionTabs.register(modEventBus);

        /*このメソッドにより今後このクラスがイベントハンドラとして扱われるようになる(何かしらプレイヤー側でアクションした際にこのクラスのメソッドが起動するようになる)*/
        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    //これはクリエイティブタブを開いた時に何か追加の機能を書くメソッド
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        //もし開かれたクリエイティブタブが材料(ingredients)の所なら
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS){
            //自作アイテムをタブに追加する
            event.accept(IntroductionItems.RAW_ORIHALCON);
        }else if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS){
            //もし開かれたタブが建築ブロック(buildingBlock)なら
            //自作アイテムをタブに追加する
            event.accept(IntroductionItems.FISH_INGOT);
            event.accept((IntroductionBlocks.ORIHALCON_BLOCK));
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
