package timaxa007.pack.furniture.block;

import java.util.List;

import timaxa007.pack.furniture.PackFurniture;
import timaxa007.pack.furniture.tile.TileEntityCnstorDoors;
import timaxa007.tms.util.ModifiedBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCnstorDoor extends ModifiedBlock implements ITileEntityProvider {

	@SideOnly(Side.CLIENT) private IIcon[] icon_array;

	public BlockCnstorDoor(String tag) {
		super(tag, Material.glass);
		setStepSound(soundTypeWood);
		setCreativeTab(PackFurniture.tab_furniture);
		setHardness(1.0F);
		setResistance(3.5F);
		setLightOpacity(0);
		setBlockTextureName("timaxa007:woodFrame");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityCnstorDoors();
	}

	public int idPicked(World world, int x, int y, int z) {
		return 0;
	}

	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(x, y, z);
		if (te != null && te instanceof TileEntityCnstorDoors) {
			return addNBT(world.getBlock(x, y, z), ((TileEntityCnstorDoors)te).getSubID(), ((TileEntityCnstorDoors)te).getColorBlock());
		} else {
			return addNBT(world.getBlock(x, y, z), 0, 0xFFFFFF);
		}
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {

		TileEntity te = world.getTileEntity(x, y, z);
		NBTTagCompound nbt = is.getTagCompound();

		if (te != null && te instanceof TileEntityCnstorDoors && nbt != null) {

			if (nbt.hasKey("SubID")) {
				((TileEntityCnstorDoors)te).setSubID((int)nbt.getByte("SubID"));
			}

			if (nbt.hasKey("ColorBlock")) {
				((TileEntityCnstorDoors)te).setColorBlock(nbt.getInteger("ColorBlock"));
			}

			if (entity instanceof EntityPlayer) {
				((TileEntityCnstorDoors)te).setOwner(((EntityPlayer)entity).getDisplayName());
			}

		}
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float hitX, float hitY, float hitZ) {
		int ib = 0;
		TileEntity te = world.getTileEntity(x, y, z);
		//if (!world.isRemote) {return false;}
		if (te == null || player.isSneaking()) {return false;}

		if (te != null && te instanceof TileEntityCnstorDoors) {
			ItemStack current = player.getCurrentEquippedItem();

			if (ib == 0) {//

				if (current != null && current.getItem() == PackFurniture.proxy.item.items_for_furniture) {
					//if (!player.capabilities.isCreativeMode) {--current.stackSize;}
					NBTTagCompound nbt = current.getTagCompound();
					if (nbt != null && nbt.hasKey("CordX") && nbt.hasKey("CordY") && nbt.hasKey("CordZ")) {
						if (nbt.getInteger("CordX") == x && nbt.getInteger("CordY") == y && nbt.getInteger("CordZ") == z) {
							((TileEntityCnstorDoors)te).openDoor(true);
						} else {
							//if (world.isRemote) {player.addChatMessage("This key does not fit into this door.");}
							return false;
						}
					} else {
						if (nbt == null) {nbt = new NBTTagCompound();}
						nbt.setInteger("CordX", x);
						nbt.setInteger("CordY", y);
						nbt.setInteger("CordZ", z);
						current.setTagCompound(nbt);
					}
				}

			}//

			if (ib == 1) {//

				if (world.provider.isDaytime()) {
					if (player.getDisplayName().equals(((TileEntityCnstorDoors)te).getOwner())) {
						((TileEntityCnstorDoors)te).openDoor(true);
					} else {
						return false;
					}
				} else {
					((TileEntityCnstorDoors)te).openDoor(true);
				}

			}//

			if (current != null && current.getItem() instanceof ItemAxe) {
				current.setItemDamage(current.getItemDamage() + 1);
				((TileEntityCnstorDoors)te).breakDoor(true);
			}

			return true;
		}

		return false;
	}

	@Override
	public void onBlockHarvested(World world, int x, int y, int z, int meta, EntityPlayer player) {
		if (!world.isRemote) {
			TileEntity te = world.getTileEntity(x, y, z);
			if (te != null && te instanceof TileEntityCnstorDoors && !player.capabilities.isCreativeMode) {
				dropBlockAsItem(world, x, y, z, addNBT(world.getBlock(x, y, z), ((TileEntityCnstorDoors)te).getSubID(), ((TileEntityCnstorDoors)te).getColorBlock()));
				world.removeTileEntity(x, y, z);
				world.setBlockToAir(x, y, z);
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item id, CreativeTabs table, List list) {

		list.add(addNBT(id, 0, 0xFFFFFF));

		//list.add(new ItemStack(id, 1, 0));
	}

	public static ItemStack addNBT(Block par1, int par2, int par3) {
		return addNBT(Item.getItemFromBlock(par1), par2, par3);
	}

	public static ItemStack addNBT(Item par1, int par2, int par3) {
		ItemStack is = new ItemStack(par1, 1, 0);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setByte("SubID", (byte)par2);
		nbt.setInteger("ColorBlock", par3);
		is.setTagCompound(nbt);
		return is;
	}
	/*
@SideOnly(Side.CLIENT)
public void registerBlockIcons(IIconRegister ir) {
icon_array = new IIcon[type_block.length];
blockIcon = ir.registerIcon("planks_oak");
for (int i = 0; i < icon_array.length; ++i) {
icon_array[i] = ir.registerIcon("timaxa007:" + "wood/" + type_block[i] + "_overlay");
}
}
	 */
}
