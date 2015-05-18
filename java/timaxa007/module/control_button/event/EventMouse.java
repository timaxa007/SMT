package timaxa007.module.control_button.event;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

import org.lwjgl.input.Mouse;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

/**Only Mouse. And we need him to take this action buttons of the game settings.**/
@Deprecated
public class EventMouse {
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onLeftClick(MouseEvent m) {
		if (m.button == 0) {
			//if (NodeSMT.show_system_info_testing) System.out.println("onLeftClick");
			//NodeSMT.network.sendToServer(new MessageMouseKey(1, m.buttonstate));
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onRightClick(MouseEvent m) {
		if (m.button == 1) {
			//if (NodeSMT.show_system_info_testing) System.out.println("onRightClick");
			//NodeSMT.network.sendToServer(new MessageMouseKey(2, m.buttonstate));
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent(priority = EventPriority.LOW)
	public void onLeftClickTick(LivingUpdateEvent p) {
		if (Mouse.isButtonDown(0) && 
				(!(Minecraft.getMinecraft().currentScreen instanceof GuiScreen)) && 
				p.entityLiving instanceof EntityPlayer) {
			//if (NodeSMT.show_system_info_testing) System.out.println("onLeftClickTick");
			//NodeSMT.network.sendToServer(new MessageMouseKey(3, true));
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent(priority = EventPriority.LOW)
	public void onRightClickTick(LivingUpdateEvent p) {
		if (Mouse.isButtonDown(1) && 
				(!(Minecraft.getMinecraft().currentScreen instanceof GuiScreen)) && 
				p.entityLiving instanceof EntityPlayer) {
			//if (NodeSMT.show_system_info_testing) System.out.println("onRightClick");
			//NodeSMT.network.sendToServer(new MessageMouseKey(4, true));
		}
	}
	//--------------------------------------------------------------------------------------------------------------
}
