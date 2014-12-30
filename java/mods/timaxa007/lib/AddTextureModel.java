package mods.timaxa007.lib;

import java.io.IOException;

import mods.timaxa007.tms.Core;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public class AddTextureModel {

	public static final AddTextureModel[] list = new AddTextureModel[1024];

	public static final AddTextureModel empty = new AddTextureModel(0).setTextureBlock("timaxa007", "woodFrame");

	public int id;
	public String tag;
	private Block block;
	private int metadata;
	private String texture;
	private String custom_mod;

	private static String tb = "textures/blocks/";
	private static String ti = "textures/items/";

	/**It is not recommended to use this method.**/
	@Deprecated
	public AddTextureModel() {
		id = getNextID();
		list[id] = this;
		metadata = 0;
	}

	/**It is not recommended to use this method.**/
	@Deprecated
	public AddTextureModel(int id) {
		this.id = id;
		list[id] = this;
		metadata = 0;
	}

	/**It is not recommended to use this method.**/
	@Deprecated
	public AddTextureModel(int id, String tag) {
		if (Core.show_tip_info_testing) checkTag(tag);
		this.id = id;
		list[id] = this;
		this.tag = tag;
		metadata = 0;
	}

	public AddTextureModel(String tag) {
		if (Core.show_tip_info_testing) checkTag(tag);
		id = getNextID();
		list[id] = this;
		this.tag = tag;
		metadata = 0;
	}
	//--------------------------------------------------------
	private static int getNextID() {
		for (int i = 0; i < list.length; ++i)
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

	public static AddTextureModel get(String tag) {
		if (tag != null && tag.length() > 0)
			return list[getID_tag(tag)];
		return empty;
	}
	//--------------------------------------------------------
	public boolean hasTag() {
		return tag != null && tag.length() > 0;
	}

	/**Taken from name icon: mod_id and name texture.**/
	public AddTextureModel setBlock(Block block) {
		this.block = block;
		return this;
	}

	/**Taken from name icon: mod_id and name texture.**/
	public AddTextureModel setBlock(Block block, int metadata) {
		this.block = block;
		this.metadata = metadata;
		return this;
	}

	public AddTextureModel setTexture(String path) {
		texture = path;
		return this;
	}
	/**This texture is other MOD or use another path.**/
	public AddTextureModel setTexture(String mod_id, String path) {
		custom_mod = mod_id;
		texture = path;
		return this;
	}

	public AddTextureModel setTextureBlock(String path) {
		texture = tb + path;
		return this;
	}
	/**This texture to path block is other MOD or use another path.**/
	public AddTextureModel setTextureBlock(String mod_id, String path) {
		custom_mod = mod_id;
		texture = tb + path;
		return this;
	}

	public ResourceLocation getTexture() {
		if (block != null) {return getBlockTextureLocation(block, metadata);}
		if (texture != null) return new ResourceLocation(custom_mod != null ? custom_mod : "timaxa007", texture + ".png");
		System.out.println("Error in getTexture for AddTextureModel. NULL!");
		return null;
	}

	public static ResourceLocation getBlockTextureLocation(Block block) {
		return getBlockTextureLocation(block, 0);
	}

	public static ResourceLocation getBlockTextureLocation(Block block, int meta) {
		int side = 0;
		IIcon icon = block.getIcon(side, meta);
		//--------------------------------------------------------------------
		if (icon != null) {
			String iconName = icon.getIconName();
			String s1 = "minecraft";
			String s2 = iconName;
			int i = iconName.indexOf(58);
			if (i >= 0) {
				s2 = iconName.substring(i + 1, iconName.length());
				if (i > 1) {
					s1 = iconName.substring(0, i);
				}
			}
			return new ResourceLocation(s1, tb + s2 + ".png");
		}
		//--------------------------------------------------------------------
		System.out.println("Error in getBlockTextureLocation for AddTextureModel. NULL!");
		return null;
	}

	//@Deprecated
	public static ResourceLocation getBlockTextureLocation(Block block, int side, int metadata) throws Exception {
		IIcon icon = block.getIcon(side, metadata);
		if (icon != null) {
			String iconName = icon.getIconName();
			//--------------------------------------------------------------------
			String s1 = "minecraft";
			String s2 = iconName;
			int i = iconName.indexOf(58);
			if (i >= 0) {s2 = iconName.substring(i + 1, iconName.length());if (i > 1) {s1 = iconName.substring(0, i);}}
			//--------------------------------------------------------------------
			ResourceLocation res_loc = new ResourceLocation(s1, tb + s2 + ".png");
			if (res_loc != null && Minecraft.getMinecraft().getResourceManager().getResource(res_loc).getInputStream() != null) {
				return res_loc;
			} else throw new IOException(String.format("The block %s icon isn't correct.", block));
		} else throw new NullPointerException(String.format("The block %s missing icon.", block));
	}

	public String getLocalizedName() {
		if (tag != null) {return StatCollector.translateToLocal("texture." + tag + ".name");}
		if (block != null && block.getUnlocalizedName() != null) {return StatCollector.translateToLocal(block.getUnlocalizedName());}
		System.out.println("Error in getLocalizedType for AddTextureModel. NONE.");
		return StatCollector.translateToLocal("texture.none.name");
	}

}
