package timaxa007.pack.item.util;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface IToolCraft {

	public void interactionWichEntity(ItemStack is, World world, EntityPlayer player, Entity entity);
	public void interactionWichEntityBlock(ItemStack is, World world, EntityPlayer player, Block block, int x, int y, int z);

}
