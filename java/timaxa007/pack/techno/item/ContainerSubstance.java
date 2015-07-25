package timaxa007.pack.techno.item;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import timaxa007.module.substance.util.Substance;
import timaxa007.module.substance.util.RegistrySubstance;
import timaxa007.pack.stock.PackStock;
import timaxa007.pack.stock.item.ItemDrinks.drinks;
import timaxa007.pack.techno.PackTechno;
import timaxa007.smt.object.ModifiedItem;
import timaxa007.smt.util.UtilString;

public class ContainerSubstance extends ModifiedItem {

	public ContainerSubstance(String tag) {
		super(tag);
		setCreativeTab(PackTechno.tab_container_fluid);
	}

	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
		NBTTagCompound nbt = is.getTagCompound();
		if (UtilString.isShiftKeyDown()) {
			if (nbt != null) {

				if (nbt.hasKey("SubstanceTag")) {
					Substance fluid = RegistrySubstance.getSubstance(nbt.getString("SubstanceTag"));
					list.add(fluid.getLocalizedName() + ".");
				}

			}
		} else list.add(UtilString.hldshiftinf);
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item id, CreativeTabs table, List list) {
		List lst = RegistrySubstance.getListSubstance();
		for (int i = 0; i < lst.size(); ++i) {
			if (lst.get(i) != null) {
				Substance fluid = RegistrySubstance.getSubstance(lst.get(i).toString());
				if (RegistrySubstance.hasSubstance(fluid))
					list.add(addNBT(fluid.getTag()));
			}
		}
	}

	public static ItemStack addNBT(String par2) {
		ItemStack is = new ItemStack(PackTechno.item.container_fluid);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setString("SubstanceTag", par2);
		is.setTagCompound(nbt);
		return is;
	}

}
