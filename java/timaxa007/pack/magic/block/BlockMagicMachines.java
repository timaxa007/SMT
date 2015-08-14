package timaxa007.pack.magic.block;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import timaxa007.gui.HandlerGui;
import timaxa007.pack.magic.PackMagic;
import timaxa007.pack.magic.tile.TileEntityMagicMachines;
import timaxa007.pack.conjoint.object.ModifiedBlock;

public class BlockMagicMachines extends ModifiedBlock implements ITileEntityProvider {

	public BlockMagicMachines(String tag) {
		super(tag, Material.rock);
		setCreativeTab(PackMagic.tab_magic);
		setHardness(0.5F);
		setResistance(1.0F);
		setBlockTextureName("planks_oak");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityMagicMachines(world);
	}

	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
		TileEntity te = world.getTileEntity(x, y, z);
		NBTTagCompound nbt = is.getTagCompound();
		if (te != null && te instanceof TileEntityMagicMachines) {
			TileEntityMagicMachines tile = (TileEntityMagicMachines)te;

			int l = MathHelper.floor_double((double)(entity.rotationYaw*4.0F/360.0F)+0.5D)&3;
			tile.setRot(l);

			if (nbt != null) {
				if (nbt.hasKey("Type")) tile.setType(nbt.getInteger("Type"));
			}
			/*
			if (is.hasDisplayName()) {
				((TileEntityMagicMachines)te).setGuiDisplayName(is.getDisplayName());
			}
			 */
		}
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		TileEntity te = world.getTileEntity(x, y, z);

		if (te == null || player.isSneaking()) return false;

		if (te != null && te instanceof TileEntityMagicMachines) {
			HandlerGui.openGui(HandlerGui.GuiID.MAGIC_MACHINES, player);
			return true;
		}

		return super.onBlockActivated(world, x, y, z, player, side, hitX, hitY, hitZ);
	}

}
