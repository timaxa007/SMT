package mods.timaxa007.pack.stock.item;

import mods.timaxa007.pack.stock.PackStock;
import mods.timaxa007.tms.util.ItemFixReg;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemHoneycombs extends ItemFixReg {

	@SideOnly(Side.CLIENT) private IIcon icon_a;
	@SideOnly(Side.CLIENT) private IIcon icon_b;

	public ItemHoneycombs(String tag) {
		super(tag);
		setCreativeTab(PackStock.tab_apis);
		setHasSubtypes(true);
		setMaxDamage(0);
	}

}
