package timaxa007.pack.magic.event;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import timaxa007.pack.magic.lib.Spells;
import timaxa007.smt.CoreSMT;
import timaxa007.smt.util.UtilInteger;
import timaxa007.smt.util.UtilString;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventSpells {
	//-----------------------------------------------------------------------------------------------------------------------
	public static class Client {

		@SubscribeEvent
		public void tipSpellsTag(ItemTooltipEvent e) {

			if (isNoShowHard(e.entityPlayer)) {

				NBTTagList nbttaglist = Spells.getSpellsTagList(e.itemStack);

				if (nbttaglist != null) {
					for (int i = 0; i < nbttaglist.tagCount(); ++i) {

						String spell = nbttaglist.getCompoundTagAt(i).getString("spell");
						int power = UtilInteger.getMaxByte((int)nbttaglist.getCompoundTagAt(i).getByte("power"));
						int times = (int)nbttaglist.getCompoundTagAt(i).getShort("times");

						if (UtilString.isControlKeyDown() && isShowPeace(e.entityPlayer)) {

							//if (!Spells.isNull(spell)) {

							e.toolTip.add("");

							e.toolTip.add(UtilString.getText("spells." + "Spell") + ": " + 
									Spells.get(spell).getLocalizedName() + ", ");

							e.toolTip.add(UtilString.getText("spells." + "Power") + ": " + power + ", " + 
									UtilString.getText("spells." + "Duration") + ": " + 
									(times >= 0 ? times : UtilString.getText("spells." + "Permanent")) + ".");

							//}

						} else {

							if (isShowPeace(e.entityPlayer) && i == 0)
								e.toolTip.add(UtilString.hldctrltinfab + " " + 
										EnumChatFormatting.LIGHT_PURPLE + 
										UtilString.getText("spells.spells") + 
										EnumChatFormatting.RESET);

							//if (!Spells.isNull(spell)) {

							e.toolTip.add(Spells.get(spell).getLocalizedName() + 
									(" (" + power + ") ") + 
									(times >= 0 ? times : "")
									);

							//}

						}

					}
				}

			}

		}

		public static boolean isNoShowHard(EntityPlayer player) {
			return (player.capabilities.isCreativeMode || 
					(CoreSMT.config.show_tip_info_testing || player.worldObj.difficultySetting != EnumDifficulty.HARD));
		}

		@Deprecated
		public static boolean isShowPeaceEasyNormal(EntityPlayer player) {
			return (isShowPeaceEasy(player) || player.worldObj.difficultySetting == EnumDifficulty.NORMAL);
		}

		@Deprecated
		public static boolean isShowPeaceEasy(EntityPlayer player) {
			return (isShowPeace(player) || player.worldObj.difficultySetting == EnumDifficulty.EASY);
		}

		public static boolean isShowPeace(EntityPlayer player) {
			return (player.capabilities.isCreativeMode || 
					CoreSMT.config.show_tip_info_testing || player.worldObj.difficultySetting == EnumDifficulty.PEACEFUL);
		}

	}
	//-----------------------------------------------------------------------------------------------------------------------
	public static class Common {
		//--------------------------------------------------------------------------------------------------------------
		//--------------------------------------------------------------------------------------------------------------
		@SubscribeEvent
		public void updateSpells(LivingUpdateEvent e) {
			if (e.entityLiving instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer)e.entityLiving;
				World world = player.worldObj;

				if (!world.isRemote && !player.capabilities.isCreativeMode) {
					//--------------------------------------------------------------------------------------------------
					ItemStack[] main = player.inventory.mainInventory;

					for (ItemStack slot : main) {
						if (slot != null) {
							//------------------------------------------------------------------------------------------
							NBTTagList nbttaglist = Spells.getSpellsTagList(slot);

							if (nbttaglist != null) {
								for (int i = 0; i < nbttaglist.tagCount(); ++i) {

									NBTTagCompound tagAt = nbttaglist.getCompoundTagAt(i);
									//------------------------
									Spells spell = Spells.get(tagAt.getString("spell"));
									int power = UtilInteger.getMaxByte((int)tagAt.getByte("power"));
									int times = (int)tagAt.getShort("times");
									//---------------------------------------------------------------------------------
									Spells spell_last = spell;
									int power_last = power;
									int times_last = times;
									//---------------------------------------------------------------------------------
									if (world.getWorldTime() % (20) == 0) {
										if (times == 0) spell = Spells.empty;
										if (times > 0) --times;
									}

									if (times != 0) {
										if (power > 0 && world.getWorldTime() % (int)(255 / power) == 0) {
											spell.functioning(slot, player, Spells.TypeFunctioning.item);
										}
									}

									if (spell_last != spell) tagAt.setString("spell", spell.getTag());
									if (power_last != power) tagAt.setByte("power", (byte)UtilInteger.setMaxByte(power));
									if (times_last != times) tagAt.setShort("times", (short)times);

								}
							}
							//------------------------------------------------------------------------------------------
						}
					}
					//--------------------------------------------------------------------------------------------------
					ItemStack[] armor = player.inventory.armorInventory;

					for (int j = 0; j < armor.length; j++) {
						if (armor[j] != null) {
							//------------------------------------------------------------------------------------------
							NBTTagList nbttaglist = Spells.getSpellsTagList(armor[j]);

							if (nbttaglist != null) {
								for (int i = 0; i < nbttaglist.tagCount(); ++i) {

									NBTTagCompound tagAt = nbttaglist.getCompoundTagAt(i);
									//------------------------
									Spells spell = Spells.get(tagAt.getString("spell"));
									int power = UtilInteger.getMaxByte((int)tagAt.getByte("power"));
									int times = (int)tagAt.getShort("times");
									//---------------------------------------------------------------------------------
									Spells spell_last = spell;
									int power_last = power;
									int times_last = times;
									//---------------------------------------------------------------------------------
									if (world.getWorldTime() % (20) == 0) {
										if (times == 0) spell = Spells.empty;
										if (times > 0) --times;
									}

									if (times != 0) {
										if (power > 0 && world.getWorldTime() % (int)(255 / power) == 0) {
											spell.functioning(armor[j], player, Spells.TypeFunctioning.item);

											if (j == 3)
												spell.functioning(armor[j], player, Spells.TypeFunctioning.armor_head);

											if (j == 2)
												spell.functioning(armor[j], player, Spells.TypeFunctioning.armor_torso);

											if (j == 1)
												spell.functioning(armor[j], player, Spells.TypeFunctioning.armor_legs);

											if (j == 0)
												spell.functioning(armor[j], player, Spells.TypeFunctioning.armor_feet);

										}
									}

									if (spell_last != spell) tagAt.setString("spell", spell.getTag());
									if (power_last != power) tagAt.setByte("power", (byte)UtilInteger.setMaxByte(power));
									if (times_last != times) tagAt.setShort("times", (short)times);

								}
							}
							//------------------------------------------------------------------------------------------
						}
					}
					//--------------------------------------------------------------------------------------------------
				}
			}
		}
		//--------------------------------------------------------------------------------------------------------------
		//--------------------------------------------------------------------------------------------------------------
		@SubscribeEvent
		public void actionHurtSpell(LivingHurtEvent e) {
			EntityLivingBase to = e.entityLiving;//Кому наноситься урон,

			if (to instanceof EntityPlayer) {

				EntityPlayer player_to = (EntityPlayer)to;
				ItemStack current_to = player_to.getCurrentEquippedItem();//Что дерижит кому наносится урон
				ItemStack helm_to = player_to.getCurrentArmor(3);//Что в слоте шлема кому наносится урон
				ItemStack chest_to = player_to.getCurrentArmor(2);//Что в слоте нагрудника кому наносится урон
				ItemStack legs_to = player_to.getCurrentArmor(1);//Что в слоте штанов кому наносится урон
				ItemStack boot_to = player_to.getCurrentArmor(0);//Что в слоте ботинок кому наносится урон

				//--------------------------------------------------------------------------------------------------
				ItemStack[] armor = player_to.inventory.armorInventory;

				for (int j = 0; j < armor.length; j++) {
					if (armor[j] != null) {
						//------------------------------------------------------------------------------------------
						NBTTagList nbttaglist = Spells.getSpellsTagList(armor[j]);

						if (nbttaglist != null) {
							for (int i = 0; i < nbttaglist.tagCount(); ++i) {

								NBTTagCompound tagAt = nbttaglist.getCompoundTagAt(i);
								//------------------------
								Spells spell = Spells.get(tagAt.getString("spell"));
								int power = UtilInteger.getMaxByte((int)tagAt.getByte("power"));
								int times = (int)tagAt.getShort("times");
								//---------------------------------------------------------------------------------

								if (times != 0) {

									String mes = UtilString.getText("spells." + "Spell") + ": ";

									if (spell == Spells.explosion_protection) {
										if (e.source.isExplosion()) {
											String mes2 = UtilString.getText("spell.is_explosion.attempt");
											player_to.addChatMessage(new ChatComponentText(mes + mes2 + "."));
											armor[j].damageItem((int)e.ammount, player_to);
											e.ammount = 0.0F;
}
									}

									if (spell == Spells.projectile_protection) {
										if (e.source.isProjectile()) {
											String mes2 = UtilString.getText("spell.is_projectile.attempt");
											player_to.addChatMessage(new ChatComponentText(mes + mes2 + "."));
											armor[j].damageItem((int)e.ammount, player_to);
											e.ammount = 0.0F;
										}
									}

									if (spell == Spells.fire_damage_protection) {
										if (e.source.isFireDamage()) {
											String mes2 = UtilString.getText("spell.is_fire_damage.attempt");
											player_to.addChatMessage(new ChatComponentText(mes + mes2 + "."));
											armor[j].damageItem((int)e.ammount, player_to);
											e.ammount = 0.0F;
										}
									}

									if (spell == Spells.explosion_protection) {
										if (e.source.isDamageAbsolute()) {
											//e.ammount = 0.0F;
										}
									}

									if (spell == Spells.explosion_protection) {
										if (e.source.isMagicDamage()) {
											//e.ammount = 0.0F;
										}
									}

									if (spell == Spells.unblockable_protection) {
										if (e.source.isUnblockable() && e.source.getDamageType() == "fall") {
											String mes2 = UtilString.getText("spell.is_unblockable.attempt");
											player_to.addChatMessage(new ChatComponentText(mes + mes2 + "."));
											armor[j].damageItem((int)e.ammount, player_to);
											e.ammount = 0.0F;
										}
									}

									if (spell == Spells.explosion_protection) {
										if (e.source.isDifficultyScaled()) {
											//e.ammount = 0.0F;
										}
									}

									System.out.println(e.source.getDamageType());

								}

							}
						}
						//------------------------------------------------------------------------------------------
					}
				}
				//--------------------------------------------------------------------------------------------------

			}
			//--------------------------------------------------------------------------------------------------------------
			//--------------------------------------------------------------------------------------------------------------
		}
	}
	//-----------------------------------------------------------------------------------------------------------------------
}
