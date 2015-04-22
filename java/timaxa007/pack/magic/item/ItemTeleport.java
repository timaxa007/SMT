package timaxa007.pack.magic.item;

import java.util.List;

import timaxa007.pack.magic.PackMagic;
import timaxa007.tms.object.ModifiedItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTeleport extends ModifiedItem {

	public ItemTeleport(String tag) {
		super(tag);
		setCreativeTab(PackMagic.tab_magic);
		setHasSubtypes(true);
		setMaxDamage(0);
	}

	public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer player) {
		NBTTagCompound nbt = is.getTagCompound();
		if (player.worldObj.provider.isSurfaceWorld()) {
			if (nbt == null) {
				--is.stackSize;
				player.inventory.addItemStackToInventory(addNBT(player.posX, player.posY, player.posZ));
			} else {
				if (nbt.hasKey("CordX") && nbt.hasKey("CordY") && nbt.hasKey("CordZ")) {
					player.setPosition(nbt.getDouble("CordX"), nbt.getDouble("CordY") + 2.0D, nbt.getDouble("CordZ"));
				}
			}
		}
		return super.onItemRightClick(is, world, player);
	}

	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null && nbt.hasKey("CordX") && nbt.hasKey("CordY") && nbt.hasKey("CordZ")) {
			list.add("CordX - " + nbt.getDouble("CordX") + ", CordY - " + nbt.getDouble("CordY") + ", CordZ - " + nbt.getDouble("CordXZ"));
		}
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item id, CreativeTabs table, List list) {
		list.add(new ItemStack(id, 1, 0));
	}

	public static ItemStack addNBT(double x, double y, double z) {
		ItemStack is = new ItemStack(PackMagic.item.teleport, 1, 0);
		NBTTagCompound nbt = new NBTTagCompound();
		//nbt.setBoolean("SurfaceWorld", true);
		nbt.setDouble("CordX", x);
		nbt.setDouble("CordY", y);
		nbt.setDouble("CordZ", z);
		is.setTagCompound(nbt);
		return is;
	}

}
