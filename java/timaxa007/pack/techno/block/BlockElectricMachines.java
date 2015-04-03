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
import timaxa007.pack.NodePack;
import timaxa007.pack.techno.PackTechno;
import timaxa007.pack.techno.tile.TileEntityElectricMachines;
import timaxa007.tms.util.ModifiedBlock;

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

			int l = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			((TileEntityElectricMachines)te).setRot(l);

			if (nbt != null) {
				if (nbt.hasKey("Type")) ((TileEntityElectricMachines)te).setType(nbt.getInteger("Type"));
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

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float hitX, float hitY, float hitZ) {
		TileEntity te = world.getTileEntity(x, y, z);

		if (player.isSneaking()) {
			return false;
		}

		if (te != null && te instanceof TileEntityElectricMachines) {
			player.openGui(NodePack.instance, PackTechno.gui_electric_machines, world, x, y, z);
			return true;
		}

		return false;
	}

}
