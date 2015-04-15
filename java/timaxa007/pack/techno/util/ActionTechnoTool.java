package timaxa007.pack.techno.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import timaxa007.pack.techno.item.ToolElectricDrill;
import timaxa007.pack.techno.item.ToolElectricSaw;
import timaxa007.pack.techno.item.ToolElectricWrench;

public class ActionTechnoTool {

	public static void mode(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ITechnoTool)
				((ITechnoTool)current.getItem()).mode(current, player.worldObj, player);
			/*
			if (current.getItem() instanceof ToolElectricDrill)
				((ToolElectricDrill)current.getItem()).mode(current, player.worldObj, player);
			if (current.getItem() instanceof ToolElectricSaw)
				((ToolElectricSaw)current.getItem()).mode(current, player.worldObj, player);
			if (current.getItem() instanceof ToolElectricWrench)
				((ToolElectricWrench)current.getItem()).mode(current, player.worldObj, player);
			 */
		}
	}

	public static void working(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ITechnoTool)
				((ITechnoTool)current.getItem()).working(current, player.worldObj, player);
			/*
			if (current.getItem() instanceof ToolElectricDrill)
				((ToolElectricDrill)current.getItem()).working(current, player.worldObj, player);
			if (current.getItem() instanceof ToolElectricSaw)
				((ToolElectricSaw)current.getItem()).working(current, player.worldObj, player);
			if (current.getItem() instanceof ToolElectricWrench)
				((ToolElectricWrench)current.getItem()).working(current, player.worldObj, player);
			 */
		}
	}

}
