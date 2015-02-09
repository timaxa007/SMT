package mods.timaxa007.tms.util;

public class ItemTool extends ModifiedItem {
	//--------------------------------------------------------------------------------------------------------------
	public ItemTool(String tag) {
		super(tag);
		setMaxStackSize(1);
		setMaxDamage(1024);
		setNoRepair();
	}
	//--------------------------------------------------------------------------------------------------------------
}
