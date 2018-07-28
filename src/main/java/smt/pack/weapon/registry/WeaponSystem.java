package smt.pack.weapon.registry;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import net.minecraftforge.common.util.Constants.NBT;
import smt.pack.weapon.SMTWeapon;
import smt.pack.weapon.item.ItemWeapon;
import smt.pack.weapon.registry.reloading.ReloadingDummy;
import smt.pack.weapon.registry.shooting.ShootingDummy;

public class WeaponSystem implements IExtendedEntityProperties {

	public final static String TAG = SMTWeapon.MODID + ":WeaponSystem";

	protected EntityPlayer player;
	protected ItemStack weapon_current = null;
	protected Weapon weapon = null;
	protected Bullet bullet = null;
	protected Magazine magazine = null;
	protected Bullet[] course = null;
	protected int number_course = 0;
	protected FireMode fire_mode = FireMode.FUSE;
	protected ShootingDummy shooting = null;
	protected ReloadingDummy reloading = null;

	private boolean isRight, isCenter, isReload, isAim;

	public void onUpdate() {
		//System.out.println("onUpdate Server, Side = " + (player.worldObj.isRemote ? "Client" : "Server"));
		onRemake();

		if (!(player.getHeldItem() != null && player.getHeldItem().getItem() instanceof ItemWeapon)) return;

		shooting.onUpdate();

		if (reloading != null) {
			reloading.onUpdate();
			if (reloading.getDelayReload() == -1) reloading = null;
		}

	}

	public void onRemake() {
		if (player.getHeldItem() != weapon_current) {
			if (!ItemStack.areItemStacksEqual(player.getHeldItem(), weapon_current)) {
				System.out.println("---------------------");
				System.out.println("onRemake");
				refresh(weapon_current);
				weaponNull();
				make(player.getHeldItem());
				System.out.println("---------------------");
			}
			weapon_current = player.getHeldItem();
		}
	}

	public void refresh(ItemStack itemStack) {
		if (itemStack == null || !(itemStack.getItem() instanceof ItemWeapon)) return;
		System.out.println("refresh - " + itemStack.toString());

		if (!itemStack.hasTagCompound()) itemStack.setTagCompound(new NBTTagCompound());
		NBTTagCompound nbt = itemStack.getTagCompound();
		/*
		if (weapon != null) {
			String id = Reg.getWeaponID(weapon);
			if (id != null) nbt.setString("WeaponID", id);
			else if (nbt.hasKey("WeaponID")) nbt.removeTag("WeaponID");
		} else if (nbt.hasKey("WeaponID")) nbt.removeTag("WeaponID");
		 */
		if (bullet != null) {
			String id = Reg.getBulletID(bullet);
			if (id != null) nbt.setString("BulletID", id);
			else if (nbt.hasKey("BulletID")) nbt.removeTag("BulletID");
		} else if (nbt.hasKey("BulletID")) nbt.removeTag("BulletID");

		if (magazine != null) {
			String id = Reg.getMagazineID(magazine);
			if (id != null) nbt.setString("MagazineID", id);
			else if (nbt.hasKey("MagazineID")) nbt.removeTag("MagazineID");
		} else if (nbt.hasKey("MagazineID")) nbt.removeTag("MagazineID");

		if (course != null && course.length > 0 && number_course >= 0) {
			NBTTagList tag_list = new NBTTagList();
			for (int i = 0; i <= number_course; ++i) {
				String id = Reg.getBulletID(course[i]);
				if (id != null) tag_list.appendTag(new NBTTagString(id));
			}
			nbt.setTag("Course", tag_list);
		} else if (nbt.hasKey("Course")) nbt.removeTag("Course");

		if (weapon.mode_fire != null && weapon.mode_fire.length > 0 && fire_mode != weapon.mode_fire[0]) {
			for (int i = 0; i < weapon.mode_fire.length; ++i) {
				if (weapon.mode_fire[i] == fire_mode) {
					nbt.setByte("ModeFire", (byte)i);
					break;
				}
			}
		} else if (nbt.hasKey("ModeFire")) nbt.removeTag("ModeFire");

	}

	protected void make(ItemStack itemStack) {
		if (itemStack == null || !(itemStack.getItem() instanceof ItemWeapon)) return;
		System.out.println("make - " + itemStack.toString());
		NBTTagCompound nbt = itemStack.getTagCompound();

		if (nbt == null) return;

		if (!nbt.hasKey("WeaponID", NBT.TAG_STRING)) return;
		weapon = Reg.weapons.get(nbt.getString("WeaponID"));

		if (nbt.hasKey("BulletID", NBT.TAG_STRING))
			bullet = Reg.bullets.get(nbt.getString("BulletID"));

		if (nbt.hasKey("MagazineID", NBT.TAG_STRING))
			magazine = Reg.magazines.get(nbt.getString("MagazineID"));

		if (nbt.hasKey("Course", NBT.TAG_LIST)) {
			NBTTagList tag_list = nbt.getTagList("Course", NBT.TAG_STRING);
			number_course = tag_list.tagCount() - 1;
			course = new Bullet[tag_list.tagCount()];
			for (int i = 0; i < tag_list.tagCount(); ++i)
				course[i] = Reg.bullets.get(tag_list.getStringTagAt(i));
		}

		if (weapon.mode_fire != null && weapon.mode_fire.length > 0) {
			if (nbt.hasKey("ModeFire", NBT.TAG_BYTE))
				fire_mode = weapon.mode_fire[nbt.getByte("ModeFire")];
			else
				fire_mode = weapon.mode_fire[0];
		}

		shooting = Reg.getShooting(weapon.shooting, this, player);
	}

	protected void weaponNull() {
		System.out.println("weaponNull");
		weapon = null;
		bullet = null;
		magazine = null;
		course = null;
		number_course = -1;
		fire_mode = FireMode.FUSE;
		if (shooting != null) {
			shooting.breaking();
			shooting = null;
		}
		if (reloading != null) {
			reloading.breaking();
			reloading = null;
		}
	}

	public void leftClick(boolean press) {
		if (shooting != null)
			shooting.leftClick(press);
	}

	public void rightClick(boolean press) {
		isRight = press;
	}

	public void centerClick(int fireModeID) {
		if (weapon == null) {
			if (fire_mode != FireMode.FUSE) fire_mode = FireMode.FUSE;
			return;
		}

		if (weapon.getModeFire() == null || weapon.getModeFire().length <= 1) {
			fire_mode = weapon.getModeFire()[0];
			return;
		}

		if (fireModeID == 0) {
			for (int i = 0; i < weapon.getModeFire().length; ++i) {
				if (weapon.getModeFire()[i] == fire_mode) {
					if (i + 1 >= weapon.getModeFire().length) {
						fire_mode = weapon.getModeFire()[0];
						break;
					} else {
						fire_mode = weapon.getModeFire()[i + 1];
						break;
					}
				}
			}

		} else {
			fire_mode = weapon.getModeFire()[0];
		}
	}

	public void reloadClick(int slotID) {
		System.out.println("reloadClick");
		if (weapon == null) return;
		reloading = Reg.getReloading(weapon.reloading, this, player, slotID, weapon.delay_reload);
	}

	public ItemStack getWeaponCurrent() {
		return weapon_current;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setBullet(Bullet bullet) {
		this.bullet = bullet;
	}

	public Bullet getBullet() {
		return bullet;
	}

	public void setMagazine(Magazine magazine) {
		this.magazine = magazine;
	}

	public Magazine getMagazine() {
		return magazine;
	}

	public void setCourse(Bullet[] course) {
		this.course = course;
	}

	public Bullet[] getCourse() {
		return course;
	}

	public void setNumerCourse(int number_course) {
		this.number_course = number_course;
	}

	public int getNumerCourse() {
		return number_course;
	}

	public FireMode getFireMode() {
		return fire_mode;
	}

	public void reg(EntityPlayer player) {
		player.registerExtendedProperties(TAG, new WeaponSystem());
	}

	public WeaponSystem get(EntityPlayer player) {
		return player != null ? (WeaponSystem)player.getExtendedProperties(TAG) : null;
	}

	@Override
	public void init(Entity entity, World world) {
		if (entity instanceof EntityPlayer) player = (EntityPlayer)entity;
	}

	@Override
	public void saveNBTData(NBTTagCompound compound) {
		//onRemake();
		refresh(weapon_current);
	}

	@Override
	public void loadNBTData(NBTTagCompound compound) {
		//onRemake();
	}

}
