package com.testmod.mod.datagen;

import com.testmod.mod.IntroductionMod;
import com.testmod.mod.block.IntroductionBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

/*BlockStateをjson形式に自動生成するクラス*/
public class IntroductionBlockStateProvider extends BlockStateProvider {

    //BlockStateProviderクラスが抽象クラスなのでインスタンスメソッドを使う時、子クラスでコンストラクタを定義しないといけない
    public IntroductionBlockStateProvider(PackOutput output,ExistingFileHelper exFileHelper) {
        super(output, IntroductionMod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlockWithItem(IntroductionBlocks.ORIHALCON_BLOCK);
    }

    //BlockStateProvider.javaのsimpleBlockWithItemメソッドに追加機能を加える
    //ConfiguredModel...models:"..."は可変長引数といい同じ方の複数の引数を受け取る事ができる
    //ex.private void simpleBlockWithItem(Block block, ConfiguredModel...models)と定義する時
    //ex.simpleBlockWithItem(Block value1,ConfiguredModel value2,ConfiguredModel value3);と宣言できる

    private void simpleBlockWithItem(RegistryObject<Block> block){
        //BlockStateProvider.javaのメソッド
        simpleBlockWithItem(block.get(),cubeAll(block.get()));
    }
}
