package mods.timaxa007.pack.item.item;

import java.util.List;

import mods.timaxa007.pack.furniture.PackFurniture;
import mods.timaxa007.tms.util.ModifiedItemArmor;
import mods.timaxa007.tms.util.UtilString;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ArmorWoolColors extends ModifiedItemArmor {

	public ArmorWoolColors(String tag, ArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
		super(tag, par2EnumArmorMaterial, par3, par4);
		setCreativeTab(PackFurniture.tab_furniture);
	}

	public String getUnlocalizedName(ItemStack is) {
		return super.getUnlocalizedName();
	}

	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
		NBTTagCompound nbt = is.getTagCompound();
		if (UtilString.isShiftKeyDown()) {
			list.add(UtilString.getText("Material") + ": " + UtilString.getText("Wool") + ".");
			list.add(UtilString.getText("Type") + ": " + UtilString.getText("Armor") + ".");
			if (nbt != null) {
				if (nbt.hasKey("Color"))
					list.add(UtilString.getText("Color") + ": " + nbt.getInteger("HexColor") + ".");
			}
		} else list.add(UtilString.hldshiftinf);
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item id, CreativeTabs table, List list) {
		list.add(addNBT(new ItemStack(id, 1, 0), 0xFFFFFF));
		//list.add(new ItemStack(id, 1, 0));
	}

	public static ItemStack addNBT(ItemStack par1, int par2) {
		ItemStack is = par1;
		NBTTagCompound nbt = new NBTTagCompound();
		//nbt.setInteger("Color", par2);
		nbt.setInteger("HexColor", par2);
		is.setTagCompound(nbt);
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
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null && nbt.hasKey("HexColor"))
			return nbt.getInteger("HexColor");
		else
			return 16777215;
	}
	/*
	public int getColor(ItemStack is) {
		super.getColor(is);
		NBTTagCompound nbt = is.getTagCompound();
			if (nbt != null && nbt.hasKey("HexColor")) {
				return nbt.getInteger("HexColor");
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