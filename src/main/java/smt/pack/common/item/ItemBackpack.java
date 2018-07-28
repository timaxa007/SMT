package smt.pack.common.item;

import java.util.HashMap;
import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import smt.pack.common.SMTCommon;
import smt.pack.common.inventory.GuiID;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBackpack extends Item implements smt.pack.common.api.IRegisterItem, smt.pack.common.api.IItemStorage {

	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		if (player.isSneaking()) {

		} else {
			SMTCommon.proxy.openGui(GuiID.BACKPACK, player);
		}
		return super.onItemRightClick(itemStack, world, player);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void getSubItems(Item id, CreativeTabs table, List list) {
		//list.add(new ItemStack(id, 1, 0));
		list.add(addNBT(new ItemStack(id, 1, 0), 1));
		list.add(addNBT(new ItemStack(id, 1, 0), 3));
		list.add(addNBT(id, SizeStorage.SIZE1));
		list.add(addNBT(id, SizeStorage.SIZE2));
		list.add(addNBT(id, SizeStorage.SIZE3));
		list.add(addNBT(id, SizeStorage.SIZE4));
		list.add(addNBT(id, SizeStorage.SIZE5));
		list.add(addNBT(id, SizeStorage.SIZE6));
		list.add(addNBT(id, SizeStorage.SIZE7));
		list.add(addNBT(id, SizeStorage.SIZE8));
		list.add(addNBT(id, SizeStorage.SIZE9));
	}

	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean flag) {
		NBTTagCompound nbt = itemStack.getTagCompound();
		if (nbt != null && nbt.hasKey("CustomSize")) list.add("Slots: " + (int)(nbt.getByte("CustomSize") & 255) + ".");
	}

	public static ItemStack addNBT(Item item, SizeStorage size) {
		return addNBT(new ItemStack(item, 1, 0), size);
	}

	public static ItemStack addNBT(ItemStack itemStack, SizeStorage size) {
		return addNBT(itemStack, size.getSize());
	}

	public static ItemStack addNBT(ItemStack itemStack, int size) {
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setByte("CustomSize", (byte)size);
		itemStack.setTagCompound(nbt);
		return itemStack;
	}

	public static enum SizeStorage {

		SIZE1(9),//(9 * 1)
		SIZE2(18),//(9 * 2)
		SIZE3(27),//(9 * 3)//размеры как у одинарного сундука
		SIZE4(36),//(9 * 4)
		SIZE5(45),//(9 * 5)
		SIZE6(54),//(9 * 6)//размеры как у двойного сундука
		SIZE7(63),//(9 * 7)
		SIZE8(72),//(9 * 8)
		SIZE9(81);//(9 * 9)

		private final int size;

		SizeStorage(int size) {
			this.size = size;
		}

		public int getSize() {
			return size;
		}

	}

	@Override
	public String getRegisterName() {
		return "item_backpack";
	}

	@Override
	public void getRegisterItem(final HashMap<String, ItemStack> map) {
		map.put(getRegisterName() + "_size1", addNBT(this, SizeStorage.SIZE1));
		map.put(getRegisterName() + "_size2", addNBT(this, SizeStorage.SIZE2));
		map.put(getRegisterName() + "_size3", addNBT(this, SizeStorage.SIZE3));
		map.put(getRegisterName() + "_size4", addNBT(this, SizeStorage.SIZE4));
		map.put(getRegisterName() + "_size5", addNBT(this, SizeStorage.SIZE5));
		map.put(getRegisterName() + "_size6", addNBT(this, SizeStorage.SIZE6));
		map.put(getRegisterName() + "_size7", addNBT(this, SizeStorage.SIZE7));
		map.put(getRegisterName() + "_size8", addNBT(this, SizeStorage.SIZE8));
		map.put(getRegisterName() + "_size9", addNBT(this, SizeStorage.SIZE9));
	}

}
