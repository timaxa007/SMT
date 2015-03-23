package timaxa007.pack.mining.block;

import java.util.List;

import timaxa007.pack.mining.PackMining;
import timaxa007.pack.mining.tile.TileEntityCristals;
import timaxa007.tms.util.ModifiedBlock;
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

public class BlockCristals extends ModifiedBlock implements ITileEntityProvider {

	public BlockCristals(String tag) {
		super(tag, Material.glass);
		setCreativeTab(PackMining.tab_mining);
		setHardness(0.25F);
		setLightOpacity(0);
		setBlockTextureName("glass");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityCristals();
	}

	public int getRenderType() {
		return PackMining.proxy.render.block_cristals_modelID;
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
		if (te != null && te instanceof TileEntityCristals)
			return addNBT(((TileEntityCristals)te).getType(), ((TileEntityCristals)te).getColor(), ((TileEntityCristals)te).getSize());
		return null;
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
		TileEntity te = world.getTileEntity(x, y, z);
		NBTTagCompound nbt = is.getTagCompound();
		if (te != null && te instanceof TileEntityCristals) {
			/*
			int l=MathHelper.floor_double((double)(entity.rotationYaw*4.0F/360.0F)+0.5D)&3;
			((TileEntityCristals)te).setRot(l);
			 */
			if (nbt != null) {
				if (nbt.hasKey("Type")) ((TileEntityCristals)te).setType(nbt.getInteger("Type"));
				if (nbt.hasKey("ColorHex")) ((TileEntityCristals)te).setColor(nbt.getInteger("ColorHex"));
				if (nbt.hasKey("Size")) ((TileEntityCristals)te).setSize(nbt.getInteger("Size"));
			}

		}
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item id, CreativeTabs table, List list) {
		for (int t = 0; t < 3; ++t) {
			for (int s = 1; s < 5; ++s) {
				list.add(addNBT(t, 0xFFFFFF, s));
			}
		}
		//list.add(new ItemStack(id, 1, 0));
	}

	public static ItemStack addNBT(int par1, int par2, int par3) {
		ItemStack is = new ItemStack(PackMining.proxy.block.cristals, 1, 0);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setInteger("Type", par1);
		nbt.setInteger("ColorHex", par2);
		nbt.setInteger("Size", par3);
		is.setTagCompound(nbt);
		return is;
	}

}
