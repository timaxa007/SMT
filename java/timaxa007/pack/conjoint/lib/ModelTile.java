package timaxa007.pack.conjoint.lib;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.world.World;
import net.minecraft.world.WorldSavedData;

public class ModelTile extends WorldSavedData {
	
	private static final String TAG = "ModelTile";

	public ModelTile(String name) {
		super(name);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		if (nbt.hasKey("create")) {
			if (nbt.getTag("create") instanceof NBTTagString)
			System.out.println(nbt.getString("create") + " - 01010");
		}
		nbt.removeTag("create");
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		//nbt.setString("create", "gg00-db91-ff00-ab89");
	}

	public static ModelTile get(World world) {
		if (world.mapStorage == null) return null;

		ModelTile data = (ModelTile)world.mapStorage.loadData(ModelTile.class, TAG);

		if (data == null) {
			data = new ModelTile(TAG);
			data.markDirty();
			world.mapStorage.setData(TAG, data);
		}
		return data;
	}

}
