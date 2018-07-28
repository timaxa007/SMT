package smt.pack.technology.item;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import smt.pack.technology.SMTTechnology;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemElectricPower extends smt.pack.technology.api.object.ItemElectricDummy {

	public ItemElectricPower() {
		super();
		setMaxDamage(1000);
		setMaxStackSize(1);
	}

	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean flag) {
		if (isTagEPT(itemStack)) {
			NBTTagCompound eet = checkEPT(itemStack);
			if (getEnergy(itemStack) >= 0) {
				String text = "Energy: " + getEnergy(itemStack);
				if (getEnergyMax(itemStack) >= 0) 
					text += " / " + getEnergyMax(itemStack);
				list.add(text + ".");
			}
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void getSubItems(Item id, CreativeTabs table, List list) {
		list.add(addNBT(id, 0, 1000));
		list.add(addNBT(id, 0, 10000));
		list.add(addNBT(id, 0, 100000));
		list.add(addNBT(id, 1000, 1000));
		list.add(addNBT(id, 10000, 10000));
	}

	public ItemStack addNBT(Item id, int i, int max) {
		return setEnergyMax(new ItemStack(id), i, max);
	}

	@Override
	public int getRateMax() {
		return 7;//For testing
	}

	@Override
	public boolean isCharging(ItemStack item) {
		return true;
	}

	@Override
	public boolean isDischarging(ItemStack item) {
		return true;
	}

}
