package mods.timaxa007.Pack.Stock.Blocks;

import java.util.List;

import mods.timaxa007.Pack.Stock.PackStock;
import mods.timaxa007.Pack.Stock.TE.TEPie;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockPies extends BlockContainer{
public static final String[] typePies = new String[]{
"Standard", 
"Fruity", 
"Berry", 
"Vegetable", 
"Meat", 
"6", 
"7", 
"8", 
"9", 
"10", 
"11", 
"12", 
"13", 
"14", 
"15", 
"Chocolate"
};

public BlockPies(int id) {
super(id, Material.rock);
setCreativeTab(PackStock.proxy.tabFoodPack);
setHardness(0.5F);
setResistance(1.0F);
setTickRandomly(true);
setBlockBounds(0.1875F, 0.0F, 0.1875F, 0.8125F, 0.1875F, 0.8125F);
setTextureName("planks_oak");
setUnlocalizedName("pie");
}

@Override
public TileEntity createNewTileEntity(World wrd) {return new TEPie();}

public int getRenderType() {return PackStock.proxy.render_block_pie_modelID;}
public boolean renderAsNormalBlock() {return false;}
public boolean isOpaqueCube() {return false;}

public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float hitX, float hitY, float hitZ) {
eatCakeSlice(world, x, y, z, player);
return true;
}

private void eatCakeSlice(World world, int x, int y, int z, EntityPlayer player) {
if (player.canEat(false)) {

TileEntity te = world.getBlockTileEntity(x, y, z);
if (te != null) {
int act = (((TEPie)te).getAmount()-1);
((TEPie)te).setAmount(act);

if (((TEPie)te).getAmount() <= 0) {
world.setBlockToAir(x, y, z);
world.removeBlockTileEntity(x, y, z);
}

}

}
}

@Override
public void onBlockPlacedBy(World wrd, int x, int y, int z, EntityLivingBase el, ItemStack is) {
TileEntity te = wrd.getBlockTileEntity(x, y, z);
NBTTagCompound tag = is.getTagCompound();
if (te != null && te instanceof TEPie) {

int l = MathHelper.floor_double((double)(el.rotationYaw*4.0F/360.0F)+0.5D)&3;
((TEPie)te).setRot(l);;

if (tag != null) {
((TEPie)te).setAmount(tag.getInteger("Amount"));;
((TEPie)te).setTypes(tag.getInteger("Type"));;
}else{
((TEPie)te).setAmount(4);
((TEPie)te).setTypes(0);
}

}
}

@SideOnly(Side.CLIENT)
public void getSubBlocks(int id, CreativeTabs table, List list) {
for(byte j = 0;j<16;++j) {list.add(addTag(j));}
list.add(new ItemStack(id, 1, 0));
}

private static ItemStack addTag(int par1) {
ItemStack is = new ItemStack(PackStock.proxy.block_pies, 1, par1);
NBTTagCompound tag = new NBTTagCompound();
tag.setInteger("Amount", 4);
tag.setInteger("Type", par1);
is.setTagCompound(tag);
return is;
}

@SideOnly(Side.CLIENT)
public void registerIcons(IconRegister ir) {
blockIcon = ir.registerIcon("timaxa007:"+"food/"+"cake/"+"cake_top");
}

}
