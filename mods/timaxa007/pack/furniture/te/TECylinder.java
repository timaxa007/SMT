package mods.timaxa007.pack.furniture.te;

import net.minecraft.tileentity.TileEntity;

public class TECylinder extends TileEntity {

public float rot_x = 0.0F;
public float rot_y = 0.0F;

public TECylinder() {

}

public void updateEntity() {
rot_x += 0.1F;
rot_y += 0.2F;
if (rot_x > 255) {rot_x = 0;}
if (rot_y > 255) {rot_y = 0;}
}

}
