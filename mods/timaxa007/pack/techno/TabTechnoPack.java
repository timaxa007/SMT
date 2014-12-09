package mods.timaxa007.pack.techno;

import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TabTechnoPack extends CreativeTabs {

public TabTechnoPack(int id, String name) {
super(id, name);
}

@SideOnly(Side.CLIENT)
public int getTabIconItemIndex() {
return PackTechno.proxy.tool_electric_wrench.itemID;
}

}
