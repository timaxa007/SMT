package mods.timaxa007.lib;

import mods.timaxa007.pack.magic.PackMagic;
import mods.timaxa007.tms.Core;
import mods.timaxa007.tms.util.UtilNBT;
import mods.timaxa007.tms.util.UtilString;
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

	public static final Spells empty = new Spells(0);
	public static final Spells test = new Spells("test");
	public static final Spells test2 = new Spells("test2");
	public static final Spells efficient_mining = new Spells("efficient_mining");
	public static final Spells efficient_digging = new Spells("efficient_digging");
	public static final Spells efficient_chopping = new Spells("efficient_chopping");
	public static final Spells efficient_trimming = new Spells("efficient_trimming");

	public int id;
	public String tag;
	private String name;
	private String type;

	/**It is not recommended to use this method.**/
	@Deprecated
	public Spells() {
		id = nextID();
		list[id] = this;
	}

	/**It is not recommended to use this method.**/
	@Deprecated
	public Spells(int id) {
		this.id = id;
		list[id] = this;
	}

	/**It is not recommended to use this method.**/
	@Deprecated
	public Spells(int id, String tag) {
		if (Core.show_system_info_testing) checkTag(tag);
		this.id = id;
		list[id] = this;
		this.tag = tag;
	}

	public Spells(String tag) {
		if (Core.show_system_info_testing) checkTag(tag);
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
		for (int i = 0; i < list.length; i++)
			if (tag.equalsIgnoreCase(list[i].tag))
				return true;
		return false;
	}

	public static int getID_tag(String tag) {
		for (int i = 0; i < list.length; i++)
			if (tag.equalsIgnoreCase(list[i].tag))
				return i;
		return 0;
	}

	private static void checkTag(String tag) {
		for (int i = 0; i < list.length; i++)
			if (list[i] != null && list[i].tag == tag)
				System.out.println("!Duplicate: " + tag);
	}

	public static Spells get(String tag) {
		if (UtilString.hasString(tag))
			return list[getID_tag(tag)];
		return empty;
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
	public void forPlayer(EntityPlayer player) {

	}

	public void forEntity(Entity entity) {

	}

	public void forEntityLiving(EntityLivingBase entity) {

	}

	public void forBlock(Block block) {

	}

	public void forItem(Item item) {

	}

	public void forItem(ItemStack is) {

	}
	//-----------------------------------------------------------------------------
	public static class TipSpells {

		@SubscribeEvent
		public void tipSpellsTag(ItemTooltipEvent e) {

			if (isNoShowHard(e.entityPlayer)) {

				NBTTagList nbttaglist = Spells.getSpellsTagList(e.itemStack);

				if (nbttaglist != null) {
					for (int i = 0; i < nbttaglist.tagCount(); ++i) {

						String spell = nbttaglist.getCompoundTagAt(i).getString("spell");
						byte power = nbttaglist.getCompoundTagAt(i).getByte("power");
						short times = nbttaglist.getCompoundTagAt(i).getShort("times");

						if (UtilString.isControlKeyDown() && isShowPeace(e.entityPlayer)) {

							e.toolTip.add("");

							e.toolTip.add(UtilString.getText("spells." + "Spell") + ": " + Spells.get(spell).getLocalizedName() + ", ");

							e.toolTip.add(UtilString.getText("spells." + "Power") + ": " + power + ", " + 
									UtilString.getText("spells." + "Duration") + ": " + 
									(times >= 0 ? times : UtilString.getText("spells." + "Permanent")) + ".");

						} else {

							if (isShowPeace(e.entityPlayer) && i == 0) 
								e.toolTip.add(UtilString.hldctrltinfab + " " + 
										EnumChatFormatting.LIGHT_PURPLE + 
										UtilString.getText("spells.spells") + 
										EnumChatFormatting.RESET);

							e.toolTip.add(Spells.get(spell).getLocalizedName() + 
									(isShowPeaceEasyNormal(e.entityPlayer) ? (" (" + power + ") ") : "") + 
									((times >= 0 && isShowPeaceEasy(e.entityPlayer)) ? times : "")
									);

						}
					}
				}

			}

		}

		public static boolean isNoShowHard(EntityPlayer player) {
			return (player.capabilities.isCreativeMode || 
					(Core.show_tip_info_testing || player.worldObj.difficultySetting != EnumDifficulty.HARD));
		}

		public static boolean isShowPeaceEasyNormal(EntityPlayer player) {
			return (isShowPeaceEasy(player) || player.worldObj.difficultySetting == EnumDifficulty.NORMAL);
		}

		public static boolean isShowPeaceEasy(EntityPlayer player) {
			return (isShowPeace(player) || player.worldObj.difficultySetting == EnumDifficulty.EASY);
		}

		public static boolean isShowPeace(EntityPlayer player) {
			return (player.capabilities.isCreativeMode || 
					Core.show_tip_info_testing || player.worldObj.difficultySetting == EnumDifficulty.PEACEFUL);
		}

	}
	//-----------------------------------------------------------------------------
	/**Not work.**/
	@Deprecated
	public static void addSpell(ItemStack is, Spells spell, int power, int times) {
		addSpell(is, spell.getTag(), power, times);
	}

	/**Not work.**/
	@Deprecated
	public static void addSpell(ItemStack is, String spell, int power, int times) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt == null) nbt = new NBTTagCompound();
		addSpell(nbt, spell, power, times);
		//is.setTagCompound(nbt);
	}

	public static void addSpell(NBTTagCompound nbt, Spells spell, int power, int times) {
		addSpell(nbt, spell.getTag(), power, times);
	}

	public static void addSpell(NBTTagCompound nbt, String spell, int power, int times) {
		if (!nbt.hasKey("spel", 9)) nbt.setTag("spel", new NBTTagList());

		NBTTagList nbttaglist = nbt.getTagList("spel", 10);
		NBTTagCompound nbttagcompound = new NBTTagCompound();
		nbttagcompound.setString("spell", spell);
		nbttagcompound.setByte("power", (byte)power);
		nbttagcompound.setShort("times", (short)times);
		nbttaglist.appendTag(nbttagcompound);
	}

	public static NBTTagList getSpellsTagList(ItemStack is) {
		return is.getTagCompound() == null ? null : is.getTagCompound().getTagList("spel", 10);
	}

	public static boolean isItemSpell(ItemStack is) {
		return is.getTagCompound() != null && is.getTagCompound().hasKey("spel", 9);
	}
	//-----------------------------------------------------------------------------
}
