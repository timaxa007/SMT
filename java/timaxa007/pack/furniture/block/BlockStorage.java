package timaxa007.pack.furniture.block;

import java.util.List;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import timaxa007.gui.HelperGui;
import timaxa007.pack.furniture.PackFurniture;
import timaxa007.pack.furniture.tile.TileEntityStorage;
import timaxa007.smt.lib.ActionModel;
import timaxa007.smt.object.ModifiedBlock;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockStorage extends ModifiedBlock implements ITileEntityProvider {

	public BlockStorage(String tag) {
		super(tag, Material.rock);
		setCreativeTab(PackFurniture.tab_furniture);
		setHardness(1.0F);
		setResistance(3.5F);
		setBlockTextureName("stone");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {return new TileEntityStorage();}
	public int getRenderType() {return PackFurniture.render.block_storage_modelID;}
	public boolean isOpaqueCube() {return false;}
	public boolean renderAsNormalBlock() {return false;}

	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
		TileEntity te = world.getTileEntity(x, y, z);
		NBTTagCompound nbt = is.getTagCompound();
		if (te != null && te instanceof TileEntityStorage) {
			TileEntityStorage tile = (TileEntityStorage)te;

			tile.setRotation(ActionModel.rotation_model_4sides_invert(entity.rotationYaw));

			if (nbt != null) {
				if (nbt.hasKey("NameID")) tile.setTag(nbt.getString("NameID"));
			}

			if (entity instanceof EntityPlayer)
				tile.setOwner(((EntityPlayer)entity).getCommandSenderName());

			if (is.hasDisplayName())
				tile.setCustomName(is.getDisplayName());

		}
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		TileEntity te = world.getTileEntity(x, y, z);
		if (te == null || player.isSneaking()) return false;
		if (te != null && te instanceof TileEntityStorage) {
			if (!world.isRemote) HelperGui.openGui(HelperGui.GuiID.STORAGE, player);
			return true;
		}

		return super.onBlockActivated(world, x, y, z, player, side, hitX, hitY, hitZ);
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item id, CreativeTabs table, List list) {
		list.add(addNBT("0", "0"));
		//list.add(new ItemStack(id, 1, 0));
	}

	public static ItemStack addNBT(String par1, String par2) {
		ItemStack is = new ItemStack(PackFurniture.block.storage, 1, 0);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setString("NameID", par1);
		nbt.setString("Style", par2);
		is.setTagCompound(nbt);
		return is;
	}

}
