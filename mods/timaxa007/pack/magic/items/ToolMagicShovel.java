package mods.timaxa007.pack.magic.items;

import mods.timaxa007.pack.magic.PackMagic;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ToolMagicShovel extends ItemTool{
public static final Block[] blocksEffectiveAgainst=new Block[]{Block.grass, Block.dirt, Block.sand, Block.gravel, Block.snow, Block.blockSnow, Block.blockClay, Block.tilledField, Block.slowSand, Block.mycelium};

public ToolMagicShovel(int id, EnumToolMaterial par2) {
super(1, par2, blocksEffectiveAgainst);
this.setCreativeTab(PackMagic.proxy.tabMagicPack);
this.setUnlocalizedName("magic.shovel");
}

public boolean canHarvestBlock(Block par1Block) {
boolean total=false;
if(par1Block==Block.snow) {total=true;}
if(par1Block==Block.blockSnow) {total=true;}
//if(par1Block.blockMaterial==PackMining.materialOreGem) {total=true;}
return total;
}

public boolean onBlockDestroyed(ItemStack is, World wrd, int par3, int x, int y, int z, EntityLivingBase el) {
if(!wrd.isRemote) {
if((double)Block.blocksList[par3].getBlockHardness(wrd, x, y, z)!=0.0D) {

for(int jx=-1;jx<2;++jx) {
for(int jy=-1;jy<2;++jy) {
for(int jz=-1;jz<2;++jz) {
wrd.destroyBlock(x+(jx), y+(jy), z+(jz), true);
is.damageItem(8, el);
}
}
}

}

return true;
}else{
return false;
}
}

@SideOnly(Side.CLIENT)
public boolean hasEffect(ItemStack is) {return true;}

@Override
public void registerIcons(IIconRegister ir) {
this.itemIIcon=ir.registerIcon("timaxa007:" + "tool/" + "shovelMagic");
}

}
