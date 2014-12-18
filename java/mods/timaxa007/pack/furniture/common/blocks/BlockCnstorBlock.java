package mods.timaxa007.pack.furniture.common.blocks;

import java.util.List;
import java.util.Random;

import mods.timaxa007.lib.GetColors;
import mods.timaxa007.lib.TileTexture;
import mods.timaxa007.pack.furniture.common.main.PackFurniture;
import mods.timaxa007.pack.furniture.common.tile.TECnstorBlock;
import net.minecraft.block.Block;
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

public class BlockCnstorBlock extends Block implements ITileEntityProvider {

	public BlockCnstorBlock() {
		super(Material.glass);
		setCreativeTab(PackFurniture.proxy.tab_furniture);
		setHardness(1.0F);
		setResistance(3.5F);
		setLightOpacity(0);
		setStepSound(soundTypeWood);
		setBlockTextureName("timaxa007:woodFrame");
		setBlockName("cnstor.block");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {return new TECnstorBlock();}
	public int quantityDropped(Random radom) {return 0;}
	public int getRenderType() {return PackFurniture.proxy.render_block_cnstor_block_modelID;}
	public boolean isOpaqueCube() {return false;}
	//public boolean renderAsNormalBlock() {return false;}
	public int idPicked(World world, int x, int y, int z) {return 0;}

	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(x, y, z);
		if (te != null && te instanceof TECnstorBlock) {
			return addTag(((TECnstorBlock)te).getType(), ((TECnstorBlock)te).getColor());
		} else {
			return addTag(0, 0);
		}
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
		
		TileEntity te = world.getTileEntity(x, y, z);
		NBTTagCompound tag = is.getTagCompound();
		
		if (te != null && te instanceof TECnstorBlock && tag != null) {
			if (tag.hasKey("Type")) ((TECnstorBlock)te).setType(tag.getInteger("Type"));
			if (tag.hasKey("Color")) ((TECnstorBlock)te).setColor(tag.getInteger("Color"));
		}
		
	}

	@Override
	public void onBlockHarvested(World world, int x, int y, int z, int meta, EntityPlayer player) {
		if (!world.isRemote) {
			TileEntity te = world.getTileEntity(x, y, z);
			if (te != null && te instanceof TECnstorBlock && !player.capabilities.isCreativeMode) {
				dropBlockAsItem(world, x, y, z, addTag(((TECnstorBlock)te).getType(), ((TECnstorBlock)te).getColor()));
				world.removeTileEntity(x, y, z);
				world.setBlockToAir(x, y, z);
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item id, CreativeTabs table, List list) {
		for (int j = 0; j < TileTexture.texTest01.length; ++j) {
			//for (byte i = 0; i < 16; ++i) {
			//int j = 74;
			int i = 14;
			list.add(addTag(j, GetColors.getHexColors[i]));
			//}
		}
		//list.add(new ItemStack(id, 1, 0));
	}

	private static ItemStack addTag(int par1, int par2) {
		ItemStack is = new ItemStack(PackFurniture.proxy.block_cnstor_block);
		NBTTagCompound tag = new NBTTagCompound();
		tag.setInteger("Type", par1);
		tag.setInteger("Color", par2);
		is.setTagCompound(tag);
		return is;
	}

}
