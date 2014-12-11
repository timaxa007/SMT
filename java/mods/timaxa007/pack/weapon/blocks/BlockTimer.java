package mods.timaxa007.pack.weapon.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockTimer extends Block {

@SideOnly(Side.CLIENT) private IIcon[] icon_array;

public BlockTimer() {
super(Material.wood);
setCreativeTab(CreativeTabs.tabBlock);
setBlockTextureName("timer_tick");
}

public void updateTick(World world, int x, int y, int z, Random random) {
System.out.println("111");
if (world.provider.getWorldTime() % (20 * 1) == 0) {
System.out.println("2222");
if (world.getBlockMetadata(x, y, z) >= 0 && world.getBlockMetadata(x, y, z) < 16) {
world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z) + 1, 3);
System.out.println("tttt");
}
}
}
/*
@SideOnly(Side.CLIENT)
public void randomDisplayTick(World world, int x, int y, int z, Random random) {
if (world.getWorldTime() % (20 * 1) == 0) {
if (world.getBlockMetadata(x, y, z) >= 0 && world.getBlockMetadata(x, y, z) < 16) {
world.setBlock(x, y, z, this, world.getBlockMetadata(x, y, z) + 1, 3);
}
}
}
*/
@SideOnly(Side.CLIENT)
public IIcon getIcon(int side, int meta) {
return icon_array[meta];
}

@SideOnly(Side.CLIENT)
public void registerBlockIcons(IIconRegister ir) {
icon_array = new IIcon[16];
for (int i = 0; i < 16; ++i) {
icon_array[i] = ir.registerIcon("timaxa007:" + "btick/tick_" + i);
}
}

}
