package timaxa007.pack.magic.util;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ActionMagic {

	public static void actionVoid(World world, EntityPlayer player) {

	}

	public static void actionTackEntityItem(EntityItem entity, EntityPlayer player) {
		ItemStack drop_item = entity.getEntityItem();
		for (int i = 0; i < player.inventory.mainInventory.length; i++) {
			if (player.inventory.mainInventory[i] == null || player.inventory.mainInventory[i] == drop_item) {
				player.inventory.addItemStackToInventory(drop_item);
				entity.setDead();
				break;
			}
		}
	}
	/*
	public static void actionVoid1(World world, EntityPlayer player) {

		//MovingObjectPosition obj = Minecraft.getMinecraft().objectMouseOver;
		MovingObjectPosition obj_block = Minecraft.getMinecraft().renderViewEntity.rayTrace(80.0D, 1.0F);
		MovingObjectPosition obj_entity = UtilSMT.LookOBJ.getEntityDistance(80.0D);

		if (obj_entity != null) {
			Entity entity = obj_entity.entityHit;

			if (entity instanceof EntityItem) ActionMagic.actionTackEntityItem((EntityItem)entity, player);

			if (entity instanceof EntityLivingBase) {
				((EntityLivingBase)entity).onKillEntity((EntityLivingBase)entity);
				world.spawnEntityInWorld(new EntityItem(world, entity.posX, entity.posY, entity.posZ, new ItemStack(Items.slime_ball, (int)((EntityLivingBase)entity).getHealth() / 2, 0)));
				//entity.setDead();
				//entity.posX
				//entity.posY
				//entity.posZ
			}


			if (CoreSMT.show_system_info_testing) System.out.println("obj_entity - " + obj_entity.toString());
		} else if (obj_block != null && obj_block.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
			int x = obj_block.blockX;
			int y = obj_block.blockY;
			int z = obj_block.blockZ;
			Block block = world.getBlock(x, y, z);

			//if (block.getMaterial() != Material.air) {}

			if (CoreSMT.show_system_info_testing) System.out.println(block.getLocalizedName() + "obj_block - " + obj_block.toString());
		} else {
			if (CoreSMT.show_system_info_testing) System.out.println("Air");
		}

	}

	public static void actionVoid2(World world, EntityPlayer player) {

		MovingObjectPosition obj_block = Minecraft.getMinecraft().renderViewEntity.rayTrace(200.0D, 1.0F);
		MovingObjectPosition obj_entity = UtilSMT.LookOBJ.getEntityDistance();

		if (obj_entity != null) {
			Entity entity = obj_entity.entityHit;

			if (entity instanceof EntityItem) ActionMagic.actionTackEntityItem((EntityItem)entity, player);

			if (entity instanceof EntityLivingBase) {
				((EntityLivingBase)entity).onKillEntity((EntityLivingBase)entity);
				world.spawnEntityInWorld(new EntityItem(world, entity.posX, entity.posY, entity.posZ, new ItemStack(Items.slime_ball, (int)((EntityLivingBase)entity).getHealth() / 2, 0)));
				//entity.setDead();
				//entity.posX
				//entity.posY
				//entity.posZ
			}


			if (CoreSMT.show_system_info_testing) System.out.println("obj_entity - " + obj_entity.toString());
		} else if (obj_block != null && obj_block.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
			int x = obj_block.blockX;
			int y = obj_block.blockY;
			int z = obj_block.blockZ;
			Block block = world.getBlock(x, y, z);

			//if (block.getMaterial() != Material.air) {}

			if (world.getBlock(x, y + 1, z) == Blocks.flowing_lava) {
				world.setBlockToAir(x, y + 1, z);
				UtilSMT.UtilWorld.dropItem(world, x, y + 1, z, new ItemStack(Blocks.cobblestone));
			}

			if (block == Blocks.dirt && world.getBlockMetadata(x, y, z) == 0) {
				world.setBlock(x, y, z, Blocks.grass);
			}

			if (CoreSMT.show_system_info_testing) System.out.println(block.getLocalizedName() + "obj_block - " + obj_block.toString());
		} else {
			if (CoreSMT.show_system_info_testing) System.out.println("Air");
		}

		double d0 = (double)(50);

		AxisAlignedBB axisalignedbb = AxisAlignedBB.getBoundingBox((double)player.posX, (double)player.posY, (double)player.posZ, (double)(player.posX + 1), (double)(player.posY + 1), (double)(player.posZ + 1)).expand(d0, d0, d0);
		axisalignedbb.maxY = (double)world.getHeight();
		List list = world.getEntitiesWithinAABB(Entity.class, axisalignedbb);
		Iterator iterator = list.iterator();
		Entity entity;

		while(iterator.hasNext()) {
			entity = (Entity)iterator.next();
			MovingObjectPosition target = new MovingObjectPosition(entity);
			//System.out.println(target.toString());

			//Minecraft.getMinecraft().effectRenderer.addEffect(new EntityHugeExplodeFX(world, ((double)player.posX), ((double)player.posY), ((double)player.posZ), 0.0D, 0.0D, 0.0D));

			if (entity instanceof EntityPlayer) {
				if (entity == player) player.getFoodStats().addStats(1, 1.0F);
				//if (!world.isRemote) ((EntityPlayer)entity).addPotionEffect(new PotionEffect(Potion.regeneration.id, 20 * 1));
			}

			else if (entity instanceof EntityLivingBase) {
				((EntityLivingBase)entity).setFire(10);
				//entity.posX
				//entity.posY
				//entity.posZ
			}

			if (entity instanceof EntityItem) ActionMagic.actionTackEntityItem((EntityItem)entity, player);

			if (entity instanceof EntityArrow) {
				for (int i = 0; i < player.inventory.mainInventory.length; i++) {
					if (player.inventory.mainInventory[i] == null || (player.inventory.mainInventory[i].getItem() == Items.arrow)) {
						player.inventory.addItemStackToInventory(new ItemStack(Items.arrow, 1));
						entity.setDead();
						break;
					}
				}
			}

			if (entity instanceof EntityXPOrb) {
				int xpv = ((EntityXPOrb)entity).getXpValue();
				player.addExperience(xpv);
				entity.setDead();
				world.playSoundAtEntity(player, "random.orb", 0.1F, 0.5F + ((float)xpv * 0.02F));
			}

		}

	}
	 */
	/*
	public static void actionVoid3(World world, EntityPlayer player) {
		PackConjoint.network.sendToAllAround(new MessageSpawnParticle(1, player.posX, player.posY, player.posZ), 
				new NetworkRegistry.TargetPoint(player.dimension, player.posX, player.posY, player.posZ, 18.5D));
	}
	 */
}
