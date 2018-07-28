package smt.pack.decorative.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBarrier extends Block {

	public BlockBarrier() {
		super(Material.glass);
		setBlockUnbreakable();
		setResistance(6000001.0F);
		disableStats();
	}

	@Override
	public int getRenderType() {
		return -1;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public int quantityDropped(Random random) {
		return 0;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public float getAmbientOcclusionLightValue() {
		return 1.0F;
	}

}
