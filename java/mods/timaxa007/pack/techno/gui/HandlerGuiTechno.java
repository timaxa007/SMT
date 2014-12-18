package mods.timaxa007.pack.techno.gui;

import mods.timaxa007.pack.techno.te.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class HandlerGuiTechno implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(x, y, z);
		switch(id) {
		//case 1:return new ContainerElectricMachines(player, (TEElectricMachines)te);
		default:return null;
		}
	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(x, y, z);
		switch(id) {
		//case 1:return new GuiElectricMachines(player, (TEElectricMachines)te);
		default:return null;
		}
	}

}
