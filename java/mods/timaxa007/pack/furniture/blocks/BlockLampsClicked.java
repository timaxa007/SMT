package mods.timaxa007.pack.furniture.blocks;

import java.util.List;
import java.util.Random;

import mods.timaxa007.lib.GetColors;
import mods.timaxa007.pack.furniture.PackFurniture;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockLampsClicked extends Block{
@SideOnly(Side.CLIENT) private IIcon[] iconArray;
private final String light;

public BlockLampsClicked(boolean par2) {
super(Material.rock);
setStepSound(soundTypeGlass);
setHardness(0.3F);
setResistance(1.0F);
setLightOpacity(5);
if(par2) {
light="on";
setLightLevel(1.0F);
}else{
light="off";
setLightLevel(0.0F);
setCreativeTab(PackFurniture.proxy.tab_furniture_pack);
}
setBlockTextureName("planks_oak");
}

public int quantityDropped(Random rdm) {return 0;}
public boolean isOpaqueCube() {return false;}
public boolean renderAsNormalBlock() {return false;}

@SideOnly(Side.CLIENT)
public void getSubBlocks(Item id, CreativeTabs table, List list) {
for(byte j=0;j<16;++j) {list.add(new ItemStack(id, 1, j));}
}

public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float hitX, float hitY, float hitZ) {
Block blok;
if(this==PackFurniture.proxy.block_lamps_click_on) {
blok=PackFurniture.proxy.block_lamps_click_off;
}else{
blok=PackFurniture.proxy.block_lamps_click_on;
}
for(byte j=0;j<16;++j) {
if(getDamageValue(world, x, y, z)==j) {
world.setBlock(x, y, z, blok, j, 0);
}
}
return true;
}
/*
@Override 
public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int metadata, int fortune) {
ArrayList<ItemStack> ret=super.getBlockDropped(world, x, y, z, metadata, fortune);
ret.add(new ItemStack(PackFurniture.proxy.block_lamps_click_off, 1, metadata));
return ret;
}
*/
/*
@SideOnly(Side.CLIENT)
public IIcon getIcon(int par1, int par2) {
return iconArray[par2 % iconArray.length];
}
*/
@SideOnly(Side.CLIENT)
public void registerBlockIcons(IIconRegister ir) {
iconArray=new IIcon[16];
for(byte i=0;i<iconArray.length;++i) {
iconArray[i]=ir.registerIcon("timaxa007:"+"lamps/lamp_"+GetColors.getNameColors[i]+"_"+light);
}
}

}
