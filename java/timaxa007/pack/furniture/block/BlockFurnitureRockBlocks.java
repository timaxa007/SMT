package timaxa007.pack.furniture.block;

import timaxa007.pack.furniture.PackFurniture;
import timaxa007.pack.furniture.tile.TileEntityFurnitureRockBlocks;
import timaxa007.pack.conjoint.object.ModifiedBlock;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockFurnitureRockBlocks extends ModifiedBlock implements ITileEntityProvider {

	@SideOnly(Side.CLIENT) private IIcon[] icon_array;

	public BlockFurnitureRockBlocks(String tag) {
		super(tag, Material.rock);
		setCreativeTab(PackFurniture.tab_furniture);
		setHardness(1.5F);
		setResistance(10.0F);
		setStepSound(soundTypeStone);
		//setBlockTextureName("stone");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityFurnitureRockBlocks(world);
	}
	/*

	public int quantityDropped(Random random) {
		return 0;
	}

	@SideOnly(Side.CLIENT)
	public int colorMultiplier(IBlockAccess block_access, int x, int y, int z) {
		TileEntity te = block_access.getTileEntity(x, y, z);
		if (te != null && te instanceof TileEntityRockBlocks)
			return ((TileEntityRockBlocks)te).getColorBlock();
		return 0xFFFFFF;
	}

	@SideOnly(Side.CLIENT)
	public IIcon getBlockTexture(IBlockAccess block_access, int x, int y, int z, int side) {
		TileEntity te = block_access.getTileEntity(x, y, z);
		if (te != null && te instanceof TileEntityRockBlocks)
			return icon_array[((TileEntityRockBlocks)te).getSubID()];
		return getIcon(side, block_access.getBlockMetadata(x, y, z));
	}

	public int idPicked(World world, int x, int y, int z) {
		return 0;
	}

	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(x, y, z);
		if (te != null && te instanceof TileEntityRockBlocks)
			return addNBT(world.getBlock(x, y, z), ((TileEntityRockBlocks)te).getSubID(), ((TileEntityRockBlocks)te).getColorBlock());
		return null;
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
		TileEntity te = world.getTileEntity(x, y, z);
		NBTTagCompound nbt = is.getTagCompound();
		if (te != null && te instanceof TileEntityRockBlocks && tag != null) {
			if (nbt.hasKey("SubID")) ((TileEntityRockBlocks)te).setSubID((int)nbt.getByte("SubID"));
			if (nbt.hasKey("ColorBlock")) ((TileEntityRockBlocks)te).setColorBlock(nbt.getInteger("ColorBlock"));
		}
	}

	@Override
	public void onBlockHarvested(World world, int x, int y, int z, int meta, EntityPlayer player) {
		if (!world.isRemote) {
			TileEntity te = world.getTileEntity(x, y, z);
			if (te != null && te instanceof TileEntityRockBlocks && !player.capabilities.isCreativeMode) {
				dropBlockAsItem(world, x, y, z, addNBT(world.getBlock(x, y, z), ((TileEntityRockBlocks)te).getSubID(), ((TileEntityRockBlocks)te).getColorBlock()));
				world.removeTileEntity(x, y, z);
				world.setBlockToAir(x, y, z);
			}
		}
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if (te == null || player.isSneaking()) return false;
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			TileEntity te = world.getTileEntity(x, y, z);
			//--------------------------------
			if (current.getItem() == PackFurniture.item.colored && (current.getItemDamage() >= 0 && current.getItemDamage() < 16)) {
				if (!player.capabilities.isCreativeMode) {--current.stackSize;}
				//((TileEntityRockBlocks)te).setColorBlock(GetColors.getHexColors[current.getItemDamage()]);
				((TileEntityRockBlocks)te).setColorBlock(GetColors.getColorMix(GetColors.getHexColors[current.getItemDamage()], ((TileEntityRockBlocks)te).getColorBlock()));
				//world.scheduleBlockUpdate(x, y, z, world.getBlock(x, y, z), 4);
				return true;
			}
			//--------------------------------
			else if (current.getItem() == Items.dye && (current.getItemDamage() >= 0 && current.getItemDamage() < 16)) {
				if (!player.capabilities.isCreativeMode) {--current.stackSize;}
				//((TileEntityRockBlocks)te).setColorBlock(ItemDye.dyeColors[current.getItemDamage()]);
				((TileEntityRockBlocks)te).setColorBlock(GetColors.getColorMix(ItemDye.field_150922_c[current.getItemDamage()], ((TileEntityRockBlocks)te).getColorBlock()));
				//world.scheduleBlockUpdate(x, y, z, world.getBlock(x, y, z), 4);
				return true;
			}
			//--------------------------------
			else return false;
			//--------------------------------
		}
		return super.onBlockActivated(world, x, y, z, player, side, hitX, hitY, hitZ);
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item id, CreativeTabs table, List list) {
		for (int i = 0; i < type_block.length; i++) {
			for (int j = 0; j < 16; j++) {
				//int j = 14;
				list.add(addNBT(id, i, GetColors.getHexColors[j]));
			}
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
		is.setTagCompound(tag);
		return is;
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister ir) {
		icon_array = new IIcon[type_block.length];
		blockIcon = ir.registerIcon("stone");
		for (int i = 0; i < icon_array.length; ++i) {
			icon_array[i] = ir.registerIcon("timaxa007:" + "stone/" + type_block[i] + "_overlay");
		}
	}

	 */
}
