package mods.timaxa007.Pack.Weapon.GUI;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;

public class GuiModifyWeapons extends GuiContainer {

public GuiModifyWeapons(EntityPlayer player) {
super(new ContainerModifyWeapons(player));
}

@Override
protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {

}

}
