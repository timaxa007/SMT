package smt.pack.common.api;

import java.util.HashMap;
import net.minecraft.item.ItemStack;

public interface IRegisterItem {

	public String getRegisterName();
	public void getRegisterItem(HashMap<String, ItemStack> map);

}
