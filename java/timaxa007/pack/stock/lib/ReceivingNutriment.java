package timaxa007.pack.stock.lib;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import timaxa007.tms.util.UtilInteger;
import timaxa007.tms.util.UtilString;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ReceivingNutriment {
	//-----------------------------------------------------------------------------
	public static class EventNutrimentCommon {

		@SubscribeEvent
		public void updateReceivingNutriment(LivingUpdateEvent e) {

		}

	}
	//-----------------------------------------------------------------------------
	public static class EventNutrimentClient {

		@SubscribeEvent
		public void tipTagReceivingNutriment(ItemTooltipEvent tip) {
			ItemStack is = tip.itemStack;

			if (is != null) {

				NBTTagCompound nbt = is.getTagCompound();

				if (nbt != null && isEffect(is)) {
					//-------------------------------------------------------------
					NBTTagList nbttaglist = ReceivingNutriment.getEffectTagList(is);

					if (nbttaglist != null) {

						if (UtilString.isControlKeyDown()) {

							tip.toolTip.add("PotionEffect:");

							for (int i = 0; i < nbttaglist.tagCount(); ++i) {

								NBTTagCompound tagAt = nbttaglist.getCompoundTagAt(i);
								//-----------------------------------------------------
								int id = tagAt.getInteger("id");
								int times = (int)tagAt.getShort("time");
								int lvl = (int)tagAt.getByte("lvl") & 0xFF;
								//-----------------------------------------------------
								PotionEffect ptn_efct = new PotionEffect(id, 20 * times, lvl);
								String mess = "";

								mess += (Potion.potionTypes[ptn_efct.getPotionID()].isBadEffect() ? 
										EnumChatFormatting.RED : EnumChatFormatting.GREEN);
								mess += StatCollector.translateToLocal(ptn_efct.getEffectName()).trim();
								mess += EnumChatFormatting.RESET;

								if (ptn_efct.getAmplifier() > 0)
									mess += " " + ptn_efct.getAmplifier();

								if (ptn_efct.getDuration() > 20)
									mess += " (" + Potion.getDurationString(ptn_efct) + ")";

								tip.toolTip.add(" - " + mess);

							}

						} else tip.toolTip.add(UtilString.hldctrltinf);
					}
					//-------------------------------------------------------------
				}
			}
		}

	}
	//-----------------------------------------------------------------------------
	public static void addEffectPlayer(ItemStack is, EntityPlayer player) {

		NBTTagCompound nbt = is.getTagCompound();

		if (nbt != null) {
			//-------------------------------------------------------------
			NBTTagList nbttaglist = ReceivingNutriment.getEffectTagList(is);

			if (nbttaglist != null) {
				for (int i = 0; i < nbttaglist.tagCount(); ++i) {

					NBTTagCompound tagAt = nbttaglist.getCompoundTagAt(i);
					//-----------------------------------------------------
					int id = tagAt.getInteger("id");
					int time = (int)tagAt.getShort("time");
					int lvl = UtilInteger.getMaxByte((int)tagAt.getByte("lvl"));
					//-----------------------------------------------------
					PotionEffect ptn_efct = new PotionEffect(id, 20 * time, lvl);
					player.addPotionEffect(ptn_efct);
				}
			}
			//-------------------------------------------------------------
		}

	}

	public static void addEffect(NBTTagCompound nbt, int id, int time, int lvl) {
		if (!nbt.hasKey("eft_nut", 9)) nbt.setTag("eft_nut", new NBTTagList());

		NBTTagList nbttaglist = nbt.getTagList("eft_nut", 10);
		NBTTagCompound nbttagcompound = new NBTTagCompound();
		nbttagcompound.setByte("id", (byte)id);
		nbttagcompound.setShort("time", (short)time);
		nbttagcompound.setByte("lvl", (byte)lvl);
		nbttaglist.appendTag(nbttagcompound);
	}

	public static NBTTagList getEffectTagList(ItemStack is) {
		return is.getTagCompound() == null ? null : is.getTagCompound().getTagList("eft_nut", 10);
	}

	public static boolean isEffect(ItemStack is) {
		return is.getTagCompound() != null && is.getTagCompound().hasKey("eft_nut", 9);
	}
	//-----------------------------------------------------------------------------
}
