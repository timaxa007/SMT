package timaxa007.pack.techno.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import timaxa007.module.control_button.api.IUpdateClient;
import timaxa007.pack.techno.PackTechno;
import timaxa007.tms.object.ModifiedItem;

public class ElectricDetector extends ModifiedItem implements IUpdateClient {

	public ElectricDetector(String tag) {
		super(tag);
		setCreativeTab(PackTechno.tab_techno);
		setMaxDamage(1000);
		setMaxStackSize(1);
		setNoRepair();
	}

	@Override
	public void updateClient(ItemStack is, World world, EntityPlayer player) {
		//System.out.println(is);
	}

}
