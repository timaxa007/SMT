package mods.timaxa007.Pack.Weapon.GUI;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class HandlerGuiWeapons implements IGuiHandler {

@Override
public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
TileEntity te = world.getBlockTileEntity(x, y, z);
switch(id) {
case 1:return new ContainerModifyWeapons(player);
//case 1:return new ContainerModifyWeapons(player, (TEElectricMachines)te);
default:return null;
}
}

@Override
public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
TileEntity te = world.getBlockTileEntity(x, y, z);
switch(id) {
case 1:return new GuiModifyWeapons(player);
//case 1:return new GuiModifyWeapons(player, (TEElectricMachines)te);
default:return null;
}
}

}
