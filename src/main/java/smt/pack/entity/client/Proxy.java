package smt.pack.entity.client;

import cpw.mods.fml.client.registry.RenderingRegistry;
import smt.pack.entity.entity.EntityZombie;

public class Proxy extends smt.pack.entity.Proxy {

	@Override
	public void preInit() {
		
	}

	@Override
	public void init() {

		RenderingRegistry.registerEntityRenderingHandler(EntityZombie.class, new RenderEntityZombie());

	}

	@Override
	public void postInit() {
		
	}

}
