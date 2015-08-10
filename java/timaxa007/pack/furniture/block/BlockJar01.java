package timaxa007.pack.furniture.block;

import java.util.List;

import timaxa007.pack.furniture.PackFurniture;
import timaxa007.pack.furniture.tile.TileEntityJar01;
import timaxa007.smt.object.ModifiedBlock;
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

public class BlockJar01 extends ModifiedBlock implements ITileEntityProvider {

	public BlockJar01(String tag) {
		super(tag, Material.glass);
		setCreativeTab(PackFurniture.tab_furniture);
		setHardness(0.25F);
		setLightOpacity(0);
		setBlockTextureName("glass");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityJar01(world);
	}

	public int getRenderType() {
		return PackFurniture.render.block_jar01_modelID;
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
		if (te != null && te instanceof TileEntityJar01) {
			return addNBT(((TileEntityJar01)te).getColorWater());
		}
		return null;
	}


	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
		TileEntity te = world.getTileEntity(x, y, z);
		NBTTagCompound nbt = is.getTagCompound();
		if (te != null && te instanceof TileEntityJar01) {
			if (nbt != null) {
				if (nbt.hasKey("ColorWater")) ((TileEntityJar01)te).setColorWater(nbt.getInteger("ColorWater"));
			}
		}
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		TileEntity te = world.getTileEntity(x, y, z);
		if (te == null || player.isSneaking()) return false;

		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			//--------------------------------
			/*if (current.getItem() == PackFurniture.item_colored && (current.getItemDamage() >= 0 && current.getItemDamage() < 16)) {
				--current.stackSize;
				((TileEntityJar01)te).setColorWater(GetColors.getHexColors[current.getItemDamage()]);
				return true;
			} else return false;*/
			//--------------------------------
		}
		return super.onBlockActivated(world, x, y, z, player, side, hitX, hitY, hitZ);
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item id, CreativeTabs table, List list) {
		list.add(addNBT(0xFFFFFF));
		//list.add(new ItemStack(id, 1, 0));
	}

	public static ItemStack addNBT(int par1) {
		ItemStack is = new ItemStack(PackFurniture.block.jar01, 1, par1);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setInteger("ColorWater", par1);
		is.setTagCompound(nbt);
		return is;
	}

}
