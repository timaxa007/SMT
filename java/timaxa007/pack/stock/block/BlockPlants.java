package timaxa007.pack.stock.block;

import java.util.List;
import java.util.Random;

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
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import timaxa007.pack.stock.PackStock;
import timaxa007.pack.stock.item.ItemPlants;
import timaxa007.pack.stock.tile.TileEntityPlants;
import timaxa007.pack.stock.util.Plant;
import timaxa007.pack.stock.util.RegistryPlants;
import timaxa007.smt.lib.AddTextureModel;
import timaxa007.smt.object.ModifiedBlock;
import timaxa007.smt.util.UtilString;
import timaxa007.smt.util.UtilSMT;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockPlants extends ModifiedBlock implements ITileEntityProvider {

	public BlockPlants(String tag) {
		super(tag, Material.glass);
		setCreativeTab(PackStock.tab_plant);
		setHardness(0.25F);
		setResistance(0.1F);
		setBlockBounds(0.125F, 0.0F, 0.125F, 0.875F, 1.0F, 0.875F);
		setBlockTextureName("planks_oak");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {return new TileEntityPlants();}
	public int getRenderType() {return PackStock.render.block_plants_modelID;}
	public int quantityDropped(Random random) {return 0;}
	public boolean isOpaqueCube() {return false;}
	public boolean renderAsNormalBlock() {return false;}
	public int idPicked(World world, int x, int y, int z) {return 0;}

	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(x, y, z);
		if (te != null && te instanceof TileEntityPlants) {
			TileEntityPlants tile = (TileEntityPlants)te;
			if (RegistryPlants.hasPlant(tile.getPlant()))
				return ItemPlants.addNBT(tile.getPlant(), tile.getPlantType(), tile.getPlantParametersMain(), tile.getWidth(), tile.getHeight());
		}
		return null;
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {return null;}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		ItemStack current = player.getCurrentEquippedItem();

		TileEntity te = world.getTileEntity(x, y, z);
		if (te != null && te instanceof TileEntityPlants) {
			TileEntityPlants tile = (TileEntityPlants)te;

			Plant plant = RegistryPlants.getPlant(tile.getPlant());

			if (current != null) {
				//if (current.getItem() instanceof ItemPlants && current.getTagCompound() != null && 
				if (player.isSneaking()) {

				} else {

				}

			} else {
				if (world.isRemote) {
					player.addChatMessage(new ChatComponentText("/*****************************************/"));
					blankMessage1(player, "Plant", plant.getLocalizedName() + " (" + tile.getPlant() + ") ");
					blankMessage1(player, "Plant_Type", tile.getPlantType());
					blankMessage1(player, "Growth_Mach", tile.getGrowthMach());
					blankMessage1(player, "Growth_Quality", tile.getGrowthQuality());
					blankMessage1(player, "Fertility_Quality", tile.getFertilityQuality());
					blankMessage1(player, "Fertility_Quantity", tile.getFertilityQuantity());
					blankMessage1(player, "Resistance", tile.getResistance());
					blankMessage1(player, "Protection", tile.getProtection());
					blankMessage1(player, "Dead_Plant", UtilString.textYesNo(tile.getDeadPlant()));
					blankMessage1(player, "Width", tile.getWidth());
					blankMessage1(player, "Height", tile.getHeight());
					//player.addChatMessage(new ChatComponentText("/*****************************************/"));
				}
			}
		}
		return false;
	}

	private static void blankMessage1(EntityPlayer player, String text1, int text2) {
		blankMessage1(player, text1, Integer.toString(text2));
	}

	private static void blankMessage1(EntityPlayer player, String text1, String text2) {
		player.addChatMessage(new ChatComponentText(EnumChatFormatting.AQUA + UtilString.getText(text1) + ": " + EnumChatFormatting.RESET + text2 + "."));
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

public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float hitX, float hitY, float hitZ) {
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
			TileEntityPlants tile = (TileEntityPlants)te;

			if (nbt != null && nbt.hasKey("Style"))
				tile.setStyle(nbt.getString("Style"));
			else
				tile.setStyle("");

		}
	}

	public void onBlockHarvested(World world, int x, int y, int z, int meta, EntityPlayer player) {
		if (!player.capabilities.isCreativeMode) {
			TileEntity te = world.getTileEntity(x, y, z);
			if (te != null && te instanceof TileEntityPlants) {
				TileEntityPlants tile = (TileEntityPlants)te;
				//----------------------------------------------------
				if (RegistryPlants.hasPlant(tile.getPlant())) {

					ItemStack is_item = ItemPlants.addNBT(
							tile.getPlant(), tile.getPlantType(), 
							tile.getPlantParametersMain(), 
							tile.getWidth(), tile.getHeight());

					UtilSMT.UtilWorld.dropItem(world, x, y, z, is_item);
				}
				//----------------------------------------------------
				if (UtilString.hasString(tile.getStyle())) {
					ItemStack is_block = addNBT(tile.getStyle());
					UtilSMT.UtilWorld.dropItem(world, x, y, z, is_block);
				}
				//----------------------------------------------------
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item id, CreativeTabs table, List list) {
		for (AddTextureModel texture : AddTextureModel.list)
			if (texture != null && AddTextureModel.hasTag(texture.tag)) list.add(addNBT(texture.tag));
	}

	public static ItemStack addNBT(String par1) {
		ItemStack is = new ItemStack(PackStock.block.plants);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setString("Style", par1);
		is.setTagCompound(nbt);
		return is;
	}

}
