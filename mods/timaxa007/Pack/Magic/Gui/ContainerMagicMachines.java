package mods.timaxa007.Pack.Magic.Gui;

import mods.timaxa007.Pack.Magic.TE.TEMagicMachines;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;

public class ContainerMagicMachines extends Container{

private TEMagicMachines te;

public ContainerMagicMachines(EntityPlayer player, TEMagicMachines te2) {
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
