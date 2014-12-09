package mods.timaxa007.Pack.Furniture.TE;

import mods.timaxa007.Pack.Furniture.GrillsRecipes;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TEBoxParticles extends TileEntity {

private int types;
private int rot;

public TEBoxParticles() {

}

public int getTypes() {return this.types;}
public int getRot() {return this.rot;}

public void setTypes(int i) {this.types=i;}
public void setRot(int i) {this.rot=i;}

public void readFromNBT(NBTTagCompound nbt) {
super.readFromNBT(nbt);
if(nbt.hasKey("Type")) {this.types=nbt.getInteger("Type");}
if(nbt.hasKey("Rot")) {this.rot=nbt.getInteger("Rot");}
}

public void writeToNBT(NBTTagCompound nbt) {
super.writeToNBT(nbt);
nbt.setInteger("Type", types);
nbt.setInteger("Rot", rot);
}

public Packet getDescriptionPacket() {
NBTTagCompound nbt=new NBTTagCompound();
writeToNBT(nbt);
return new Packet132TileEntityData(xCoord, yCoord, zCoord, 0, nbt);
}

public void onDataPacket(INetworkManager net, Packet132TileEntityData Packet) {
readFromNBT(Packet.data);
}

}
