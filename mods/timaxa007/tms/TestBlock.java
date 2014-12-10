package mods.timaxa007.tms;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class TestBlock extends Block {

public TestBlock() {
super(Material.iron);
this.setStepSound(soundTypeWood);
this.setCreativeTab(Core.tabTMS);
this.setHardness(0.1F);
this.setResistance(10.0F);
this.setLightValue(0.0F);
this.setLightOpacity(1);
this.setTextureName("timaxa007:" + "testBlock");
this.setUnlocalizedName("block_test");
}

}
