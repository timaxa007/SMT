package timaxa007.pack.techno.block;

import java.util.List;

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
import timaxa007.pack.techno.PackTechno;
import timaxa007.pack.techno.tile.TileEntityElectricWires;
import timaxa007.smt.lib.AddTextureModel;
import timaxa007.smt.object.ModifiedBlock;
import timaxa007.smt.util.UtilString;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockElectricWires extends ModifiedBlock implements ITileEntityProvider {

	public BlockElectricWires(String tag) {
		super(tag, Material.glass);
		setCreativeTab(PackTechno.tab_techno);
		setHardness(0.25F);
		setBlockTextureName("glass");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {return new TileEntityElectricWires(world);}
	public int getRenderType() {return PackTechno.render.block_electric_wires_modelID;}
	public boolean isOpaqueCube() {return false;}
	public boolean renderAsNormalBlock() {return false;}
	public int idPicked(World world, int x, int y, int z) {return 0;}

	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(x, y, z);
		if (te != null && te instanceof TileEntityElectricWires) {
			TileEntityElectricWires tile = (TileEntityElectricWires)te;
			return addNBT(tile.getStyle(), tile.getSize(), tile.getColor());
		}
		return null;
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
		TileEntity te = world.getTileEntity(x, y, z);
		NBTTagCompound nbt = is.getTagCompound();

		if (te != null && te instanceof TileEntityElectricWires) {
			TileEntityElectricWires tile = (TileEntityElectricWires)te;

			//int l=MathHelper.floor_double((double)(entity.rotationYaw*4.0F/360.0F)+0.5D)&3;
			//tile.setRot(l);

			if (nbt != null) {
				//if (nbt.hasKey("Type")) tile.setType(nbt.getInteger("Type"));
				if (nbt.hasKey("Style")) tile.setStyle(nbt.getString("Style"));
				if (nbt.hasKey("Size")) tile.setSize(nbt.getInteger("Size"));
				if (nbt.hasKey("Color")) tile.setColor(nbt.getInteger("Color"));

				tile.updateExtensively(world, x, y, z);

			}

		}

	}

	@Override
	public void onBlockHarvested(World world, int x, int y, int z, int meta, EntityPlayer player) {
		TileEntity te = world.getTileEntity(x, y, z);
		if (te != null && te instanceof TileEntityElectricWires) {
			if (!world.isRemote && !player.capabilities.isCreativeMode) {
				TileEntityElectricWires tile = (TileEntityElectricWires)te;
				dropBlockAsItem(world, x, y, z, addNBT(tile.getStyle(), tile.getSize(), tile.getColor()));
				world.removeTileEntity(x, y, z);
				world.setBlockToAir(x, y, z);
			}
			TileEntityElectricWires.updateExtensively(world, x, y, z);
		}
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item id, CreativeTabs table, List list) {
		for (AddTextureModel texture : AddTextureModel.list) {
			if (!texture.isNull(texture) && UtilString.hasString(texture.tag)) {
				list.add(addNBT(texture.tag, 1, 0xFFFFFF));
				list.add(addNBT(texture.tag, 2, 0xFFFFFF));
				list.add(addNBT(texture.tag, 3, 0xFFFFFF));
				list.add(addNBT(texture.tag, 4, 0xFFFFFF));
				list.add(addNBT(texture.tag, 5, 0xFFFFFF));
				list.add(addNBT(texture.tag, 6, 0xFFFFFF));
				list.add(addNBT(texture.tag, 7, 0xFFFFFF));
				list.add(addNBT(texture.tag, 8, 0xFFFFFF));
			}
		}
		//list.add(new ItemStack(id, 1, 0));
	}

	public static ItemStack addNBT(String par1, int par2, int par3) {
		ItemStack is = new ItemStack(PackTechno.block.electric_wires, 1, 0);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setString("Style", par1);
		nbt.setInteger("Size", par2);
		nbt.setInteger("Color", par3);
		is.setTagCompound(nbt);
		return is;
	}

}
