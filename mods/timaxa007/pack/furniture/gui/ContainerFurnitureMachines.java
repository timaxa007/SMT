package mods.timaxa007.pack.furniture.gui;

import mods.timaxa007.pack.furniture.te.TEFurnitureMachines;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;

public class ContainerFurnitureMachines extends Container{

private TEFurnitureMachines te;

public ContainerFurnitureMachines(EntityPlayer player, TEFurnitureMachines te2) {
te=te2;
int i;
int j;


for(i=0;i<3;++i) {
for(j=0;j<9;++j) {
this.addSlotToContainer(new Slot(player.inventory, j+i*9+9, 8+j*18, 84+i*18));
}
}

for(i=0;i<9;++i) {
this.addSlotToContainer(new Slot(player.inventory, i, 8+i*18, 142));
}
}

@Override
public boolean canInteractWith(EntityPlayer player) {
return true;
}

}
