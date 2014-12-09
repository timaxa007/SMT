package mods.timaxa007.Pack.Magic.Items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.timaxa007.Pack.Magic.PackMagic;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class ItemGlobular extends Item {

@SideOnly(Side.CLIENT) private Icon icon_overlay;

public ItemGlobular(int id) {
super(id);
setCreativeTab(PackMagic.proxy.tabMagicPack);
setTextureName("timaxa007:testItem1");
setUnlocalizedName("globular");
}

public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer player) {
NBTTagCompound tag = is.getTagCompound();
if (tag != null && tag.hasKey("Active")) {
tag.setBoolean("Active", tag.getBoolean("Active")?false:true);
is.setTagCompound(tag);
return is;
}/* else {
--is.stackSize;
addTag();
}*/
return is;
}

public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
NBTTagCompound tag = is.getTagCompound();
if (tag != null && tag.hasKey("Active")) {
list.add("Active: " + tag.getBoolean("Active") + ".");
}
}

@SideOnly(Side.CLIENT)
public void getSubItems(int id, CreativeTabs table, List list) {
list.add(addTag());
}

private static ItemStack addTag() {
ItemStack is = new ItemStack(PackMagic.proxy.item_globular, 1, 0);
NBTTagCompound tag = new NBTTagCompound();
tag.setBoolean("Active", false);
is.setTagCompound(tag);
return is;
}

@SideOnly(Side.CLIENT)
public boolean requiresMultipleRenderPasses() {return true;}

@SideOnly(Side.CLIENT)
public Icon getIcon(ItemStack is, int pass) {
NBTTagCompound tag = is.getTagCompound();
if(tag != null && tag.hasKey("Active")) {

if (pass == 0) {
return tag.getBoolean("Active")?icon_overlay:itemIcon;
} else {
return itemIcon;
}

}else{
return getIconFromDamageForRenderPass(is.getItemDamage(), pass);
}
}

@SideOnly(Side.CLIENT)
public void registerIcons(IconRegister ir) {
super.registerIcons(ir);
//itemIcon = ir.registerIcon("timaxa007:testItem1");
icon_overlay = ir.registerIcon(getIconString() + "_overlay");
}

}
