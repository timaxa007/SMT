package timaxa007.pack.conjoint.api;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface IInteractionWithEntity {

	public void interactionWithEntity(ItemStack is, World world, EntityPlayer player, Entity entity);

}
