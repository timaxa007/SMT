package timaxa007.pack.techno.block;

import java.util.Random;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import timaxa007.gui.HandlerGuiSMT;
import timaxa007.pack.techno.PackTechno;
import timaxa007.pack.techno.tile.TileEntityElectricMachines;
import timaxa007.smt.CoreSMT;
import timaxa007.smt.object.ModifiedBlock;

public class BlockElectricMachines extends ModifiedBlock implements ITileEntityProvider {

	public BlockElectricMachines(String tag) {
		super(tag, Material.iron);
		setCreativeTab(PackTechno.tab_techno);
		setHardness(0.5F);
		setResistance(1.0F);
		setBlockTextureName("planks_oak");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityElectricMachines();
	}

	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
		TileEntity te = world.getTileEntity(x, y, z);
		NBTTagCompound nbt = is.getTagCompound();
		if (te != null && te instanceof TileEntityElectricMachines) {
			TileEntityElectricMachines tile = (TileEntityElectricMachines)te;

			int l = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			tile.setRot(l);

			if (nbt != null) {
				if (nbt.hasKey("Type")) tile.setType(nbt.getInteger("Type"));
			}

			if (entity instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer)entity;
				tile.setOwner(player.getCommandSenderName());
			}
			/*
			if (is.hasDisplayName()) {
				((TileEntityElectricMachines)te).setGuiDisplayName(is.getDisplayName());
			}
			 */
		}
	}

	public void onNeighborBlockChange(World world, int x, int y, int z, int par5) {
		if (!world.isRemote) {
			if (world.isBlockIndirectlyGettingPowered(x, y, z)) {

				desBreak(world, x, y, z);

			}
		}
	}

	public void updateTick(World world, int x, int y, int z, Random rdm) {
		if (!world.isRemote && !world.isBlockIndirectlyGettingPowered(x, y, z)) {

			//desBreak(world, x, y, z);

		}
	}

	private void desBreak(World world, int x, int y, int z) {
		++x;
		//world.destroyBlock(x, y, z, true);
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		TileEntity te = world.getTileEntity(x, y, z);

		if (te == null || player.isSneaking()) return false;

		if (te != null && te instanceof TileEntityElectricMachines) {
			player.openGui(CoreSMT.instance, HandlerGuiSMT.electric_machines, world, x, y, z);
			return true;
		}

		return super.onBlockActivated(world, x, y, z, player, side, hitX, hitY, hitZ);
	}

}
