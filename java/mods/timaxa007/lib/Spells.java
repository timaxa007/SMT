package mods.timaxa007.lib;

import mods.timaxa007.tms.Core;
import mods.timaxa007.tms.util.UtilText;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

/**Spells same Enchantment, but better.<br><b>WIP</b>
 * @author timaxa007
 * @param 
 * @param 
 * @param 
 */
public class Spells {

	public static final Spells[] list = new Spells[2048];

	public static final Spells empty = new Spells(0);

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
	//--------------------------------------------------------
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
		if (UtilText.hasString(tag))
			return list[getID_tag(tag)];
		return empty;
	}
	//--------------------------------------------------------
	public Spells setName(String name) {
		this.name = name;
		return this;
	}

	public String getName() {
		return UtilText.hasString(name) ? name : UtilText.hasString(tag) ? tag : "unname";
	}

	public String getLocalizedName() {
		return StatCollector.translateToLocal("spell." + getName() + ".name");
	}

	public Spells setType(String type) {
		this.type = type;
		return this;
	}

	public String getType() {
		return UtilText.hasString(type) ? type : "untype";
	}

	public String getLocalizedType() {
		return StatCollector.translateToLocal("type." + getType().toLowerCase() + ".name");
	}
	//--------------------------------------------------------
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
	//--------------------------------------------------------
}
