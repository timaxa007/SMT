package mods.timaxa007.pack.magic.gui;

import mods.timaxa007.pack.magic.tile.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class HandlerGuiMagic implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(x, y, z);
		switch(id) {
		//case 1:return new ContainerMagicMachines(player, (TileEntityMagicMachines)te);
		default:return null;
		}
	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(x, y, z);
		switch(id) {
		//case 1:return new GuiMagicMachines(player, (TileEntityMagicMachines)te);
		default:return null;
		}
	}

}
