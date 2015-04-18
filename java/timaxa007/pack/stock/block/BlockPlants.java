package timaxa007.pack.stock.block;

import java.util.List;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import timaxa007.pack.stock.PackStock;
import timaxa007.pack.stock.item.ItemPlants;
import timaxa007.pack.stock.tile.TileEntityPlants;
import timaxa007.tms.util.ModifiedBlock;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockPlants extends ModifiedBlock implements ITileEntityProvider {

	public BlockPlants(String tag) {
		super(tag, Material.glass);
		setCreativeTab(PackStock.tab_plant);
		setHardness(0.25F);
		setResistance(0.1F);
		setBlockBounds(0.125F, 0.0F, 0.125F, 0.875F, 1.0F, 0.875F);
		setBlockTextureName("plank_oak");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityPlants();
	}

	public int getRenderType() {
		return PackStock.render.block_plants_modelID;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(x, y, z);
		if (te != null && te instanceof TileEntityPlants) {
			/*return addNBT(
					((TileEntityPlants)te).getPlant(), 
					((TileEntityPlants)te).getSticks(), 
					((TileEntityPlants)te).getGrowth(), 
					((TileEntityPlants)te).getFertility(), 
					((TileEntityPlants)te).getResistance()
					);*/
			/*return ItemPlants.addNBT(
					((TileEntityPlants)te).getPlant(), 
					(byte)((TileEntityPlants)te).getTypePlant(), 
					(byte)((TileEntityPlants)te).getGrowth(), 
					(byte)((TileEntityPlants)te).getFertility(), 
					(byte)((TileEntityPlants)te).getResistance()
					);*/
		}
		return null;
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {return null;}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float hitX, float hitY, float hitZ) {
		ItemStack current = player.getCurrentEquippedItem();

		TileEntity te = world.getTileEntity(x, y, z);
		if (te != null && te instanceof TileEntityPlants) {
			if (current != null) {
				if (current.getItem() instanceof ItemPlants && current.getTagCompound() != null && 
						current.getTagCompound().hasKey("PlantID") && 
						current.getTagCompound().hasKey("PlantType") && 
						current.getTagCompound().hasKey("Growth") && 
						current.getTagCompound().hasKey("Fertility") && 
						current.getTagCompound().hasKey("Resistance") &&
						((TileEntityPlants)te).getPlantID() == 0) {
					((TileEntityPlants)te).setPlantID(current.getTagCompound().getInteger("PlantID"));
					((TileEntityPlants)te).setPlantType(current.getTagCompound().getString("PlantType"));
					((TileEntityPlants)te).setWidth(0);
					((TileEntityPlants)te).setHeight(0);
					((TileEntityPlants)te).setGrowth(current.getTagCompound().getInteger("Growth"));
					((TileEntityPlants)te).setFertility(current.getTagCompound().getInteger("Fertility"));
					((TileEntityPlants)te).setResistance(current.getTagCompound().getInteger("Resistance"));
					return true;
				}
			} else {
				if (world.isRemote) {
					//player.addChatMessage("/*****************************************/");

					/*player.addChatMessage(
" Plant ID - " + ((TileEntityPlants)te).getPlantID() + 
" / Name - " + Plants.plant_list[((TileEntityPlants)te).getPlantID()].getLocalizedName() +
" / Plant Type - " + ((TileEntityPlants)te).getPlantType());

player.addChatMessage(
" Width - " + ((TileEntityPlants)te).getWidth() + 
" / Height - " + ((TileEntityPlants)te).getHeight());

player.addChatMessage(
" Growth - " + ((TileEntityPlants)te).getGrowth() + 
" / Fertility - " + ((TileEntityPlants)te).getFertility() + 
" / Resistance - " + ((TileEntityPlants)te).getResistance());*/
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
if (te != null && te instanceof TileEntityPlants) {

String psp1 = ((TileEntityPlants)te).getPlant();
int psg1 = ((TileEntityPlants)te).getGrowing();
spawnPlod(world, x, y, z, psp1, psg1, 0, 0);

((TileEntityPlants)te).setPlant("");
}
}

public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
ItemStack current = player.getCurrentEquippedItem();

TileEntity te = world.getTileEntity(x, y, z);
if (te != null && te instanceof TileEntityPlants) {

if (current != null) {
//--------------------------------
if (
(current.getItem() == PackStock.item_base_seed)&&
(((TileEntityPlants)te).getPlant() == "")&&
(world.getBlock(x, y-1, z) == Block.tilledField)
) {
ItemStack isg = new ItemStack(current.getItem(), 1, current.getItemDamage());
NBTTagCompound nbt = isg.getTagCompound();
((TileEntityPlants)te).setPlant(current.getItemDamage());
((TileEntityPlants)te).setGrowing(0);
if (!player.capabilities.isCreativeMode) {--current.stackSize;}
//--------------------------------
} else if (
(current.getItem() == Item.reed)&&
(((TileEntityPlants)te).getPlant() == 0)&&
(world.getBlock(x, y-1, z) == Block.sand)&&
(current.stackSize >= 4)
) {
((TileEntityPlants)te).setPlant(4);
((TileEntityPlants)te).setGrowing(0);
if (!player.capabilities.isCreativeMode) {--current.stackSize;--current.stackSize;--current.stackSize;--current.stackSize;}
//--------------------------------
} else if (
(current.getItem() == Item.potato)&&
(((TileEntityPlants)te).getPlant() == 0)&&
((world.getBlock(x, y-1, z) == Block.tilledField)||(world.getBlock(x, y-1, z) == Block.dirt))&&
(current.stackSize >= 4)
) {
((TileEntityPlants)te).setPlant(2);
((TileEntityPlants)te).setGrowing(0);
if (!player.capabilities.isCreativeMode) {--current.stackSize;--current.stackSize;--current.stackSize;--current.stackSize;}
//--------------------------------
} else if (
(current.getItem() == Item.carrot)&&
(((TileEntityPlants)te).getPlant() == 0)&&
(world.getBlock(x, y-1, z) == Block.tilledField)&&
(current.stackSize >= 4)
) {
((TileEntityPlants)te).setPlant(1);
((TileEntityPlants)te).setGrowing(0);
if (!player.capabilities.isCreativeMode) {--current.stackSize;--current.stackSize;--current.stackSize;--current.stackSize;}
//--------------------------------
} else if (
(current.getItem() == Item.netherStalkSeeds)&&
(((TileEntityPlants)te).getPlant() == 0)&&
(world.getBlock(x, y-1, z) == Block.slowSand)&&
(current.stackSize >= 4)
) {
((TileEntityPlants)te).setPlant(5);
((TileEntityPlants)te).setGrowing(0);
if (!player.capabilities.isCreativeMode) {--current.stackSize;--current.stackSize;--current.stackSize;--current.stackSize;}
//--------------------------------
} else if (
(current.getItem() == Item.seeds)&&
(((TileEntityPlants)te).getPlant() == 0)&&
(world.getBlock(x, y-1, z) == Block.tilledField)&&
(current.stackSize >= 4)
) {
((TileEntityPlants)te).setPlant(3);
((TileEntityPlants)te).setGrowing(0);
if (!player.capabilities.isCreativeMode) {--current.stackSize;--current.stackSize;--current.stackSize;--current.stackSize;}
//--------------------------------
} else if (
(current.getItem() == Item.melonSeeds)&&
(((TileEntityPlants)te).getPlant() == 0)&&
(world.getBlock(x, y-1, z) == Block.tilledField)&&
(current.stackSize >= 4)
) {
((TileEntityPlants)te).setPlant(6);
((TileEntityPlants)te).setGrowing(0);
if (!player.capabilities.isCreativeMode) {--current.stackSize;--current.stackSize;--current.stackSize;--current.stackSize;}
//--------------------------------
} else if (
(current.getItem() == Item.pumpkinSeeds)&&
(((TileEntityPlants)te).getPlant() == 0)&&
(world.getBlock(x, y-1, z) == Block.tilledField)&&
(current.stackSize >= 4)
) {
((TileEntityPlants)te).setPlant(7);
((TileEntityPlants)te).setGrowing(0);
if (!player.capabilities.isCreativeMode) {--current.stackSize;--current.stackSize;--current.stackSize;--current.stackSize;}
//--------------------------------
} else if (
(current.getItem() == Block.mushroomBrown)&&
(((TileEntityPlants)te).getPlant() == 0)&&
((world.getBlock(x, y-1, z) == Block.tilledField)||
(world.getBlock(x, y-1, z) == Block.dirt)||
(world.getBlock(x, y-1, z) == Block.cobblestone)||
(world.getBlock(x, y-1, z) == Block.cobblestoneMossy)||
(world.getBlock(x, y-1, z) == Block.mycelium))&&
(current.stackSize >= 4)
) {
((TileEntityPlants)te).setPlant(8);
((TileEntityPlants)te).setGrowing(0);
if (!player.capabilities.isCreativeMode) {--current.stackSize;--current.stackSize;--current.stackSize;--current.stackSize;}
//--------------------------------
} else if (
(current.getItem() == Block.mushroomRed)&&
(((TileEntityPlants)te).getPlant() == 0)&&
((world.getBlock(x, y-1, z) == Block.tilledField)||
(world.getBlock(x, y-1, z) == Block.dirt)||
(world.getBlock(x, y-1, z) == Block.cobblestone)||
(world.getBlock(x, y-1, z) == Block.cobblestoneMossy)||
(world.getBlock(x, y-1, z) == Block.mycelium))&&
(current.stackSize >= 4)
) {
((TileEntityPlants)te).setPlant(9);
((TileEntityPlants)te).setGrowing(0);
if (!player.capabilities.isCreativeMode) {--current.stackSize;--current.stackSize;--current.stackSize;--current.stackSize;}
//--------------------------------
} else if (
(current.getItem() == Block.plantRed)&&
(((TileEntityPlants)te).getPlant() == 0)&&
((world.getBlock(x, y-1, z) == Block.tilledField)||
(world.getBlock(x, y-1, z) == Block.dirt)||
(world.getBlock(x, y-1, z) == Block.grass))&&
(current.stackSize >= 4)
) {
((TileEntityPlants)te).setPlant(10);
((TileEntityPlants)te).setGrowing(0);
if (!player.capabilities.isCreativeMode) {--current.stackSize;--current.stackSize;--current.stackSize;--current.stackSize;}
//--------------------------------
} else if (
(current.getItem() == Block.plantYellow)&&
(((TileEntityPlants)te).getPlant() == 0)&&
((world.getBlock(x, y-1, z) == Block.tilledField)||
(world.getBlock(x, y-1, z) == Block.dirt)||
(world.getBlock(x, y-1, z) == Block.grass))&&
(current.stackSize >= 4)
) {
((TileEntityPlants)te).setPlant(11);
((TileEntityPlants)te).setGrowing(0);
if (!player.capabilities.isCreativeMode) {--current.stackSize;--current.stackSize;--current.stackSize;--current.stackSize;}
//--------------------------------
} else if ((current.getItem() == Item.dyePowder)&&(current.getItemDamage() == 15)) {
world.spawnParticle("happyVillager", (double)x + 0.5F, (double)y + 0.25F, (double)z + 0.5F, 0, 0, 0);

world.spawnParticle("happyVillager", (double)x + 0.26F, (double)y + 0.25F, (double)z + 0.26F, 0, 0, 0);
world.spawnParticle("happyVillager", (double)x + 0.74F, (double)y + 0.25F, (double)z + 0.74F, 0, 0, 0);
world.spawnParticle("happyVillager", (double)x + 0.26F, (double)y + 0.25F, (double)z + 0.74F, 0, 0, 0);
world.spawnParticle("happyVillager", (double)x + 0.74F, (double)y + 0.25F, (double)z + 0.26F, 0, 0, 0);

world.spawnParticle("happyVillager", (double)x + 0.6F, (double)y + 0.2F, (double)z + 0.25F, 0, 0, 0);
world.spawnParticle("happyVillager", (double)x + 0.6F, (double)y + 0.2F, (double)z + 0.75F, 0, 0, 0);
world.spawnParticle("happyVillager", (double)x + 0.25F, (double)y + 0.2F, (double)z + 0.6F, 0, 0, 0);
world.spawnParticle("happyVillager", (double)x + 0.75F, (double)y + 0.2F, (double)z + 0.6F, 0, 0, 0);

((TileEntityPlants)te).setGrowing(((TileEntityPlants)te).getGrowing() + 1);

if (!player.capabilities.isCreativeMode) {--current.stackSize;}
//--------------------------------
} else {

int psp1 = ((TileEntityPlants)te).getPlant();
int psg1 = ((TileEntityPlants)te).getGrowing();
spawnPlod(world, x, y, z, psp1, psg1, 0, 0);

((TileEntityPlants)te).setGrowing(0);

}

} else {

int psp1 = ((TileEntityPlants)te).getPlant();
int psg1 = ((TileEntityPlants)te).getGrowing();
spawnPlod(world, x, y, z, psp1, psg1, 0, 0);
((TileEntityPlants)te).setGrowing(0);
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
		NBTTagCompound nbt = is.getTagCompound();
		if (te != null && te instanceof TileEntityPlants) {

			if (
					nbt != null && 
					nbt.hasKey("PlantID") && 
					nbt.hasKey("PlantType") && 
					nbt.hasKey("Width") && 
					nbt.hasKey("Height") && 
					nbt.hasKey("Growth") && 
					nbt.hasKey("Fertility") && 
					nbt.hasKey("Resistance")
					) {
				((TileEntityPlants)te).setPlantID(nbt.getInteger("PlantID"));
				((TileEntityPlants)te).setPlantType(nbt.getString("PlantType"));
				((TileEntityPlants)te).setWidth(nbt.getInteger("Width"));
				((TileEntityPlants)te).setHeight(nbt.getInteger("Height"));
				((TileEntityPlants)te).setGrowth(nbt.getInteger("Growth"));
				((TileEntityPlants)te).setFertility(nbt.getInteger("Fertility"));
				((TileEntityPlants)te).setResistance(nbt.getInteger("Resistance"));
			} else {
				((TileEntityPlants)te).setPlantID(0);
				((TileEntityPlants)te).setPlantType("");
				((TileEntityPlants)te).setWidth(0);
				((TileEntityPlants)te).setHeight(0);
				((TileEntityPlants)te).setGrowth(0);
				((TileEntityPlants)te).setFertility(0);
				((TileEntityPlants)te).setResistance(0);
			}

		}
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item id, CreativeTabs table, List list) {
		list.add(addNBT(0, "", 0, 0, 0, 0, 0));
		//list.add(new ItemStack(id, 1, 0));
	}

	public static ItemStack addNBT(int par1, String par2, int par3, int par4, int par5, int par6, int par7) {
		ItemStack is = new ItemStack(PackStock.block.plants, 1, 0);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setInteger("PlantID", par1);
		nbt.setString("PlantType", par2);
		nbt.setInteger("Width", par3);
		nbt.setInteger("Height", par4);
		nbt.setInteger("Growth", par5);
		nbt.setInteger("Fertility", par6);
		nbt.setInteger("Resistance", par7);
		is.setTagCompound(nbt);
		return is;
	}

	/*
@SideOnly(Side.CLIENT)
public void registerBlockIcons(IIconRegister ir) {blockIcon = ir.registerIcon("wood");}
	 */
}
