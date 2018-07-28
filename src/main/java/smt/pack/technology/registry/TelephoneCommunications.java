package smt.pack.technology.registry;

import java.io.File;

import javax.annotation.Nonnull;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import smt.pack.common.util.FileNBT;
import smt.pack.technology.api.IEntityEIM;
import smt.pack.technology.api.IItemEIM;

public class TelephoneCommunications extends FileNBT {

	@Nonnull public static final TelephoneCommunications INSTANCE = new TelephoneCommunications();
	private static final String TAG = "TelephoneCommunications";
	private boolean isCall;
	private EntityPlayer caller;
	private int
	findID,
	cooldownCalling;

	public TelephoneCommunications() {
		super(getDir(), TAG);
	}

	public void load() {
		System.out.println("\"" + TAG + "\" Loading.");
		loadData();
		System.out.println("\"" + TAG + "\" Loaded.");
	}

	public void save() {
		System.out.println("\"" + TAG + "\" Saving.");
		saveData();
		System.out.println("\"" + TAG + "\" Saved.");
	}

	public void reload() {
		System.out.println("\"" + TAG + "\" Reloading.");
		saveData();
		loadData();
		System.out.println("\"" + TAG + "\" Reloaded.");
	}

	public void update(World world) {
		boolean isFind = false;
		if (isCall && !isFind) {
			for (int i = 0; i < world.loadedEntityList.size(); ++i) {
				Entity entity = (Entity)world.loadedEntityList.get(i);
				if (entity instanceof EntityPlayer) {
					EntityPlayer player = (EntityPlayer)entity;
					for (ItemStack item : player.inventory.mainInventory) {
						if (item != null && item.getItem() instanceof IItemEIM) {
							if (((IItemEIM)item.getItem()).hasEIM(item)) {
								isFind = ((IItemEIM)item.getItem()).callEIM(item, findID);
								if (isFind) break;
							}
						} else continue;
					}
				}
				else if (entity instanceof EntityItem) {
					EntityItem ei = (EntityItem)entity;
					ItemStack item = ei.getEntityItem();
					if (item != null && item.getItem() instanceof IItemEIM) {
						if (((IItemEIM)item.getItem()).hasEIM(item)) {
							isFind = ((IItemEIM)item.getItem()).callEIM(item, findID);
						}
					}
				}
				else if (entity instanceof IEntityEIM) {
					if (((IEntityEIM)entity).hasEIM()) {
						isFind = ((IEntityEIM)entity).callEIM(findID);
					}
				}
				if (isFind) break;
			}
			if (isCall && isFind) {
				++cooldownCalling;
				if (cooldownCalling > 600) drop();
				System.out.println(findID);
			}
		}
	}

	public void call(EntityPlayer caller, int id) {
		this.caller = caller;
		isCall = true;
		findID = id;
		cooldownCalling = 0;
	}

	public void accept() {
		isCall = false;
		cooldownCalling = 0;
	}

	public void drop() {
		caller = null;
		isCall = false;
		findID = -1;
		cooldownCalling = 0;
	}
	/*
	public static TelephoneCommunications get(World world) {
		if (world.mapStorage == null) return null;

		TelephoneCommunications data = (TelephoneCommunications)world.mapStorage.loadData(TelephoneCommunications.class, TAG);

		if (data == null) {
			data = new TelephoneCommunications(TAG);
			world.mapStorage.setData(TAG, data);
		}
		return data;
	}
	 */
	@Override
	public void readFromNBT(NBTTagCompound nbt) {

	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {

	}

	public static File getDir() {
		return new File(MinecraftServer.getServer().worldServers[0].getSaveHandler().getWorldDirectory(), "telephone");
	}

	/**EIM - Entity Identification Module**/
	public static class EIM {

		Entity owner;
		int id;

		public EIM(Entity owner, int id) {
			this.owner = owner;
			this.id = id;
		}

		public Entity getOwner() {
			return owner;
		}

		public int getID() {
			return id;
		}

	}

}
