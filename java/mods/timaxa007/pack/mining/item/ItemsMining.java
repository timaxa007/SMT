package mods.timaxa007.pack.mining.item;

import mods.timaxa007.pack.mining.PackMining;
import mods.timaxa007.tms.util.ModifiedItem;

public class ItemsMining extends ModifiedItem {

	public ItemsMining(String tag) {
		super(tag);
		setCreativeTab(PackMining.tab_mining);
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
