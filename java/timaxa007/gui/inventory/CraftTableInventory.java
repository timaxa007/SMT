package timaxa007.gui.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import timaxa007.module.craft_table.CraftTable;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CraftTableInventory implements IInventory {

	private CraftTable.BlockCraftTable current;//Предмет в котором будет хранить вещи
	private ItemStack[] inventory;//Массив слотов инвентаря в виде ItemStack
	/*
	public CraftTableInventory(ItemStack is) {
		if (!is.hasTagCompound()) is.setTagCompound(new NBTTagCompound());
		current = is;
	}
	 */
	@SideOnly(Side.CLIENT)
	public CraftTableInventory(int x, int y, int z) {
		CraftTable.BlockCraftTable bct = CraftTable.getCraftTableClient();
		//if (bct == null) return;
		current = bct;
		inventory = bct.inv;
	}

	public CraftTableInventory(World world, int x, int y, int z) {
		CraftTable.BlockCraftTable bct = CraftTable.get(world).getCraftTable(x, y, z);
		//if (bct == null) return;
		current = bct;
		inventory = bct.inv;
	}

	public CraftTableInventory(CraftTable.BlockCraftTable bct) {
		//if (bct == null) return;
		current = bct;
		inventory = bct.inv;
	}

	@Override
	public int getSizeInventory() {
		return inventory.length;//Количество слотов инвентаря
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return slot >= 0 && slot < inventory.length ? inventory[slot] : null;
	}

	@Override
	public ItemStack decrStackSize(int slot, int amount) {
		if (inventory[slot] != null) {
			ItemStack is;

			if (inventory[slot].stackSize <= amount) {
				is = inventory[slot];
				inventory[slot] = null;
				markDirty();
				return is;
			} else {
				is = inventory[slot].splitStack(amount);
				if (inventory[slot].stackSize == 0) inventory[slot] = null;

				markDirty();
				return is;
			}
		} else return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		if (inventory[slot] != null) {
			ItemStack itemstack = inventory[slot];
			inventory[slot] = null;
			return itemstack;
		} else return null;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack is) {
		inventory[slot] = is;

		if (is != null && is.stackSize > getInventoryStackLimit())
			is.stackSize = getInventoryStackLimit();

		markDirty();
	}

	@Override
	public String getInventoryName() {
		return null/*current.getDisplayName()*/;//Своё имя
	}

	@Override
	public boolean hasCustomInventoryName() {
		return false/*current.hasDisplayName()*/;//Есть-ли своё имя
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;//Лимит размер стака в слоте
	}

	@Override
	public void markDirty() {
		//У меня этот метод от 3 и более раза за раз вызывается, так-что я с ним ни чего не делаю.
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		//Может-ли игрок использовать этот инвентарь
		return player.getDistanceSq((double)current.x + 0.5D, (double)current.y + 0.5D, (double)current.z + 0.5D) <= 64.0D;
	}

	//Открытие инвентаря
	@Override
	public void openInventory() {

	}

	//Закрытие инвентаря
	@Override
	public void closeInventory() {

	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack is) {
		//Можно-ли взаимодействовать со слотом(-ами).
		return true;
	}

}
