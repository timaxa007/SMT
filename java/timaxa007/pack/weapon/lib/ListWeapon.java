package timaxa007.pack.weapon.lib;

import timaxa007.pack.weapon.util.Ammo;
import timaxa007.pack.weapon.util.Clip;
import timaxa007.pack.weapon.util.RegistryWeapons;
import timaxa007.pack.weapon.util.Weapon;


public class ListWeapon {

	public static Ammo
	bullet,
	bullet_pistol,
	bullet_shotgun,
	bullet_avtomat,
	bullet_pulemet,
	bullet_sniper
	;

	public static Clip
	magazine_bullet,
	magazine_pistol,
	magazine_avtomat,
	magazine_pulemet,
	magazine_sniper
	;

	public static Weapon
	weapon,
	weapon_pistol,
	weapon_shotgun_1,
	weapon_shotgun_2,
	weapon_avtomat,
	weapon_pulemet,
	weapon_sniper
	;

	public static Ammo[] list_ammo;
	public static Clip[] list_clip;
	public static Weapon[] list_weapon;

	public static void init() {

		bullet = new Ammo("bullet");
		bullet_pistol = new Ammo("bullet_pistol");
		bullet_shotgun = new Ammo("bullet_shotgun");
		bullet_avtomat = new Ammo("bullet_avtomat");
		bullet_pulemet = new Ammo("bullet_pulemet");
		bullet_sniper = new Ammo("bullet_sniper");

		list_ammo = new Ammo[] {
				bullet,
				bullet_pistol,
				bullet_shotgun,
				bullet_avtomat,
				bullet_pulemet,
				bullet_sniper
		};

		magazine_bullet = new Clip("magazine_bullet").setMaxAmountAmmo(10).setAmmo(bullet);
		magazine_pistol = new Clip("magazine_pistol").setMaxAmountAmmo(7).setAmmo(bullet_pistol);
		magazine_avtomat = new Clip("magazine_avtomat").setMaxAmountAmmo(30).setAmmo(bullet_avtomat);
		magazine_pulemet = new Clip("magazine_pulemet").setMaxAmountAmmo(100).setAmmo(bullet_pulemet);
		magazine_sniper = new Clip("magazine_sniper").setMaxAmountAmmo(20).setAmmo(bullet_sniper);

		list_clip = new Clip[] {
				magazine_bullet,
				magazine_pistol,
				magazine_avtomat,
				magazine_pulemet,
				magazine_sniper
		};

		weapon = new Weapon("weapon", magazine_bullet)
		.setDelay(1).setSoundFire("timaxa007:mp5-1").setSoundReload("timaxa007:mp5_slideback");

		weapon_pistol = new Weapon("weapon_pistol", magazine_pistol)
		.setDelay(4).setSoundFire("timaxa007:fiveseven-1").setSoundReload("timaxa007:fiveseven_slidepull");

		weapon_shotgun_1 = new Weapon("weapon_shotgun_1", bullet_shotgun, 2)
		.setDelay(8).setSoundFire("timaxa007:m3-1").setSoundReload("timaxa007:m3_pump");

		weapon_shotgun_2 = new Weapon("weapon_shotgun_2", bullet_shotgun, 7)
		.setDelay(12).setSoundFire("timaxa007:m3-1").setSoundReload("timaxa007:m3_pump");

		weapon_avtomat = new Weapon("weapon_avtomat", magazine_avtomat)
		.setDelay(2).setSoundFire("timaxa007:ak47-1").setSoundReload("timaxa007:ak47_boltpull");

		weapon_pulemet = new Weapon("weapon_pulemet", magazine_pulemet)
		.setDelay(2).setSoundFire("timaxa007:m249-1").setSoundReload("timaxa007:m249_chain");

		weapon_sniper = new Weapon("weapon_sniper", magazine_sniper)
		.setDelay(25).setSoundFire("timaxa007:scout_fire-1").setSoundReload("timaxa007:scout_bolt");

		list_weapon = new Weapon[] {
				weapon,
				weapon_pistol,
				weapon_shotgun_1,
				weapon_shotgun_2,
				weapon_avtomat,
				weapon_pulemet,
				weapon_sniper
		};

		RegistryWeapons.RegistryAmmo.registerWeapon(list_ammo);
		RegistryWeapons.RegistryClip.registerWeapon(list_clip);
		RegistryWeapons.RegistryWeapon.registerWeapon(list_weapon);

	}

}
