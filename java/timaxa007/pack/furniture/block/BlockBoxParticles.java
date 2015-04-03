package timaxa007.pack.furniture.block;

import java.util.List;
import java.util.Random;

import timaxa007.pack.furniture.PackFurniture;
import timaxa007.pack.furniture.tile.TileEntityBoxParticles;
import timaxa007.tms.util.ModifiedBlock;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBoxParticles extends ModifiedBlock implements ITileEntityProvider {

	public BlockBoxParticles(String tag) {
		super(tag, Material.rock);
		setCreativeTab(PackFurniture.tab_furniture);
		setHardness(0.35F);
		setBlockTextureName("planks_oak");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityBoxParticles();
	}

	public int getRenderType() {
		return PackFurniture.render.block_box_particles_modelID;
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
		TileEntity te=world.getTileEntity(x, y, z);
		if (te != null && te instanceof TileEntityBoxParticles) {
			return addNBT(0, ((TileEntityBoxParticles)te).getStyle());
		}
		return null;
	}

	public void updateTick(World world, int x, int y, int z, Random random) {

	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
		TileEntity te = world.getTileEntity(x, y, z);
		NBTTagCompound nbt = is.getTagCompound();
		if (te != null && te instanceof TileEntityBoxParticles) {

			int l = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			((TileEntityBoxParticles)te).setRot(l);

			if (nbt != null) {
				if (nbt.hasKey("Style")) ((TileEntityBoxParticles)te).setStyle(nbt.getString("Style"));
			}

		}
	}
	/*
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random random) {
		TileEntity te = world.getTileEntity(x, y, z);
		if (te != null) {
			String listP[] = new String[] {
					"smoke", 
					"flame", 
					"largesmoke", 
					"cloud", 
					"hugeexplosion", 
					"splash", 
					"dripWater", 
					"bubble", 
					"portal", 
					"enchantmenttable", 
					"lava", 
					"slime", 
					"explode", 
					"largeexplode", 
					"largesmoke", 
					"note", 
					"reddust", 
					"heart", 
					"snowshovel", 
					"snowballpoof", 
					"hugeexplosion", 
					"fireworksSpark", 
					"witchFurniture", 
					"happyVillager"
			};
			//int l=world.getBlockMetadata(x, y, z);
			int l=5;

			if (l>0) {
				double d0 = (double)x+0.5D+((double)random.nextFloat()-0.5D)*0.2D;
				//double d1=(double)((float)y+0.0625F);
				double d1 = (double)((float)y+0.625F);
				double d2 = (double)z+0.5D+((double)random.nextFloat()-0.5D)*0.2D;
				float f = (float)l/15.0F;
				float f1 = f*0.6F+0.4F;

				if (l == 0) {f1=0.0F;}

				float f2 = f * f * 0.7F - 0.5F;
				float f3 = f * f * 0.6F - 0.7F;

				if (f2<0.0F) {f2=0.0F;}
				if (f3<0.0F) {f3=0.0F;}
				if (((TileEntityBoxParticles)te).getStyles() < listP.length) {
					world.spawnParticle(listP[((TileEntityBoxParticles)te).getStyles()], d0, d1, d2, (double)f2, (double)f1, (double)f3);
				}
			}
		}
	}
	 */
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item id, CreativeTabs table, List list) {
		//for(int j = 0; j < TileTexture.tt.length; ++j) {
		//for(int i = 0; i < 16; ++i) {
		String j = "";

		list.add(addNBT(0, j));
		//}
		//}
		//list.add(new ItemStack(id, 1, 0));
	}

	public static ItemStack addNBT(int par1, String par2) {
		ItemStack is = new ItemStack(PackFurniture.block.box_particles, 1, par1);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setString("Style", par2);
		is.setTagCompound(nbt);
		return is;
	}


}
