package smt.pack.common.item;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import smt.pack.common.SMTCommon;

import java.util.HashMap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSword extends Item implements smt.pack.common.api.IRegisterItem {

	@Override
	public boolean func_150897_b(Block block) {
		return block == Blocks.bedrock;
	}

	@Override
	public float func_150893_a(ItemStack itemStack, Block block) {
		return block == Blocks.bedrock ? 999F : func_150893_a(itemStack, block);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public boolean isFull3D() {
		return true;
	}

	@Override
	public EnumAction getItemUseAction(ItemStack itemStack) {
		return EnumAction.block;
	}

	@Override
	public int getMaxItemUseDuration(ItemStack itemStack) {
		return 72000;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		player.setItemInUse(itemStack, getMaxItemUseDuration(itemStack));
		return itemStack;
	}

	@Override
	public String getRegisterName() {
		return "item_sword";
	}

	@Override
	public void getRegisterItem(final HashMap<String, ItemStack> map) {
		map.put(getRegisterName(), new ItemStack(this));
	}

}
