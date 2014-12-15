package mods.timaxa007.pack.magic.blocks;

import java.util.List;

import mods.timaxa007.pack.magic.PackMagic;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSlims extends BlockContainer {
@SideOnly(Side.CLIENT)
private IIcon[] iconArray;

public BlockSlims() {
super(Material.wood);
setCreativeTab(PackMagic.proxy.tab_magic);
setBlockTextureName("planks_oak");
setBlockName("magic.slims");
}
/*
@SideOnly(Side.CLIENT)
public IIcon getIcon(int par1, int par2) {return iconArray[par2 % iconArray.length];}
*/
@Override
public TileEntity createNewTileEntity(World world, int meta) {return new TESlims();}

@SideOnly(Side.CLIENT)
public void getSubBlocks(Item id, CreativeTabs table, List list) {
for(byte j=0;j<16;++j) {list.add(new ItemStack(id, 1, j));}
}
/*
@SideOnly(Side.CLIENT)
public void registerBlockIcons(IIconRegister ir) {
iconArray=new IIcon[16];
for(byte i=0;i<iconArray.length;++i) {
iconArray[i]=ir.registerIcon("timaxa007:"+"blockSlims/"+"blockSlims"+GetColors.getNameColors[i]);
}
}
*/
}
