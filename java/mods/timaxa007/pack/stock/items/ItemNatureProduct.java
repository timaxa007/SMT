package mods.timaxa007.pack.stock.items;

import java.util.List;

import mods.timaxa007.pack.stock.PackStock;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemNatureProduct extends Item {
public static final String[] natureProductNames=new String[]{
"1", 
"100"
};
@SideOnly(Side.CLIENT) private IIcon[] iconArray;
@SideOnly(Side.CLIENT) private IIcon[] theIIcon;

public ItemNatureProduct() {
super();
this.setHasSubtypes(true);
this.setMaxDamage(0);
this.setCreativeTab(PackStock.proxy.tab_food_pack);
this.setUnlocalizedName("NatureProduct");
}

public String getUnlocalizedName(ItemStack is) {
int i=MathHelper.clamp_int(is.getItemDamage(), 0, (natureProductNames.length)-1);
return super.getUnlocalizedName()+"."+natureProductNames[i];
}

@SideOnly(Side.CLIENT)
public void getSubItems(Item id, CreativeTabs table, List list) {
for(int j=0;j<natureProductNames.length;++j) {list.add(new ItemStack(id, 1, j));}
}


public ItemStack onEaten(ItemStack is, World par2World, EntityPlayer player) {
if(!player.capabilities.isCreativeMode) {
--is.stackSize;
}
if(!par2World.isRemote) {

if(is.getItemDamage()==0) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==1) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==2) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==3) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==4) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==5) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==6) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==7) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==8) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==9) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==10) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==11) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==12) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==13) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==14) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==15) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==16) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==17) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==18) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==19) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==20) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==21) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==22) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==23) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==24) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==25) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==26) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==27) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==28) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==29) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==30) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==31) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==32) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==33) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==34) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==35) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==36) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==37) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==38) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==39) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==40) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==41) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==42) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==43) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==44) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==45) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==46) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==47) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==48) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==49) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==50) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==51) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==52) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==53) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==54) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==55) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==56) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==57) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==58) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==59) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==60) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==61) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==62) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==63) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==64) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==65) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==66) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==67) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==68) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==69) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==70) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==71) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==72) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==73) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==74) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==75) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==76) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==77) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==78) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==79) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==80) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==81) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==82) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==83) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==84) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==85) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==86) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==87) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==88) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==89) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==90) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==91) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==92) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==93) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==94) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==95) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==96) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==97) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==98) {
player.getFoodStats().addStats(1, 0.1F);
}else if(is.getItemDamage()==99) {
player.getFoodStats().addStats(1, 0.1F);
}else{
player.getFoodStats().addStats(1, 0.1F);
}

}
//return is.stackSize <= 0 ? new ItemStack(Item.bucketEmpty) : IS;
return is;
}

public ItemStack onItemRightClick(ItemStack is, World par2World, EntityPlayer player) {
player.setItemInUse(is, this.getMaxItemUseDuration(is));
return is;
}

public int getMaxItemUseDuration(ItemStack is) {
return 32;
}

public EnumAction getItemUseAction(ItemStack is) {
return EnumAction.eat;
}

@SideOnly(Side.CLIENT)
public IIcon getIconFromDamage(int meta) {
int j=MathHelper.clamp_int(meta, 0, (natureProductNames.length)-1);
return this.iconArray[j];
}

@SideOnly(Side.CLIENT)
public boolean requiresMultipleRenderPasses() {return true;}

@SideOnly(Side.CLIENT)
public int getColorFromItemStack(ItemStack is, int renderPass) {
if(renderPass==0) {
return 16777215;
}else{

if(is.getItemDamage()==0) {return 16777215;}

else{return 16777215;}

}
}

@SideOnly(Side.CLIENT)
public IIcon getIconFromDamageForRenderPass(int par1, int par2) {
return par2==0 ? (par2>0 ? this.iconArray[par1] : this.theIIcon[par1]) : super.getIconFromDamageForRenderPass(par1, par2);
}

@SideOnly(Side.CLIENT)
public void registerIcons(IIconRegister ir) {
super.registerIcons(ir);
this.theIIcon=new IIcon[natureProductNames.length];
this.iconArray=new IIcon[natureProductNames.length];
for(int i=0;i<natureProductNames.length;++i) {
this.theIIcon[i]=ir.registerIcon("timaxa007:"+"testItem");
this.iconArray[i]=ir.registerIcon("timaxa007:"+"empty");
}
}

}
