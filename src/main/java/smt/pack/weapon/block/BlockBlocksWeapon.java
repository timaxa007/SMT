package smt.pack.weapon.block;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import smt.pack.weapon.tile.TileEntityBlocksWeapon;

public class BlockBlocksWeapon extends Block implements ITileEntityProvider {

	public BlockBlocksWeapon() {
		super(Material.wood);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int mata) {
		return new TileEntityBlocksWeapon();
	}
	/*
	@Override
	public void updateTick(World world, int x, int y, int z, Random random) {
		if (!world.isRemote) {
			double radius = 10.0D;
			double x_d = (double)x + ((random.nextDouble() * (radius * 2)) - (random.nextDouble() * radius));
			double y_d = (double)y + ((random.nextDouble() * (radius * 2)) - (random.nextDouble() * radius));
			double z_d = (double)z + ((random.nextDouble() * (radius * 2)) - (random.nextDouble() * radius));
			EntityItem ei = new EntityItem(world, x_d, y_d, z_d, new ItemStack(SMTWeapon.item.itemsWeapon));
			ei.delayBeforeCanPickup = 20;
			world.spawnEntityInWorld(ei);
		}
	}
	 */
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if (world.isRemote) return true;

		EntityItem
		apple = null,
		diamond = null;

		for (int xp =-2; xp <= 2; xp++) {
			if (xp == 0) {
				for (int zp =-2; zp <= 2; zp++) {
					if (zp == 0) continue;
					else if (world.getBlock(x, y, z + zp) != net.minecraft.init.Blocks.diamond_block) return true;
				}
			} else if (world.getBlock(x + xp, y, z) != net.minecraft.init.Blocks.diamond_block) return true;
		}

		for (Object o : world.getEntitiesWithinAABB(EntityItem.class, AxisAlignedBB.getBoundingBox(x, y, z, x + 1D, y + 1D, z + 1D).expand(2D, 2D, 2D))) {
			EntityItem i = (EntityItem)o;
			if (apple == null && i.getEntityItem().getItem() == Items.apple) apple = i;
			else if (diamond == null && i.getEntityItem().getItem() == Items.diamond) diamond = i;
			if (apple != null && diamond != null) break;
		}

		if (apple == null || diamond == null) return true;

		ItemStack is = apple.getEntityItem();
		--is.stackSize;
		if (is.stackSize <= 0) apple.setDead(); else apple.setEntityItemStack(is);

		is = diamond.getEntityItem();
		--is.stackSize;
		if (is.stackSize <= 0) diamond.setDead(); else diamond.setEntityItemStack(is);

		world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(Items.stick)));

		world.setWorldTime(0L);

		return true;
	}

}
