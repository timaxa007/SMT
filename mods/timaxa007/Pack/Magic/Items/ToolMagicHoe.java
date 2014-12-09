package mods.timaxa007.Pack.Magic.Items;

import mods.timaxa007.Pack.Magic.PackMagic;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ToolMagicHoe extends Item{
protected EnumToolMaterial theToolMaterial;

public ToolMagicHoe(int id, EnumToolMaterial par2) {
super(id);
this.setCreativeTab(PackMagic.proxy.tabMagicPack);
this.theToolMaterial=par2;
this.maxStackSize=1;
this.setMaxDamage(par2.getMaxUses());
this.setUnlocalizedName("magic.hoe");
}

public boolean onItemUse(ItemStack is, EntityPlayer player, World wrd, int x, int y, int z, int meta, float hitX, float hitY, float hitZ) {
if(!player.canPlayerEdit(x, y, z, meta, is)) {return false;}
else{
UseHoeEvent event=new UseHoeEvent(player, is, wrd, x, y, z);
if(MinecraftForge.EVENT_BUS.post(event)) {return false;}

if(event.getResult()==Result.ALLOW) {
is.damageItem(1, player);
return true;
}

int i1=wrd.getBlockId(x, y, z);
boolean air=wrd.isAirBlock(x, y+1, z);

if(i1==Block.cobblestone.blockID) {
Block block=Block.stone;
wrd.playSoundEffect((double)((float)x+0.5F), (double)((float)y+0.5F), (double)((float)z+0.5F), block.stepSound.getStepSound(), (block.stepSound.getVolume()+1.0F) / 2.0F, block.stepSound.getPitch() * 0.8F);

if(wrd.isRemote) {return true;}else{
wrd.setBlock(x, y, z, block.blockID);
is.damageItem(1, player);
}

return true;

} else if(i1==Block.bookShelf.blockID) {
Block block=Block.bookShelf;
wrd.playSoundEffect((double)((float)x+0.5F), (double)((float)y+0.5F), (double)((float)z+0.5F), block.stepSound.getStepSound(), (block.stepSound.getVolume()+1.0F) / 2.0F, block.stepSound.getPitch() * 0.8F);

if(wrd.isRemote) {return true;}else{
wrd.destroyBlock(x, y, z, false);

ItemStack isitem=new ItemStack(Item.book, 1, 0);
EntityItem entityitem=new EntityItem(wrd, (double)x+0.5D, (double)y+0.5D, (double)z+0.5D, isitem);
entityitem.delayBeforeCanPickup=32;
wrd.spawnEntityInWorld(entityitem);

is.damageItem(1, player);
}

return true;

} else if(i1==Block.dirt.blockID||i1==Block.grass.blockID||i1==Block.mycelium.blockID) {
Block block=Block.tilledField;
wrd.playSoundEffect((double)((float)x+0.5F), (double)((float)y+0.5F), (double)((float)z+0.5F), block.stepSound.getStepSound(), (block.stepSound.getVolume()+1.0F) / 2.0F, block.stepSound.getPitch() * 0.8F);

if(wrd.isRemote) {return true;}else{
wrd.setBlock(x, y, z, block.blockID);
/*
wrd.setBlock(x+1, y, z, block.blockID);
wrd.setBlock(x-1, y, z, block.blockID);
wrd.setBlock(x, y, z+1, block.blockID);
wrd.setBlock(x, y, z-1, block.blockID);
wrd.setBlock(x+1, y, z+1, block.blockID);
wrd.setBlock(x+1, y, z-1, block.blockID);
wrd.setBlock(x-1, y, z+1, block.blockID);
wrd.setBlock(x-1, y, z-1, block.blockID);
*/
is.damageItem(1, player);
}

return true;

} else if(i1==Block.tilledField.blockID) {
Block block=Block.tilledField;
wrd.playSoundEffect((double)((float)x+0.5F), (double)((float)y+0.5F), (double)((float)z+0.5F), block.stepSound.getStepSound(), (block.stepSound.getVolume()+1.0F) / 2.0F, block.stepSound.getPitch() * 0.8F);

if(wrd.isRemote) {return true;}else{
wrd.setBlock(x, y, z, block.blockID, 1, 2);
is.damageItem(1, player);
}

return true;

} else if(wrd.getBlockMaterial(x, y, z)==Material.wood) {
Block block=Block.wood;
wrd.playSoundEffect((double)((float)x+0.5F), (double)((float)y+0.5F), (double)((float)z+0.5F), block.stepSound.getStepSound(), (block.stepSound.getVolume()+1.0F) / 2.0F, block.stepSound.getPitch() * 0.8F);

if(wrd.isRemote) {return true;}else{
for(byte ia=0;ia<16;++ia) {
if(wrd.getBlockMaterial(x, y+ia, z)==Material.wood) {wrd.destroyBlock(x, y+ia, z, true);is.damageItem(1, player);
}else{break;}
}
}

return true;

}else{return false;}




}
}

@SideOnly(Side.CLIENT)
public boolean isFull3D() {
return true;
}

public String getMaterialName() {
return this.theToolMaterial.toString();
}

@SideOnly(Side.CLIENT)
public boolean hasEffect(ItemStack is) {return true;}

@Override
public void registerIcons(IconRegister ir) {
this.itemIcon=ir.registerIcon("timaxa007:" + "tool/" + "hoeMagic");
}

}
