package smt.pack.technology.block;

import java.util.List;
import java.util.Map;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants.NBT;
import smt.pack.common.api.ICustomName;
import smt.pack.technology.SMTTechnology;
import smt.pack.technology.inventory.GuiID;
import smt.pack.technology.registry.RegistryMachine;
import smt.pack.technology.tile.TileEntityElectricMachine;
import smt.pack.technology.tile.machine.ElectricCrusher;
import smt.pack.technology.tile.machine.ElectricGenerator;
import smt.pack.technology.tile.machine.ElectricMachine;

public class BlockElectricMachine extends Block implements ITileEntityProvider {

	public BlockElectricMachine() {
		super(Material.iron);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		System.out.println("createNewTileEntity");
		return new TileEntityElectricMachine();
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		TileEntity tile = world.getTileEntity(x, y, z);
		if (tile instanceof TileEntityElectricMachine) {
			TileEntityElectricMachine te = (TileEntityElectricMachine)tile;
			SMTTechnology.proxy.openGui(GuiID.ELECTRIC_MACHINE, player, x, y, z);
			/*if (te.getElectricMachine() instanceof ElectricCrusher) {
				SMTTechnology.proxy.openGui(GuiID.ELECTRIC_CRASHER, player, x, y, z);
			} else if (te.getElectricMachine() instanceof ElectricGenerator) {
				SMTTechnology.proxy.openGui(GuiID.ELECTRIC_GENERATOR, player, x, y, z);
			}*/
		}
		/*
		TileEntity tile = world.getTileEntity(x, y, z);
		if (tile != null) {
			//System.out.println("tile = " + tile.toString());
			if (tile instanceof TileEntityElectricMachine) {
				SMTTechnology.proxy.openGui(GuiID.BLOCKS_TECHNOLOGY, player, x, y, z);
				return true;
			} else if (tile instanceof TileEntityElectricFurnace) {
				SMTTechnology.proxy.openGui(GuiID.ELECTRIC_FURNACE, player, x, y, z);
				return true;
			} else if (tile instanceof TileEntityElectricBoxAccumulator) {
				SMTTechnology.proxy.openGui(GuiID.BLOCK_ACCUMULATOR, player, x, y, z);
				return true;
			} else if (tile instanceof IInventory) {
				//IInventory inv = (IInventory)tile;
			}
		}
		 */
		//return super.onBlockActivated(world, x, y, z, player, side, hitX, hitY, hitZ);
		return true;
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemStack) {
		world.setBlockMetadataWithNotify(x, y, z, itemStack.getItemDamage(), 3);
		TileEntity tile = world.getTileEntity(x, y, z);
		if (tile != null) {
			if (tile instanceof TileEntityElectricMachine) {
				TileEntityElectricMachine te = (TileEntityElectricMachine)tile;
				NBTTagCompound nbt = itemStack.getTagCompound();
				if (nbt != null && nbt.hasKey("ElectricMachine", NBT.TAG_STRING))
					te.setElectricMachine(nbt.getString("ElectricMachine"));
			} else if (tile instanceof IInventory) {
				IInventory inv = (IInventory)tile;
			}

			if (tile instanceof ICustomName)
				if (itemStack.hasDisplayName()) ((ICustomName)tile).setName(itemStack.getDisplayName());
		}
		//int l = MathHelper.floor_double((double)(p_149689_5_.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
		/*
		TileEntity tile = world.getTileEntity(x, y, z);
		if (tile != null) {
			if (tile instanceof TileEntityElectricMachine) {
				TileEntityElectricMachine te = (TileEntityElectricMachine)tile;
				IInventory inv;
				inv = te.getInventoryIn();
				for (int i = 0; i < inv.getSizeInventory(); ++i) {
					ItemStack itemStack = inv.getStackInSlot(i);
					if (itemStack != null) spawnItem(world, x, y, z, is);
				}
				inv = te.getInventoryOut();
				for (int i = 0; i < inv.getSizeInventory(); ++i) {
					ItemStack itemStack = inv.getStackInSlot(i);
					if (itemStack != null) spawnItem(world, x, y, z, is);
				}
			} else if (tile instanceof IInventory) {
				IInventory inv = (IInventory)tile;
				for (int i = 0; i < inv.getSizeInventory(); ++i) {
					ItemStack itemStack = inv.getStackInSlot(i);
					if (itemStack != null) dropBlockAsItem(world, x, y, z, itemStack);
				}
			}
		}
		 */
		super.breakBlock(world, x, y, z, block, meta);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list) {
		for (Map.Entry<String, Class<? extends ElectricMachine>> o : RegistryMachine.getElectricMachines().entrySet())
			list.add(addNBT(o.getKey()));
		list.add(new ItemStack(item, 1, 0));
	}

	public ItemStack addNBT(String name) {
		ItemStack itemStack = new ItemStack(this, 1, 0);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setString("ElectricMachine", name);
		itemStack.setTagCompound(nbt);
		return itemStack;
	}

	@Override
	public int getLightValue(IBlockAccess world, int x, int y, int z) {
		Block block = world.getBlock(x, y, z);
		int metadata = world.getBlockMetadata(x, y, z);
		if (block == this) {
			return metadata;
		}
		return super.getLightValue(world, x, y, z);
	}

}
