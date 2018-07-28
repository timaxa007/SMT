package smt.pack.magic.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import smt.pack.magic.SMTMagic;
import smt.pack.magic.entity.EntityMagicChest;

public class ItemSpawnEntity extends Item {

	public ItemSpawnEntity() {
		super();
	}

	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		Entity entity = new EntityMagicChest(world);
		entity.setPosition((double)x + 0.5D, (double)y + 2.5D, (double)z + 0.5D);
		if (!world.isRemote) world.spawnEntityInWorld(entity);
		return true;
	}

}
