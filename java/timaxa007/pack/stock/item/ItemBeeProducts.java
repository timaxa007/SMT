package timaxa007.pack.stock.item;

import timaxa007.pack.stock.PackStock;
import timaxa007.tms.object.ModifiedItem;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBeeProducts extends ModifiedItem {

	@SideOnly(Side.CLIENT) private IIcon[] icon_tex;
	@SideOnly(Side.CLIENT) private IIcon[] icon_ovl;

	public ItemBeeProducts(String tag) {
		super(tag);
		setCreativeTab(PackStock.tab_apis);
		setHasSubtypes(true);
		setMaxDamage(0);
	}

}
