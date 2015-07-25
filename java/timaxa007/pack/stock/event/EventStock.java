package timaxa007.pack.stock.event;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import timaxa007.pack.stock.PackStock;
import timaxa007.pack.stock.config.ConfigStock;
import timaxa007.pack.stock.entity.EntityCorpse;
import timaxa007.pack.stock.item.ItemPetals;
import timaxa007.pack.stock.item.ItemsStock;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventStock {
	private static Random random;
	//--------------------------------------------------------------------------------------------------------------
	/*@SubscribeEvent
	public void onUseBonemeal(BonemealEvent event) {
		if (event.ID == PackStock.blockSapling1) {
			if (!event.world.isRemote) {
				((BlockSapling1)PackStock.blockSapling1).onTreeUp(event.world, event.X, event.Y, event.Z);
			}
			event.setResult(Result.ALLOW);
		}
	}*/
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onUpdate(LivingUpdateEvent p) {
		if (p.entityLiving instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)p.entityLiving;

			for (int i = 0; i < player.inventory.mainInventory.length; i++) {
				if (player.inventory.mainInventory[i] != null && player.inventory.mainInventory[i].getItem() instanceof ItemsStock) {

					if (player.getActivePotionEffect(Potion.nightVision) != null) {
						//player.removePotionEffect(Potion.nightVision.id);
					} else {
						//player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 20, 3));
					}
					break;
				}
			}

		}
	}
	//--------------------------------------------------------------------------------------------------------------
	public static double rand;

	@SubscribeEvent
	public void onEntityDrop(LivingDropsEvent event) {
		if (event.source.getDamageType().equals("player")) {
			rand = Math.random();
			if (event.entityLiving instanceof EntityZombie) {

				if (rand >= 0.0D && rand <= 0.25D) {
					event.entityLiving.entityDropItem(new ItemStack(Items.stick, 1, 0), 0.0F);
				}

				if (rand >= 0.26D && rand <= 0.5D) {
					event.entityLiving.entityDropItem(new ItemStack(Items.bone, 1, 0), 0.0F);
				}

				if (rand >= 0.51D && rand <= 0.60D) {
					event.entityLiving.entityDropItem(new ItemStack(Items.leather, 1, 0), 0.0F);
				}

			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void addNewBucket(FillBucketEvent event) {
		if (event.current.getItem() == Items.bucket) {
			if (event.world.getBlock(event.target.blockX, event.target.blockY, event.target.blockZ) == Blocks.stone) {
				event.result = new ItemStack(PackStock.item.drinks, 1, 0);
				event.world.setBlockToAir(event.target.blockX, event.target.blockY, event.target.blockZ);
				event.setResult(Result.ALLOW);
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void addNewBottle(PlayerInteractEvent event) {
		EntityPlayer player = event.entityPlayer;
		World world = player.worldObj;
		ItemStack current = player.getCurrentEquippedItem();
		if (player != null && world != null && event.action == event.action.RIGHT_CLICK_BLOCK) {
			if (current != null && current.getItem() == Items.glass_bottle && world.getBlock(event.x, event.y, event.z) == Blocks.stone) {
				--current.stackSize;
				player.inventory.addItemStackToInventory(new ItemStack(PackStock.item.drinks, 1, 0));
				event.setResult(Result.ALLOW);
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onEatFoodItem(PlayerEvent event) {
		/*enter to server = crash
		EntityPlayer player = event.entityPlayer;

		if (player != null) {
			ItemStack current = player.getCurrentEquippedItem();
			if (player.isEating() && current != null) {
				if (current.getItem() instanceof ItemFood) {
				}

			}
		}
		 */
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onEntityTrimming(EntityInteractEvent event) {
		World world = event.entity.worldObj;
		if (event.entityPlayer.getCurrentEquippedItem() != null && event.entityPlayer.getCurrentEquippedItem().getItem() instanceof ItemsStock) {

			if (event.target instanceof EntityChicken) {
				if (!world.isRemote) {
					world.spawnEntityInWorld(new EntityItem(world, event.target.posX, event.target.posY, event.target.posZ, new ItemStack(Items.feather, 1, 0)));
					event.target.setDead();
					Entity entity = ItemMonsterPlacer.spawnCreature(world, EntityList.getEntityID(new EntityCow(world)), event.target.posX, event.target.posY, event.target.posZ);
					world.spawnEntityInWorld(entity);
				}
			}

		}

	}
	//--------------------------------------------------------------------------------------------------------------
	/*@SubscribeEvent
	public void dropCobblestone(LivingDropsEvent event) {
		if (event.source.getDamageType().equals("player")) {
			random = new Random();
			if (event.entityLiving instanceof EntityZombie) {
				random = new Random();
				System.out.println(random);
				if (random.nextInt(100) < 60) {
					random = new Random();
					System.out.println(random);
					event.entityLiving.entityDropItem(new ItemStack(Blocks.cobblestone, 1 + random.nextInt(5), 0), 0.0F);
				}
			}
		}
	}*/
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void dropFlower(BlockEvent.HarvestDropsEvent event) {
		boolean drop_default = (ConfigStock.getDropVanillaFlowers() == ConfigStock.typeDropVanillaFlowers.DEFAULT);
		boolean drop_vanilla_dye = (ConfigStock.getDropVanillaFlowers() == ConfigStock.typeDropVanillaFlowers.VANILLA_DYE);
		boolean drop_petals = (ConfigStock.getDropVanillaFlowers() == ConfigStock.typeDropVanillaFlowers.PETALS);
		boolean drop_other = (ConfigStock.getDropVanillaFlowers() == ConfigStock.typeDropVanillaFlowers.OTHER);
		if (!drop_default) {
			//-------------------------------------------------------------------------------------
			if (event.block == Blocks.red_flower) {
				if (event.blockMetadata == 0) {
					if (drop_vanilla_dye)
						renewDropFlower(event, new ItemStack(Items.dye, 1 + event.world.rand.nextInt(2), 1));
					if (drop_petals)
						renewDropFlower(event, ItemPetals.addNBT("poppy"), 1 + event.world.rand.nextInt(2));
				}
				if (event.blockMetadata == 1) {
					if (drop_vanilla_dye)
						renewDropFlower(event, new ItemStack(Items.dye, 1 + event.world.rand.nextInt(2), 12));
					if (drop_petals)
						renewDropFlower(event, ItemPetals.addNBT("blueOrchid"), 1 + event.world.rand.nextInt(2));
				}
				if (event.blockMetadata == 2) {
					if (drop_vanilla_dye)
						renewDropFlower(event, new ItemStack(Items.dye, 1 + event.world.rand.nextInt(2), 13));
					if (drop_petals)
						renewDropFlower(event, ItemPetals.addNBT("allium"), 1 + event.world.rand.nextInt(2));
				}
				if (event.blockMetadata == 3) {
					if (drop_vanilla_dye)
						renewDropFlower(event, new ItemStack(Items.dye, 1 + event.world.rand.nextInt(2), 7));
					if (drop_petals)
						renewDropFlower(event, ItemPetals.addNBT("houstonia"), 1 + event.world.rand.nextInt(2));
				}
				if (event.blockMetadata == 4) {
					if (drop_vanilla_dye)
						renewDropFlower(event, new ItemStack(Items.dye, 1 + event.world.rand.nextInt(2), 1));
					if (drop_petals)
						renewDropFlower(event, ItemPetals.addNBT("tulipRed"), 1 + event.world.rand.nextInt(2));
				}
				if (event.blockMetadata == 5) {
					if (drop_vanilla_dye)
						renewDropFlower(event, new ItemStack(Items.dye, 1 + event.world.rand.nextInt(2), 14));
					if (drop_petals)
						renewDropFlower(event, ItemPetals.addNBT("tulipOrange"), 1 + event.world.rand.nextInt(2));
				}
				if (event.blockMetadata == 6) {
					if (drop_vanilla_dye)
						renewDropFlower(event, new ItemStack(Items.dye, 1 + event.world.rand.nextInt(2), 7));
					if (drop_petals)
						renewDropFlower(event, ItemPetals.addNBT("tulipWhite"), 1 + event.world.rand.nextInt(2));
				}
				if (event.blockMetadata == 7) {
					if (drop_vanilla_dye)
						renewDropFlower(event, new ItemStack(Items.dye, 1 + event.world.rand.nextInt(2), 8));
					if (drop_petals)
						renewDropFlower(event, ItemPetals.addNBT("tulipPink"), 1 + event.world.rand.nextInt(2));
				}
				if (event.blockMetadata == 8) {
					if (drop_vanilla_dye)
						renewDropFlower(event, new ItemStack(Items.dye, 1 + event.world.rand.nextInt(2), 7));
					if (drop_petals)
						renewDropFlower(event, ItemPetals.addNBT("oxeyeDaisy"), 1 + event.world.rand.nextInt(2));
				}
			}
			//-------------------------------------------------------------------------------------
			if (event.block == Blocks.yellow_flower) {
				if (event.blockMetadata == 0) {
					if (drop_vanilla_dye)
						renewDropFlower(event, new ItemStack(Items.dye, 1 + event.world.rand.nextInt(2), 11));
					if (drop_petals)
						renewDropFlower(event, ItemPetals.addNBT("dandelion"), 1 + event.world.rand.nextInt(2));
				}
			}
			//-------------------------------------------------------------------------------------
			if (event.block == Blocks.double_plant) {
				if (event.blockMetadata == 0) {
					if (drop_vanilla_dye)
						renewDropFlower(event, new ItemStack(Items.dye, 2 + event.world.rand.nextInt(1), 11));
					if (drop_petals)
						renewDropFlower(event, ItemPetals.addNBT("sunflower"), 2 + event.world.rand.nextInt(1));
				}
				if (event.blockMetadata == 1) {
					if (drop_vanilla_dye)
						renewDropFlower(event, new ItemStack(Items.dye, 2 + event.world.rand.nextInt(2), 13));
					if (drop_petals)
						renewDropFlower(event, ItemPetals.addNBT("syringa"), 2 + event.world.rand.nextInt(2));
				}
				if (event.blockMetadata == 4) {
					if (drop_vanilla_dye)
						renewDropFlower(event, new ItemStack(Items.dye, 2 + event.world.rand.nextInt(2), 1));
					if (drop_petals)
						renewDropFlower(event, ItemPetals.addNBT("rose"), 2 + event.world.rand.nextInt(2));
				}
				if (event.blockMetadata == 5) {
					if (drop_vanilla_dye)
						renewDropFlower(event, new ItemStack(Items.dye, 2 + event.world.rand.nextInt(2), 9));
					if (drop_petals)
						renewDropFlower(event, ItemPetals.addNBT("paeonia"), 2 + event.world.rand.nextInt(2));
				}
			}
			//-------------------------------------------------------------------------------------
		}
	}

	private static void renewDropFlower(BlockEvent.HarvestDropsEvent event, ItemStack is) {
		event.drops.clear();
		if (is != null) event.drops.add(is);
	}

	private static void renewDropFlower(BlockEvent.HarvestDropsEvent event, ItemStack is, int size) {
		event.drops.clear();
		if (is != null) {
			is.stackSize = size;
			event.drops.add(is);
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void corpseSpawn(LivingDeathEvent event) {
		EntityLivingBase entity = event.entityLiving;
		if (entity != null) {
			World world = entity.worldObj;
			if (world != null) {

				if (!(event.entity instanceof EntityCorpse)) {

					EntityCorpse corpse = new EntityCorpse(world);
					corpse.setPositionAndRotation(entity.posX, entity.posY, entity.posZ, entity.rotationYaw, entity.rotationPitch);

					/*if (entity instanceof EntityZombie) {}
					else if (entity instanceof EntityCow) {}
					else if (entity instanceof EntityPig) {}
					else {}*/

					//if (!world.isRemote) world.spawnEntityInWorld(corpse);

				}

			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
}
