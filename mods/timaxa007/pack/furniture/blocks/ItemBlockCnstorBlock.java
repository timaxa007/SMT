package mods.timaxa007.pack.furniture.blocks;

import java.util.List;

import mods.timaxa007.lib.Option;
import mods.timaxa007.pack.furniture.PackFurniture;
import mods.timaxa007.pack.furniture.te.TECnstorBlock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;

public class ItemBlockCnstorBlock extends ItemBlock {

public ItemBlockCnstorBlock(int id) {
super(id);
this.setMaxDamage(0);
this.setHasSubtypes(true);
}
/*
public boolean onItemUse(ItemStack is, EntityPlayer player, World wrd, int x, int y, int z, int meta, float hitX, float hitY, float hitZ) {
if(!player.canPlayerEdit(x, y, z, meta, is)) {return false;}
else{
if (hitX == 1.0F) {x++;}
if (hitX == 0.0F) {x--;}
if (hitZ == 1.0F) {z++;}
if (hitZ == 0.0F) {z--;}
if (hitY == 1.0F) {y++;}
if (hitY == 0.0F) {y--;}

wrd.setBlock(x, y, z, PackFurniture.proxy.blockCnstorBlock.blockID, 0, 3);
TileEntity te = wrd.getBlockTileEntity(x, y, z);
NBTTagCompound tag = is.getTagCompound();
if(te!=null && te instanceof TECnstorBlock) {

if (tag != null) {
if (tag.hasKey("Type")) {
((TECnstorBlock)te).setType(tag.getInteger("Type"));
} else {
((TECnstorBlock)te).setType(0);
}
if (tag.hasKey("Color")) {
((TECnstorBlock)te).setColor(tag.getInteger("Color"));
} else {
((TECnstorBlock)te).setColor(0);
}

} else {
((TECnstorBlock)te).setType(0);
((TECnstorBlock)te).setColor(0);
}
}
return true;
}
}
*/
public void addInformation(ItemStack is, EntityPlayer entity, List list, boolean flag) {
NBTTagCompound tag = is.getTagCompound();
if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
if (tag != null) {
if (tag.hasKey("Type")) {list.add("Type: " + tag.getInteger("Type") + ".");}
if (tag.hasKey("Color")) {list.add("Color: " + tag.getInteger("Color") + ".");}
}
} else {
list.add(Option.prshift);
}
}

}
