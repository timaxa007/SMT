package timaxa007.pack.stock.item;

import timaxa007.pack.stock.PackStock;
import timaxa007.smt.object.ModifiedItem;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBees extends ModifiedItem {

	@SideOnly(Side.CLIENT) private IIcon[] icon_a;
	@SideOnly(Side.CLIENT) private IIcon[] icon_b;
	@SideOnly(Side.CLIENT) private IIcon[] icon_c;

	public ItemBees(String tag) {
		super(tag);
		setCreativeTab(PackStock.tab_apis);
		setHasSubtypes(true);
		setMaxDamage(0);
		setTextureName("timaxa007:apis/bees_");
	}

}
