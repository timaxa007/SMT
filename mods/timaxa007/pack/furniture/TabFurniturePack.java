package mods.timaxa007.pack.furniture;

import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TabFurniturePack extends CreativeTabs {

public TabFurniturePack(int id, String name) {
super(id, name);
}

@SideOnly(Side.CLIENT)
public int getTabIconItemIndex() {
return PackFurniture.proxy.block_cnstor_block.blockID;
}

}
