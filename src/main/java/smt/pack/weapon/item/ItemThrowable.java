package smt.pack.weapon.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import smt.pack.weapon.entity.EntityBall;

public class ItemThrowable extends Item {

	public ItemThrowable() {
		super();
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		EntityBall ball = new EntityBall(world, player);
		world.spawnEntityInWorld(ball);
		return super.onItemRightClick(itemStack, world, player);
	}

}
