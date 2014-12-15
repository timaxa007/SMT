package mods.timaxa007.pack.magic.items;

import java.util.List;

import mods.timaxa007.pack.magic.PackMagic;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTeleport extends Item {

public ItemTeleport() {
super();
setHasSubtypes(true);
setMaxDamage(0);
setCreativeTab(PackMagic.proxy.tab_magic);
setUnlocalizedName("teleport");
}

public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer player) {
NBTTagCompound tag = is.getTagCompound();
if (player.worldObj.provider.isSurfaceWorld()) {
if (tag == null) {
--is.stackSize;
player.inventory.addItemStackToInventory(addTag(player.posX, player.posY, player.posZ));
} else {
if (tag.hasKey("CordX") && tag.hasKey("CordY") && tag.hasKey("CordZ")) {
player.setPosition(tag.getDouble("CordX"), tag.getDouble("CordY") + 2.0D, tag.getDouble("CordZ"));
}
}
}
return is;
}

public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
NBTTagCompound tag = is.getTagCompound();
if (tag != null && tag.hasKey("CordX") && tag.hasKey("CordY") && tag.hasKey("CordZ")) {
list.add("CordX - " + tag.getDouble("CordX") + ", CordY - " + tag.getDouble("CordY") + ", CordZ - " + tag.getDouble("CordXZ"));
}
}

@SideOnly(Side.CLIENT)
public void getSubItems(Item id, CreativeTabs table, List list) {
list.add(new ItemStack(id, 1, 0));
}

private static ItemStack addTag(double x, double y, double z) {
ItemStack is = new ItemStack(PackMagic.proxy.item_teleport, 1, 0);
NBTTagCompound tag = new NBTTagCompound();
//tag.setBoolean("SurfaceWorld", true);
tag.setDouble("CordX", x);
tag.setDouble("CordY", y);
tag.setDouble("CordZ", z);
is.setTagCompound(tag);
return is;
}

}
