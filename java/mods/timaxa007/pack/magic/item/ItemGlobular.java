package mods.timaxa007.pack.magic.item;

import java.util.List;

import mods.timaxa007.pack.magic.PackMagic;
import mods.timaxa007.tms.util.ItemFixReg;
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

public class ItemGlobular extends ItemFixReg {

	@SideOnly(Side.CLIENT) private IIcon icon_overlay;

	public ItemGlobular(String tag) {
		super(tag);
		setCreativeTab(PackMagic.tab_magic);
		setTextureName("timaxa007:test_item");
	}

	public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer player) {
		NBTTagCompound tag = is.getTagCompound();
		if (tag != null && tag.hasKey("Active")) {
			tag.setBoolean("Active", tag.getBoolean("Active") ? false : true);
			is.setTagCompound(tag);
			return is;
		}/* else {
			--is.stackSize;
			addTag();
		}*/
		return is;
	}

	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
		NBTTagCompound tag = is.getTagCompound();
		if (tag != null) {
			if (tag.hasKey("Active")) list.add("Active: " + tag.getBoolean("Active") + ".");
		}
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item id, CreativeTabs table, List list) {
		list.add(addTag());
	}

	private static ItemStack addTag() {
		ItemStack is = new ItemStack(PackMagic.proxy.item.globular, 1, 0);
		NBTTagCompound tag = new NBTTagCompound();
		tag.setBoolean("Active", false);
		is.setTagCompound(tag);
		return is;
	}

	@SideOnly(Side.CLIENT)
	public boolean requiresMultipleRenderPasses() {
		return true;
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(ItemStack is, int pass) {
		NBTTagCompound tag = is.getTagCompound();
		if (tag != null && tag.hasKey("Active")) {

			if (pass == 0) {
				return tag.getBoolean("Active")?icon_overlay:itemIcon;
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
