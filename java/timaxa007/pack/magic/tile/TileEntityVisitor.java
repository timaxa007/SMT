package timaxa007.pack.magic.tile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityVisitor extends TileEntity {
	String visitor1 = "none";
	String visitor2 = "none";
	String visitor3 = "none";
	String visitor4 = "none";
	String visitor5 = "none";

	public void processActivate(EntityPlayer par5EntityPlayer, World world) {
		if (!visitor1.equals(par5EntityPlayer.getDisplayName())) {
			visitor5 = visitor4;
			visitor4 = visitor3;
			visitor3 = visitor2;
			visitor2 = visitor1;
			visitor1 = par5EntityPlayer.getDisplayName();
		}
		//par5EntityPlayer.addChatMessage("Visitors: "+visitor1+", "+visitor2+", "+visitor3+", "+visitor4+", "+visitor5);
		//world.notifyBlockChange(xCoord, yCoord, zCoord, 2);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		visitor1 = nbt.getString("visitor1");
		visitor2 = nbt.getString("visitor2");
		visitor3 = nbt.getString("visitor3");
		visitor4 = nbt.getString("visitor4");
		visitor5 = nbt.getString("visitor5");
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setString("visitor1", visitor1);
		nbt.setString("visitor2", visitor2);
		nbt.setString("visitor3", visitor3);
		nbt.setString("visitor4", visitor4);
		nbt.setString("visitor5", visitor5);
	}

}