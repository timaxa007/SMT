package mods.timaxa007.pack.furniture.block;

import java.util.List;
import java.util.Random;

import mods.timaxa007.pack.furniture.PackFurniture;
import mods.timaxa007.pack.furniture.tile.TileEntityGrills;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockGrills extends BlockContainer {
	private static boolean keepFurnaceInventory;
	private final Random furnaceRand = new Random();
	private boolean isActive;

	public BlockGrills() {
		super(Material.iron);
		setHardness(0.5F);
		setCreativeTab(PackFurniture.tab_furniture);
		setBlockTextureName("planks_oak");
		setBlockName("grills");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityGrills();
	}

	public int getRenderType() {
		return PackFurniture.proxy.render.block_grills_modelID;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public int idPicked(World world, int x, int y, int z) {
		return 0;
	}

	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(x, y, z);
		if (te != null && te instanceof TileEntityGrills) return addTag(((TileEntityGrills)te).getStyle());
		return null;
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		TileEntity te = world.getTileEntity(x, y, z);
		//if (!world.isRemote) {return false;}
		if (player.isSneaking()) {return false;}
		if (te != null && te instanceof TileEntityGrills) {
			player.openGui(PackFurniture.instance, PackFurniture.proxy.gui_grills, world, x, y, z);
			return true;
		}
		return false;
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
		TileEntity te = world.getTileEntity(x, y, z);
		NBTTagCompound tag = is.getTagCompound();
		if (te != null && te instanceof TileEntityGrills) {

			int l = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F/ 360.0F) + 0.5D) & 3;
			((TileEntityGrills)te).setRot(l);

			if (tag != null) {
				if (tag.hasKey("Style")) ((TileEntityGrills)te).setStyle(tag.getString("Style"));
			}

		}
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item id, CreativeTabs table, List list) {
		//for(int j = 0; j < TileTexture.tt01.length; ++j) {
		String j = "";
		list.add(addTag(j));
		//}
		//list.add(new ItemStack(id, 1, 0));
	}

	private static ItemStack addTag(String par1) {
		ItemStack is = new ItemStack(PackFurniture.proxy.block.grills, 1, 0);
		NBTTagCompound tag = new NBTTagCompound();
		tag.setString("Style", par1);
		is.setTagCompound(tag);
		return is;
	}

}
