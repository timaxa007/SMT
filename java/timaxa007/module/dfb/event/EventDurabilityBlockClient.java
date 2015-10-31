package timaxa007.module.dfb.event;

import java.util.ArrayList;

import net.minecraft.item.Item;

import org.lwjgl.input.Keyboard;

import timaxa007.module.dfb.DurabilityBlockHelper;
import timaxa007.module.dfb.DurabilityBlockHelper.DurabilityForBlock;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventDurabilityBlockClient {

	@SubscribeEvent
	public void tipTagReceivingNutriment(net.minecraftforge.event.entity.player.ItemTooltipEvent tip) {
		if (tip.itemStack != null && tip.entityPlayer.capabilities.isCreativeMode) {
			tip.toolTip.add(Item.itemRegistry.getNameForObject(tip.itemStack.getItem()));//Временно
		}
		ArrayList<DurabilityForBlock> list = DurabilityBlockHelper.getList();
		if (list != null && list.size() > 0)
			for (int i = 0; i < list.size(); ++i) {
				DurabilityForBlock dfb = list.get(i);
				if (tip.itemStack != null && dfb.getBlock() != null && tip.itemStack.getItem() == Item.getItemFromBlock(dfb.getBlock())) {
					if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
						tip.toolTip.add("Durability: " + dfb.durability + ".");
					} else tip.toolTip.add("Hold SHIFT.");
				}
			}
	}

}
