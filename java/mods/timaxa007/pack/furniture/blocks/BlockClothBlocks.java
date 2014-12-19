package mods.timaxa007.pack.furniture.blocks;

import java.util.List;
import java.util.Random;

import mods.timaxa007.lib.GetColors;
import mods.timaxa007.pack.furniture.PackFurniture;
import mods.timaxa007.pack.furniture.lib.AddBlockCloth;
import mods.timaxa007.pack.furniture.tile.TEClothBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockClothBlocks extends Block implements ITileEntityProvider {

	public static AddBlockCloth cloth_style1 = new AddBlockCloth("cloth_style1").setName("cloth_style1").setColor(0xFFFFFF).setTexture("cloth_style_1");

	@SideOnly(Side.CLIENT) private IIcon[] icon_array;

	public static String[] type_block = new String[] {
		"rock", 
		"stone_smooth"
	};

	public BlockClothBlocks() {
		super(Material.cloth);
		setCreativeTab(PackFurniture.proxy.tab_furniture);
		setHardness(0.5F);
		setResistance(5.0F);
		setStepSound(soundTypeCloth);
		//setBlockTextureName("cloth");
		setBlockName("block_cloth_blocks");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TEClothBlocks();
	}

	public int idPicked(World world, int x, int y, int z) {return 0;}

	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(x, y, z);
		if (te != null && te instanceof TEClothBlocks) {
			return addTag(world.getBlock(x, y, z), ((TEClothBlocks)te).getSubID(), ((TEClothBlocks)te).getColorBlock());
		} else {
			return addTag(world.getBlock(x, y, z), 0, 0xFFFFFF);
		}
	}

	public int quantityDropped(Random random) {
		return 0;
	}

	@SideOnly(Side.CLIENT)
	public int colorMultiplier(IBlockAccess block_access, int x, int y, int z) {
		TileEntity te = block_access.getTileEntity(x, y, z);
		if (te != null && te instanceof TEClothBlocks) {
			return ((TEClothBlocks)te).getColorBlock();
		}
		return 0xFFFFFF;
	}

	@SideOnly(Side.CLIENT)
	public IIcon getBlockTexture(IBlockAccess block_access, int x, int y, int z, int side) {
		TileEntity te = block_access.getTileEntity(x, y, z);
		if (te != null && te instanceof TEClothBlocks) {
			return icon_array[((TEClothBlocks)te).getSubID()];
		}
		return getIcon(side, block_access.getBlockMetadata(x, y, z));
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
		TileEntity te = world.getTileEntity(x, y, z);
		NBTTagCompound tag = is.getTagCompound();

		if (te != null && te instanceof TEClothBlocks && tag != null) {
			if (tag.hasKey("SubID")) ((TEClothBlocks)te).setSubID((int)tag.getByte("SubID"));
			if (tag.hasKey("ColorBlock")) ((TEClothBlocks)te).setColorBlock(tag.getInteger("ColorBlock"));
		}
		
	}

	@Override
	public void onBlockHarvested(World world, int x, int y, int z, int meta, EntityPlayer player) {
		if (!world.isRemote) {
			TileEntity te = world.getTileEntity(x, y, z);
			if (te != null && te instanceof TEClothBlocks && !player.capabilities.isCreativeMode) {
				dropBlockAsItem(world, x, y, z, addTag(world.getBlock(x, y, z), ((TEClothBlocks)te).getSubID(), ((TEClothBlocks)te).getColorBlock()));
				world.removeTileEntity(x, y, z);
				world.setBlockToAir(x, y, z);
			}
		}
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float hitX, float hitY, float hitZ) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			TileEntity te = world.getTileEntity(x, y, z);
			//--------------------------------
			if (current.getItem() == PackFurniture.proxy.item_colored && (current.getItemDamage() >= 0 && current.getItemDamage() < 16)) {
				if (!player.capabilities.isCreativeMode) {--current.stackSize;}
				//((TEClothBlocks)te).setColorBlock(GetColors.getHexColors[current.getItemDamage()]);
				((TEClothBlocks)te).setColorBlock(GetColors.getColorMix(GetColors.getHexColors[current.getItemDamage()], ((TEClothBlocks)te).getColorBlock()));
				//world.scheduleBlockUpdate(x, y, z, world.getBlock(x, y, z), 4);
				return true;
			}
			//--------------------------------
			else if (current.getItem() == Items.dye && (current.getItemDamage() >= 0 && current.getItemDamage() < 16)) {
				if (!player.capabilities.isCreativeMode) {--current.stackSize;}
				//((TEClothBlocks)te).setColorBlock(ItemDye.dyeColors[current.getItemDamage()]);
				((TEClothBlocks)te).setColorBlock(GetColors.getColorMix(ItemDye.field_150922_c[current.getItemDamage()], ((TEClothBlocks)te).getColorBlock()));
				//world.scheduleBlockUpdate(x, y, z, world.getBlock(x, y, z), 4);
				return true;
			}
			//--------------------------------
			else {
				return false;
			}
			//--------------------------------
		} else {
			return false;
		}
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item id, CreativeTabs table, List list) {
		for (int i = 0; i < type_block.length; i++) {
			for (int j = 0; j < 16; j++) {
				//int j = 14;
				list.add(addTag(id, i, GetColors.getHexColors[j]));
			}
			/*for (int j = 0; j < (Integer.MAX_VALUE / 1000000); j++) {//int j = 14;
				list.add(addTag(id, i, (j * 1000000)));
			}*/
		}
		//list.add(new ItemStack(id, 1, 0));
	}

	private static ItemStack addTag(Block par1, int par2, int par3) {
		return addTag(Item.getItemFromBlock(par1), par2, par3);
	}

	private static ItemStack addTag(Item par1, int par2, int par3) {
		ItemStack is = new ItemStack(par1, 1, 0);
		NBTTagCompound tag = new NBTTagCompound();
		tag.setByte("SubID", (byte)par2);
		tag.setInteger("ColorBlock", par3);
		is.setTagCompound(tag);
		return is;
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister ir) {
		icon_array = new IIcon[type_block.length];
		blockIcon = ir.registerIcon("cloth");
		for (int i = 0; i < icon_array.length; ++i) {
			icon_array[i] = ir.registerIcon("timaxa007:" + "cloth/" + type_block[i] + "_overlay");
		}
	}

}
