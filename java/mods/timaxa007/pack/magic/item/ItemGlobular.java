package mods.timaxa007.pack.magic.item;

import java.util.List;

import mods.timaxa007.pack.magic.PackMagic;
import mods.timaxa007.tms.util.ModifiedItem;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemGlobular extends ModifiedItem {

	@SideOnly(Side.CLIENT) private IIcon icon_overlay;

	public ItemGlobular(String tag) {
		super(tag);
		setCreativeTab(PackMagic.tab_magic);
		setTextureName("timaxa007:test_item");
	}

	public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer player) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null && nbt.hasKey("Active")) {
			nbt.setBoolean("Active", nbt.getBoolean("Active") ? false : true);
			is.setTagCompound(nbt);
			return is;
		}/* else {
			--is.stackSize;
			addNBT();
		}*/
		return is;
	}

	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null) {
			if (nbt.hasKey("Active")) list.add("Active: " + nbt.getBoolean("Active") + ".");
		}
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item id, CreativeTabs table, List list) {
		list.add(addNBT());
	}

	public static ItemStack addNBT() {
		ItemStack is = new ItemStack(PackMagic.proxy.item.globular, 1, 0);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setBoolean("Active", false);
		is.setTagCompound(nbt);
		return is;
	}

	@SideOnly(Side.CLIENT)
	public boolean requiresMultipleRenderPasses() {
		return true;
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(ItemStack is, int pass) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null && nbt.hasKey("Active")) {

			if (pass == 0) {
				return nbt.getBoolean("Active")?icon_overlay:itemIcon;
			} else {
				return itemIcon;
			}

		} else {
			return getIconFromDamageForRenderPass(is.getItemDamage(), pass);
		}
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister ir) {
		super.registerIcons(ir);
		//itemIcon = ir.registerIcon("timaxa007:testItem1");
		icon_overlay = ir.registerIcon(getIconString() + "_overlay");
	}

}
