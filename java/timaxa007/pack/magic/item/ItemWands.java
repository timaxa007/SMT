package timaxa007.pack.magic.item;

import java.util.List;

import timaxa007.pack.magic.PackMagic;
import timaxa007.smt.object.ModifiedItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemWands extends ModifiedItem {

	public ItemWands(String tag) {
		super(tag);
		setCreativeTab(PackMagic.tab_magic);
		setTextureName("timaxa007:wands");
		setFull3D();
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item id, CreativeTabs table, List list) {
		for (int j1 = 0; j1 < 4; ++j1) {
			for (int j2 = 0; j2 < 4; ++j2) {
				list.add(addNBT(j1, j2));
			}
		}
		//list.add(new ItemStack(id, 1, 0));
	}

	public static ItemStack addNBT(int par1, int par2) {
		ItemStack is = new ItemStack(PackMagic.item.wands);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setInteger("Type", par1);
		nbt.setInteger("Cap", par2);
		is.setTagCompound(nbt);
		return is;
	}

}
