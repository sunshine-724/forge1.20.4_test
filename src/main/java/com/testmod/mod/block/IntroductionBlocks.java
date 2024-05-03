package com.testmod.mod.block;

import com.testmod.mod.IntroductionMod;
import com.testmod.mod.Item.IntroductionItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class IntroductionBlocks {
    //ブロック用のレジストリを作成
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, IntroductionMod.MODID);

    //オリハルコンブロックをレジストリに登録
    //インスタンスのコンストラクタの説明
    /*チェインメソッド:同じクラスのメソッドを連続して宣言することにより、順番にインスタンスメソッドを使う事ができる
      ex. new Block(BlockBehaviour.Properties.ofLegacyCopy(Blocks.DIAMOND_BLOCK).sound(SoundType.ANVIL)))
      これはBlockBehaviour.Properties.ofLegacyCopy(Blocks.DIAMOND_BLOCK)メソッドを使ったあと、
      BlockBehaviour.Properties.sound(SoundType.ANVIL))を使ってコンストラクタに返り値を渡している
      チェインメソッドに他のクラスのメソッドを使いたい場合、他のクラスのインスタンスを同じクラスに渡すメソッドを宣言し、インスタンスメソッドを介して使う*/
    //BlockBehaviour.Properties.ofLegacyCopy(Blocks.DIAMOND_BLOCK):ダイヤモンドブロックの設定をコピーする(ダイヤモンドブロックと同じ性質のインスタンスを生成)
    //BlockBehaviour.Properties.sound(SoundType.ANVIL)):ブロックを設置する音をSoundTypeフィールドを使って変える。ANVILは金床

    //ブロックオブジェクトをレジストリに登録
    public static final RegistryObject<Block> ORIHALCON_BLOCK = registerBlockItem("orihalcon_block",
            () -> new Block(BlockBehaviour.Properties.ofLegacyCopy(Blocks.DIAMOND_BLOCK).sound(SoundType.ANVIL)));

    //BlockItem:BlockクラスとItemクラスとの橋渡し役(BlockItem自体はBlockクラスの子クラス)
    //Block.regigerメソッドにある機能に少し付け足すためのメソッド
    private static  <T extends Block> RegistryObject<T> registerBlockItem(String name, Supplier<T> supplier){

        //ブロックオブジェクトをレジストリに登録
        RegistryObject<T> block = BLOCKS.register(name,supplier);

        //アイテムとしてブロックオブジェクトをレジストリに登録(これによってコマンドでブロックとして設置することしかできなかったのが、アイテムとして呼び出す事ができる)
        //具体的にはsetblockコマンドでしか呼び出せなかったものを、giveコマンドで呼び出す事ができる
        //IntroductionItemsクラスでいうITEMS.registerメソッドと同義
        IntroductionItems.ITEMS.register(name,() -> new BlockItem(block.get(),new Item.Properties()));

        return block;
    }


    //レジストリをイベントバスに登録
    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
