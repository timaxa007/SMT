package timaxa007.pack.furniture.item;

import net.minecraft.util.IIcon;
import timaxa007.pack.conjoint.object.ModifiedItem;
import timaxa007.pack.furniture.PackFurniture;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemPaintCan extends ModifiedItem {

	@SideOnly(Side.CLIENT) private IIcon icon_a;
	@SideOnly(Side.CLIENT) private IIcon icon_b;

	public ItemPaintCan(String tag) {
		super(tag);
		setCreativeTab(PackFurniture.tab_furniture);
		setMaxStackSize(1);
		setMaxDamage(15);
	}

}
