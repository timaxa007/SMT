package smt.pack.common.registry;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;

public class Knowledge {
	
	public ItemStack icon;
	public int
	x,
	y;
	public boolean
	enabled,
	visible,
	hover;
	List<String> displayString = new ArrayList<String>();

	public Knowledge(ItemStack icon, int x, int y, String displayString) {
		this.icon = icon;
		this.x = x;
		this.y = y;
		this.enabled = true;
		this.visible = true;
		this.displayString.add(displayString);
	}

	public List<String> getDisplayString() {
		return displayString;
	}

	public int getHoverState(boolean state) {
		byte b0 = 0;
		if (!enabled) b0 = 2;
		else if (state) b0 = 1;
		return b0;
	}

	public boolean mousePressed(int x, int y, int mouseX, int mouseY) {
		return enabled && visible && mouseX >= x && mouseY >= y && mouseX < x + 20 && mouseY < y + 20;
	}

	public void action() {

	}

}
