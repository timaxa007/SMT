package timaxa007.pack.furniture.block;

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
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import timaxa007.gui.HelperGui;
import timaxa007.pack.furniture.PackFurniture;
import timaxa007.pack.furniture.tile.TileEntityGrills;
import timaxa007.smt.object.ModifiedBlock;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockGrills extends ModifiedBlock implements ITileEntityProvider {

	private static boolean keepFurnaceInventory;
	private final Random furnaceRand = new Random();
	private boolean isActive;

	public BlockGrills(String tag) {
		super(tag, Material.iron);
		setHardness(0.5F);
		setCreativeTab(PackFurniture.tab_furniture);
		setBlockTextureName("planks_oak");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityGrills();
	}

	public int getRenderType() {
		return PackFurniture.render.block_grills_modelID;
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
		if (te != null && te instanceof TileEntityGrills) return addNBT(((TileEntityGrills)te).getStyle());
		return null;
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		TileEntity te = world.getTileEntity(x, y, z);
		if (te == null || player.isSneaking()) return false;
		if (te != null && te instanceof TileEntityGrills) {
			HelperGui.openGui(HelperGui.GuiID.GRILLS, player);
			return true;
		}
		return super.onBlockActivated(world, x, y, z, player, side, hitX, hitY, hitZ);
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
		TileEntity te = world.getTileEntity(x, y, z);
		NBTTagCompound nbt = is.getTagCompound();
		if (te != null && te instanceof TileEntityGrills) {

			int l = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F/ 360.0F) + 0.5D) & 3;
			((TileEntityGrills)te).setRot(l);

			if (nbt != null) {
				if (nbt.hasKey("Style")) ((TileEntityGrills)te).setStyle(nbt.getString("Style"));
			}

		}
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item id, CreativeTabs table, List list) {
		//for(int j = 0; j < TileTexture.tt01.length; ++j) {
		String j = "";
		list.add(addNBT(j));
		//}
		//list.add(new ItemStack(id, 1, 0));
	}

	public static ItemStack addNBT(String par1) {
		ItemStack is = new ItemStack(PackFurniture.block.grills, 1, 0);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setString("Style", par1);
		is.setTagCompound(nbt);
		return is;
	}

}
