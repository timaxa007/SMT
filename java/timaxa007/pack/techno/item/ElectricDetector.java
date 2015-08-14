package timaxa007.pack.techno.item;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import timaxa007.module.control_button.api.IUpdateClient;
import timaxa007.pack.techno.PackTechno;
import timaxa007.pack.conjoint.object.ModifiedItem;

public class ElectricDetector extends ModifiedItem implements IUpdateClient {

	public ElectricDetector(String tag) {
		super(tag);
		setCreativeTab(PackTechno.tab_techno);
		setMaxDamage(1000);
		setMaxStackSize(1);
		setNoRepair();
	}

	@Override
	public void updateClient(ItemStack is, World world, EntityPlayer player) {
		//System.out.println(is);
	}

	public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer player) {

		if (!world.isRemote) {

			ArrayList<BlockInRadius> list = new ArrayList<BlockInRadius>();
			double posX = player.posX;
			double posY = player.posY;
			double posZ = player.posZ;
			float radius = 3;
			int r = (int)radius + 1;

			for (int x = (int)posX - r; x <= (int)posX + r; x++) {
				for (int y = (int)posY - r; y <= (int)posY + r; y++) {
					for (int z = (int)posZ - r; z <= (int)posZ + r; z++) {
						if (!player.worldObj.isAirBlock(x, y, z)) {
							if (distanceTo(player, x, y, z) <= (double)r) {
								list.add(new BlockInRadius(player.worldObj.getBlock(x, y, z), x, y, z));
							}
						}
					}
				}
			}

			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) != null) {
					BlockInRadius bir = (BlockInRadius)list.get(i);
					if (bir != null) {
						System.out.println(bir.toString());
					}
				}
			}

		}

		return super.onItemRightClick(is, world, player);
	}
	//--------------------------------------------------------------------------------------------------------------
	public static class BlockInRadius {

		public Block block;
		public int x;
		public int y;
		public int z;

		public BlockInRadius(Block block, int x, int y, int z) {
			this.block = block;
			this.x = x;
			this.y = y;
			this.z = z;
		}

		public String toString() {
			return "Block: " + block.getLocalizedName() + " (" + x + ", " + y + ", " + z + ").";
		}

	}
	//--------------------------------------------------------------------------------------------------------------
	public static double distanceTo(EntityPlayer player, int x, int y, int z) {
		double d0 = ((double)x + 0.5F) - player.posX;
		double d1 = ((double)y + 0.5F) - player.posY;
		double d2 = ((double)z + 0.5F) - player.posZ;
		return Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
	}
	//--------------------------------------------------------------------------------------------------------------
}
