package mods.timaxa007.pack.furniture.block;

import mods.timaxa007.pack.furniture.PackFurniture;
import mods.timaxa007.pack.furniture.tile.TileEntityFurnitureWoodBlocks;
import mods.timaxa007.tms.util.BlockFixReg;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockFurnitureWoodBlocks extends BlockFixReg implements ITileEntityProvider {

	@SideOnly(Side.CLIENT) private IIcon[] icon_array;

	public BlockFurnitureWoodBlocks(String tag) {
		super(tag, Material.wood);
		setCreativeTab(PackFurniture.tab_furniture);
		setHardness(0.75F);
		setResistance(7.0F);
		setStepSound(soundTypeWood);
		//setBlockTextureName("wood_oak");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityFurnitureWoodBlocks();
	}
	/*
	public int quantityDropped(Random random) {
		return 0;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	@SideOnly(Side.CLIENT)
	public int colorMultiplier(IBlockAccess block_access, int x, int y, int z) {
		TileEntity te = block_access.getTileEntity(x, y, z);
		if (te != null && te instanceof TileEntityWoodBlocks) {
			return ((TileEntityWoodBlocks)te).getColorBlock();
		}
		return 0xFFFFFF;
	}

	@SideOnly(Side.CLIENT)
	public IIcon getBlockTexture(IBlockAccess block_access, int x, int y, int z, int side) {
		TileEntity te = block_access.getTileEntity(x, y, z);
		if (te != null && te instanceof TileEntityWoodBlocks) {
			return icon_array[((TileEntityWoodBlocks)te).getSubID()];
		}
		return getIcon(side, block_access.getBlockMetadata(x, y, z));
	}

	public int idPicked(World world, int x, int y, int z) {return 0;}

	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(x, y, z);
		if (te != null && te instanceof TileEntityWoodBlocks) {
			return addTag(world.getBlock(x, y, z), ((TileEntityWoodBlocks)te).getSubID(), ((TileEntityWoodBlocks)te).getColorBlock());
		} else {
			return addTag(world.getBlock(x, y, z), 0, 0xFFFFFF);
		}
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
		TileEntity te = world.getTileEntity(x, y, z);
		NBTTagCompound tag = is.getTagCompound();
		if (te != null && te instanceof TileEntityWoodBlocks && tag != null) {
			if (tag.hasKey("SubID")) {((TileEntityWoodBlocks)te).setSubID((int)tag.getByte("SubID"));} 
			else {((TileEntityWoodBlocks)te).setSubID(0);}
			if (tag.hasKey("ColorBlock")) {((TileEntityWoodBlocks)te).setColorBlock(tag.getInteger("ColorBlock"));} 
			else {((TileEntityWoodBlocks)te).setColorBlock(0xFFFFFF);}
		}
	}

	@Override
	public void onBlockHarvested(World world, int x, int y, int z, int meta, EntityPlayer player) {
		if (!world.isRemote) {
			TileEntity te = world.getTileEntity(x, y, z);
			if (te != null && te instanceof TileEntityWoodBlocks && !player.capabilities.isCreativeMode) {
				dropBlockAsItem(world, x, y, z, addTag(world.getBlock(x, y, z), ((TileEntityWoodBlocks)te).getSubID(), ((TileEntityWoodBlocks)te).getColorBlock()));
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
			if (current.getItem() == PackFurniture.proxy.item.colored && (current.getItemDamage() >= 0 && current.getItemDamage() < 16)) {
				if (!player.capabilities.isCreativeMode) {--current.stackSize;}
				//((TileEntityWoodBlocks)te).setColorBlock(GetColors.getHexColors[current.getItemDamage()]);
				((TileEntityWoodBlocks)te).setColorBlock(GetColors.getColorMix(GetColors.getHexColors[current.getItemDamage()], ((TileEntityWoodBlocks)te).getColorBlock()));
				//world.scheduleBlockUpdate(x, y, z, world.getBlock(x, y, z), 4);
				return true;
			}
			//--------------------------------
			else if (current.getItem() == Items.dye && (current.getItemDamage() >= 0 && current.getItemDamage() < 16)) {
				if (!player.capabilities.isCreativeMode) {--current.stackSize;}
				//((TileEntityWoodBlocks)te).setColorBlock(ItemDye.dyeColors[current.getItemDamage()]);
				((TileEntityWoodBlocks)te).setColorBlock(GetColors.getColorMix(ItemDye.field_150922_c[current.getItemDamage()], ((TileEntityWoodBlocks)te).getColorBlock()));
				//world.scheduleBlockUpdate(x, y, z, world.getBlock(x, y, z), 4);
				return true;
			}
			//--------------------------------
			else {return false;}
			//--------------------------------
		} else {return false;}
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item id, CreativeTabs table, List list) {
		for (int i = 0; i < type_block.length; i++) {
			for (int j = 0; j < 16; j++) {
				//int j = 14;
				list.add(addTag(id, i, GetColors.getHexColors[j]));
			}
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
		blockIcon = ir.registerIcon("planks_oak");
		for (int i = 0; i < icon_array.length; ++i) {
			icon_array[i] = ir.registerIcon("timaxa007:" + "wood/" + type_block[i] + "_overlay");
		}
	}
	 */
}
