package smt.pack.magic.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import smt.pack.magic.inventory.ContainerDisenchanter;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MessageActionDisench implements IMessage {

	public MessageActionDisench() {}

	@Override
	public void toBytes(ByteBuf buf) {

	}

	@Override
	public void fromBytes(ByteBuf buf) {

	}

	public static class Handler implements IMessageHandler<MessageActionDisench, IMessage> {

		@Override
		public IMessage onMessage(MessageActionDisench packet, MessageContext message) {
			if (message.side.isClient())
				act(packet);
			else
				act(message.getServerHandler().playerEntity, packet);
			return null;
		}

		@SideOnly(Side.CLIENT)
		private void act(MessageActionDisench packet) {}

		private void act(EntityPlayerMP player, MessageActionDisench packet) {
			Container container = player.openContainer;
			if (container instanceof ContainerDisenchanter) {
				Slot slot1 = container.getSlot(0);
				Slot slot2 = container.getSlot(1);
				Slot slot3 = container.getSlot(2);
				Slot slot4 = container.getSlot(3);

				if (slot1 != null && slot2 != null && slot3 != null && slot4 != null) {
					if (slot1.getHasStack() && slot2.getHasStack() && !slot3.getHasStack() && !slot4.getHasStack()) {
						if (slot1.getStack().isItemEnchanted() && slot2.getStack().getItem() == Items.book) {

							EnchantmentData ench = null;
							ItemStack slot1copy = slot1.getStack().copy();
							{
								NBTTagList nbttaglist = slot1copy.getEnchantmentTagList();
								NBTTagList newnbttaglist = new NBTTagList();
								if (nbttaglist != null) {
									for (int i = 0; i < nbttaglist.tagCount(); ++i) {
										short id = nbttaglist.getCompoundTagAt(i).getShort("id");
										short lvl = nbttaglist.getCompoundTagAt(i).getShort("lvl");

										if (i != 0) {
											NBTTagCompound nbttagcompound = new NBTTagCompound();
											nbttagcompound.setShort("id", id);
											nbttagcompound.setShort("lvl", lvl);
											newnbttaglist.appendTag(nbttagcompound);
										} else ench = new EnchantmentData(id, lvl);

									}
									if (ench == null) return;
									if (nbttaglist.tagCount() <= 1) {
										slot1copy.getTagCompound().removeTag("ench");
									}
									NBTTagCompound nbt = slot1copy.getTagCompound();
									if (newnbttaglist.tagCount() > 0) nbt.setTag("ench", newnbttaglist);
									slot1copy.setTagCompound(nbt);
								}

							}

							ItemStack slot2copy = new ItemStack(Items.enchanted_book);
							Items.enchanted_book.addEnchantment(slot2copy, ench);

							container.putStackInSlot(3, slot2copy);
							container.putStackInSlot(2, slot1copy);
							container.putStackInSlot(1, null);
							container.putStackInSlot(0, null);
						}
					}
				}

			}
		}

	}

}
