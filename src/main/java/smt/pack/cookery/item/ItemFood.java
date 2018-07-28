package smt.pack.cookery.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemFood extends Item {

	@Override
	public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer player) {
		if (!player.capabilities.isCreativeMode) --itemStack.stackSize;
		player.getFoodStats().addStats(0, 0F);
		world.playSoundAtEntity(player, "random.burp", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
		return itemStack;
	}

	@Override
	public int getMaxItemUseDuration(ItemStack itemStack) {
		return 32;
	}

	@Override
	public EnumAction getItemUseAction(ItemStack itemStack) {
		return EnumAction.eat;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		if (player.canEat(false)) player.setItemInUse(itemStack, getMaxItemUseDuration(itemStack));
		return itemStack;
	}

}
