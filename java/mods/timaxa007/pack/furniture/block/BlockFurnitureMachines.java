package mods.timaxa007.pack.furniture.block;

import mods.timaxa007.pack.furniture.PackFurniture;
import mods.timaxa007.pack.furniture.tile.TileEntityFurnitureMachines;
import mods.timaxa007.tms.util.BlockFixReg;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockFurnitureMachines extends BlockFixReg implements ITileEntityProvider {

	public BlockFurnitureMachines(String tag) {
		super(tag, Material.rock);
		setCreativeTab(PackFurniture.tab_furniture);
		setHardness(1.0F);
		setResistance(3.5F);
		setBlockTextureName("stone");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityFurnitureMachines();
	}

	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
		TileEntity te = world.getTileEntity(x, y, z);
		NBTTagCompound tag = is.getTagCompound();
		if (te != null && te instanceof TileEntityFurnitureMachines) {

			int l = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			((TileEntityFurnitureMachines)te).setRotation(l);

			if (tag != null) {
				if (tag.hasKey("Type")) ((TileEntityFurnitureMachines)te).setType(tag.getInteger("Type"));
			}
			/*
			if (is.hasDisplayName()) {
				((TileEntityFurnitureMachines)te).setGuiDisplayName(is.getDisplayName());
			}
			 */
		}
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		TileEntity te = world.getTileEntity(x, y, z);
		//if (!world.isRemote) {return false;}
		if (player.isSneaking()) {return false;}
		if (te != null && te instanceof TileEntityFurnitureMachines) {
			player.openGui(PackFurniture.instance, PackFurniture.proxy.gui_furniture_machines, world, x, y, z);
			return true;
		}
		return false;
	}

}
