package mods.timaxa007.pack.item.item;

import mods.timaxa007.pack.furniture.PackFurniture;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ToolHammer extends Item {
	/*
	@SideOnly(Side.CLIENT) private IIcon[] icon_tex;
	@SideOnly(Side.CLIENT) private IIcon[] icon_ovl;
	 */
	public ToolHammer() {
		super();
		setCreativeTab(PackFurniture.tab_furniture);
		setNoRepair();
		setMaxStackSize(1);
		setMaxDamage(10);
		setContainerItem(this);
		setTextureName("timaxa007:tool/hammer");
		setUnlocalizedName("tool_hammer");
	}

	public ItemStack getContainerItem(ItemStack is) {
		System.out.println("craft");
		if (is.getItemDamage() >= 0) {
			is.setItemDamage(is.getItemDamage() + 1);
			return is;
		}
		return super.getContainerItem(is);
	}
	/*
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister ir) {
		super.registerIcons(ir);

		itemIcon = ir.registerIcon("timaxa007:colors/tool_airbrush");

		icon_tex = new IIcon[airbrush_type.length];
		icon_ovl = new IIcon[airbrush_type.length];

		for (int i = 0; i < airbrush_type.length; i++) {
			icon_tex[i] = ir.registerIcon(getIconString());
			icon_ovl[i] = ir.registerIcon(getIconString() + "_overlay");
		}
	}
	 */
}
