package smt.pack.technology.block;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.Constants.NBT;

public class ItemBlockElectricMachine extends ItemBlock {

	public ItemBlockElectricMachine(Block block) {
		super(block);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean isAdv) {
		NBTTagCompound nbt = itemStack.getTagCompound();
		if (nbt != null && nbt.hasKey("ElectricMachine", NBT.TAG_STRING))
			list.add("ElectricMachine - " + nbt.getString("ElectricMachine") + ".");
		else
			list.add("ElectricMachine - empty.");
	}

}
