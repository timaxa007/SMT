package timaxa007.pack.furniture.item;

import java.util.List;

import timaxa007.pack.furniture.PackFurniture;
import timaxa007.pack.furniture.render.model.ModelBackpacks;
import timaxa007.tms.util.ModifiedItemArmor;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ArmorBackpacks extends ModifiedItemArmor {

	@SideOnly(Side.CLIENT) private IIcon[] icon_b;

	public static String[] type_packpacks = new String[] {
		"test", 
		"none"
	};

	public ArmorBackpacks(String tag) {
		super(tag, ArmorMaterial.IRON, 0, 1);
		setCreativeTab(PackFurniture.tab_furniture);
		setTextureName("timaxa007:armor/backpack");
	}

	public void onArmorTickUpdate(World world, EntityPlayer player, ItemStack is) {

	}

	public String getUnlocalizedName(ItemStack is) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null && nbt.hasKey("TypeBackpack"))
			return super.getUnlocalizedName() + "." + nbt.getInteger("TypeBackpack");
		return super.getUnlocalizedName();
	}

	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null) {
			if (nbt.hasKey("TypeBackpack"))
				list.add("TypeBackpack: " + nbt.getInteger("TypeBackpack") + ".");
		}
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item id, CreativeTabs table, List list) {
		for (int j = 0; j < type_packpacks.length; ++j) {
			list.add(addNBT(j));
		}
		//list.add(new ItemStack(id, 1, 0));
	}

	public static ItemStack addNBT(int par1) {
		ItemStack is = new ItemStack(PackFurniture.proxy.item.armor_backpacks, 1, 0);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setInteger("TypeBackpack", par1);
		is.setTagCompound(nbt);
		return is;
	}

	public String getArmorTexture(ItemStack is, Entity entity, int slot, String type) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null && nbt.hasKey("TypeBackpack"))
			return "timaxa007:textures/armor/backpack_" + nbt.getInteger("TypeBackpack") + ".png";
		else
			return "timaxa007:textures/armor/backpack.png";
	}

	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entity, ItemStack is, int armorSlot) {
		NBTTagCompound nbt = is.getTagCompound();
		if (armorSlot != 1) return null;
		if (is != null && is.getItem() instanceof ArmorBackpacks) {
			ModelBackpacks model_backpack = new ModelBackpacks(0);

			if (nbt != null && nbt.hasKey("TypeBackpack")) {
				if (nbt.getInteger("TypeBackpack") == 1) {model_backpack = new ModelBackpacks(1);}
				else if (nbt.getInteger("TypeBackpack") == 2) {model_backpack = new ModelBackpacks(2);}
				else if (nbt.getInteger("TypeBackpack") == 3) {model_backpack = new ModelBackpacks(3);}
				else {model_backpack = new ModelBackpacks(0);}

			}

			model_backpack.bipedHead.showModel = false;
			model_backpack.bipedHeadwear.showModel = false;
			model_backpack.bipedBody.showModel = false;
			model_backpack.bipedRightArm.showModel = false;
			model_backpack.bipedLeftArm.showModel = false;
			model_backpack.bipedRightLeg.showModel = false;
			model_backpack.bipedLeftLeg.showModel = false;
			model_backpack.bipedCloak.showModel = false;
			model_backpack.isSneak = entity.isSneaking();
			model_backpack.isRiding = entity.isRiding();
			model_backpack.isChild = entity.isChild();
			//model_mask.onGround = entity.onGround();
			if (entity instanceof EntityPlayer) {
				model_backpack.heldItemRight = ((EntityPlayer)entity).getCurrentEquippedItem() != null ? 1 :0;
				model_backpack.aimedBow = ((EntityPlayer)entity).getItemInUseDuration() > 2;
			}
			return model_backpack;
		}
		return null;
	}

	@SideOnly(Side.CLIENT)
	public boolean requiresMultipleRenderPasses() {return true;}

	public IIcon getIcon(ItemStack is, int pass) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null && nbt.hasKey("TypeBackpack"))
			return icon_b[nbt.getInteger("TypeBackpack")];
		else
			return itemIcon;
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister ir) {
		super.registerIcons(ir);

		itemIcon = ir.registerIcon(getIconString());

		icon_b = new IIcon[type_packpacks.length];

		for (int i = 0; i < type_packpacks.length; ++i) {
			icon_b[i] = ir.registerIcon(getIconString() + "_" + type_packpacks[i]);
		}
	}

}