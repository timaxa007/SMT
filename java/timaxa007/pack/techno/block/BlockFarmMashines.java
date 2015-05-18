package timaxa007.pack.techno.block;

import java.util.List;

import timaxa007.pack.techno.PackTechno;
import timaxa007.pack.techno.tile.TileEntityFarmMashines;
import timaxa007.smt.lib.AddTextureModel;
import timaxa007.smt.object.ModifiedBlock;
import timaxa007.smt.util.UtilString;
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

public class BlockFarmMashines extends ModifiedBlock implements ITileEntityProvider {

	public BlockFarmMashines(String tag) {
		super(tag, Material.iron);
		setCreativeTab(PackTechno.tab_techno);
		setStepSound(soundTypeMetal);
		setBlockTextureName("iron_block");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityFarmMashines();
	}

	public int getRenderType() {
		return PackTechno.render.block_farm_mashines_modelID;
	}

	public boolean isOpaqueCube() {return false;}
	public boolean renderAsNormalBlock() {return false;}
	public int idPicked(World world, int x, int y, int z) {return 0;}

	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(x, y, z);
		if (te != null && te instanceof TileEntityFarmMashines) {
			TileEntityFarmMashines tile = (TileEntityFarmMashines)te;
			return addNBT(tile.getStyle(), tile.getType(), tile.getColor());
		}
		return null;
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
		TileEntity te = world.getTileEntity(x, y, z);
		NBTTagCompound nbt = is.getTagCompound();

		if (te != null && te instanceof TileEntityFarmMashines) {
			TileEntityFarmMashines tile = (TileEntityFarmMashines)te;

			if (nbt != null) {
				if (nbt.hasKey("Style")) tile.setStyle(nbt.getString("Style"));
				if (nbt.hasKey("Type")) tile.setType(nbt.getInteger("Type"));
				if (nbt.hasKey("ColorHex")) tile.setColor(nbt.getInteger("ColorHex"));
			}

			//int l=MathHelper.floor_double((double)(entity.rotationYaw*4.0F/360.0F)+0.5D)&3;
			//((TileEntityJar01)te).setRot(l);

		}

	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item id, CreativeTabs table, List list) {
		/*for (AddTextureModel texture : AddTextureModel.list) {
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
		}*/
		list.add(addNBT(AddTextureModel.empty.tag, 4, 0xFFFFFF));
		//list.add(new ItemStack(id, 1, 0));
	}

	public static ItemStack addNBT(String par1, int par2, int par3) {
		ItemStack is = new ItemStack(PackTechno.block.farm_mashines, 1, 0);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setString("Style", par1);
		nbt.setInteger("Type", par2);
		nbt.setInteger("ColorHex", par3);
		is.setTagCompound(nbt);
		return is;
	}

}
