package mods.timaxa007.pack.furniture.common.blocks;

import java.util.List;

import mods.timaxa007.lib.Option;
import mods.timaxa007.pack.furniture.common.main.PackFurniture;
import mods.timaxa007.pack.furniture.common.tile.TEBookshelf;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;

public class ItemBlockBookshelf extends ItemBlock {

	public ItemBlockBookshelf(Block id) {
		super(id);
		setMaxDamage(0);
		setHasSubtypes(true);
	}

	public boolean onItemUse(ItemStack is, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		if (!player.canPlayerEdit(x, y, z, side, is)) {return false;}
		else {
			if (hitX==1.0F) {x++;}
			if (hitX==0.0F) {x--;}
			if (hitZ==1.0F) {z++;}
			if (hitZ==0.0F) {z--;}
			if (hitY==1.0F) {y++;}
			if (hitY==0.0F) {y--;}

			world.setBlock(x, y, z, PackFurniture.proxy.block_bookshelf, 0, 3);
			TileEntity te = world.getTileEntity(x, y, z);
			NBTTagCompound tag = is.getTagCompound();
			if (te != null && te instanceof TEBookshelf) {

				int l = MathHelper.floor_double((double)(player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
				((TEBookshelf)te).setRotation(l);
				//if (is.hasDisplayName()) ((TEBookshelf)te).setCustomName(is.getDisplayName());

				if (tag != null) {
					if (tag.hasKey("Type")) ((TEBookshelf)te).setType(tag.getInteger("Type"));
				}
			}
			return true;
		}
	}

	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
		NBTTagCompound tag = is.getTagCompound();
		if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
			if (tag != null) {
				if (tag.hasKey("Type")) list.add("Type: "+tag.getInteger("Type") + ".");
			}
		} else {
			list.add(Option.prshift);
		}
	}

}
