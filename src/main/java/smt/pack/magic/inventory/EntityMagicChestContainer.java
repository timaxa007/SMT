package smt.pack.magic.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import smt.pack.magic.entity.EntityMagicChest;

public class EntityMagicChestContainer extends net.minecraft.inventory.Container {

	private final EntityMagicChest entityMagicChest;

	public EntityMagicChestContainer(final EntityMagicChest entityMagicChest, final EntityPlayer player) {
		this.entityMagicChest = entityMagicChest;
		if (entityMagicChest != null) {
			addSlotToContainer(new Slot(entityMagicChest.getInventory(), 0, 56, 17));
			addSlotToContainer(new Slot(entityMagicChest.getInventory(), 1, 56, 53));
			addSlotToContainer(new SlotFurnace(player, entityMagicChest.getInventory(), 2, 116, 35));
		}

		int i;

		for (i = 0; i < 3; ++i) {
			for (int j = 0; j < 9; ++j) {
				addSlotToContainer(new Slot(player.inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		for (i = 0; i < 9; ++i) {
			addSlotToContainer(new Slot(player.inventory, i, 8 + i * 18, 142));
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return entityMagicChest != null ? player.getDistanceToEntity(entityMagicChest) <= 64.0D : false;
	}
	/*
	public void onUpdate(EntityPlayer player, Phase phase) {
		switch(phase) {
		case END:{
			if (entityMagicChest != null && player instanceof EntityPlayerMP)
				SMTMagic.network.sendTo(entityMagicChest.getDescriptionPacket(), (EntityPlayerMP)player);
			break;
		}
		default:break;
		}

	}
	 */
}
