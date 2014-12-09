package mods.timaxa007.Pack.Furniture;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MincerRecipes{
private static final MincerRecipes minceBase=new MincerRecipes();

private Map minceList=new HashMap();
private HashMap<List<Integer>, ItemStack> metaMinceList=new HashMap<List<Integer>, ItemStack>();

public static final MincerRecipes mince() {return minceBase;}

private MincerRecipes() {
this.addMince(Item.porkRaw.itemID, new ItemStack(Item.porkCooked));
this.addMince(Item.beefRaw.itemID, new ItemStack(Item.beefCooked));
this.addMince(Item.chickenRaw.itemID, new ItemStack(Item.chickenCooked));
this.addMince(Item.fishRaw.itemID, new ItemStack(Item.fishCooked));
this.addMince(Block.cactus.blockID, new ItemStack(Item.dyePowder, 1, 2));
this.addMince(Item.potato.itemID, new ItemStack(Item.bakedPotato));
}

public void addMince(int par1, ItemStack par2ItemStack) {
minceList.put(Integer.valueOf(par1), par2ItemStack);
}

public Map getMinceList() {return this.minceList;}

public void addMince(int itemID, int metadata, ItemStack itemstack) {
metaMinceList.put(Arrays.asList(itemID, metadata), itemstack);
}

public ItemStack getMinceResult(ItemStack is) {
if(is==null) {return null;}
ItemStack ret=(ItemStack)metaMinceList.get(Arrays.asList(is.itemID, is.getItemDamage()));
if(ret!=null) {return ret;}
return (ItemStack)minceList.get(Integer.valueOf(is.itemID));
}

public Map<List<Integer>, ItemStack> getMetaMinceList() {return metaMinceList;}

}
