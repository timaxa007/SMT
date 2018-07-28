package smt.pack.common.client;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import smt.pack.common.client.gui.*;
import smt.pack.common.client.render.ListRender;
import smt.pack.common.inventory.*;

public class Proxy extends smt.pack.common.Proxy {

	@Override
	public void preInit() {
		smt.pack.common.client.event.EventsClient.init();
		ListRender.preInit();
		RegKey.preInit();
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
		TileEntity tile = world.getTileEntity(x, y, z);
		switch(ID) {
		//case GuiID.BLOCKS_common:return new BlockscommonGuiContainer(player.inventory, (TileEntityBlockscommon)tile);
		case GuiID.BACKPACK:return new GuiItemStorage(player, new InventoryItemStorage(player.getCurrentEquippedItem()));
		default:return super.getClientGuiElement(ID, player, world, x, y, z);
		}
	}

}
