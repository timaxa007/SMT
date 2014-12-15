package mods.timaxa007.pack.techno;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TabTechno extends CreativeTabs {

public TabTechno(String name) {
super(name);
}

@Override
public Item getTabIconItem() {
return PackTechno.proxy.tool_electric_wrench;
}

}
