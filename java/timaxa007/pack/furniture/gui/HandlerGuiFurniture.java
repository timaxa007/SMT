package timaxa007.pack.furniture.gui;

import timaxa007.pack.furniture.inventory.InventoryBackpack;
import timaxa007.pack.furniture.item.ItemBackpack;
import timaxa007.pack.furniture.tile.TileEntityFurnitureChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class HandlerGuiFurniture implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(x, y, z);
		ItemStack current = player.getCurrentEquippedItem();
		switch(id) {
		//case 1:return new ContainerFurnitureMachines(player, (TileEntityFurnitureMachines)te);
		case 15:return new ContainerFurnitureChest(player, (TileEntityFurnitureChest)te);
		//case 16:return new ContainerBookshelf(player, (TileEntityBookshelf)te);
		//case 17:return new ContainerMincer(player, (TileEntityMincer)te);
		//case 18:return new ContainerGrills(player, (TileEntityGrills)te);
		//case 19:return new ContainerMashineWater(player, (TileEntityMashineWater)te);
		case 20:return new ContainerBackpack(player, (ItemBackpack)current.getItem());
		case 32:return new ContainerBackpack(player, (ItemBackpack)current.getItem());
		case 33:return new ContainerBackpack(player, (ItemBackpack)current.getItem());
		case 34:return new ContainerBackpack(player, (ItemBackpack)current.getItem());
		case 35:return new ContainerBackpack(player, (ItemBackpack)current.getItem());
		case 36:return new ContainerBackpack(player, (ItemBackpack)current.getItem());
		case 37:return new ContainerBackpack(player, (ItemBackpack)current.getItem());
		case 38:return new ContainerBackpack(player, (ItemBackpack)current.getItem());
		case 39:return new ContainerBackpack(player, (ItemBackpack)current.getItem());
		case 40:return new ContainerBackpack(player, (ItemBackpack)current.getItem());
		case 41:return new ContainerBackpack(player, (ItemBackpack)current.getItem());
		case 42:return new ContainerBackpack(player, (ItemBackpack)current.getItem());
		case 43:return new ContainerBackpack(player, (ItemBackpack)current.getItem());
		case 44:return new ContainerBackpack(player, (ItemBackpack)current.getItem());
		case 45:return new ContainerBackpack(player, (ItemBackpack)current.getItem());
		case 46:return new ContainerBackpack(player, (ItemBackpack)current.getItem());
		case 47:return new ContainerBackpack(player, (ItemBackpack)current.getItem());
		default:return null;
		}
	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(x, y, z);
		ItemStack current = player.getCurrentEquippedItem();
		switch(id) {
		//case 1:return new GuiFurnitureMachines(player, (TileEntityFurnitureMachines)te);
		case 15:return new GuiFurnitureChest(player, (TileEntityFurnitureChest)te);
		//case 16:return new GuiBookshelf(player, (TileEntityBookshelf)te);
		//case 17:return new GuiMincer(player, (TileEntityMincer)te);
		//case 18:return new GuiGrills(player, (TileEntityGrills)te);
		//case 19:return new GuiMashineWater(player, (TileEntityMashineWater)te);
		case 20:return new GuiBackpack(player, (ItemBackpack)current.getItem());
		case 32:return new GuiBackpack(player, (ItemBackpack)current.getItem());
		case 33:return new GuiBackpack(player, (ItemBackpack)current.getItem());
		case 34:return new GuiBackpack(player, (ItemBackpack)current.getItem());
		case 35:return new GuiBackpack(player, (ItemBackpack)current.getItem());
		case 36:return new GuiBackpack(player, (ItemBackpack)current.getItem());
		case 37:return new GuiBackpack(player, (ItemBackpack)current.getItem());
		case 38:return new GuiBackpack(player, (ItemBackpack)current.getItem());
		case 39:return new GuiBackpack(player, (ItemBackpack)current.getItem());
		case 40:return new GuiBackpack(player, (ItemBackpack)current.getItem());
		case 41:return new GuiBackpack(player, (ItemBackpack)current.getItem());
		case 42:return new GuiBackpack(player, (ItemBackpack)current.getItem());
		case 43:return new GuiBackpack(player, (ItemBackpack)current.getItem());
		case 44:return new GuiBackpack(player, (ItemBackpack)current.getItem());
		case 45:return new GuiBackpack(player, (ItemBackpack)current.getItem());
		case 46:return new GuiBackpack(player, (ItemBackpack)current.getItem());
		case 47:return new GuiBackpack(player, (ItemBackpack)current.getItem());
		default:return null;
		}
	}

}
