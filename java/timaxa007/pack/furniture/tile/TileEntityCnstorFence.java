package timaxa007.pack.furniture.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityCnstorFence extends TileEntity {

	private String style;
	private boolean stepN;
	private boolean stepS;
	private boolean stepW;
	private boolean stepE;

	public TileEntityCnstorFence() {
		style = "";
		stepN = false;
		stepS = false;
		stepW = false;
		stepE = false;
	}

	public void updateEntity() {

		if (worldObj.getTileEntity(xCoord, yCoord, zCoord-1) instanceof TileEntityCnstorFence) {
			stepN = true;
		} else {
			stepN = false;
		}

		if (worldObj.getTileEntity(xCoord, yCoord, zCoord+1) instanceof TileEntityCnstorFence) {
			stepS = true;
		} else {
			stepS = false;
		}

		if (worldObj.getTileEntity(xCoord+1, yCoord, zCoord) instanceof TileEntityCnstorFence) {
			stepW = true;
		} else {
			stepW = false;
		}

		if (worldObj.getTileEntity(xCoord-1, yCoord, zCoord) instanceof TileEntityCnstorFence) {
			stepE = true;
		} else {
			stepE = false;
		}

	}

	public String getStyle() {
		return style;
	}

	public boolean getStepN() {
		return stepN;
	}

	public boolean getStepS() {
		return stepS;
	}

	public boolean getStepW() {
		return stepW;
	}

	public boolean getStepE() {
		return stepE;
	}

	public void setStyle(String i) {
		style = i;
	}
	/*
	public void setStepN(boolean i) {
		stepN = i;
	}

	public void setStepS(boolean i) {
		stepS = i;
	}

	public void setStepW(boolean i) {
		stepW = i;
	}

	public void setStepE(boolean i) {
		stepE = i;
	}
	 */
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		if (nbt.hasKey("Style")) style = nbt.getString("Style");
		//if (nbt.hasKey("StepN")) stepN = nbt.getBoolean("StepN");
		//if (nbt.hasKey("StepS")) stepS = nbt.getBoolean("StepS");
		//if (nbt.hasKey("StepW")) stepW = nbt.getBoolean("StepW");
		//if (nbt.hasKey("StepE")) stepE = nbt.getBoolean("StepE");
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setString("Style", style);
		//nbt.setBoolean("StepN", stepN);
		//nbt.setBoolean("StepS", stepS);
		//nbt.setBoolean("StepW", stepW);
		//nbt.setBoolean("StepE", stepE);
	}

	public Packet getDescriptionPacket() {
		NBTTagCompound nbt = new NBTTagCompound();
		writeToNBT(nbt);
		return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 0, nbt);
	}

	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
		readFromNBT(packet.func_148857_g());
	}

}
