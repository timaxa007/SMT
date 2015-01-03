package mods.timaxa007.pack.furniture.block;

import java.util.List;

import mods.timaxa007.lib.Option;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import org.lwjgl.input.Keyboard;

public class ItemBlockCnstorBlock extends ItemBlock {

	public ItemBlockCnstorBlock(Block id) {
		super(id);
		setMaxDamage(0);
		setHasSubtypes(true);
	}
/*
	public boolean onItemUse(ItemStack is, EntityPlayer player, World world, int x, int y, int z, int meta, float hitX, float hitY, float hitZ) {
		if (!player.canPlayerEdit(x, y, z, meta, is)) {return false;}
		else {
			if (hitX == 1.0F) {x++;}
			if (hitX == 0.0F) {x--;}
			if (hitZ == 1.0F) {z++;}
			if (hitZ == 0.0F) {z--;}
			if (hitY == 1.0F) {y++;}
			if (hitY == 0.0F) {y--;}

			world.setBlock(x, y, z, PackFurniture.proxy.blockCnstorBlock, 0, 3);
			TileEntity te = world.getTileEntity(x, y, z);
			NBTTagCompound tag = is.getTagCompound();
			if (te != null && te instanceof TileEntityCnstorBlock) {

				if (tag != null) {
					if (tag.hasKey("Type")) {
						((TileEntityCnstorBlock)te).setType(tag.getInteger("Type"));
					} else {
						((TileEntityCnstorBlock)te).setType(0);
					}
					if (tag.hasKey("Color")) {
						((TileEntityCnstorBlock)te).setColor(tag.getInteger("Color"));
					} else {
						((TileEntityCnstorBlock)te).setColor(0);
					}

				} else {
					((TileEntityCnstorBlock)te).setType(0);
					((TileEntityCnstorBlock)te).setColor(0);
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
				if (tag.hasKey("Style")) {list.add("Style: " + tag.getString("Style") + ".");}
				if (tag.hasKey("Color")) {list.add("Color: " + tag.getInteger("Color") + ".");}
			}
		} else {
			list.add(Option.prshift);
		}
	}

}
