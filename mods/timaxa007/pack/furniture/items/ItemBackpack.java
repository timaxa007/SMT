package mods.timaxa007.pack.furniture.items;

import java.util.List;

import mods.timaxa007.pack.furniture.PackFurniture;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBackpack extends Item {
public static ItemStack[] slotsBackpack = new ItemStack[27];

public ItemBackpack(int id) {
super(id);
setCreativeTab(PackFurniture.proxy.tabFurniturePack);
setTextureName("timaxa007:backpack");
setUnlocalizedName("backpack");
}

public ItemStack onItemRightClick(ItemStack is, World wrd, EntityPlayer player) {
if(player.isSneaking()) {

}else{
player.openGui(PackFurniture.instance, PackFurniture.proxy.guiBackpack, wrd, 0, 0, 0);
}
return is;
}
/*
public boolean onItemUse(ItemStack is, EntityPlayer player, World wrd, int x, int y, int z, int meta, float hitX, float hitY, float hitZ) {
if(player.isSneaking()) {
return false;
}else{
player.openGui(PackFurniture.instance, PackFurniture.guiBackpack, wrd, x, y, z);
return true;
}
}
*/
@SideOnly(Side.CLIENT)
public void getSubItems(int id, CreativeTabs table, List list) {
list.add(addTag());
list.add(new ItemStack(id, 1, 0));
}

private static ItemStack addTag() {
ItemStack is=new ItemStack(PackFurniture.proxy.item_backpack);
NBTTagCompound tag=new NBTTagCompound();
NBTTagList nbttaglist=new NBTTagList();
for(int i=0;i<slotsBackpack.length;++i) {
if(slotsBackpack[i]!=null) {
NBTTagCompound nbttagcompound1=new NBTTagCompound();
nbttagcompound1.setByte("Slot", (byte)i);
slotsBackpack[i].writeToNBT(nbttagcompound1);
nbttaglist.appendTag(nbttagcompound1);
}
}
tag.setTag("Items", nbttaglist);
is.setTagCompound(tag);
return is;
}

}
