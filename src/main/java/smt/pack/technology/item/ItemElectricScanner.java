package smt.pack.technology.item;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import smt.pack.technology.SMTTechnology;
import smt.pack.technology.client.gui.ItemElectricScannerGui;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemElectricScanner extends Item {

	public ItemElectricScanner() {
		super();
		setMaxDamage(128);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		Minecraft mc = Minecraft.getMinecraft();
		MovingObjectPosition mop = mc.objectMouseOver;
		if (mop != null) {
			mc.displayGuiScreen(new ItemElectricScannerGui(mop));
		}
		return super.onItemRightClick(itemStack, world, player);
	}

}
