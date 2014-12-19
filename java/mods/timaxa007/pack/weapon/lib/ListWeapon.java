package mods.timaxa007.pack.weapon.lib;


public class ListWeapon {

	public static AmmoFor bullet = new AmmoFor().setName("bullet");
	public static AmmoFor bullet_pistol = new AmmoFor().setName("bullet_pistol");
	public static AmmoFor bullet_drobovik = new AmmoFor().setName("bullet_drobovik");
	public static AmmoFor bullet_avtomat = new AmmoFor().setName("bullet_avtomat");
	public static AmmoFor bullet_pulemet = new AmmoFor().setName("bullet_pulemet");
	public static AmmoFor bullet_sniper = new AmmoFor().setName("bullet_sniper");

	public static MagazineFor magazine_bullet = new MagazineFor().setName("magazine_bullet").setSize(10).setBullet(bullet);
	public static MagazineFor magazine_pistol = new MagazineFor().setName("magazine_pistol").setSize(7).setBullet(bullet_pistol);
	public static MagazineFor magazine_avtomat = new MagazineFor().setName("magazine_avtomat").setSize(30).setBullet(bullet_avtomat);
	public static MagazineFor magazine_pulemet = new MagazineFor().setName("magazine_pulemet").setSize(100).setBullet(bullet_pulemet);
	public static MagazineFor magazine_sniper = new MagazineFor().setName("magazine_sniper").setSize(20).setBullet(bullet_sniper);

	public static WeaponFor weapon = new WeaponFor().setName("weapon").setAmmo(magazine_bullet);
	public static WeaponFor weapon_pistol = new WeaponFor().setName("weapon_pistol").setAmmo(magazine_pistol);
	public static WeaponFor weapon_drobovik_1 = new WeaponFor().setName("weapon_drobovik_1").setAmmo(bullet_drobovik).setSizeAmmo(2);
	public static WeaponFor weapon_drobovik_2 = new WeaponFor().setName("weapon_drobovik_2").setAmmo(bullet_drobovik).setSizeAmmo(7);
	public static WeaponFor weapon_avtomat = new WeaponFor().setName("weapon_avtomat").setAmmo(magazine_avtomat);
	public static WeaponFor weapon_pulemet = new WeaponFor().setName("weapon_pulemet").setAmmo(magazine_pulemet);
	public static WeaponFor weapon_sniper = new WeaponFor().setName("weapon_sniper").setAmmo(magazine_sniper);


}
