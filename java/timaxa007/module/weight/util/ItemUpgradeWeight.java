package timaxa007.module.weight.util;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import timaxa007.module.weight.NodeWeight;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemUpgradeWeight extends Item {

	public ItemUpgradeWeight() {
		super();
		setCreativeTab(CreativeTabs.tabMisc);
		setHasSubtypes(true);
		setMaxDamage(0);
		setTextureName("weight:upgrades_weights");
		setUnlocalizedName("upgrades_weights");
	}

	public String getUnlocalizedName(ItemStack is) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null && nbt.hasKey("WeightUp")) {
			if (nbt.getShort("WeightUp") < (short)0)
				return "item.meter";
			else if (nbt.getShort("WeightUp") == (short)0)
				return "item.take.upgrades_weights";
		}
		return super.getUnlocalizedName();
	}

	public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer player) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt == null) nbt = new NBTTagCompound();

		if (PlayerWeight.get(player) != null) {

			float get_weight_max = PlayerWeight.get(player).getWeightMax();

			if (nbt != null && nbt.hasKey("WeightUp")) {
				if (nbt.getShort("WeightUp") > (short)0) {
					PlayerWeight.get(player).addWeightMax((float)nbt.getShort("WeightUp"));
					if (!player.capabilities.isCreativeMode) --is.stackSize;
				} else if (nbt.getShort("WeightUp") == (short)0) {
					if (get_weight_max >= 60.0F && get_weight_max <= 30000.0F) {
						short weight_down = (short)(get_weight_max - 60.0F);
						player.inventory.addItemStackToInventory(addNBT(weight_down));
						PlayerWeight.get(player).addWeightMax(-weight_down);
					}
				} else if (nbt.getShort("WeightUp") < (short)0) {
					if (world.isRemote) player.addChatMessage(new ChatComponentText(
							StatCollector.translateToLocal("text.get_weight") + ": " + 
									SystemWeight.sendInventory(player) + " / " + 
									StatCollector.translateToLocal("text.get_weight_max") + ": " + get_weight_max + ".")
							);
				}
			}
		}

		return is;
	}

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null && nbt.hasKey("WeightUp") && nbt.getShort("WeightUp") > (short)0)
			list.add(StatCollector.translateToLocal("text.add_weight") + ": +" + nbt.getShort("WeightUp") + ".");
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item id, CreativeTabs table, List list) {
		list.add(addNBT((short)-1));
		list.add(addNBT((short)0));
		list.add(addNBT((short)1));
		list.add(addNBT((short)2));
		list.add(addNBT((short)3));
		list.add(addNBT((short)4));
		list.add(addNBT((short)5));
		list.add(addNBT((short)10));
		list.add(addNBT((short)25));
		list.add(addNBT((short)50));
		list.add(addNBT((short)100));
		list.add(addNBT((short)500));
		list.add(addNBT((short)1000));
		list.add(addNBT((short)5000));
		list.add(addNBT((short)10000));
		list.add(addNBT((short)20000));
		list.add(addNBT((short)30000));
		//list.add(new ItemStack(id, 1, 0));
	}

	public static ItemStack addNBT(short i) {
		ItemStack is = new ItemStack(NodeWeight.upgradeWeight);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setShort("WeightUp", i);
		is.setTagCompound(nbt);
		return is;
	}

}
