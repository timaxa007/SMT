package mods.timaxa007.pack.furniture.gui;

import mods.timaxa007.pack.furniture.tile.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class HandlerGuiFurniture implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(x, y, z);
		switch(id) {
		//case 1:return new ContainerFurnitureMachines(player, (TileEntityFurnitureMachines)te);
		case 15:return new ContainerFurnitureChest(player, (TileEntityFurnitureChest)te);
		//case 16:return new ContainerBookshelf(player, (TileEntityBookshelf)te);
		//case 17:return new ContainerMincer(player, (TileEntityMincer)te);
		//case 18:return new ContainerGrills(player, (TileEntityGrills)te);
		//case 19:return new ContainerMashineWater(player, (TileEntityMashineWater)te);
		//case 20:return new ContainerBackpack(player);
		default:return null;
		}
	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(x, y, z);
		switch(id) {
		//case 1:return new GuiFurnitureMachines(player, (TileEntityFurnitureMachines)te);
		case 15:return new GuiFurnitureChest(player, (TileEntityFurnitureChest)te);
		//case 16:return new GuiBookshelf(player, (TileEntityBookshelf)te);
		//case 17:return new GuiMincer(player, (TileEntityMincer)te);
		//case 18:return new GuiGrills(player, (TileEntityGrills)te);
		//case 19:return new GuiMashineWater(player, (TileEntityMashineWater)te);
		//case 20:return new GuiBackpack(player);
		default:return null;
		}
	}

}
