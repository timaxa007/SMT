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
		DurabilityBlockHelper.UsedForBlock bct = new DurabilityBlockHelper.UsedForBlock(x, y, z, count_used);
		addDurabilityBlock(bct);
	}

	public void addDurabilityBlock(DurabilityBlockHelper.UsedForBlock bct) {
		if (regDurabilityBlock != null) regDurabilityBlock.add(bct);
		else System.out.println("[Error] Adding - DurabilityBlockHelper.UsedForBlock: x = " + bct.x + ", y = " + bct.y + ", z = " + bct.z + ".");
	}

	public void addDurabilityBlock_check(DurabilityBlockHelper.UsedForBlock bct) {
		boolean flag = false;
		if (regDurabilityBlock != null) {
			for (DurabilityBlockHelper.UsedForBlock bctp : regDurabilityBlock) {
				if (bctp.x == bct.x && bctp.y == bct.y && bctp.z == bct.z)
					flag = true;
			}
		}
		if (!flag) regDurabilityBlock.add(bct);
		if (flag) System.out.println("[Error] Adding - DurabilityBlockHelper.UsedForBlock: x = " + bct.x + ", y = " + bct.y + ", z = " + bct.z + ".");
	}
	//-----------------------------------------------------------------------------------------------
	public void removeDurabilityBlock(int x, int y, int z) {
		boolean flag = false;
		if (regDurabilityBlock != null && regDurabilityBlock.size() > 0) {
			for (int i = 0; i < regDurabilityBlock.size(); ++i) {
				DurabilityBlockHelper.UsedForBlock bctp = regDurabilityBlock.get(i);
				if (bctp != null && bctp.x == x && bctp.y == y && bctp.z == z) {
					regDurabilityBlock.remove(bctp);
					flag = true;
				}
			}
		}
		if (!flag) System.out.println("[Error] Not Remove - DurabilityBlockHelper.UsedForBlock: x = " + x + ", y = " + y + ", z = " + z + ".");
	}

	public void removeDurabilityBlock(DurabilityBlockHelper.UsedForBlock bct) {
		if (regDurabilityBlock != null) regDurabilityBlock.remove(bct);
		else System.out.println("[Error] Not Remove - DurabilityBlockHelper.UsedForBlock: x = " + bct.x + ", y = " + bct.y + ", z = " + bct.z + ".");
	}
	//-----------------------------------------------------------------------------------------------
	public DurabilityBlockHelper.UsedForBlock getDurabilityBlock(int x, int y, int z) {
		if (regDurabilityBlock != null && regDurabilityBlock.size() > 0) {
			for (DurabilityBlockHelper.UsedForBlock bctp : regDurabilityBlock) {
				if (bctp.x == x && bctp.y == y && bctp.z == z) return bctp;
			}
		}
		return null;
	}

	public boolean isDurabilityBlock(int x, int y, int z) {
		if (regDurabilityBlock != null && regDurabilityBlock.size() > 0) {
			for (DurabilityBlockHelper.UsedForBlock bctp : regDurabilityBlock) {
				if (bctp.x == x && bctp.y == y && bctp.z == z) return true;
			}
		}
		return false;
	}

	public void use(int x, int y, int z) {
		if (regDurabilityBlock != null && regDurabilityBlock.size() > 0) {
			for (DurabilityBlockHelper.UsedForBlock bctp : regDurabilityBlock) {
				if (bctp.x == x && bctp.y == y && bctp.z == z) {
					--bctp.durability;
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
				DurabilityBlockHelper.UsedForBlock bct = new DurabilityBlockHelper.UsedForBlock(x, y, z, count_used);
				addDurabilityBlock_check(bct);
				//System.out.println(bct.toString());
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
