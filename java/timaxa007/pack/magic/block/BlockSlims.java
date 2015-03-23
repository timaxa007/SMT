package timaxa007.pack.magic.block;

import java.util.List;

import timaxa007.pack.magic.PackMagic;
import timaxa007.pack.magic.tile.TileEntitySlims;
import timaxa007.tms.util.ModifiedBlock;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSlims extends ModifiedBlock implements ITileEntityProvider {

	@SideOnly(Side.CLIENT) private IIcon[] iconArray;

	public BlockSlims(String tag) {
		super(tag, Material.wood);
		setCreativeTab(PackMagic.tab_magic);
		setBlockTextureName("planks_oak");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntitySlims();
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item id, CreativeTabs table, List list) {
		for (int j = 0; j < 16; ++j) {
			list.add(new ItemStack(id, 1, j));
		}
	}

}
