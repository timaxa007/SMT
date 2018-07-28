package smt.pack.privacy.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants.NBT;
import smt.pack.privacy.SMTPrivacy;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemItemsPrivacy extends Item {

	public ItemItemsPrivacy() {
		super();
	}

	@Override
	public void onCreated(ItemStack itemStack, World world, EntityPlayer player) {
		NBTTagCompound nbt = itemStack.getTagCompound();
		if (nbt == null) nbt = new NBTTagCompound();
		nbt.setString("own", player.getCommandSenderName());
		itemStack.setTagCompound(nbt);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean flag) {
		NBTTagCompound nbt = itemStack.getTagCompound();
		if (nbt != null) {
			if (nbt.hasKey("own", NBT.TAG_STRING))
				list.add(EnumChatFormatting.GREEN + "Приобрел: " + nbt.getString("own"));
		}
	}

}
