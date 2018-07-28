package smt.pack.weapon.client;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import smt.pack.weapon.client.gui.*;
import smt.pack.weapon.inventory.GuiID;
import smt.pack.weapon.registry.WeaponSystemClient;
import smt.pack.weapon.tile.*;

public class Proxy extends smt.pack.weapon.Proxy {

	@Override
	public void preInit() {
		smt.pack.weapon.client.event.EventsClient.init();
		wpn_sys = new WeaponSystemClient();
	}

	@Override
	public void init() {

	}

	@Override
	public void postInit() {

	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		net.minecraft.tileentity.TileEntity tile = world.getTileEntity(x, y, z);
		switch(ID) {
		case GuiID.ASSEMBLY_TABLE:return new AssemblyTableGui(player, (TileEntityAssemblyTable)tile);
		default:return super.getClientGuiElement(ID, player, world, x, y, z);
		}
	}

}
