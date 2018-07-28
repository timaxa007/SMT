package smt.pack.geology.client;

import smt.pack.geology.client.render.ListRender;

public class Proxy extends smt.pack.geology.Proxy {

	@Override
	public void preInit() {
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

}
