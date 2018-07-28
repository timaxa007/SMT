package smt.pack.technology.entity;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityTelephone extends EntityItem {

	public EntityTelephone(World world) {
		super(world);
	}

	public EntityTelephone(World world, double posX, double posY, double posZ, ItemStack itemStack) {
		super(world, posX, posY, posZ, itemStack);
	}

	@Override
	public void onUpdate(){
		super.onUpdate();

		inWater = isInsideOfMaterial(Material.water);
			if (isInWater()) {
				//System.out.println("EntityTelephone");
				ItemStack item = getEntityItem();
				item.setItemDamage(item.getItemDamage() + 1);

				worldObj.spawnParticle("blockcrack_" + Block.getIdFromBlock(Blocks.iron_bars) + "_0",
						posX, posY, posZ,
						0D, 1D, 0D);
				setEntityItemStack(item);
			}
	}

}
