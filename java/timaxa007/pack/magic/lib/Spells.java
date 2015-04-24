package timaxa007.pack.magic.lib;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.StatCollector;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import timaxa007.tms.util.UtilInteger;
import timaxa007.tms.util.UtilString;

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

		public void functioning(ItemStack is, EntityPlayer player, TypeFunctioning type, LivingHurtEvent event) {
			if (type == type.item) {
				if (is.isItemStackDamageable()) {
					if (is.getItemDamage() > 0 && is.getItemDamage() < is.getMaxDamage()) is.setItemDamage(is.getItemDamage() + 1);
				}
			}
		}

	};

	public static final Spells slow_spell = new Spells("slow_spell");
	public static final Spells fast_spell = new Spells("fast_spell");

	public static final Spells explosion_protection = new Spells("explosion_protection");
	public static final Spells projectile_protection = new Spells("projectile_protection");
	public static final Spells fire_damage_protection = new Spells("fire_damage_protection");
	public static final Spells unblockable_protection = new Spells("unblockable_protection");

	public int id;
	public String tag;
	private String name;
	private String type;

	/**Не рекомендуется использовать этот метод.<br>
	 * It is not recommended to use this method.**/
	@Deprecated
	public Spells() {id = nextID();list[id] = this;}

	/**Не рекомендуется использовать этот метод.<br>
	 * It is not recommended to use this method.**/
	@Deprecated
	public Spells(int id) {checkID(this, id);this.id = id;list[id] = this;}

	/**Не рекомендуется использовать этот метод.<br>
	 * It is not recommended to use this method.**/
	@Deprecated
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

	public static boolean isSpell(ItemStack is, Spells spell) {
		return isSpell(is, spell.getTag());
	}

	public static boolean isSpell(ItemStack is, String spell) {
		if (is != null) {
			//------------------------------------------------------------------------------------------
			NBTTagList nbttaglist = Spells.getSpellsTagList(is);

			if (nbttaglist != null) {
				for (int i = 0; i < nbttaglist.tagCount(); ++i) {

					NBTTagCompound tagAt = nbttaglist.getCompoundTagAt(i);
					//------------------------
					String spelly = tagAt.getString("spell");
					int power = UtilInteger.getMaxByte((int)tagAt.getByte("power"));
					int times = (int)tagAt.getShort("times");
					//---------------------------------------------------------------------------------
					if (spelly == spell) return true;
				}
			}
		}
		return false;
	}
	//-----------------------------------------------------------------------------
}
