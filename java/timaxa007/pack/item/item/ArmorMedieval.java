package timaxa007.pack.item.item;

import java.util.List;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import timaxa007.pack.item.PackItems;
import timaxa007.pack.item.render.model.ModelArmorMedieval;
import timaxa007.tms.util.ModifiedItemArmor;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ArmorMedieval extends ModifiedItemArmor {

	@SideOnly(Side.CLIENT) private IIcon[] iconArray;

	public static final String[] type_medieval = new String[] {
		"gold", 
		"iron"
	};

	public ArmorMedieval(String tag, ArmorMaterial par2, int par3, int par4) {
		super(tag, par2, par3, par4);
		setCreativeTab(PackItems.tab_items);
		setTextureName("timaxa007:armor/medieval");
	}

	public void onArmorTickUpdate(World world, EntityPlayer player, ItemStack is) {

	}

	public String getUnlocalizedName(ItemStack is) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null && nbt.hasKey("TypeMedieval"))
			return super.getUnlocalizedName() + "." + type_medieval[nbt.getInteger("TypeMedieval")];
		else
			return super.getUnlocalizedName();
	}

	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null && nbt.hasKey("TypeMedieval")) {
			list.add("TypeMask: " + nbt.getInteger("TypeMedieval") + "/" + type_medieval[nbt.getInteger("TypeMedieval")]);
		}
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item id, CreativeTabs table, List list) {
		for (int j = 0; j < type_medieval.length; ++j) {
			list.add(addNBT(new ItemStack(id, 1, 0), j));
		}
		//list.add(new ItemStack(id, 1, 0));
	}

	public static ItemStack addNBT(ItemStack par1, int par2) {
		ItemStack is = par1;
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setInteger("TypeMedieval", par2);
		is.setTagCompound(nbt);
		return is;
	}

	public String getArmorTexture(ItemStack is, Entity entity, int slot, String type) {
		/*NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null && nbt.hasKey("TypeMedieval")) {
			return "timaxa007:textures/armor/mask_" + type_medieval[nbt.getInteger("TypeMedieval")] + ".png";
		} else {*/
		return "timaxa007:textures/armor/mask.png";
		//}
		//" + (armorType == 2 ? 2 : 1) + "
	}

	//int type = ((ItemArmor)itemStack.getItem()).armorType;

	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entity, ItemStack is, int armorSlot) {
		if (armorSlot != armorType) return null;

		if (is != null && is.getItem() instanceof ArmorMedieval) {
			NBTTagCompound nbt = is.getTagCompound();
			ModelArmorMedieval model_armor_medieval;

			if (nbt.hasKey("TypeMedieval")) {
				model_armor_medieval = new ModelArmorMedieval(nbt.getInteger("TypeMedieval"), armorType);
			} else {
				model_armor_medieval = new ModelArmorMedieval();
			}

			model_armor_medieval.bipedHead.showModel = false;
			model_armor_medieval.bipedHeadwear.showModel = false;
			model_armor_medieval.bipedBody.showModel = false;
			model_armor_medieval.bipedRightArm.showModel = false;
			model_armor_medieval.bipedLeftArm.showModel = false;
			model_armor_medieval.bipedRightLeg.showModel = false;
			model_armor_medieval.bipedLeftLeg.showModel = false;
			model_armor_medieval.bipedCloak.showModel = false;
			model_armor_medieval.isSneak = entity.isSneaking();
			model_armor_medieval.isRiding = entity.isRiding();
			model_armor_medieval.isChild = entity.isChild();
			//model_armor_medieval.onGround = entity.onGround();
			if (entity instanceof EntityPlayer) {
				model_armor_medieval.heldItemRight = ((EntityPlayer)entity).getCurrentEquippedItem() != null ? 1 :0;
				model_armor_medieval.aimedBow = ((EntityPlayer)entity).getItemInUseDuration() > 2;
			}
			return model_armor_medieval;
		}
		return null;
	}

}
