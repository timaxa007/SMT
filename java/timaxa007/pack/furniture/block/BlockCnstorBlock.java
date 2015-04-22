package timaxa007.pack.furniture.block;

import java.util.List;
import java.util.Random;

import timaxa007.pack.furniture.PackFurniture;
import timaxa007.pack.furniture.tile.TileEntityCnstorBlock;
import timaxa007.tms.lib.AddTextureModel;
import timaxa007.tms.object.ModifiedBlock;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCnstorBlock extends ModifiedBlock implements ITileEntityProvider {

	public BlockCnstorBlock(String tag) {
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
		return new TileEntityCnstorBlock();
	}

	public int quantityDropped(Random radom) {
		return 0;
	}

	public int getRenderType() {
		return PackFurniture.render.block_cnstor_block_modelID;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	/*public boolean renderAsNormalBlock() {
		return false;
	}*/

	public int idPicked(World world, int x, int y, int z) {
		return 0;
	}

	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(x, y, z);
		if (te != null && te instanceof TileEntityCnstorBlock) {
			TileEntityCnstorBlock tile = (TileEntityCnstorBlock)te;
			return addNBT(tile.getStyle(), tile.getColor());
		}
		return null;
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {

		TileEntity te = world.getTileEntity(x, y, z);
		NBTTagCompound nbt = is.getTagCompound();

		if (te != null && te instanceof TileEntityCnstorBlock) {
			TileEntityCnstorBlock tile = (TileEntityCnstorBlock)te;
			if (nbt != null) {
				if (nbt.hasKey("Style")) tile.setStyle(nbt.getString("Style"));
				if (nbt.hasKey("ColorHex")) tile.setColor(nbt.getInteger("ColorHex"));
			}
		}

	}

	@Override
	public void onBlockHarvested(World world, int x, int y, int z, int meta, EntityPlayer player) {
		if (!world.isRemote) {
			TileEntity te = world.getTileEntity(x, y, z);
			if (te != null && te instanceof TileEntityCnstorBlock && !player.capabilities.isCreativeMode) {
				TileEntityCnstorBlock tile = (TileEntityCnstorBlock)te;
				dropBlockAsItem(world, x, y, z, addNBT(tile.getStyle(), tile.getColor()));
				world.removeTileEntity(x, y, z);
				world.setBlockToAir(x, y, z);
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item id, CreativeTabs table, List list) {
		for (int j = 0; j < AddTextureModel.list.length; ++j) {
			if (AddTextureModel.list[j] != null && AddTextureModel.list[j].tag != null) {
				list.add(addNBT(AddTextureModel.list[j].tag, 0xFFFFFF));
			}
		}
		//list.add(new ItemStack(id, 1, 0));
	}

	public static ItemStack addNBT(String par1, int par2) {
		ItemStack is = new ItemStack(PackFurniture.block.cnstor_block);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setString("Style", par1);
		nbt.setInteger("ColorHex", par2);
		is.setTagCompound(nbt);
		return is;
	}

}
