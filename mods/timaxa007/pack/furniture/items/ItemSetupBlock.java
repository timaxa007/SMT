package mods.timaxa007.pack.furniture.items;

import java.util.List;

import mods.timaxa007.pack.furniture.PackFurniture;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSetupBlock extends Item {

@SideOnly(Side.CLIENT) private Icon[] iconArray;

public static final String[] typeSetupBlocks = new String[] {
"door_wood_black", 
"door_wood_blue", 
"door_wood_brown", 
"door_wood_cyan", 
"door_wood_gray", 
"door_wood_green", 
"door_wood_light_blue", 
"door_wood_light_gray", 
"door_wood_light_green", 
"door_wood_magenta", 
"door_wood_orange", 
"door_wood_pink", 
"door_wood_purple", 
"door_wood_red", 
"door_wood_white", 
"door_wood_yellow"
};

public ItemSetupBlock(int id) {
super(id);
setHasSubtypes(true);
setMaxDamage(0);
setMaxStackSize(1);
setCreativeTab(PackFurniture.proxy.tabFurniturePack);
setUnlocalizedName("item_setup_block");
}

/*
public boolean onItemUse(ItemStack is, EntityPlayer player, World wrd, int x, int y, int z, int meta, float par8, float par9, float par10) {
if (meta != 1) {return false;}
else{
++y;
Block block;
if (is.getItemDamage() == 0) {block = PackFurniture.proxy.block_door_wood_color_black;}
else if (is.getItemDamage() == 1) {block = PackFurniture.proxy.block_door_wood_color_blue;}
else if (is.getItemDamage() == 2) {block = PackFurniture.proxy.block_door_wood_color_brown;}
else if (is.getItemDamage() == 3) {block = PackFurniture.proxy.block_door_wood_color_cyan;}
else if (is.getItemDamage() == 4) {block = PackFurniture.proxy.block_door_wood_color_gray;}
else if (is.getItemDamage() == 5) {block = PackFurniture.proxy.block_door_wood_color_green;}
else if (is.getItemDamage() == 6) {block = PackFurniture.proxy.block_door_wood_color_light_blue;}
else if (is.getItemDamage() == 7) {block = PackFurniture.proxy.block_door_wood_color_light_gray;}
else if (is.getItemDamage() == 8) {block = PackFurniture.proxy.block_door_wood_color_light_green;}
else if (is.getItemDamage() == 9) {block = PackFurniture.proxy.block_door_wood_color_magenta;}
else if (is.getItemDamage() == 10) {block = PackFurniture.proxy.block_door_wood_color_orange;}
else if (is.getItemDamage() == 11) {block = PackFurniture.proxy.block_door_wood_color_pink;}
else if (is.getItemDamage() == 12) {block = PackFurniture.proxy.block_door_wood_color_purple;}
else if (is.getItemDamage() == 13) {block = PackFurniture.proxy.block_door_wood_color_red;}
else if (is.getItemDamage() == 14) {block = PackFurniture.proxy.block_door_wood_color_white;}
else if (is.getItemDamage() == 15) {block = PackFurniture.proxy.block_door_wood_color_yellow;}
else{block = PackFurniture.proxy.block_door_wood_color_yellow;}
if (player.canPlayerEdit(x, y, z, meta, is) && player.canPlayerEdit(x, y+1, z, meta, is)) {
if (!block.canPlaceBlockAt(wrd, x, y, z)) {return false;}
else{
int i1 = MathHelper.floor_double((double)((player.rotationYaw+180.0F) * 4.0F / 360.0F)-0.5D) & 3;
placeDoorWoodBlock(wrd, x, y, z, i1, block);
--is.stackSize;
return true;
}
}else{return false;}
}
}
*/

public static void placeDoorWoodBlock(World par0World, int par1, int par2, int par3, int par4, Block par5Block) {
byte b0 = 0;
byte b1 = 0;

if (par4 == 0) {b1 = 1;}
if (par4 == 1) {b0 = -1;}
if (par4 == 2) {b1 = -1;}
if (par4 == 3) {b0 = 1;}

int i1 = (par0World.isBlockNormalCube(par1-b0, par2, par3-b1) ? 1 : 0)+(par0World.isBlockNormalCube(par1-b0, par2+1, par3-b1) ? 1 : 0);
int j1 = (par0World.isBlockNormalCube(par1+b0, par2, par3+b1) ? 1 : 0)+(par0World.isBlockNormalCube(par1+b0, par2+1, par3+b1) ? 1 : 0);
boolean flag = par0World.getBlockId(par1-b0, par2, par3-b1) == par5Block.blockID || par0World.getBlockId(par1-b0, par2+1, par3-b1) == par5Block.blockID;
boolean flag1 = par0World.getBlockId(par1+b0, par2, par3+b1) == par5Block.blockID || par0World.getBlockId(par1+b0, par2+1, par3+b1) == par5Block.blockID;
boolean flag2 = false;

if (flag && !flag1) {flag2 = true;}
else if (j1 > i1) {flag2 = true;}

par0World.setBlock(par1, par2, par3, par5Block.blockID, par4, 2);
par0World.setBlock(par1, par2+1, par3, par5Block.blockID, 8 | (flag2 ? 1 : 0), 2);
par0World.notifyBlocksOfNeighborChange(par1, par2, par3, par5Block.blockID);
par0World.notifyBlocksOfNeighborChange(par1, par2+1, par3, par5Block.blockID);
}

@SideOnly(Side.CLIENT)
public Icon getIconFromDamage(int par1) {
int j = MathHelper.clamp_int(par1, 0, (typeSetupBlocks.length)-1);
return iconArray[j];
}

public String getUnlocalizedName(ItemStack is) {
int i = MathHelper.clamp_int(is.getItemDamage(), 0, (typeSetupBlocks.length)-1);
return super.getUnlocalizedName()+"."+typeSetupBlocks[i];
}

@SideOnly(Side.CLIENT)
public void getSubItems(int id, CreativeTabs table, List list) {
for(int j = 0;j<typeSetupBlocks.length;++j) {
list.add(new ItemStack(id, 1, j));
}
}

@SideOnly(Side.CLIENT)
public void registerIcons(IconRegister ir) {
iconArray = new Icon[typeSetupBlocks.length];

for(int i = 0;i<typeSetupBlocks.length;++i) {
iconArray[i]  =  ir.registerIcon("timaxa007:" + "door/" + typeSetupBlocks[i]);
}
}

}