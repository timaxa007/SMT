package mods.timaxa007.Pack.Furniture.Items;

import java.util.List;

import mods.timaxa007.Pack.Furniture.PackFurniture;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBrickColors extends Item{
@SideOnly(Side.CLIENT) private Icon[] iconArray;
public static final String[] brickName=new String[]{
"brick_clay_black", 
"brick_clay_blue", 
"brick_clay_brown", 
"brick_clay_cyan", 
"brick_clay_gray", 
"brick_clay_green", 
"brick_clay_light_blue", 
"brick_clay_light_gray", 
"brick_clay_light_green", 
"brick_clay_magenta", 
"brick_clay_orange", 
"brick_clay_pink", 
"brick_clay_purple", 
"brick_clay_red", 
"brick_clay_white", 
"brick_clay_yellow", 

"brick_stone_black", 
"brick_stone_blue", 
"brick_stone_brown", 
"brick_stone_cyan", 
"brick_stone_gray", 
"brick_stone_green", 
"brick_stone_light_blue", 
"brick_stone_light_gray", 
"brick_stone_light_green", 
"brick_stone_magenta", 
"brick_stone_orange", 
"brick_stone_pink", 
"brick_stone_purple", 
"brick_stone_red", 
"brick_stone_white", 
"brick_stone_yellow", 

"cement", 
"brick_clay", 
"brick_stone", 
};


public ItemBrickColors(int id) {
super(id);
this.setHasSubtypes(true);
this.setMaxDamage(0);
this.setCreativeTab(PackFurniture.proxy.tabFurniturePack);
this.setUnlocalizedName("brick_colors");
}

@SideOnly(Side.CLIENT)
public Icon getIconFromDamage(int par1) {
int j=MathHelper.clamp_int(par1, 0, (brickName.length)-1);
return this.iconArray[j];
}

public String getUnlocalizedName(ItemStack is) {
int i=MathHelper.clamp_int(is.getItemDamage(), 0, (brickName.length)-1);
return super.getUnlocalizedName()+"."+brickName[i];
}

@SideOnly(Side.CLIENT)
public void getSubItems(int id, CreativeTabs table, List list) {
for(int j=0;j<brickName.length;++j) {
list.add(new ItemStack(id, 1, j));
}
}

@SideOnly(Side.CLIENT)
public void registerIcons(IconRegister ir) {
this.iconArray=new Icon[brickName.length];

for(int i=0;i<brickName.length;++i) {
this.iconArray[i]=ir.registerIcon("timaxa007:"+"bricks/"+brickName[i]);
}
}

}