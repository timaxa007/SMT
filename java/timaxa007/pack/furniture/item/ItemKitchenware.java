package timaxa007.pack.furniture.item;

import java.util.List;

import timaxa007.pack.furniture.PackFurniture;
import timaxa007.tms.util.ModifiedItem;
import timaxa007.tms.util.UtilString;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemKitchenware extends ModifiedItem {

	@SideOnly(Side.CLIENT) private IIcon[] icon_tex;
	@SideOnly(Side.CLIENT) private IIcon[] icon_ovl;

	public ItemKitchenware(String tag) {
		super(tag);
		setCreativeTab(PackFurniture.tab_furniture);
		setHasSubtypes(true);
		setMaxDamage(0);
	}

	public enum kitchenware {
		Mug01("mug01", false, 0xFFFFFF, 0xFFFFFF), 
		Mug02("mug02", false, 0xFFFFFF, 0xFFFFFF), 
		Glass01("glass01", false, 0xFFFFFF, 0xFFFFFF), 
		Glass02("glass02", false, 0xFFFFFF, 0xFFFFFF), 
		Glass03("glass03", false, 0xFFFFFF, 0xFFFFFF), 
		Glass04("glass04", false, 0xFFFFFF, 0xFFFFFF), 
		Glassful01("glassful01", false, 0xFFFFFF, 0xFFFFFF), 
		Jar01("jar01", false, 0xFFFFFF, 0xFFFFFF), 
		Jar02("jar02", false, 0xFFFFFF, 0xFFFFFF), 
		Foarm_cupcake("foarm_cupcake", false, 0xFFFFFF, 0xFFFFFF), 
		Plaque("plaque", false, 0xFFFFFF, 0xFFFFFF), 
		Pot07("pot07", false, 0xFFFFFF, 0xFFFFFF), 
		Spoon_mixing("spoon_mixing", false, 0xFFFFFF, 0xFFFFFF), 
		Cup_clay_raw("cup_clay_raw", false, 0xFFFFFF, 0xFFFFFF), 
		Cup_clay_burned("cup_clay_burned", false, 0xFFFFFF, 0xFFFFFF), 
		Cup_clay("cup_clay", false, 0xFFFFFF, 0xFFFFFF), //and bone meal for hard
		NONE("none", false, 0xFFFFFF, 0xFFFFFF);

		private String texture;
		private boolean pass;
		private int color_hex1;
		private int color_hex2;

		static boolean hasStrCode(String str) {
			for (kitchenware j : kitchenware.values())
				if (str.equalsIgnoreCase(j.toString()))
					return true;
			return false;
		}

		kitchenware(String tex, boolean ren_pass, int p_hex1, int p_hex2) {
			texture = tex;
			pass = ren_pass;
			color_hex1 = p_hex1;
			color_hex2 = p_hex2;
		}

	}

	public String getUnlocalizedName(ItemStack is) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null && nbt.hasKey("NameID"))
			return super.getUnlocalizedName() + "." + nbt.getString("NameID").toLowerCase();
		return super.getUnlocalizedName();
	}

	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
		NBTTagCompound nbt = is.getTagCompound();
		if (UtilString.isShiftKeyDown()) {
			if (nbt != null) {
				if (nbt.hasKey("NameID"))
					list.add("NameID: " + nbt.getString("NameID") + ".");
			}
		} else list.add(UtilString.hldshiftinf);
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item id, CreativeTabs table, List list) {
		for (kitchenware j : kitchenware.values()) {
			list.add(addNBT(j.toString()));
		}
		//list.add(new ItemStack(id, 1, 0));
	}

	public static ItemStack addNBT(String par1) {
		ItemStack is = new ItemStack(PackFurniture.item.kitchenware, 1, 0);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setString("NameID", par1);
		is.setTagCompound(nbt);
		return is;
	}

	public IIcon getIcon(ItemStack is, int pass) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null && nbt.hasKey("NameID") && kitchenware.hasStrCode(nbt.getString("NameID"))) {
			if (pass == 0)
				return icon_tex[kitchenware.valueOf(nbt.getString("NameID")).ordinal()];
			else
				return icon_ovl[kitchenware.valueOf(nbt.getString("NameID")).ordinal()];
		} else return itemIcon;
	}

	@SideOnly(Side.CLIENT)
	public boolean requiresMultipleRenderPasses() {
		return true;
	}

	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack is, int pass) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null && nbt.hasKey("NameID") && kitchenware.hasStrCode(nbt.getString("NameID"))) {
			if (pass == 0)
				return kitchenware.valueOf(nbt.getString("NameID")).color_hex1;
			else
				return kitchenware.valueOf(nbt.getString("NameID")).color_hex2;
		} else return 16777215;
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister ir) {
		super.registerIcons(ir);

		itemIcon = ir.registerIcon("timaxa007:" + "kitchenware/" + "kitchenware");

		icon_tex = new IIcon[kitchenware.values().length];
		icon_ovl = new IIcon[kitchenware.values().length];

		for (kitchenware j : kitchenware.values()) {
			icon_tex[j.ordinal()] = ir.registerIcon("timaxa007:" + "kitchenware/" + j.texture);
			if (j.pass) {
				icon_ovl[j.ordinal()] = ir.registerIcon("timaxa007:" + "kitchenware/" + j.texture + "_overlay");
			} else {
				icon_ovl[j.ordinal()] = ir.registerIcon("timaxa007:" + "empty");
			}
		}

	}

}
