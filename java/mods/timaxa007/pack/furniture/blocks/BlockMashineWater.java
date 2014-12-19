package mods.timaxa007.pack.furniture.blocks;

import java.util.List;

import mods.timaxa007.lib.GetColors;
import mods.timaxa007.pack.furniture.PackFurniture;
import mods.timaxa007.pack.furniture.tile.TileEntityMashineWater;
import net.minecraft.block.Block;
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
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockMashineWater extends Block implements ITileEntityProvider {

	public BlockMashineWater() {
		super(Material.iron);
		setCreativeTab(PackFurniture.tab_furniture);
		setHardness(0.25F);
		setLightOpacity(0);
		setBlockTextureName("glass");
		setBlockName("masine_water");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityMashineWater();
	}

	public int getRenderType() {
		return PackFurniture.proxy.render_block_jar01_modelID;
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
			return addTag(((TileEntityMashineWater)te).getColor(), ((TileEntityMashineWater)te).getPart());
		}
		return null;
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
		TileEntity te = world.getTileEntity(x, y, z);
		NBTTagCompound tag = is.getTagCompound();
		if (te != null && te instanceof TileEntityMashineWater) {
			/*
			int l = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			((TileEntityMashineWater)te).setRot(l);
			 */
			if (tag != null) {
				if (tag.hasKey("Color")) ((TileEntityMashineWater)te).setColor(tag.getInteger("Color"));
				if (tag.hasKey("Part")) ((TileEntityMashineWater)te).setPart(tag.getBoolean("Part"));
			}

		}
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		TileEntity te = world.getTileEntity(x, y, z);
		if (te != null && te instanceof TileEntityMashineWater) {
			player.openGui(PackFurniture.instance, PackFurniture.proxy.gui_mashine_water, world, x, y, z);
			return true;
		}
		return false;
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item id, CreativeTabs table, List list) {
		//for (int j = 0; j < 16; ++j) {
		int j = 14;
		list.add(addTag(GetColors.getHexColors[j], true));
		list.add(addTag(GetColors.getHexColors[j], false));
		//}
		//list.add(new ItemStack(id, 1, 0));
	}

	private static ItemStack addTag(int par1, boolean par2) {
		ItemStack is = new ItemStack(PackFurniture.proxy.block_mashine_waiter, 1, par1);
		NBTTagCompound tag = new NBTTagCompound();
		tag.setInteger("Color", par1);
		tag.setBoolean("Part", par2);
		is.setTagCompound(tag);
		return is;
	}

}
