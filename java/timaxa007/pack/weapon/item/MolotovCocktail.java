package timaxa007.pack.weapon.item;

import timaxa007.pack.weapon.PackWeapon;
import timaxa007.smt.object.ModifiedItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class MolotovCocktail extends ModifiedItem {

	public MolotovCocktail(String tag) {
		super(tag);
		setCreativeTab(PackWeapon.tab_weapons);
		setTextureName("timaxa007:molotov_cocktail");
	}

	public void onPlayerStoppedUsing(ItemStack is, World world, EntityPlayer player, int par4) {
		if (player.capabilities.isCreativeMode || player.inventory.hasItem(Items.flint_and_steel)) {

			if (!player.capabilities.isCreativeMode) {
				for (int i = 0; i < player.inventory.mainInventory.length; i++) {
					if (player.inventory.mainInventory[i] != null) {

						if (player.inventory.getStackInSlot(i).getItem() == new ItemStack(Items.flint_and_steel, 1, 0).getItem() && player.inventory.getStackInSlot(i).getItemDamage() != player.inventory.getStackInSlot(i).getMaxDamage()) {
							player.inventory.setInventorySlotContents(i, new ItemStack(Items.flint_and_steel, 1, player.inventory.getStackInSlot(i).getItemDamage()+1));
							--is.stackSize;
							break;
						}

						if (player.inventory.getStackInSlot(i).getItem() == new ItemStack(Items.flint_and_steel, 1, 0).getItem() && player.inventory.getStackInSlot(i).getItemDamage() == player.inventory.getStackInSlot(i).getMaxDamage()) {
							player.inventory.setInventorySlotContents(i, null);
						}

					}
				}
			}

			/*EntityArrowMini entityarrow = new EntityArrowMini(world);
			world.spawnEntityInWorld(entityarrow);*/
			world.playSoundAtEntity(player, "random.bow", 1.0F, 1.0F/(itemRand.nextFloat()*0.4F+1.2F)+0.5F);
		}
	}

	public ItemStack onEaten(ItemStack is, World world, EntityPlayer player) {return is;}

	public int getMaxItemUseDuration(ItemStack is) {
		return 72000;
	}

	public EnumAction getItemUseAction(ItemStack is) {
		return EnumAction.block;
	}

	public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer player) {
		if (player.capabilities.isCreativeMode || player.inventory.hasItem(Items.flint_and_steel)) {
			player.setItemInUse(is, this.getMaxItemUseDuration(is));
		}
		return super.onItemRightClick(is, world, player);
	}

}
