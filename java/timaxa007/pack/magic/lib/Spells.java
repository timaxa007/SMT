package timaxa007.pack.magic.lib;

import timaxa007.tms.Core;
import timaxa007.tms.util.UtilInteger;
import timaxa007.tms.util.UtilString;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

/**Spells same Enchantment, but better.<br><b>WIP</b>
 * @author timaxa007
 * @param 
 * @param 
 * @param 
 */
public class Spells {
	//-----------------------------------------------------------------------------
	public static final Spells[] list = new Spells[2048];

	public static final Spells empty = new Spells("");

	public static final Spells efficient_mining = new Spells("efficient_mining");
	public static final Spells efficient_digging = new Spells("efficient_digging");
	public static final Spells efficient_chopping = new Spells("efficient_chopping");
	public static final Spells efficient_trimming = new Spells("efficient_trimming");

	public static final Spells armor_head = new Spells("armor_head");
	public static final Spells armor_torso = new Spells("armor_torso");
	public static final Spells armor_legs = new Spells("armor_legs");
	public static final Spells armor_feet = new Spells("armor_feet");

	public static final Spells repair_item = new Spells("repair_item") {

		public void functioning(ItemStack is, EntityPlayer player, TypeFunctioning type) {
			if (type == type.item) {
				if (is.isItemStackDamageable()) {
					if (is.getItemDamage() > 0 && is.getItemDamage() < is.getMaxDamage()) is.setItemDamage(is.getItemDamage() - 1);
				}
			}
		}

	};

	public static final Spells damage_item = new Spells("damage_item") {

		public void functioning(ItemStack is, EntityPlayer player, TypeFunctioning type) {
			if (type == type.item) {
				if (is.isItemStackDamageable()) {
					if (is.getItemDamage() > 0 && is.getItemDamage() < is.getMaxDamage()) is.setItemDamage(is.getItemDamage() + 1);
				}
			}
		}

	};

	public static final Spells slow_spell = new Spells("slow_spell");
	public static final Spells fast_spell = new Spells("fast_spell");

	public int id;
	public String tag;
	private String name;
	private String type;

	/**It is not recommended to use this method.**/@Deprecated
	public Spells() {id = nextID();list[id] = this;}

	/**It is not recommended to use this method.**/@Deprecated
	public Spells(int id) {checkID(this, id);this.id = id;list[id] = this;}

	/**It is not recommended to use this method.**/@Deprecated
	public Spells(int id, String tag) {
		checkID(this, id);checkTag(this, tag);
		this.id = id;this.tag = tag;list[id] = this;
	}

	public Spells(String tag) {
		checkTag(this, tag);
		id = nextID();
		list[id] = this;
		this.tag = tag;
	}
	//-----------------------------------------------------------------------------
	public static int nextID() {
		for (int i = 0; i < list.length; i++)
			if (list[i] == null)
				return i;
		return list.length - 1;
	}

	public static boolean hasTag(String tag) {
		if (UtilString.hasString(tag))
			for (Spells spell : list)
				if (spell != null && tag.equalsIgnoreCase(spell.tag))
					return true;
		return false;
	}

	public static int getID_tag(String tag) {
		if (UtilString.hasString(tag))
			for (Spells spell : list)
				if (spell != null && tag.equalsIgnoreCase(spell.tag))
					return spell.id;
		return empty.id;
	}

	private static void checkID(Spells spell, int id) {
		if (list[id] != null)
			throw new IllegalArgumentException("Duplicate id: " + id + " in " + spell.getClass() + ".");
	}

	private static void checkTag(Spells spell, String tag) {
		if (UtilString.hasString(tag))
			for (Spells spell2 : list)
				if (spell2 != null && spell2.tag == tag)
					throw new IllegalArgumentException("Duplicate tag: " + tag + " in " + spell.getClass() + ".");
	}

	public static Spells get(String tag) {
		return list[getID_tag(tag)];
	}

	public static boolean isNull(String tag) {
		return isNull(get(tag));
	}

	public static boolean isNull(Spells spell) {
		return spell == null || spell == empty;
	}
	//-----------------------------------------------------------------------------
	public String getTag() {
		return tag;
	}

	public Spells setName(String name) {
		this.name = name;
		return this;
	}

	public String getName() {
		return UtilString.hasString(name) ? name : UtilString.hasString(tag) ? tag : "unname";
	}

	public String getLocalizedName() {
		return StatCollector.translateToLocal("spell." + getName() + ".name");
	}

	public Spells setType(String type) {
		this.type = type;
		return this;
	}

	public String getType() {
		return UtilString.hasString(type) ? type : "untype";
	}

	public String getLocalizedType() {
		return StatCollector.translateToLocal("type." + getType().toLowerCase() + ".name");
	}
	//-----------------------------------------------------------------------------
	@Deprecated
	public void forPlayer(EntityPlayer player) {

	}

	@Deprecated
	public void forEntity(Entity entity) {

	}

	@Deprecated
	public void forEntityLiving(EntityLivingBase entity) {

	}

	@Deprecated
	public void forBlock(Block block) {

	}

	@Deprecated
	public void forItem(Item item) {

	}

	@Deprecated
	public void forItem(ItemStack is) {

	}

	public void functioning(ItemStack is, EntityPlayer player, TypeFunctioning type) {

	}

	public enum TypeFunctioning {
		//armor_all,
		armor_head,
		armor_torso,
		armor_legs,
		armor_feet,
		//other,
		item;
	}
	//-----------------------------------------------------------------------------
	public static class EventSpellsClient {

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
					(Core.show_tip_info_testing || player.worldObj.difficultySetting != EnumDifficulty.HARD));
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
					Core.show_tip_info_testing || player.worldObj.difficultySetting == EnumDifficulty.PEACEFUL);
		}

	}
	//-----------------------------------------------------------------------------
	public static class EventSpellsCommon {

		@SubscribeEvent
		public void updateSpells(LivingUpdateEvent e) {
			if (e.entityLiving instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer)e.entityLiving;
				World world = player.worldObj;

				if (!world.isRemote && !player.capabilities.isCreativeMode) {
					//---------------------------------------------------------------------
					ItemStack[] main = player.inventory.mainInventory;

					for (ItemStack slot : main) {
						if (slot != null) {
							//-------------------------------------------------------------
							NBTTagList nbttaglist = Spells.getSpellsTagList(slot);

							if (nbttaglist != null) {
								for (int i = 0; i < nbttaglist.tagCount(); ++i) {

									NBTTagCompound tagAt = nbttaglist.getCompoundTagAt(i);
									//------------------------
									Spells spell = Spells.get(tagAt.getString("spell"));
									int power = UtilInteger.getMaxByte((int)tagAt.getByte("power"));
									int times = (int)tagAt.getShort("times");
									//------------------------
									Spells spell_last = spell;
									int power_last = power;
									int times_last = times;
									//------------------------
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
							//-------------------------------------------------------------
						}
					}
					//---------------------------------------------------------------------
					ItemStack[] armor = player.inventory.armorInventory;

					for (int j = 0; j < armor.length; j++) {
						if (armor[j] != null) {
							//-------------------------------------------------------------
							NBTTagList nbttaglist = Spells.getSpellsTagList(armor[j]);

							if (nbttaglist != null) {
								for (int i = 0; i < nbttaglist.tagCount(); ++i) {

									NBTTagCompound tagAt = nbttaglist.getCompoundTagAt(i);
									//------------------------
									Spells spell = Spells.get(tagAt.getString("spell"));
									int power = UtilInteger.getMaxByte((int)tagAt.getByte("power"));
									int times = (int)tagAt.getShort("times");
									//------------------------
									Spells spell_last = spell;
									int power_last = power;
									int times_last = times;
									//------------------------
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
							//-------------------------------------------------------------
						}
					}
					//---------------------------------------------------------------------
				}
			}
		}

	}
	//-----------------------------------------------------------------------------
	public static void addSpell(NBTTagCompound nbt, Spells spell) {
		addSpell(nbt, spell.getTag(), 1, -1);
	}

	public static void addSpell(NBTTagCompound nbt, Spells spell, int power) {
		addSpell(nbt, spell.getTag(), power, -1);
	}

	public static void addSpell(NBTTagCompound nbt, Spells spell, int power, int times) {
		addSpell(nbt, spell.getTag(), power, times);
	}

	public static void addSpell(NBTTagCompound nbt, String spell, int power, int times) {
		if (!nbt.hasKey("spells", 9)) nbt.setTag("spells", new NBTTagList());

		NBTTagList nbttaglist = nbt.getTagList("spells", 10);
		NBTTagCompound nbttagcompound = new NBTTagCompound();
		nbttagcompound.setString("spell", spell);
		nbttagcompound.setByte("power", (byte)UtilInteger.setMaxByte(power));
		nbttagcompound.setShort("times", (short)times);
		nbttaglist.appendTag(nbttagcompound);
	}

	public static NBTTagList getSpellsTagList(ItemStack is) {
		return is.getTagCompound() == null ? null : is.getTagCompound().getTagList("spells", 10);
	}

	public static boolean isSpell(ItemStack is) {
		return is.getTagCompound() != null && is.getTagCompound().hasKey("spells", 9);
	}
	//-----------------------------------------------------------------------------
}
