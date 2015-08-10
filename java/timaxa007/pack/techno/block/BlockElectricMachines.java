package timaxa007.pack.techno.block;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import timaxa007.gui.HandlerGui;
import timaxa007.pack.techno.PackTechno;
import timaxa007.pack.techno.tile.TileEntityElectricMachines;
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
		return new TileEntityElectricMachines(world);
	}

	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
		TileEntity te = world.getTileEntity(x, y, z);
		NBTTagCompound nbt = is.getTagCompound();
		if (te != null && te instanceof TileEntityElectricMachines) {
			TileEntityElectricMachines tile = (TileEntityElectricMachines)te;

			if (nbt != null) {
				//if (nbt.hasKey("Type")) tile.setType(nbt.getInteger("Type"));
			}

			if (entity instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer)entity;
				tile.setOwner(player);
			}

		}
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		TileEntity te = world.getTileEntity(x, y, z);

		if (player.isSneaking()) return false;

		if (te != null && te instanceof TileEntityElectricMachines) {
			HandlerGui.openGui(HandlerGui.GuiID.ELECTRIC_MACHINES, player);
			return true;
		}

		return super.onBlockActivated(world, x, y, z, player, side, hitX, hitY, hitZ);
	}

}
