package timaxa007.pack.furniture.item;

import java.util.List;

import timaxa007.pack.furniture.PackFurniture;
import timaxa007.pack.furniture.render.model.ModelMask;
import timaxa007.tms.util.ModifiedItemArmor;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ArmorMasks extends ModifiedItemArmor {

	@SideOnly(Side.CLIENT) private IIcon[] iconArray;

	public static final String[] type_mask = new String[] {
		"mini", 
		"max", 
		"bla", 
		"4", 
		"5", 
		"test"
	};

	public ArmorMasks(String tag) {
		super(tag, PackFurniture.proxy.item.COSTUME, 0, 0);
		setCreativeTab(PackFurniture.tab_furniture);
		setTextureName("timaxa007:armor/mask");
	}

	public void onArmorTickUpdate(World world, EntityPlayer player, ItemStack is) {

	}

	public String getUnlocalizedName(ItemStack is) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null && nbt.hasKey("TypeMask"))
			return super.getUnlocalizedName() + "." + type_mask[nbt.getInteger("TypeMask")];
		else
			return super.getUnlocalizedName();
	}

	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null) {
			if (nbt.hasKey("TypeMask"))
				list.add("TypeMask: " + nbt.getInteger("TypeMask") + "/" + type_mask[nbt.getInteger("TypeMask")]);
		}
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item id, CreativeTabs table, List list) {
		for (int j = 0; j < type_mask.length; ++j) {
			list.add(addNBT(j));
		}
		//list.add(new ItemStack(id, 1, 0));
	}

	public static ItemStack addNBT(int par1) {
		ItemStack is = new ItemStack(PackFurniture.proxy.item.armor_masks, 1, 0);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setInteger("TypeMask", par1);
		is.setTagCompound(nbt);
		return is;
	}

	public String getArmorTexture(ItemStack is, Entity entity, int slot, String type) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null && nbt.hasKey("TypeMask"))
			return "timaxa007:textures/armor/mask_" + type_mask[nbt.getInteger("TypeMask")] + ".png";
		else 
			return "timaxa007:textures/armor/mask.png";
	}

	//int type = ((ItemArmor)itemStack.getItem()).armorType;

	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entity, ItemStack is, int armorSlot) {
		NBTTagCompound nbt = is.getTagCompound();
		if (armorSlot != 0) return null;
		if (is != null && is.getItem() instanceof ArmorMasks) {
			ModelMask model_mask = new ModelMask(0);

			if (nbt != null && nbt.hasKey("TypeMask")) {
				if (nbt.getInteger("TypeMask") == 1) {model_mask = new ModelMask(1);}
				else if (nbt.getInteger("TypeMask") == 2) {model_mask = new ModelMask(2);}
				else if (nbt.getInteger("TypeMask") == 3) {model_mask = new ModelMask(3);}
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
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null && nbt.hasKey("TypeMask"))
			return iconArray[nbt.getInteger("TypeMask")];
		else
			return itemIcon;
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
