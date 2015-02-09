package mods.timaxa007.pack.furniture.item;

import java.util.List;

import mods.timaxa007.pack.furniture.render.model.ModelNewArmor;
import mods.timaxa007.tms.util.ModifiedItemArmor;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ArmorNew extends ModifiedItemArmor {

	public ArmorNew(String tag, ArmorMaterial mat, int par3, int par4) {
		super(tag, mat, par3, par4);
	}

	public void onArmorTickUpdate(World world, EntityPlayer player, ItemStack is) {

	}

	public String getUnlocalizedName(ItemStack is) {
		return super.getUnlocalizedName();
	}

	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {

	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item id, CreativeTabs table, List list) {
		list.add(new ItemStack(id, 1, 0));
	}

	public String getArmorTexture(ItemStack is, Entity entity, int slot, String type) {
		//" + (armorType == 2 ? 2 : 1) + "
		return "timaxa007:textures/armor/new.png";
	}

	//int type = ((ItemArmor)itemStack.getItem()).armorType;

	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entity, ItemStack is, int armorSlot) {
		if (armorSlot != armorType) return null;

		if (is != null && is.getItem() instanceof ArmorNew) {
			//NBTTagCompound nbt = is.getTagCompound();
			ModelNewArmor model_new_armor;

			//if (nbt.hasKey("TypeMedieval")) {
			model_new_armor = new ModelNewArmor(armorType);
			//} else {model_armor_medieval = new ModelNewArmor();}

			model_new_armor.bipedHead.showModel = false;
			model_new_armor.bipedHeadwear.showModel = false;
			model_new_armor.bipedBody.showModel = false;
			model_new_armor.bipedRightArm.showModel = false;
			model_new_armor.bipedLeftArm.showModel = false;
			model_new_armor.bipedRightLeg.showModel = false;
			model_new_armor.bipedLeftLeg.showModel = false;
			model_new_armor.bipedCloak.showModel = false;
			model_new_armor.isSneak = entity.isSneaking();
			model_new_armor.isRiding = entity.isRiding();
			model_new_armor.isChild = entity.isChild();
			//model_armor_medieval.onGround = entity.onGround();
			if (entity instanceof EntityPlayer) {
				model_new_armor.heldItemRight = ((EntityPlayer)entity).getCurrentEquippedItem() != null ? 1 :0;
				model_new_armor.aimedBow = ((EntityPlayer)entity).getItemInUseDuration() > 2;
			}
			return model_new_armor;
		}
		return null;
	}

}
