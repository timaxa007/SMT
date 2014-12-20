package mods.timaxa007.pack.weapon.lib;


public class ListWeapon {

	public static AmmoFor bullet = new AmmoFor("bullet").setName("bullet");
	public static AmmoFor bullet_pistol = new AmmoFor("bullet_pistol").setName("bullet_pistol");
	public static AmmoFor bullet_drobovik = new AmmoFor("bullet_drobovik").setName("bullet_drobovik");
	public static AmmoFor bullet_avtomat = new AmmoFor("bullet_avtomat").setName("bullet_avtomat");
	public static AmmoFor bullet_pulemet = new AmmoFor("bullet_pulemet").setName("bullet_pulemet");
	public static AmmoFor bullet_sniper = new AmmoFor("bullet_sniper").setName("bullet_sniper");

	public static MagazineFor magazine_bullet = new MagazineFor("magazine_bullet").setName("magazine_bullet").setSize(10).setBullet(bullet);
	public static MagazineFor magazine_pistol = new MagazineFor("magazine_pistol").setName("magazine_pistol").setSize(7).setBullet(bullet_pistol);
	public static MagazineFor magazine_avtomat = new MagazineFor("magazine_avtomat").setName("magazine_avtomat").setSize(30).setBullet(bullet_avtomat);
	public static MagazineFor magazine_pulemet = new MagazineFor("magazine_pulemet").setName("magazine_pulemet").setSize(100).setBullet(bullet_pulemet);
	public static MagazineFor magazine_sniper = new MagazineFor("magazine_sniper").setName("magazine_sniper").setSize(20).setBullet(bullet_sniper);

	public static WeaponFor weapon = new WeaponFor("weapon").setName("weapon").setAmmo(magazine_bullet);
	public static WeaponFor weapon_pistol = new WeaponFor("weapon_pistol").setName("weapon_pistol").setAmmo(magazine_pistol);
	public static WeaponFor weapon_drobovik_1 = new WeaponFor("weapon_drobovik_1").setName("weapon_drobovik_1").setAmmo(bullet_drobovik).setSizeAmmo(2);
	public static WeaponFor weapon_drobovik_2 = new WeaponFor("weapon_drobovik_2").setName("weapon_drobovik_2").setAmmo(bullet_drobovik).setSizeAmmo(7);
	public static WeaponFor weapon_avtomat = new WeaponFor("weapon_avtomat").setName("weapon_avtomat").setAmmo(magazine_avtomat);
	public static WeaponFor weapon_pulemet = new WeaponFor("weapon_pulemet").setName("weapon_pulemet").setAmmo(magazine_pulemet);
	public static WeaponFor weapon_sniper = new WeaponFor("weapon_sniper").setName("weapon_sniper").setAmmo(magazine_sniper);


}
