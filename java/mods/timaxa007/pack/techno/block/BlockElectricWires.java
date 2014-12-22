package mods.timaxa007.pack.techno.block;

import java.util.List;

import mods.timaxa007.lib.AddTextureModel;
import mods.timaxa007.pack.techno.PackTechno;
import mods.timaxa007.pack.techno.tile.TileEntityElectricWires;
import net.minecraft.block.Block;
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

public class BlockElectricWires extends Block implements ITileEntityProvider {

	public BlockElectricWires() {
		super(Material.glass);
		setCreativeTab(PackTechno.tab_techno);
		setBlockTextureName("glass");
		setBlockName("wires");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityElectricWires();
	}

	public int getRenderType() {
		return PackTechno.proxy.render_block_electric_wires_modelID;
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
		if (te != null && te instanceof TileEntityElectricWires) {
			TileEntityElectricWires tile = (TileEntityElectricWires)te;
			return addTag(tile.getStyle(), tile.getSize(), tile.getColor());
		}
		return null;
	}


	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
		TileEntity te = world.getTileEntity(x, y, z);
		NBTTagCompound tag = is.getTagCompound();

		if (te != null && te instanceof TileEntityElectricWires) {
			TileEntityElectricWires tile = (TileEntityElectricWires)te;

			//int l=MathHelper.floor_double((double)(entity.rotationYaw*4.0F/360.0F)+0.5D)&3;
			//((TileEntityJar01)te).setRot(l);

			if (tag != null) {
				//if (tag.hasKey("Type")) tile.setType(tag.getInteger("Type"));
				if (tag.hasKey("Style")) tile.setStyle(tag.getString("Style"));
				if (tag.hasKey("Size")) tile.setSize(tag.getInteger("Size"));
				if (tag.hasKey("Color")) tile.setColor(tag.getInteger("Color"));
			}

		}

	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item id, CreativeTabs table, List list) {
		for (int j = 0; j < AddTextureModel.list.length; ++j) {
			if (AddTextureModel.list[j] != null && AddTextureModel.list[j].tag != null) {
				list.add(addTag(AddTextureModel.list[j].tag, 1, 0xFFFFFF));
				list.add(addTag(AddTextureModel.list[j].tag, 2, 0xFFFFFF));
				list.add(addTag(AddTextureModel.list[j].tag, 3, 0xFFFFFF));
				list.add(addTag(AddTextureModel.list[j].tag, 4, 0xFFFFFF));
				list.add(addTag(AddTextureModel.list[j].tag, 5, 0xFFFFFF));
				list.add(addTag(AddTextureModel.list[j].tag, 6, 0xFFFFFF));
				list.add(addTag(AddTextureModel.list[j].tag, 7, 0xFFFFFF));
				list.add(addTag(AddTextureModel.list[j].tag, 8, 0xFFFFFF));
			}
		}
		//list.add(new ItemStack(id, 1, 0));
	}

	private static ItemStack addTag(String par1, int par2, int par3) {
		ItemStack is = new ItemStack(PackTechno.proxy.block_electric_wires, 1, 0);
		NBTTagCompound tag = new NBTTagCompound();
		tag.setString("Style", par1);
		tag.setInteger("Size", par2);
		tag.setInteger("Color", par3);
		is.setTagCompound(tag);
		return is;
	}

}
