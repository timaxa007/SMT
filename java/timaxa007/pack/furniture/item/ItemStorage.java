package timaxa007.pack.furniture.item;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import timaxa007.api.IItemStorage;
import timaxa007.gui.HandlerGuiSMT;
import timaxa007.pack.furniture.PackFurniture;
import timaxa007.smt.object.ModifiedItem;
import timaxa007.smt.util.UtilString;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemStorage extends ModifiedItem implements IItemStorage {

	public ItemStorage(String tag) {
		super(tag);
		setMaxStackSize(1);
		setNoRepair();
		setCreativeTab(PackFurniture.tab_furniture);
		setTextureName("timaxa007:storage");
	}

	@Override
	public void onUpdate(ItemStack is, World world, Entity entity, int tick, boolean flag) {
		if (!world.isRemote && entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)entity;
		}
	}

	public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer player) {
		if (player.isSneaking()) {

		} else {
			HandlerGuiSMT.openContainer(HandlerGuiSMT.GuiID.ITEM_STORAGE, player, true);
		}
		return super.onItemRightClick(is, world, player);
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item id, CreativeTabs table, List list) {
		//list.add(new ItemStack(id, 1, 0));
		list.add(addNBT(id, size_storage.SIZE1));
		list.add(addNBT(id, size_storage.SIZE2));
		list.add(addNBT(id, size_storage.SIZE3));
		list.add(addNBT(id, size_storage.SIZE4));
		list.add(addNBT(id, size_storage.SIZE5));
		list.add(addNBT(id, size_storage.SIZE6));
		list.add(addNBT(id, size_storage.SIZE7));
		list.add(addNBT(id, size_storage.SIZE8));
		list.add(addNBT(id, size_storage.SIZE9));
	}

	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
		NBTTagCompound nbt = is.getTagCompound();
		if (UtilString.isShiftKeyDown()) {
			if (nbt != null) {
				if (nbt.hasKey("CustomSize")) list.add("Slots: " + (int)(nbt.getByte("CustomSize") & 255) + ".");
			}
		} else list.add(UtilString.hldshiftinf);
	}

	public static ItemStack addNBT(Item item, size_storage size) {
		return addNBT(new ItemStack(item, 1, 0), size);
	}

	public static ItemStack addNBT(ItemStack is, size_storage size) {
		return addNBT(is, size.getSize());
	}

	public static ItemStack addNBT(ItemStack is, int size) {
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setByte("CustomSize", (byte)size);
		is.setTagCompound(nbt);
		return is;
	}

	public static enum size_storage {

		SIZE1(9),
		SIZE2(18),
		SIZE3(27),
		SIZE4(36),
		SIZE5(45),
		SIZE6(54),
		SIZE7(63),
		SIZE8(72),
		SIZE9(81);

		private int size;

		size_storage(int size) {
			this.size = size;
		}

		public int getSize() {
			return size;
		}

	}

}
