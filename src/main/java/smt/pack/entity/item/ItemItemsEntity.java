package smt.pack.entity.item;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import smt.pack.entity.entity.EntityZombie;

public class ItemItemsEntity extends Item {

	public ItemItemsEntity() {
		super();
	}

	@Override
	public boolean itemInteractionForEntity(ItemStack item, EntityPlayer player, EntityLivingBase entity) {
		if (!player.worldObj.isRemote && entity instanceof EntityChicken) {
			EntityLiving entityliving = (EntityLiving)entity;
			entityliving.dropItem(Items.egg, 1);
			entityliving.func_110163_bv();
			item.damageItem(1, entity);
			return true;
		}
		return super.itemInteractionForEntity(item, player, entity);
	}

	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		EntityZombie entity = null;
		//EntitySkeleton - EntityZombie
		/*
		if (player.isSneaking()) {
			entity = new EntityLightningBolt(world, (double)x + 0.5D, (double)y + 0.5D, (double)z + 0.5D);
		} else {
			entity = new EntityLightningBolt2(world, (double)x + 0.5D, (double)y + 0.5D, (double)z + 0.5D);
		}
		 */
		entity = new EntityZombie(world);
		entity.setPosition((double)x + 0.5D, (double)y + 1.5D, (double)z + 0.5D);
		/*entity.setCurrentItemOrArmor(1, new ItemStack(MyMod.armorBoots));
		entity.setCurrentItemOrArmor(2, new ItemStack(MyMod.armorPants));
		entity.setCurrentItemOrArmor(3, new ItemStack(MyMod.armorVest));
		entity.setCurrentItemOrArmor(4, new ItemStack(MyMod.armorHelmet));*/
		//entity.setChild(true);
		//entity.setSkeletonType(1);

		/*entity.setCurrentItemOrArmor(1, new ItemStack(Items.diamond_boots));
		entity.setCurrentItemOrArmor(2, new ItemStack(Items.diamond_leggings));
		entity.setCurrentItemOrArmor(3, new ItemStack(Items.diamond_chestplate));
		entity.setCurrentItemOrArmor(4, new ItemStack(Items.diamond_helmet));*/
		if (entity != null) {
			if (!world.isRemote)
				world.spawnEntityInWorld(entity);
		}
		return true;
	}

}
