package mods.timaxa007.pack.furniture.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import mods.timaxa007.lib.GetColors;
import mods.timaxa007.pack.furniture.PackFurniture;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockLampsClicked extends Block{
@SideOnly(Side.CLIENT) private Icon[] iconArray;
private final String light;

public BlockLampsClicked(int id, boolean par2) {
super(id, Material.rock);
setStepSound(soundGlassFootstep);
setHardness(0.3F);
setResistance(1.0F);
setLightOpacity(5);
if(par2) {
light="on";
setLightValue(1.0F);
}else{
light="off";
setLightValue(0.0F);
setCreativeTab(PackFurniture.proxy.tabFurniturePack);
}
setTextureName("planks_oak");
}

public int quantityDropped(Random rdm) {return 0;}
public boolean isOpaqueCube() {return false;}
public boolean renderAsNormalBlock() {return false;}

@SideOnly(Side.CLIENT)
public void getSubBlocks(int id, CreativeTabs table, List list) {
for(byte j=0;j<16;++j) {list.add(new ItemStack(id, 1, j));}
}

public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float hitX, float hitY, float hitZ) {
int blok;
if(blockID==PackFurniture.proxy.block_lamps_click_on.blockID) {
blok=PackFurniture.proxy.block_lamps_click_off.blockID;
}else{
blok=PackFurniture.proxy.block_lamps_click_on.blockID;
}
for(byte j=0;j<16;++j) {
if(getDamageValue(world, x, y, z)==j) {
world.setBlock(x, y, z, blok, j, 0);
}
}
return true;
}

@Override 
public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int metadata, int fortune) {
ArrayList<ItemStack> ret=super.getBlockDropped(world, x, y, z, metadata, fortune);
ret.add(new ItemStack(PackFurniture.proxy.block_lamps_click_off.blockID, 1, metadata));
return ret;
}

@SideOnly(Side.CLIENT)
public Icon getIcon(int par1, int par2) {
return iconArray[par2 % iconArray.length];
}

@SideOnly(Side.CLIENT)
public void registerIcons(IconRegister ir) {
iconArray=new Icon[16];
for(byte i=0;i<iconArray.length;++i) {
iconArray[i]=ir.registerIcon("timaxa007:"+"lamps/lamp_"+GetColors.getNameColors[i]+"_"+light);
}
}

}
