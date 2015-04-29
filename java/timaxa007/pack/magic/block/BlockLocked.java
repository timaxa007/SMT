package timaxa007.pack.magic.block;

import java.util.List;

import timaxa007.pack.magic.PackMagic;
import timaxa007.pack.magic.tile.TileEntityBlockLocked;
import timaxa007.tms.object.ModifiedBlock;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockLocked extends ModifiedBlock implements ITileEntityProvider {

	public BlockLocked(String tag) {
		super(tag, Material.iron);
		setCreativeTab(PackMagic.tab_magic);
		setBlockUnbreakable();
		setBlockTextureName("planks_oak");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityBlockLocked();
	}

	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(x, y, z);
		if (te != null && te instanceof TileEntityBlockLocked) {
			TileEntityBlockLocked tile = (TileEntityBlockLocked)te;
			addNBT(tile.getType());
		}
		return null;
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
		TileEntity te = world.getTileEntity(x, y, z);
		NBTTagCompound nbt = is.getTagCompound();
		if (te != null && te instanceof TileEntityBlockLocked) {
			TileEntityBlockLocked tile = (TileEntityBlockLocked)te;

			if (nbt != null) {
				if (nbt.hasKey("Type")) tile.setType(nbt.getInteger("Type"));
			}

			if (entity instanceof EntityPlayer) {
				tile.setOwner(((EntityPlayer)entity).getDisplayName());
			}

		}
	}

	/*
	public void harvestBlock(World world, EntityPlayer player, int x, int y, int z, int meta) {
		super.harvestBlock(world, player, x, y, z, meta);
	}
	 */

	public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player) {
		TileEntity te = world.getTileEntity(x, y, z);
		if (te != null && te instanceof TileEntityBlockLocked) {
			TileEntityBlockLocked tile = (TileEntityBlockLocked)te;
			if (!world.isRemote) {
				if (player.getDisplayName().equals(tile.getOwner())) {
					//world.setBlockToAir(x, y, z);
					//world.spawnEntityInWorld(new EntityItem(world, (double)x + 0.5D, (double)y + 0.5D, (double)z + 0.5D, addNBT(((TileEntityBlockLocked)te).getType())));
				}
			}
		}
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		TileEntity te = world.getTileEntity(x, y, z);
		if (te != null && te instanceof TileEntityBlockLocked) {
			TileEntityBlockLocked tile = (TileEntityBlockLocked)te;
			if (world.isRemote) {
				//player.addChatMessage("Install Block user - " + tile.getOwner() + ".");
				return true;
			}
		}
		return false;
	}

	public void onBlockHarvested(World world, int x, int y, int z, int meta, EntityPlayer player) {
		TileEntity te = world.getTileEntity(x, y, z);
		if (te != null && te instanceof TileEntityBlockLocked) {
			TileEntityBlockLocked tile = (TileEntityBlockLocked)te;
			if (player.getDisplayName().equals(tile.getOwner())) {
				System.out.println("true");
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item id, CreativeTabs table, List list) {
		list.add(addNBT(0));
	}

	public static ItemStack addNBT(int par1) {
		ItemStack is = new ItemStack(PackMagic.block.magic_locked, 1, 0);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setInteger("Type", par1);
		is.setTagCompound(nbt);
		return is;
	}

}
