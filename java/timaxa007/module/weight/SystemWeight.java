package timaxa007.module.weight;

import timaxa007.module.weight.api.IWeight;
import timaxa007.module.weight.api.IWeightBlock;
import timaxa007.module.weight.api.IWeightItem;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;

public class SystemWeight {
	//--------------------------------------------------------
	public static float sendInventory(EntityPlayer player) {
		float weighting = 0.0F;

		for (ItemStack slot : player.inventory.mainInventory)
			weighting += checkWeighting(slot);

		for (ItemStack slot : player.inventory.armorInventory)
			weighting += (checkWeighting(slot) / 2.0F);

		/*if (player.getCurrentEquippedItem() != null)
			weighting += checkWeighting(player.getCurrentEquippedItem());*/

		return weighting;
	}
	//--------------------------------------------------------
	public static float checkWeighting(ItemStack slot) {
		float weighting = 0.0F;
		if (slot != null) {
			Item item = slot.getItem();
			Block block = Block.getBlockFromItem(item);

			if (block instanceof IWeightBlock && block != Blocks.air /*&& ((IWeightBlock)item).getWeight(block) != 0.0F*/) {
				weighting += ((IWeightBlock)block).getWeight(block) * slot.stackSize;
			} else if (block instanceof IWeight && block != Blocks.air) {
				weighting += ((IWeight)block).getWeight(slot);
			} else if (WeightVanilaBlocks.getVanilaBlock(block, slot.getItemDamage()) != 0.0F) {
				weighting += WeightVanilaBlocks.getVanilaBlock(block, slot.getItemDamage()) * slot.stackSize;
			} else if (item instanceof IWeightItem /*&& ((IWeightItem)item).getWeight(item) != 0.0F*/) {
				weighting += ((IWeightItem)item).getWeight(item) * slot.stackSize;
			} else if (item instanceof IWeight) {
				weighting += ((IWeight)item).getWeight(slot);
			} else if (WeightVanilaItems.getVanilaItem(item, slot.getItemDamage()) != 0.0F) {
				weighting += WeightVanilaItems.getVanilaItem(item, slot.getItemDamage()) * slot.stackSize;
			}

		}
		return weighting;
	}
	//--------------------------------------------------------
	public static void sumMoving(EntityPlayer player) {
		if (player != null && player.worldObj != null && !player.capabilities.isCreativeMode && PlayerWeight.get(player) != null) {

			float weight = SystemWeight.sendInventory(player);
			float weight_max = PlayerWeight.get(player).getWeightMax();
			float factor = ((weight_max - weight) / weight_max);
			double moving = ((weight >= 0.0F && weight <= weight_max) ? (double)factor : 0.0D);

			/*if (FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER) {
				System.out.println(player.getDisplayName() + ":  moving -- " + moving);
				System.out.println("weight -- " + weight + ", weight_max -- " + weight_max);
			}*/

			/** Из-за медленного падения при пустом инвентаре наносить больше урона от падения,<br>
			 * чем при быстром падении при полу-пустом или полном инвентаре.<br>
			 * Возможная причина из-за долгого парения в воздухе насчитываеться больше для коэфецента дамага от падения.<br>
			 * Это должно хоть как-то исправить.**/
			player.fallDistance += (1.0F - (float)(moving > 0.0D ? (moving * moving) : 0.0D));

			if (player.isAirBorne && moving < 1.0D) {

				if (player.motionY <= 0.0D) {
					player.motionY *= (2.0D - moving);
				} else {
					player.motionY *= (moving > 0.0D ? (moving / moving) : 0.0D);
				}

				if (moving <= 0.0D && player.motionY > 0.0D)
					player.motionY -= player.motionY;

			} else {

				if (player.motionY >= 0.0D)
					player.motionY *= 1.1D;
				else
					player.motionY *= 0.95D;

				if (player.onGround)
					moving *= 1.25D;

				player.motionX *= moving;
				player.motionZ *= moving;

			}

		}
	}
	//--------------------------------------------------------
}
