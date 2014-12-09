package mods.timaxa007.Pack.Weapon;

import mods.timaxa007.Pack.Weapon.Items.ItemWeapons;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

import org.lwjgl.input.Mouse;

public class EventPackWeapon {

@ForgeSubscribe
public void onFire(LivingUpdateEvent p) {
if (Mouse.isButtonDown(0)) {
ItemStack actHBI = p.entityLiving.getCurrentItemOrArmor(0);
if (actHBI != null && actHBI.getItem() instanceof ItemWeapons) {
//System.out.println("onFire");
}
}
}

@ForgeSubscribe
public void onScope(LivingUpdateEvent p) {
if (Mouse.isButtonDown(1)) {
ItemStack actHBI = p.entityLiving.getCurrentItemOrArmor(0);
if (actHBI != null && actHBI.getItem() instanceof ItemWeapons) {
//System.out.println("onScope");
}
}
}

}
