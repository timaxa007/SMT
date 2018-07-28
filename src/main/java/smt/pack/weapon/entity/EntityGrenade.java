package smt.pack.weapon.entity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityGrenade extends EntityThrowable {

	public EntityGrenade(World world) {
		super(world);
	}

	public EntityGrenade(World world, EntityPlayer player) {
		super(world, player);
	}

	@Override
	public void onImpact(MovingObjectPosition mop) {

	}

	public void setSmokeColour(int i) {
		
	}

}
