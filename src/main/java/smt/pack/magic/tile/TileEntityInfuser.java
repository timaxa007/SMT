package smt.pack.magic.tile;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import smt.pack.decorative.tile.TileEntityStand;
import smt.pack.magic.api.InfuserRecipes;

public class TileEntityInfuser extends TileEntity implements IInventory {

	final InventoryBasic inventory = new InventoryBasic("infuser", false, 1);
	public static final InfuserRecipes recipes = new InfuserRecipes();
	public InfuserRecipes.Recipe recipe = null;
	int time = 0;

	public TileEntityInfuser() {

	}

	public void updateEntity() {

		if (inventory.getStackInSlot(0) != null) {
			System.out.println("drop");
			EntityItem ei = new EntityItem(worldObj, xCoord + 0.5, yCoord + 1.5, zCoord + 0.5, inventory.getStackInSlot(0).copy());
			ei.delayBeforeCanPickup = 20;
			if (!worldObj.isRemote) worldObj.spawnEntityInWorld(ei);
			inventory.setInventorySlotContents(0, null);
		}

		if (time <= 0 && recipe != null && inventory.getStackInSlot(0) == null) finish();

		if (time > 0) --time;

	}

	public void onBlockActivated() {
		System.out.println("onBlockActivated");
		if (recipe != null) {
			recipe = null;
			time = 0;
		} else {
			ItemStack[] arr = new ItemStack[8];

			TileEntity tile_stand0 = worldObj.getTileEntity(xCoord - 2, yCoord, zCoord - 2);
			if (tile_stand0 instanceof TileEntityStand)
				arr[0] =((TileEntityStand)tile_stand0).getItemStack();

			TileEntity tile_stand1 = worldObj.getTileEntity(xCoord, yCoord, zCoord - 2);
			if (tile_stand1 instanceof TileEntityStand)
				arr[1] =((TileEntityStand)tile_stand1).getItemStack();

			TileEntity tile_stand2 = worldObj.getTileEntity(xCoord + 2, yCoord, zCoord - 2);
			if (tile_stand2 instanceof TileEntityStand)
				arr[2] =((TileEntityStand)tile_stand2).getItemStack();

			TileEntity tile_stand3 = worldObj.getTileEntity(xCoord - 2, yCoord, zCoord);
			if (tile_stand3 instanceof TileEntityStand)
				arr[3] =((TileEntityStand)tile_stand3).getItemStack();

			TileEntity tile_stand4 = worldObj.getTileEntity(xCoord + 2, yCoord, zCoord);
			if (tile_stand4 instanceof TileEntityStand)
				arr[4] =((TileEntityStand)tile_stand4).getItemStack();

			TileEntity tile_stand5 = worldObj.getTileEntity(xCoord - 2, yCoord, zCoord + 2);
			if (tile_stand5 instanceof TileEntityStand)
				arr[5] =((TileEntityStand)tile_stand5).getItemStack();

			TileEntity tile_stand6 = worldObj.getTileEntity(xCoord, yCoord, zCoord + 2);
			if (tile_stand6 instanceof TileEntityStand)
				arr[6] =((TileEntityStand)tile_stand6).getItemStack();

			TileEntity tile_stand7 = worldObj.getTileEntity(xCoord + 2, yCoord, zCoord + 2);
			if (tile_stand7 instanceof TileEntityStand)
				arr[7] =((TileEntityStand)tile_stand7).getItemStack();

			recipe = recipes.findRecipe(arr);

			if (recipe != null) {
				time = recipe.time;
				System.out.println(time);
			}
		}
	}

	public void finish() {
		System.out.println("finish");
		ItemStack[] arr = new ItemStack[8];

		TileEntity tile_stand0 = worldObj.getTileEntity(xCoord - 2, yCoord, zCoord - 2);
		if (tile_stand0 instanceof TileEntityStand)
			arr[0] =((TileEntityStand)tile_stand0).getItemStack();

		TileEntity tile_stand1 = worldObj.getTileEntity(xCoord, yCoord, zCoord - 2);
		if (tile_stand1 instanceof TileEntityStand)
			arr[1] =((TileEntityStand)tile_stand1).getItemStack();

		TileEntity tile_stand2 = worldObj.getTileEntity(xCoord + 2, yCoord, zCoord - 2);
		if (tile_stand2 instanceof TileEntityStand)
			arr[2] =((TileEntityStand)tile_stand2).getItemStack();

		TileEntity tile_stand3 = worldObj.getTileEntity(xCoord - 2, yCoord, zCoord);
		if (tile_stand3 instanceof TileEntityStand)
			arr[3] =((TileEntityStand)tile_stand3).getItemStack();

		TileEntity tile_stand4 = worldObj.getTileEntity(xCoord + 2, yCoord, zCoord);
		if (tile_stand4 instanceof TileEntityStand)
			arr[4] =((TileEntityStand)tile_stand4).getItemStack();

		TileEntity tile_stand5 = worldObj.getTileEntity(xCoord - 2, yCoord, zCoord + 2);
		if (tile_stand5 instanceof TileEntityStand)
			arr[5] =((TileEntityStand)tile_stand5).getItemStack();

		TileEntity tile_stand6 = worldObj.getTileEntity(xCoord, yCoord, zCoord + 2);
		if (tile_stand6 instanceof TileEntityStand)
			arr[6] =((TileEntityStand)tile_stand6).getItemStack();

		TileEntity tile_stand7 = worldObj.getTileEntity(xCoord + 2, yCoord, zCoord + 2);
		if (tile_stand7 instanceof TileEntityStand)
			arr[7] =((TileEntityStand)tile_stand7).getItemStack();

		InfuserRecipes.Recipe recipe = recipes.findRecipe(arr);
		if (this.recipe == recipe) {
			inventory.setInventorySlotContents(0, recipe.output.copy());
			((TileEntityStand)tile_stand0).getInventory().setInventorySlotContents(0, null);
			((TileEntityStand)tile_stand1).getInventory().setInventorySlotContents(0, null);
			((TileEntityStand)tile_stand2).getInventory().setInventorySlotContents(0, null);
			((TileEntityStand)tile_stand3).getInventory().setInventorySlotContents(0, null);
			((TileEntityStand)tile_stand4).getInventory().setInventorySlotContents(0, null);
			((TileEntityStand)tile_stand5).getInventory().setInventorySlotContents(0, null);
			((TileEntityStand)tile_stand6).getInventory().setInventorySlotContents(0, null);
			((TileEntityStand)tile_stand7).getInventory().setInventorySlotContents(0, null);
		}

		this.recipe = null;
	}

	@Override
	public void markDirty() {
		super.markDirty();
		inventory.markDirty();
	}

	@Override
	public int getSizeInventory() {
		return inventory.getSizeInventory();
	}

	@Override
	public ItemStack getStackInSlot(int slot_i) {
		return inventory.getStackInSlot(slot_i);
	}

	@Override
	public ItemStack decrStackSize(int slot_i, int stackSize) {
		return inventory.decrStackSize(slot_i, stackSize);
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot_i) {
		return inventory.getStackInSlotOnClosing(slot_i);
	}

	@Override
	public void setInventorySlotContents(int slot_i, ItemStack itemStack) {
		inventory.setInventorySlotContents(slot_i, itemStack);
	}

	@Override
	public String getInventoryName() {
		return inventory.getInventoryName();
	}

	@Override
	public boolean hasCustomInventoryName() {
		return inventory.hasCustomInventoryName();
	}

	@Override
	public int getInventoryStackLimit() {
		return inventory.getInventoryStackLimit();
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return inventory.isUseableByPlayer(player);
	}

	@Override
	public void openInventory() {
		inventory.openInventory();
	}

	@Override
	public void closeInventory() {
		inventory.closeInventory();
	}

	@Override
	public boolean isItemValidForSlot(int slot_i, ItemStack itemStack) {
		return inventory.isItemValidForSlot(slot_i, itemStack);
	}

}
