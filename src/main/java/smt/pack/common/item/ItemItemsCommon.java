package smt.pack.common.item;

import java.util.HashMap;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;

public class ItemItemsCommon extends Item implements smt.pack.common.api.IRegisterItem {

	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		if (world.getTileEntity(x, y, z) instanceof IInventory) {
			if (world.isRemote) return true;
			IInventory inv = (IInventory)world.getTileEntity(x, y, z);
			ItemBlock itemBlock = (ItemBlock)Item.getItemFromBlock(Blocks.chest);
			ItemStack invItem = new ItemStack(itemBlock, 1, itemBlock.getMetadata(world.getBlockMetadata(x, y, z)));
			NBTTagCompound nbt = new NBTTagCompound();
			NBTTagList nbttaglist = new NBTTagList();
			for (int i = 0; i < inv.getSizeInventory(); ++i) {
				ItemStack slot = inv.getStackInSlot(i);
				if (slot != null) {
					NBTTagCompound nbttagcompound1 = new NBTTagCompound();
					nbttagcompound1.setByte("Slot", (byte)i);
					slot.writeToNBT(nbttagcompound1);
					nbttaglist.appendTag(nbttagcompound1);
				}

			}
			nbt.setTag("SaveInv", nbttaglist);
			invItem.setTagCompound(nbt);
			world.spawnEntityInWorld(new EntityItem(world, x + 0.5D, y + 0.5D, z + 0.5D, invItem));
			world.removeTileEntity(x, y, z);
			world.setBlockToAir(x, y, z);
			return true;
		}
		return false;
	}

	/*
	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {

		//if (!world.isAirBlock(x, y + 1, z)) return false;

		if (!player.canPlayerEdit(x, y, z, side, itemstack)) {
			return false;
		} else {
			if (SMTCommon.block.test.canPlaceBlockAt(world, x, y + 1, z)) {
				--itemstack.stackSize;
				world.setBlock(x, y + 1, z, SMTCommon.block.test);
				world.scheduleBlockUpdate(x, y + 1, z, SMTCommon.block.test, 0);
			}
			return true;
		}
	}
	 */
	/*
@Override
public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
PlayerStat player_stat = PlayerStat.get(player);
if (player_stat != null) {
player_stat.hand_left = !player_stat.hand_left;
player_stat.hand_right = !player_stat.hand_right;
System.out.println("player_stat.hand_right - " + player_stat.hand_right);
}
return itemStack;
}
	 */
	/*
@Override
public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
MovingObjectPosition mop = EntityLook.getMouseOver(player, 1F, 10D, true);
if (mop != null) {
System.out.println(mop.toString());
EntityLightningBolt ent = new EntityLightningBolt(world, mop.entityHit.posX, mop.entityHit.posY, mop.entityHit.posZ);
//world.addWeatherEffect(ent);
if (!world.isRemote) {
if (mop.entityHit instanceof EntityItem) {
EntityItem entityItem = (EntityItem)mop.entityHit;
int size = entityItem.getEntityItem().stackSize;
entityItem.setEntityItemStack(new ItemStack(Items.diamond, size));
}
}
}
return itemStack;
}
	 */
	@Override
	public String getRegisterName() {
		return "item_items_common";
	}

	@Override
	public void getRegisterItem(final HashMap<String, ItemStack> map) {
		map.put(getRegisterName(), new ItemStack(this));
	}

}
