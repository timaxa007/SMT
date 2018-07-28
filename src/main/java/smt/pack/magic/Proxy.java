package smt.pack.magic;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import smt.pack.magic.inventory.ChestExpContainer;
import smt.pack.magic.inventory.ContainerDisenchanter;
import smt.pack.magic.inventory.ContainerInfuser;
import smt.pack.magic.inventory.GuiID;
import smt.pack.magic.tile.TileEntityChestExp;
import smt.pack.magic.tile.TileEntityDisenchanter;
import smt.pack.magic.tile.TileEntityInfuser;

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
		case GuiID.CHEST_EXP:return new ChestExpContainer(player, (TileEntityChestExp)tile);
		case GuiID.DISENCHANTER:return new ContainerDisenchanter(player, (TileEntityDisenchanter)tile);
		case GuiID.INFUSER:return new ContainerInfuser(player, (TileEntityInfuser)tile);
		default:return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}

	public static void openGui(final int ID, final EntityPlayer player, final int x, final int y, final int z) {
		player.openGui(SMTMagic.instance, ID, player.worldObj, x, y, z);
	}

	public static void openGui(final int ID, final EntityPlayer player) {
		player.openGui(SMTMagic.instance, ID, player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ);
	}

}
