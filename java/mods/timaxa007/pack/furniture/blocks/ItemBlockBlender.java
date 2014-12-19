package mods.timaxa007.pack.furniture.blocks;

import java.util.List;

import mods.timaxa007.lib.Option;
import mods.timaxa007.pack.furniture.PackFurniture;
import mods.timaxa007.pack.furniture.tile.TEBlender;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;

public class ItemBlockBlender extends ItemBlock {

	public ItemBlockBlender(Block id) {
		super(id);
		setMaxDamage(0);
		setHasSubtypes(true);
	}

	public boolean onItemUse(ItemStack is, EntityPlayer player, World world, int x, int y, int z, int meta, float hitX, float hitY, float hitZ) {
		if (!player.canPlayerEdit(x, y, z, meta, is)) {return false;}
		else {
			if (hitX==1.0F) {x++;}
			if (hitX==0.0F) {x--;}
			if (hitZ==1.0F) {z++;}
			if (hitZ==0.0F) {z--;}
			if (hitY==1.0F) {y++;}
			if (hitY==0.0F) {y--;}

			world.setBlock(x, y, z, PackFurniture.proxy.block_blender, 0, 3);
			TileEntity te=world.getTileEntity(x, y, z);
			NBTTagCompound tag = is.getTagCompound();
			if (te != null && te instanceof TEBlender) {

				int l=MathHelper.floor_double((double)(player.rotationYaw*4.0F/360.0F) + 0.5D)&3;
				((TEBlender)te).setRotation(l);

				if (tag != null) {
					if (tag.hasKey("Type")) ((TEBlender)te).setType(tag.getInteger("Type"));
					if (tag.hasKey("TypeCap")) ((TEBlender)te).setTypeCap(tag.getInteger("TypeCap"));
					if (tag.hasKey("TypeHandler")) ((TEBlender)te).setTypeHandler(tag.getInteger("TypeHandler"));
					if (tag.hasKey("TypeBox")) ((TEBlender)te).setTypeBox(tag.getInteger("TypeBox"));
					if (tag.hasKey("TypeGlass")) ((TEBlender)te).setTypeGlass(tag.getInteger("TypeGlass"));
					if (tag.hasKey("TypeSize")) ((TEBlender)te).setTypeSize(tag.getInteger("TypeSize"));
					if (tag.hasKey("Size")) ((TEBlender)te).setSize(tag.getInteger("Size"));
				}
			}
			return true;
		}
	}

	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
		NBTTagCompound tag = is.getTagCompound();
		if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
			if (tag != null) {
				if (tag.hasKey("Type")) list.add("Type: " + tag.getInteger("Type") + ".");
				if (tag.hasKey("TypeCap")) list.add("Type Cap: " + tag.getInteger("TypeCap") + ".");
				if (tag.hasKey("TypeHandler")) list.add("Type Handler: " + tag.getInteger("TypeHandler") + ".");
				if (tag.hasKey("TypeBox")) list.add("Type Box: " + tag.getInteger("TypeBox") + ".");
				if (tag.hasKey("TypeGlass")) list.add("Type Glass: " + tag.getInteger("TypeGlass") + ".");
				if (tag.hasKey("TypeSize")) list.add("Type Size: " + tag.getInteger("TypeSize") + ".");
				if (tag.hasKey("Size")) list.add("Size: " + tag.getInteger("Size") + ".");
			}
		} else {
			list.add(Option.prshift);
		}
	}

}
