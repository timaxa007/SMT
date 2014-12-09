package mods.timaxa007.pack.mining.items;

import java.util.List;

import mods.timaxa007.pack.mining.PackMining;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemCapsul extends Item {

public ItemCapsul(int id) {
super(id);
setCreativeTab(PackMining.proxy.tabMiningPack);
setHasSubtypes(true);
setMaxDamage(0);
setTextureName("capsul");
setUnlocalizedName("capsul");
}

public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer player) {
NBTTagCompound tag = is.getTagCompound();
//if (!player.capabilities.isCreativeMode) {--is.stackSize;}

if (tag != null) {

if (tag.hasKey("Perm")) {
tag.setInteger("Perm", tag.getInteger("Perm") + 1);
}

is.setTagCompound(tag);
} else {
addTag();
}

return is;
}

@SideOnly(Side.CLIENT)
public void getSubItems(int id, CreativeTabs table, List list) {
list.add(addTag());
//list.add(new ItemStack(id, 1, 0));
}

private static ItemStack addTag() {
ItemStack is = new ItemStack(PackMining.proxy.itemCapsul, 1, 0);
NBTTagCompound tag = new NBTTagCompound();
tag.setInteger("Perm", 0);
is.setTagCompound(tag);
return is;
}

}
