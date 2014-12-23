package mods.timaxa007.pack.magic.item;

import java.util.List;

import mods.timaxa007.pack.magic.PackMagic;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemWands extends Item {

	public ItemWands() {
		super();
		setCreativeTab(PackMagic.tab_magic);
		setTextureName("timaxa007:wands");
		setUnlocalizedName("wands");
		setFull3D();
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item id, CreativeTabs table, List list) {
		for (int j1 = 0; j1 < 4; ++j1) {
			for (int j2 = 0; j2 < 4; ++j2) {
				list.add(addTag(j1, j2));
			}
		}
		//list.add(new ItemStack(id, 1, 0));
	}

	private static ItemStack addTag(int par1, int par2) {
		ItemStack is = new ItemStack(PackMagic.proxy.item.wands);
		NBTTagCompound tag = new NBTTagCompound();
		tag.setInteger("Type", par1);
		tag.setInteger("Cap", par2);
		is.setTagCompound(tag);
		return is;
	}

}
