package mods.timaxa007.pack.stock.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import mods.timaxa007.pack.stock.PackStock;
import mods.timaxa007.pack.stock.te.TEHealing;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockHealing extends BlockContainer {

@SideOnly(Side.CLIENT) private Icon[] iconArray;

public static final String[] healingTypes = new String[] {
"healing1", 
"healing2", 
"healing3", 
"healing4", 
"healing5", 
"healing6", 
"healing7", 
"healing8", 
"healing9", 
"healing10", 
"healing11", 
"healing12", 
"healing13", 
"healing14", 
"healing15", 
"healing16"
};

public BlockHealing(int id) {
super(id, Material.wood);
setCreativeTab(PackStock.proxy.tabMedicalPack);
setStepSound(soundWoodFootstep);
setHardness(0.1F);
setResistance(0.01F);
setTextureName("planks_oak");
setUnlocalizedName("block_healing");
}

public TileEntity createNewTileEntity(World world) {return new TEHealing();}

@SideOnly(Side.CLIENT)
public Icon getIcon(int par1, int par2) {return iconArray[par2 % iconArray.length];}

public int quantityDropped(Random rdm) {return 0;}
public int idDropped(int id, Random rdm, int par3) {return id;}
public int damageDropped(int id) {return id;}

@SideOnly(Side.CLIENT)
public void getSubBlocks(int id, CreativeTabs table, List list) {
for (int j = 0; j < healingTypes.length; ++j) {
list.add(new ItemStack(id, 1, j));
}
}

@Override 
public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int metadata, int fortune) {
ArrayList<ItemStack> ret = super.getBlockDropped(world, x, y, z, metadata, fortune);
ret.add(new ItemStack(PackStock.proxy.block_healing, 1, metadata));
return ret;
}

@SideOnly(Side.CLIENT)
public void registerIcons(IconRegister ir) {
iconArray = new Icon[healingTypes.length];
for (int i = 0; i < iconArray.length; ++i) {
//iconArray[i] = ir.registerIcon("timaxa007:"+"tree/"+"sapling"+sapling1Types[i]);
iconArray[i] = ir.registerIcon("timaxa007:"+"healing/"+healingTypes);
}
}

}
