package smt.pack.technology.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import smt.pack.EntityLook;

public class ItemCapsule extends Item {

	public ItemCapsule() {
		super();
		setMaxDamage(1000);
	}
	/*
	@Override
	public boolean onBlockDestroyed(ItemStack itemStack, World world, Block block, int x, int y, int z, EntityLivingBase entity) {
		if (!world.isRemote) {
			int dmg = 1;
			for (int i = x - 1; i <= x + 1; i++) {
				for (int j = y - 1; j <= y + 1; j++) {
					for (int k = z - 1; k <= z + 1; k++) {
						float hardness = world.getBlock(i, j, k).getBlockHardness(world, i, j, k);
						if (world.getBlock(i, j, k).getMaterial() == block.getMaterial() && 
								hardness != 1F &&
								hardness <= block.getBlockHardness(world, x, y, z)) {
							world.func_147480_a(i, j, k, true);
							if (hardness > 0F) ++dmg;
						}
					}
				}
			}
			itemStack.damageItem(dmg, entity);
		}

		return true;
	}
	 */
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		MovingObjectPosition mop = EntityLook.block(player, 1F, 4D, true);
		if (mop != null) {
			int blockX = mop.blockX;
			int blockY = mop.blockY;
			int blockZ = mop.blockZ;
			/*int side = mop.sideHit;
			float hitX = (float)(mop.hitVec.xCoord - (double)blockX);
			float hitY = (float)(mop.hitVec.yCoord - (double)blockY);
			float hitZ = (float)(mop.hitVec.zCoord - (double)blockZ);*/
			Fluid fluid = FluidRegistry.lookupFluidForBlock(world.getBlock(blockX, blockY, blockZ));
			if (fluid != null) {
				System.out.println(fluid.getName());
			}
		}
		return super.onItemRightClick(itemStack, world, player);
	}

}
