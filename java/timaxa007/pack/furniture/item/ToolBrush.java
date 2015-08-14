package timaxa007.pack.furniture.item;

import net.minecraft.util.IIcon;
import timaxa007.pack.conjoint.object.ModifiedItem;
import timaxa007.pack.furniture.PackFurniture;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ToolBrush extends ModifiedItem {

	@SideOnly(Side.CLIENT) private IIcon icon_a;
	@SideOnly(Side.CLIENT) private IIcon icon_b;

	public ToolBrush(String tag) {
		super(tag);
		setCreativeTab(PackFurniture.tab_furniture);
		setMaxStackSize(1);
		setMaxDamage(8);
		setTextureName("timaxa007:colors/tool_brush");
	}

}
