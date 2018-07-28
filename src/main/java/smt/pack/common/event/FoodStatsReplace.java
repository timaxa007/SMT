package smt.pack.common.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.FoodStats;

public class FoodStatsReplace extends FoodStats {

	@Override
	public void addStats(int foodLevel, float foodSaturationLevel) {
		System.out.println(foodLevel + "   " + foodSaturationLevel);
	}

	@Override
	public boolean needFood() {
		return true;
	}

	@Override
	public void onUpdate(EntityPlayer player) {
		System.out.println(" onUpdate  ");
	}

}
