package timaxa007.pack.furniture.block;

import timaxa007.pack.furniture.PackFurniture;
import timaxa007.tms.object.ModifiedBlock;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockCnstorWall extends ModifiedBlock implements ITileEntityProvider {

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
