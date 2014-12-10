package mods.timaxa007.pack.stock.blocks;

import java.util.List;

import mods.timaxa007.pack.stock.PackStock;
import mods.timaxa007.pack.stock.items.ItemGerminationPlants;
import mods.timaxa007.pack.stock.lib.GerminationPlants;
import mods.timaxa007.pack.stock.te.TEGerminationPlants;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockGerminationPlants extends BlockContainer {

public BlockGerminationPlants() {
super(Material.glass);
setCreativeTab(PackStock.proxy.tabPlantPack);
setHardness(0.25F);
setResistance(0.1F);
setBlockBounds(0.125F, 0.0F, 0.125F, 0.875F, 1.0F, 0.875F);
setBlockTextureName("plank_oak");
setBlockName("germination");
}

@Override
public TileEntity createNewTileEntity(World world, int meta) {return new TEGerminationPlants();}

public int getRenderType() {return PackStock.proxy.render_block_germination_plants_modelID;}
public boolean renderAsNormalBlock() {return false;}
public boolean isOpaqueCube() {return false;}

public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
TileEntity te = world.getTileEntity(x, y, z);
if (te != null && te instanceof TEGerminationPlants) {
/*return addTag(
((TEGerminationPlants)te).getPlant(), 
((TEGerminationPlants)te).getSticks(), 
((TEGerminationPlants)te).getGrowth(), 
((TEGerminationPlants)te).getFertility(), 
((TEGerminationPlants)te).getResistance()
);*/
/*return ItemGerminationPlants.addTag(
((TEGerminationPlants)te).getPlant(), 
(byte)((TEGerminationPlants)te).getTypePlant(), 
(byte)((TEGerminationPlants)te).getGrowth(), 
(byte)((TEGerminationPlants)te).getFertility(), 
(byte)((TEGerminationPlants)te).getResistance()
);*/
}
return null;
}

public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {return null;}

public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float hitX, float hitY, float hitZ) {
ItemStack current = player.getCurrentEquippedItem();

TileEntity te = world.getTileEntity(x, y, z);
if (te != null && te instanceof TEGerminationPlants) {
if (current != null) {
if (current.getItem() instanceof ItemGerminationPlants && current.getTagCompound() != null && 
current.getTagCompound().hasKey("PlantID") && 
current.getTagCompound().hasKey("PlantType") && 
current.getTagCompound().hasKey("Growth") && 
current.getTagCompound().hasKey("Fertility") && 
current.getTagCompound().hasKey("Resistance") &&
((TEGerminationPlants)te).getPlantID() == 0) {
((TEGerminationPlants)te).setPlantID(current.getTagCompound().getInteger("PlantID"));
((TEGerminationPlants)te).setPlantType(current.getTagCompound().getString("PlantType"));
((TEGerminationPlants)te).setWidth(0);
((TEGerminationPlants)te).setHeight(0);
((TEGerminationPlants)te).setGrowth(current.getTagCompound().getInteger("Growth"));
((TEGerminationPlants)te).setFertility(current.getTagCompound().getInteger("Fertility"));
((TEGerminationPlants)te).setResistance(current.getTagCompound().getInteger("Resistance"));
return true;
}
} else {
if (world.isRemote) {
//player.addChatMessage("/*****************************************/");

/*player.addChatMessage(
" Plant ID - " + ((TEGerminationPlants)te).getPlantID() + 
" / Name - " + GerminationPlants.plant_list[((TEGerminationPlants)te).getPlantID()].getLocalizedName() +
" / Plant Type - " + ((TEGerminationPlants)te).getPlantType());

player.addChatMessage(
" Width - " + ((TEGerminationPlants)te).getWidth() + 
" / Height - " + ((TEGerminationPlants)te).getHeight());

player.addChatMessage(
" Growth - " + ((TEGerminationPlants)te).getGrowth() + 
" / Fertility - " + ((TEGerminationPlants)te).getFertility() + 
" / Resistance - " + ((TEGerminationPlants)te).getResistance());*/
}
}
}
return false;
}
/*
public boolean checkTemperatureGrowing(World world, int x, int y, int z, float temp) {
if (world.getBiomeGenForCoords(x, z).getFloatTemperature() >= temp - 0.25F && 
world.getBiomeGenForCoords(x, z).getFloatTemperature() <= temp + 0.25F) {return true;}
return false;
}

public boolean checkHumidityGrowingPrimary(World world, int x, int y, int z, float humy) {
if (world.getBiomeGenForCoords(x, z).getFloatRainfall() >= humy - 0.25F && 
world.getBiomeGenForCoords(x, z).getFloatRainfall() <= humy + 0.25F) {return true;}
return false;
}

public boolean checkBlockGrowingPrimary(World world, int x, int y, int z, String primary) {
if (primary != null && primary != "") {
if (world.getBlock(x, y - 1, z) == Block.dirt) {return true;}
if (world.getBlock(x, y - 1, z) == Block.sand) {return true;}
if (world.getBlock(x, y - 1, z) == Block.stone) {return true;}
if (world.getBlock(x, y - 1, z) == Block.cobblestone) {return true;}
if (world.getBlock(x, y - 1, z) == Block.slowSand) {return true;}
if (world.getBlock(x, y - 1, z) == Block.netherrack) {return true;}
}
return false;
}

public boolean checkBlockGrowingSecondary(World world, int x, int y, int z, String secondary) {
if (secondary != null && secondary != "") {
if (world.getBlockMaterial(x, y - 1, z) == Material.ground) {return true;}
if (world.getBlockMaterial(x, y - 1, z) == Material.sand) {return true;}
if (world.getBlockMaterial(x, y - 1, z) == Material.rock) {return true;}
}
return false;
}
*/
/*
public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player) {
TileEntity te = world.getTileEntity(x, y, z);
if (te != null && te instanceof TEGerminationPlants) {

String psp1 = ((TEGerminationPlants)te).getPlant();
int psg1 = ((TEGerminationPlants)te).getGrowing();
spawnPlod(world, x, y, z, psp1, psg1, 0, 0);

((TEGerminationPlants)te).setPlant("");
}
}

public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
ItemStack current = player.getCurrentEquippedItem();

TileEntity te = world.getTileEntity(x, y, z);
if (te != null && te instanceof TEGerminationPlants) {

if (current != null) {
//--------------------------------
if (
(current.getItem() == PackStock.proxy.item_base_seed)&&
(((TEGerminationPlants)te).getPlant() == "")&&
(world.getBlock(x, y-1, z) == Block.tilledField)
) {
ItemStack isg = new ItemStack(current.getItem(), 1, current.getItemDamage());
NBTTagCompound nbt = isg.getTagCompound();
((TEGerminationPlants)te).setPlant(current.getItemDamage());
((TEGerminationPlants)te).setGrowing(0);
if (!player.capabilities.isCreativeMode) {--current.stackSize;}
//--------------------------------
}else if (
(current.getItem() == Item.reed)&&
(((TEGerminationPlants)te).getPlant() == 0)&&
(world.getBlock(x, y-1, z) == Block.sand)&&
(current.stackSize >= 4)
) {
((TEGerminationPlants)te).setPlant(4);
((TEGerminationPlants)te).setGrowing(0);
if (!player.capabilities.isCreativeMode) {--current.stackSize;--current.stackSize;--current.stackSize;--current.stackSize;}
//--------------------------------
}else if (
(current.getItem() == Item.potato)&&
(((TEGerminationPlants)te).getPlant() == 0)&&
((world.getBlock(x, y-1, z) == Block.tilledField)||(world.getBlock(x, y-1, z) == Block.dirt))&&
(current.stackSize >= 4)
) {
((TEGerminationPlants)te).setPlant(2);
((TEGerminationPlants)te).setGrowing(0);
if (!player.capabilities.isCreativeMode) {--current.stackSize;--current.stackSize;--current.stackSize;--current.stackSize;}
//--------------------------------
}else if (
(current.getItem() == Item.carrot)&&
(((TEGerminationPlants)te).getPlant() == 0)&&
(world.getBlock(x, y-1, z) == Block.tilledField)&&
(current.stackSize >= 4)
) {
((TEGerminationPlants)te).setPlant(1);
((TEGerminationPlants)te).setGrowing(0);
if (!player.capabilities.isCreativeMode) {--current.stackSize;--current.stackSize;--current.stackSize;--current.stackSize;}
//--------------------------------
}else if (
(current.getItem() == Item.netherStalkSeeds)&&
(((TEGerminationPlants)te).getPlant() == 0)&&
(world.getBlock(x, y-1, z) == Block.slowSand)&&
(current.stackSize >= 4)
) {
((TEGerminationPlants)te).setPlant(5);
((TEGerminationPlants)te).setGrowing(0);
if (!player.capabilities.isCreativeMode) {--current.stackSize;--current.stackSize;--current.stackSize;--current.stackSize;}
//--------------------------------
}else if (
(current.getItem() == Item.seeds)&&
(((TEGerminationPlants)te).getPlant() == 0)&&
(world.getBlock(x, y-1, z) == Block.tilledField)&&
(current.stackSize >= 4)
) {
((TEGerminationPlants)te).setPlant(3);
((TEGerminationPlants)te).setGrowing(0);
if (!player.capabilities.isCreativeMode) {--current.stackSize;--current.stackSize;--current.stackSize;--current.stackSize;}
//--------------------------------
}else if (
(current.getItem() == Item.melonSeeds)&&
(((TEGerminationPlants)te).getPlant() == 0)&&
(world.getBlock(x, y-1, z) == Block.tilledField)&&
(current.stackSize >= 4)
) {
((TEGerminationPlants)te).setPlant(6);
((TEGerminationPlants)te).setGrowing(0);
if (!player.capabilities.isCreativeMode) {--current.stackSize;--current.stackSize;--current.stackSize;--current.stackSize;}
//--------------------------------
}else if (
(current.getItem() == Item.pumpkinSeeds)&&
(((TEGerminationPlants)te).getPlant() == 0)&&
(world.getBlock(x, y-1, z) == Block.tilledField)&&
(current.stackSize >= 4)
) {
((TEGerminationPlants)te).setPlant(7);
((TEGerminationPlants)te).setGrowing(0);
if (!player.capabilities.isCreativeMode) {--current.stackSize;--current.stackSize;--current.stackSize;--current.stackSize;}
//--------------------------------
}else if (
(current.getItem() == Block.mushroomBrown)&&
(((TEGerminationPlants)te).getPlant() == 0)&&
((world.getBlock(x, y-1, z) == Block.tilledField)||
(world.getBlock(x, y-1, z) == Block.dirt)||
(world.getBlock(x, y-1, z) == Block.cobblestone)||
(world.getBlock(x, y-1, z) == Block.cobblestoneMossy)||
(world.getBlock(x, y-1, z) == Block.mycelium))&&
(current.stackSize >= 4)
) {
((TEGerminationPlants)te).setPlant(8);
((TEGerminationPlants)te).setGrowing(0);
if (!player.capabilities.isCreativeMode) {--current.stackSize;--current.stackSize;--current.stackSize;--current.stackSize;}
//--------------------------------
}else if (
(current.getItem() == Block.mushroomRed)&&
(((TEGerminationPlants)te).getPlant() == 0)&&
((world.getBlock(x, y-1, z) == Block.tilledField)||
(world.getBlock(x, y-1, z) == Block.dirt)||
(world.getBlock(x, y-1, z) == Block.cobblestone)||
(world.getBlock(x, y-1, z) == Block.cobblestoneMossy)||
(world.getBlock(x, y-1, z) == Block.mycelium))&&
(current.stackSize >= 4)
) {
((TEGerminationPlants)te).setPlant(9);
((TEGerminationPlants)te).setGrowing(0);
if (!player.capabilities.isCreativeMode) {--current.stackSize;--current.stackSize;--current.stackSize;--current.stackSize;}
//--------------------------------
}else if (
(current.getItem() == Block.plantRed)&&
(((TEGerminationPlants)te).getPlant() == 0)&&
((world.getBlock(x, y-1, z) == Block.tilledField)||
(world.getBlock(x, y-1, z) == Block.dirt)||
(world.getBlock(x, y-1, z) == Block.grass))&&
(current.stackSize >= 4)
) {
((TEGerminationPlants)te).setPlant(10);
((TEGerminationPlants)te).setGrowing(0);
if (!player.capabilities.isCreativeMode) {--current.stackSize;--current.stackSize;--current.stackSize;--current.stackSize;}
//--------------------------------
}else if (
(current.getItem() == Block.plantYellow)&&
(((TEGerminationPlants)te).getPlant() == 0)&&
((world.getBlock(x, y-1, z) == Block.tilledField)||
(world.getBlock(x, y-1, z) == Block.dirt)||
(world.getBlock(x, y-1, z) == Block.grass))&&
(current.stackSize >= 4)
) {
((TEGerminationPlants)te).setPlant(11);
((TEGerminationPlants)te).setGrowing(0);
if (!player.capabilities.isCreativeMode) {--current.stackSize;--current.stackSize;--current.stackSize;--current.stackSize;}
//--------------------------------
}else if ((current.getItem() == Item.dyePowder)&&(current.getItemDamage() == 15)) {
world.spawnParticle("happyVillager", (double)x + 0.5F, (double)y + 0.25F, (double)z + 0.5F, 0, 0, 0);

world.spawnParticle("happyVillager", (double)x + 0.26F, (double)y + 0.25F, (double)z + 0.26F, 0, 0, 0);
world.spawnParticle("happyVillager", (double)x + 0.74F, (double)y + 0.25F, (double)z + 0.74F, 0, 0, 0);
world.spawnParticle("happyVillager", (double)x + 0.26F, (double)y + 0.25F, (double)z + 0.74F, 0, 0, 0);
world.spawnParticle("happyVillager", (double)x + 0.74F, (double)y + 0.25F, (double)z + 0.26F, 0, 0, 0);

world.spawnParticle("happyVillager", (double)x + 0.6F, (double)y + 0.2F, (double)z + 0.25F, 0, 0, 0);
world.spawnParticle("happyVillager", (double)x + 0.6F, (double)y + 0.2F, (double)z + 0.75F, 0, 0, 0);
world.spawnParticle("happyVillager", (double)x + 0.25F, (double)y + 0.2F, (double)z + 0.6F, 0, 0, 0);
world.spawnParticle("happyVillager", (double)x + 0.75F, (double)y + 0.2F, (double)z + 0.6F, 0, 0, 0);

((TEGerminationPlants)te).setGrowing(((TEGerminationPlants)te).getGrowing() + 1);

if (!player.capabilities.isCreativeMode) {--current.stackSize;}
//--------------------------------
} else {

int psp1 = ((TEGerminationPlants)te).getPlant();
int psg1 = ((TEGerminationPlants)te).getGrowing();
spawnPlod(world, x, y, z, psp1, psg1, 0, 0);

((TEGerminationPlants)te).setGrowing(0);

}

} else {

int psp1 = ((TEGerminationPlants)te).getPlant();
int psg1 = ((TEGerminationPlants)te).getGrowing();
spawnPlod(world, x, y, z, psp1, psg1, 0, 0);
((TEGerminationPlants)te).setGrowing(0);
}

return true;
} else {
return false;
}

}

private static int[] plods1 = {
Item.carrot.getItem(), 
Item.potato.getItem(), 
Item.seeds.getItem(), 
Item.reed.getItem(), 
Item.netherStalkSeeds.getItem(), 
Item.melonSeeds.getItem(), 
Item.pumpkinSeeds.getItem(), 
Block.mushroomBrown, 
Block.mushroomRed, 
Block.plantRed, 
Block.plantYellow, 
};

private static int[] plods2 = {
Item.carrot.getItem(), 
Item.potato.getItem(), 
Item.seeds.getItem(), 
Item.reed.getItem(), 
Item.netherStalkSeeds.getItem(), 
Item.melonSeeds.getItem(), 
Item.pumpkinSeeds.getItem(), 
Block.mushroomBrown, 
Block.mushroomRed, 
Block.plantRed, 
Block.plantYellow, 
};

private void spawnPlod(World world, int x, int y, int z, int ps1, int pc1, int ps2, int pc2) {
if (!world.isRemote) {

if ((ps1 >= 1)&&(pc1 >= 1)) {
for(int j1 = 0;j1<pc1/2; ++j1) {
ItemStack isitem1 = new ItemStack(plods1[ps1-1], 1, 0);
EntityItem entityitem1 = new EntityItem(world, (double)x + 0.5D, (double)y + 0.5D, (double)z + 0.5D, isitem1);
//entityitem.delayBeforeCanPickup = 8;
world.spawnEntityInWorld(entityitem1);
}
} else {}

if ((ps1 == 3)&&(pc1 >= 4)) {
for(int j3 = 0;j3<(pc1 + 1)/2; ++j3) {
ItemStack isitem1p = new ItemStack(plods2[ps1-1], 1, 0);
EntityItem entityitem1p = new EntityItem(world, (double)x + 0.5D, (double)y + 0.5D, (double)z + 0.5D, isitem1p);
//entityitem.delayBeforeCanPickup = 8;
world.spawnEntityInWorld(entityitem1p);
}
}

if ((ps2 >= 1)&&(pc2 >= 1)) {
for(int j2 = 0;j2<(pc2 + 1)/2; ++j2) {
ItemStack isitem2 = new ItemStack(plods2[ps2-1], 1, 0);
EntityItem entityitem2 = new EntityItem(world, (double)x + 0.5D, (double)y + 0.5D, (double)z + 0.5D, isitem2);
//entityitem.delayBeforeCanPickup = 8;
world.spawnEntityInWorld(entityitem2);
}
} else {}

}
}
*/

@Override
public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
TileEntity te = world.getTileEntity(x, y, z);
NBTTagCompound tag = is.getTagCompound();
if (te != null && te instanceof TEGerminationPlants) {

if (
tag != null && 
tag.hasKey("PlantID") && 
tag.hasKey("PlantType") && 
tag.hasKey("Width") && 
tag.hasKey("Height") && 
tag.hasKey("Growth") && 
tag.hasKey("Fertility") && 
tag.hasKey("Resistance")
) {
((TEGerminationPlants)te).setPlantID(tag.getInteger("PlantID"));
((TEGerminationPlants)te).setPlantType(tag.getString("PlantType"));
((TEGerminationPlants)te).setWidth(tag.getInteger("Width"));
((TEGerminationPlants)te).setHeight(tag.getInteger("Height"));
((TEGerminationPlants)te).setGrowth(tag.getInteger("Growth"));
((TEGerminationPlants)te).setFertility(tag.getInteger("Fertility"));
((TEGerminationPlants)te).setResistance(tag.getInteger("Resistance"));
} else {
((TEGerminationPlants)te).setPlantID(0);
((TEGerminationPlants)te).setPlantType("");
((TEGerminationPlants)te).setWidth(0);
((TEGerminationPlants)te).setHeight(0);
((TEGerminationPlants)te).setGrowth(0);
((TEGerminationPlants)te).setFertility(0);
((TEGerminationPlants)te).setResistance(0);
}

}
}

@SideOnly(Side.CLIENT)
public void getSubBlocks(int id, CreativeTabs table, List list) {
list.add(addTag(0, "", 0, 0, 0, 0, 0));
//list.add(new ItemStack(id, 1, 0));
}

private static ItemStack addTag(int par1, String par2, int par3, int par4, int par5, int par6, int par7) {
ItemStack is = new ItemStack(PackStock.proxy.block_germination_plants, 1, 0);
NBTTagCompound tag = new NBTTagCompound();
tag.setInteger("PlantID", par1);
tag.setString("PlantType", par2);
tag.setInteger("Width", par3);
tag.setInteger("Height", par4);
tag.setInteger("Growth", par5);
tag.setInteger("Fertility", par6);
tag.setInteger("Resistance", par7);
is.setTagCompound(tag);
return is;
}

/*
@SideOnly(Side.CLIENT)
public void registerIcons(IIconRegister ir) {blockIcon = ir.registerIcon("wood");}
*/
}
