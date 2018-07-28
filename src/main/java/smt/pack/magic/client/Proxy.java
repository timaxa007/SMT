package smt.pack.magic.client;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import smt.pack.magic.client.gui.*;
import smt.pack.magic.client.render.ListRender;
import smt.pack.magic.inventory.GuiID;
import smt.pack.magic.tile.*;

public class Proxy extends smt.pack.magic.Proxy {

	@Override
	public void preInit() {
		smt.pack.magic.client.event.EventsClient.init();
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
		TileEntity tile = world.getTileEntity(x, y, z);
		switch(ID) {
		case GuiID.CHEST_EXP:return new ChestExpGui(player, (TileEntityChestExp)tile);
		case GuiID.DISENCHANTER:return new GuiDisenchanter(player, (TileEntityDisenchanter)tile);
		case GuiID.INFUSER:return new GuiInfuser(player, (TileEntityInfuser)tile);
		default:return super.getClientGuiElement(ID, player, world, x, y, z);
		}
	}

}
