package smt.pack.common.client;

import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class IconRotFlip implements IIcon {

	private final IIcon baseIcon;
	private final boolean flipU;
	private final boolean flipV;

	public IconRotFlip(IIcon baseIcon, boolean flipU, boolean flipV) {
		this.baseIcon = baseIcon;
		this.flipU = flipU;
		this.flipV = flipV;
	}

	/**
	 * Returns the width of the icon, in pixels.
	 */
	@Override
	public int getIconWidth() {
		return this.baseIcon.getIconWidth();
	}

	/**
	 * Returns the height of the icon, in pixels.
	 */
	@Override
	public int getIconHeight() {
		return this.baseIcon.getIconHeight();
	}

	/**
	 * Returns the minimum U coordinate to use when rendering with this icon.
	 */
	@Override
	public float getMinU() {
		return this.flipU ? this.baseIcon.getMaxU() : this.baseIcon.getMinU();
	}

	/**
	 * Returns the maximum U coordinate to use when rendering with this icon.
	 */
	@Override
	public float getMaxU() {
		return this.flipU ? this.baseIcon.getMinU() : this.baseIcon.getMaxU();
	}

	/**
	 * Gets a U coordinate on the icon. 0 returns uMin and 16 returns uMax. Other arguments return in-between values.
	 */
	@Override
	public float getInterpolatedU(double vexU) {
		float f = this.getMaxU() - this.getMinU();
		return this.getMinU() + f * ((float)vexU / 16.0F);
	}

	/**
	 * Returns the minimum V coordinate to use when rendering with this icon.
	 */
	@Override
	public float getMinV() {
		return this.flipV ? this.baseIcon.getMinV() : this.baseIcon.getMinV();
	}

	/**
	 * Returns the maximum V coordinate to use when rendering with this icon.
	 */
	@Override
	public float getMaxV() {
		return this.flipV ? this.baseIcon.getMinV() : this.baseIcon.getMaxV();
	}

	/**
	 * Gets a V coordinate on the icon. 0 returns vMin and 16 returns vMax. Other arguments return in-between values.
	 */
	@Override
	public float getInterpolatedV(double vexV) {
		float f = this.getMaxV() - this.getMinV();
		return this.getMinV() + f * ((float)vexV / 16.0F);
	}

	@Override
	public String getIconName() {
		return this.baseIcon.getIconName();
	}

}