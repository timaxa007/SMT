package timaxa007.pack.techno.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface ITechnoTool/* or IElectricTool*/ {

	public void mode(ItemStack is, World world, EntityPlayer player);
	public void working(ItemStack is, World world, EntityPlayer player);

}
