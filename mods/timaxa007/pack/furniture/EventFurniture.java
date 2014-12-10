package mods.timaxa007.pack.furniture;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public class EventFurniture {
//--------------------------------------------------------------------------------------------------------------
@ForgeSubscribe
public void addNewBottle(PlayerInteractEvent event) {
EntityPlayer player = event.entityPlayer;
World world = player.worldObj;
ItemStack current = player.getCurrentEquippedItem();
if (player != null && world != null && event.action == event.action.RIGHT_CLICK_BLOCK) {
if (current != null && current.getItem() == Item.glassBottle && world.getBlock(event.x, event.y, event.z) == Block.stone.blockID) {
--current.stackSize;
//player.inventory.addItemStackToInventory(new ItemStack(PackStock.proxy.item_drinks, 1, 0));
event.setResult(Result.ALLOW);
}
}
}
//--------------------------------------------------------------------------------------------------------------
}
