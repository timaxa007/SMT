package timaxa007.pack.item.item;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import timaxa007.pack.item.PackItem;
import timaxa007.pack.item.render.model.ModelArmorTechne;
import timaxa007.smt.object.ModifiedItem;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ArmorTechne extends ModifiedItem {

	public ArmorTechne(String tag) {
		super(tag);
		setCreativeTab(PackItem.tab_items);
	}

	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {

	}

	public boolean isValidArmor(ItemStack stack, int armorType, Entity entity) {
		/*
		if (armorType == 0)
			return this == Item.getItemFromBlock(Blocks.pumpkin) || this == Items.skull;
		 */
		return true;
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		return null;
	}

	@SideOnly(Side.CLIENT) private static ModelBiped model;
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entity, ItemStack is, int armorSlot) {
		System.out.println("gg");

		if (is != null && is.getItem() instanceof ArmorTechne) {
			model = new ModelArmorTechne();

			model.bipedHead.showModel = false;
			model.bipedHeadwear.showModel = false;
			model.bipedBody.showModel = false;
			model.bipedRightArm.showModel = false;
			model.bipedLeftArm.showModel = false;
			model.bipedRightLeg.showModel = false;
			model.bipedLeftLeg.showModel = false;
			model.bipedCloak.showModel = false;
			model.isSneak = entity.isSneaking();
			model.isRiding = entity.isRiding();
			model.isChild = entity.isChild();
			//model.onGround = entity.onGround();
			
			if (entity instanceof EntityPlayer) {
				model.heldItemRight = ((EntityPlayer)entity).getCurrentEquippedItem() != null ? 1 :0;
				model.aimedBow = ((EntityPlayer)entity).getItemInUseDuration() > 2;
			}
			
		} else model = null;

		return model;
	}

}
