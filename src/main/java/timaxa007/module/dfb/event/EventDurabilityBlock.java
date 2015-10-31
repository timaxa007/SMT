package timaxa007.module.dfb.event;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.WorldEvent;
import timaxa007.module.dfb.DurabilityBlock;
import timaxa007.module.dfb.DurabilityBlockHelper;
import timaxa007.module.dfb.DurabilityBlockHelper.DurabilityForBlock;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

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
				if (dfb.getBlock() != null && e.block == dfb.getBlock()) {
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
				if (dfb.getBlock() != null && e.placedBlock == dfb.getBlock()) {
					if (DurabilityBlock.get(e.world) != null) DurabilityBlock.get(e.world).addDurabilityBlock(e.x, e.y, e.z, dfb.durability);
				}
			}
	}

	@SubscribeEvent
	public void onDurability(PlayerInteractEvent e) {
		if (e.action == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK) {
			DurabilityBlock db = DurabilityBlock.get(e.world);
			if (db != null) {
				if (e.entityPlayer instanceof EntityPlayerMP) {
					ItemStack current = e.entityPlayer.getCurrentEquippedItem();
					Block block = e.world.getBlock(e.x, e.y, e.z);
					ArrayList<DurabilityForBlock> list = DurabilityBlockHelper.getList();
					if (list != null && list.size() > 0)
						for (int i = 0; i < list.size(); ++i) {
							DurabilityForBlock dfb = list.get(i);
							if (dfb.getBlock() != null && block == dfb.getBlock()) {
								if (db.isDurabilityBlock(e.x, e.y, e.z)) {
									if (db.getDurabilityBlock(e.x, e.y, e.z).durability > 0 )
										db.use(e.x, e.y, e.z);
									else {
										db.removeDurabilityBlock(e.x, e.y, e.z);
										e.world.func_147480_a(e.x, e.y, e.z, true);
									}
								}
								else db.addDurabilityBlock(e.x, e.y, e.z, dfb.durability - 1);
								db.get(e.world).markDirty();
							}
						}
				}
			}
		}
	}

}
