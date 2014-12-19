package mods.timaxa007.pack.furniture.item;

import java.util.List;

import mods.timaxa007.pack.furniture.PackFurniture;
import mods.timaxa007.pack.furniture.render.model.ModelMask;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ArmorMasks extends ItemArmor {

	@SideOnly(Side.CLIENT) private IIcon[] iconArray;

	public static final String[] type_mask = new String[] {
		"mini", 
		"max", 
		"bla", 
		"4", 
		"5", 
		"test"
	};

	public ArmorMasks() {
		super(PackFurniture.proxy.COSTUME, 0, 0);
		setCreativeTab(PackFurniture.tab_furniture);
		setTextureName("timaxa007:armor/mask");
		setUnlocalizedName("armor_masks");
	}

	public void onArmorTickUpdate(World world, EntityPlayer player, ItemStack is) {

	}

	public String getUnlocalizedName(ItemStack is) {
		NBTTagCompound tag = is.getTagCompound();
		if (tag != null && tag.hasKey("TypeMask")) {
			return super.getUnlocalizedName() + "." + type_mask[tag.getInteger("TypeMask")];
		} else {
			return super.getUnlocalizedName();
		}
	}

	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
		NBTTagCompound tag = is.getTagCompound();
		if (tag != null && tag.hasKey("TypeMask")) {
			list.add("TypeMask: " + tag.getInteger("TypeMask") + "/" + type_mask[tag.getInteger("TypeMask")]);
		} else {

		}
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item id, CreativeTabs table, List list) {
		for (int j = 0; j < type_mask.length; ++j) {
			list.add(addTag(j));
		}
		//list.add(new ItemStack(id, 1, 0));
	}

	private static ItemStack addTag(int par1) {
		ItemStack is = new ItemStack(PackFurniture.proxy.armor_masks, 1, 0);
		NBTTagCompound tag = new NBTTagCompound();
		tag.setInteger("TypeMask", par1);
		is.setTagCompound(tag);
		return is;
	}

	public String getArmorTexture(ItemStack is, Entity entity, int slot, String type) {
		NBTTagCompound tag = is.getTagCompound();
		if (tag != null && tag.hasKey("TypeMask"))
			return "timaxa007:textures/armor/mask_" + type_mask[tag.getInteger("TypeMask")] + ".png";
		else 
			return "timaxa007:textures/armor/mask.png";
	}

	//int type = ((ItemArmor)itemStack.getItem()).armorType;

	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entity, ItemStack is, int armorSlot) {
		NBTTagCompound tag = is.getTagCompound();
		if (armorSlot != 0) return null;
		if (is != null && is.getItem() instanceof ArmorMasks) {
			ModelMask model_mask = new ModelMask(0);

			if (tag != null && tag.hasKey("TypeMask")) {
				if (tag.getInteger("TypeMask") == 1) {model_mask = new ModelMask(1);}
				else if (tag.getInteger("TypeMask") == 2) {model_mask = new ModelMask(2);}
				else if (tag.getInteger("TypeMask") == 3) {model_mask = new ModelMask(3);}
				else {model_mask = new ModelMask(0);}
			}

			model_mask.bipedHead.showModel = false;
			model_mask.bipedHeadwear.showModel = false;
			model_mask.bipedBody.showModel = false;
			model_mask.bipedRightArm.showModel = false;
			model_mask.bipedLeftArm.showModel = false;
			model_mask.bipedRightLeg.showModel = false;
			model_mask.bipedLeftLeg.showModel = false;
			model_mask.bipedCloak.showModel = false;
			model_mask.isSneak = entity.isSneaking();
			model_mask.isRiding = entity.isRiding();
			model_mask.isChild = entity.isChild();
			//model_mask.onGround = entity.onGround();
			if (entity instanceof EntityPlayer) {
				model_mask.heldItemRight = ((EntityPlayer)entity).getCurrentEquippedItem() != null ? 1 :0;
				model_mask.aimedBow = ((EntityPlayer)entity).getItemInUseDuration() > 2;
			}
			return model_mask;
		}
		return null;
	}

	@SideOnly(Side.CLIENT)
	public boolean requiresMultipleRenderPasses() {
		return true;
	}

	public IIcon getIcon(ItemStack is, int pass) {
		NBTTagCompound tag = is.getTagCompound();
		if (tag != null && tag.hasKey("TypeMask")) {
			return iconArray[tag.getInteger("TypeMask")];
		} else {
			return itemIcon;
		}
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister ir) {
		super.registerIcons(ir);
		itemIcon = ir.registerIcon(getIconString());
		iconArray = new IIcon[type_mask.length];
		for (int i = 0; i < type_mask.length; ++i) {
			iconArray[i] = ir.registerIcon(getIconString() + "_" + type_mask[i]);
		}
	}

}
