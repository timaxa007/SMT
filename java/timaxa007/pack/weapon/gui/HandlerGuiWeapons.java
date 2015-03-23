package timaxa007.pack.weapon.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class HandlerGuiWeapons implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(x, y, z);
		switch(id) {
		//case 2:return new ContainerScope1(player);
		//case 1:return new ContainerModifyWeapons(player, (TileEntityElectricMachines)te);
		case 19:return new ContainerModifyWeapons(player);
		default:return null;
		}
	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(x, y, z);
		switch(id) {
		case 2:return new GuiScope1(player);
		//case 1:return new GuiModifyWeapons(player, (TileEntityElectricMachines)te);
		case 19:return new GuiModifyWeapons(player);
		default:return null;
		}
	}

}
