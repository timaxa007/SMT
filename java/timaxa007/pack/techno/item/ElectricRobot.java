package timaxa007.pack.techno.item;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import timaxa007.pack.techno.PackTechno;
import timaxa007.pack.techno.entity.EntityElectricRobot;
import timaxa007.smt.object.ModifiedItem;
import timaxa007.smt.util.UtilString;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ElectricRobot extends ModifiedItem {

	public ElectricRobot(String tag) {
		super(tag);
		setCreativeTab(PackTechno.tab_techno);
	}

	public boolean onItemUse(ItemStack is, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		if (!player.canPlayerEdit(x, y, z, side, is)) return false;
		else {
			NBTTagCompound nbt = is.getTagCompound();

			if (nbt != null) {
				if (!world.isRemote) {
					EntityElectricRobot robot = new EntityElectricRobot(world);
					robot.setPosition((double)x + 0.5D, (double)y + 1.5D, (double)z + 0.5D);

					if (nbt.hasKey("TierRobot")) robot.setTier((int)nbt.getByte("TierRobot"));

					world.spawnEntityInWorld(robot);
					if (!player.capabilities.isCreativeMode) --is.stackSize;
					return true;
				}
			}

		}
		return super.onItemUse(is, player, world, x, y, z, side, hitX, hitY, hitZ);
	}

	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
		NBTTagCompound nbt = is.getTagCompound();
		if (UtilString.isShiftKeyDown()) {
			if (nbt != null) {
				if (nbt.hasKey("TierRobot")) list.add("Tier Robot: " + (int)nbt.getByte("TierRobot") + ".");
			}
		} else list.add(UtilString.hldshiftinf);
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item id, CreativeTabs table, List list) {
		list.add(new ItemStack(id));
		list.add(addNBT(0));
		list.add(addNBT(1));
		list.add(addNBT(2));
	}

	public static ItemStack addNBT(int tier) {
		ItemStack is = new ItemStack(PackTechno.item.electric_robot);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setByte("TierRobot", (byte)tier);
		is.setTagCompound(nbt);
		return is;
	}

}
