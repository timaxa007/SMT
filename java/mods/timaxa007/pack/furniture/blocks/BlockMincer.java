package mods.timaxa007.pack.furniture.blocks;

import java.util.Random;

import mods.timaxa007.pack.furniture.PackFurniture;
import mods.timaxa007.pack.furniture.tile.TileEntityMincer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockMincer extends BlockContainer{
	private static boolean keepFurnaceInventory;
	private final Random furnaceRand = new Random();
	private boolean isActive;

	public BlockMincer() {
		super(Material.iron);
		setStepSound(soundTypeMetal);
		setCreativeTab(PackFurniture.tab_furniture);
		setHardness(0.5F);
		setBlockTextureName("iron_block");
		setBlockName("mincer");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityMincer();
	}
	
	public int getRenderType() {
		return PackFurniture.proxy.render_block_mincer_modelID;
	}
	
	public boolean isOpaqueCube() {
		return false;
	}
	
	public boolean renderAsNormalBlock() {
		return false;
	}

	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
		int i1 = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		world.setBlock(x, y, z, this, i1, 3);
		/*if (is.hasDisplayName()) {
		((TileEntityMincer)world.getTileEntity(x, y, z)).setGuiDisplayName(is.getDisplayName());
		}*/
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		TileEntity te = world.getTileEntity(x, y, z);
		//if (!world.isRemote) {return false;}
		if (player.isSneaking()) {return false;}
		if (te != null && te instanceof TileEntityMincer) {
			player.openGui(PackFurniture.instance, PackFurniture.proxy.gui_mincer, world, x, y, z);
			return true;
		}
		return false;
	}

	public void breakBlock(World world, int x, int y, int z, Block blkid, int blkmeta) {
		if (!keepFurnaceInventory) {
			TileEntityMincer tileentityfurnace = (TileEntityMincer)world.getTileEntity(x, y, z);

			if (tileentityfurnace != null) {
				for (int j1 = 0; j1 < tileentityfurnace.getSizeInventory(); ++j1) {
					ItemStack itemstack = tileentityfurnace.getStackInSlot(j1);

					if (itemstack!=null) {
						float f=furnaceRand.nextFloat()*0.8F+0.1F;
						float f1=furnaceRand.nextFloat()*0.8F+0.1F;
						float f2=furnaceRand.nextFloat()*0.8F+0.1F;

						while (itemstack.stackSize>0) {
							int k1=furnaceRand.nextInt(21)+10;

							if (k1>itemstack.stackSize) {k1=itemstack.stackSize;}

							itemstack.stackSize-=k1;
							EntityItem entityitem = new EntityItem(world, (double)((float)x+f), (double)((float)y+f1), (double)((float)z+f2), new ItemStack(itemstack.getItem(), k1, itemstack.getItemDamage()));

							if (itemstack.hasTagCompound()) {
								entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
							}

							float f3=0.05F;
							entityitem.motionX=(double)((float)furnaceRand.nextGaussian()*f3);
							entityitem.motionY=(double)((float)furnaceRand.nextGaussian()*f3+0.2F);
							entityitem.motionZ=(double)((float)furnaceRand.nextGaussian()*f3);
							world.spawnEntityInWorld(entityitem);
						}
					}
				}

			}
		}

		super.breakBlock(world, x, y, z, blkid, blkmeta);
	}

	public static void updateFurnaceBlockState(boolean par0, World world, int x, int y, int z) {
		int l=world.getBlockMetadata(x, y, z);
		TileEntity tileentity = world.getTileEntity(x, y, z);
		keepFurnaceInventory = true;
		/*
if (par0) {
world.setBlock(x, y, z, PackFurniture.blockMincer);
}
else
{
world.setBlock(x, y, z, PackFurniture.blockMincer);
}
		 */
		keepFurnaceInventory=false;
		world.setBlockMetadataWithNotify(x, y, z, l, 2);

		if (tileentity!=null) {
			tileentity.validate();
			world.setTileEntity(x, y, z, tileentity);
		}
	}

}
