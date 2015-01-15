package mods.timaxa007.pack.furniture.block;

import java.util.List;

import mods.timaxa007.pack.furniture.PackFurniture;
import mods.timaxa007.pack.furniture.tile.TileEntityChair;
import mods.timaxa007.tms.util.BlockFixReg;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockChair extends BlockFixReg implements ITileEntityProvider {

	public BlockChair(String tag) {
		super(tag, Material.wood);
		setCreativeTab(PackFurniture.tab_furniture);
		setHardness(0.5F);
		setBlockTextureName("planks_oak");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityChair();
	}
	public int getRenderType() {
		return PackFurniture.proxy.render.block_chair_modelID;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public int idPicked(World world, int x, int y, int z) {
		return 0;
	}

	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(x, y, z);
		if (te != null && te instanceof TileEntityChair) {
			return addTag(0, ((TileEntityChair)te).getType());
		}
		return addTag(0, 0);
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item id, CreativeTabs table, List list) {

		//for(int j=0;j<TileTexture.getTexturesConstructionCount;++j) {
		//for(byte i=0;i<16;++i) {
		int j=0;

		list.add(addTag(0, j));
		//list.add(addTag(1, j));
		//list.add(addTag(2, j));
		//list.add(addTag(3, j));
		//list.add(addTag(4, j));
		//list.add(addTag(5, j));
		//list.add(addTag(6, j));
		//list.add(addTag(7, j));
		//list.add(addTag(8, j));
		//list.add(addTag(9, j));
		//list.add(addTag(10, j));
		//list.add(addTag(11, j));
		//}
		//}
		//list.add(new ItemStack(PackFurniture.blockCnstorBlock, 1, 0));
	}

	private static ItemStack addTag(int par1, int par2) {
		ItemStack is = new ItemStack(PackFurniture.proxy.block.chair, 1, par1);
		NBTTagCompound tag = new NBTTagCompound();
		tag.setInteger("Type", par2);
		is.setTagCompound(tag);
		return is;
	}

}
