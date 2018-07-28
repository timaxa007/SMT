package smt.pack.vehicle.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import smt.pack.vehicle.entity.EntityVehicle;
import smt.pack.vehicle.entity.VehiclePartEntity;

public class ItemItemsVehicle extends Item {

	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		EntityVehicle entity = new EntityVehicle(world);
		entity.setPosition((double)x + 0.5D, (double)y + 1.5D + (double)entity.getEyeHeight(), (double)z + 0.5D);
		/*
		VehiclePartEntity part = new VehiclePartEntity(world);
		part.setPosition(entity.posX, entity.posY, entity.posZ);

		entity.parts = new VehiclePartEntity[] {
				part
		};
		 */
		if (!world.isRemote) {
			world.spawnEntityInWorld(entity);

			//entity.parts.add(new VehiclePartEntity(world));
			if (entity.parts != null)
				for (VehiclePartEntity part : entity.parts) {
					part.setPosition(entity.posX, entity.posY, entity.posZ);
					world.spawnEntityInWorld(part);
				}
		}
		return true;
	}

}
