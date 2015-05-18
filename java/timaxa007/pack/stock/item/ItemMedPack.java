package timaxa007.pack.stock.item;

import timaxa007.pack.stock.PackStock;
import timaxa007.smt.object.ModifiedItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemMedPack extends ModifiedItem {

	public ItemMedPack(String tag) {
		super(tag);
		setCreativeTab(PackStock.tab_medical);
		setHasSubtypes(true);
		setMaxDamage(0);
		setMaxStackSize(1);
		setTextureName("timaxa007:medpack");
	}

	public ItemStack onEaten(ItemStack is, World world, EntityPlayer player) {
		if (!player.capabilities.isCreativeMode) --is.stackSize;
		if (!world.isRemote) {
			//player.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(1000.0D);
		}
		return is;
	}

	public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer player) {
		player.setItemInUse(is, getMaxItemUseDuration(is));
		world.playSound(player.posX, player.posY, player.posZ, "timaxa007:vodka", 1.0F, 1.0F, true);
		return super.onItemRightClick(is, world, player);
	}

	public int getMaxItemUseDuration(ItemStack is) {
		return 64;
	}

	public EnumAction getItemUseAction(ItemStack is) {
		return EnumAction.block;
	}

}
