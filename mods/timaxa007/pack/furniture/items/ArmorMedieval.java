package mods.timaxa007.pack.furniture.items;

import java.util.List;

import mods.timaxa007.pack.furniture.PackFurniture;
import mods.timaxa007.pack.furniture.model.ModelArmorMedieval;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ArmorMedieval extends ItemArmor {

@SideOnly(Side.CLIENT) private Icon[] iconArray;

public static final String[] type_medieval = new String[] {
"gold", 
"iron"
};

public ArmorMedieval(int id, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
super(id, par2EnumArmorMaterial, par3, par4);
setCreativeTab(PackFurniture.proxy.tabFurniturePack);
setTextureName("timaxa007:armor/medieval");
setUnlocalizedName("armor_medieval");
}

public void onArmorTickUpdate(World world, EntityPlayer player, ItemStack is) {

}

public String getUnlocalizedName(ItemStack is) {
NBTTagCompound tag = is.getTagCompound();
if (tag != null && tag.hasKey("TypeMedieval")) {
return super.getUnlocalizedName() + "." + type_medieval[tag.getInteger("TypeMedieval")];
} else {
return super.getUnlocalizedName();
}
}

public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
NBTTagCompound tag = is.getTagCompound();
if (tag != null && tag.hasKey("TypeMedieval")) {
list.add("TypeMask: " + tag.getInteger("TypeMedieval") + "/" + type_medieval[tag.getInteger("TypeMedieval")]);
}
}

@SideOnly(Side.CLIENT)
public void getSubItems(int id, CreativeTabs table, List list) {
for (int j = 0; j < type_medieval.length; ++j) {
list.add(addTag(new ItemStack(id, 1, 0), j));
}
//list.add(new ItemStack(id, 1, 0));
}

private static ItemStack addTag(ItemStack par1, int par2) {
ItemStack is = par1;
NBTTagCompound tag = new NBTTagCompound();
tag.setInteger("TypeMedieval", par2);
is.setTagCompound(tag);
return is;
}

public String getArmorTexture(ItemStack is, Entity entity, int slot, String type) {
/*NBTTagCompound tag = is.getTagCompound();
if (tag != null && tag.hasKey("TypeMedieval")) {
return "timaxa007:textures/armor/mask_" + type_medieval[tag.getInteger("TypeMedieval")] + ".png";
} else {*/
return "timaxa007:textures/armor/mask.png";
//}
}

//int type = ((ItemArmor)itemStack.getItem()).armorType;

@SideOnly(Side.CLIENT)
public ModelBiped getArmorModel(EntityLivingBase entity, ItemStack is, int armorSlot) {
if (armorSlot != armorType) return null;

if (is != null && is.getItem() instanceof ArmorMedieval) {
NBTTagCompound tag = is.getTagCompound();
ModelArmorMedieval model_armor_medieval;

if (tag.hasKey("TypeMedieval")) {
model_armor_medieval = new ModelArmorMedieval(tag.getInteger("TypeMedieval"), armorType);
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
model_armor_medieval.heldItemRight = entity.getCurrentItemOrArmor(0) != null ? 1 :0;
if (entity instanceof EntityPlayer) {
model_armor_medieval.aimedBow = ((EntityPlayer)entity).getItemInUseDuration() > 2;
}
return model_armor_medieval;
}
return null;
}

}
