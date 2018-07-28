package smt.pack.magic.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import smt.pack.magic.SMTMagic;
import smt.pack.magic.mana.ManaEntity;
import smt.pack.magic.mana.Util;

public class ItemUpgradeMana extends Item {

	public ItemUpgradeMana() {
		super();
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		if (!world.isRemote) {
			ManaEntity mana_entity = Util.getManaEntity(player);
			if (mana_entity != null) {
				int mana_max = mana_entity.getManaMax();
				if (!player.isSneaking()) mana_max += 100; else mana_max -= 100;
				mana_entity.setManaMax(mana_max);
				System.out.println("getMana - " + mana_entity.getMana() + "/" + mana_entity.getManaMax());
			}
		}
		return super.onItemRightClick(itemStack, world, player);
	}

}
