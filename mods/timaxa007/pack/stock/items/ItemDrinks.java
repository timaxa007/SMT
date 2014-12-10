package mods.timaxa007.pack.stock.items;

import java.util.List;

import mods.timaxa007.lib.FluidFake;
import mods.timaxa007.lib.Option;
import mods.timaxa007.pack.stock.PackStock;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemDrinks extends Item {

@SideOnly(Side.CLIENT) private IIcon[] icon_tex;
@SideOnly(Side.CLIENT) private IIcon[] icon_ovl;

public ItemDrinks() {
super(id);
//setCreativeTab(PackStock.proxy.tabFoodPack);
setHasSubtypes(true);
setMaxDamage(0);
setUnlocalizedName("drinks");
}

//tea - flower, tea, 
//boiled, hot, normal, 

public enum drinks {
//Cup(0, 0xFFFFFF, 0xFFFFFF), 
Bottle(0, 0xFFFFFF, 0xFFFFFF);

private int lvl;
private int hex1;
private int hex2;

static boolean hasStrCode(String str) {
for (drinks j : drinks.values()) {
if (str.equalsIgnoreCase(j.toString())) {
return true;
}
}
return false;
}

drinks(int p_lvl, int p_hex1, int p_hex2) {
lvl = p_lvl;
hex1 = p_hex1;
hex2 = p_hex2;
}

}
/*
public enum liquid_for_drinking {
Water(0.0F, 0xFFFFFF), 
Tea(0.0F, 0xFFFFFF), 
Coffee(0.0F, 0xFFFFFF), 
Milk(0.0F, 0xFFFFFF), 
Cacao(0.0F, 0xFFFFFF), 
Juice_of_apples(0.0F, 0xFFFFFF), 
Juice_of_carrot(0.0F, 0xFFFFFF), 
Juice_of_melon(0.0F, 0xFFFFFF), 
Juice_of_pumpkin(0.0F, 0xFFFFFF), 
Juice_of_potato(0.0F, 0xFFFFFF), 
Milkshake(0.0F, 0xFFFFFF), 
Lemonade(0.0F, 0xFFFFFF), 
NONE(0.0F, 0xFFFFFF);

private float sat;
private int liquid_hex;

static boolean hasStrCode(String str) {
for (liquid_for_drinking j : liquid_for_drinking.values()) {
if (str.equalsIgnoreCase(j.toString())) {
return true;
}
}
return false;
}

liquid_for_drinking(float p_sat, int liq_hex) {
sat = p_sat;
liquid_hex = liq_hex;
}

}
*/
public enum temperature {
Hot(45.0F, 0xFFFFFF), 
Very_hot(60.0F, 0xFFFFFF), 
Very_cool(-45.0F, 0xFFFFFF), 
Cool(0.0F, 0xFFFFFF), 
NONE(0.0F, 0xFFFFFF);

private float t;
private int t_hex;

static boolean hasStrCode(String str) {
for (temperature j : temperature.values()) {
if (str.equalsIgnoreCase(j.toString())) {
return true;
}
}
return false;
}

temperature(float temp, int temp_hex) {
t = temp;
t_hex = temp_hex;
}

}

public ItemStack onEaten(ItemStack is, World world, EntityPlayer player) {
NBTTagCompound tag = is.getTagCompound();
if (!player.capabilities.isCreativeMode) {--is.stackSize;}
if (!world.isRemote) {
if (tag != null) {
if (tag.hasKey("NameID") && tag.hasKey("LiquidID")) {
player.getFoodStats().addStats(2, 0.5F);
} else {
}
}
}
//return new ItemStack(Item.bucketEmpty);
return is;
}

public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer player) {
//world.playSoundAtEntity(player, "timaxa007:vodka", 1.0F, 1.0F);
player.setItemInUse(is, getMaxItemUseDuration(is));
return is;
}

public int getMaxItemUseDuration(ItemStack is) {
return 32;
}

public EnumAction getItemUseAction(ItemStack is) {
return EnumAction.drink;
}

public String getUnlocalizedName(ItemStack is) {
NBTTagCompound tag = is.getTagCompound();
if (tag != null && tag.hasKey("LiquidID")) {
return "fluid." + FluidFake.fluid_list[tag.getInteger("LiquidID")].getName();
}
return super.getUnlocalizedName();
}

public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
NBTTagCompound tag = is.getTagCompound();
if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
if (tag != null) {
if (tag.hasKey("NameID")) {
list.add("NameID: " + tag.getString("NameID") + ".");
list.add("Saturation Level: " + drinks.valueOf(tag.getString("NameID")).lvl + ".");
}
if (tag.hasKey("LiquidID") && FluidFake.fluid_list[tag.getInteger("LiquidID")] != null) {
list.add("LiquidID: " + tag.getInteger("LiquidID") + "/" + 
FluidFake.fluid_list[tag.getInteger("LiquidID")].getLocalizedName() + ".");
list.add("Liquid Type: " + FluidFake.fluid_list[tag.getInteger("LiquidID")].getType() + ".");
}
}
} else {
list.add(Option.prshift);
}
}

@SideOnly(Side.CLIENT)
public void getSubItems(int id, CreativeTabs table, List list) {
for (drinks j1 : drinks.values()) {
for (int i = 0; i < FluidFake.fluid_list.length; ++i) {
if (FluidFake.fluid_list[i] != null) {
list.add(addTag(j1.toString(), i));
}
}

}
//list.add(new ItemStack(id, 1, 0));
}

private static ItemStack addTag(String par1, int par2) {
ItemStack is = new ItemStack(PackStock.proxy.item_drinks, 1, 0);
NBTTagCompound tag = new NBTTagCompound();
tag.setString("NameID", par1);
tag.setInteger("LiquidID", par2);
tag.setFloat("TempID", 30.0F);
//tag.setFloat("Sat", drinks.valueOf(par1).sat);
is.setTagCompound(tag);
return is;
}

@SideOnly(Side.CLIENT)
public boolean requiresMultipleRenderPasses() {return true;}

public IIcon getIcon(ItemStack is, int pass) {
NBTTagCompound tag = is.getTagCompound();
if (tag != null && tag.hasKey("NameID")) {
if (pass == 0) {
return icon_tex[drinks.valueOf(tag.getString("NameID")).ordinal()];
} else {
return icon_ovl[drinks.valueOf(tag.getString("NameID")).ordinal()];
}
} else {
return itemIIcon;
}
}

@SideOnly(Side.CLIENT)
public int getColorFromItemStack(ItemStack is, int renderPass) {
NBTTagCompound tag = is.getTagCompound();
if (renderPass == 0) {
	if (tag != null && tag.hasKey("NameID")) {
	return drinks.valueOf(tag.getString("NameID")).hex1;
	} else {return 16777215;}
} else {
	if (tag != null && tag.hasKey("LiquidID")) {
	return FluidFake.fluid_list[tag.getInteger("LiquidID")].getColor();
	} else {return 16777215;}
}
}

@SideOnly(Side.CLIENT)
public void registerIcons(IIconRegister ir) {
super.registerIcons(ir);
itemIIcon = ir.registerIcon("timaxa007:" + "drinks/" + "drink");
icon_tex = new IIcon[drinks.values().length];
icon_ovl = new IIcon[drinks.values().length];
for (drinks j : drinks.values()) {
//icon_tex[j.ordinal()] = ir.registerIcon("timaxa007:" + "drinks/" + j.toString().toLowerCase());
//icon_ovl[j.ordinal()] = ir.registerIcon("timaxa007:" + "empty");
icon_tex[j.ordinal()] = ir.registerIcon("timaxa007:" + "kitchenware/" + "proof_big");
icon_ovl[j.ordinal()] = ir.registerIcon("timaxa007:" + "kitchenware/" + "proof_big" + "_overlay");
}
}

}
