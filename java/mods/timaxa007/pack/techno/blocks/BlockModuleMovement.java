package mods.timaxa007.pack.techno.blocks;

import java.util.List;

import mods.timaxa007.pack.techno.PackTechno;
import mods.timaxa007.pack.techno.tile.TileEntityModuleMovement;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockModuleMovement extends Block implements ITileEntityProvider {

	public String typeModule[] = new String[] {
			"Cursor", 
			"Move", 
			"Jump"
	};

	public BlockModuleMovement() {
		super(Material.circuits);
		setCreativeTab(PackTechno.tab_techno);
		setHardness(0.5F);
		setResistance(0.1F);
		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
		setBlockTextureName("planks_oak");
		setBlockName("module.movement");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityModuleMovement();
	}

	public int getRenderType() {
		return PackTechno.proxy.render_block_module_movement_modelID;
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
		if (te != null && te instanceof TileEntityModuleMovement) return addTag(((TileEntityModuleMovement)te).getType());
		return null;
	}

	/*
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
		float f = 0.125F;
		return AxisAlignedBB.getAABBPool().getAABB((double)par2, (double)par3, (double)par4, (double)(par2 + 1), (double)((float)(par3 + 1) - f), (double)(par4 + 1));
	}
	 */
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
		TileEntity te = world.getTileEntity(x, y, z);
		if (te != null && te instanceof TileEntityModuleMovement) {
			if (((TileEntityModuleMovement)te).getType() == 0) {

				if (((TileEntityModuleMovement)te).getRot() == 3) {entity.motionX += 0.1D;}
				else if (((TileEntityModuleMovement)te).getRot() == 1) {entity.motionX -= 0.1D;}
				else if (((TileEntityModuleMovement)te).getRot() == 0) {entity.motionZ += 0.1D;}
				else if (((TileEntityModuleMovement)te).getRot() == 2) {entity.motionZ -= 0.1D;}
				else {entity.motionY += 0.1D;}

			} else if (((TileEntityModuleMovement)te).getType() == 1) {
				//entity.motionX *= 2.0D;
				if (((TileEntityModuleMovement)te).getRot() == 3) {
					if (entity.motionX > 0 && entity.motionX < 3.0D) {
						entity.motionX *= 2.1D;}
				}
				else if (((TileEntityModuleMovement)te).getRot() == 1) {
					if (entity.motionX < 0 && entity.motionX > -3.0D) {
						entity.motionX *= 2.1D;}
				}
				else if (((TileEntityModuleMovement)te).getRot() == 0) {
					if (entity.motionZ > 0 && entity.motionZ < 3.0D) {
						entity.motionZ *= 2.1D;}
				}
				else if (((TileEntityModuleMovement)te).getRot() == 2) {
					if (entity.motionZ < 0 && entity.motionZ > -3.0D) {
						entity.motionZ *= 2.1D;}
				}
				else {
					entity.motionY *= 0.1D;
				}

			} else if (((TileEntityModuleMovement)te).getType() == 2) {

				if (entity.motionY >= 0.0D && entity.motionY < 10.0D) {
					entity.motionY += 0.1D;
					//entity.motionY *= 0.1D;
				}

				if (((TileEntityModuleMovement)te).getRot() == 3) {
					entity.motionX += 0.01D;
				}
				else if (((TileEntityModuleMovement)te).getRot() == 1) {
					entity.motionX -= 0.01D;
				}
				else if (((TileEntityModuleMovement)te).getRot() == 0) {
					entity.motionZ += 0.01D;
				}
				else if (((TileEntityModuleMovement)te).getRot() == 2) {
					entity.motionZ -= 0.01D;
				}
				else {entity.motionY += 0.1D;}

			} else {
				entity.motionX *= 0.4D;
				entity.motionZ *= 0.4D;
			}
		}
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float hitX, float hitY, float hitZ) {
		TileEntity te = world.getTileEntity(x, y, z);

		if (player.isSneaking()) {
			return false;
		}

		if (te != null && te instanceof TileEntityModuleMovement) {
			return true;
		}

		return false;
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item id, CreativeTabs table, List list) {
		for (int j = 0; j < typeModule.length; ++j) {
			list.add(addTag(j));
		}
		//list.add(new ItemStack(id, 1, 0));
	}

	private static ItemStack addTag(int par1) {
		ItemStack is = new ItemStack(PackTechno.proxy.block_module_movement, 1, 0);
		NBTTagCompound tag = new NBTTagCompound();
		tag.setInteger("Type", par1);
		is.setTagCompound(tag);
		return is;
	}

}
