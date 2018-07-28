package smt.pack.privacy.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import smt.pack.privacy.SMTPrivacy;

public class BlockBlocksPrivacy extends Block {

	public BlockBlocksPrivacy() {
		super(Material.wood);
		setCreativeTab(SMTPrivacy.tabPrivacy);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		System.out.println("onBlockActivated");
		return true;
	}

	@Override
	public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player) {
		System.out.println("onBlockClicked");
	}

}
