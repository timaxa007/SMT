package smt.pack.phytology.item;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import smt.pack.phytology.world.ActBoss;
import smt.pack.phytology.world.WorldGenTwoTree;

public class ItemFeed extends Item {

	public ItemFeed() {
		super();
	}

	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		if (!world.isRemote) {
			WorldGenTwoTree gen = new WorldGenTwoTree();
			gen.generate(world, world.rand, x, y + 1, z);
			ActBoss.setBoundingBox(gen.getBoundingBox());
		}
		return true;
	}

	@Override
	public boolean itemInteractionForEntity(ItemStack itemStack, EntityPlayer player, EntityLivingBase entity) {
		if (entity instanceof EntityAnimal) {
			((EntityAnimal)entity).func_146082_f(player);
			return true;
		}
		return false;
	}

}
