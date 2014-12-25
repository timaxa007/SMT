package mods.timaxa007.pack.furniture.block;

import java.util.List;

import mods.timaxa007.pack.furniture.PackFurniture;
import mods.timaxa007.pack.furniture.tile.TileEntityBlender;
import net.minecraft.block.BlockContainer;
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


public class BlockBlender extends BlockContainer{

	public BlockBlender() {
		super(Material.wood);
		setCreativeTab(PackFurniture.tab_furniture);
		setHardness(0.5F);
		setBlockTextureName("planks_oak");
		setBlockName("blender");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityBlender();
	}

	public int getRenderType() {
		return PackFurniture.proxy.render.block_blender_modelID;
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
			return addTag(0, ((TileEntityBlender)te).getType(), 0, ((TileEntityBlender)te).getTypeGlass(), ((TileEntityBlender)te).getTypeSize());
		}
		return addTag(0, 0, 0, 0, 0);
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item id, CreativeTabs table, List list) {
		//for(int j=0;j<TileTexture.getTexturesConstructionCount;++j) {
		for (byte i = 0; i < 16; ++i) {
			int j=0;
			list.add(addTag(0, j, 0, i, 1));
		}
		//}
		//list.add(new ItemStack(id, 1, 0));
	}

	private static ItemStack addTag(int par1, int par2, int par3, int par4, int par5) {
		ItemStack is = new ItemStack(PackFurniture.proxy.block.blender, 1, par1);
		NBTTagCompound tag = new NBTTagCompound();
		tag.setInteger("Type", par2);
		tag.setInteger("TypeCap", par2);
		tag.setInteger("TypeHandler", par2);
		tag.setInteger("TypeBox", par2);
		tag.setInteger("TypeGlass", par4);
		tag.setInteger("TypeSize", par5);
		tag.setInteger("Size", par3);
		is.setTagCompound(tag);
		return is;
	}

}
