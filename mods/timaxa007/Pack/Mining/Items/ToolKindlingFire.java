package mods.timaxa007.Pack.Mining.Items;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ToolKindlingFire extends Item{

public ToolKindlingFire(int id) {
super(id);
this.maxStackSize = 1;
this.setMaxDamage(64);
this.setCreativeTab(CreativeTabs.tabTools);
this.setUnlocalizedName("tool.kindlingFire");
}

public boolean onItemUse(ItemStack is, EntityPlayer player, World wrd, int x, int y, int z, int meta, float hitX, float hitY, float hitZ) {
if(meta==0) {--y;}
if(meta==1) {++y;}
if(meta==2) {--z;}
if(meta==3) {++z;}
if(meta==4) {--x;}
if(meta==5) {++x;}

if(!player.canPlayerEdit(x, y, z, meta, is)) {return false;}
else{
int i1=wrd.getBlockId(x, y, z);

if(i1==0) {
wrd.playSoundEffect((double)x+0.5D, (double)y+0.5D, (double)z+0.5D, "fire.ignite", 1.0F, itemRand.nextFloat()*0.4F+0.8F);
wrd.setBlock(x, y, z, Block.fire.blockID);
}

/*
ItemStack isitem=new ItemStack(Item.book, 1, 0);
EntityItem entityitem=new EntityItem(wrd, (double)x+0.5D, (double)y+0.5D, (double)z+0.5D, isitem);
if(entityitem instanceof EntityItem) {

}
*/

is.damageItem(1, player);
return true;
}
}

}
