package mods.timaxa007.pack.magic.items;

import mods.timaxa007.pack.magic.PackMagic;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ToolMagicSword extends ItemSword{

public ToolMagicSword(int id, EnumToolMaterial par2) {
super(par2);
this.setCreativeTab(PackMagic.proxy.tabMagicPack);
this.setUnlocalizedName("magic.sword");
this.setFull3D();
}

@SideOnly(Side.CLIENT)
public boolean hasEffect(ItemStack is) {return true;}

public boolean hitEntity(ItemStack is, EntityLivingBase par2EL, EntityLivingBase par3EL) {
par2EL.motionY+=1;
return true;
}

@Override
public void registerIcons(IIconRegister ir) {
this.itemIIcon=ir.registerIcon("timaxa007:" + "tool/" + "swordMagic");
}

}
