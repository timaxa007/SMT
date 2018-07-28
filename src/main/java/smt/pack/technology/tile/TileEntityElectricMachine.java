package smt.pack.technology.tile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.Constants.NBT;
import smt.pack.common.api.object.CustomNameDummy;
import smt.pack.technology.api.object.ElectricDummy;
import smt.pack.technology.registry.RegistryMachine;
import smt.pack.technology.tile.machine.ElectricAccumulator;
import smt.pack.technology.tile.machine.ElectricMachine;
import smt.pack.technology.world.SourceEnergy;

public class TileEntityElectricMachine extends TileEntity {

	IInventory inventoryOutput = new InventoryBasic("inventory_output", false, 9);
	//ArrayList<ItemStack> buffer_item = new ArrayList<ItemStack>();
	ElectricMachine machine;
	ElectricDummy energy;
	SourceEnergy source_energy;
	public final CustomNameDummy name = new CustomNameDummy("name");

	public TileEntityElectricMachine() {
		energy = new ElectricDummy(512, 1024, 16);
	}

	@Override
	public void updateEntity() {
		if (machine != null) machine.update();
		if (inventoryOutput == null && worldObj.getTileEntity(xCoord, yCoord - 1, zCoord) instanceof IInventory)
			inventoryOutput = (IInventory)worldObj.getTileEntity(xCoord, yCoord - 1, zCoord);
		else
			inventoryOutput = null;

		if (source_energy != null) {
			TileEntity es = worldObj.getTileEntity(source_energy.x, source_energy.y, source_energy.z);
			if (es instanceof TileEntityElectricMachine) {
				TileEntityElectricMachine bat = (TileEntityElectricMachine)es;
				if (energy.isAddEnergy(1)) {
					System.out.println("source_energy");
					//bat.addEnergy(-1);
					energy.addEnergy(1);
				}
			}
		}

	}

	public void setElectricMachine(String name) {
		machine = RegistryMachine.getElectricMachineObject(RegistryMachine.getElectricMachineClass(name), this);
	}

	public ElectricMachine getElectricMachine() {
		return machine;
	}

	public boolean setInventoryOutput(IInventory inventory) {
		inventoryOutput = inventory;
		return true;
	}

	public IInventory getInventoryOutput() {
		return inventoryOutput;
	}

	public ItemStack addInventoryOutput(ItemStack itemStack) {
		if (inventoryOutput == null) return itemStack;
		for (int i = 0; i < inventoryOutput.getSizeInventory(); ++i) {
			ItemStack slot = inventoryOutput.getStackInSlot(i);
			if (slot == null) {
				inventoryOutput.setInventorySlotContents(i, itemStack);
				return null;
			} else if (slot.isItemEqual(itemStack) && ItemStack.areItemStackTagsEqual(slot, itemStack) && slot.stackSize < slot.getMaxStackSize()) {
				if (slot.getMaxStackSize() < slot.stackSize + itemStack.stackSize) {
					itemStack.stackSize = slot.stackSize + itemStack.stackSize - slot.getMaxStackSize();
					slot.stackSize = slot.getMaxStackSize();
				} else {
					slot.stackSize = slot.stackSize + itemStack.stackSize;
					return null;
				}
			}

		}
		return itemStack;
	}

	public ElectricDummy getEnergy() {
		return energy;
	}

	public void setSourceEnergy(SourceEnergy source_energy) {
		this.source_energy = source_energy;
	}

	public boolean isUseableByPlayer(EntityPlayer player) {
		return worldObj.getTileEntity(xCoord, yCoord, zCoord) != this ? false : player.getDistanceSq((double)xCoord + 0.5D, (double)yCoord + 0.5D, (double)zCoord + 0.5D) <= 64.0D;
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		if (nbt.hasKey("ElectricMachine", NBT.TAG_STRING)) {
			machine = RegistryMachine.getElectricMachineObject(RegistryMachine.getElectricMachineClass(nbt.getString("ElectricMachine")), this);
			//machine.tile = this;
			machine.readFromNBT(nbt);
			System.out.println("readFromNBT - " + machine + ".");
		}
		energy.readFromNBT(nbt);
		if (nbt.hasKey("esX", NBT.TAG_INT) && nbt.hasKey("esY", NBT.TAG_INT) && nbt.hasKey("esZ", NBT.TAG_INT))
			setSourceEnergy(new SourceEnergy(nbt.getInteger("esX"), nbt.getInteger("esY"), nbt.getInteger("esZ")));
		name.readFromNBT(nbt);
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		if (machine != null) {
			String name = RegistryMachine.getElectricMachineName(machine.getClass());
			if (name != null) {
				nbt.setString("ElectricMachine", name);
				System.out.println("writeToNBT - " + name + ".");
			} else throw new RuntimeException("Not found id.");
			machine.writeToNBT(nbt);
		}
		energy.writeToNBT(nbt);
		if (source_energy != null) {
			nbt.setInteger("esX", source_energy.x);
			nbt.setInteger("esY", source_energy.y);
			nbt.setInteger("esZ", source_energy.z);
		}
		name.writeToNBT(nbt);
	}
	/*
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
	 */

}
