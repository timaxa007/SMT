package smt.pack.technology.tile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraftforge.common.util.Constants.NBT;
import smt.pack.ActionInventory;
import smt.pack.common.api.ICustomName;
import smt.pack.technology.api.IElectricItem;
import smt.pack.technology.api.object.TileEntityElectricDummy;

public class TileEntityElectricBoxAccumulator extends TileEntityElectricDummy implements ICustomName {

	private IInventory inventoryMain = new InventoryBasic("ElectricBoxAccumulator", false, 2);
	public int temperature;
	private String customName;

	public TileEntityElectricBoxAccumulator() {
		setEnergy(500);
		setEnergyMax(1000);
		temperature = 100;
	}

	@Override
	public void updateEntity() {
		//System.out.println("CLIENT " + (FMLCommonHandler.instance().getSide() == Side.CLIENT));
		if (!worldObj.isRemote) {
			if (canWork()) {
				{
					ItemStack slot0 = inventoryMain.getStackInSlot(0);
					if (slot0 != null) {
						chargingItem(slot0);
					}
					//if (canWork(-1)) charge(slot0, 1);
				}
				{
					ItemStack slot1 = inventoryMain.getStackInSlot(1);
					if (slot1 != null) {
						dischargingItem(slot1);
					}
					//if (canWork(1)) charge(slot1, -1);
				}
			}
		}
	}

	public boolean chargingItem(ItemStack itemStack) {
		if (itemStack.getItem() instanceof IElectricItem) {
			IElectricItem ie = (IElectricItem)itemStack.getItem();
			if (ie.isCharging(itemStack)) {
				int charge = Math.min(ie.getRateMax(), getRateMax());
				//if (ie.getEnergyMax(is) >= ie.getEnergy(is) + charge) {
				//System.out.println("chargingItem");
				if (ie.isAddEnergy(itemStack, charge) && isAddEnergy(-charge)) {
					addEnergy(-(charge + ie.addEnergy(itemStack, charge)));
				}
				return true;
				//}
			}
		}
		return false;
	}

	//Yeah, I need the mind inside out.
	public boolean dischargingItem(ItemStack itemStack) {
		if (itemStack.getItem() instanceof IElectricItem) {
			IElectricItem ie = (IElectricItem)itemStack.getItem();
			if (ie.isDischarging(itemStack)) {
				int charge = Math.min(ie.getRateMax(), getRateMax());
				//if (0 <= ie.getEnergy(is) - charge) {
				//System.out.println("dischargingItem");
				if (ie.isAddEnergy(itemStack, -charge) && isAddEnergy(charge)) {
					ie.addEnergy(itemStack, -(charge - addEnergy(charge)));
				}
				//}
				return true;
			}
		}
		return false;
	}
	/*
	public boolean charge(ItemStack itemStack, int i) {
		if (i == 0) return false;
		if (itemStack != null && itemStack.getItem() instanceof IElectricItem) {
			IElectricItem ie = (IElectricItem)itemStack.getItem();
			boolean plus = ie.getEnergyMax(itemStack) >= ie.getEnergy(itemStack) + i;
			boolean minus = 0 <= ie.getEnergy(itemStack) + i;
			if (ie.isCharging(itemStack) && i >= 0 ? plus : minus) {
				ie.addEnergy(itemStack, i);
				addEnergy(-i);
				return true;
			}
		}
		return false;
	}
	 */
	public boolean canWork() {
		return canWork(0);
	}

	public boolean canWork(int i) {
		boolean plus = getEnergyMax() >= getEnergy() + i;
		boolean minus = 0 <= getEnergy() + i;
		return i == 0 ? (plus && minus) : i > 0 ? plus : minus;
	}

	@Override
	public int getRateMax() {
		return 100;
	}

	@Override
	public boolean isCharging() {
		return true;
	}

	@Override
	public boolean isDischarging() {
		return true;
	}

	public IInventory getInventory() {
		return inventoryMain;
	}

	@Override
	public boolean hasCustomName() {
		return customName != null && customName.length() > 0;
	}

	@Override
	public void setName(String name) {
		customName = name;
	}

	@Override
	public String getName() {
		return hasCustomName() ? customName : "container.smt.electric_block_accumulator";
	}

	public boolean isUseableByPlayer(EntityPlayer player) {
		return worldObj.getTileEntity(xCoord, yCoord, zCoord) != this ? false : player.getDistanceSq((double)xCoord + 0.5D, (double)yCoord + 0.5D, (double)zCoord + 0.5D) <= 64.0D;
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		inventoryMain = ActionInventory.readFromNBT(nbt, inventoryMain);

		if (nbt.hasKey("CustomName", NBT.TAG_STRING))
			customName = nbt.getString("CustomName");

	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		ActionInventory.writeToNBT(nbt, inventoryMain);

		if (hasCustomName())
			nbt.setString("CustomName", customName);

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
