package smt.pack.medicine.item;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.util.Constants.NBT;
import smt.pack.medicine.SMTMedicine;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemItemsMedicine extends Item {

	public ItemItemsMedicine() {
		super();
	}

	@Override
	public boolean onLeftClickEntity(ItemStack itemStack, EntityPlayer player, Entity entity) {
		if (!player.worldObj.isRemote) {

			NBTTagCompound nbt = itemStack.getTagCompound();
			if (nbt == null || (!nbt.hasKey("DNAP", NBT.TAG_STRING) && !nbt.hasKey("DNAE", NBT.TAG_STRING))) {

				if (entity instanceof EntityLivingBase) {
					EntityLivingBase entity_base = (EntityLivingBase) entity;

					if (player.worldObj.rand.nextInt(5) == 0) {
						entity.playSound("random.explode", 1.0F, 1.0F);
						entity_base.addPotionEffect(new PotionEffect(Potion.confusion.id, 0, 5));
						//player.inventory.consumeInventoryItem(AlchemyBase.Needle);
						//player.inventory.addItemStackToInventory(new ItemStack(AlchemyBase.NeedleWithBlood, 1));

						for (int i = 0; i < 10; i++) {
							entity.worldObj.spawnParticle("reddust", entity.posX, entity.posY + 0.5, entity.posZ, 0.0D, 0.1D, 0.0D);
						}
						ItemStack itemStack_new = itemStack.copy();
						--itemStack.stackSize;
						if (itemStack.stackSize <= 0) {
							if (player.getCurrentEquippedItem() == itemStack) {
								player.setCurrentItemOrArmor(0, null);
							} else itemStack = null;
						}
						itemStack_new.stackSize = 1;
						itemStack_new = addNBT(itemStack_new, entity_base);
						player.inventory.addItemStackToInventory(itemStack_new);
					}
				}

			}

		}
		return true;
	}

	@Override
	public String getUnlocalizedName(ItemStack itemStack) {
		NBTTagCompound nbt = itemStack.getTagCompound();
		if (nbt != null) {
			if (nbt.hasKey("DNAP", NBT.TAG_STRING)) {
				return "Иголка с ДНК.";
			}
			if (nbt.hasKey("DNAE", NBT.TAG_STRING)) {
				return "Иголка с ДНК.";
			}
		} else return "Чистая иголка.";
		return super.getUnlocalizedName();
	}

	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean flag) {
		NBTTagCompound nbt = itemStack.getTagCompound();
		if (nbt != null) {
			if (nbt.hasKey("DNAP", NBT.TAG_STRING)) {
				list.add("ДНК игрока: " + nbt.getString("DNAP") + ".");
			}
			if (nbt.hasKey("DNAE", NBT.TAG_STRING)) {
				list.add("ДНК моба: " + StatCollector.translateToLocal(nbt.getString("DNAE")) + ".");
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item item, CreativeTabs table, List list) {
		list.add(addNBT(new ItemStack(item), null));
	}

	private static ItemStack addNBT(ItemStack itemStack, EntityLivingBase entity) {
		NBTTagCompound nbt = itemStack.getTagCompound();
		if (nbt == null) nbt = new NBTTagCompound();
		if (entity != null) {
			nbt.setString("DNA" + (entity instanceof EntityPlayer ? "P" : "E"), entity.getCommandSenderName());
		}
		itemStack.setTagCompound(nbt);
		return itemStack;
	}

}
