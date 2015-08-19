package timaxa007.pack.furniture.block;

import java.util.List;
import java.util.Random;

import timaxa007.pack.furniture.PackFurniture;
import timaxa007.pack.furniture.tile.TileEntityLights;
import timaxa007.pack.conjoint.object.ModifiedBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockLight extends ModifiedBlock implements ITileEntityProvider {

	public static final String[] block_type = new String[] {
		"lamp", 
		"burner", 
		"flashlight", 
		"lantern", 
		//"blowtorch", 
		""
	};

	public BlockLight(String tag) {
		super(tag, Material.glass);
		setStepSound(soundTypeStone);
		setBlockTextureName("glass");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityLights(world);
	}

	public int quantityDropped(Random random) {
		return 0;
	}

	public int getRenderType() {
		return PackFurniture.render.block_lights_modelID;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public int idPicked(World world, int x, int y, int z) {
		return 0;
	}

	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(x, y, z);
		if (te != null && te instanceof TileEntityLights) {
			TileEntityLights tile = (TileEntityLights)te;
			return addNBT(world.getBlock(x, y, z), tile.getType(), tile.getColorHex1());
		}
		return null;
	}

	public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB aabb, List list, Entity entity) {

		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.3125F, 1.0F);
		super.addCollisionBoxesToList(world, x, y, z, aabb, list, entity);

		float f = 0.125F;

		setBlockBounds(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
		super.addCollisionBoxesToList(world, x, y, z, aabb, list, entity);

		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
		super.addCollisionBoxesToList(world, x, y, z, aabb, list, entity);

		setBlockBounds(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		super.addCollisionBoxesToList(world, x, y, z, aabb, list, entity);

		setBlockBounds(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
		super.addCollisionBoxesToList(world, x, y, z, aabb, list, entity);

		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);

	}
	/*
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(x, y, z);
		if (te != null && te instanceof TileEntityLights) {
			TileEntityLights tile = (TileEntityLights)te;
			return null;
		}
		return super.getCollisionBoundingBoxFromPool(world, x, y, z);
	}
	 */
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
		TileEntity te = world.getTileEntity(x, y, z);
		NBTTagCompound nbt = is.getTagCompound();
		if (te != null && te instanceof TileEntityLights) {
			TileEntityLights tile = (TileEntityLights)te;
			if (nbt != null) {
				if (nbt.hasKey("Type")) tile.setType(nbt.getString("Type"));
				if (nbt.hasKey("ColorHex1")) tile.setColorHex1(nbt.getInteger("ColorHex1"));
			}
		}
	}

	@Override
	public void onBlockHarvested(World world, int x, int y, int z, int meta, EntityPlayer player) {
		if (!world.isRemote) {
			TileEntity te = world.getTileEntity(x, y, z);
			if (te != null && te instanceof TileEntityLights && !player.capabilities.isCreativeMode) {
				TileEntityLights tile = (TileEntityLights)te;
				dropBlockAsItem(world, x, y, z, addNBT(world.getBlock(x, y, z), tile.getType(), tile.getColorHex1()));
				world.removeTileEntity(x, y, z);
				world.setBlockToAir(x, y, z);
			}
		}
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		TileEntity te = world.getTileEntity(x, y, z);
		if (te == null || player.isSneaking()) return false;

		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			//--------------------------------
			/*if (current.getItem() == PackFurniture.item_colored && (current.getItemDamage() >= 0 && current.getItemDamage() < 16) {
				if (!player.capabilities.isCreativeMode) {--current.stackSize;}
				return true;
			}
			//--------------------------------
			else return false;*/
			//--------------------------------
		}
		return super.onBlockActivated(world, x, y, z, player, side, hitX, hitY, hitZ);
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item id, CreativeTabs table, List list) {
		for (int i = 0; i < block_type.length; i++) {
			list.add(addNBT(id, block_type[i], 0xFFFFFF));
		}
		//list.add(new ItemStack(id, 1, 0));
	}

	public static ItemStack addNBT(Block par1, String par2, int par3) {
		return addNBT(Item.getItemFromBlock(par1), par2, par3);
	}

	public static ItemStack addNBT(Item par1, String par2, int par3) {
		ItemStack is = new ItemStack(par1, 1, 0);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setString("Type", par2);
		nbt.setInteger("ColorHex1", par3);
		is.setTagCompound(nbt);
		return is;
	}

}
