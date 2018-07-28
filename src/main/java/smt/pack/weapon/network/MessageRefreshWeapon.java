package smt.pack.weapon.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import smt.pack.weapon.SMTWeapon;

public class MessageRefreshWeapon implements IMessage {

	public MessageRefreshWeapon() {}

	@Override
	public void toBytes(ByteBuf buf) {}

	@Override
	public void fromBytes(ByteBuf buf) {}

	public static class Handler implements IMessageHandler<MessageRefreshWeapon, IMessage> {

		@Override
		public IMessage onMessage(MessageRefreshWeapon packet, MessageContext message) {
			if (message.side.isClient())
				act();
			else
				act(message.getServerHandler().playerEntity);
			return null;
		}

		@SideOnly(Side.CLIENT)
		private void act() {
			Minecraft mc = Minecraft.getMinecraft();
			if (!ItemStack.areItemStacksEqual(mc.thePlayer.getHeldItem(), SMTWeapon.proxy.wpn_sys.getWeaponCurrent())) {
				SMTWeapon.proxy.wpn_sys.get(mc.thePlayer).refresh(SMTWeapon.proxy.wpn_sys.getWeaponCurrent());
				SMTWeapon.proxy.wpn_sys.get(mc.thePlayer).refresh(mc.thePlayer.getHeldItem());
			}
		}

		private void act(EntityPlayerMP player) {
			if (!ItemStack.areItemStacksEqual(player.getHeldItem(), SMTWeapon.proxy.wpn_sys.getWeaponCurrent())) {
				SMTWeapon.proxy.wpn_sys.get(player).refresh(SMTWeapon.proxy.wpn_sys.getWeaponCurrent());
				SMTWeapon.proxy.wpn_sys.get(player).refresh(player.getHeldItem());
			}
		}

	}

}
