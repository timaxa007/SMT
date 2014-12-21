package mods.timaxa007.pack.furniture.block;

import mods.timaxa007.lib.ActionModel;
import mods.timaxa007.pack.furniture.PackFurniture;
import mods.timaxa007.pack.furniture.tile.TileEntityFurnitureChest;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockFurnitureChest extends BlockContainer {

	public BlockFurnitureChest() {
		super(Material.wood);
		setCreativeTab(PackFurniture.tab_furniture);
		setHardness(1.0F);
		setResistance(3.5F);
		setBlockTextureName("stone");
		setBlockName("furniture.machines");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityFurnitureChest();
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public int getRenderType() {
		return PackFurniture.proxy.render_block_furniture_chest_modelID;
	}

	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
		TileEntity te = world.getTileEntity(x, y, z);
		NBTTagCompound tag = is.getTagCompound();
		if (te != null && te instanceof TileEntityFurnitureChest) {
			TileEntityFurnitureChest tile = (TileEntityFurnitureChest)te;

			tile.setRotation(ActionModel.rotation_model_4sides(entity.rotationYaw));

			if (tag != null) {
				if (tag.hasKey("NameID")) tile.setTag(tag.getString("NameID"));
			}

			if (entity instanceof EntityPlayer) {
				tile.setOwner(((EntityPlayer) entity).getDisplayName());
			}

			if (is.hasDisplayName())
				tile.setCustomName(is.getDisplayName());

		}
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		TileEntity te = world.getTileEntity(x, y, z);
		//if (!world.isRemote) {return false;}
		if (player.isSneaking()) {return false;}
		if (te != null && te instanceof TileEntityFurnitureChest) {
			player.openGui(PackFurniture.instance, PackFurniture.proxy.gui_furniture_chest, world, x, y, z);
			return true;
		}
		return false;
	}

}
