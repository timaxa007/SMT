package mods.timaxa007.pack.techno.items;

import mods.timaxa007.pack.techno.PackTechno;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class ToolElectricWrench extends Item {

public ToolElectricWrench() {
super(id);
setCreativeTab(PackTechno.proxy.tabTechnoPack);
setUnlocalizedName("electric.wrench");
}

@Override
public void registerIcons(IIconRegister ir) {
itemIIcon = ir.registerIcon("timaxa007:" + "testItem");
}
}