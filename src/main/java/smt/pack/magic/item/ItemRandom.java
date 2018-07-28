package smt.pack.magic.item;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;
import smt.pack.magic.SMTMagic;
import smt.pack.magic.event.ItemWithChanceEvent;
import smt.pack.technology.SMTTechnology;

public class ItemRandom extends Item {

	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {

		ArrayList<ItemWithChanceEvent.ItemWithChance> list_rate_drops = new ArrayList<ItemWithChanceEvent.ItemWithChance>();

		//Даём конструктору эвента аргументы.
		//Give the constructor event's arguments.
		ItemWithChanceEvent event = new ItemWithChanceEvent(list_rate_drops, itemStack, player);

		//Добаваяем предметы с шансом.
		//Adding items with chance.
		event.addItemWithChance(30F, Items.diamond);
		event.addItemWithChance(30F, SMTMagic.item.teleport);
		event.addItemWithChance(30F, SMTTechnology.item.itemsTechnology);
		event.addItemWithChance(25F, new ItemStack(Items.coal, 1, 0));
		event.addItemWithChance(25F, new ItemStack(Items.coal, 1, 1));

		//После инстанций эвентов.
		//Post instance events.
		MinecraftForge.EVENT_BUS.post(event);

		//Если эвент отменён, то продолжать выполнять код не должен.
		//If the event is canceled, then continue to execute code should not.
		if (event.isCanceled()) return super.onItemRightClick(itemStack, world, player);

		if (!world.isRemote) {

			//Переделываем ItemWithChance для ChanceDropItem.
			//Remake ItemWithChance for ChanceDropItem.
			ArrayList<ChanceDropItem> list_drops_item = new ArrayList<ChanceDropItem>();
			if (!list_rate_drops.isEmpty())
				for (ItemWithChanceEvent.ItemWithChance cdi : list_rate_drops)
					addItemWithChance(list_drops_item, cdi.getChance(), cdi.getItem());

			if (!list_drops_item.isEmpty()) {
				float maxChance = getChanceMax(list_drops_item);
				float p = world.rand.nextFloat() * maxChance;
				ItemStack item_drop = null;
				for (int i = 0; i < list_drops_item.size(); ++i) {
					if (list_drops_item.get(i) != null) {
						if (list_drops_item.get(i).getChanceStart() <= p && list_drops_item.get(i).getChanceEnd() > p) {
							item_drop = list_drops_item.get(i).getItem().copy();
							System.out.println("Item: " + item_drop + " (" + p + " / " + maxChance + ")");
							break;
						}
					}
				}
				if (item_drop != null) {
					--itemStack.stackSize;
					//Если нельзя положить в инвентарь предмет, то
					if (!player.inventory.addItemStackToInventory(item_drop))
						//Бросаеться в мир (если эвент позволит).
						player.dropPlayerItemWithRandomChoice(item_drop, false);//Второй аргумент безполезен.
					
				}
			}
		}
		return super.onItemRightClick(itemStack, world, player);
	}

	private static void addItemWithChance(ArrayList<ChanceDropItem> list_drops, float chance, Object item) {
		if (list_drops == null || item == null || chance <= 0F) return;
		float tempChance = 0F;
		if (!list_drops.isEmpty()) {
			for (int i = 0; i < list_drops.size(); ++i) {
				if (list_drops.get(i) != null) {
					if (tempChance < list_drops.get(i).getChanceEnd()) tempChance = list_drops.get(i).getChanceEnd();
					else continue;
				} else continue;
			}
		}
		list_drops.add(new ChanceDropItem(tempChance, tempChance + chance, item));
	}

	private static float getChanceMax(ArrayList<ChanceDropItem> list_drops) {
		float maxChance = 0F;
		if (list_drops != null && !list_drops.isEmpty()) {
			for (int i = 0; i < list_drops.size(); ++i) {
				if (list_drops.get(i) == null) continue;
				if (maxChance < list_drops.get(i).getChanceEnd()) maxChance = list_drops.get(i).getChanceEnd();
				else continue;
			}
		}
		return maxChance;
	}

	private static class ChanceDropItem {

		private ItemStack item;
		private float chanceStart;
		private float chanceEnd;

		public ChanceDropItem(float chanceStart, float chanceEnd, Object item) {
			if (item == null) return;
			else if (item instanceof Block) this.item = new ItemStack((Block)item);
			else if (item instanceof Item) this.item = new ItemStack((Item)item);
			else if (item instanceof ItemStack) this.item = (ItemStack)item;
			else return;
			this.chanceStart = chanceStart;
			this.chanceEnd = chanceEnd;
		}

		public ItemStack getItem() {
			return item;
		}

		public float getChanceStart() {
			return chanceStart;
		}

		public float getChanceEnd() {
			return chanceEnd;
		}

	}

}
