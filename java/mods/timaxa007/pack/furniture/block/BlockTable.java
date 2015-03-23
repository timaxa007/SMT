package mods.timaxa007.pack.furniture.block;

import java.util.List;

import mods.timaxa007.pack.furniture.PackFurniture;
import mods.timaxa007.pack.furniture.tile.TileEntityTable;
import mods.timaxa007.tms.util.ModifiedBlock;
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

public class BlockTable extends ModifiedBlock implements ITileEntityProvider {

	public BlockTable(String tag) {
		super(tag, Material.wood);
		setCreativeTab(PackFurniture.tab_furniture);
		setHardness(0.5F);
		setBlockTextureName("planks_oak");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityTable();
	}

	public int getRenderType() {
		return PackFurniture.proxy.render.block_table_modelID;
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
		if (te != null && te instanceof TileEntityTable)
			return addNBT(0, ((TileEntityTable)te).getStyle(), ((TileEntityTable)te).getSize());
		return null;
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item id, CreativeTabs table, List list) {
		//for(int j = 0; j < TileTexture.tt01.length; ++j) {
		//for(int i = 0; i < 16; ++i) {
		String j = "";
		list.add(addNBT(0, j, 0));
		list.add(addNBT(0, j, 1));
		list.add(addNBT(0, j, 2));
		list.add(addNBT(0, j, 3));
		list.add(addNBT(0, j, 4));
		list.add(addNBT(0, j, 5));
		list.add(addNBT(0, j, 6));
		list.add(addNBT(0, j, 7));
		//}
		//}
		//list.add(new ItemStack(id, 1, 0));
	}

	public static ItemStack addNBT(int par1, String par2, int par3) {
		ItemStack is = new ItemStack(PackFurniture.proxy.block.table, 1, 0);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setString("Style", par2);
		nbt.setInteger("Size", par3);
		is.setTagCompound(nbt);
		return is;
	}

}
