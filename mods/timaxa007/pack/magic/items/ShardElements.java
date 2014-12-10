package mods.timaxa007.pack.magic.items;

import java.util.List;

import mods.timaxa007.pack.magic.PackMagic;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ShardElements extends Item{
@SideOnly(Side.CLIENT) private IIcon[] iconArray;
@SideOnly(Side.CLIENT) private IIcon[] theIIcon;
public static final String[] shaedNames=new String[]{
"Air", 
"Earth", 
"Fire", 
"Water", 
"Sound", 
"6", 
"Lightning", 
"Liquid", 
"Flame", 
"10", 
"11", 
"12", 
"13", 
"14", 
"15", 
"16"
};

public static final int[] shardHex=new int[]{
0x000000, 
0x000000, 
0x000000, 
0x000000, 
0x000000, 
0x000000, 
0x000000, 
0x000000, 
0x000000, 
0x000000, 
0x000000, 
0x000000, 
0x000000, 
0x000000, 
0x000000, 
0x000000
};

public ShardElements() {
super(id);
this.setHasSubtypes(true);
this.setMaxDamage(0);
this.setCreativeTab(PackMagic.proxy.tabMagicPack);
this.setUnlocalizedName("ShardElements");
}

public String getUnlocalizedName(ItemStack is) {
int j=MathHelper.clamp_int(is.getItemDamage(), 0, (shaedNames.length)-1);
return super.getUnlocalizedName()+"."+shaedNames[j];
}

@SideOnly(Side.CLIENT)
public void getSubItems(int id, CreativeTabs table, List list) {
for(int j=0;j<shaedNames.length;++j) {list.add(new ItemStack(id, 1, j));}
}

@SideOnly(Side.CLIENT)
public IIcon getIconFromDamage(int par1) {
int j=MathHelper.clamp_int(par1, 0, (shaedNames.length)-1);
return this.iconArray[j];
}

@SideOnly(Side.CLIENT)
public boolean requiresMultipleRenderPasses() {return true;}

@SideOnly(Side.CLIENT)
public int getColorFromItemStack(ItemStack is, int renderPass) {
if(renderPass==0) {
return 16777215;
}else{

if(is.getItemDamage()==0) {return shardHex[0];}
else if(is.getItemDamage()==1) {return shardHex[1];}
else if(is.getItemDamage()==2) {return shardHex[2];}
else if(is.getItemDamage()==3) {return shardHex[3];}
else if(is.getItemDamage()==4) {return shardHex[4];}
else if(is.getItemDamage()==5) {return shardHex[5];}
else if(is.getItemDamage()==6) {return shardHex[6];}
else if(is.getItemDamage()==7) {return shardHex[7];}
else if(is.getItemDamage()==8) {return shardHex[8];}
else if(is.getItemDamage()==9) {return shardHex[9];}
else if(is.getItemDamage()==10) {return shardHex[10];}
else if(is.getItemDamage()==11) {return shardHex[11];}
else if(is.getItemDamage()==12) {return shardHex[12];}
else if(is.getItemDamage()==13) {return shardHex[13];}
else if(is.getItemDamage()==14) {return shardHex[14];}
else if(is.getItemDamage()==15) {return shardHex[15];}

else{return 16777215;}

}
}

@SideOnly(Side.CLIENT)
public IIcon getIconFromDamageForRenderPass(int par1, int par2) {
int j=MathHelper.clamp_int(par1, 0, (shardHex.length)-1);
return par2 > 0 ? (par2==0 ? this.iconArray[j] : this.theIIcon[j]) : super.getIconFromDamageForRenderPass(par1, par2);
}

@SideOnly(Side.CLIENT)
public void registerIcons(IIconRegister ir) {
this.iconArray=new IIcon[shaedNames.length];
this.theIIcon=new IIcon[shaedNames.length];
for(int i=0;i<shaedNames.length;++i) {
this.iconArray[i]=ir.registerIcon("timaxa007:"+"shardElementEasy"+"_overlay");
this.theIIcon[i]=ir.registerIcon("timaxa007:"+"shardElementEasy");
}
}

}