package mods.timaxa007.pack.furniture;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class RecipeArmorColor implements IRecipe {

@Override
public boolean matches(InventoryCrafting ic, World world) {

ItemStack cmj = ic.getStackInSlot(0);
ItemStack cmh = ic.getStackInSlot(1);

if (
(cmj != null && cmh != null && cmj != cmh) &&
(cmj != null && cmj.getItem() == new ItemStack(PackFurniture.proxy.armor_wool_colors_helmet).getItem() && cmj.getTagCompound() != null) && 
(cmh != null && cmh.getItem() == new ItemStack(PackFurniture.proxy.item_colored).getItem() && cmj.getTagCompound().getInteger("Color") == 14)
) {
return true;
}

return false;
}

@Override
public ItemStack getCraftingResult(InventoryCrafting ic) {

ItemStack cmj = ic.getStackInSlot(0);
ItemStack cmh = ic.getStackInSlot(1);

if (
(cmj != null && cmh != null && cmj != cmh) &&
(cmj.getItem() == new ItemStack(PackFurniture.proxy.armor_wool_colors_helmet).getItem() && cmj.getTagCompound() != null && cmj.getTagCompound().getInteger("Color") == 14) && 
(cmh.getItem() == new ItemStack(PackFurniture.proxy.item_colored).getItem())
) {
ItemStack is = new ItemStack(PackFurniture.proxy.armor_wool_colors_helmet);
NBTTagCompound tag = new NBTTagCompound();
tag.setInteger("Color", cmh.getItemDamage());
is.setTagCompound(tag);
return is;
}

return null;
}

@Override
public int getRecipeSize() {
return 9;
}

@Override
public ItemStack getRecipeOutput() {
return null;
}

}
