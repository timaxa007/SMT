package smt.pack.phytology.event;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFlowerPot;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.util.FakePlayerFactory;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.item.ItemExpireEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import smt.pack.EntityLook;
import smt.pack.phytology.SMTPhytology;
import smt.pack.phytology.network.MessageFlowerPotClient;
import smt.pack.phytology.registry.LivingFeedAI;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventsForge {

	@SubscribeEvent
	public void place(PlayerInteractEvent event) {
		ItemStack itemStack = event.entityPlayer.getCurrentEquippedItem();
		if (itemStack != null) {
			if (event.action == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK) {
				if (itemStack.getItem() == SMTPhytology.item.itemsPhytology && event.world.getTileEntity(event.x, event.y, event.z) != null && event.world.getTileEntity(event.x, event.y, event.z) instanceof TileEntityFlowerPot) {
					TileEntityFlowerPot tileentityflowerpot = (TileEntityFlowerPot)event.world.getTileEntity(event.x, event.y, event.z);
					if (tileentityflowerpot.getFlowerPotItem() == null) {

						if (!event.world.isRemote) {
							int i = event.world.rand.nextInt(2);
							tileentityflowerpot.func_145964_a(Item.getItemFromBlock(Blocks.sapling), i);
							SMTPhytology.network.sendToDimension(new MessageFlowerPotClient(event.x, event.y, event.z, i),
									event.world.provider.dimensionId);
						}
						tileentityflowerpot.markDirty();
						event.world.markBlockForUpdate(event.x, event.y, event.z);

						if (!event.entityPlayer.capabilities.isCreativeMode && --itemStack.stackSize <= 0) {
							event.entityPlayer.inventory.setInventorySlotContents(event.entityPlayer.inventory.currentItem, null);
						}

					}
				}
			}
		}
	}

	@SubscribeEvent
	public void placeSeeds(ItemExpireEvent event) {
		EntityItem itemEntity = event.entityItem;
		ItemStack itemstack = itemEntity.getEntityItem();
		Item item = itemstack.getItem();
		if (Block.getBlockFromItem(item) instanceof BlockSapling) {//Seeds and Plants
			World world = itemEntity.worldObj;
			if (world instanceof WorldServer) {
				FakePlayer player_fake = FakePlayerFactory.getMinecraft((WorldServer)world);
				player_fake.setPositionAndRotation(itemEntity.posX, itemEntity.posY, itemEntity.posZ, 0F, 90F);
				Vec3 vec3 = Vec3.createVectorHelper(player_fake.posX, player_fake.posY + 0.5D, player_fake.posZ);
				MovingObjectPosition mop = EntityLook.block(world, vec3, vec3.addVector(0D, -1D, 0D), true);
				if (mop != null) {
					int blockX = mop.blockX;
					int blockY = mop.blockY;
					int blockZ = mop.blockZ;
					int side = mop.sideHit;
					float hitX = (float)(mop.hitVec.xCoord - (double)blockX);
					float hitY = (float)(mop.hitVec.yCoord - (double)blockY);
					float hitZ = (float)(mop.hitVec.zCoord - (double)blockZ);

					if (itemEntity.worldObj.isAirBlock(blockX, blockY + 1, blockZ) && 
							(itemEntity.worldObj.getBlock(blockX, blockY, blockZ).getMaterial() == Material.ground || 
							itemEntity.worldObj.getBlock(blockX, blockY, blockZ).getMaterial() == Material.grass)) {
						if (item.onItemUse(itemstack, player_fake, world, blockX, blockY, blockZ, side, hitX, hitY, hitZ)) {

						}
					}
				}
			}
		}

	}

	@SubscribeEvent
	public void addEntityConstructing(EntityEvent.EntityConstructing event) {
		if (event.entity instanceof EntityLivingBase)
			if (LivingFeedAI.get((EntityLivingBase)event.entity) == null)
				LivingFeedAI.reg((EntityLivingBase)event.entity);
	}

	/*
	@SubscribeEvent
	public void addEntityConstructing(EntityEvent.EntityConstructing event) {
		if (event.entity instanceof EntityLivingBase)
			if (LivingFeedAI.get((EntityLivingBase)event.entity) == null)
				LivingFeedAI.reg((EntityLivingBase)event.entity);
	}

	@SubscribeEvent
	public void followedFeed(LivingUpdateEvent event) {
		/*
		if (event.entityLiving instanceof EntityAnimal) {
			LivingFeedAI lf = LivingFeedAI.get((EntityAnimal)event.entity);
			if (lf != null && !lf.isAIfeed()) {
				System.out.println("followedFeed");
				EntityAnimal animal = (EntityAnimal)event.entityLiving;
				animal.tasks.addTask(4, new EntityAITempt(animal, 1.25D, SMTPhytology.item.itemFeed, false));
				lf.setTrueAIfeed();
			}
		}
	 *//*
		if (event.entityLiving instanceof EntityCreature) {
			LivingFeedAI lf = LivingFeedAI.get(event.entityLiving);
			if (lf != null && !lf.isAIfeed()) {
				EntityCreature creature = (EntityCreature)event.entityLiving;
				System.out.println(EntityList.getEntityString(creature));
				if (EntityList.getEntityString(creature).equals("Cow")) {
					//creature.tasks.addTask(4, new EntityAITempt(creature, 1.25D, Items.water_bucket, false));
					lf.setTrueAIfeed();
					return;
				}
				if (EntityList.getEntityString(creature).equals("MushroomCow")) {
					//creature.tasks.addTask(4, new EntityAITempt(creature, 1.25D, Items.mushroom_stew, false));
					lf.setTrueAIfeed();
					return;
				}
				if (EntityList.getEntityString(creature).equals("EntityHorse")) {
					//creature.tasks.addTask(4, new EntityAITempt(creature, 1.25D, Items.bread, false));
					lf.setTrueAIfeed();
					return;
				}
			}
		}
	}
	  */
	/*
	@SubscribeEvent
	public void entityInteractEvent(EntityJoinWorldEvent event) {
		System.out.println("EntityJoinWorldEvent");
	}
	 */
	/*
	@SubscribeEvent
	public void entityInteractEvent(EntityInteractEvent event) {
		System.out.println("entityInteractEvent");
		ItemStack itemStack = event.entityPlayer.getCurrentEquippedItem();
		if (itemStack != null && itemStack.getItem() == Items.bread)
			if (event.target instanceof EntityCreature) {
				EntityCreature creature = (EntityCreature)event.target;
				creature.tasks.addTask(4, new EntityAITempt(creature, 1.25D, Items.bread, false));
			}
	}
	 */
}
