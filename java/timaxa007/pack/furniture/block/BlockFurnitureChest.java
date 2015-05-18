package timaxa007.pack.furniture.block;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import timaxa007.pack.furniture.PackFurniture;
import timaxa007.pack.furniture.tile.TileEntityFurnitureChest;
import timaxa007.smt.CoreSMT;
import timaxa007.smt.lib.ActionModel;
import timaxa007.smt.object.ModifiedBlock;

public class BlockFurnitureChest extends ModifiedBlock implements ITileEntityProvider {

	public BlockFurnitureChest(String tag) {
		super(tag, Material.wood);
		setCreativeTab(PackFurniture.tab_furniture);
		setHardness(1.0F);
		setResistance(3.5F);
		setBlockTextureName("stone");
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
		return PackFurniture.render.block_furniture_chest_modelID;
	}

	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
		TileEntity te = world.getTileEntity(x, y, z);
		NBTTagCompound nbt = is.getTagCompound();
		if (te != null && te instanceof TileEntityFurnitureChest) {
			TileEntityFurnitureChest tile = (TileEntityFurnitureChest)te;

			tile.setRotation(ActionModel.rotation_model_4sides(entity.rotationYaw));

			if (nbt != null) {
				if (nbt.hasKey("NameID")) tile.setTag(nbt.getString("NameID"));
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
			player.openGui(CoreSMT.instance, PackFurniture.gui_furniture_chest, world, x, y, z);
			return true;
		}
		return false;
	}

}
