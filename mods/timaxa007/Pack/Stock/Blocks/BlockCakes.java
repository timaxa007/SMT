package mods.timaxa007.Pack.Stock.Blocks;

import java.util.List;
import java.util.Random;

import mods.timaxa007.Pack.Stock.PackInfo;
import mods.timaxa007.Pack.Stock.PackStock;
import mods.timaxa007.Pack.Stock.TE.TECake;
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
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCakes extends BlockContainer {
public static final String[] typeCakes = new String[]{
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

public BlockCakes(int id) {
super(id, Material.cake);
setCreativeTab(PackStock.proxy.tabFoodPack);
setHardness(0.5F);
setResistance(1.0F);
setTickRandomly(true);
setBlockBounds(0.125F, 0.0F, 0.125F, 0.875F, 0.5F, 0.875F);
setTextureName("planks_oak");
setUnlocalizedName("cake");
}

@Override
public TileEntity createNewTileEntity(World world) {return new TECake();}

public int getRenderType() {return PackStock.proxy.render_block_cake_modelID;}
public int quantityDropped(Random radom) {return 0;}
public boolean renderAsNormalBlock() {return false;}
public boolean isOpaqueCube() {return false;}
public int idPicked(World wrd, int x, int y, int z) {return 0;}

public ItemStack getPickBlock(MovingObjectPosition target, World wrd, int x, int y, int z) {
TileEntity te = wrd.getBlockTileEntity(x, y, z);
if ((te != null)&&(te instanceof TECake)) {
return addTag(((TECake)te).getTypes());
}
return addTag(0);
}


public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
this.eatCakeSlice(world, x, y, z, player);
return true;
}

private void eatCakeSlice(World world, int x, int y, int z, EntityPlayer player) {
if (player.canEat(false)) {

TileEntity te = world.getBlockTileEntity(x, y, z);
if (te != null) {
int act = (((TECake)te).getAmount()-1);
((TECake)te).setAmount(act);

if (((TECake)te).getAmount() <= 0) {
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
if (te != null && te instanceof TECake) {

int l = MathHelper.floor_double((double)(el.rotationYaw*4.0F/360.0F)+0.5D)&3;
((TECake)te).setRot(l);;

if (tag != null) {
((TECake)te).setAmount(tag.getInteger("Amount"));
((TECake)te).setTypes(tag.getInteger("Type"));;
} else {
((TECake)te).setAmount(12);
((TECake)te).setTypes(0);
}

}
}

@SideOnly(Side.CLIENT)
public void getSubBlocks(int id, CreativeTabs table, List list) {
for (int j = 0; j < 64; ++j) {
list.add(addTag(j));
}
//list.add(new ItemStack(id, 1, 0));
}

private static ItemStack addTag(int par1) {
ItemStack is = new ItemStack(PackStock.proxy.block_cakes, 1, 0);
NBTTagCompound tag = new NBTTagCompound();
tag.setInteger("Amount", 12);
tag.setInteger("Type", par1);
is.setTagCompound(tag);
return is;
}

@SideOnly(Side.CLIENT)
public void registerIcons(IconRegister ir) {
this.blockIcon = ir.registerIcon("timaxa007:" + "food/" + "cake/" + "cake_top");
}

}
