package mods.timaxa007.pack.furniture;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class GrillsRecipes{
private static final GrillsRecipes grillBase=new GrillsRecipes();

private Map grillList=new HashMap();
private Map experienceList=new HashMap();
private HashMap<List<Integer>, ItemStack> metaGrillList=new HashMap<List<Integer>, ItemStack>();
private HashMap<List<Integer>, Float> metaExperience=new HashMap<List<Integer>, Float>();

public static final GrillsRecipes grill() {return grillBase;}

private GrillsRecipes() {
this.addGrill(Item.porkRaw.itemID, new ItemStack(Item.porkCooked), 0.35F);
this.addGrill(Item.beefRaw.itemID, new ItemStack(Item.beefCooked), 0.35F);
this.addGrill(Item.chickenRaw.itemID, new ItemStack(Item.chickenCooked), 0.35F);
this.addGrill(Item.fishRaw.itemID, new ItemStack(Item.fishCooked), 0.35F);
this.addGrill(Block.cactus.blockID, new ItemStack(Item.dyePowder, 1, 2), 0.2F);
this.addGrill(Item.potato.itemID, new ItemStack(Item.bakedPotato), 0.35F);
}

public void addGrill(int par1, ItemStack par2ItemStack, float par3) {
this.grillList.put(Integer.valueOf(par1), par2ItemStack);
this.experienceList.put(Integer.valueOf(par2ItemStack.itemID), Float.valueOf(par3));
}

public Map getGrillList() {return this.grillList;}

public void addGrill(int itemID, int metadata, ItemStack itemstack, float experience) {
metaGrillList.put(Arrays.asList(itemID, metadata), itemstack);
metaExperience.put(Arrays.asList(itemstack.itemID, itemstack.getItemDamage()), experience);
}

public ItemStack getGrillsResult(ItemStack item) {
if(item==null) {return null;}
ItemStack ret=(ItemStack)metaGrillList.get(Arrays.asList(item.itemID, item.getItemDamage()));
if(ret!=null) {return ret;}
return (ItemStack)grillList.get(Integer.valueOf(item.itemID));
}

/**
 * Grabs the amount of base experience for this item to give when pulled from the furnace slot.
 */
public float getExperience(ItemStack item) {
if(item==null || item.getItem()==null) {return 0;}
float ret=item.getItem().getSmeltingExperience(item);
if(ret < 0 && metaExperience.containsKey(Arrays.asList(item.itemID, item.getItemDamage()))) {ret=metaExperience.get(Arrays.asList(item.itemID, item.getItemDamage()));}
if(ret < 0 && experienceList.containsKey(item.itemID)) {ret=((Float)experienceList.get(item.itemID)).floatValue();}
return (ret < 0 ? 0 : ret);
}

public Map<List<Integer>, ItemStack> getMetaGrillList() {return metaGrillList;}

}
