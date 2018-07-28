package smt.pack.vehicle.client;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
//import smt.pack.vehicle.client.event.ListEventClient;
import smt.pack.vehicle.client.render.ListRender;
import smt.pack.vehicle.tile.*;

public class Proxy extends smt.pack.vehicle.Proxy {

	@Override
	public void preInit() {
		//ListEventClient.preInit();
		ListRender.preInit();
	}

	@Override
	public void init() {
		//ListEventClient.init();
		ListRender.init();
	}

	@Override
	public void postInit() {
		//ListEventClient.postInit();
		ListRender.postInit();
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tile = world.getTileEntity(x, y, z);
		switch(ID) {
		default:return super.getClientGuiElement(ID, player, world, x, y, z);
		}
	}

}
