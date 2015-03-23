package timaxa007.pack.furniture.item;

import timaxa007.pack.furniture.PackFurniture;
import timaxa007.tms.util.ModifiedItem;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemColored extends ModifiedItem {

	@SideOnly(Side.CLIENT) private IIcon[] icon_tex;
	@SideOnly(Side.CLIENT) private IIcon[] icon_ovl;

	public ItemColored(String tag) {
		super(tag);
		setCreativeTab(PackFurniture.tab_furniture);
		//setHasSubtypes(true);
		//setMaxDamage(0);
		setTextureName("timaxa007:");
	}
	/*
public String getUnlocalizedName(ItemStack is) {
NBTTagCompound nbt = is.getTagCompound();
if (tag != null && nbt.hasKey("NameID")) {
return super.getUnlocalizedName() + "." + ItemForStock.item_list[ItemForStock.getID_name(nbt.getString("NameID"))].getName();
} else if (tag != null && nbt.hasKey("ItemID")) {
return super.getUnlocalizedName() + "." + ItemForStock.item_list[nbt.getInteger("ItemID")].getName();
}
return super.getUnlocalizedName();
}

public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
NBTTagCompound nbt = is.getTagCompound();
if (UtilString.isShiftKeyDown()) {
if (tag != null) {
//-------------------------------------------------------------------------------------
if (nbt.hasKey("NameID")) {
if (ItemForStock.item_list[ItemForStock.getID_name(nbt.getString("NameID"))] != null) {
list.add("NameID: " + nbt.getString("NameID") + " / [-] ID: " + ItemForStock.getID_name(nbt.getString("NameID")) + ".");
	if (ItemForStock.item_list[ItemForStock.getID_name(nbt.getString("NameID"))].getType() != "none") {
	list.add(Option.getText("Type") + ": " + ItemForStock.item_list[ItemForStock.getID_name(nbt.getString("NameID"))].getLocalizedType() + ".");
	}
} else {
list.add("Bag Item is in NameID: " + nbt.getString("NameID") + ".");
}
}
//-------------------------------------------------------------------------------------
if (nbt.hasKey("ItemID")) {
if (ItemForStock.item_list[nbt.getInteger("ItemID")] != null) {
if (ItemForStock.item_list[nbt.getInteger("ItemID")].nameID != null) {
list.add("NameID: " + ItemForStock.item_list[nbt.getInteger("ItemID")].nameID + " [-] / ID: " + nbt.getInteger("ItemID") + ".");
}
	if (ItemForStock.item_list[nbt.getInteger("ItemID")].getType() != "none") {
	list.add(Option.getText("Type") + ": " + ItemForStock.item_list[nbt.getInteger("ItemID")].getLocalizedType() + ".");
	}
} else {
list.add("Bag Item is in ItemID: " + nbt.getInteger("ItemID") + ".");
}
}
//-------------------------------------------------------------------------------------
}
} else {
list.add(UtilString.hldshiftinf);
}
}

@SideOnly(Side.CLIENT)
public void getSubItems(Item id, CreativeTabs table, List list) {
for (int i = 1; i < ItemForStock.item_list.length; i++) {
if (ItemForStock.item_list[i] != null && ItemForStock.item_list[i].nameID != "") {
list.add(addNBT(ItemForStock.item_list[i].nameID));
} else if (ItemForStock.item_list[i] != null && ItemForStock.item_list[i].nameID == "") {
list.add(addNBT(i));
}
}
//list.add(new ItemStack(id, 1, 0));
}

public static ItemStack addNBT(String par1) {
ItemStack is = new ItemStack(PackFurniture.proxy.item_colored, 1, 0);
NBTTagCompound nbt = new NBTTagCompound();
nbt.setString("NameID", par1);
is.setTagCompound(tag);
return is;
}

public static ItemStack addNBT(int par1) {
ItemStack is = new ItemStack(PackFurniture.proxy.item_colored, 1, 0);
NBTTagCompound nbt = new NBTTagCompound();
nbt.setInteger("ItemID", par1);
is.setTagCompound(tag);
return is;
}

@SideOnly(Side.CLIENT)
public boolean requiresMultipleRenderPasses() {return true;}

public IIcon getIcon(ItemStack is, int pass) {
NBTTagCompound nbt = is.getTagCompound();
if (tag != null && nbt.hasKey("NameID")) {
if (pass == 0) {
return icon_tex[ItemForStock.getID_name(nbt.getString("NameID"))];
} else {
return icon_ovl[ItemForStock.getID_name(nbt.getString("NameID"))];
}
} else if (tag != null && nbt.hasKey("ItemID")) {
if (pass == 0) {
return icon_tex[nbt.getInteger("ItemID")];
} else {
return icon_ovl[nbt.getInteger("ItemID")];
}
} else {
return itemIcon;
}
}

@SideOnly(Side.CLIENT)
public int getColorFromItemStack(ItemStack is, int pass) {
NBTTagCompound nbt = is.getTagCompound();
if (tag != null && nbt.hasKey("NameID")) {
if (pass == 0) {
return ItemForStock.item_list[ItemForStock.getID_name(nbt.getString("NameID"))].getColor1();
} else {
return ItemForStock.item_list[ItemForStock.getID_name(nbt.getString("NameID"))].getColor2();
}
} else if (tag != null && nbt.hasKey("ItemID")) {
if (pass == 0) {
return ItemForStock.item_list[nbt.getInteger("ItemID")].getColor1();
} else {
return ItemForStock.item_list[nbt.getInteger("ItemID")].getColor2();
}
} else {
return 16777215;
}
}

@SideOnly(Side.CLIENT)
public void registerIcons(IIconRegister ir) {
super.registerIcons(ir);
itemIcon = ir.registerIcon(getIconString() + "testItem");
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
icon_tex[i] = itemIcon;
icon_ovl[i] = itemIcon;
}
}
}
	 */
}