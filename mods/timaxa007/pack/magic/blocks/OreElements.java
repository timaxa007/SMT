package mods.timaxa007.pack.magic.blocks;

import java.util.List;
import java.util.Random;

import mods.timaxa007.pack.magic.PackMagic;
import mods.timaxa007.pack.magic.items.ShardElements;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class OreElements extends Block{
public static final String[] elementsNames=new String[]{
"Air", 
"Earth", 
"Fire", 
"Water", 
"Sound", 
"6", 
"Lightning", 
"Liquid", 
"Flame", 
"10", 
"11", 
"12", 
"13", 
"14", 
"15", 
"16"
};
@SideOnly(Side.CLIENT) private IIcon[] iconArray;

public OreElements() {
super(PackMagic.proxy.oreMagic);
setCreativeTab(PackMagic.proxy.tabMagicPack);
setHardness(0.5F);
setResistance(0.1F);
setBlockTextureName("planks_oak");
setBlockName("magic.ore.elements");
}

@SideOnly(Side.CLIENT)
public IIcon getIcon(int par1, int par2) {return iconArray[par2%iconArray.length];}

public int quantityDropped(Random rdm) {return 0;}
public int idDropped(int par1, Random rdm, int par3) {return par1;}
public int damageDropped(int par1) {return par1;}

@SideOnly(Side.CLIENT)
public void getSubBlocks(Item id, CreativeTabs table, List list) {
for(byte j=0;j<16;++j) {list.add(new ItemStack(id, 1, j));}
}

private Item getItem() {return PackMagic.proxy.shardElements;}
private Block getBlock() {return PackMagic.proxy.oreElements;}
/*
@Override 
public ArrayList<ItemStack> getBlockDropped(World wrd, int x, int y, int z, int meta, int fortune) {
ArrayList<ItemStack> ret=super.getBlockDropped(wrd, x, y, z, meta, fortune);
if(fortune!=0) {
if(fortune==1) {
ret.add(new ItemStack(Item.flint, wrd.rand.nextInt(1), 0));
}else if(fortune==2) {
ret.add(new ItemStack(Block.cobblestone, 1, 0));
}else if(fortune==3) {
ret.add(new ItemStack(Block.stone, 1, 0));
}else{
ret.add(new ItemStack(getBlock(), fortune-3, meta));
}
ret.add(new ItemStack(getItem(), fortune+1, meta));
}else{
ret.add(new ItemStack(getItem(), 1, meta));
//ret.add(new ItemStack(getBlock(), 1, metadata));
}
return ret;
}
*/
@SideOnly(Side.CLIENT)
public void registerIcons(IIconRegister ir) {
iconArray=new IIcon[16];
for(byte i=0;i<iconArray.length;++i) {
iconArray[i]=ir.registerIcon("timaxa007:"+"ore/"+"oreElement"+ShardElements.shaedNames[i]);
}
}

}
