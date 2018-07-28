package smt.pack.technology.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants.NBT;
import smt.pack.technology.tile.TileEntityElectricMachine;
import smt.pack.technology.tile.machine.ElectricAccumulator;
import smt.pack.technology.world.SourceEnergy;
import smt.pack.technology.world.WorldWireEnergy;

public class ItemWire extends Item {

	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		WorldWireEnergy net = WorldWireEnergy.get(world);

			//if (!net.is(x, y, z)) {
			NBTTagCompound nbt = itemStack.getTagCompound();
			if (nbt == null) {
				nbt = new NBTTagCompound();
				itemStack.setTagCompound(nbt);
			}
			if (nbt.hasKey("dot", NBT.TAG_INT_ARRAY)) {
				int[] dot = nbt.getIntArray("dot");
				if (dot[0] != x || dot[1] != y || dot[2] != z) {
					//if (EntityLook.block(world, Vec3.createVectorHelper(dot[0], dot[1], dot[2]), Vec3.createVectorHelper(x, y, z), false) == null) {
					net.add(dot[0], dot[1], dot[2], x, y, z);
					
					TileEntity t1 = world.getTileEntity(dot[0], dot[1], dot[2]);
					TileEntity t2 = world.getTileEntity(x, y, z);
					if (t1 instanceof TileEntityElectricMachine && t2 instanceof TileEntityElectricMachine) {
						TileEntityElectricMachine te1 = (TileEntityElectricMachine)t1;
						TileEntityElectricMachine te2 = (TileEntityElectricMachine)t2;
						if (te1.getElectricMachine() != null && te1.getElectricMachine() != null) {
							if (te1.getElectricMachine().getClass() == ElectricAccumulator.class) {
								te2.setSourceEnergy(new SourceEnergy(x, y, z));
							} else {
								te1.setSourceEnergy(new SourceEnergy(dot[0], dot[1], dot[2]));
							}
						}
					}
					
					//}
				}
				nbt.removeTag("dot");
			} else nbt.setIntArray("dot", new int[]{x, y, z});
		//}
		return true;
	}

}
