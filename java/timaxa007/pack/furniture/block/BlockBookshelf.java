package timaxa007.pack.furniture.block;

import java.util.List;
import java.util.Random;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import timaxa007.gui.HandlerGui;
import timaxa007.pack.furniture.PackFurniture;
import timaxa007.pack.furniture.tile.TileEntityBookshelf;
import timaxa007.pack.conjoint.object.ModifiedBlock;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBookshelf extends ModifiedBlock implements ITileEntityProvider {

	private Random random = new Random();

	public BlockBookshelf(String tag) {
		super(tag, Material.wood);
		setCreativeTab(PackFurniture.tab_furniture);
		setHardness(0.5F);
		setBlockTextureName("bookshelf");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {return new TileEntityBookshelf(world);}
	public int getRenderType() {return PackFurniture.render.block_bookshelf_modelID;}
	public boolean isOpaqueCube() {return false;}
	public boolean renderAsNormalBlock() {return false;}
	public int idPicked(World world, int x, int y, int z) {return 0;}

	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(x, y, z);
		if (te != null && te instanceof TileEntityBookshelf) {
			return addNBT(0, ((TileEntityBookshelf)te).getStyle());
		}
		return null;
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		TileEntity te = world.getTileEntity(x, y, z);
		if (te == null || player.isSneaking()) return false;
		if (te != null && te instanceof TileEntityBookshelf) {
			HandlerGui.openGui(HandlerGui.GuiID.BOOKSHELF, player);
			return true;
		}
		return super.onBlockActivated(world, x, y, z, player, side, hitX, hitY, hitZ);
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item id, CreativeTabs table, List list) {

		//for(int j=0;j<TileTexture.tt01.length;++j) {
		//for(byte i=0;i<16;++i) {
		String j = "";

		list.add(addNBT(0, j));
		//list.add(addNBT(1, j));
		//list.add(addNBT(2, j));
		//list.add(addNBT(3, j));
		//list.add(addNBT(4, j));
		//list.add(addNBT(5, j));
		//list.add(addNBT(6, j));
		//list.add(addNBT(7, j));
		//list.add(addNBT(8, j));
		//list.add(addNBT(9, j));
		//list.add(addNBT(10, j));
		//list.add(addNBT(11, j));
		//}
		//}
		//list.add(new ItemStack(id, 1, 0));
	}

	public static ItemStack addNBT(int par1, String par2) {
		ItemStack is = new ItemStack(PackFurniture.block.bookshelf, 1, 0);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setString("Style", par2);
		is.setTagCompound(nbt);
		return is;
	}

}
