package mods.timaxa007.pack.techno.items;

import mods.timaxa007.pack.techno.PackTechno;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ToolElectricWrench extends Item {

public ToolElectricWrench(int id) {
super(id);
setCreativeTab(PackTechno.proxy.tabTechnoPack);
setUnlocalizedName("electric.wrench");
}

@Override
public void registerIcons(IconRegister ir) {
itemIcon = ir.registerIcon("timaxa007:" + "testItem");
}
}