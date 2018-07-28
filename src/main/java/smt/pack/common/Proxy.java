package smt.pack.common;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import smt.pack.common.inventory.*;

public class Proxy implements cpw.mods.fml.common.network.IGuiHandler {

	public void preInit() {

	}

	public void init() {

	}

	public void postInit() {

	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tile = world.getTileEntity(x, y, z);
		switch(ID) {
		//case GuiID.BLOCKS_common:return new BlockscommonContainer(player.inventory, (TileEntityBlockscommon)tile);
		case GuiID.BACKPACK:return new ContainerItemStorage(player, new InventoryItemStorage(player.getCurrentEquippedItem()));
		default:return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}

	public static final void openGui(int ID, EntityPlayer player, int x, int y, int z) {
		player.openGui(SMTCommon.instance, ID, player.worldObj, x, y, z);
	}

	public static final void openGui(int ID, EntityPlayer player) {
		player.openGui(SMTCommon.instance, ID, player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ);
	}

}
