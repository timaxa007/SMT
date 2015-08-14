package timaxa007.pack.magic.block;

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
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import timaxa007.pack.magic.PackMagic;
import timaxa007.pack.magic.tile.TileEntityMagicSpawner;
import timaxa007.pack.conjoint.object.ModifiedBlock;
import timaxa007.smt.util.UtilSMT;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockMagicSpawner extends ModifiedBlock implements ITileEntityProvider {

	public BlockMagicSpawner(String tag) {
		super(tag, Material.iron);
		setCreativeTab(PackMagic.tab_magic);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {return new TileEntityMagicSpawner(world);}

	public int quantityDropped(Random random) {return 0;}
	public boolean isOpaqueCube() {return false;}
	public int idPicked(World world, int x, int y, int z) {return 0;}

	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(x, y, z);
		if (te != null && te instanceof TileEntityMagicSpawner) {
			TileEntityMagicSpawner tile = (TileEntityMagicSpawner)te;
			//return addNBT(tile.getSubID(), tile.getColorBlock());
		}
		return null;
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
		TileEntity te = world.getTileEntity(x, y, z);
		NBTTagCompound nbt = is.getTagCompound();

		if (te != null && te instanceof TileEntityMagicSpawner && nbt != null) {
			TileEntityMagicSpawner tile = (TileEntityMagicSpawner)te;

			/*if (nbt.hasKey("ColorBlock"))
				tile.setColorBlock(nbt.getInteger("ColorBlock"));*/

			if (entity instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer)entity;
				//tile.setOwner(player.getDisplayName());
			}

		}
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		TileEntity te = world.getTileEntity(x, y, z);
		if (te == null || player.isSneaking()) return false;
		if (te != null && te instanceof TileEntityMagicSpawner) {
			TileEntityMagicSpawner tile = (TileEntityMagicSpawner)te;
			ItemStack current = player.getCurrentEquippedItem();

			//return true;
		}

		return super.onBlockActivated(world, x, y, z, player, side, hitX, hitY, hitZ);
	}

	@Override
	public void onBlockHarvested(World world, int x, int y, int z, int meta, EntityPlayer player) {
		if (!world.isRemote) {
			TileEntity te = world.getTileEntity(x, y, z);
			if (te != null && te instanceof TileEntityMagicSpawner && !player.capabilities.isCreativeMode) {
				TileEntityMagicSpawner tile = (TileEntityMagicSpawner)te;
				UtilSMT.UtilWorld.breakupBlock(world, x, y, z, addNBT());
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item id, CreativeTabs table, List list) {
		//list.add(addNBT(0));
	}

	public static ItemStack addNBT() {
		ItemStack is = new ItemStack(PackMagic.block.magic_spawner, 1, 0);
		NBTTagCompound nbt = new NBTTagCompound();
		//nbt.setByte("SubID", (byte)par2);
		is.setTagCompound(nbt);
		return is;
	}
}
