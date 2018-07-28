package smt.pack.technology.client;

import static smt.pack.technology.inventory.GuiID.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import smt.pack.technology.client.render.ListRender;
import smt.pack.technology.client.gui.*;
import smt.pack.technology.tile.*;

public class Proxy extends smt.pack.technology.Proxy {

	@Override
	public void preInit() {
		smt.pack.technology.client.event.EventsClient.init();
		ListRender.preInit();
	}

	@Override
	public void init() {
		ListRender.init();
	}

	@Override
	public void postInit() {
		ListRender.postInit();
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		net.minecraft.tileentity.TileEntity tile = world.getTileEntity(x, y, z);
		switch(ID) {
		case BLOCK_ACCUMULATOR:return new ElectricBoxAccumulatorGuiContainer(player.inventory, (TileEntityElectricBoxAccumulator)tile);
		case ELECTRIC_MACHINE:return new ElectricMachineGui(player, (TileEntityElectricMachine)tile);
		default:return super.getClientGuiElement(ID, player, world, x, y, z);
		}
	}

}
