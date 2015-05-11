package timaxa007.module.control_button.api;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface IUpdateClient {
	
	/**Пока-что работает в инвентаре игрока. Не получилось пока-что сделать наподобие ванильного Update.**/
	void updateClient(ItemStack is, World world, EntityPlayer player);

}
