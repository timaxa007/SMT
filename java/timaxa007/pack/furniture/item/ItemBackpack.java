package timaxa007.pack.furniture.item;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import timaxa007.gui.HelperGui;
import timaxa007.pack.furniture.PackFurniture;
import timaxa007.smt.object.ModifiedItem;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBackpack extends ModifiedItem {

	public ItemBackpack(String tag) {
		super(tag);
		setMaxStackSize(1);
		setCreativeTab(PackFurniture.tab_furniture);
		setTextureName("timaxa007:backpack");
	}

	public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer player) {
		if (player.isSneaking()) {

		} else {
			HelperGui.openGui(HelperGui.GuiID.BACKPACK, player);
		}
		return super.onItemRightClick(is, world, player);
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item id, CreativeTabs table, List list) {
		//list.add(addNBT());
		//list.add(new ItemStack(id, 1, 0));
	}

	private ItemStack addNBT() {
		ItemStack is = new ItemStack(PackFurniture.item.backpack);
		NBTTagCompound nbt = new NBTTagCompound();
		is.setTagCompound(nbt);
		return is;
	}

}
