package smt.pack.phytology.block;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockLog extends net.minecraft.block.BlockLog {

	@SideOnly(Side.CLIENT)
	private IIcon[]
			side_icons,
			top_icons;

	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getSideIcon(int metada) {
		return side_icons[metada % side_icons.length];
	}

	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getTopIcon(int metada) {
		return top_icons[metada % top_icons.length];
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister ir) {
		side_icons = new IIcon[4];
		top_icons = new IIcon[4];

		for (int i = 0; i < side_icons.length; ++i)
			side_icons[i] = ir.registerIcon(getTextureName() + "_" + (i + 1));

		for (int i = 0; i < top_icons.length; ++i)
			top_icons[i] = ir.registerIcon(getTextureName() + "_" + (i + 1) + "_top");

	}

}
