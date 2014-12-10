package mods.timaxa007.pack.magic.items;

import mods.timaxa007.pack.magic.PackMagic;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ToolMagicPickaxe extends ItemPickaxe{

public ToolMagicPickaxe(int id, EnumToolMaterial par2) {
super(par2);
this.setCreativeTab(PackMagic.proxy.tabMagicPack);
this.setUnlocalizedName("magic.pickaxe");
}

@SideOnly(Side.CLIENT)
public boolean hasEffect(ItemStack is) {return true;}

@Override
public void registerIcons(IIconRegister ir) {
this.itemIIcon=ir.registerIcon("timaxa007:" + "tool/" + "pickaxeMagic");
}

}
