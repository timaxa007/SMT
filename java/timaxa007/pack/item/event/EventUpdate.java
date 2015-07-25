package timaxa007.pack.item.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;

public class EventUpdate {
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void updateArmor(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.START && event.side == Side.SERVER) {
			EntityPlayer player = event.player;
			if (player != null) {
				ItemStack head = player.getCurrentArmor(3);
				ItemStack body = player.getCurrentArmor(2);
				ItemStack legs = player.getCurrentArmor(1);
				ItemStack feet = player.getCurrentArmor(0);
				if (head != null && head.getItem() == Items.golden_helmet && 
						body != null && body.getItem() == Items.golden_chestplate && 
						legs != null && legs.getItem() == Items.golden_leggings && 
						feet != null && feet.getItem() == Items.golden_boots) {
					player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 20));
				}
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
}
