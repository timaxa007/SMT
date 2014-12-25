package mods.timaxa007.pack.mining.block;

import java.util.List;

import mods.timaxa007.lib.GetColors;
import mods.timaxa007.pack.mining.PackMining;
import mods.timaxa007.pack.mining.tile.TileEntityCristals;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCristals extends Block implements ITileEntityProvider {

	public BlockCristals() {
		super(Material.glass);
		setCreativeTab(PackMining.tab_mining);
		setHardness(0.25F);
		setLightOpacity(0);
		setBlockTextureName("glass");
		setBlockName("cristals");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityCristals();
	}

	public int getRenderType() {
		return PackMining.proxy.render.block_cristals_modelID;
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
		if (te != null && te instanceof TileEntityCristals)
			return addTag(((TileEntityCristals)te).getType(), ((TileEntityCristals)te).getColor(), ((TileEntityCristals)te).getSize());
		return null;
	}


	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
		TileEntity te = world.getTileEntity(x, y, z);
		NBTTagCompound tag = is.getTagCompound();
		if (te != null && te instanceof TileEntityCristals) {
			/*
			int l=MathHelper.floor_double((double)(entity.rotationYaw*4.0F/360.0F)+0.5D)&3;
			((TileEntityCristals)te).setRot(l);
			 */
			if (tag != null) {
				if (tag.hasKey("Type")) ((TileEntityCristals)te).setType(tag.getInteger("Type"));
				if (tag.hasKey("Color")) ((TileEntityCristals)te).setColor(tag.getInteger("Color"));
				if (tag.hasKey("Size")) ((TileEntityCristals)te).setSize(tag.getInteger("Size"));
			}

		}
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item id, CreativeTabs table, List list) {
		for (int t = 0; t < 3; ++t) {
			for (int c = 0; c < GetColors.getHexColors.length; ++c) {
				for (int s = 1; s < 5; ++s) {
					list.add(addTag(t, GetColors.getHexColors[c], s));
				}
			}
		}
		//list.add(new ItemStack(id, 1, 0));
	}

	private static ItemStack addTag(int par1, int par2, int par3) {
		ItemStack is = new ItemStack(PackMining.proxy.block.cristals, 1, 0);
		NBTTagCompound tag = new NBTTagCompound();
		tag.setInteger("Type", par1);
		tag.setInteger("Color", par2);
		tag.setInteger("Size", par3);
		is.setTagCompound(tag);
		return is;
	}

}
