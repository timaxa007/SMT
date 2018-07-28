package smt.pack.decorative.item;

import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import smt.pack.decorative.SMTDecorative;

import com.mojang.authlib.minecraft.MinecraftProfileTexture.Type;

public class ItemItemsDecorative extends Item {

	public ItemItemsDecorative() {
		super();
	}
	/*
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		player.openGui(SMTDecorative.instance, 0, world, 0, 0, 0);
		return super.onItemRightClick(is, world, player);
	}
	 */
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		if (player instanceof AbstractClientPlayer) {
			AbstractClientPlayer acp = (AbstractClientPlayer)player;
			ResourceLocation rl = new ResourceLocation(SMTDecorative.MODID, "textures/skin/my_skin.png");
			acp.func_152121_a(Type.SKIN, rl);
		}
		return super.onItemRightClick(itemStack, world, player);
	}

}
