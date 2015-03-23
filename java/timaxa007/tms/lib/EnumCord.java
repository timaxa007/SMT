package timaxa007.tms.lib;

public enum EnumCord{
NORTH(0, 0, 0, "north"), 
SOUTH(0, 0, 0, "south"), 
WEST(0, 0, 0, "west"), 
EAST(0, 0, 0, "east"), 
UP(0, 0, 0, "up"), 
DOWN(0, 0, 0, "down");

int xCr;
int yCr;
int zCr;
String sCr;

private EnumCord(int par1, int par2, int par3, String stg) {
this.xCr=par1;
this.yCr=par2;
this.zCr=par3;
this.sCr=stg;
}

public int getCordX() {return this.xCr;}
public int getCordY() {return this.yCr;}
public int getCordZ() {return this.zCr;}
public String getCordName() {return this.sCr;}

}

