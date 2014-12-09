package mods.timaxa007.Pack.Magic.Blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import mods.timaxa007.Lib.GetColors;
import mods.timaxa007.Pack.Magic.PackInfo;
import mods.timaxa007.Pack.Magic.PackMagic;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSlims extends BlockContainer{
@SideOnly(Side.CLIENT)
private Icon[] iconArray;

public BlockSlims(int id) {
super(id, Material.wood);
setCreativeTab(PackMagic.proxy.tabMagicPack);
setTextureName("planks_oak");
setUnlocalizedName("magic.slims");
}

@SideOnly(Side.CLIENT)
public Icon getIcon(int par1, int par2) {return iconArray[par2 % iconArray.length];}

@Override
public TileEntity createNewTileEntity(World wrd) {return new TESlims();}

@SideOnly(Side.CLIENT)
public void getSubBlocks(int id, CreativeTabs table, List list) {
for(byte j=0;j<16;++j) {list.add(new ItemStack(id, 1, j));}
}
/*
@SideOnly(Side.CLIENT)
public void registerIcons(IconRegister ir) {
iconArray=new Icon[16];
for(byte i=0;i<iconArray.length;++i) {
iconArray[i]=ir.registerIcon("timaxa007:"+"blockSlims/"+"blockSlims"+GetColors.getNameColors[i]);
}
}
*/
}
