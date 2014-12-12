package mods.timaxa007.pack.mining.items;

import mods.timaxa007.pack.mining.PackMining;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;

public class ItemsMining extends Item {

public ItemsMining() {
super();
setCreativeTab(PackMining.proxy.tab_mining_pack);
setUnlocalizedName("items_mining");
}
/*
public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer player) {
if (!world.isRemote && player instanceof EntityPlayerMP) {
MinecraftServer minecraftserver = MinecraftServer.getServer();
minecraftserver.getConfigurationManager().transferPlayerToDimension((EntityPlayerMP)player, PackMining.proxy.world_dim_mining_id);
}
return is;
}
*/
}
