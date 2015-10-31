package timaxa007.module.dfb;

import java.util.ArrayList;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraft.world.WorldSavedData;
import net.minecraftforge.common.util.Constants;

public class DurabilityBlock extends WorldSavedData {
	//-----------------------------------------------------------------------------------------------
	private static final String TAG = "DurabilityBlock";
	public static int max_used;
	private World world_p;

	private ArrayList<DurabilityBlockHelper.UsedForBlock> regDurabilityBlock = new ArrayList<DurabilityBlockHelper.UsedForBlock>();
	//-----------------------------------------------------------------------------------------------
	public DurabilityBlock() {
		super(TAG);
	}

	public DurabilityBlock(String tag) {
		super(tag);
	}
	//-----------------------------------------------------------------------------------------------
	public static void check(World world) {
		WorldSavedData data = world.perWorldStorage.loadData(DurabilityBlock.class, TAG);
		if (data == null) data = new DurabilityBlock(TAG);
		world.perWorldStorage.setData(TAG, data);
		data.markDirty();
	}

	public static DurabilityBlock get(World world) {
		return (DurabilityBlock)world.perWorldStorage.loadData(DurabilityBlock.class, TAG);
	}
	//-----------------------------------------------------------------------------------------------
	public void setWorld(World world) {
		world_p = world;
	}

	public ArrayList<DurabilityBlockHelper.UsedForBlock> getList() {
		return regDurabilityBlock;
	}
	//-----------------------------------------------------------------------------------------------
	public void addDurabilityBlock(int x, int y, int z, int count_used) {
		DurabilityBlockHelper.UsedForBlock ufb = new DurabilityBlockHelper.UsedForBlock(x, y, z, count_used);
		addDurabilityBlock(ufb);
	}

	public void addDurabilityBlock(DurabilityBlockHelper.UsedForBlock ufb) {
		if (regDurabilityBlock != null) regDurabilityBlock.add(ufb);
		else System.out.println("[Error] Adding - DurabilityBlockHelper.UsedForBlock: x = " + ufb.x + ", y = " + ufb.y + ", z = " + ufb.z + ".");
	}

	public void addDurabilityBlock_check(DurabilityBlockHelper.UsedForBlock ufb) {
		boolean flag = false;
		if (regDurabilityBlock != null) {
			for (DurabilityBlockHelper.UsedForBlock ufbp : regDurabilityBlock) {
				if (ufbp.x == ufb.x && ufbp.y == ufb.y && ufbp.z == ufb.z)
					flag = true;
			}
		}
		if (!flag) regDurabilityBlock.add(ufb);
		if (flag) System.out.println("[Error] Adding - DurabilityBlockHelper.UsedForBlock: x = " + ufb.x + ", y = " + ufb.y + ", z = " + ufb.z + ".");
	}
	//-----------------------------------------------------------------------------------------------
	public void removeDurabilityBlock(int x, int y, int z) {
		boolean flag = false;
		if (regDurabilityBlock != null && regDurabilityBlock.size() > 0) {
			for (int i = 0; i < regDurabilityBlock.size(); ++i) {
				DurabilityBlockHelper.UsedForBlock ufb = regDurabilityBlock.get(i);
				if (ufb != null && ufb.x == x && ufb.y == y && ufb.z == z) {
					regDurabilityBlock.remove(ufb);
					flag = true;
				}
			}
		}
		if (!flag) System.out.println("[Error] Not Remove - DurabilityBlockHelper.UsedForBlock: x = " + x + ", y = " + y + ", z = " + z + ".");
	}

	public void removeDurabilityBlock(DurabilityBlockHelper.UsedForBlock ufb) {
		if (regDurabilityBlock != null) regDurabilityBlock.remove(ufb);
		else System.out.println("[Error] Not Remove - DurabilityBlockHelper.UsedForBlock: x = " + ufb.x + ", y = " + ufb.y + ", z = " + ufb.z + ".");
	}
	//-----------------------------------------------------------------------------------------------
	public DurabilityBlockHelper.UsedForBlock getDurabilityBlock(int x, int y, int z) {
		if (regDurabilityBlock != null && regDurabilityBlock.size() > 0) {
			for (DurabilityBlockHelper.UsedForBlock ufb : regDurabilityBlock) {
				if (ufb.x == x && ufb.y == y && ufb.z == z) return ufb;
			}
		}
		return null;
	}

	public boolean isDurabilityBlock(int x, int y, int z) {
		if (regDurabilityBlock != null && regDurabilityBlock.size() > 0) {
			for (DurabilityBlockHelper.UsedForBlock ufb : regDurabilityBlock) {
				if (ufb.x == x && ufb.y == y && ufb.z == z) return true;
			}
		}
		return false;
	}

	public void use(int x, int y, int z) {
		if (regDurabilityBlock != null && regDurabilityBlock.size() > 0) {
			for (DurabilityBlockHelper.UsedForBlock ufb : regDurabilityBlock) {
				if (ufb.x == x && ufb.y == y && ufb.z == z) {
					--ufb.durability;
				}
			}
		}
	}
	//-----------------------------------------------------------------------------------------------
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		/* System.out.println("readFromNBT " + (
		 FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER ? "Side Server" : 
		 FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT ? "Side Client" : 
		 "Side Error"));*/
		regDurabilityBlock.clear();

		NBTTagList nbttaglist = nbt.getTagList(TAG, Constants.NBT.TAG_COMPOUND);
		if (nbttaglist != null) {
			for (int i = 0; i < nbttaglist.tagCount(); ++i) {
				NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
				int x = nbttagcompound1.getInteger("CordX");
				int y = nbttagcompound1.getInteger("CordY");
				int z = nbttagcompound1.getInteger("CordZ");
				int count_used = (int)nbttagcompound1.getShort("CountUsed");
				DurabilityBlockHelper.UsedForBlock ufb = new DurabilityBlockHelper.UsedForBlock(x, y, z, count_used);
				addDurabilityBlock_check(ufb);
				//System.out.println(ufb.toString());
			}
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		/*System.out.println("writeToNBT " + (
		 FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER ? "Side Server" : 
		 FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT ? "Side Client" : 
		 "Side Error"));*/
		if (regDurabilityBlock != null && regDurabilityBlock.size() > 0) {
			NBTTagList nbttaglist = new NBTTagList();
			for (int i = 0; i < regDurabilityBlock.size(); ++i) {
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setInteger("CordX", regDurabilityBlock.get(i).x);
				nbttagcompound1.setInteger("CordY", regDurabilityBlock.get(i).y);
				nbttagcompound1.setInteger("CordZ", regDurabilityBlock.get(i).z);
				nbttagcompound1.setShort("CountUsed", (short)regDurabilityBlock.get(i).durability);
				//--------------------------------------------------------------
				nbttaglist.appendTag(nbttagcompound1);
			}
			nbt.setTag(TAG, nbttaglist);
		}
	}
	//-----------------------------------------------------------------------------------------------
}
