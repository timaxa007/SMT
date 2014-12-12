package mods.timaxa007.pack.furniture.items;

import java.util.List;

import mods.timaxa007.pack.furniture.PackFurniture;
import mods.timaxa007.pack.furniture.model.ModelBackpacks;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ArmorBackpacks extends ItemArmor {

@SideOnly(Side.CLIENT) private IIcon[] iconArray;

public static String[] type_packpacks = new String[] {
"test", 
"none"
};

public ArmorBackpacks() {
super(ArmorMaterial.IRON, 0, 1);
setCreativeTab(PackFurniture.proxy.tab_furniture_pack);
setTextureName("timaxa007:armor/backpack");
setUnlocalizedName("armor_backpacks");
}

public void onArmorTickUpdate(World world, EntityPlayer player, ItemStack is) {

}

public String getUnlocalizedName(ItemStack is) {
NBTTagCompound tag = is.getTagCompound();
if (tag != null && tag.hasKey("TypeBackpack")) {
return super.getUnlocalizedName() + "." + tag.getInteger("TypeBackpack");
} else {
return super.getUnlocalizedName();
}
}

public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
NBTTagCompound tag = is.getTagCompound();
if (tag != null && tag.hasKey("TypeBackpack")) {
list.add("TypeBackpack: " + tag.getInteger("TypeBackpack") + ".");
} else {

}
}

@SideOnly(Side.CLIENT)
public void getSubItems(int id, CreativeTabs table, List list) {
for (int j = 0; j < type_packpacks.length; ++j) {
list.add(addTag(j));
}
//list.add(new ItemStack(id, 1, 0));
}

private static ItemStack addTag(int par1) {
ItemStack is = new ItemStack(PackFurniture.proxy.armor_backpacks, 1, 0);
NBTTagCompound tag = new NBTTagCompound();
tag.setInteger("TypeBackpack", par1);
is.setTagCompound(tag);
return is;
}

public String getArmorTexture(ItemStack is, Entity entity, int slot, String type) {
NBTTagCompound tag = is.getTagCompound();
if (tag != null && tag.hasKey("TypeBackpack")) {
return "timaxa007:textures/armor/backpack_" + tag.getInteger("TypeBackpack") + ".png";
} else {
return "timaxa007:textures/armor/backpack.png";
}
}

@SideOnly(Side.CLIENT)
public ModelBiped getArmorModel(EntityLivingBase entity, ItemStack is, int armorSlot) {
NBTTagCompound tag = is.getTagCompound();
if (armorSlot != 1) return null;
if (is != null && is.getItem() instanceof ArmorBackpacks) {
ModelBackpacks model_backpack = new ModelBackpacks(0);

if (tag != null && tag.hasKey("TypeBackpack")) {
if (tag.getInteger("TypeBackpack") == 1) {model_backpack = new ModelBackpacks(1);}
else if (tag.getInteger("TypeBackpack") == 2) {model_backpack = new ModelBackpacks(2);}
else if (tag.getInteger("TypeBackpack") == 3) {model_backpack = new ModelBackpacks(3);}
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
NBTTagCompound tag = is.getTagCompound();
if (tag != null && tag.hasKey("TypeBackpack")) {
return iconArray[tag.getInteger("TypeBackpack")];
} else {
return itemIcon;
}
}

@SideOnly(Side.CLIENT)
public void registerIcons(IIconRegister ir) {
super.registerIcons(ir);
itemIcon = ir.registerIcon(getIconString());
iconArray = new IIcon[type_packpacks.length];
for (int i = 0; i < type_packpacks.length; ++i) {
iconArray[i] = ir.registerIcon(getIconString() + "_" + type_packpacks[i]);
}
}

}
