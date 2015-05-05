package timaxa007.pack.furniture.block;

import java.util.List;

import timaxa007.pack.furniture.PackFurniture;
import timaxa007.pack.furniture.tile.TileEntityCnstorFence;
import timaxa007.tms.object.ModifiedBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCnstorFence extends ModifiedBlock implements ITileEntityProvider {

	public BlockCnstorFence(String tag) {
		super(tag, Material.glass);
		setCreativeTab(PackFurniture.tab_furniture);
		setHardness(1.0F);
		setResistance(3.5F);
		setLightOpacity(0);
		setStepSound(soundTypeWood);
		setBlockTextureName("timaxa007:woodFrame");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityCnstorFence();
	}

	public int getRenderType() {
		return PackFurniture.render.block_cnstor_fence_modelID;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(x, y, z);
		if (te != null && te instanceof TileEntityCnstorFence) {
			return addNBT(((TileEntityCnstorFence)te).getStyle());
		}
		return null;
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
		TileEntity te = world.getTileEntity(x, y, z);
		NBTTagCompound nbt = is.getTagCompound();
		if (te != null && te instanceof TileEntityCnstorFence) {
			if (nbt != null) {
				((TileEntityCnstorFence)te).setStyle(nbt.getString("Style"));
			}
		}
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block id, int meta) {}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item id, CreativeTabs table, List list) {
		//for (int j = 0; j < TileTexture.texTest01.length; ++j) {
		//for (int i = 0; i < 16; ++i) {
		String j = "";

		list.add(addNBT(j));
		//}
		//}
		//list.add(new ItemStack(id, 1, 0));
	}

	public static ItemStack addNBT(String par1) {
		ItemStack is = new ItemStack(PackFurniture.block.cnstor_fence, 1, 0);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setString("Style", par1);
		is.setTagCompound(nbt);
		return is;
	}


}
