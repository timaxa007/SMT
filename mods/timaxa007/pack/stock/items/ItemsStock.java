package mods.timaxa007.pack.stock.items;

import java.util.List;

import mods.timaxa007.lib.Option;
import mods.timaxa007.pack.stock.PackStock;
import mods.timaxa007.pack.stock.lib.ItemForStock;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemsStock extends Item {

@SideOnly(Side.CLIENT) private IIcon[] icon_tex;
@SideOnly(Side.CLIENT) private IIcon[] icon_ovl;

public ItemsStock() {
super(id);
setCreativeTab(PackStock.proxy.tabStockPack);
setTextureName("timaxa007:");
setUnlocalizedName("items_stock");
}

public void onUpdate(ItemStack is, World world, Entity entity, int par4, boolean flag) {
if (!world.isRemote) {
if (entity instanceof EntityLivingBase) {
if (((EntityLivingBase)entity).getActivePotionEffect(Potion.regeneration) != null) {
//((EntityLivingBase)entity).removePotionEffect(Potion.regeneration.id);
} else {
//((EntityLivingBase)entity).addPotionEffect(new PotionEffect(Potion.regeneration.id, 10, 3));
}
}
}
}

public String getUnlocalizedName(ItemStack is) {
NBTTagCompound tag = is.getTagCompound();
if (tag != null && tag.hasKey("NameID")) {
return super.getUnlocalizedName() + "." + ItemForStock.item_list[ItemForStock.getID_name(tag.getString("NameID"))].getName();
} else if (tag != null && tag.hasKey("ItemID")) {
return super.getUnlocalizedName() + "." + ItemForStock.item_list[tag.getInteger("ItemID")].getName();
}
return super.getUnlocalizedName();
}

public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
NBTTagCompound tag = is.getTagCompound();
if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
if (tag != null) {
//-------------------------------------------------------------------------------------
if (tag.hasKey("NameID")) {
if (ItemForStock.item_list[ItemForStock.getID_name(tag.getString("NameID"))] != null) {
list.add("NameID: " + tag.getString("NameID") + " / [-] ID: " + ItemForStock.getID_name(tag.getString("NameID")) + ".");
	if (ItemForStock.item_list[ItemForStock.getID_name(tag.getString("NameID"))].getType() != "none") {
	list.add(Option.getText("Type") + ": " + ItemForStock.item_list[ItemForStock.getID_name(tag.getString("NameID"))].getLocalizedType() + ".");
	}
} else {
list.add("Bag Item is in NameID: " + tag.getString("NameID") + ".");
}
}
//-------------------------------------------------------------------------------------
if (tag.hasKey("ItemID")) {
if (ItemForStock.item_list[tag.getInteger("ItemID")] != null) {
if (ItemForStock.item_list[tag.getInteger("ItemID")].nameID != null) {
list.add("NameID: " + ItemForStock.item_list[tag.getInteger("ItemID")].nameID + " [-] / ID: " + tag.getInteger("ItemID") + ".");
}
	if (ItemForStock.item_list[tag.getInteger("ItemID")].getType() != "none") {
	list.add(Option.getText("Type") + ": " + ItemForStock.item_list[tag.getInteger("ItemID")].getLocalizedType() + ".");
	}
} else {
list.add("Bag Item is in ItemID: " + tag.getInteger("ItemID") + ".");
}
}
//-------------------------------------------------------------------------------------
}
} else {
list.add(Option.prshift);
}
}

@SideOnly(Side.CLIENT)
public void getSubItems(int id, CreativeTabs table, List list) {
for (int i = 1; i < ItemForStock.item_list.length; i++) {
if (ItemForStock.item_list[i] != null && ItemForStock.item_list[i].nameID != "") {
list.add(addTag(ItemForStock.item_list[i].nameID));
} else if (ItemForStock.item_list[i] != null && ItemForStock.item_list[i].nameID == "") {
list.add(addTag(i));
}
}
//list.add(new ItemStack(id, 1, 0));
}

private static ItemStack addTag(String par1) {
ItemStack is = new ItemStack(PackStock.proxy.items_for_stock, 1, 0);
NBTTagCompound tag = new NBTTagCompound();
tag.setString("NameID", par1);
is.setTagCompound(tag);
return is;
}

private static ItemStack addTag(int par1) {
ItemStack is = new ItemStack(PackStock.proxy.items_for_stock, 1, 0);
NBTTagCompound tag = new NBTTagCompound();
tag.setInteger("ItemID", par1);
is.setTagCompound(tag);
return is;
}

@SideOnly(Side.CLIENT)
public boolean requiresMultipleRenderPasses() {return true;}

public IIcon getIcon(ItemStack is, int pass) {
NBTTagCompound tag = is.getTagCompound();
if (tag != null && tag.hasKey("NameID")) {
if (pass == 0) {
return icon_tex[ItemForStock.getID_name(tag.getString("NameID"))];
} else {
return icon_ovl[ItemForStock.getID_name(tag.getString("NameID"))];
}
} else if (tag != null && tag.hasKey("ItemID")) {
if (pass == 0) {
return icon_tex[tag.getInteger("ItemID")];
} else {
return icon_ovl[tag.getInteger("ItemID")];
}
} else {
return itemIIcon;
}
}

@SideOnly(Side.CLIENT)
public int getColorFromItemStack(ItemStack is, int pass) {
NBTTagCompound tag = is.getTagCompound();
if (tag != null && tag.hasKey("NameID")) {
if (pass == 0) {
return ItemForStock.item_list[ItemForStock.getID_name(tag.getString("NameID"))].getColor1();
} else {
return ItemForStock.item_list[ItemForStock.getID_name(tag.getString("NameID"))].getColor2();
}
} else if (tag != null && tag.hasKey("ItemID")) {
if (pass == 0) {
return ItemForStock.item_list[tag.getInteger("ItemID")].getColor1();
} else {
return ItemForStock.item_list[tag.getInteger("ItemID")].getColor2();
}
} else {
return 16777215;
}
}

@SideOnly(Side.CLIENT)
public void registerIcons(IIconRegister ir) {
super.registerIcons(ir);
itemIIcon = ir.registerIcon(getIconString() + "testItem");
icon_tex = new IIcon[ItemForStock.item_list.length];
icon_ovl = new IIcon[ItemForStock.item_list.length];
for (int i = 0; i < ItemForStock.item_list.length; i++) {
if (ItemForStock.item_list[i] != null) {
icon_tex[i] = ir.registerIcon(getIconString() + ItemForStock.item_list[i].getTexture1());
	if (ItemForStock.item_list[i].getTexture2() == ItemForStock.item_list[i].getTexture1()) {
	icon_ovl[i] = ir.registerIcon(getIconString() + "empty");
	} else {
	icon_ovl[i] = ir.registerIcon(getIconString() + ItemForStock.item_list[i].getTexture2());
	}
} else {
icon_tex[i] = itemIIcon;
icon_ovl[i] = itemIIcon;
}
}
}

}
