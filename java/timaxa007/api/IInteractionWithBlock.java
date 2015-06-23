package timaxa007.api;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface IInteractionWithBlock {

	public void interactionWithBlock(ItemStack is, World world, EntityPlayer player, int x, int y, int z);

}
