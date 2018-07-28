package smt.pack.magic.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import smt.pack.magic.SMTMagic;
import smt.pack.magic.entity.EntityFireBall;
import smt.pack.magic.event.CountUseManaEntityEvent;
import smt.pack.magic.mana.ManaEntity;
import smt.pack.magic.mana.Util;

public class ItemItemsMagic extends Item {

	public ItemItemsMagic() {
		super();
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		if (!world.isRemote) {
			ManaEntity mana_entity = Util.getManaEntity(player);
			if (mana_entity != null) {

				//Значение переменной, сколько использовать маны для использования заклинания.
				//Value of a variable how much to use mana to use spells.
				int count_use_mana = 10;

				//Даём конструктору эвента аргументы.
				//Give the constructor event's arguments.
				CountUseManaEntityEvent event = new CountUseManaEntityEvent(player, itemStack, count_use_mana);

				//После инстанций эвентов.
				//Post instance events.
				MinecraftForge.EVENT_BUS.post(event);

				//Если эвент отменён, то продолжать выполнять код не должен.
				//If the event is canceled, then continue to execute code should not.
				if (event.isCanceled()) return event.held;

				count_use_mana = event.count_use_mana;

				if (mana_entity.hasMana(-count_use_mana)) {
					mana_entity.addMana(-count_use_mana);
					EntityFireBall fireball = new EntityFireBall(world, player);
					world.spawnEntityInWorld(fireball);
				}
			}
		}
		return super.onItemRightClick(itemStack, world, player);
	}

}
