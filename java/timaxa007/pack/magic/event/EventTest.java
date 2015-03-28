package timaxa007.pack.magic.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EventTest {

	@SubscribeEvent
	public void giveHealthToBag(AttackEntityEvent attackevent) {
		EntityPlayer player = attackevent.entityPlayer;

		for (ItemStack slot : player.inventory.mainInventory) {
			if (slot != null) {
				if (slot.getItem() == Items.diamond) {
					NBTTagCompound nbt = slot.getTagCompound();
					if (nbt == null) nbt = new NBTTagCompound();
					if (!nbt.hasKey("HealthInBag")) nbt.setInteger("HealthInBag", 0);

					if (nbt.hasKey("HealthInBag") && nbt.getInteger("HealthInBag") < 1000000) {
						nbt.setInteger("HealthInBag", nbt.getInteger("HealthInBag") + 1);
						slot.setTagCompound(nbt);
						break;
					}

				}
			}
		}

	}

	@SideOnly(Side.CLIENT) 
	@SubscribeEvent
	public void tipSpellsTag(ItemTooltipEvent e) {
		NBTTagCompound nbt = e.itemStack.getTagCompound();
		if (nbt != null && nbt.hasKey("HealthInBag"))
			e.toolTip.add("Health In Bag: " + nbt.getInteger("HealthInBag"));
	}

}
