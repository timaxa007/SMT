package mods.timaxa007.pack.mining.item;

import mods.timaxa007.pack.mining.PackMining;
import net.minecraft.item.Item;

public class ItemsMining extends Item {

	public ItemsMining() {
		super();
		setCreativeTab(PackMining.tab_mining);
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
