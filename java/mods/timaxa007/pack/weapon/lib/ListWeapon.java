package mods.timaxa007.pack.weapon.lib;


public class ListWeapon {

	public static AmmoFor bullet = new AmmoFor("bullet");
	public static AmmoFor bullet_pistol = new AmmoFor("bullet_pistol");
	public static AmmoFor bullet_shotgun = new AmmoFor("bullet_shotgun");
	public static AmmoFor bullet_avtomat = new AmmoFor("bullet_avtomat");
	public static AmmoFor bullet_pulemet = new AmmoFor("bullet_pulemet");
	public static AmmoFor bullet_sniper = new AmmoFor("bullet_sniper");

	public static MagazineFor magazine_bullet = new MagazineFor("magazine_bullet").setSize(10).setBullet(bullet);
	public static MagazineFor magazine_pistol = new MagazineFor("magazine_pistol").setSize(7).setBullet(bullet_pistol);
	public static MagazineFor magazine_avtomat = new MagazineFor("magazine_avtomat").setSize(30).setBullet(bullet_avtomat);
	public static MagazineFor magazine_pulemet = new MagazineFor("magazine_pulemet").setSize(100).setBullet(bullet_pulemet);
	public static MagazineFor magazine_sniper = new MagazineFor("magazine_sniper").setSize(20).setBullet(bullet_sniper);

	public static WeaponFor weapon = new WeaponFor("weapon").setDelay(1).setAmmo(magazine_bullet);
	public static WeaponFor weapon_pistol = new WeaponFor("weapon_pistol").setDelay(4).setAmmo(magazine_pistol);
	public static WeaponFor weapon_shotgun_1 = new WeaponFor("weapon_shotgun_1").setDelay(7).setAmmo(bullet_shotgun).setSizeAmmo(2);
	public static WeaponFor weapon_shotgun_2 = new WeaponFor("weapon_shotgun_2").setDelay(10).setAmmo(bullet_shotgun).setSizeAmmo(7);
	public static WeaponFor weapon_avtomat = new WeaponFor("weapon_avtomat").setDelay(2).setAmmo(magazine_avtomat);
	public static WeaponFor weapon_pulemet = new WeaponFor("weapon_pulemet").setDelay(3).setAmmo(magazine_pulemet);
	public static WeaponFor weapon_sniper = new WeaponFor("weapon_sniper").setDelay(25).setAmmo(magazine_sniper);


}
