package smt.pack.phytology.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.item.ItemMultiTexture;
import net.minecraft.item.ItemStack;

public class ItemBlockLeaves extends ItemMultiTexture {

	public ItemBlockLeaves(Block block) {
		super(block, block, BlockLeaves.names);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public int getColorFromItemStack(ItemStack itemStack, int pass) {
		return field_150941_b.getRenderColor(itemStack.getItemDamage());
	}

}
