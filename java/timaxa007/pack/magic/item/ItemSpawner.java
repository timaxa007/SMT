package timaxa007.pack.magic.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import timaxa007.pack.magic.PackMagic;
import timaxa007.smt.object.ModifiedItem;

public class ItemSpawner extends ModifiedItem {

	public ItemSpawner(String tag) {
		super(tag);
		setCreativeTab(PackMagic.tab_magic);
	}

	public boolean onItemUse(ItemStack is, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		if (!player.canPlayerEdit(x, y, z, side, is)) return false;
		else {
			NBTTagCompound nbt = is.getTagCompound();
			/*
			if (!world.isRemote) {
				EntityRobot corpse = new EntityRobot(world);
				corpse.setPosition((double)x + 0.5D, (double)y + 2.5D, (double)z + 0.5D);
				world.spawnEntityInWorld(corpse);
				return true;
			}
			 */
		}
		return super.onItemUse(is, player, world, x, y, z, side, hitX, hitY, hitZ);
	}

}
