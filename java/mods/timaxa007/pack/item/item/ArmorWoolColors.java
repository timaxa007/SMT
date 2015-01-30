package mods.timaxa007.pack.item.item;

import java.util.List;

import mods.timaxa007.pack.furniture.PackFurniture;
import mods.timaxa007.tms.util.ItemArmorFixReg;
import mods.timaxa007.tms.util.UtilText;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ArmorWoolColors extends ItemArmorFixReg {

	public ArmorWoolColors(String tag, ArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
		super(tag, par2EnumArmorMaterial, par3, par4);
		setCreativeTab(PackFurniture.tab_furniture);
	}

	public String getUnlocalizedName(ItemStack is) {
		return super.getUnlocalizedName();
	}

	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
		NBTTagCompound tag = is.getTagCompound();
		if (UtilText.isShiftKeyDown()) {
			list.add(UtilText.getText("Material") + ": " + UtilText.getText("Wool") + ".");
			list.add(UtilText.getText("Type") + ": " + UtilText.getText("Armor") + ".");
			if (tag != null) {
				if (tag.hasKey("Color"))
					list.add(UtilText.getText("Color") + ": " + tag.getInteger("HexColor") + ".");
			}
		} else list.add(UtilText.hldshiftinf);
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item id, CreativeTabs table, List list) {
		list.add(addTag(new ItemStack(id, 1, 0), 0xFFFFFF));
		//list.add(new ItemStack(id, 1, 0));
	}

	private static ItemStack addTag(ItemStack par1, int par2) {
		ItemStack is = par1;
		NBTTagCompound tag = new NBTTagCompound();
		//tag.setInteger("Color", par2);
		tag.setInteger("HexColor", par2);
		is.setTagCompound(tag);
		return is;
	}
	/*
	@SideOnly(Side.CLIENT)
	public boolean requiresMultipleRenderPasses() {
		return true;
	}
	 */
	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack is, int pass) {
		NBTTagCompound tag = is.getTagCompound();
		if (tag != null && tag.hasKey("HexColor"))
			return tag.getInteger("HexColor");
		else
			return 16777215;
	}
	/*
	public int getColor(ItemStack is) {
		super.getColor(is);
		NBTTagCompound tag = is.getTagCompound();
			if (tag != null && tag.hasKey("HexColor")) {
				return tag.getInteger("HexColor");
			} else {
				return 0xFF0000;
			}
	}
	 */
	public String getArmorTexture(ItemStack is, Entity entity, int slot, String type) {
		return "timaxa007:textures/armor/armor_wool_color_white_" + (armorType == 2 ? 2 : 1) + ".png";
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister ir) {
		String[] typeArmor = new String[] {"helm", "chest", "leggin", "boot"};
		super.registerIcons(ir);
		itemIcon = ir.registerIcon("timaxa007:armor/armor_wool_" + typeArmor[armorType] +"_overlay");
	}

}