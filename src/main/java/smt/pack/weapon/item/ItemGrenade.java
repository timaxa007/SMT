package smt.pack.weapon.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import smt.pack.weapon.entity.EntityGrenade;

public class ItemGrenade extends Item {

	public ItemGrenade() {
		this.setMaxDamage(300);
		this.setMaxStackSize(1);
	}

	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer) {
		if(entityplayer.capabilities.isCreativeMode) {
			entityplayer.setItemInUse(itemstack, this.getMaxItemUseDuration(itemstack));
		}

		return itemstack;
	}

	public ItemStack onEaten(ItemStack itemstack, World world, EntityPlayer entityplayer) {
		if(entityplayer.capabilities.isCreativeMode) {
			itemstack.damageItem(1, entityplayer);
			if(!entityplayer.capabilities.isCreativeMode) {

			}

			if(entityplayer.canEat(false)) {
				entityplayer.getFoodStats().addStats(2, 0.3F);
			}

			if(!world.isRemote) {
				EntityGrenade smoke = new EntityGrenade(world, entityplayer);
				int i = 0;
				if (itemstack.getTagCompound() != null) {
					i = itemstack.getTagCompound().getInteger("SmokeColour");
				}

				smoke.setSmokeColour(i);
				world.spawnEntityInWorld(smoke);
				if(i == 16) {

				}
			}

			world.playSoundAtEntity(entityplayer, "lotr:item.puff", 1.0F, (itemRand.nextFloat() - itemRand.nextFloat()) * 0.2F + 1.0F);
		}

		return itemstack;
	}

	public int getMaxItemUseDuration(ItemStack itemstack) {
		return 40;
	}

	public EnumAction getItemUseAction(ItemStack itemstack) {
		return EnumAction.bow;
	}

}
