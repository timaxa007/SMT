package timaxa007.pack.mining.item;

import timaxa007.pack.mining.PackMining;
import timaxa007.tms.object.ModifiedItem;

public class ItemsMining extends ModifiedItem {

	public ItemsMining(String tag) {
		super(tag);
		setCreativeTab(PackMining.tab_mining);
		setTextureName("timaxa007:icon/mining");
	}
	/*
	public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer player) {
		if (!world.isRemote && player instanceof EntityPlayerMP) {
			MinecraftServer minecraftserver = MinecraftServer.getServer();
			minecraftserver.getConfigurationManager().transferPlayerToDimension((EntityPlayerMP)player, PackMining.world_dim_mining_id);
		}
		return super.onItemRightClick(is, world, player);
	}
	 */
}
