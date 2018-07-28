package smt.pack.common.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.google.common.collect.Sets;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants.NBT;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.world.BlockEvent;
import smt.pack.common.SMTCommon;
import smt.pack.common.entity.EntityCorpse;
import smt.pack.common.network.MessageCropseSyncClass;
import smt.pack.common.network.MessageCropseSyncNBT;
import smt.pack.common.registry.PlayerEffectIEEP;

public class EventsForge {

	//@SubscribeEvent(priority=EventPriority.HIGH)
	public void replaceFoodStats(EntityEvent.EntityConstructing event) {
		if (event.entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)event.entity;
			/*
			Field field = EntityPlayer.class.getDeclaredFields()[7];
			field.setAccessible(true);
			try {
				System.out.println(field.toString());
				FoodStats foodStats = new FoodStatsReplace();
				field.set(player, foodStats);
				System.out.println(field.toString());
			} catch (Exception e) {e.printStackTrace();}
			 */
			//ReflectionHelper.setPrivateValue(EntityPlayer.class, player, new FoodStatsReplace(), "foodStats", "field_71100_bB", "bp");
			/*
			try {
				Field f = ReflectionHelper.findField(EntityPlayer.class, "foodStats", "field_71100_bB", "bp");
				f.setAccessible(true);
				f.set(player, new FoodStatsReplace());
				System.out.println("replaceFoodStats");
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
			 */
		}
	}

	@SubscribeEvent
	public void addEntityConstructing(EntityEvent.EntityConstructing event) {
		if (event.entity instanceof EntityPlayer) {
			if (PlayerEffectIEEP.get((EntityPlayer)event.entity) == null)
				PlayerEffectIEEP.reg((EntityPlayer)event.entity);
		}
	}

	@SubscribeEvent
	public void onLivingEvent(LivingEvent.LivingUpdateEvent event) {
		if (event.entity instanceof EntityPlayer) {
			PlayerEffectIEEP ep = PlayerEffectIEEP.get((EntityPlayer)event.entity);
			if (ep != null) ep.update((EntityPlayer)event.entity);
		}
	}

	Set<Block> white_list_wood = Sets.newHashSet(
			Blocks.log,
			Blocks.log2
			);

	@SubscribeEvent
	public void unbreakeableWood(PlayerEvent.BreakSpeed event) {
		if (white_list_wood.contains(event.block) && canBlockItemAxe(event.entityPlayer.getHeldItem()))
			event.setCanceled(true);
	}

	private static boolean canBlockItemAxe(ItemStack itemStack) {
		return itemStack == null || !(itemStack.getItem() instanceof ItemAxe);
	}

	@SubscribeEvent
	public void itemPickupEvent(EntityItemPickupEvent event) {

	}
	/*
	@SubscribeEvent
	public void spawnCrops(LivingDeathEvent event) {
		Entity from = event.source.getSourceOfDamage();
		EntityLivingBase to = event.entityLiving;
		World world = event.entityLiving.worldObj;
		Entity crops = new EntityCorpse(world);
		world.spawnEntityInWorld(crops);
	}
	 */
	//@SubscribeEvent
	public void dropCrops(LivingDropsEvent event) {
		Entity from = event.source.getSourceOfDamage();
		EntityLivingBase to = event.entityLiving;
		World world = event.entityLiving.worldObj;
		EntityCorpse corpse = new EntityCorpse(world);
		corpse.setPosition(to.posX, to.posY, to.posZ);
		corpse.setDrops(event.drops);
		corpse.setCorpse(to);
		NBTTagCompound corpse_nbt = new NBTTagCompound();
		to.writeEntityToNBT(corpse_nbt);
		world.spawnEntityInWorld(corpse);
		SMTCommon.network.sendToDimension(new MessageCropseSyncNBT(corpse.getEntityId(), corpse_nbt), event.entityLiving.dimension);
		SMTCommon.network.sendToDimension(new MessageCropseSyncClass(corpse.getEntityId(), to.getClass().getName()), event.entityLiving.dimension);
		event.setCanceled(true);
	}
	/*
	@SubscribeEvent
	public void wpnXPdeath(LivingDeathEvent event) {
		Entity from = event.source.getSourceOfDamage();
		EntityLivingBase to = event.entityLiving;
		if (from instanceof EntityPlayer && to != null) {
			EntityPlayer player = (EntityPlayer)from;
			ItemStack current = player.getCurrentEquippedItem();
			NBTTagCompound nbt = current.getTagCompound();
			if (nbt == null) nbt = new NBTTagCompound();
			short wpnXP = 0;
			if (nbt.hasKey("wpnXP", NBT.TAG_SHORT))
				wpnXP = nbt.getShort("wpnXP");
			nbt.setShort("wpnXP", (short)(wpnXP + 1));
			current.setTagCompound(nbt);
		}
	}

	@SubscribeEvent
	public void wpnXPtip(ItemTooltipEvent event) {
		//System.out.println("ItemTooltipEvent");
		NBTTagCompound nbt = event.itemStack.getTagCompound();
		if (nbt != null && nbt.hasKey("wpnXP", NBT.TAG_SHORT)) {
			//System.out.println("ItemTooltipEvent 2");
			event.toolTip.add("Weapon XP: " + (int)nbt.getShort("wpnXP") + ".");
		}
	}
	 */
	@SubscribeEvent
	public void durabilityTip(ItemTooltipEvent event) {
		if (event.itemStack != null && event.itemStack.isItemDamaged()) {
			event.toolTip.add("Durability: " + (event.itemStack.getMaxDamage() - event.itemStack.getItemDamage()) + "/" + event.itemStack.getMaxDamage() + ".");
		}
	}

	public static final HashMap<EntityPlayer, ArrayList<Integer>> pickup = new HashMap<EntityPlayer, ArrayList<Integer>>();

	//@SubscribeEvent
	public void noPuckup(EntityItemPickupEvent event) {
		List<Integer> list = pickup.get(event.entityPlayer);
		if (list != null) {
			for (int i = 0; i < list.size(); ++i) {
				int id = list.get(i);
				if (id == event.item.getEntityId()) {
					list.remove(i);
					return;
				}
			}
		}
		event.setCanceled(true);
	}

	@SubscribeEvent
	public void placeSaveInv(BlockEvent.PlaceEvent event) {
		if (event.itemInHand == null) return;
		if (!event.itemInHand.hasTagCompound()) return;
		if (!event.itemInHand.getTagCompound().hasKey("SaveInv", NBT.TAG_LIST)) return;
		IInventory inv = (IInventory)event.world.getTileEntity(event.x, event.y, event.z);
		NBTTagList nbttaglist = event.itemInHand.getTagCompound().getTagList("SaveInv", NBT.TAG_COMPOUND);
		for (int i = 0; i < nbttaglist.tagCount(); ++i) {
			NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
			byte slot = nbttagcompound1.getByte("Slot");
			if (slot >= 0 && slot < inv.getSizeInventory())
				inv.setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(nbttagcompound1));
		}
	}
/*
	@SubscribeEvent
	public void death(LivingDeathEvent event) {
		if (event.source instanceof EntityDamageSource) {
			EntityDamageSource edc = (EntityDamageSource)event.source;
			if (edc.getSourceOfDamage() instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer)edc.getSourceOfDamage();
				if (event.entityLiving instanceof EntityPlayer)
					System.out.println("killPlayer - " + player.getCommandSenderName() + " - " + event.entityLiving.getCommandSenderName());
				else if (event.entityLiving instanceof EntityZombie)
					System.out.println("killZombie - " + player.getCommandSenderName() + " - " + event.entityLiving.getCommandSenderName());
			}
		}
	}
*/
}
