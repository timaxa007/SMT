package timaxa007.pack.item.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.minecraft.block.material.Material;
import timaxa007.pack.item.block.BlockData;
import timaxa007.smt.util.UtilString;

public class RegistryBlockData {

	private static HashMap<String, BlockData> block_data_map = new HashMap<String, BlockData>();
	private static ArrayList<String> block_data_list = new ArrayList<String>();

	public static final BlockData EMPTY = new BlockData("empty", Material.circuits);

	static {
		RegistryBlockData.registerBlockData(EMPTY);
	}

	public static void registerBlockData(BlockData[] block_datas) {
		for (BlockData block_data : block_datas) if (block_data != null) registerBlockData(block_data);
	}

	public static void registerBlockData(BlockData block_data) {
		registerBlockData(block_data, block_data.getSubTag());
	}

	public static void registerBlockData(BlockData block_data, String tag) {
		if (block_data != null && UtilString.hasString(tag)) {
			if (block_data_map.get(tag) == null) {
				block_data_map.put(tag, block_data);
				block_data_list.add(tag);
			} else throw new IllegalArgumentException("Duplicate " + block_data);
		} else throw new IllegalArgumentException("Error " + block_data);
	}

	public static List getListBlockData() {
		return block_data_list;
	}

	public static List getListBlockData(Material material) {
		ArrayList<String> list = new ArrayList<String>();

		for (int i = 0; i < block_data_list.size(); ++i) {
			if (block_data_list.get(i) != null) {
				BlockData block_data = RegistryBlockData.getBlockData(block_data_list.get(i).toString());
				if (RegistryBlockData.hasBlockData(block_data) && block_data.getMaterial() == material) {
					list.add(block_data_list.get(i).toString());
				}
			}
		}

		return list;
	}

	public static BlockData getBlockData(String tag) {
		return (block_data_map.get(tag) != null ? block_data_map.get(tag) : EMPTY);
	}

	public static boolean hasBlockData(BlockData block_data) {
		return !(block_data == null || block_data == EMPTY);
	}

	public static boolean hasBlockData(String tag) {
		return UtilString.hasString(tag) && hasBlockData(RegistryBlockData.getBlockData(tag));
	}
	//-------------------------------------------------------------------------------------------
}
