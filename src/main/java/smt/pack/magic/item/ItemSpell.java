package smt.pack.magic.item;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import smt.pack.magic.client.DragonEntityFX;

public class ItemSpell extends Item {

	public static final String[] spell_name = new String[]{
			"wall_dirt",
			"wall_stone",
			"wall_lava",
			"wall_water"
	};
	
	@Override
    public Entity createEntity(World world, Entity location, ItemStack itemstack) {
System.out.println("createEntity");
        return null;
    }
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		/*
		if (!world.isRemote) {
			if (!itemStack.hasTagCompound()) {
				itemStack.setTagCompound(new NBTTagCompound());
				itemStack.getTagCompound().setInteger("ModeSpell", 0);
			} else {
				NBTTagCompound nbt = itemStack.getTagCompound();
				int mode = nbt.getInteger("ModeSpell");
				nbt.setInteger("ModeSpell", (mode < spell_name.length - 1 ? mode + 1 : 0));
			}
		}
		 */
		/*if (world.isRemote)
			Minecraft.getMinecraft().effectRenderer.addEffect(new DragonEntityFX(world,
					player.posX,
					player.posY,
					player.posZ));*/
		return super.onItemRightClick(itemStack, world, player);
	}

}
