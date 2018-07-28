package smt.pack.weapon.registry.reloading;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants.NBT;
import smt.pack.weapon.SMTWeapon;
import smt.pack.weapon.item.ItemItemsWeapon;
import smt.pack.weapon.registry.Bullet;
import smt.pack.weapon.registry.Reg;
import smt.pack.weapon.registry.WeaponSystem;

public class DefaultReloading extends ReloadingDummy {

	//if (!player.capabilities.isCreativeMode) {
	public DefaultReloading(final WeaponSystem wpn_sys, final EntityPlayer player, final int slotID, final int delay_reload) {
		super(wpn_sys, player, slotID, delay_reload);

		if (wpn_sys.getWeapon() == null) return;
		if (wpn_sys.getWeapon().getAmmunition() == null || wpn_sys.getWeapon().getAmmunition().length == 0) return;

		if (slotID == -1) {
			System.out.println("0");
			for (int i = 0; i < player.inventory.getSizeInventory(); ++i) {
				ItemStack itemStack = player.inventory.getStackInSlot(i);
				if (itemStack == null) continue;
				if (!(itemStack.getItem() instanceof ItemItemsWeapon)) continue;
				if (!itemStack.hasTagCompound()) continue;
				NBTTagCompound nbt = itemStack.getTagCompound();
				if (!nbt.hasKey("MagazineID", NBT.TAG_STRING)) continue;
				if (!nbt.hasKey("Course", NBT.TAG_LIST)) continue;
				String id = nbt.getString("MagazineID");
				if (!Reg.magazines.containsKey(id)) continue;
				boolean stop = true;
				for (String a : wpn_sys.getWeapon().getAmmunition()) {
					if (a.equals(id)) {stop = false;break;}
				}
				if (stop) continue;
				if (wpn_sys.getMagazine() != null) {
					ItemStack magazineIS = new ItemStack(SMTWeapon.item.itemsWeapon);
					if (wpn_sys.getCourse() != null && wpn_sys.getCourse().length > 0 && wpn_sys.getNumerCourse() >= 0) {
						ItemItemsWeapon.addNBT(magazineIS, Reg.getMagazineID(wpn_sys.getMagazine()), wpn_sys.getCourse(), wpn_sys.getNumerCourse());
						wpn_sys.setNumerCourse(-1);
						wpn_sys.setCourse(null);
					} else
						ItemItemsWeapon.addNBT(magazineIS, "MagazineID", Reg.getMagazineID(wpn_sys.getMagazine()));
					if (!player.inventory.addItemStackToInventory(magazineIS)) player.dropPlayerItemWithRandomChoice(magazineIS, false);
					/*else if (player instanceof EntityPlayerMP) ((EntityPlayerMP)player).sendContainerToPlayer(player.inventoryContainer);*/
					wpn_sys.setMagazine(null);
				}
				temp = itemStack.copy();
				temp.stackSize = 1;
				--itemStack.stackSize;
				if (itemStack.stackSize <= 0) player.inventory.setInventorySlotContents(i, null);
				this.slotID = i;
				//break;
				return;
			}

			System.out.println("1");

			for (int i = 0; i < player.inventory.getSizeInventory(); ++i) {
				ItemStack itemStack = player.inventory.getStackInSlot(i);
				if (itemStack == null) continue;
				if (!(itemStack.getItem() instanceof ItemItemsWeapon)) continue;
				if (!itemStack.hasTagCompound()) continue;
				NBTTagCompound nbt = itemStack.getTagCompound();
				if (!nbt.hasKey("BulletID", NBT.TAG_STRING)) continue;
				String id = nbt.getString("BulletID");
				if (!Reg.bullets.containsKey(id)) continue;
				boolean stop = true;
				for (String a : wpn_sys.getWeapon().getAmmunition()) {
					if (a.equals(id)) {stop = false;break;}
				}
				if (stop) continue;
				if (wpn_sys.getBullet() != null) {
					ItemStack bulletIS = new ItemStack(SMTWeapon.item.itemsWeapon);
					ItemItemsWeapon.addNBT(bulletIS, "BulletID", Reg.getBulletID(wpn_sys.getBullet()));
					if (!player.inventory.addItemStackToInventory(bulletIS)) player.dropPlayerItemWithRandomChoice(bulletIS, false);
					/*else if (player instanceof EntityPlayerMP) ((EntityPlayerMP)player).sendContainerToPlayer(player.inventoryContainer);*/
					wpn_sys.setBullet(null);
				}
				temp = itemStack.copy();
				temp.stackSize = 1;
				--itemStack.stackSize;
				if (itemStack.stackSize <= 0) player.inventory.setInventorySlotContents(i, null);
				this.slotID = i;
				//break;
				return;
			}

			System.out.println("2");

			if (wpn_sys.getMagazine() != null) {
				ItemStack magazineIS = new ItemStack(SMTWeapon.item.itemsWeapon);
				if (wpn_sys.getCourse() != null && wpn_sys.getCourse().length > 0 && wpn_sys.getNumerCourse() >= 0) {
					ItemItemsWeapon.addNBT(magazineIS, Reg.getMagazineID(wpn_sys.getMagazine()), wpn_sys.getCourse(), wpn_sys.getNumerCourse());
					wpn_sys.setNumerCourse(-1);
					wpn_sys.setCourse(null);
				} else
					ItemItemsWeapon.addNBT(magazineIS, "MagazineID", Reg.getMagazineID(wpn_sys.getMagazine()));
				if (!player.inventory.addItemStackToInventory(magazineIS)) player.dropPlayerItemWithRandomChoice(magazineIS, false);
				/*else if (player instanceof EntityPlayerMP) ((EntityPlayerMP)player).sendContainerToPlayer(player.inventoryContainer);*/
				wpn_sys.setMagazine(null);
				return;
			}

			System.out.println("3");

			if (wpn_sys.getBullet() != null) {
				ItemStack bulletIS = new ItemStack(SMTWeapon.item.itemsWeapon);
				ItemItemsWeapon.addNBT(bulletIS, "BulletID", Reg.getBulletID(wpn_sys.getBullet()));
				if (!player.inventory.addItemStackToInventory(bulletIS)) player.dropPlayerItemWithRandomChoice(bulletIS, false);
				/*else if (player instanceof EntityPlayerMP) ((EntityPlayerMP)player).sendContainerToPlayer(player.inventoryContainer);*/
				wpn_sys.setBullet(null);
				return;
			}

			System.out.println("4");

		} else {
			System.out.println("5");

			ItemStack itemStack = player.inventory.getStackInSlot(slotID);
			temp = itemStack.copy();
			temp.stackSize = 1;
			--itemStack.stackSize;
			if (itemStack.stackSize <= 0) player.inventory.setInventorySlotContents(slotID, null);

			System.out.println("6");
		}
	}

	@Override
	public void onUpdate() {
		if (delay_reload == -1) return;
		else if (delay_reload > 0) --delay_reload;
		else finish();
	}

	@Override
	public void finish() {
		if (temp != null) {

			System.out.println("finish");
			if (temp.hasTagCompound()) {
				NBTTagCompound nbt = temp.getTagCompound();

				if (nbt.hasKey("MagazineID", NBT.TAG_STRING)) {
					wpn_sys.setMagazine(Reg.magazines.get(nbt.getString("MagazineID")));

					if (nbt.hasKey("Course", NBT.TAG_LIST)) {
						NBTTagList tag_list = nbt.getTagList("Course", NBT.TAG_STRING);
						wpn_sys.setNumerCourse(tag_list.tagCount() - 1);
						wpn_sys.setCourse(new Bullet[tag_list.tagCount()]);
						for (int i = 0; i < tag_list.tagCount(); ++i)
							wpn_sys.getCourse()[i] = Reg.bullets.get(tag_list.getStringTagAt(i));
					}
					if (wpn_sys.getBullet() == null) {
						wpn_sys.setBullet(wpn_sys.getCourse()[wpn_sys.getNumerCourse()]);
						wpn_sys.setNumerCourse(wpn_sys.getNumerCourse() - 1);
					}
				} else if (nbt.hasKey("BulletID", NBT.TAG_STRING))
					wpn_sys.setBullet(Reg.bullets.get(nbt.getString("BulletID")));
			}

			temp = null;
			delay_reload = -1;
			wpn_sys.refresh(wpn_sys.getWeaponCurrent());
		}
	}

	@Override
	public void breaking() {
		if (temp != null && !player.inventory.addItemStackToInventory(temp))
			player.dropPlayerItemWithRandomChoice(temp, false);
		delay_reload = -1;
	}

}
