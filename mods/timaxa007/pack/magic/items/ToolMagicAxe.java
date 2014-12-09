package mods.timaxa007.pack.magic.items;

import mods.timaxa007.pack.magic.PackMagic;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ToolMagicAxe extends ItemAxe{

public ToolMagicAxe(int id, EnumToolMaterial par2) {
super(id, par2);
this.setCreativeTab(PackMagic.proxy.tabMagicPack);
this.setUnlocalizedName("magic.axe");
}

@SideOnly(Side.CLIENT)
public boolean hasEffect(ItemStack is) {return true;}

@Override
public void registerIcons(IconRegister ir) {
this.itemIcon=ir.registerIcon("timaxa007:" + "tool/" + "axeMagic");
}

}
