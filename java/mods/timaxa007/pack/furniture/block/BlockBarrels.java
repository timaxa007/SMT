package mods.timaxa007.pack.furniture.block;

import java.util.List;

import mods.timaxa007.pack.furniture.PackFurniture;
import mods.timaxa007.pack.furniture.tile.TileEntityBarrels;
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

public class BlockBarrels extends BlockFixReg implements ITileEntityProvider {

	public BlockBarrels(String tag) {
		super(tag, Material.clay);
		setCreativeTab(PackFurniture.tab_furniture);
		setHardness(0.5F);
		setBlockTextureName("planks_oak");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityBarrels();
	}

	public int getRenderType() {
		return -1;
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
		if (te != null && te instanceof TileEntityBarrels) {
			return addTag(((TileEntityBarrels)te).getTypeB(), ((TileEntityBarrels)te).getTypeP(), ((TileEntityBarrels)te).getTypeCD(), ((TileEntityBarrels)te).getLie());
		}
		return addTag(0, 0, 0, false);
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item id, CreativeTabs table, List list) {
		//for(int j1=0;j1<TileTexture.getTexturesConstructionCount;++j1) {
		//for(byte i=0;i<16;++i) {
		int j1=68;
		int j2=3;
		int j3=75;
		list.add(addTag(j1, j2, j3, false));
		//
		//}
		//list.add(new ItemStack(PackFurniture.toolAirBrush, 1, 0));
	}

	private static ItemStack addTag(int par1, int par2, int par3, boolean par4) {
		ItemStack is = new ItemStack(PackFurniture.proxy.block.barrels, 1, 0);
		NBTTagCompound tag = new NBTTagCompound();
		tag.setInteger("TypeB", par1);
		tag.setInteger("TypeP", par2);
		tag.setInteger("TypeCD", par3);
		tag.setBoolean("Lie", par4);
		is.setTagCompound(tag);
		return is;
	}

}
