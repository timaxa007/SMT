package timaxa007.module.dfb;

import java.util.ArrayList;

public class DurabilityBlockHelper {
	//-----------------------------------------------------------------------------------------------
	private static ArrayList<DurabilityForBlock> listDurabilityBlock = new ArrayList<DurabilityForBlock>();
	//-----------------------------------------------------------------------------------------------
	public static class UsedForBlock {

		public int x;
		public int y;
		public int z;
		public int durability;

		public UsedForBlock(int x, int y, int z, int durability) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.durability = durability;
		}

		public String toString() {
			String str = "UsedForBlock: x = " + x + ", y = " + y + ", z = " + z + "";
			str += "durability:" + durability;
			return str + ".";
		}

	}
	//-----------------------------------------------------------------------------------------------
	public static ArrayList<DurabilityForBlock> getList() {
		return listDurabilityBlock;
	}

	public static void add(String config) {
		if (config.equals("modid:block:16")) return;
		String[] str = config.split(":");
		add(str[0], str[1], Integer.parseInt(str[2]));
	}

	public static void add(String modid, String block, int durability) {
		if (modid.equals("modid") && modid.equals("block") && modid.equals("16")) return;
		DurabilityForBlock dfb = new DurabilityForBlock(modid, block, durability);
		System.out.println(dfb);
		listDurabilityBlock.add(dfb);
	}

	public static void addCheck(String modid, String block, int durability) {
		boolean flag = false;
		DurabilityForBlock dfb = new DurabilityForBlock(modid, block, durability);
		if (listDurabilityBlock != null && listDurabilityBlock.size() > 0)
			for (int i = 0; i > listDurabilityBlock.size(); ++i) {
				DurabilityForBlock temp = listDurabilityBlock.get(i);
				if (dfb.modid == temp.modid && dfb.block == temp.block && dfb.durability == temp.durability) flag = true;
			}
		if (!flag) listDurabilityBlock.add(dfb); else System.err.println("[ERROR] addCheck: " + dfb.toString());
	}
	//-----------------------------------------------------------------------------------------------
	public static class DurabilityForBlock {

		public String modid;
		public String block;
		public int durability;

		public DurabilityForBlock(String modid, String block, int durability) {
			this.modid = modid;
			this.block = block;
			this.durability = durability;
		}

		public net.minecraft.block.Block getBlock() {
			return cpw.mods.fml.common.registry.GameRegistry.findBlock(modid, block);
		}

		public String toString() {
			return "DurabilityForBlock: " + modid + ":" + block + ", durability = " + durability + ".";
		}

	}
	//-----------------------------------------------------------------------------------------------

}
