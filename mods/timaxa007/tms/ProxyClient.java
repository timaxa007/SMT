package mods.timaxa007.tms;

import cpw.mods.fml.client.registry.KeyBindingRegistry;

public class ProxyClient extends ProxyServer {

@Override
public void regLoad() {
super.regLoad();
KeyBindingRegistry.registerKeyBinding(new KeyBindingHandler());

}

}
