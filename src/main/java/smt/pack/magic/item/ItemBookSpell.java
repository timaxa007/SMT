package smt.pack.magic.item;

import java.util.Iterator;
import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import smt.pack.magic.SMTMagic;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBookSpell extends Item {

	public ItemBookSpell() {
		super();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item item, CreativeTabs tabs, List list) {
		list.add(addNBT(new ItemStack(item, 1, 0)));
	}

	private static ItemStack addNBT(ItemStack itemStack) {
		NBTTagCompound nbt = itemStack.getTagCompound();
		if (nbt == null) nbt = new NBTTagCompound();
		nbt.setInteger("savedSpells", 0);
		itemStack.setTagCompound(nbt);
		return itemStack;
	}

	@Override
	public boolean onEntityItemUpdate(EntityItem entity) {
		ItemStack stack = entity.getEntityItem();
		if (stack.getTagCompound() != null && stack.getItem() == SMTMagic.item.bookSpell) {
			AxisAlignedBB aabb = AxisAlignedBB.getBoundingBox(entity.posX - 0.5D, entity.posY - 0.5D, entity.posZ - 0.5D, entity.posX + 0.5D, entity.posY + 0.5D, entity.posZ + 0.5D);
			List list = entity.worldObj.getEntitiesWithinAABB(EntityItem.class, aabb);
			Iterator iterator = list.iterator();
			EntityItem near = null;
			while (iterator.hasNext()) {
				near = (EntityItem)iterator.next();
				if (near == entity) continue;
				ItemStack scroll = near.getEntityItem();
				if (!stack.stackTagCompound.getBoolean("haveAcidArrow") && scroll.getItem() == Items.arrow) {
					stack.stackTagCompound.setInteger("savedSpells", stack.stackTagCompound.getInteger("savedSpells") + 1);
					stack.stackTagCompound.setBoolean("haveAcidArrow", true);
					stack.stackTagCompound.setString("spellNumber" + stack.stackTagCompound.getInteger("savedSpells"), "AcidArrow");
					entity.worldObj.playSoundEffect(entity.posX, entity.posY, entity.posZ, "timaxa007:spbadd", 1.0F, 1.0F);
					entity.worldObj.spawnParticle("smoke", entity.posX, entity.posY, entity.posZ, 0.0D, 0.0D, 0.0D);
					entity.worldObj.spawnParticle("flame", entity.posX, entity.posY, entity.posZ, 0.0D, 0.0D, 0.0D);
					near.setDead();
				}
			}
		}
		return false;
	}

}
