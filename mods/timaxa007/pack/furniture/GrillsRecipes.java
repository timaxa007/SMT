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
this.addGrill(Item.porkRaw.getItem(), new ItemStack(Item.porkCooked), 0.35F);
this.addGrill(Item.beefRaw.getItem(), new ItemStack(Item.beefCooked), 0.35F);
this.addGrill(Item.chickenRaw.getItem(), new ItemStack(Item.chickenCooked), 0.35F);
this.addGrill(Item.fishRaw.getItem(), new ItemStack(Item.fishCooked), 0.35F);
this.addGrill(Block.cactus, new ItemStack(Item.dyePowder, 1, 2), 0.2F);
this.addGrill(Item.potato.getItem(), new ItemStack(Item.bakedPotato), 0.35F);
}

public void addGrill(int par1, ItemStack par2ItemStack, float par3) {
this.grillList.put(Integer.valueOf(par1), par2ItemStack);
this.experienceList.put(Integer.valueOf(par2ItemStack.getItem()), Float.valueOf(par3));
}

public Map getGrillList() {return this.grillList;}

public void addGrill(int itemID, int metadata, ItemStack itemstack, float experience) {
metaGrillList.put(Arrays.asList(itemID, metadata), itemstack);
metaExperience.put(Arrays.asList(itemstack.getItem(), itemstack.getItemDamage()), experience);
}

public ItemStack getGrillsResult(ItemStack item) {
if(item==null) {return null;}
ItemStack ret=(ItemStack)metaGrillList.get(Arrays.asList(item.getItem(), item.getItemDamage()));
if(ret!=null) {return ret;}
return (ItemStack)grillList.get(Integer.valueOf(item.getItem()));
}

/**
 * Grabs the amount of base experience for this item to give when pulled from the furnace slot.
 */
public float getExperience(ItemStack item) {
if(item==null || item.getItem()==null) {return 0;}
float ret=item.getItem().getSmeltingExperience(item);
if(ret < 0 && metaExperience.containsKey(Arrays.asList(item.getItem(), item.getItemDamage()))) {ret=metaExperience.get(Arrays.asList(item.getItem(), item.getItemDamage()));}
if(ret < 0 && experienceList.containsKey(item.getItem())) {ret=((Float)experienceList.get(item.getItem())).floatValue();}
return (ret < 0 ? 0 : ret);
}

public Map<List<Integer>, ItemStack> getMetaGrillList() {return metaGrillList;}

}
