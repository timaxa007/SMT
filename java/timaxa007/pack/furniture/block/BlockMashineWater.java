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
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import timaxa007.pack.furniture.PackFurniture;
import timaxa007.pack.furniture.tile.TileEntityMashineWater;
import timaxa007.tms.CoreTMS;
import timaxa007.tms.util.ModifiedBlock;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockMashineWater extends ModifiedBlock implements ITileEntityProvider {

	public BlockMashineWater(String tag) {
		super(tag, Material.iron);
		setCreativeTab(PackFurniture.tab_furniture);
		setHardness(0.25F);
		setLightOpacity(0);
		setBlockTextureName("glass");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityMashineWater();
	}

	public int getRenderType() {
		return PackFurniture.render.block_jar01_modelID;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public int idPicked(World world, int x, int y, int z) {
		return 0;
	}

	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(x, y, z);
		if (te != null && te instanceof TileEntityMashineWater) {
			return addNBT(((TileEntityMashineWater)te).getColor(), ((TileEntityMashineWater)te).getPart());
		}
		return null;
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
		TileEntity te = world.getTileEntity(x, y, z);
		NBTTagCompound nbt = is.getTagCompound();
		if (te != null && te instanceof TileEntityMashineWater) {
			/*
			int l = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			((TileEntityMashineWater)te).setRot(l);
			 */
			if (nbt != null) {
				if (nbt.hasKey("ColorHex")) ((TileEntityMashineWater)te).setColor(nbt.getInteger("ColorHex"));
				if (nbt.hasKey("Part")) ((TileEntityMashineWater)te).setPart(nbt.getBoolean("Part"));
			}

		}
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		TileEntity te = world.getTileEntity(x, y, z);
		if (te != null && te instanceof TileEntityMashineWater) {
			player.openGui(CoreTMS.instance, PackFurniture.gui_mashine_water, world, x, y, z);
			return true;
		}
		return false;
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item id, CreativeTabs table, List list) {
		list.add(addNBT(0xFFFFFF, true));
		list.add(addNBT(0xFFFFFF, false));
		//list.add(new ItemStack(id, 1, 0));
	}

	public static ItemStack addNBT(int par1, boolean par2) {
		ItemStack is = new ItemStack(PackFurniture.block.mashine_waiter, 1, par1);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setInteger("ColorHex", par1);
		nbt.setBoolean("Part", par2);
		is.setTagCompound(nbt);
		return is;
	}

}
