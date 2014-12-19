package mods.timaxa007.pack.furniture.block;

import java.util.List;
import java.util.Random;

import mods.timaxa007.pack.furniture.PackFurniture;
import mods.timaxa007.pack.furniture.tile.TileEntityBookshelf;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBookshelf extends BlockContainer {
	protected Random random = new Random();

	public BlockBookshelf() {
		super(Material.wood);
		setCreativeTab(PackFurniture.tab_furniture);
		setHardness(0.5F);
		setBlockTextureName("bookshelf");
		setBlockName("bookshelf");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityBookshelf();
	}
	
	public int getRenderType() {
		return -1;
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
		if (te != null && te instanceof TileEntityBookshelf) {
			return addTag(0, ((TileEntityBookshelf)te).getType());
		}
		return addTag(0, 0);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		TileEntity te = world.getTileEntity(x, y, z);
		//if (!world.isRemote) {return false;}
		if (te == null || player.isSneaking()) {return false;}
		if (te != null && te instanceof TileEntityBookshelf) {
			player.openGui(PackFurniture.instance, PackFurniture.proxy.gui_bookshelf, world, x, y, z);
			return true;
		}
		return false;
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block id, int meta) {
		TileEntityBookshelf TileEntityBookshelf = (TileEntityBookshelf)world.getTileEntity(x, y, z);

		if (TileEntityBookshelf!=null) {
			for(int j1=0;j1<TileEntityBookshelf.getSizeInventory();++j1) {
				ItemStack itemstack=TileEntityBookshelf.getStackInSlot(j1);

				if (itemstack!=null) {
					float f=random.nextFloat()*0.8F+0.1F;
					float f1=random.nextFloat()*0.8F+0.1F;
					float f2=random.nextFloat()*0.8F+0.1F;

					while(itemstack.stackSize>0) {
						int k1=random.nextInt(21)+10;

						if (k1>itemstack.stackSize) {k1=itemstack.stackSize;}

						itemstack.stackSize-=k1;
						EntityItem entityitem=new EntityItem(world, (double)((float)x+f), (double)((float)y+f1), (double)((float)z+f2), new ItemStack(itemstack.getItem(), k1, itemstack.getItemDamage()));

						if (itemstack.hasTagCompound()) {
							entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
						}

						float f3=0.05F;
						entityitem.motionX=(double)((float)random.nextGaussian()*f3);
						entityitem.motionY=(double)((float)random.nextGaussian()*f3+0.2F);
						entityitem.motionZ=(double)((float)random.nextGaussian()*f3);
						world.spawnEntityInWorld(entityitem);
					}
				}
			}

		}

		super.breakBlock(world, x, y, z, id, meta);
	}

	public void spawnDropItem(World world, int x, int y, int z, ItemStack is) {
		if (!world.isRemote && world.getGameRules().getGameRuleBooleanValue("doTileDrops")) {
			EntityItem entityitem1 = new EntityItem(world, (double)x+0.5D, (double)y+0.5D, (double)z+0.5D, is);
			world.spawnEntityInWorld(entityitem1);
		}
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item id, CreativeTabs table, List list) {

		//for(int j=0;j<TileTexture.tt01.length;++j) {
		//for(byte i=0;i<16;++i) {
		int j=0;

		list.add(addTag(0, j));
		//list.add(addTag(1, j));
		//list.add(addTag(2, j));
		//list.add(addTag(3, j));
		//list.add(addTag(4, j));
		//list.add(addTag(5, j));
		//list.add(addTag(6, j));
		//list.add(addTag(7, j));
		//list.add(addTag(8, j));
		//list.add(addTag(9, j));
		//list.add(addTag(10, j));
		//list.add(addTag(11, j));
		//}
		//}
		//list.add(new ItemStack(id, 1, 0));
	}

	private static ItemStack addTag(int par1, int par2) {
		ItemStack is = new ItemStack(PackFurniture.proxy.block_bookshelf, 1, 0);
		NBTTagCompound tag = new NBTTagCompound();
		tag.setInteger("Type", par2);
		is.setTagCompound(tag);
		return is;
	}

}
