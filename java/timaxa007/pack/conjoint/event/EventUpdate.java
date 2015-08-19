package timaxa007.pack.conjoint.event;

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
	/*
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
	*/
	//--------------------------------------------------------------------------------------------------------------
	/*
	private int last_damage = -1;
	private int cooldown228 = 0;
	@SubscribeEvent
	public void update228(TickEvent.PlayerTickEvent event) {
		if (event.side == Side.SERVER) {
			EntityPlayer player = event.player;
			if (player != null) {
				ItemStack head = player.getCurrentArmor(3);
				ItemStack body = player.getCurrentArmor(2);
				ItemStack legs = player.getCurrentArmor(1);
				ItemStack feet = player.getCurrentArmor(0);
				//-----------------------------------------
				if (legs != null) {
					last_damage = legs.getMaxDamage() - legs.getItemDamage();
				}

				if (legs == null && last_damage == 0) {
					player.playSound("modid:pants40", 1.0F, 1.0F);
					//System.out.println("pants40");
				}

				if (legs == null) {
					last_damage = -1;
				}
				//-----------------------------------------
				if (head != null && head.getDisplayName().endsWith("228") {
					++cooldown228;
					if (cooldown228 > (20 * 60) {
						player.playSound("modid:hat228", 1.0F, 1.0F);
						cooldown228 = 0;
						//System.out.println("hat228");
					}
				}
				//-----------------------------------------
			}
		}
	}
	*/
	//--------------------------------------------------------------------------------------------------------------
}
