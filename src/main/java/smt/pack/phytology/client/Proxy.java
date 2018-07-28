package smt.pack.phytology.client;

//import smt.pack.phytology.client.render.ListRender;

public class Proxy extends smt.pack.phytology.Proxy {

	@Override
	public void preInit() {
		smt.pack.phytology.client.event.EventsClient.init();
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
