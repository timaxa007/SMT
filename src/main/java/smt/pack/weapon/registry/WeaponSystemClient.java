package smt.pack.weapon.registry;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import smt.pack.common.client.RegKey;
import smt.pack.weapon.SMTWeapon;
import smt.pack.weapon.network.MessageCenter;
import smt.pack.weapon.network.MessageLeft;
import smt.pack.weapon.network.MessageRefreshWeapon;
import smt.pack.weapon.network.MessageReload;
import smt.pack.weapon.network.MessageRight;

@SideOnly(Side.CLIENT)
public class WeaponSystemClient extends WeaponSystem {

	private static final Minecraft mc = Minecraft.getMinecraft();

	private boolean left, right, center, reload, isOpenContainer;

	@Override
	public void onUpdate() {
		//System.out.println("onUpdate Client, Side = " + (player.worldObj.isRemote ? "Client" : "Server"));
		if (!player.worldObj.isRemote) {
			super.onUpdate();
			return;
		}

		onRemake();

		if (mc.currentScreen instanceof GuiContainer) {
			if (!isOpenContainer) {
				SMTWeapon.network.sendToServer(new MessageRefreshWeapon());
				isOpenContainer = true;
			}
		} else {
			if (isOpenContainer) isOpenContainer = false;
		}

		boolean left = mc.gameSettings.keyBindAttack.getIsKeyPressed();
		boolean right = mc.gameSettings.keyBindUseItem.getIsKeyPressed();
		boolean center = mc.gameSettings.keyBindPickBlock.getIsKeyPressed();
		boolean reload = RegKey.reload.isPressed();

		if (left != this.left) doLeft(player, left);
		if (right != this.right) doRight(player, right);
		if (center != this.center) doCenter(player, center);
		if (reload != this.reload) doReload(player, reload);

		this.left = left;
		this.right = right;
		this.center = center;
		this.reload = reload;
	}

	private void doLeft(EntityPlayer player, boolean press) {
		MessageLeft message = new MessageLeft();
		message.press = press;
		SMTWeapon.network.sendToServer(message);
	}

	private void doRight(EntityPlayer player, boolean press) {
		MessageRight message = new MessageRight();
		message.press = press;
		SMTWeapon.network.sendToServer(message);
	}

	private void doCenter(EntityPlayer player, boolean center) {
		if (center) {
			MessageCenter message = new MessageCenter();
			message.id = 0;
			SMTWeapon.network.sendToServer(message);
		}
	}

	private void doReload(EntityPlayer player, boolean reload) {
		if (reload) {
			MessageReload message = new MessageReload();
			message.slotID = -1;
			SMTWeapon.network.sendToServer(message);
		}
	}

	@Override
	public void reg(EntityPlayer player) {
		player.registerExtendedProperties(TAG, new WeaponSystemClient());
	}

	@Override
	public WeaponSystem get(EntityPlayer player) {
		return player != null ? (WeaponSystemClient)player.getExtendedProperties(TAG) : null;
	}

}
