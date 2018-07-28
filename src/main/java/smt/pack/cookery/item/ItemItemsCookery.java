package smt.pack.cookery.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemItemsCookery extends Item {

	private IIcon
	itemIcon1,
	itemIcon2,
	itemIcon3;

	@Override
	public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer player) {
		if (!player.capabilities.isCreativeMode) --itemStack.stackSize;
		player.getFoodStats().addStats(5, 10F);
		world.playSoundAtEntity(player, "random.burp", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
		return itemStack;
	}

	@Override
	public int getMaxItemUseDuration(ItemStack itemStack) {
		return 32;
	}

	@Override
	public EnumAction getItemUseAction(ItemStack itemStack) {
		return EnumAction.eat;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		if (player.canEat(false))
			player.setItemInUse(itemStack, this.getMaxItemUseDuration(itemStack));
		return itemStack;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public boolean requiresMultipleRenderPasses() {
		return true;
	}

	@Override
	public int getRenderPasses(int metadata) {
		return 4;
	}

	@Override
	public IIcon getIcon(ItemStack itemStack, int pass) {
		switch(pass) {
		case 0:return itemIcon;
		case 1:return itemIcon1;
		case 2:return itemIcon2;
		case 3:return itemIcon3;
		default:return super.getIcon(itemStack, pass);
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister ir) {
		itemIcon = ir.registerIcon(this.getIconString());
		itemIcon1 = ir.registerIcon(this.getIconString() + "1");
		itemIcon2 = ir.registerIcon(this.getIconString() + "2");
		itemIcon3 = ir.registerIcon(this.getIconString() + "3");
	}

}
