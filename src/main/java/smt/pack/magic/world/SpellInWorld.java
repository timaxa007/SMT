package smt.pack.magic.world;

import java.util.ArrayList;

import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import net.minecraft.world.WorldSavedData;
import net.minecraftforge.common.util.Constants.NBT;

public class SpellInWorld extends WorldSavedData {

	public static final String TAG = "SpellInWorld";
	private final ArrayList<ObjectSpell> list = new ArrayList<ObjectSpell>();

	public SpellInWorld(String tag) {
		super(tag);
	}

	public boolean add(Block block, int time, ChunkCoordinates[] massiv) {
		return list.add(new ObjectSpell(block, time, massiv));
	}

	public void update(World world) {
		if (!list.isEmpty())
			for (int i = 0; i < list.size(); ++i) {
				ObjectSpell os = list.get(i);
				--os.time;
				if (os.time <= 0) {
					for (int j = 0; j < os.massiv.length; ++j) {
						ChunkCoordinates cc = os.massiv[j];
						world.setBlockToAir(cc.posX, cc.posY, cc.posZ);
					}

					System.out.println("remove + " + i + " - " + world.provider.dimensionId);
					list.remove(i);
					--i;
				}
			}
	}

	public static SpellInWorld get(World world) {
		if (world.mapStorage == null) return null;

		SpellInWorld data = (SpellInWorld)world.mapStorage.loadData(SpellInWorld.class, TAG);

		if (data == null) {
			data = new SpellInWorld(TAG);
			data.markDirty();
			world.mapStorage.setData(TAG, data);
		}
		return data;
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		System.out.println("readFromNBT");
		NBTTagCompound nbt_compound = nbt.getCompoundTag(TAG);
		NBTTagList nbttaglist = nbt_compound.getTagList("List", NBT.TAG_COMPOUND);
		for (int i = 0; i < nbttaglist.tagCount(); ++i) {
			NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
			String name = nbttagcompound1.getString("Name");
			String[] stgs = name.split(";");

			int time = nbttagcompound1.getInteger("Time");

			ArrayList<ChunkCoordinates> lcc = new ArrayList<ChunkCoordinates>();
			NBTTagList nbttaglist1 = nbttagcompound1.getTagList("CCM", NBT.TAG_COMPOUND);
			for (int j = 0; j < nbttaglist1.tagCount(); ++j) {
				NBTTagCompound nbttagcompound2 = nbttaglist1.getCompoundTagAt(j);
				int[] cc = nbttagcompound2.getIntArray("CC");
				lcc.add(new ChunkCoordinates(cc[0], cc[1], cc[2]));
			}
			this.list.add(new ObjectSpell(
					(stgs.length > 1 ? GameRegistry.findBlock(stgs[0], stgs[1]) : GameRegistry.findBlock("minecraft", stgs[0]))
					, time, lcc.toArray(new ChunkCoordinates[]{})));
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		System.out.println("writeToNBT");
		NBTTagCompound nbt_compound = new NBTTagCompound();
		NBTTagList list = new NBTTagList();
		for (ObjectSpell os : this.list) {
			NBTTagCompound nbttagcompound = new NBTTagCompound();
			String name = GameData.getBlockRegistry().getNameForObject(os.block);
			System.out.println(name);
			nbttagcompound.setString("Name", name);
			nbttagcompound.setInteger("Time", os.time);

			NBTTagList list2 = new NBTTagList();
			for (ChunkCoordinates cc : os.massiv) {
				NBTTagCompound nbttagcompound2 = new NBTTagCompound();
				nbttagcompound2.setIntArray("CC", new int[]{cc.posX, cc.posY, cc.posZ});
				list2.appendTag(nbttagcompound2);
			}
			nbttagcompound.setTag("CCM", list2);
			list.appendTag(nbttagcompound);
		}
		nbt_compound.setTag("List", list);
		nbt.setTag(TAG, nbt_compound);
	}

	public static final class ObjectSpell {

		final Block block;
		int time;
		final ChunkCoordinates[] massiv;

		public ObjectSpell(final Block block, int time, final ChunkCoordinates[] massiv) {
			this.block = block;
			this.time = time;
			this.massiv = massiv;
		}

	}

}
