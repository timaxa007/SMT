package smt.pack.magic.event;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class ItemWithChanceEvent extends PlayerEvent {

	/**
	С помощью какого предмета будет выпадать "предмет с шансом".</br>
	With the help of some item will drop "item with chance".
	**/
	public final ItemStack item_use;
	/**
	Список "предмет с шансом".</br>
	List "item with chance".
	**/
	public ArrayList<ItemWithChance> list_drops;

	public ItemWithChanceEvent(ArrayList<ItemWithChance> list_drops, ItemStack item_use, EntityPlayer player) {
		super(player);
		this.item_use = item_use;
		this.list_drops = list_drops;
	}

	public void addItemWithChance(float chance, Object item) {
		if (item == null || chance <= 0F) return;
		this.list_drops.add(new ItemWithChance(chance, item));
	}

	public static class ItemWithChance {

		private ItemStack item;
		private float chance;

		public ItemWithChance(float chance, Object item) {
			if (item == null) return;
			else if (item instanceof Block) this.item = new ItemStack((Block)item);
			else if (item instanceof Item) this.item = new ItemStack((Item)item);
			else if (item instanceof ItemStack) this.item = (ItemStack)item;
			else return;
			if (chance <= 0F) return;
			else this.chance = chance;
		}

		public ItemStack getItem() {
			return item;
		}

		public float getChance() {
			return chance;
		}

	}

}
