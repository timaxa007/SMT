package mods.timaxa007.pack.furniture.block;

import mods.timaxa007.pack.furniture.PackFurniture;
import mods.timaxa007.tms.util.BlockFixReg;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockCnstorWall extends BlockFixReg implements ITileEntityProvider {

	public BlockCnstorWall(String tag) {
		super(tag, Material.glass);
		setStepSound(soundTypeWood);
		setCreativeTab(PackFurniture.tab_furniture);
		setHardness(1.0F);
		setResistance(3.5F);
		setLightOpacity(0);
		setBlockTextureName("timaxa007:woodFrame");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return null;
	}

}
