package timaxa007.pack.stock.event;

import java.util.Random;

import timaxa007.pack.stock.PackStock;
import timaxa007.pack.stock.item.ItemsStock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventStock {
	private static Random random;
	//--------------------------------------------------------------------------------------------------------------
	/*@SubscribeEvent
	public void onUseBonemeal(BonemealEvent event) {
		if (event.ID == PackStock.proxy.blockSapling1) {
			if (!event.world.isRemote) {
				((BlockSapling1)PackStock.proxy.blockSapling1).onTreeUp(event.world, event.X, event.Y, event.Z);
			}
			event.setResult(Result.ALLOW);
		}
	}*/
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onUpdate(LivingUpdateEvent p) {
		if (p.entityLiving instanceof EntityPlayer) {

			for (int i = 0; i < ((EntityPlayer)p.entityLiving).inventory.mainInventory.length; i++) {
				if (((EntityPlayer)p.entityLiving).inventory.mainInventory[i] != null && ((EntityPlayer)p.entityLiving).inventory.mainInventory[i].getItem() instanceof ItemsStock) {

					if (((EntityPlayer)p.entityLiving).getActivePotionEffect(Potion.nightVision) != null) {
						//((EntityPlayer)p.entityLiving).removePotionEffect(Potion.nightVision.id);
					} else {
						//((EntityPlayer)p.entityLiving).addPotionEffect(new PotionEffect(Potion.nightVision.id, 20, 3));
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
				event.result = new ItemStack(PackStock.proxy.item.drinks, 1, 0);
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
				player.inventory.addItemStackToInventory(new ItemStack(PackStock.proxy.item.drinks, 1, 0));
				event.setResult(Result.ALLOW);
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onEatFoodItem(PlayerEvent event) {

		if (event.entityPlayer.isEating() && event.entityPlayer.getCurrentEquippedItem() != null) {
			if (event.entityPlayer.getCurrentEquippedItem().getItem() instanceof ItemFood) {
			}

		}

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
	@SubscribeEvent
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
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void dropMossyCobblestone(LivingDropsEvent event) {
		if (event.source.getDamageType().equals("player")) {
			if (event.entityLiving instanceof EntityZombie) {
				random = new Random();
				System.out.println(random);
				if (random.nextInt(100) < 25) {
					random = new Random();
					System.out.println(random);
					event.entityLiving.entityDropItem(new ItemStack(Blocks.mossy_cobblestone, 1 + random.nextInt(2), 0), 0.0F);
				}
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void dropIronOre(LivingDropsEvent event) {
		if (event.source.getDamageType().equals("player")) {
			if (event.entityLiving instanceof EntityZombie) {
				random = new Random();
				System.out.println(random);
				if (random.nextInt(100) < 3) {
					random = new Random();
					System.out.println(random);
					event.entityLiving.entityDropItem(new ItemStack(Blocks.iron_ore, 1 + random.nextInt(1), 0), 0.0F);
				}
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void dropCoalOre(LivingDropsEvent event) {
		if (event.source.getDamageType().equals("player")) {
			if (event.entityLiving instanceof EntityZombie) {
				random = new Random();
				System.out.println(random);
				if (random.nextInt(100) < 7) {
					random = new Random();
					System.out.println(random);
					event.entityLiving.entityDropItem(new ItemStack(Blocks.coal_ore, 1 + random.nextInt(2), 0), 0.0F);
				}
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void dropLapisOre(LivingDropsEvent event) {
		if (event.source.getDamageType().equals("player")) {
			if (event.entityLiving instanceof EntityZombie) {
				random = new Random();
				System.out.println(random);
				if (random.nextInt(100) < 2) {
					random = new Random();
					System.out.println(random);
					event.entityLiving.entityDropItem(new ItemStack(Blocks.lapis_ore, 3 + random.nextInt(5), 0), 0.0F);
				}
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void dropGoldOre(LivingDropsEvent event) {
		if (event.source.getDamageType().equals("player")) {
			if (event.entityLiving instanceof EntityZombie) {
				random = new Random();
				System.out.println(random);
				if (random.nextInt(1000) < 8) {
					random = new Random();
					System.out.println(random);
					event.entityLiving.entityDropItem(new ItemStack(Blocks.gold_ore, 1 + random.nextInt(1), 0), 0.0F);
				}
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
}
