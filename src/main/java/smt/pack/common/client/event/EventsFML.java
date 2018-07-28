package smt.pack.common.client.event;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.ReflectionHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraftforge.client.event.GuiScreenEvent.DrawScreenEvent;
import smt.pack.EntityLook;
import smt.pack.common.SMTCommon;
import smt.pack.common.client.RegKey;
import smt.pack.common.network.MessageUpPickup;

public class EventsFML {

	static Minecraft mc = Minecraft.getMinecraft();

	@SubscribeEvent
	public void onRender(TickEvent.RenderTickEvent event) {
		smt.pack.common.animation.AnimationManager.parTick = event.renderTickTime;
		//System.out.println(event.phase);
	}

	//@SubscribeEvent
	public void onKeyInputEvent(TickEvent.PlayerTickEvent event) {
		switch (event.phase) {
		case START:
			MovingObjectPosition mop = EntityLook.getMouseOver(mc.thePlayer, 1F, 5D, true);
			if (mop == null) return;
			if (mop.typeOfHit != MovingObjectPosition.MovingObjectType.ENTITY) return;
			if (RegKey.use.isPressed()) {
				MessageUpPickup message = new MessageUpPickup();
				message.id = mop.entityHit.getEntityId();
				SMTCommon.network.sendToServer(message);
			}
			break;
		default:break;
		}
	}

	//@SubscribeEvent
	public void onKeyInputEvent(InputEvent.KeyInputEvent event) {
		//System.out.println(Keyboard.getEventCharacter() + "\t" + Keyboard.getEventKey() + "\t" + Keyboard.getEventKeyState());
		if (RegKey.use.isPressed()) {
			MovingObjectPosition mop = EntityLook.getMouseOver(mc.thePlayer, 1F, 5D, true);
			if (mop == null) return;
			if (mop.typeOfHit != MovingObjectPosition.MovingObjectType.ENTITY) return;
			MessageUpPickup message = new MessageUpPickup();
			message.id = mop.entityHit.getEntityId();
			SMTCommon.network.sendToServer(message);
		}
	}
	/*
	@SubscribeEvent
	public void onKeyInputEvent2(InputEvent.KeyInputEvent event) {
		if (Keyboard.isKeyDown(Keyboard.KEY_J)) {

		}
	}
	 */
	@SubscribeEvent
	public void comboItem(DrawScreenEvent.Post event) {
		//Container container = mc.thePlayer.openContainer;
		if (event.gui != null && event.gui instanceof GuiContainer) {
			GuiContainer gui = (GuiContainer)event.gui;
			ItemStack mouse = mc.thePlayer.inventory.getItemStack();
			Slot slot = getSlotAtPosition(gui, event.mouseX, event.mouseY);
			if (mouse != null && mouse.getItem() == Items.stick && slot != null) {

			}
		}
	}

	private static Slot getSlotAtPosition(GuiContainer gui, int mouseX, int mouseY) {
		try {
			Method m = ReflectionHelper.findMethod(GuiContainer.class, gui, new String[] {"getSlotAtPosition", "func_146975_c", "c"}, int.class, int.class);
			return (Slot)m.invoke(gui, mouseX, mouseY);
		}
		catch (IllegalAccessException e) {e.printStackTrace();}
		catch (IllegalArgumentException e) {e.printStackTrace();}
		catch (InvocationTargetException e) {e.printStackTrace();}
		/*
		for (int k = 0; k < gui.inventorySlots.inventorySlots.size(); ++k) {
			Slot slot = (Slot)gui.inventorySlots.inventorySlots.get(k);

			if (isMouseOverSlot(gui, slot, mouseX, mouseY)) {
				return slot;
			}
		}
		 */
		return null;
	}

	private static boolean isMouseOverSlot(GuiContainer gui, Slot slot, int mouseX, int mouseY) {
		return func_146978_c(gui, slot.xDisplayPosition, slot.yDisplayPosition, 16, 16, mouseX, mouseY);
	}

	protected static boolean func_146978_c(GuiContainer gui, int xPos, int yPos, int xSize, int ySize, int mouseX, int mouseY) {
		int guiLeft = ReflectionHelper.getPrivateValue(GuiContainer.class, gui, "field_147003_i", "guiLeft", "i");
		int guiTop = ReflectionHelper.getPrivateValue(GuiContainer.class, gui, "field_147009_r", "guiTop", "r");
		mouseX -= guiLeft;
		mouseY -= guiTop;
		return mouseX >= xPos - 1 && mouseX < xPos + xSize + 1 && mouseY >= yPos - 1 && mouseY < yPos + ySize + 1;
	}

}
