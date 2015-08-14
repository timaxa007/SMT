package timaxa007.pack.furniture.block;

import java.util.List;

import timaxa007.pack.furniture.PackFurniture;
import timaxa007.pack.furniture.tile.TileEntityBlender;
import timaxa007.pack.conjoint.object.ModifiedBlock;
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


public class BlockBlender extends ModifiedBlock implements ITileEntityProvider {

	public BlockBlender(String tag) {
		super(tag, Material.wood);
		setCreativeTab(PackFurniture.tab_furniture);
		setHardness(0.5F);
		setBlockTextureName("planks_oak");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityBlender(world);
	}

	public int getRenderType() {
		return PackFurniture.render.block_blender_modelID;
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
		if (te != null && te instanceof TileEntityBlender) {
			return addNBT(0, ((TileEntityBlender)te).getType(), 0, ((TileEntityBlender)te).getTypeGlass(), ((TileEntityBlender)te).getTypeSize());
		}
		return addNBT(0, 0, 0, 0, 0);
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item id, CreativeTabs table, List list) {
		//for(int j=0;j<TileTexture.getTexturesConstructionCount;++j) {
		for (byte i = 0; i < 16; ++i) {
			int j=0;
			list.add(addNBT(0, j, 0, i, 1));
		}
		//}
		//list.add(new ItemStack(id, 1, 0));
	}

	public static ItemStack addNBT(int par1, int par2, int par3, int par4, int par5) {
		ItemStack is = new ItemStack(PackFurniture.block.blender, 1, par1);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setInteger("Type", par2);
		nbt.setInteger("TypeCap", par2);
		nbt.setInteger("TypeHandler", par2);
		nbt.setInteger("TypeBox", par2);
		nbt.setInteger("TypeGlass", par4);
		nbt.setInteger("TypeSize", par5);
		nbt.setInteger("Size", par3);
		is.setTagCompound(nbt);
		return is;
	}

}
