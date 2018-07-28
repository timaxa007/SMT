package smt.pack.common.block;

import java.util.HashMap;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockTest extends Block implements smt.pack.common.api.IRegisterItem {

	public BlockTest() {
		super(Material.rock);
		this.setTickRandomly(true);
	}

	@Override
	public void updateTick(World world, int x, int y, int z, Random random) {
		world.scheduleBlockUpdate(x, y, z, this, 0);
		System.out.println("test");
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase eLB, ItemStack itemStack) {
		world.scheduleBlockUpdate(x, y, z, this, 0);
	}

	@Override
	public String getRegisterName() {
		return "block_test";
	}

	@Override
	public void getRegisterItem(final HashMap<String, ItemStack> map) {
		map.put(getRegisterName(), new ItemStack(this));
	}

}
