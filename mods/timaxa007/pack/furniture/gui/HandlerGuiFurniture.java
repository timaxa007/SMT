package mods.timaxa007.pack.furniture.gui;

import mods.timaxa007.pack.furniture.te.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class HandlerGuiFurniture implements IGuiHandler{

@Override
public Object getServerGuiElement(int id, EntityPlayer player, World wrd, int x, int y, int z) {
TileEntity te=wrd.getBlockTileEntity(x, y, z);
switch(id) {
case 1:return new ContainerFurnitureMachines(player, (TEFurnitureMachines)te);
case 16:return new ContainerBookshelf(player, (TEBookshelf)te);
case 17:return new ContainerMincer(player, (TEMincer)te);
case 18:return new ContainerGrills(player, (TEGrills)te);
case 19:return new ContainerMashineWater(player, (TEMashineWater)te);
case 20:return new ContainerBackpack(player);
default:return null;
}
}

@Override
public Object getClientGuiElement(int id, EntityPlayer player, World wrd, int x, int y, int z) {
TileEntity te=wrd.getBlockTileEntity(x, y, z);
switch(id) {
case 1:return new GuiFurnitureMachines(player, (TEFurnitureMachines)te);
case 16:return new GuiBookshelf(player, (TEBookshelf)te);
case 17:return new GuiMincer(player, (TEMincer)te);
case 18:return new GuiGrills(player, (TEGrills)te);
case 19:return new GuiMashineWater(player, (TEMashineWater)te);
case 20:return new GuiBackpack(player);
default:return null;
}
}

}
