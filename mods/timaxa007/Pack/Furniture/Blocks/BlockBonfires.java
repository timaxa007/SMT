package mods.timaxa007.Pack.Furniture.Blocks;

import mods.timaxa007.Pack.Furniture.PackFurniture;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockBonfires extends Block {

public BlockBonfires(int id) {
super(id, Material.wood);
setCreativeTab(PackFurniture.proxy.tabFurniturePack);
setHardness(0.5F);
setResistance(2.5F);
setLightOpacity(0);
setStepSound(soundWoodFootstep);
setTextureName("timaxa007:block_bonfires");
setUnlocalizedName("block_bonfires");
}

public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float hitX, float hitY, float hitZ) {
ItemStack current = player.getCurrentEquippedItem();
if (current != null) {
//--------------------------------
if ((current.getItem()==Item.flintAndSteel) && (world.getBlockId(x, y, z) == PackFurniture.proxy.block_bonfires.blockID)) {
world.setBlock(x, y, z, PackFurniture.proxy.block_bonfires_burning.blockID);
current.setItemDamage(current.getItemDamage()+1);
return true;
} else {
return false;
}
//--------------------------------
} else {
return false;
}
}

}
