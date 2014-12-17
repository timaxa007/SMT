package mods.timaxa007.pack.furniture.tile;

import mods.timaxa007.lib.tile.IDataUser;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityArmChair extends TileEntity implements IDataUser {

    private String type;
    private int sizes;
    private int rotation;

    public String getType() {
        return this.type;
    }

    public int getSize() {
        return this.sizes;
    }
    public int getRotation() {
        return this.rotation;
    }

    public void setType(String i) {
        this.type = i;
    }

    public void setSize(int i) {
        this.sizes = i;
    }

    public void setRotation(int i) {
        this.rotation = i;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        if(nbt.hasKey("Type")) this.type=nbt.getString("Type");
        if(nbt.hasKey("Size")) this.sizes=nbt.getInteger("Size");
        if(nbt.hasKey("Rotation")) this.rotation=nbt.getInteger("Rotation");
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        nbt.setString("Type", type);
        nbt.setInteger("Size", sizes);
        nbt.setInteger("Rotation", rotation);
    }
}
