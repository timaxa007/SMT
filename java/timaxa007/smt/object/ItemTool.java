package timaxa007.smt.object;

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
