package timaxa007.pack.furniture.block;

import java.util.List;
import java.util.Random;

import timaxa007.pack.furniture.PackFurniture;
import timaxa007.pack.furniture.lib.AddBlockGlass;
import timaxa007.pack.furniture.tile.TileEntityGlassBlocks;
import timaxa007.tms.util.ModifiedBlock;
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

public class BlockGlassBlocks extends ModifiedBlock implements ITileEntityProvider {

	@SideOnly(Side.CLIENT) private IIcon[] icon_array;

	public static AddBlockGlass glass_style1 = new AddBlockGlass("glass_style1").setName("glass_style1").setColor(0xFFFFFF).setTexture("glass_style_1");

	public static String[] type_block = new String[] {
		"glass_b", 
		"glass", 
		"glass_plastic", 
		"glass2_b", 
		"glass3_b", 
		"glass4_b"
	};

	public BlockGlassBlocks(String tag) {
		super(tag, Material.glass);
		setCreativeTab(PackFurniture.tab_furniture);
		setHardness(1.5F);
		setResistance(10.0F);
		setStepSound(soundTypeGlass);
		//setBlockTextureName("glass");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityGlassBlocks();
	}

	public int quantityDropped(Random random) {
		return 0;
	}

	@SideOnly(Side.CLIENT)
	public int getRenderBlockPass() {
		return 0;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	protected boolean canSilkHarvest() {
		return true;
	}

	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess block_access, int x, int y, int z, int side) {
		return super.shouldSideBeRendered(block_access, x, y, z, side);
	}

	@SideOnly(Side.CLIENT)
	public int colorMultiplier(IBlockAccess block_access, int x, int y, int z) {
		TileEntity te = block_access.getTileEntity(x, y, z);
		if (te != null && te instanceof TileEntityGlassBlocks) {
			return ((TileEntityGlassBlocks)te).getColorBlock();
		}
		return 0xFFFFFF;
	}

	@SideOnly(Side.CLIENT)
	public IIcon getBlockTexture(IBlockAccess block_access, int x, int y, int z, int side) {
		TileEntity te = block_access.getTileEntity(x, y, z);
		if (te != null && te instanceof TileEntityGlassBlocks) {
			return icon_array[((TileEntityGlassBlocks)te).getSubID()];
		}
		return getIcon(side, block_access.getBlockMetadata(x, y, z));
	}

	public int idPicked(World world, int x, int y, int z) {
		return 0;
	}

	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(x, y, z);
		if (te != null && te instanceof TileEntityGlassBlocks) {
			return addNBT(world.getBlock(x, y, z), ((TileEntityGlassBlocks)te).getSubID(), ((TileEntityGlassBlocks)te).getColorBlock());
		}
		return null;
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
		TileEntity te = world.getTileEntity(x, y, z);
		NBTTagCompound nbt = is.getTagCompound();
		if (te != null && te instanceof TileEntityGlassBlocks && nbt != null) {
			if (nbt.hasKey("SubID")) ((TileEntityGlassBlocks)te).setSubID((int)nbt.getByte("SubID"));
			if (nbt.hasKey("ColorBlock")) ((TileEntityGlassBlocks)te).setColorBlock(nbt.getInteger("ColorBlock"));
		}
	}

	@Override
	public void onBlockHarvested(World world, int x, int y, int z, int meta, EntityPlayer player) {
		if (!world.isRemote) {
			TileEntity te = world.getTileEntity(x, y, z);
			if (te != null && te instanceof TileEntityGlassBlocks && !player.capabilities.isCreativeMode) {
				dropBlockAsItem(world, x, y, z, addNBT(world.getBlock(x, y, z), ((TileEntityGlassBlocks)te).getSubID(), ((TileEntityGlassBlocks)te).getColorBlock()));
				world.removeTileEntity(x, y, z);
				world.setBlockToAir(x, y, z);
			}
		}
	}
	/*
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float hitX, float hitY, float hitZ) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			TileEntity te = world.getTileEntity(x, y, z);
			//--------------------------------
			if (current.getItem() == PackFurniture.proxy.item.colored && (current.getItemDamage() >= 0 && current.getItemDamage() < 16)) {
				if (!player.capabilities.isCreativeMode) {--current.stackSize;}
				//((TileEntityGlassBlocks)te).setColorBlock(GetColors.getHexColors[current.getItemDamage()]);
				((TileEntityGlassBlocks)te).setColorBlock(GetColors.getColorMix(GetColors.getHexColors[current.getItemDamage()], ((TileEntityGlassBlocks)te).getColorBlock()));
				//world.scheduleBlockUpdate(x, y, z, world.getBlock(x, y, z), 4);
				return true;
			}
			//--------------------------------
			else if (current.getItem() == Items.dye && (current.getItemDamage() >= 0 && current.getItemDamage() < 16)) {
				if (!player.capabilities.isCreativeMode) {--current.stackSize;}
				//((TileEntityGlassBlocks)te).setColorBlock(ItemDye.dyeColors[current.getItemDamage()]);
				((TileEntityGlassBlocks)te).setColorBlock(GetColors.getColorMix(ItemDye.field_150922_c[current.getItemDamage()], ((TileEntityGlassBlocks)te).getColorBlock()));
				//world.scheduleBlockUpdate(x, y, z, world.getBlock(x, y, z), 4);
				return true;
			}
			//--------------------------------
			else return false;
			//--------------------------------
		}
		return false;
	}
	 */
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item id, CreativeTabs table, List list) {
		for (int i = 0; i < type_block.length; i++) {
			list.add(addNBT(id, i, 0xFFFFFF));
		}
		//list.add(new ItemStack(id, 1, 0));
	}

	public static ItemStack addNBT(Block par1, int par2, int par3) {
		return addNBT(Item.getItemFromBlock(par1), par2, par3);
	}

	public static ItemStack addNBT(Item par1, int par2, int par3) {
		ItemStack is = new ItemStack(par1, 1, 0);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setByte("SubID", (byte)par2);
		nbt.setInteger("ColorBlock", par3);
		is.setTagCompound(nbt);
		return is;
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister ir) {
		icon_array = new IIcon[type_block.length];
		blockIcon = ir.registerIcon("glass");
		for (int i = 0; i < icon_array.length; ++i) {
			icon_array[i] = ir.registerIcon("timaxa007:" + "glass/" + type_block[i] + "_overlay");
		}
	}

}
