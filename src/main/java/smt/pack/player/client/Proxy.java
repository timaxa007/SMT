package smt.pack.player.client;

//import smt.pack.player.client.render.ListRender;

public class Proxy extends smt.pack.player.Proxy {

	@Override
	public void preInit() {
		smt.pack.player.client.event.EventsClient.init();
		//ListRender.preInit();
	}

	@Override
	public void init() {
		//ListRender.init();
	}

	@Override
	public void postInit() {
		//ListRender.postInit();
	}

}
