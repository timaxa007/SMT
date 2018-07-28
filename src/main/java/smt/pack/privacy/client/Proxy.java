package smt.pack.privacy.client;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
//import smt.pack.privacy.client.render.ListRender;
import smt.pack.privacy.client.gui.*;
import smt.pack.privacy.inventory.*;

public class Proxy extends smt.pack.privacy.Proxy {

	@Override
	public void preInit() {
		smt.pack.privacy.client.event.EventsClient.init();
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

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return super.getServerGuiElement(ID, player, world, x, y, z);
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tile = world.getTileEntity(x, y, z);
		switch(ID) {
		case GuiID.LOCKPICKING:
			return new LockpickingGuiContainer(tile, player);
		case GuiID.INVENTORY:
			return new InventoryDataGuiContainer(player);
		case GuiID.INVENTORY_BACKUP:
			return new InventoryBackupGuiContainer(player.inventory, new InventoryBackup(player));
		default:return super.getClientGuiElement(ID, player, world, x, y, z);
		}
	}

}
