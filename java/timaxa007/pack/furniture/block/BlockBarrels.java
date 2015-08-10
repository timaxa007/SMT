package timaxa007.pack.furniture.block;

import java.util.List;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import timaxa007.pack.furniture.PackFurniture;
import timaxa007.pack.furniture.tile.TileEntityBarrels;
import timaxa007.smt.object.ModifiedBlock;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBarrels extends ModifiedBlock implements ITileEntityProvider {

	public BlockBarrels(String tag) {
		super(tag, Material.wood);
		setCreativeTab(PackFurniture.tab_furniture);
		setHardness(0.5F);
		setBlockTextureName("planks_oak");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {return new TileEntityBarrels(world);}
	public int getRenderType() {return PackFurniture.render.block_barrels_modelID;}
	public boolean isOpaqueCube() {return false;}
	public boolean renderAsNormalBlock() {return false;}
	public int idPicked(World world, int x, int y, int z) {return 0;}

	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(x, y, z);
		/*if (te != null && te instanceof TileEntityBarrels) {
			return addNBT(((TileEntityBarrels)te).getTypeB(), ((TileEntityBarrels)te).getTypeP(), ((TileEntityBarrels)te).getTypeCD(), ((TileEntityBarrels)te).getLie());
		}*/
		return addNBT(0, 0, 0, false);
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item id, CreativeTabs table, List list) {
		//for(int j1=0;j1<TileTexture.getTexturesConstructionCount;++j1) {
		//for(byte i=0;i<16;++i) {
		int j1=68;
		int j2=3;
		int j3=75;
		list.add(addNBT(j1, j2, j3, false));
		//
		//}
		//list.add(new ItemStack(PackFurniture.toolAirBrush, 1, 0));
	}

	public static ItemStack addNBT(int par1, int par2, int par3, boolean par4) {
		ItemStack is = new ItemStack(PackFurniture.block.barrels, 1, 0);
		NBTTagCompound nbt = new NBTTagCompound();
		//nbt.setInteger("TypeB", par1);
		//nbt.setInteger("TypeP", par2);
		//nbt.setInteger("TypeCD", par3);
		//nbt.setBoolean("Lie", par4);
		is.setTagCompound(nbt);
		return is;
	}

}
