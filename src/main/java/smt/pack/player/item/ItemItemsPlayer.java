package smt.pack.player.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemItemsPlayer extends Item {

	public ItemItemsPlayer() {
		super();
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		setSize(player, 0.5F, 0.5F);
		return itemStack;
	}

	public void setSize(EntityPlayer player, float width, float height) {
		float f2;

		if (width != player.width || height != player.height) {
			f2 = player.width;
			player.width = width;
			player.height = height;
			player.boundingBox.maxX = player.boundingBox.minX + (double)player.width;
			player.boundingBox.maxZ = player.boundingBox.minZ + (double)player.width;
			player.boundingBox.maxY = player.boundingBox.minY + (double)player.height;
		}

		f2 = width % 2.0F;

		if ((double)f2 < 0.375D) {
			player.myEntitySize = Entity.EnumEntitySize.SIZE_1;
		}
		else if ((double)f2 < 0.75D) {
			player.myEntitySize = Entity.EnumEntitySize.SIZE_2;
		}
		else if ((double)f2 < 1.0D) {
			player.myEntitySize = Entity.EnumEntitySize.SIZE_3;
		}
		else if ((double)f2 < 1.375D) {
			player.myEntitySize = Entity.EnumEntitySize.SIZE_4;
		}
		else if ((double)f2 < 1.75D) {
			player.myEntitySize = Entity.EnumEntitySize.SIZE_5;
		}
		else {
			player.myEntitySize = Entity.EnumEntitySize.SIZE_6;
		}
	}

}
