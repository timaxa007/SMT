package smt.pack.privacy.event;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Sets;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.event.entity.player.PlayerOpenContainerEvent;
import net.minecraftforge.event.world.WorldEvent;
import smt.pack.privacy.registry.InventoryData;


public class EventsForge {
	/*
	@SubscribeEvent
	public void opening(PlayerInteractEvent event) {
		if (event.action == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK) {
			TileEntity tile = event.world.getTileEntity(event.x, event.y, event.z);
			if (tile instanceof IInventory) {
				SMTPrivacy.proxy.openGui(GuiID.LOCKPICKING, event.entityPlayer, event.x, event.y, event.z);
				event.setCanceled(true);
			}
		}
	}
	 */
	/*
	@SubscribeEvent
	public void blockClicked(PlayerInteractEvent event) {
		if (event.world.getBlock(event.x, event.y, event.z) == SMTPrivacy.blocks.blocksPrivacy) {
			if (event.action == PlayerInteractEvent.Action.LEFT_CLICK_BLOCK) {
				event.setCanceled(true);
			}
			else if (event.action == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK) {
				event.setCanceled(true);
			}
		}
	}
	 */
	/*
	@SubscribeEvent
	public void onEntityJoin(EntityJoinWorldEvent event) {
		if (event.entity instanceof EntityZombie) {
			EntityZombie zombie = (EntityZombie)event.entity;
			if (zombie.isChild()) event.setCanceled(true);
		}
	}
	 */

	@SubscribeEvent
	public void checkDurability(WorldEvent.Load event) {
		InventoryData.createOrLoad(event.world);
	}

	Set blocked_items = Sets.newHashSet(new Item[] {
			Items.nether_star,
			Item.getItemFromBlock(Blocks.bedrock)
	});

	@SubscribeEvent
	public void dropQ(ItemTossEvent event) {
		if (event.entityItem != null) {
			ItemStack item = event.entityItem.getEntityItem();
			if (item != null && blocked_items.contains(item.getItem())) {
				event.player.inventory.addItemStackToInventory(item);
				event.setCanceled(true);
			}
		}
	}

	static HashMap<ItemStack, ItemStack> map = new HashMap<ItemStack, ItemStack>();
	static {
		map.put(new ItemStack(Blocks.tnt), new ItemStack(Items.gunpowder));
		map.put(new ItemStack(Blocks.bedrock), null);
	}

	//@SubscribeEvent
	public void playerOpenContainerEvent(PlayerOpenContainerEvent event) {
		Container container = event.entityPlayer.openContainer;
		if (container != null) {
			for (int i = 0; i < container.inventorySlots.size(); ++i) {
				Slot slot = container.getSlot(i);
				if (slot != null && slot.getHasStack()) {
					ItemStack item = slot.getStack();
					for (Map.Entry<ItemStack, ItemStack> entry : map.entrySet()) {
						ItemStack key = entry.getKey();
						if (key != null && key.isItemEqual(item)) {
							if (entry.getValue() == null)
								slot.putStack(null);
							else {
								ItemStack value = entry.getValue().copy();
								value.stackSize = item.stackSize;
								slot.putStack(value);
							}
						}
					}

				}
			}
		}
	}

	//static HashMap<EntityPlayer, Long> mapOpenChest = new HashMap<EntityPlayer, Long>();
	/*
	@SubscribeEvent
	public void openChest(PlayerInteractEvent event) {
		if (event.world.isRemote) return;
		if (event.world.getBlock(event.x, event.y, event.z) == Blocks.chest) {
			if (event.action == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK) {
				if (mapOpenChest.containsKey(event.entityPlayer)) {
					//TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
					mapOpenChest.replace(event.entityPlayer, System.currentTimeMillis() + (1000 * 6));
					System.out.println("up time " + event.entityPlayer.getCommandSenderName() + " in mapOpenChest [" + System.currentTimeMillis() + "/" + System.currentTimeMillis() + (1000 * 6) + "]");
					event.setCanceled(true);
				} else {
					mapOpenChest.put(event.entityPlayer, System.currentTimeMillis() + (1000 * 2));
					System.out.println("add time " + event.entityPlayer.getCommandSenderName() + " in mapOpenChest [" + System.currentTimeMillis() + "/" + System.currentTimeMillis() + (1000 * 2) + "]");
				}
			}
		}
	}
	 */
	//static boolean isCloseChest;
	/*
	@SubscribeEvent
	public void openChest(PlayerOpenContainerEvent event) {
		if (!isCloseChest && event.entityPlayer.openContainer instanceof ContainerChest && mapOpenChest.containsKey(event.entityPlayer))
			event.setResult(Result.DENY);
	}

	@SubscribeEvent
	public void openChestUpdate(LivingEvent.LivingUpdateEvent event) {
		if (event.entityLiving.worldObj.isRemote) return;

		if (event.entityLiving instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)event.entityLiving;


			if (player.openContainer instanceof ContainerChest) {

				if (isCloseChest) {
					if (mapOpenChest.containsKey(player)) {
						//TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
						mapOpenChest.replace(player, System.currentTimeMillis() + (1000 * 6));
						System.out.println("up time " + player.getCommandSenderName() + " in mapOpenChest [" + System.currentTimeMillis() + "/" + System.currentTimeMillis() + (1000 * 6) + "]");
					} else {
						mapOpenChest.put(player, System.currentTimeMillis() + (1000 * 2));
						System.out.println("add time " + player.getCommandSenderName() + " in mapOpenChest [" + System.currentTimeMillis() + "/" + System.currentTimeMillis() + (1000 * 2) + "]");
					}
				}

				isCloseChest = false;
			} else {
				isCloseChest = true;
			}


			Long l = mapOpenChest.get(player);
			if (l != null && l.longValue() <= System.currentTimeMillis()) {
				mapOpenChest.remove(player);
				System.out.println("remove " + player.getCommandSenderName() + " in mapOpenChest [" + System.currentTimeMillis() + "]");
				return;
			}
		}
	}
	 */
}
