package smt.pack.technology.api.object;

import net.minecraft.world.World;

public abstract class BlockElectricDummy
extends net.minecraft.block.Block
implements smt.pack.technology.api.IElectricIBlock {

	public BlockElectricDummy(net.minecraft.block.material.Material material) {
		super(material);
	}

	//Electric Power

	@Override
	public int addEnergy(World world, int x, int y, int z, int side, int energy) {
		return energy;
	}

	@Override
	public void setEnergy(World world, int x, int y, int z, int side, int energy) {

	}

	@Override
	public int getEnergy(World world, int x, int y, int z, int side) {
		return -1;
	}

	@Override
	public void setEnergyMax(World world, int x, int y, int z, int side, int energy) {

	}

	@Override
	public int getEnergyMax(World world, int x, int y, int z, int side) {
		return -1;
	}

	@Override
	public abstract int rateMax(World world, int x, int y, int z, int side);

	@Override
	public boolean isCharging(World world, int x, int y, int z, int side) {
		return false;
	}

	@Override
	public boolean isDischarging(World world, int x, int y, int z, int side) {
		return false;
	}

}
