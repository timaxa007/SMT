package timaxa007.module.dfb.event;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.WorldEvent;

import org.lwjgl.input.Keyboard;

import timaxa007.module.dfb.DurabilityBlock;
import timaxa007.module.dfb.DurabilityBlockHelper;
import timaxa007.module.dfb.DurabilityBlockHelper.DurabilityForBlock;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EventDurabilityBlock {

	@SubscribeEvent
	public void checkDurability(WorldEvent.Load e) {
		DurabilityBlock.check(e.world);
		DurabilityBlock.get(e.world).setWorld(e.world);
	}

	@SubscribeEvent
	public void breakDurability(BlockEvent.BreakEvent e) {
		ArrayList<DurabilityForBlock> list = DurabilityBlockHelper.getList();
		if (list != null && list.size() > 0)
			for (int i = 0; i < list.size(); ++i) {
				DurabilityForBlock dfb = list.get(i);
				if (e.block == dfb.getBlock()) {
					if (DurabilityBlock.get(e.world) != null) DurabilityBlock.get(e.world).removeDurabilityBlock(e.x, e.y, e.z);
				}
			}
	}

	@SubscribeEvent
	public void addDurability(BlockEvent.PlaceEvent e) {
		ArrayList<DurabilityForBlock> list = DurabilityBlockHelper.getList();
		if (list != null && list.size() > 0)
			for (int i = 0; i < list.size(); ++i) {
				DurabilityForBlock dfb = list.get(i);
				if (e.placedBlock == dfb.getBlock()) {
					if (DurabilityBlock.get(e.world) != null) DurabilityBlock.get(e.world).addDurabilityBlock(e.x, e.y, e.z, dfb.durability);
				}
			}
	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void tipTagReceivingNutriment(net.minecraftforge.event.entity.player.ItemTooltipEvent tip) {
		if (tip.itemStack != null && tip.entityPlayer.capabilities.isCreativeMode) {
			tip.toolTip.add(Item.itemRegistry.getNameForObject(tip.itemStack.getItem()));//Временно
		}
		ArrayList<DurabilityForBlock> list = DurabilityBlockHelper.getList();
		if (list != null && list.size() > 0)
			for (int i = 0; i < list.size(); ++i) {
				DurabilityForBlock dfb = list.get(i);
				if (tip.itemStack != null && tip.itemStack.getItem() == Item.getItemFromBlock(dfb.getBlock())) {
					if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
						tip.toolTip.add("Durability: " + dfb.durability + ".");
					} else tip.toolTip.add("Hold SHIFT.");
				}
			}
	}

	@SubscribeEvent
	public void onDurability(PlayerInteractEvent e) {
		if (e.action == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK) {
			DurabilityBlock ct = DurabilityBlock.get(e.world);
			if (ct != null) {
				if (e.entityPlayer instanceof EntityPlayerMP) {
					ItemStack current = e.entityPlayer.getCurrentEquippedItem();
					Block block = e.world.getBlock(e.x, e.y, e.z);
					ArrayList<DurabilityForBlock> list = DurabilityBlockHelper.getList();
					if (list != null && list.size() > 0)
						for (int i = 0; i < list.size(); ++i) {
							DurabilityForBlock dfb = list.get(i);
							if (block == dfb.getBlock()) {
								if (ct.isDurabilityBlock(e.x, e.y, e.z)) {
									if (ct.getDurabilityBlock(e.x, e.y, e.z).durability > 0 )
										ct.use(e.x, e.y, e.z);
									else {
										//--------------------------------------
										EntityItem ei1 = new EntityItem(e.world, 
												(double)e.x + 0.5D, 
												(double)e.y + 0.5D, 
												(double)e.z + 0.5D, 
												new ItemStack(block));
										e.world.spawnEntityInWorld(ei1);
										//--------------------------------------
										e.world.setBlockToAir(e.x, e.y, e.z);
										ct.removeDurabilityBlock(e.x, e.y, e.z);
									}
								}
								else ct.addDurabilityBlock(e.x, e.y, e.z, dfb.durability - 1);
								ct.get(e.world).markDirty();
							}
						}
				}
			}
		}
	}

}
