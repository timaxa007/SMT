package smt.pack.decorative.client;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import smt.pack.decorative.client.render.ListRender;

public class Proxy extends smt.pack.decorative.Proxy {

	@Override
	public void preInit() {
		smt.pack.decorative.client.event.EventsClient.init();
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
		return super.getClientGuiElement(ID, player, world, x, y, z);
	}

}
