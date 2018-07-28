package smt.pack.common.client.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.Session;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class EntityCamClient extends EntityPlayerSP {

	public EntityCamClient(Minecraft mc, World world, Session session, int i) {
		super(mc, world, session, i);
		// TODO Auto-generated constructor stub
	}

	public EntityCamClient(Minecraft mc, World world) {
		super(mc, world, mc.getSession(), 0);//PlayerControllerMP 452 -> EntityClientPlayerMP
	}

	public EntityCamClient(Minecraft mc) {
		super(mc, mc.theWorld, mc.getSession(), 0);
	}

	@Override
	public boolean canBeCollidedWith() {
		return false;
	}

	@Override
	public boolean canBePushed() {
		return false;
	}

}
