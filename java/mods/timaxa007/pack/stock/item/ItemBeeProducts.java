package mods.timaxa007.pack.stock.item;

import java.util.List;

import mods.timaxa007.lib.GetColors;
import mods.timaxa007.lib.Option;
import mods.timaxa007.pack.stock.PackStock;
import mods.timaxa007.tms.util.ItemFixReg;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBeeProducts extends ItemFixReg {

	@SideOnly(Side.CLIENT) private IIcon[] icon_tex;
	@SideOnly(Side.CLIENT) private IIcon[] icon_ovl;

	public ItemBeeProducts(String tag) {
		super(tag);
		setCreativeTab(PackStock.tab_apis);
		setHasSubtypes(true);
		setMaxDamage(0);
	}

	public enum bee_products {
		Beeswax_1("beeswax", GetColors.getHexColors[10], GetColors.getHexColors[15]), 
		Beeswax_2("beeswax", GetColors.getHexColors[15], GetColors.getHexColors[10]), 
		Beeswax_3("beeswax", 0x7F6A00, 0xBF9F00), 
		Beeswax_4("beeswax", GetColors.getHexColors[10], GetColors.getHexColors[2]), 
		Beeswax_5("beeswax", GetColors.getHexColors[10], GetColors.getHexColors[13]), 
		Beeswax_6("beeswax", GetColors.getHexColors[6], GetColors.getHexColors[14]), 
		Beeswax_7("beeswax", GetColors.getHexColors[8], GetColors.getHexColors[5]), 
		Beeswax_8("beeswax", GetColors.getHexColors[14], GetColors.getHexColors[15]), 
		Beeswax_9("beeswax", GetColors.getHexColors[9], GetColors.getHexColors[0]), 
		Beeswax("beeswax", 0xFFFFFF, 0xFFFFFF), 
		//Refractory_wax("", 0xFFFFFF, 0xFFFFFF), 
		Drop_honey_1("drop_honey", GetColors.getHexColors[10], GetColors.getHexColors[15]), 
		Drop_honey_2("drop_honey", GetColors.getHexColors[15], GetColors.getHexColors[10]), 
		Drop_honey_3("drop_honey", 0x7F6A00, 0xBF9F00), 
		Drop_honey_4("drop_honey", GetColors.getHexColors[10], GetColors.getHexColors[2]), 
		Drop_honey_5("drop_honey", GetColors.getHexColors[10], GetColors.getHexColors[13]), 
		Drop_honey_6("drop_honey", GetColors.getHexColors[6], GetColors.getHexColors[14]), 
		Drop_honey_7("drop_honey", GetColors.getHexColors[8], GetColors.getHexColors[5]), 
		Drop_honey_8("drop_honey", GetColors.getHexColors[14], GetColors.getHexColors[15]), 
		Drop_honey_9("drop_honey", GetColors.getHexColors[9], GetColors.getHexColors[0]), 
		Drop_honey("drop_honey", 0xFFFFFF, 0xFFFFFF), 
		//Honeydew("", 0xFFFFFF, 0xFFFFFF), 
		Pollen_1("pollen", GetColors.getHexColors[10], GetColors.getHexColors[15]), 
		Pollen_2("pollen", GetColors.getHexColors[15], GetColors.getHexColors[10]), 
		Pollen_3("pollen", 0x7F6A00, 0xBF9F00), 
		Pollen_4("pollen", GetColors.getHexColors[10], GetColors.getHexColors[2]), 
		Pollen_5("pollen", GetColors.getHexColors[10], GetColors.getHexColors[13]), 
		Pollen_6("pollen", GetColors.getHexColors[6], GetColors.getHexColors[14]), 
		Pollen_7("pollen", GetColors.getHexColors[8], GetColors.getHexColors[5]), 
		Pollen_8("pollen", GetColors.getHexColors[14], GetColors.getHexColors[15]), 
		Pollen_9("pollen", GetColors.getHexColors[9], GetColors.getHexColors[0]), 
		Pollen("pollen", 0xFFFFFF, 0xFFFFFF), 
		Royal_jelly_1("royal_jelly", GetColors.getHexColors[10], GetColors.getHexColors[15]), 
		Royal_jelly_2("royal_jelly", GetColors.getHexColors[15], GetColors.getHexColors[10]), 
		Royal_jelly_3("royal_jelly", 0x7F6A00, 0xBF9F00), 
		Royal_jelly_4("royal_jelly", GetColors.getHexColors[10], GetColors.getHexColors[2]), 
		Royal_jelly_5("royal_jelly", GetColors.getHexColors[10], GetColors.getHexColors[13]), 
		Royal_jelly_6("royal_jelly", GetColors.getHexColors[6], GetColors.getHexColors[14]), 
		Royal_jelly_7("royal_jelly", GetColors.getHexColors[8], GetColors.getHexColors[5]), 
		Royal_jelly_8("royal_jelly", GetColors.getHexColors[14], GetColors.getHexColors[15]), 
		Royal_jelly_9("royal_jelly", GetColors.getHexColors[9], GetColors.getHexColors[0]), 
		Royal_jelly("royal_jelly", 0xFFFFFF, 0xFFFFFF), 
		Propolis_1("propolis", GetColors.getHexColors[10], GetColors.getHexColors[15]), 
		Propolis_2("propolis", GetColors.getHexColors[15], GetColors.getHexColors[10]), 
		Propolis_3("propolis", 0x7F6A00, 0xBF9F00), 
		Propolis_4("propolis", GetColors.getHexColors[10], GetColors.getHexColors[2]), 
		Propolis_5("propolis", GetColors.getHexColors[10], GetColors.getHexColors[13]), 
		Propolis_6("propolis", GetColors.getHexColors[6], GetColors.getHexColors[14]), 
		Propolis_7("propolis", GetColors.getHexColors[8], GetColors.getHexColors[5]), 
		Propolis_8("propolis", GetColors.getHexColors[14], GetColors.getHexColors[15]), 
		Propolis_9("propolis", GetColors.getHexColors[9], GetColors.getHexColors[0]), 
		Propolis("propolis", 0xFFFFFF, 0xFFFFFF), 
		//Silky_propolis("", 0xFFFFFF, 0xFFFFFF), 
		Pulsating_propolis("", 0xFFFFFF, 0xFFFFFF), 
		Crystal_pollen("", 0xFFFFFF, 0xFFFFFF), 
		Phosphorus("", 0xFFFFFF, 0xFFFFFF), 
		Piece_silk("", 0xFFFFFF, 0xFFFFFF), 
		Pulsating_net("", 0xFFFFFF, 0xFFFFFF), 
		Woven_silk("", 0xFFFFFF, 0xFFFFFF), 
		Shard_ice("", 0xFFFFFF, 0xFFFFFF), 
		NONE("", 0xFFFFFF, 0xFFFFFF);

		private String name;
		private int hex1;
		private int hex2;

		static boolean hasStrCode(String str) {
			for (bee_products j : bee_products.values()) {
				if (str.equalsIgnoreCase(j.toString())) {
					return true;
				}
			}
			return false;
		}

		bee_products(String str, int p_hex1, int p_hex2) {
			//new FluidFake(600 + ordinal()).setName("honey_" + this.toString().toLowerCase()).setType("Liquid").setColor(0xFFFFFF).setTemperatures(16.0F, -10.0F, 100.0F);
			if (str == "" || str == null) {
				name = toString().toLowerCase();
			} else {
				name = str;
			}
			hex1 = p_hex1;
			hex2 = p_hex2;
		}

	}

	public String getUnlocalizedName(ItemStack is) {
		NBTTagCompound tag = is.getTagCompound();
		if (tag != null && tag.hasKey("NameID")) {
			return super.getUnlocalizedName() + "." + tag.getString("NameID").toLowerCase();
		}
		return super.getUnlocalizedName();
	}

	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
		NBTTagCompound tag = is.getTagCompound();
		if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
			if (tag != null && tag.hasKey("NameID")) {
				list.add("NameID: " + tag.getString("NameID") + ".");
			}
		} else {
			list.add(Option.prshift);
		}
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item id, CreativeTabs table, List list) {
		for (bee_products j : bee_products.values()) {
			list.add(addTag(j.toString()));
		}
		//list.add(new ItemStack(id, 1, 0));
	}

	private ItemStack addTag(String par1) {
		ItemStack is = new ItemStack(PackStock.proxy.item.bee_products, 1, 0);
		NBTTagCompound tag = new NBTTagCompound();
		tag.setString("NameID", par1);
		is.setTagCompound(tag);
		return is;
	}

	@SideOnly(Side.CLIENT)
	public boolean requiresMultipleRenderPasses() {return true;}

	public IIcon getIcon(ItemStack is, int pass) {
		NBTTagCompound tag = is.getTagCompound();
		if (tag != null && tag.hasKey("NameID") && bee_products.hasStrCode(tag.getString("NameID"))) {
			if (pass == 0) {
				return icon_tex[bee_products.valueOf(tag.getString("NameID")).ordinal()];
			} else {
				return icon_ovl[bee_products.valueOf(tag.getString("NameID")).ordinal()];
			}
		} else {
			return itemIcon;
		}
	}

	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack is, int pass) {
		NBTTagCompound tag = is.getTagCompound();
		if (tag != null && tag.hasKey("NameID") && bee_products.hasStrCode(tag.getString("NameID"))) {
			if (pass == 0) {
				return bee_products.valueOf(tag.getString("NameID")).hex1;
			} else {
				return bee_products.valueOf(tag.getString("NameID")).hex2;
			}
		} else {
			return 16777215;
		}
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister ir) {
		super.registerIcons(ir);
		itemIcon = ir.registerIcon("timaxa007:apis/bee_products_icon");
		icon_tex = new IIcon[bee_products.values().length];
		icon_ovl = new IIcon[bee_products.values().length];
		for (bee_products j : bee_products.values()) {
			icon_tex[j.ordinal()] = ir.registerIcon("timaxa007:apis/" + j.name);
			icon_ovl[j.ordinal()] = ir.registerIcon("timaxa007:apis/" + j.name + "_overlay");
		}

	}

}
