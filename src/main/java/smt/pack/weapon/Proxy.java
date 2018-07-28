package smt.pack.weapon;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import smt.pack.weapon.inventory.*;
import smt.pack.weapon.registry.WeaponSystem;
import smt.pack.weapon.tile.*;

public class Proxy implements cpw.mods.fml.common.network.IGuiHandler {

	public WeaponSystem wpn_sys;

	public void preInit() {
		wpn_sys = new WeaponSystem();
	}

	public void init() {

	}

	public void postInit() {

	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		net.minecraft.tileentity.TileEntity tile = world.getTileEntity(x, y, z);
		switch(ID) {
		case GuiID.ASSEMBLY_TABLE:return new AssemblyTableContainer(player, (TileEntityAssemblyTable)tile);
		default:return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}

	public static void openGui(int ID, EntityPlayer player, int x, int y, int z) {
		player.openGui(SMTWeapon.instance, ID, player.worldObj, x, y, z);
	}

	public static void openGui(int ID, EntityPlayer player) {
		player.openGui(SMTWeapon.instance, ID, player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ);
	}

}
