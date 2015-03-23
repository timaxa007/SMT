package timaxa007.pack.furniture.item;

import timaxa007.pack.mining.PackMining;
import timaxa007.tms.util.ModifiedItem;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemPaintCan extends ModifiedItem {

	@SideOnly(Side.CLIENT) private IIcon icon_a;
	@SideOnly(Side.CLIENT) private IIcon icon_b;

	public ItemPaintCan(String tag) {
		super(tag);
		setMaxStackSize(1);
		setMaxDamage(15);
		setCreativeTab(PackMining.tab_tools);
	}

}
