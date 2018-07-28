package smt.pack.magic.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.storage.WorldInfo;
import smt.pack.magic.SMTMagic;

public class ItemArtifact extends Item {

	public ItemArtifact() {
		super();
	}

	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		//
		int i = 18000;
		//net.minecraft.command.CommandWeather
		WorldInfo worldinfo = world.getWorldInfo();
		//if ("clear".equalsIgnoreCase(p_71515_2_[0])) {
		worldinfo.setRainTime(0);
		worldinfo.setThunderTime(0);
		worldinfo.setRaining(false);
		worldinfo.setThundering(false);
		//} else if ("rain".equalsIgnoreCase(p_71515_2_[0])) {
		worldinfo.setRainTime(i);
		worldinfo.setRaining(true);
		worldinfo.setThundering(false);
		//if (!"thunder".equalsIgnoreCase(p_71515_2_[0])) {
		worldinfo.setRainTime(i);
		worldinfo.setThunderTime(i);
		worldinfo.setRaining(true);
		worldinfo.setThundering(true);

		world.setWorldTime(world.getWorldTime() + 20L); 
		//
		if (player.canEat(false)) {
			player.setHealth(player.getHealth() - 1F);//to damage Source
			player.getFoodStats().addStats(1, 0F);
		}
		//
		ItemDye.applyBonemeal(itemStack, world, x, y, z, player);//stackSize-- to damageItem
		//
		return true;
	}

}
