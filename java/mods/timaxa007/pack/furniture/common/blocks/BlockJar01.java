package mods.timaxa007.pack.furniture.common.blocks;

import java.util.List;

import mods.timaxa007.lib.GetColors;
import mods.timaxa007.pack.furniture.common.main.PackFurniture;
import mods.timaxa007.pack.furniture.common.tile.TEJar01;
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

public class BlockJar01 extends Block implements ITileEntityProvider {

	public BlockJar01() {
		super(Material.glass);
		setCreativeTab(PackFurniture.proxy.tab_furniture);
		setHardness(0.25F);
		setLightOpacity(0);
		setBlockTextureName("glass");
		setBlockName("jar01");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TEJar01();
	}

	public int getRenderType() {
		return PackFurniture.proxy.render_block_jar01_modelID;
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
		if (te != null && te instanceof TEJar01) {
			return addTag(((TEJar01)te).getColorWater());
		}
		return null;
	}


	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
		TileEntity te = world.getTileEntity(x, y, z);
		NBTTagCompound tag = is.getTagCompound();
		if (te != null && te instanceof TEJar01) {
			if (tag != null) {
				if (tag.hasKey("ColorWater")) ((TEJar01)te).setColorWater(tag.getInteger("ColorWater"));
			}
		}
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			TileEntity te = world.getTileEntity(x, y, z);
			//--------------------------------
			/*if (current.getItem() == PackFurniture.proxy.item_colored && (current.getItemDamage() >= 0 && current.getItemDamage() < 16)) {
				--current.stackSize;
				((TEJar01)te).setColorWater(GetColors.getHexColors[current.getItemDamage()]);
				return true;
			} else return false;*/
			//--------------------------------
		}
		return false;
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item id, CreativeTabs table, List list) {
		//for (int j = 0; j < 16; ++j) {
		int j = 14;
		list.add(addTag(GetColors.getHexColors[j]));
		//}
		//list.add(new ItemStack(id, 1, 0));
	}

	private static ItemStack addTag(int par1) {
		ItemStack is = new ItemStack(PackFurniture.proxy.block_jar01, 1, par1);
		NBTTagCompound tag = new NBTTagCompound();
		tag.setInteger("ColorWater", par1);
		is.setTagCompound(tag);
		return is;
	}

}
