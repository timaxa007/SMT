package smt.pack.technology;

import static smt.pack.technology.inventory.GuiID.*;
import static smt.pack.technology.SMTTechnology.instance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import smt.pack.technology.inventory.*;
import smt.pack.technology.tile.*;

public class Proxy implements cpw.mods.fml.common.network.IGuiHandler {

	public void preInit() {

	}

	public void init() {

	}

	public void postInit() {

	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		net.minecraft.tileentity.TileEntity tile = world.getTileEntity(x, y, z);
		switch(ID) {
		case BLOCK_ACCUMULATOR:return new ElectricBoxAccumulatorContainer(player.inventory, (TileEntityElectricBoxAccumulator)tile);
		case ELECTRIC_MACHINE:return new ElectricMachineContainer(player, (TileEntityElectricMachine)tile);
		default:return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}

	public static void openGui(int ID, EntityPlayer player, int x, int y, int z) {
		player.openGui(instance, ID, player.worldObj, x, y, z);
	}

	public static void openGui(int ID, EntityPlayer player) {
		player.openGui(instance, ID, player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ);
	}

}
