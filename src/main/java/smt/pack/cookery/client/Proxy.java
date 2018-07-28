package smt.pack.cookery.client;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import smt.pack.cookery.client.gui.GrillGuiContainer;
import smt.pack.cookery.inventory.GuiID;
import smt.pack.cookery.tile.TileEntityGrill;

public class Proxy extends smt.pack.cookery.Proxy {

	@Override
	public void preInit() {
		//ListEventClient.preInit();
		//ListRender.preInit();
	}

	@Override
	public void init() {
		//ListEventClient.init();
		//ListRender.init();
	}

	@Override
	public void postInit() {
		//ListEventClient.postInit();
		//ListRender.postInit();
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tile = world.getTileEntity(x, y, z);
		switch(ID) {
		case GuiID.GRILL:return new GrillGuiContainer(player.inventory, (TileEntityGrill)tile);
		default:return super.getClientGuiElement(ID, player, world, x, y, z);
		}
	}

}
