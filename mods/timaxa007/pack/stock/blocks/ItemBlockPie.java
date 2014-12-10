package mods.timaxa007.pack.stock.blocks;

import java.util.List;

import mods.timaxa007.lib.Option;
import mods.timaxa007.pack.stock.PackStock;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemMultiTexture;
import net.minecraft.item.ItemStack;

import org.lwjgl.input.Keyboard;

public class ItemBlockPie extends ItemMultiTexture {

public ItemBlockPie(Block id) {
super(id, PackStock.proxy.block_cakes, BlockPies.typePies);
}

public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)||Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
list.add("Material: none.");
list.add("Type: none.");
}else{
list.add(Option.prshift);
}
}

}
