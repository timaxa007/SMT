package timaxa007.module.craft_table;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraft.world.WorldSavedData;
import net.minecraftforge.common.util.Constants;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CraftTable extends WorldSavedData {
	//-----------------------------------------------------------------------------------------------
	private static final String TAG = "CraftTable";
	private World world_p;

	private ArrayList<BlockCraftTable> regCraftTable = new ArrayList<BlockCraftTable>();
	@SideOnly(Side.CLIENT) private static BlockCraftTable current_bct;
	//-----------------------------------------------------------------------------------------------
	public CraftTable() {
		super(TAG);
	}

	public CraftTable(String tag) {
		super(tag);
	}
	//-----------------------------------------------------------------------------------------------
	public static void check(World world) {
		WorldSavedData data = world.perWorldStorage.loadData(CraftTable.class, TAG);
		if (data == null) data = new CraftTable(TAG);
		world.perWorldStorage.setData(TAG, data);
		data.markDirty();
	}

	public static CraftTable get(World world) {
		return (CraftTable)world.perWorldStorage.loadData(CraftTable.class, TAG);
	}
	//-----------------------------------------------------------------------------------------------
	public void setWorld(World world) {
		world_p = world;
	}

	public ArrayList<BlockCraftTable> getList() {
		return regCraftTable;
	}
	//-----------------------------------------------------------------------------------------------
	public void addCraftTable(int x, int y, int z) {
		addCraftTable(x, y, z, null);
	}

	public void addCraftTable(int x, int y, int z, ItemStack[] inv) {
		if (inv == null) inv = new ItemStack[9];
		BlockCraftTable bct = new BlockCraftTable(x, y, z, inv);
		addCraftTable(bct);
	}

	public void addCraftTable(BlockCraftTable bct) {
		if (regCraftTable != null) regCraftTable.add(bct);
		else System.out.println("[Error] Adding - BlockCraftTable: x = " + bct.x + ", y = " + bct.y + ", z = " + bct.z + ".");
	}

	public void addCraftTable_check(BlockCraftTable bct) {
		boolean flag = false;
		if (regCraftTable != null) {
			for (BlockCraftTable bctp : regCraftTable) {
				if (bctp.x == bct.x && bctp.y == bct.y && bctp.z == bct.z)
					flag = true;
			}
		}
		if (!flag) regCraftTable.add(bct);
		if (flag) System.out.println("[Error] Adding - BlockCraftTable: x = " + bct.x + ", y = " + bct.y + ", z = " + bct.z + ".");
	}
	//-----------------------------------------------------------------------------------------------
	public void removeCraftTable(int x, int y, int z) {
		boolean flag = false;
		if (regCraftTable != null && regCraftTable.size() > 0) {
			for (int i = 0; i < regCraftTable.size(); ++i) {
				BlockCraftTable bctp = regCraftTable.get(i);
				if (bctp != null && bctp.x == x && bctp.y == y && bctp.z == z) {
					regCraftTable.remove(bctp);
					flag = true;
				}
			}
		}
		if (!flag) System.out.println("[Error] Not Remove - BlockCraftTable: x = " + x + ", y = " + y + ", z = " + z + ".");
	}

	public void removeCraftTable(BlockCraftTable bct) {
		if (regCraftTable != null) regCraftTable.remove(bct);
		else System.out.println("[Error] Not Remove - BlockCraftTable: x = " + bct.x + ", y = " + bct.y + ", z = " + bct.z + ".");
	}
	//-----------------------------------------------------------------------------------------------
	public BlockCraftTable getCraftTable(int x, int y, int z) {
		if (regCraftTable != null && regCraftTable.size() > 0) {
			for (BlockCraftTable bctp : regCraftTable) {
				if (bctp.x == x && bctp.y == y && bctp.z == z) return bctp;
			}
		}
		return null;
	}
	//-----------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public static void setCraftTableClient(int x, int y, int z, ItemStack[] inv) {
		if (inv == null) inv = new ItemStack[9];
		current_bct = new BlockCraftTable(x, y, z, inv);
	}

	@SideOnly(Side.CLIENT)
	public static BlockCraftTable getCraftTableClient() {
		return current_bct;
	}
	//-----------------------------------------------------------------------------------------------
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		/* System.out.println("readFromNBT " + (
		 FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER ? "Side Server" : 
		 FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT ? "Side Client" : 
		 "Side Error"));*/
		regCraftTable.clear();

		NBTTagList nbttaglist = nbt.getTagList(TAG, Constants.NBT.TAG_COMPOUND);
		if (nbttaglist != null) {
			for (int i = 0; i < nbttaglist.tagCount(); ++i) {
				NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
				int x = nbttagcompound1.getInteger("CordX");
				int y = nbttagcompound1.getInteger("CordY");
				int z = nbttagcompound1.getInteger("CordZ");
				//--------------------------------------------------------------
				NBTTagList nbttaglist1 = nbttagcompound1.getTagList("Items", 10);
				ItemStack[] list_slot = new ItemStack[9];

				for (int i1 = 0; i1 < nbttaglist1.tagCount(); ++i1) {
					NBTTagCompound nbttagcompound2 = nbttaglist1.getCompoundTagAt(i1);
					int j = nbttagcompound2.getByte("Slot") & 255;

					if (j >= 0 && j < list_slot.length) {
						list_slot[j] = ItemStack.loadItemStackFromNBT(nbttagcompound2);
					}
				}
				//--------------------------------------------------------------
				BlockCraftTable bct = new BlockCraftTable(x, y, z, list_slot);
				addCraftTable_check(bct);
				System.out.println(bct.toString());
			}
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		/*System.out.println("writeToNBT " + (
		 FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER ? "Side Server" : 
		 FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT ? "Side Client" : 
		 "Side Error"));*/
		if (regCraftTable != null && regCraftTable.size() > 0) {
			NBTTagList nbttaglist = new NBTTagList();
			for (int i = 0; i < regCraftTable.size(); ++i) {
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setInteger("CordX", regCraftTable.get(i).x);
				nbttagcompound1.setInteger("CordY", regCraftTable.get(i).y);
				nbttagcompound1.setInteger("CordZ", regCraftTable.get(i).z);
				//--------------------------------------------------------------
				NBTTagList nbttaglist1 = new NBTTagList();
				ItemStack[] list_slot = regCraftTable.get(i).inv;

				for (int i1 = 0; i1 < list_slot.length; ++i1) {
					if (list_slot[i1] != null) {
						NBTTagCompound nbttagcompound2 = new NBTTagCompound();
						nbttagcompound2.setByte("Slot", (byte)i1);
						list_slot[i1].writeToNBT(nbttagcompound2);
						nbttaglist1.appendTag(nbttagcompound2);
					}
				}

				nbttagcompound1.setTag("Items", nbttaglist1);
				//--------------------------------------------------------------
				nbttaglist.appendTag(nbttagcompound1);
			}
			nbt.setTag(TAG, nbttaglist);
		}
	}
	//-----------------------------------------------------------------------------------------------
	public static class BlockCraftTable {

		public int x;
		public int y;
		public int z;
		public ItemStack[] inv;

		public BlockCraftTable(int x, int y, int z, ItemStack[] inv) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.inv = inv;
		}

		public String toString() {
			String str = "BlockCraftTable: x = " + x + ", y = " + y + ", z = " + z + "";
			if (inv != null) {
				str += ", ItemStack[] {";
				for (int i = 0; i < inv.length; ++i) {
					if (i != 0) str += ", ";
					if (inv[i] != null) str += inv[i].toString(); else str += "null";
				}
				str += "}";
			} else str += ", inv = null";
			return str + ".";
		}

	}
	//-----------------------------------------------------------------------------------------------
}
