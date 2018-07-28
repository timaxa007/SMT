package smt.pack.technology.item;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants.NBT;
import smt.pack.technology.SMTTechnology;
import smt.pack.technology.api.IItemEIM;
import smt.pack.technology.client.gui.ItemTelephoneGui;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTelephone extends Item implements IItemEIM {

	public ItemTelephone() {
		super();
		setMaxDamage(128);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		Minecraft mc = Minecraft.getMinecraft();
		mc.displayGuiScreen(new ItemTelephoneGui(itemStack));
		return super.onItemRightClick(itemStack, world, player);
	}

	@Override
	public boolean onEntityItemUpdate(EntityItem entityItem) {
		ItemStack item = entityItem.getEntityItem();
		if (item != null && item.getItem() instanceof IItemEIM) {

		}
		return false;
	}

	@Override
	public boolean hasEIM(ItemStack itemStack) {
		NBTTagCompound nbt = itemStack.getTagCompound();
		if (nbt == null) return false;
		if (nbt.hasKey("EIM")) return true;
		return false;
	}

	@Override
	public boolean callEIM(ItemStack itemStack, int findID) {
		NBTTagCompound nbt = itemStack.getTagCompound();
		if (nbt == null) return false;
		if (nbt.hasKey("EIM", NBT.TAG_COMPOUND)) {
			NBTTagCompound nbtTagCompound  = nbt.getCompoundTag("EIM");
			if (nbtTagCompound.hasKey("ID", NBT.TAG_INT)) {
				if (nbtTagCompound.getInteger("ID") == findID) return true;
			}
		}
		return false;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void getSubItems(Item item, CreativeTabs tab, List list) {
		list.add(addNBT(new ItemStack(item), -1));
		list.add(addNBT(new ItemStack(item), 1234));
	}

	public ItemStack addNBT(ItemStack itemStack) {
		if (itemStack == null) itemStack = new ItemStack(this);
		NBTTagCompound nbt = itemStack.getTagCompound();
		if (nbt == null) nbt = new NBTTagCompound();
		itemStack.setTagCompound(nbt);
		return itemStack;
	}

	public ItemStack addNBT(ItemStack itemStack, int id) {
		if (itemStack == null) itemStack = new ItemStack(this);
		NBTTagCompound nbt = itemStack.getTagCompound();
		if (nbt == null) nbt = new NBTTagCompound();
		//
		NBTTagCompound nbtTagCompound  = new NBTTagCompound();
		nbtTagCompound.setInteger("ID", id);
		nbt.setTag("EIM", nbtTagCompound);
		//
		itemStack.setTagCompound(nbt);
		return itemStack;
	}

}
