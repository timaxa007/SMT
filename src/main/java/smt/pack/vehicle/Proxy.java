package smt.pack.vehicle;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class Proxy implements cpw.mods.fml.common.network.IGuiHandler {

	public void preInit() {

	}

	public void init() {

	}

	public void postInit() {

	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tile = world.getTileEntity(x, y, z);
		switch(ID) {
		default:return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}

	public static void openGui(int ID, EntityPlayer player, int x, int y, int z) {
		player.openGui(SMTVehicle.instance, ID, player.worldObj, x, y, z);
	}

	public static void openGui(int ID, EntityPlayer player) {
		player.openGui(SMTVehicle.instance, ID, player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ);
	}

}
