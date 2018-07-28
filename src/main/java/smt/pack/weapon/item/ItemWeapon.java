package smt.pack.weapon.item;

import java.util.List;
import java.util.Map;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.util.Constants.NBT;
import smt.pack.common.util.UtilString;
import smt.pack.weapon.SMTWeapon;
import smt.pack.weapon.registry.Bullet;
import smt.pack.weapon.registry.FireMode;
import smt.pack.weapon.registry.Magazine;
import smt.pack.weapon.registry.Reg;
import smt.pack.weapon.registry.Weapon;

public class ItemWeapon extends Item {

	/*
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		if (!world.isRemote) {
			EntityBullet entity = new EntityBullet(world, player);
			//entity.setPosition(player.posX, player.posY, player.posZ);
			entity.motionX *= 0.5D;
			entity.motionZ *= 0.5D;
			world.spawnEntityInWorld(entity);
		}
		return super.onItemRightClick(itemStack, world, player);
	}
	 */
	/*
	@Override
	public void onCreated(ItemStack itemStack, World world, EntityPlayer player) {
		if (!itemStack.hasTagCompound()) itemStack.setTagCompound(new NBTTagCompound());
		NBTTagCompound nbt = itemStack.getTagCompound();
		nbt.setString("WeaponID", "");
	}
	 */

	@Override
	public String getUnlocalizedName(ItemStack itemStack) {
		NBTTagCompound nbt = itemStack.getTagCompound();
		if (nbt != null && nbt.hasKey("WeaponID", NBT.TAG_STRING) && Reg.weapons.containsKey(nbt.getString("WeaponID")))
			return Reg.weapons.get(nbt.getString("WeaponID")).getName();
		return super.getUnlocalizedName(itemStack);
	}

	@Override
	public String getItemStackDisplayName(ItemStack itemStack) {
		NBTTagCompound nbt = itemStack.getTagCompound();
		if (nbt != null && nbt.hasKey("WeaponID", NBT.TAG_STRING) && Reg.weapons.containsKey(nbt.getString("WeaponID")))
			return StatCollector.translateToLocal(Reg.weapons.get(nbt.getString("WeaponID")).getName());
		return super.getItemStackDisplayName(itemStack);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean flag) {
		NBTTagCompound nbt = itemStack.getTagCompound();
		if (nbt != null && nbt.hasKey("WeaponID", NBT.TAG_STRING)) {
			if (flag) list.add("WeaponID: " + nbt.getString("WeaponID"));
			Weapon wpn = Reg.weapons.get(nbt.getString("WeaponID"));
			if (wpn == null) return;
			list.add("Delay Fire: " + wpn.getDelayFire());
			list.add("Delay Reload: " + wpn.getDelayReload());

			if (wpn.getModeFire() != null && wpn.getModeFire().length > 0) {
				String modes = "";
				for (FireMode fm : wpn.getModeFire()) modes += fm.name() + "  ";
				list.add("Fire Modes: " + modes);
				/*
				if (flag && ItemStack.areItemStacksEqual(itemStack, SMTWeapon.proxy.wpn_sys.getWeaponCurrent()) && nbt.hasKey("ModeFire", NBT.TAG_BYTE)) {
					list.add("Mode Fire: " + SMTWeapon.proxy.wpn_sys.getFireMode() + " Save-[" + wpn.getModeFire()[nbt.getByte("ModeFire")] + "]");
				} else {
					if (ItemStack.areItemStacksEqual(player.getCurrentEquippedItem(), SMTWeapon.proxy.wpn_sys.getWeaponCurrent()))
						list.add("Mode Fire: " + SMTWeapon.proxy.wpn_sys.getFireMode());
					else if (nbt.hasKey("ModeFire", NBT.TAG_BYTE)) {
						list.add("Mode Fire: " + wpn.getModeFire()[nbt.getByte("ModeFire")]);
					}
				}*/
				if (nbt.hasKey("ModeFire", NBT.TAG_BYTE))
					list.add("Mode Fire: " + wpn.getModeFire()[nbt.getByte("ModeFire")]);
			}

			if (wpn.getAmmunition() != null) {
				String modes = "";
				for (String ammunition : wpn.getAmmunition()) modes += ammunition + "  ";
				list.add("Ammunition: " + modes);

				if (nbt.hasKey("MagazineID", NBT.TAG_STRING))
					list.add("MagazineID: " + nbt.getString("MagazineID"));

				if (nbt.hasKey("BulletID", NBT.TAG_STRING))
					list.add("BulletID: " + nbt.getString("BulletID"));

				if (nbt.hasKey("Course", NBT.TAG_LIST)) {
					NBTTagList tag_list = nbt.getTagList("Course", NBT.TAG_STRING);
					for (int i = 0; i < tag_list.tagCount(); ++i)
						list.add("Course" + i + ": " + tag_list.getStringTagAt(i));
				}

			}

			if (wpn.getDescription().length() > 0) {
				list.add("Description:");
				list.addAll(UtilString.unname2(StatCollector.translateToLocal(wpn.getDescription()), Minecraft.getMinecraft().fontRenderer, 200));
			}

		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void getSubItems(Item id, CreativeTabs table, List list) {
		//list.add(new ItemStack(id, 1, 0));
		for (Map.Entry<String, Weapon> entry : Reg.weapons.entrySet())
			list.add(addNBT(new ItemStack(id), false, entry.getKey()));
		list.add(addNBT(new ItemStack(id), true, "wpn_test", "mag_test", "bullet_test"));
		list.add(addNBT(new ItemStack(id), true, "wpn_test2", "mag_test2", "bullet_test2"));
		//list.add(addNBT(new ItemStack(id), true, "wpn_flamethrower", "mag_gas", "flame"));
		//list.add(addNBT(new ItemStack(id), true, "wpn_blaster", "mag_blast", "blast"));
	}

	public static ItemStack addNBT(ItemStack itemStack, boolean fill, String... args) {
		NBTTagCompound nbt = new NBTTagCompound();
		if (args.length > 0) {
			nbt.setString("WeaponID", args[0]);
			if (args.length > 1) {
				nbt.setString("MagazineID", args[1]);
				if (args.length > 2) {
					nbt.setString("BulletID", args[2]);
					if (fill) {
						Magazine mag = Reg.magazines.get((args[1]));
						if (mag != null) {
							NBTTagList tag_list = new NBTTagList();
							for (int i = 0; i < mag.getAmount(); ++i)
								tag_list.appendTag(new NBTTagString(args[2]));
							nbt.setTag("Course", tag_list);
						}
					}
				}
			}
		}
		itemStack.setTagCompound(nbt);
		return itemStack;
	}

	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
		return true;
	}

	@Override
	public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack) {
		return true;
	}

}
