package smt.pack.common.api.object;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import smt.pack.common.client.render.armor.ArmorCustomModel;

public abstract class ItemCustomArmorDummy extends Item {

	protected final int armorType;

	public ItemCustomArmorDummy(int armorType) {
		super();
		this.armorType = armorType;
	}

	@Override
	public boolean isValidArmor(ItemStack stack, int armorType, Entity entity) {
		return this.armorType == armorType;
	}

	@SideOnly(Side.CLIENT)
	public ArmorCustomModel getModel(EntityLivingBase entityPlayer, ItemStack stack, int slot) {
		return null;
	}

}
