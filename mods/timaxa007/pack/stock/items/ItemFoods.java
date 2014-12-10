package mods.timaxa007.pack.stock.items;

import java.util.List;

import mods.timaxa007.lib.Option;
import mods.timaxa007.pack.mining.lib.OreFake;
import mods.timaxa007.pack.stock.PackStock;
import mods.timaxa007.pack.stock.lib.FoodForItem;
import mods.timaxa007.tms.Core;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemFoods extends Item {

public static OreFake ore_salt = new OreFake("ore_salt").setName("salt").setType("Rock").setColor(0xFFFFFF).setTemperatures(16.0F, -10.0F, 100.0F);
public static OreFake ore_salted = new OreFake("ore_salted").setName("salt").setType("End").setColor(0xFFFFFF).setTemperatures(0.0F, -60.0F, 40.0F);
public static OreFake ore_salter = new OreFake("ore_salter").setName("salt").setType("Nether").setColor(0xFFFFFF).setTemperatures(48.0F, 0.0F, 180.0F);


public static FoodForItem cookie_raw = new FoodForItem("cookie_raw").setFoodStats(1, 0.2F).setName("cookie_raw").setColors(0xF1D598).setTextureFood("cookie", "O");
public static FoodForItem cookie_cooked = new FoodForItem("cookie_cooked").setFoodStats(2, 0.2F).setName("cookie_cooked").setColors(0xE79042).setTextureFood("cookie", "O");

public static FoodForItem cookie_chocolate_chips_raw = new FoodForItem("cookie_chocolate_chips_raw").setFoodStats(2, 0.2F).setName("cookie_chocolate_chips_raw").setColors(0xF1D598, 0x3F1800).setTextureFood("cookie", "O");
public static FoodForItem cookie_chocolate_chips_cooked = new FoodForItem("cookie_chocolate_chips_cooked").setFoodStats(2, 0.2F).setName("cookie_chocolate_chips_cooked").setColors(0xE79042, 0x3F1800).setTextureFood("cookie", "O");
/*
public static FoodForItem cookie_red_raw = new FoodForItem("cookie_red_raw").setFoodStats(2, 0.2F).setName("cookie_raw").setColors(0xF1D598, 0xFF0000).setTextureFood("cookie", "O");
public static FoodForItem cookie_red_cooked = new FoodForItem("cookie_red_cooked").setFoodStats(2, 0.2F).setName("cookie_cooked").setColors(0xE79042, 0xFF0000).setTextureFood("cookie", "O");
public static FoodForItem cookie_green_raw = new FoodForItem("cookie_green_raw").setFoodStats(2, 0.2F).setName("cookie_raw").setColors(0xF1D598, 0x00FF00).setTextureFood("cookie", "O");
public static FoodForItem cookie_green_cooked = new FoodForItem("cookie_green_cooked").setFoodStats(2, 0.2F).setName("cookie_cooked").setColors(0xE79042, 0x00FF00).setTextureFood("cookie", "O");
public static FoodForItem cookie_blue_raw = new FoodForItem("cookie_blue_raw").setFoodStats(2, 0.2F).setName("cookie_raw").setColors(0xF1D598, 0x0000FF).setTextureFood("cookie", "O");
public static FoodForItem cookie_blue_cooked = new FoodForItem("cookie_blue_cooked").setFoodStats(2, 0.2F).setName("cookie_cooked").setColors(0xE79042, 0x0000FF).setTextureFood("cookie", "O");
*/
public static FoodForItem cracker_raw = new FoodForItem("cracker_raw").setFoodStats(2, 0.2F).setName("cracker_raw").setColors(0xFFD57F).setTextureFood("cracker");
public static FoodForItem cracker_fried = new FoodForItem("cracker_fried").setFoodStats(2, 0.2F).setName("cracker_fried").setColors(0xF3B420).setTextureFood("cracker");

public static FoodForItem cupcake_01_raw = new FoodForItem("cupcake_01_raw").setFoodStats(2, 0.2F).setName("cupcake_01_raw").setColors(0xD9D481).setTextureFood("cupcake_01");
public static FoodForItem cupcake_01_fried = new FoodForItem("cupcake_01_fried").setFoodStats(2, 0.2F).setName("cupcake_01_fried").setColors(0xBB9949).setTextureFood("cupcake_01");
/*
public static FoodForItem cupcake_02_raw = new FoodForItem("cupcake_02_raw").setFoodStats(2, 0.2F).setName("cupcake_02_raw").setColors(0xD9D481, 0xFF0000).setTextureFood("cupcake_02", "O");
public static FoodForItem cupcake_02_fried = new FoodForItem("cupcake_02_fried").setFoodStats(2, 0.2F).setName("cupcake_02_fried").setColors(0xBB9949, 0xFF0000).setTextureFood("cupcake_02", "O");
*/
public static FoodForItem pancake_raw = new FoodForItem("pancake_raw").setFoodStats(2, 0.2F).setName("pancake_raw").setColors(0xD9D481).setTextureFood("pancake");
public static FoodForItem pancake_fried = new FoodForItem("pancake_fried").setFoodStats(2, 0.2F).setName("pancake_fried").setColors(0xBB9949).setTextureFood("pancake");
/*
public static FoodForItem pancake_red = new FoodForItem("pancake_red").setFoodStats(2, 0.2F).setName("pancake_red").setColors(0xBB9949, 0x00FF00).setTextureFood("pancake", "O");
public static FoodForItem pancake_green = new FoodForItem("pancake_green").setFoodStats(2, 0.2F).setName("pancake_green").setColors(0xBB9949, 0xFF0000).setTextureFood("pancake", "O");
public static FoodForItem pancake_blue = new FoodForItem("pancake_blue").setFoodStats(2, 0.2F).setName("pancake_blue").setColors(0xBB9949, 0x0000FF).setTextureFood("pancake", "O");
*/
public static FoodForItem doughnut_raw = new FoodForItem("doughnut_raw").setFoodStats(2, 0.2F).setName("doughnut_raw").setColors(0xD9D481).setTextureFood("doughnut_raw");
public static FoodForItem doughnut_cooked = new FoodForItem("doughnut_cooked").setFoodStats(2, 0.2F).setName("doughnut_cooked").setColors(0xBB9949).setTextureFood("doughnut_cooked");
/*
public static FoodForItem doughnut_cooked_red = new FoodForItem("doughnut_cooked_red").setFoodStats(2, 0.2F).setName("doughnut_cooked_red").setColors(0xBB9949, 0xFF0000).setTextureFood("doughnut_cooked", "O");
public static FoodForItem doughnut_cooked_green = new FoodForItem("doughnut_cooked_green").setFoodStats(2, 0.2F).setName("doughnut_cooked_green").setColors(0xBB9949, 0x00FF00).setTextureFood("doughnut_cooked", "O");
public static FoodForItem doughnut_cooked_blue = new FoodForItem("doughnut_cooked_blue").setFoodStats(2, 0.2F).setName("doughnut_cooked_blue").setColors(0xBB9949, 0x0000FF).setTextureFood("doughnut_cooked", "O");
*/
public static FoodForItem bun_raw = new FoodForItem("bun_raw").setFoodStats(2, 0.2F).setName("bun_raw").setColors(0xD9D481).setTextureFood("bun_raw");
public static FoodForItem bun_cooked = new FoodForItem("bun_cooked").setFoodStats(2, 0.2F).setName("bun_cooked").setColors(0xBB9949).setTextureFood("bun_cooked");
/*
public static FoodForItem bun_red_raw = new FoodForItem("bun_red_raw").setFoodStats(2, 0.2F).setName("bun_red_raw").setColors(0xD9D481, 0xFF0000).setTextureFood("bun_raw", "O");
public static FoodForItem bun_red_cooked = new FoodForItem("bun_red_cooked").setFoodStats(2, 0.2F).setName("bun_red_cooked").setColors(0xBB9949, 0xFF0000).setTextureFood("bun_cooked", "O");
public static FoodForItem bun_green_raw = new FoodForItem("bun_green_raw").setFoodStats(2, 0.2F).setName("bun_green_raw").setColors(0xD9D481, 0x00FF00).setTextureFood("bun_raw", "O");
public static FoodForItem bun_green_cooked = new FoodForItem("bun_green_cooked").setFoodStats(2, 0.2F).setName("bun_green_cooked").setColors(0xBB9949, 0x00FF00).setTextureFood("bun_cooked", "O");
public static FoodForItem bun_blue_raw = new FoodForItem("bun_blue_raw").setFoodStats(2, 0.2F).setName("bun_blue_raw").setColors(0xD9D481, 0x0000FF).setTextureFood("bun_raw", "O");
public static FoodForItem bun_blue_cooked = new FoodForItem("bun_blue_cooked").setFoodStats(2, 0.2F).setName("bun_blue_cooked").setColors(0xBB9949, 0x0000FF).setTextureFood("bun_cooked", "O");
*/
public static FoodForItem tortilla = new FoodForItem("tortilla").setFoodStats(2, 0.2F).setName("tortilla").setColors(0xFFFFFF).setTextureFood("tortilla");
public static FoodForItem bond01 = new FoodForItem("bond01").setFoodStats(2, 0.2F).setName("bond01").setColors(0xFFFFFF).setTextureFood("bond01");
public static FoodForItem bond02 = new FoodForItem("bond02").setFoodStats(2, 0.2F).setName("bond02").setColors(0xFFFFFF).setTextureFood("bond02");
public static FoodForItem bread_loaf = new FoodForItem("bread_loaf").setFoodStats(2, 0.2F).setName("bread_loaf").setColors(0xFFFFFF).setTextureFood("bread_loaf");
public static FoodForItem bread_long_loaf = new FoodForItem("bread_long_loaf").setFoodStats(2, 0.2F).setName("bread_long_loaf").setColors(0xFFFFFF).setTextureFood("bread_long_loaf");
public static FoodForItem bread_rye_loaf = new FoodForItem("bread_rye_loaf").setFoodStats(2, 0.2F).setName("bread_rye_loaf").setColors(0xFFFFFF).setTextureFood("bread_rye_loaf");
public static FoodForItem bread_rolls = new FoodForItem("bread_rolls").setFoodStats(2, 0.2F).setName("bread_rolls").setColors(0xFFFFFF).setTextureFood("bread_rolls");
public static FoodForItem breadcrumbs = new FoodForItem("breadcrumbs").setFoodStats(2, 0.2F).setName("breadcrumbs").setColors(0xFFFFFF).setTextureFood("breadcrumbs");
public static FoodForItem waffle = new FoodForItem("waffle").setFoodStats(2, 0.2F).setName("waffle").setColors(0xFFFFFF).setTextureFood("waffle");
public static FoodForItem waffle_cone = new FoodForItem("waffle_cone").setFoodStats(2, 0.2F).setName("waffle_cone").setColors(0xFFFFFF).setTextureFood("waffle_cone");
public static FoodForItem ice_small = new FoodForItem("ice_small").setFoodStats(2, 0.2F).setName("ice_small").setColors(0xFFFFFF).setTextureFood("ice_small");
public static FoodForItem icecream_ball = new FoodForItem("icecream_ball").setFoodStats(2, 0.2F).setName("icecream_ball").setColors(0xFFFFFF).setTextureFood("icecream_ball");
public static FoodForItem icecream_waffle_cone = new FoodForItem("icecream_waffle_cone").setFoodStats(2, 0.2F).setName("icecream_waffle_cone").setColors(0xFFFFFF).setTextureFood("icecream_waffle_cone", "O");
public static FoodForItem icecream_stick = new FoodForItem("icecream_stick").setFoodStats(2, 0.2F).setName("icecream_stick").setColors(0xFFFFFF).setTextureFood("icecream_stick", "O");
public static FoodForItem icecream_plate = new FoodForItem("icecream_plate").setFoodStats(2, 0.2F).setName("icecream_plate").setColors(0xFFFFFF).setTextureFood("icecream_plate", "O");
public static FoodForItem candy01 = new FoodForItem("candy01").setFoodStats(2, 0.2F).setName("candy01").setColors(0xFFFFFF).setTextureFood("candy01");
public static FoodForItem lolipops01 = new FoodForItem("lolipops01").setFoodStats(2, 0.2F).setName("lolipops01").setColors(0xFFFFFF).setTextureFood("lolipops01", "O");
public static FoodForItem lolipops02 = new FoodForItem("lolipops02").setFoodStats(2, 0.2F).setName("lolipops02").setColors(0xFFFFFF).setTextureFood("lolipops02", "O");
public static FoodForItem egg_raw = new FoodForItem("egg_raw").setFoodStats(1, 0.2F).setName("egg_raw").setColors(0xFFFFFF).setTextureFood("egg_raw");
public static FoodForItem egg_fried = new FoodForItem("egg_fried").setFoodStats(2, 0.2F).setName("egg_fried").setColors(0xFFFFFF).setTextureFood("egg_fried");
public static FoodForItem egg_boiled = new FoodForItem("egg_boiled").setFoodStats(2, 0.2F).setName("egg_boiled").setColors(0xFFFFFF).setTextureFood("egg_boiled");
public static FoodForItem chocobar = new FoodForItem("chocobar").setFoodStats(2, 0.2F).setName("chocobar").setColors(0xFFFFFF).setTextureFood("chocobar");
public static FoodForItem cheese = new FoodForItem("cheese").setFoodStats(2, 0.2F).setName("cheese").setColors(0xFFFFFF).setTextureFood("cheese");
public static FoodForItem cheese_part = new FoodForItem("cheese_part").setFoodStats(2, 0.2F).setName("cheese_part").setColors(0xFFFFFF).setTextureFood("cheese_part");

public static FoodForItem cocoa_powder = new FoodForItem("cocoa_powder").setFoodStats(1, 0.0F).setName("cocoa_powder").setTextureFood("cocoa_powder");
public static FoodForItem butter = new FoodForItem("butter").setFoodStats(2, 0.2F).setName("butter").setTextureFood("butter");
public static FoodForItem nutella = new FoodForItem("nutella").setFoodStats(2, 0.2F).setName("nutella").setColors(0xFFFFFF).setTextureFood("nutella");

public static FoodForItem sushi = new FoodForItem("sushi").setFoodStats(2, 0.2F).setName("sushi").setColors(0xFFFFFF).setTextureFood("sushi", "O");
public static FoodForItem sushi_roll = new FoodForItem("sushi_roll").setFoodStats(2, 0.2F).setName("sushi_roll").setColors(0xFFFFFF).setTextureFood("sushi_roll");
public static FoodForItem roll = new FoodForItem("roll").setFoodStats(2, 0.2F).setName("roll").setColors(0xFFFFFF).setTextureFood("roll");
public static FoodForItem roll_red = new FoodForItem("roll_red").setFoodStats(2, 0.2F).setName("roll_red").setColors(0xFFFFFF, 0xFF0000).setTextureFood("roll", "O");
public static FoodForItem roll_green = new FoodForItem("roll_green").setFoodStats(2, 0.2F).setName("roll_green").setColors(0xFFFFFF, 0x00FF00).setTextureFood("roll");
public static FoodForItem roll_blue = new FoodForItem("roll_blue").setFoodStats(2, 0.2F).setName("roll_blue").setColors(0xFFFFFF, 0x0000FF).setTextureFood("roll", "O");

public static FoodForItem frankfurter_stick_raw = new FoodForItem("frankfurter_stick_raw").setFoodStats(2, 0.2F).setName("frankfurter_stick_raw").setColors(0xFFFFFF).setTextureFood("frankfurter_stick_raw");
public static FoodForItem frankfurter_stick_fried = new FoodForItem("frankfurter_stick_fried").setFoodStats(2, 0.2F).setName("frankfurter_stick_fried").setColors(0xBE7F7F).setTextureFood("frankfurter_stick_fried");
public static FoodForItem frankfurter_stick_boiled = new FoodForItem("frankfurter_stick_boiled").setFoodStats(2, 0.2F).setName("frankfurter_stick_boiled").setColors(0xDEBEBE).setTextureFood("frankfurter_stick_boiled");
public static FoodForItem sausage = new FoodForItem("sausage").setFoodStats(2, 0.2F).setName("sausage").setColors(0xFFFFFF).setTextureFood("sausage");
public static FoodForItem hotdog = new FoodForItem("hotdog").setFoodStats(2, 0.2F).setName("hotdog").setColors(0xFFFFFF).setTextureFood("hotdog");
public static FoodForItem corndog_raw = new FoodForItem("corndog_raw").setFoodStats(2, 0.2F).setName("corndog_raw").setColors(0xFFFFFF).setTextureFood("corndog_raw");
public static FoodForItem corndog_fried = new FoodForItem("corndog_fried").setFoodStats(2, 0.2F).setName("corndog_fried").setColors(0xFFFFFF).setTextureFood("corndog_fried");
public static FoodForItem corndog_stick_raw = new FoodForItem("corndog_stick_raw").setFoodStats(2, 0.2F).setName("corndog_stick_raw").setColors(0xFFFFFF).setTextureFood("corndog_stick_raw");
public static FoodForItem corndog_stick_fried = new FoodForItem("corndog_stick_fried").setFoodStats(2, 0.2F).setName("corndog_stick_fried").setColors(0xFFFFFF).setTextureFood("corndog_stick_fried");

public static FoodForItem sandwich_beef_fried = new FoodForItem("sandwich_beef_fried").setFoodStats(2, 0.2F).setName("sandwich_beef_fried").setColors(0xFFFFFF).setTextureFood("sandwich_beef_fried");
public static FoodForItem sandwich_carrot = new FoodForItem("sandwich_carrot").setFoodStats(2, 0.2F).setName("sandwich_carrot").setColors(0xFFFFFF).setTextureFood("sandwich_carrot");
public static FoodForItem sandwich_chiken_fried = new FoodForItem("sandwich_chiken_fried").setFoodStats(2, 0.2F).setName("sandwich_chiken_fried").setColors(0xFFFFFF).setTextureFood("sandwich_chiken_fried");
public static FoodForItem sandwich_fish = new FoodForItem("sandwich_fish").setFoodStats(2, 0.2F).setName("sandwich_fish").setColors(0xFFFFFF).setTextureFood("sandwich_fish");
public static FoodForItem sandwich_porkchop_fried = new FoodForItem("sandwich_porkchop_fried").setFoodStats(2, 0.2F).setName("sandwich_porkchop_fried").setColors(0xFFFFFF).setTextureFood("sandwich_porkchop_fried");
public static FoodForItem sandwich_potato = new FoodForItem("sandwich_potato").setFoodStats(2, 0.2F).setName("sandwich_potato").setColors(0xFFFFFF).setTextureFood("sandwich_potato");
public static FoodForItem sandwich_rotten_flesh = new FoodForItem("sandwich_rotten_flesh").setFoodStats(2, 0.2F).setName("sandwich_rotten_flesh").setColors(0xFFFFFF).setTextureFood("sandwich_rotten_flesh");

public static FoodForItem sandwich_dual_beef_fried = new FoodForItem("sandwich_dual_beef_fried").setFoodStats(2, 0.2F).setName("sandwich_beef_fried").setColors(0xFFFFFF).setTextureFood("sandwich_dual_beef_fried");
public static FoodForItem sandwich_dual_carrot = new FoodForItem("sandwich_dual_carrot").setFoodStats(2, 0.2F).setName("sandwich_carrot").setColors(0xFFFFFF).setTextureFood("sandwich_dual_carrot");
public static FoodForItem sandwich_dual_chiken_fried = new FoodForItem("sandwich_dual_chiken_fried").setFoodStats(2, 0.2F).setName("sandwich_chiken_fried").setColors(0xFFFFFF).setTextureFood("sandwich_dual_chiken_fried");
public static FoodForItem sandwich_dual_fish = new FoodForItem("sandwich_dual_fish").setFoodStats(2, 0.2F).setName("sandwich_fish").setColors(0xFFFFFF).setTextureFood("sandwich_dual_fish");
public static FoodForItem sandwich_dual_porkchop_fried = new FoodForItem("sandwich_dual_porkchop_fried").setFoodStats(2, 0.2F).setName("sandwich_porkchop_fried").setColors(0xFFFFFF).setTextureFood("sandwich_dual_porkchop_fried");
public static FoodForItem sandwich_dual_potato = new FoodForItem("sandwich_dual_potato").setFoodStats(2, 0.2F).setName("sandwich_potato").setColors(0xFFFFFF).setTextureFood("sandwich_dual_potato");
public static FoodForItem sandwich_dual_rotten_flesh = new FoodForItem("sandwich_dual_rotten_flesh").setFoodStats(2, 0.2F).setName("sandwich_rotten_flesh").setColors(0xFFFFFF).setTextureFood("sandwich_dual_rotten_flesh");

public static FoodForItem burger = new FoodForItem("burger").setFoodStats(2, 0.3F).setName("burger").setColors(0xFFFFFF).setTextureFood("burger");
public static FoodForItem burger_meat_beef = new FoodForItem("burger_meat_beef").setFoodStats(5, 0.5F).setName("burger_meat_beef").setColors(0xFFFFFF).setTextureFood("burger_meat_beef");
public static FoodForItem burger_meat_chicken = new FoodForItem("burger_meat_chicken").setFoodStats(5, 0.5F).setName("burger_meat_chicken").setColors(0xFFFFFF).setTextureFood("burger_meat_chicken");
public static FoodForItem burger_meat_mutton = new FoodForItem("burger_meat_mutton").setFoodStats(5, 0.5F).setName("burger_meat_mutton").setColors(0xFFFFFF).setTextureFood("burger_meat_mutton");
public static FoodForItem burger_meat_goat = new FoodForItem("burger_meat_goat").setFoodStats(5, 0.5F).setName("burger_meat_goat").setColors(0xFFFFFF).setTextureFood("burger_meat_goat");
public static FoodForItem burger_meat_pork = new FoodForItem("burger_meat_pork").setFoodStats(5, 0.5F).setName("burger_meat_pork").setColors(0xFFFFFF).setTextureFood("burger_meat_pork");
public static FoodForItem burger_meat_horse = new FoodForItem("burger_meat_horse").setFoodStats(5, 0.5F).setName("burger_meat_horse").setColors(0xFFFFFF).setTextureFood("burger_meat_horse");
public static FoodForItem burger_meat_squid = new FoodForItem("burger_meat_squid").setFoodStats(5, 0.5F).setName("burger_meat_squid").setColors(0xFFFFFF).setTextureFood("burger_meat_squid");
public static FoodForItem burger_meat_fish = new FoodForItem("burger_meat_fish").setFoodStats(5, 0.5F).setName("burger_meat_fish").setColors(0xFFFFFF).setTextureFood("burger_meat_fish");
public static FoodForItem burger_cheese = new FoodForItem("burger_cheese").setFoodStats(3, 0.35F).setName("burger_cheese").setColors(0xFFFFFF).setTextureFood("burger_cheese");
public static FoodForItem burger_tomato = new FoodForItem("burger_tomato").setFoodStats(2, 0.3F).setName("burger_tomato").setColors(0xFFFFFF).setTextureFood("burger_tomato");
public static FoodForItem burger_lettuce = new FoodForItem("burger_lettuce").setFoodStats(2, 0.2F).setName("burger_lettuce").setColors(0xFFFFFF).setTextureFood("burger_lettuce");

public static FoodForItem pie_part = new FoodForItem("pie_part").setFoodStats(2, 0.2F).setName("pie_part").setColors(0xFFFFFF, 0xFFFFFF).setTextureFood("pie_part", "O");
/*
public static FoodForItem pie_red_part = new FoodForItem("pie_red_part").setFoodStats(2, 0.2F).setName("pie_red_part").setColors(0xFFFFFF, 0xFF0000).setTextureFood("pie_part", "O");
public static FoodForItem pie_green_part = new FoodForItem("pie_green_part").setFoodStats(2, 0.2F).setName("pie_green_part").setColors(0xFFFFFF, 0x00FF00).setTextureFood("pie_part", "O");
public static FoodForItem pie_blue_part = new FoodForItem("pie_blue_part").setFoodStats(2, 0.2F).setName("pie_blue_part").setColors(0xFFFFFF, 0x0000FF).setTextureFood("pie_part", "O");
*/
public static FoodForItem pizza_part = new FoodForItem("pizza_part").setFoodStats(2, 0.2F).setName("pizza_part").setColors(0xFFFFFF, 0xFFFFFF).setTextureFood("pizza_part", "O");
/*
public static FoodForItem pizza_red_part = new FoodForItem("pizza_red_part").setFoodStats(2, 0.2F).setName("pizza_red_part").setColors(0xFFFFFF, 0xFF0000).setTextureFood("pizza_part", "O");
public static FoodForItem pizza_green_part = new FoodForItem("pizza_green_part").setFoodStats(2, 0.2F).setName("pizza_green_part").setColors(0xFFFFFF, 0x00FF00).setTextureFood("pizza_part", "O");
public static FoodForItem pizza_blue_part = new FoodForItem("pizza_blue_part").setFoodStats(2, 0.2F).setName("pizza_blue_part").setColors(0xFFFFFF, 0x0000FF).setTextureFood("pizza_part", "O");
*/
public static FoodForItem sugar_stick_white = new FoodForItem("sugar_stick_white").setFoodStats(2, 0.2F).setName("sugar_stick_white").setColors(0xFFFFFF).setTextureFood("sugar_stick01", "O");
public static FoodForItem boiled_sugar = new FoodForItem("boiled_sugar").setFoodStats(2, 0.2F).setName("boiled_sugar").setColors(0xFFFFFF).setTextureFood("boiled_sugar");
public static FoodForItem cotton_candy = new FoodForItem("cotton_candy").setFoodStats(2, 0.2F).setName("cotton_candy").setColors(0xFFFFFF).setTextureFood("cotton_candy");
public static FoodForItem cotton_candy_stick = new FoodForItem("cotton_candy_stick").setFoodStats(2, 0.2F).setName("cotton_candy_stick").setColors(0xFFFFFF).setTextureFood("cotton_candy_stick", "O");
public static FoodForItem marshmallow_raw_stick = new FoodForItem("marshmallow_raw_stick").setFoodStats(2, 0.2F).setName("marshmallow_raw_stick").setColors(0xFFFFFF).setTextureFood("marshmallow_raw_stick", "O");
public static FoodForItem marshmallow_fried_stick = new FoodForItem("marshmallow_fried_stick").setFoodStats(2, 0.2F).setName("marshmallow_fried_stick").setColors(0xCC9944).setTextureFood("marshmallow_fried_stick", "O");
public static FoodForItem taco = new FoodForItem("taco").setFoodStats(2, 0.2F).setName("taco").setColors(0xFFFFFF).setTextureFood("taco");
public static FoodForItem kebab = new FoodForItem("kebab").setFoodStats(2, 0.2F).setName("kebab").setColors(0xFFFFFF).setTextureFood("kebab");
public static FoodForItem toast = new FoodForItem("toast").setFoodStats(2, 0.2F).setName("toast").setColors(0xFFFFFF).setTextureFood("toast");
public static FoodForItem toast_butter = new FoodForItem("toast_butter").setFoodStats(2, 0.2F).setName("toast_butter").setColors(0xFFFFFF).setTextureFood("toast");
public static FoodForItem toast_nutella = new FoodForItem("toast_nutella").setFoodStats(2, 0.2F).setName("toast_nutella").setColors(0xFFFFFF).setTextureFood("toast");
public static FoodForItem cookie = new FoodForItem().setFoodStats(2, 0.2F).setName("cookie").setColors(0xFFFFFF).setTextureFood("cookie");
/*
public static FoodForItem test1 = new FoodForItem("test1").setFoodStats(2, 0.2F).setName("cookie").setColors(0xFFFFFF).setTexture("test_1", "O");
public static FoodForItem test2 = new FoodForItem("test2").setFoodStats(2, 0.2F).setName("cookie").setColors(0xFFFFFF).setTextureFood("test_1", "O");
*/
/*
@SideOnly(Side.CLIENT) private IIcon[] icon_tex;
@SideOnly(Side.CLIENT) private IIcon[] icon_ovl;
*/
@SideOnly(Side.CLIENT) private IIcon[][] icon_g;

public ItemFoods() {
super(id);
setCreativeTab(PackStock.proxy.tabFoodPack);
setHasSubtypes(true);
setMaxDamage(0);
setTextureName("timaxa007:");
setUnlocalizedName("foods");
}
/*
public enum foods {
Cocoa_powder(1, 0.3F, null, "cocoa_powder", true, 0xE79042, 0xFF0000), 
Flour_wheat(1, 0.1F, new int[][] {{Potion.confusion.id, 20 * 5, 0}}, "flour", false, 0xDDDDDD, 0xFFFFFF), 
Flour_rye(1, 0.1F, new int[][] {{Potion.confusion.id, 20 * 5, 0}}, "flour", false, 0x855A3E, 0xFFFFFF), 
Flour_rise(1, 0.1F, new int[][] {{Potion.confusion.id, 20 * 5, 0}}, "flour", false, 0xFFFFFF, 0xFFFFFF), 

Dough(1, 0.1F, new int[][] {{Potion.confusion.id, 20 * 5, 0}}), 
Batter(1, 0.1F, new int[][] {{Potion.confusion.id, 20 * 5, 0}}), 
Batter_pancake(1, 0.1F, new int[][] {{Potion.confusion.id, 20 * 5, 0}}), 
;

private int level;
private float sat;
private int[][] effects;
private String texture;
private boolean pass;
private int hex1;
private int hex2;

static boolean hasStrCode(String str) {
for (foods j : foods.values()) {
if (str.equalsIgnoreCase(j.toString())) {
return true;
}
}
return false;
}

foods(int lvl, float p_sat, int[][] efcts, String tex, boolean ren_pass, int p_hex1, int p_hex2) {
level = lvl;
sat = p_sat;
effects = efcts;
texture = tex;
pass = ren_pass;
hex1 = p_hex1;
if (p_hex1 != 0xFFFFFF || p_hex1 != 16777215) {
int clr1 = p_hex1;int clr2 = p_hex2;
int r1 = (int)(clr1 >> 16 & 255);int g1 = (int)(clr1 >> 8 & 255);int b1 = (int)(clr1 >> 0 & 255);
int r2 = (int)(clr2 >> 16 & 255);int g2 = (int)(clr2 >> 8 & 255);int b2 = (int)(clr2 >> 0 & 255);
int r3 = ((r1 + (r2 * 2)) / 3);int g3 = ((g1 + (g2 * 2)) / 3);int b3 = ((b1 + (b2 * 2)) / 3);
hex2 = (int)r3 << 16 | (int)g3 << 8 | (int)b3;
} else {
hex2 = p_hex2;
}
}

foods(int lvl, float p_sat, int[][] efcts, String tex, boolean ren_pass) {
level = lvl;
sat = p_sat;
effects = efcts;
texture = tex;
pass = ren_pass;
hex1 = 0xFFFFFF;
hex2 = 0xFFFFFF;
}

foods(int lvl, float p_sat, int[][] efcts, boolean ren_pass) {
level = lvl;
sat = p_sat;
effects = efcts;
texture = toString().toLowerCase();
pass = ren_pass;
hex1 = 0xFFFFFF;
hex2 = 0xFFFFFF;
}

foods(int lvl, float p_sat, int[][] efcts) {
level = lvl;
sat = p_sat;
effects = efcts;
texture = toString().toLowerCase();
pass = false;
hex1 = 0xFFFFFF;
hex2 = 0xFFFFFF;
}

foods(int lvl, float p_sat) {
level = lvl;
sat = p_sat;
effects = null;
texture = toString().toLowerCase();
pass = false;
hex1 = 0xFFFFFF;
hex2 = 0xFFFFFF;
}

}
//-----------------------------------------------------------------------------------------------
public enum spices {
Sugar(0.0F), 
Vanilla(0.0F), 
Sail(0.0F), 
Ground_paper_black(0.0F), 
Ground_paper_white(0.0F), 
Ground_paper_red(0.0F), 
Ground_paper_chili(0.0F), 
Ground_cinnamon(0.0F), 
Ground_nutmeg(0.0F), 

Allspice(0.0F), 
Ginger(0.0F), 
Canella(0.0F), 
Curcuma(0.0F), 
Bay(0.0F), 
Rosemary(0.0F), 
Citron(0.0F), 
Crocus(0.0F), 

NONE(0.0F);

private float spices_sat;

static boolean hasStrCode(String str) {
for (spices j : spices.values()) {
if (str.equalsIgnoreCase(j.toString())) {
return true;
}
}
return false;
}

spices(float sat_spices) {
spices_sat = sat_spices;
}

}
//-----------------------------------------------------------------------------------------------
public enum sauce {
Sauce_tomato(0.0F, 0xFFFFFF), 
Sauce_mayo(0.0F, 0xFFFFFF), 
Sauce_mustard(0.0F, 0xFFFFFF), 
Sauce_horseradish(0.0F, 0xFFFFFF), 
Sauce_sour_cream(0.0F, 0xFFFFFF), 
Sauce_cream(0.0F, 0xFFFFFF), 
Sauce_milk(0.0F, 0xFFFFFF), 
Sauce_mushroom(0.0F, 0xFFFFFF), 
Sauce_cheese(0.0F, 0xFFFFFF), 
Sauce_vanilla(0.0F, 0xFFFFFF), 
Sauce_chocolate(0.0F, 0xFFFFFF), 
Sauce_lemon(0.0F, 0xFFFFFF), 
Sauce_fruit(0.0F, 0xFFFFFF), 
Sauce_berry(0.0F, 0xFFFFFF), 
NONE(0.0F, 0xFFFFFF);

private float sauce_sat;
private int sauce_hex;

static boolean hasStrCode(String str) {
for (sauce j : sauce.values()) {
if (str.equalsIgnoreCase(j.toString())) {
return true;
}
}
return false;
}

sauce(float sat_sauce, int hex_sauce) {
sauce_sat = sat_sauce;
sauce_hex = hex_sauce;
}

}
*/
//-----------------------------------------------------------------------------------------------
public void onUpdate(ItemStack is, World world, Entity entity, int par4, boolean flag) {
if (!world.isRemote) {
NBTTagCompound tag = is.getTagCompound();
//-------------------------
if (tag == null) {
tag = new NBTTagCompound();
tag.setByte("Spoilage", (byte)0);
}
//-------------------------
if (tag != null) {
if (tag.hasKey("Spoilage")) {
if (tag.getByte("Spoilage") > 126) {
--is.stackSize;
/*
} else if (tag.getByte("Spoilage") < 0) {
*/
} else {
if (world.getWorldTime() % (20 * 60) == 0) {
tag.setByte("Spoilage", (byte)(tag.getByte("Spoilage") + 1));
}
}
}
}
//-------------------------
}
}
//-----------------------------------------------------------------------------------------------
public ItemStack onEaten(ItemStack is, World world, EntityPlayer player) {
if (!player.capabilities.isCreativeMode) {--is.stackSize;}
if (!world.isRemote) {
//player.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(100.0D);
}
return is;
}

public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer player) {
player.setItemInUse(is, getMaxItemUseDuration(is));
return is;
}

public int getMaxItemUseDuration(ItemStack is) {
NBTTagCompound tag = is.getTagCompound();
if (tag != null && tag.hasKey("NameID")) {
return FoodForItem.food_list[FoodForItem.getID_tag(tag.getString("NameID"))].getSpeedOfEating();
} else if (tag != null && tag.hasKey("ItemID")) {
return FoodForItem.food_list[tag.getInteger("ItemID")].getSpeedOfEating();
} else {
return 64;
}
}

public EnumAction getItemUseAction(ItemStack is) {
return EnumAction.eat;
}

public String getUnlocalizedName(ItemStack is) {
NBTTagCompound tag = is.getTagCompound();
if (tag != null && tag.hasKey("NameID")) {
return "food." + FoodForItem.food_list[FoodForItem.getID_tag(tag.getString("NameID"))].getName();
} else if (tag != null && tag.hasKey("ItemID")) {
return "food." + FoodForItem.food_list[tag.getInteger("ItemID")].getName();
}
return super.getUnlocalizedName();
}

public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
NBTTagCompound tag = is.getTagCompound();
if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
if (tag != null) {

if (Core.show_tip_info_testing) {

if (tag.hasKey("NameID")) {
if (FoodForItem.food_list[FoodForItem.getID_tag(tag.getString("NameID"))] != null) {
list.add("NameID: " + tag.getString("NameID") + " / [-] ID:" + FoodForItem.getID_tag(tag.getString("NameID")) + ".");
//if (FoodForItem.food_list[FoodForItem.getID_tag(tag.getString("NameID"))].getType() != null) {
list.add(Option.getText("Type") + ": " + FoodForItem.food_list[FoodForItem.getID_tag(tag.getString("NameID"))].getLocalizedType() + ".");
//}
} else {
list.add("Bag Item is in NameID: " + tag.getString("NameID") + ".");
}
}

if (tag.hasKey("ItemID")) {
if (FoodForItem.food_list[tag.getInteger("ItemID")] != null) {
list.add("NameID: " + FoodForItem.food_list[tag.getInteger("ItemID")].tagID + " [-] / ItemID: " + tag.getInteger("ItemID") + ".");
//if (FoodForItem.food_list[tag.getInteger("ItemID")].getType() != null) {
list.add(Option.getText("Type") + ": " + FoodForItem.food_list[tag.getInteger("ItemID")].getLocalizedType() + ".");
//}
} else {
list.add("Bag Item is in ItemID: " + tag.getInteger("ItemID") + ".");
}
}

if (tag.hasKey("ColorHex")) {

int clr = tag.getInteger("ColorHex");
int r = (int)(clr >> 16 & 255);int g = (int)(clr >> 8 & 255);int b = (int)(clr >> 0 & 255);

list.add("Color: R - " + r + ", G - " + g + ", B - " + b + ".");
}

if (tag.hasKey("ColorHex")) {

int clr = tag.getInteger("ColorHex");
int r = (int)(clr >> 16 & 255);int g = (int)(clr >> 8 & 255);int b = (int)(clr >> 0 & 255);

list.add("Color: R - " + r + ", G - " + g + ", B - " + b + ".");
}

if (tag.hasKey("ColorHex")) {

int clr = tag.getInteger("ColorHex");
int r = (int)(clr >> 16 & 255);int g = (int)(clr >> 8 & 255);int b = (int)(clr >> 0 & 255);

list.add("Spoilage:" + tag.getByte("Spoilage") + ".");
}

}

/*
list.add("Saturation Level: " + foods.valueOf(tag.getString("NameID")).level + ".");

if (!tag.hasKey("Sat")) {
list.add("Saturation: " + foods.valueOf(tag.getString("NameID")).sat + ".");
} else {
list.add("Saturation*: " + tag.getFloat("Sat") + ".");
}

*/

}
} else {
list.add(Option.prshift);
}
}

@SideOnly(Side.CLIENT)
public void getSubItems(int id, CreativeTabs table, List list) {
for (int i = 0; i < FoodForItem.food_list.length; i++) {
if (FoodForItem.food_list[i] != null && FoodForItem.food_list[i].tagID != null) {
list.add(addTag(FoodForItem.food_list[i].tagID));
} else if (FoodForItem.food_list[i] != null && FoodForItem.food_list[i].tagID == null) {
list.add(addTag(i));
}
}
//list.add(new ItemStack(id, 1, 0));
}

private static ItemStack addTag(String par1) {
ItemStack is = new ItemStack(PackStock.proxy.item_foods, 1, 0);
NBTTagCompound tag = new NBTTagCompound();
tag.setString("NameID", par1);
is.setTagCompound(tag);
return is;
}

private static ItemStack addTag(int par1) {
ItemStack is = new ItemStack(PackStock.proxy.item_foods, 1, 0);
NBTTagCompound tag = new NBTTagCompound();
tag.setInteger("ItemID", par1);
is.setTagCompound(tag);
return is;
}

//tag.setInteger("ColorHex", 0xFF0000);
//tag.setFloat("Sat", foods.valueOf(par1).sat);
//tag.setString("Ingredient_1", "");
//tag.setString("Ingredient_2", "");
//tag.setString("Ingredient_3", "");

@SideOnly(Side.CLIENT)
public boolean requiresMultipleRenderPasses() {return true;}

@SideOnly(Side.CLIENT)
public int getRenderPasses(int meta) {return 4;}

public IIcon getIcon(ItemStack is, int pass) {
NBTTagCompound tag = is.getTagCompound();
if (tag != null && tag.hasKey("NameID")) {
return icon_g[FoodForItem.getID_tag(tag.getString("NameID"))][pass];
} else if (tag != null && tag.hasKey("ItemID")) {
return icon_g[tag.getInteger("ItemID")][pass];
} else {
return itemIIcon;
}
}

@SideOnly(Side.CLIENT)
public int getColorFromItemStack(ItemStack is, int pass) {
NBTTagCompound tag = is.getTagCompound();
/*
if (renderPass == 0) {
	if (tag != null && tag.hasKey("NameID") && tag.hasKey("ColorHex") && foods.hasStrCode(tag.getString("NameID"))) {

int clr1 = foods.valueOf(tag.getString("NameID")).hex1;
int r1 = (int)(clr1 >> 16 & 255);int g1 = (int)(clr1 >> 8 & 255);int b1 = (int)(clr1 >> 0 & 255);

int clr2 = tag.getInteger("ColorHex");
int r2 = (int)(clr2 >> 16 & 255);int g2 = (int)(clr2 >> 8 & 255);int b2 = (int)(clr2 >> 0 & 255);

int r3 = ((r1 + (r2 * 2)) / 3);int g3 = ((g1 + (g2 * 2)) / 3);int b3 = ((b1 + (b2 * 2)) / 3);

	return (int)r3 << 16 | (int)g3 << 8 | (int)b3;
	
	} else if (tag != null && tag.hasKey("NameID") && !tag.hasKey("ColorHex") && foods.hasStrCode(tag.getString("NameID"))) {
	return foods.valueOf(tag.getString("NameID")).hex1;
	} else {return 16777215;}
} else {
	if (tag != null && tag.hasKey("NameID") && foods.hasStrCode(tag.getString("NameID"))) {
	return foods.valueOf(tag.getString("NameID")).hex2;
	} else {return 16777215;}
}*/

if (tag != null && tag.hasKey("NameID") && tag.hasKey("ColorHex")) {

int clr1 = FoodForItem.food_list[FoodForItem.getID_tag(tag.getString("NameID"))].getColor(pass);;
int r1 = (int)(clr1 >> 16 & 255);int g1 = (int)(clr1 >> 8 & 255);int b1 = (int)(clr1 >> 0 & 255);
int clr2 = tag.getInteger("ColorHex");
int r2 = (int)(clr2 >> 16 & 255);int g2 = (int)(clr2 >> 8 & 255);int b2 = (int)(clr2 >> 0 & 255);
//int r3 = ((r1 + (r2 * 2)) / 3);int g3 = ((g1 + (g2 * 2)) / 3);int b3 = ((b1 + (b2 * 2)) / 3);
int r3 = ((r1 + r2) / 2);int g3 = ((g1 + g2) / 2);int b3 = ((b1 + b2) / 2);
return (int)r3 << 16 | (int)g3 << 8 | (int)b3;

} else if (tag != null && tag.hasKey("ItemID") && tag.hasKey("ColorHex")) {

int clr1 = FoodForItem.food_list[tag.getInteger("ItemID")].getColor(pass);
int r1 = (int)(clr1 >> 16 & 255);int g1 = (int)(clr1 >> 8 & 255);int b1 = (int)(clr1 >> 0 & 255);
int clr2 = tag.getInteger("ColorHex");
int r2 = (int)(clr2 >> 16 & 255);int g2 = (int)(clr2 >> 8 & 255);int b2 = (int)(clr2 >> 0 & 255);
//int r3 = ((r1 + (r2 * 2)) / 3);int g3 = ((g1 + (g2 * 2)) / 3);int b3 = ((b1 + (b2 * 2)) / 3);
int r3 = ((r1 + r2) / 2);int g3 = ((g1 + g2) / 2);int b3 = ((b1 + b2) / 2);
return (int)r3 << 16 | (int)g3 << 8 | (int)b3;

} else if (tag != null && tag.hasKey("NameID")) {
return FoodForItem.food_list[FoodForItem.getID_tag(tag.getString("NameID"))].getColor(pass);
} else if (tag != null && tag.hasKey("ItemID")) {
return FoodForItem.food_list[tag.getInteger("ItemID")].getColor(pass);
} else {
return 16777215;
}
}

@SideOnly(Side.CLIENT)
public void registerIcons(IIconRegister ir) {
super.registerIcons(ir);
itemIIcon = ir.registerIcon(getIconString() + "foods/food");
icon_g = new IIcon[FoodForItem.food_list.length][4];
for (int i = 0; i < FoodForItem.food_list.length; i++) {
for (int j = 0; j < 4; j++) {
if ( FoodForItem.food_list[i] != null) {
icon_g[i][j] = ir.registerIcon(getIconString() + FoodForItem.food_list[i].getTexture(j));
} else {
icon_g[i][j] = itemIIcon;
}
}
}
/*
icon_tex = new IIcon[FoodForItem.food_list.length];
icon_ovl = new IIcon[FoodForItem.food_list.length];
for (int i = 0; i < FoodForItem.food_list.length; i++) {
if (FoodForItem.food_list[i] != null) {
icon_tex[i] = ir.registerIcon(getIconString() + FoodForItem.food_list[i].getTexture(0));
	if (FoodForItem.food_list[i].getTexture(1) == FoodForItem.food_list[i].getTexture(0)) {
	icon_ovl[i] = ir.registerIcon(getIconString() + "empty");
	} else {
	icon_ovl[i] = ir.registerIcon(getIconString() + FoodForItem.food_list[i].getTexture(1));
	}
} else {
icon_tex[i] = itemIIcon;
icon_ovl[i] = itemIIcon;
}
}
*/
}

}
