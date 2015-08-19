package timaxa007.pack.conjoint.lib;

import java.io.IOException;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import timaxa007.smt.util.UtilString;

public class AddTextureModel {

	public static final AddTextureModel[] list = new AddTextureModel[2048];

	public static final AddTextureModel empty = new AddTextureModel("").setTextureBlock("timaxa007", "woodFrame");

	public int id;
	public String tag;
	private Block block;
	private int metadata;
	private String texture;
	private String custom_mod;

	private static final String tb = "textures/blocks/";
	private static final String ti = "textures/items/";

	/**Не рекомендуется использовать этот метод.<br>
	 * It is not recommended to use this method.**/
	@Deprecated
	public AddTextureModel() {id = getNextID();list[id] = this;metadata = 0;}

	/**Не рекомендуется использовать этот метод.<br>
	 * It is not recommended to use this method.**/
	@Deprecated
	public AddTextureModel(int id) {checkID(this, id);this.id = id;list[id] = this;metadata = 0;}

	/**Не рекомендуется использовать этот метод.<br>
	 * It is not recommended to use this method.**/
	@Deprecated
	public AddTextureModel(int id, String tag) {
		checkID(this, id);checkTag(this, tag);
		this.id = id;this.tag = tag;list[id] = this;metadata = 0;
	}

	public AddTextureModel(String tag) {
		checkTag(this, tag);
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
		if (UtilString.hasString(tag))
			for (AddTextureModel texture : list)
				if (texture != null && tag.equalsIgnoreCase(texture.tag))
					return true;
		return false;
	}

	public static int getID_tag(String tag) {
		if (UtilString.hasString(tag))
			for (AddTextureModel texture : list)
				if (texture != null && tag.equalsIgnoreCase(texture.tag))
					return texture.id;
		return empty.id;
	}

	private static void checkID(AddTextureModel texture_model, int id) {
		if (list[id] != null)
			throw new IllegalArgumentException("Duplicate id: " + id + " in " + texture_model.getClass() + ".");
	}

	private static void checkTag(AddTextureModel texture_model, String tag) {
		if (UtilString.hasString(tag))
			for (AddTextureModel texture : list)
				if (texture != null && texture.tag == tag)
					throw new IllegalArgumentException("Duplicate tag: " + tag + " in " + texture_model.getClass() + ".");
	}

	public static AddTextureModel get(String tag) {
		return list[getID_tag(tag)];
	}

	public static boolean isNull(String tag) {
		return isNull(get(tag));
	}

	public static boolean isNull(AddTextureModel texture_model) {
		return texture_model == null || texture_model == empty;
	}
	//--------------------------------------------------------
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