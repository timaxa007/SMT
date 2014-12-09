package mods.timaxa007.Pack.Stock.Lib;


public class EnumSaplingsGrowth {
//---------------------------------------
public enum tree {
Oak(), 
Spruce(), 
Birch(), 
Jungle(), 
NONE();

public static boolean hasStrCode(String str) {
for (tree j : tree.values()) {
if (str.equalsIgnoreCase(j.toString())) {
return true;
}
}
return false;
}

public String name;
public String log;
public String leaves;
public int height_max;
public int thickness_max;

tree() {
name = toString().toLowerCase();
log = "log_" + toString().toLowerCase();
leaves = "leaves_" + toString().toLowerCase();
height_max = 1;
thickness_max = 1;
}

}
//---------------------------------------
public enum structure_leaves {
Oak(
new int[][] {
{0, +1, 0}, 
{+1, 0, 0}, 
{-1, 0, 0}, 
{0, 0, +1}, 
{0, 0, -1}
}, 
new int[][] {
{0, +1, 0}, 
//{+1, 0, 0}, 
{+2, 0, 0}, 
//{-1, 0, 0}, 
{-2, 0, 0}, 
//{0, 0, +1}, 
{0, 0, +2}, 
//{0, 0, -1}, 
{0, 0, -2}, 
{+1, 0, +1}, 
{+1, 0, -1}, 
{-1, 0, +1}, 
{-1, 0, -1}
}, 
new int[][] {
//{0, +1, 0}, 
{+1, +1, 0}, 
{-1, +1, 0}, 
{0, +1, +1}, 
{0, +1, -1}, 
//{+1, 0, 0}, 
//{+2, 0, 0}, 
{+3, 0, 0}, 
//{-1, 0, 0}, 
//{-2, 0, 0}, 
{-3, 0, 0}, 
//{0, 0, +1}, 
//{0, 0, +2}, 
{0, 0, +3}, 
//{0, 0, -1}, 
//{0, 0, -2}, 
{0, 0, -3}, 
//{+1, 0, +1}, 
//{+1, 0, -1}, 
//{-1, 0, +1}, 
//{-1, 0, -1}, 
{+2, 0, +2}, 
{+2, 0, -2}, 
{-2, 0, +2}, 
{-2, 0, -2}, 
{+2, 0, +1}, 
{+2, 0, -1}, 
{-2, 0, +1}, 
{-2, 0, -1}, 
{+1, 0, +2}, 
{+1, 0, -2}, 
{-1, 0, +2}, 
{-1, 0, -2}
}, 
null, 
null), 
//Spruce(), 
//Birch(), 
//Jungle(), 
NONE(null, null, null, null, null);

public static boolean hasStrCode(String str) {
for (structure_leaves j : structure_leaves.values()) {
if (str.equalsIgnoreCase(j.toString())) {
return true;
}
}
return false;
}

public String name;
//public int[][] structure;
public int[][] stage_1;
public int[][] stage_2;
public int[][] stage_3;
public int[][] stage_4;
public int[][] stage_5;

structure_leaves(int[][] stg_1, int[][] stg_2, int[][] stg_3, int[][] stg_4, int[][] stg_5) {
name = toString().toLowerCase();
stage_1 = stg_1;
stage_2 = stg_2;
stage_3 = stg_3;
stage_4 = stg_4;
stage_5 = stg_5;
}

}
//---------------------------------------

}
