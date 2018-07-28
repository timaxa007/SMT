package smt.pack.technology.tile;

import java.util.Iterator;
import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import smt.pack.ActionInventory;

public class TileEntityTeleport extends TileEntity {

	private IInventory inventoryMain = new InventoryBasic("InventoryTeleport", false, 9);

	private AxisAlignedBB aabb_main = null;
	private int cooldown = 0;

	public TileEntityTeleport() {

	}

	@Override
	public void updateEntity() {

		if (cooldown > 0) --cooldown;

		if (cooldown <= 0) {

			if (aabb_main == null)
				aabb_main = AxisAlignedBB.getBoundingBox((double)xCoord, (double)yCoord + 1, (double)zCoord, (double)(xCoord + 1), (double)(yCoord + 2), (double)(zCoord + 1));

			if (aabb_main != null) {
				List list = worldObj.getEntitiesWithinAABB(Entity.class, aabb_main);
				Iterator iterator = list.iterator();
				Entity entity;

				while(iterator.hasNext()) {
					entity = (Entity)iterator.next();
					if (entity != null) {
						entity.setPosition((double)xCoord + 0.5D, (double)yCoord + 5, (double)zCoord + 0.5D);

						if (entity instanceof EntityItem) cooldown = 20;
						else if (entity instanceof EntityThrowable) cooldown = 35;
						else if (entity instanceof EntityLivingBase) cooldown = 60;
						else cooldown = 60;

						break;
					}
				}
			}

		}

	}

	public IInventory getInventory() {
		return inventoryMain;
	}

	public boolean isUseableByPlayer(EntityPlayer player) {
		return worldObj.getTileEntity(xCoord, yCoord, zCoord) != this ? false : player.getDistanceSq((double)xCoord + 0.5D, (double)yCoord + 0.5D, (double)zCoord + 0.5D) <= 64.0D;
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		inventoryMain = ActionInventory.readFromNBT(nbt, inventoryMain);

	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		ActionInventory.writeToNBT(nbt, inventoryMain);

	}

	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound nbt = new NBTTagCompound();
		writeToNBT(nbt);
		return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 0, nbt);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
		readFromNBT(packet.func_148857_g());
	}

}
