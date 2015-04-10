package timaxa007.pack.magic.event;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EntityDamageSource;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.world.BlockEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventMagic {
	//--------------------------------------------------------------------------------------------------------------
	/*@SubscribeEvent
	public void onEntityUpdate(LivingUpdateEvent e) {
		ItemStack helmet = ((EntityPlayer)e.entityLiving).getCurrentArmor(0);
		ItemStack chestplate = ((EntityPlayer)e.entityLiving).getCurrentArmor(1);
		ItemStack leggings = ((EntityPlayer)e.entityLiving).getCurrentArmor(2);
		ItemStack boots = ((EntityPlayer)e.entityLiving).getCurrentArmor(3);
		ItemStack actHBI = ((EntityPlayer)e.entityLiving).getCurrentEquippedItem();//active HotBar Item
		ItemStack helmetI;
		ItemStack chestplateI;
		ItemStack leggingsI;
		ItemStack bootsI;
		if (helmet != null && chestplate != null && leggings != null && boots != null) {
			//--------------------------------------------------------------
			helmetI = new ItemStack(PackFurniture.armor_new_helmet);
			chestplateI = new ItemStack(PackFurniture.armor_new_chest);
			leggingsI = new ItemStack(PackFurniture.armor_new_leggin);
			bootsI = new ItemStack(PackFurniture.armor_new_boot);
			if (boots.getItem() == helmetI.getItem() && leggings.getItem() == chestplateI.getItem() && chestplate.getItem() == leggingsI.getItem() && helmet.getItem() == bootsI.getItem()) {

				if (e.entityLiving.isSneaking()) {

				}

				if (e.entityLiving.isAirBorne) {

				}

				if (e.entityLiving.isSprinting()) {
					e.entityLiving.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 20 * 1, 3));
				}

				if (e.entityLiving.isEating()) {
					e.entityLiving.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 20 * 1, 3));
				}

				e.entityLiving.fallDistance = e.entityLiving.fallDistance-0.1F;
			}

			//--------------------------------------------------------------

		}
	}*/
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void hasPlayerTool(BlockEvent.BreakEvent e) {
		ItemStack current = e.getPlayer().getCurrentEquippedItem();
		if (current != null) {
			//System.out.println("isBreakBlock " + e.block.getUnlocalizedName() + ".");
		}
	}
	//--------------------------------------------------------------------------------------------------------------
}
