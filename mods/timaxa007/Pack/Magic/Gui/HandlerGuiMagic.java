package mods.timaxa007.Pack.Magic.Gui;

import mods.timaxa007.Pack.Magic.TE.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class HandlerGuiMagic implements IGuiHandler{

@Override
public Object getServerGuiElement(int id, EntityPlayer player, World wrd, int x, int y, int z) {
TileEntity te=wrd.getBlockTileEntity(x, y, z);
switch(id) {
case 1:return new ContainerMagicMachines(player, (TEMagicMachines)te);
default:return null;
}
}

@Override
public Object getClientGuiElement(int id, EntityPlayer player, World wrd, int x, int y, int z) {
TileEntity te=wrd.getBlockTileEntity(x, y, z);
switch(id) {
case 1:return new GuiMagicMachines(player, (TEMagicMachines)te);
default:return null;
}
}

}
