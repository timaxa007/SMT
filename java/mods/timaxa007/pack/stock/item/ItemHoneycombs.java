package mods.timaxa007.pack.stock.item;

import java.util.List;

import mods.timaxa007.lib.GetColors;
import mods.timaxa007.pack.stock.PackStock;
import mods.timaxa007.tms.util.ItemFixReg;
import mods.timaxa007.tms.util.UtilText;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemHoneycombs extends ItemFixReg {

	@SideOnly(Side.CLIENT) private IIcon icon_a;
	@SideOnly(Side.CLIENT) private IIcon icon_b;

	public ItemHoneycombs(String tag) {
		super(tag);
		setCreativeTab(PackStock.tab_apis);
		setHasSubtypes(true);
		setMaxDamage(0);
	}

	public static enum honeycombs {
		Honey_1(GetColors.getHexColors[10], GetColors.getHexColors[15]), 
		Honey_2(GetColors.getHexColors[15], GetColors.getHexColors[10]), 
		Honey_3(0x7F6A00, 0xBF9F00), 
		Honey_4(GetColors.getHexColors[10], GetColors.getHexColors[2]), 
		Honey_5(GetColors.getHexColors[10], GetColors.getHexColors[13]), 
		Honey_6(GetColors.getHexColors[6], GetColors.getHexColors[14]), 
		Honey_7(GetColors.getHexColors[8], GetColors.getHexColors[5]), 
		Honey_8(GetColors.getHexColors[14], GetColors.getHexColors[15]), 
		Honey_9(GetColors.getHexColors[9], GetColors.getHexColors[0]), 
		Honey_black(GetColors.getHexColors[0], GetColors.getHexColors[0]), 
		Honey_blue(GetColors.getHexColors[1], GetColors.getHexColors[1]), 
		Honey_brown(GetColors.getHexColors[2], GetColors.getHexColors[2]), 
		Honey_cyan(GetColors.getHexColors[3], GetColors.getHexColors[3]), 
		Honey_gray(GetColors.getHexColors[4], GetColors.getHexColors[4]), 
		Honey_green(GetColors.getHexColors[5], GetColors.getHexColors[5]), 
		Honey_light_blue(GetColors.getHexColors[6], GetColors.getHexColors[6]), 
		Honey_light_gray(GetColors.getHexColors[7], GetColors.getHexColors[7]), 
		Honey_light_green(GetColors.getHexColors[8], GetColors.getHexColors[8]), 
		Honey_magenta(GetColors.getHexColors[9], GetColors.getHexColors[9]), 
		Honey_orange(GetColors.getHexColors[10], GetColors.getHexColors[10]), 
		Honey_pink(GetColors.getHexColors[11], GetColors.getHexColors[11]), 
		Honey_purple(GetColors.getHexColors[12], GetColors.getHexColors[12]), 
		Honey_red(GetColors.getHexColors[13], GetColors.getHexColors[13]), 
		Honey_white(GetColors.getHexColors[14], GetColors.getHexColors[14]), 
		Honey_yellow(GetColors.getHexColors[15], GetColors.getHexColors[15]), 
		/*
		Honey1(0xFFFF00, 0xFFAA00), 
		Honey2(0xFFFF00, 0xFF8800), 
		b_b(0x222222, 0x444444), 
		w_w(0xFFFFFF, 0xCCCCCC), 
		b_w(0x222222, 0xFFFFFF), 
		w_b(0xFFFFFF, 0x222222), 
		 */
		none(0xFFFFFF, 0xFFFFFF);

		private int hex1;
		private int hex2;

		static boolean hasStrCode(String str) {
			for (honeycombs j : honeycombs.values()) {
				if (str.equalsIgnoreCase(j.toString())) {
					return true;
				}
			}
			return false;
		}

		honeycombs(int p_hex1, int p_hex2) {
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

	public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer player) {

		if (!player.capabilities.isCreativeMode) {
		}

		player.removePotionEffect(Potion.wither.id);
		player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 20*5, 0));
		world.playSoundAtEntity(player, "timaxa007:vodka", 1F, 1F);

		return is;
	}

	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
		NBTTagCompound tag = is.getTagCompound();
		if (UtilText.isShiftKeyDown()) {
			if (tag != null && tag.hasKey("NameID")) {
				list.add("NameID: " + tag.getString("NameID") + ".");
			}
		} else {
			list.add(UtilText.hldshiftinf);
		}
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item id, CreativeTabs table, List list) {
		for (honeycombs j : honeycombs.values()) {
			list.add(addTag(j.toString()));
		}
		//list.add(new ItemStack(id, 1, 0));
	}

	private ItemStack addTag(String par1) {
		ItemStack is = new ItemStack(PackStock.proxy.item.honeycombs, 1, 0);
		NBTTagCompound tag = new NBTTagCompound();
		tag.setString("NameID", par1);
		is.setTagCompound(tag);
		return is;
	}

	@SideOnly(Side.CLIENT)
	public boolean requiresMultipleRenderPasses() {return true;}

	public IIcon getIcon(ItemStack is, int pass) {
		NBTTagCompound tag = is.getTagCompound();
		if (tag != null && tag.hasKey("NameID")) {
			if (pass == 0) {
				return icon_a;
			} else {
				return icon_b;
			}
		} else {
			return itemIcon;
		}
	}

	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack is, int pass) {
		NBTTagCompound tag = is.getTagCompound();
		if (tag != null && tag.hasKey("NameID") && honeycombs.hasStrCode(tag.getString("NameID"))) {
			if (pass == 0) {
				return honeycombs.valueOf(tag.getString("NameID")).hex1;
			} else {
				return honeycombs.valueOf(tag.getString("NameID")).hex2;
			}
		} else {
			return 16777215;
		}
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister ir) {
		super.registerIcons(ir);
		itemIcon = ir.registerIcon("timaxa007:apis/honeycombs_icon");
		icon_a = ir.registerIcon("timaxa007:apis/honeycombs_a");
		icon_b = ir.registerIcon("timaxa007:apis/honeycombs_b");
	}

}
