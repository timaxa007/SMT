package smt.pack.decorative.item;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import smt.pack.decorative.SMTDecorative;
import smt.pack.decorative.client.model.ModelHatWitch;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemArmorDecorative extends ItemArmor {

	public ItemArmorDecorative(int typeArmor) {
		super(ArmorMaterial.IRON, 0, typeArmor);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		return SMTDecorative.MODID + ":/textures/armor/ModelArmorTest.png";
	}

	@SideOnly(Side.CLIENT)
	@Override
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot) {
		return fillingArmorModel(new ModelHatWitch(), entityLiving);
	}

	@SideOnly(Side.CLIENT)
	public static ModelBiped fillingArmorModel(ModelBiped model, EntityLivingBase entityLiving) {
		if (model == null) return model;
		model.bipedHead.showModel = 
				model.bipedHeadwear.showModel = 
				model.bipedBody.showModel = 
				model.bipedRightArm.showModel = 
				model.bipedLeftArm.showModel = 
				model.bipedRightLeg.showModel = 
				model.bipedLeftLeg.showModel = false;
		model.isSneak = entityLiving.isSneaking();
		model.isRiding = entityLiving.isRiding();
		model.isChild = entityLiving.isChild();
		ItemStack held_item = entityLiving.getEquipmentInSlot(0);
		if (held_item != null) {
			model.heldItemRight = 1;

			if (entityLiving instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer)entityLiving;

				if (player.getItemInUseCount() > 0) {
					EnumAction enumaction = held_item.getItemUseAction();
					if (enumaction == EnumAction.bow) model.aimedBow = true;
					else if (enumaction == EnumAction.block) model.heldItemRight = 3;
				}

			}

		} else model.heldItemRight = 0;

		if (entityLiving instanceof EntitySkeleton)
			model.aimedBow = ((EntitySkeleton)entityLiving).getSkeletonType() == 1;

		return model;
	}

}
