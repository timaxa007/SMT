package mods.timaxa007.pack.stock.item;

import java.util.List;

import mods.timaxa007.pack.stock.PackStock;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMedicals extends Item {
	public static final String[] medicalNames = new String[] {
		"none", 

		"PillSpeed1", 
		"PillMoveSlow1", 
		"PillDigSpeed1", 
		"PillDigSlow1", 
		"PillStg1", 
		"PillHeal1", 
		"PillHarm1", 
		"PillJump1", 
		"PillConfusion1", 
		"PillRegen1", 
		"PillResis1", 
		"PillFireRes1", 
		"PillWater1", 
		"PillInvis1", 
		"PillBlindness1", 
		"PillNightVision1", 
		"PillHunger1", 
		"PillStd1", 
		"PillPoison1", 
		"PillWither1", 
		"Pill21_1", 
		"Pill22_1", 
		"Pill23_1", 
		"Pill24_1", 
		"Pill25_1", 
		"PillSatiety1", 
		"Pill27_1", 
		"Pill28_1", 
		"Pill29_1", 
		"Pill30_1", 

		"PillSpeed2", 
		"PillMoveSlow2", 
		"PillDigSpeed2", 
		"PillDigSlow2", 
		"PillStg2", 
		"PillHeal2", 
		"PillHarm2", 
		"PillJump2", 
		"PillConfusion2", 
		"PillRegen2", 
		"PillResis2", 
		"PillFireRes2", 
		"PillWater2", 
		"PillInvis2", 
		"PillBlindness2", 
		"PillNightVision2", 
		"PillHunger2", 
		"PillStd2", 
		"PillPoison2", 
		"PillWither2", 
		"Pill21_2", 
		"Pill22_2", 
		"Pill23_2", 
		"Pill24_2", 
		"Pill25_2", 
		"PillSatiety2", 
		"Pill27_2", 
		"Pill28_2", 
		"Pill29_2", 
		"Pill30_2", 

		"PillSpeed3", 
		"PillMoveSlow3", 
		"PillDigSpeed3", 
		"PillDigSlow3", 
		"PillStg3", 
		"PillHeal3", 
		"PillHarm3", 
		"PillJump3", 
		"PillConfusion3", 
		"PillRegen3", 
		"PillResis3", 
		"PillFireRes3", 
		"PillWater3", 
		"PillInvis3", 
		"PillBlindness3", 
		"PillNightVision3", 
		"PillHunger3", 
		"PillStd3", 
		"PillPoison3", 
		"PillWither3", 
		"Pill21_3", 
		"Pill22_3", 
		"Pill23_3", 
		"Pill24_3", 
		"Pill25_3", 
		"PillSatiety3", 
		"Pill27_3", 
		"Pill28_3", 
		"Pill29_3", 
		"Pill30_3", 

		"PillSpeed4", 
		"PillMoveSlow4", 
		"PillDigSpeed4", 
		"PillDigSlow4", 
		"PillStg4", 
		"PillHeal4", 
		"PillHarm4", 
		"PillJump4", 
		"PillConfusion4", 
		"PillRegen4", 
		"PillResis4", 
		"PillFireRes4", 
		"PillWater4", 
		"PillInvis4", 
		"PillBlindness4", 
		"PillNightVision4", 
		"PillHunger4", 
		"PillStd4", 
		"PillPoison4", 
		"PillWither4", 
		"Pill21_4", 
		"Pill22_4", 
		"Pill23_4", 
		"Pill24_4", 
		"Pill25_4", 
		"PillSatiety4", 
		"Pill27_4", 
		"Pill28_4", 
		"Pill29_4", 
		"Pill30_4", 

		"PillSpeed5", 
		"PillMoveSlow5", 
		"PillDigSpeed5", 
		"PillDigSlow5", 
		"PillStg5", 
		"PillHeal5", 
		"PillHarm5", 
		"PillJump5", 
		"PillConfusion5", 
		"PillRegen5", 
		"PillResis5", 
		"PillFireRes5", 
		"PillWater5", 
		"PillInvis5", 
		"PillBlindness5", 
		"PillNightVision5", 
		"PillHunger5", 
		"PillStd5", 
		"PillPoison5", 
		"PillWither5", 
		"Pill21_5", 
		"Pill22_5", 
		"Pill23_5", 
		"Pill24_5", 
		"Pill25_5", 
		"PillSatiety5", 
		"Pill27_5", 
		"Pill28_5", 
		"Pill29_5", 
		"Pill30_5", 

		"PillElite1", 
		"PillElite2", 
		"PillElite3", 
		"PillElite4", 
		"PillElite5", 
		"PillElite6", 
		"PillElite7", 
		"PillElite8", 
		"PillElite9", 
		"PillElite10", 

		"PillExtra1", 
		"PillExtra2", 
		"PillExtra3", 
		"PillExtra4", 
		"PillExtra5", 
		"PillExtra6", 
		"PillExtra7", 
		"PillExtra8", 
		"PillExtra9", 
		"PillExtra10", 

		"PillVIP1", 
		"PillVIP2", 
		"PillVIP3", 
		"PillVIP4", 
		"PillVIP5", 
		"PillVIP6", 
		"PillVIP7", 
		"PillVIP8", 
		"PillVIP9", 
		"PillVIP10", 

		"PillPremium1", 
		"PillPremium2", 
		"PillPremium3", 
		"PillPremium4", 
		"PillPremium5", 
		"PillPremium6", 
		"PillPremium7", 
		"PillPremium8", 
		"PillPremium9", 
		"PillPremium10"

	};
	@SideOnly(Side.CLIENT) private IIcon[] iconArray;

	public ItemMedicals() {
		super();
		setHasSubtypes(true);
		setMaxDamage(0);
		setCreativeTab(PackStock.tab_medical);
		setUnlocalizedName("medicals");
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int meta) {
		return iconArray[meta];
	}

	public String getUnlocalizedName(ItemStack is) {
		int i = MathHelper.clamp_int(is.getItemDamage(), 0, (medicalNames.length)-1);
		return super.getUnlocalizedName()+"."+medicalNames[i];
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item id, CreativeTabs table, List list) {
		for(int j = 0;j<medicalNames.length;++j) {list.add(new ItemStack(id, 1, j));}
	}


	public ItemStack onEaten(ItemStack is, World world, EntityPlayer player) {
		if (!player.capabilities.isCreativeMode) {--is.stackSize;}
		if (!world.isRemote) {

			if (is.getItemDamage() == 0) {
				player.curePotionEffects(is);
				player.clearActivePotions();
				player.removePotionEffect(Potion.moveSlowdown.id);
				player.removePotionEffect(Potion.digSlowdown.id);
				player.removePotionEffect(Potion.confusion.id);
				player.removePotionEffect(Potion.blindness.id);
				player.removePotionEffect(Potion.hunger.id);
				player.removePotionEffect(Potion.weakness.id);
				player.removePotionEffect(Potion.poison.id);
				player.removePotionEffect(Potion.wither.id);
				for(int i = 1;i>32;i++) {player.removePotionEffect(i);}
				//player.addExperience(1);
				//player.addExperienceLevel(1);
				//player.dropPlayerItem(new ItemStack(PackStock.itemMedicals, 1, 3));

			} else if (is.getItemDamage() == 1) {
				player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 20*5, 0));
			} else if (is.getItemDamage() == 2) {
				player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 20*5, 0));
			} else if (is.getItemDamage() == 3) {
				player.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 20*5, 0));
			} else if (is.getItemDamage() == 4) {
				player.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 20*5, 0));
			} else if (is.getItemDamage() == 5) {
				player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 20*5, 0));
			} else if (is.getItemDamage() == 6) {
				player.addPotionEffect(new PotionEffect(Potion.heal.id, 1, 0));
			} else if (is.getItemDamage() == 7) {
				player.addPotionEffect(new PotionEffect(Potion.harm.id, 1, 0));
			} else if (is.getItemDamage() == 8) {
				player.addPotionEffect(new PotionEffect(Potion.jump.id, 20*5, 0));
			} else if (is.getItemDamage() == 9) {
				player.addPotionEffect(new PotionEffect(Potion.confusion.id, 20*5, 0));
			} else if (is.getItemDamage() == 10) {
				player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 20*5, 0));
			} else if (is.getItemDamage() == 11) {
				player.addPotionEffect(new PotionEffect(Potion.resistance.id, 20*5, 0));
			} else if (is.getItemDamage() == 12) {
				player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 20*5, 0));
			} else if (is.getItemDamage() == 13) {
				player.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 20*5, 0));
			} else if (is.getItemDamage() == 14) {
				player.addPotionEffect(new PotionEffect(Potion.invisibility.id, 20*5, 0));
			} else if (is.getItemDamage() == 15) {
				player.addPotionEffect(new PotionEffect(Potion.blindness.id, 20*5, 0));
			} else if (is.getItemDamage() == 16) {
				player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 20*5, 0));
			} else if (is.getItemDamage() == 17) {
				player.addPotionEffect(new PotionEffect(Potion.hunger.id, 20*5, 0));
			} else if (is.getItemDamage() == 18) {
				player.addPotionEffect(new PotionEffect(Potion.weakness.id, 20*5, 0));
			} else if (is.getItemDamage() == 19) {
				player.addPotionEffect(new PotionEffect(Potion.poison.id, 20*5, 0));
			} else if (is.getItemDamage() == 20) {
				player.addPotionEffect(new PotionEffect(Potion.wither.id, 20*5, 0));
			} else if (is.getItemDamage() == 21) {
			} else if (is.getItemDamage() == 22) {
			} else if (is.getItemDamage() == 23) {
			} else if (is.getItemDamage() == 24) {
			} else if (is.getItemDamage() == 25) {
			} else if (is.getItemDamage() == 26) {
				player.getFoodStats().addStats(1, 1.0F);
			} else if (is.getItemDamage() == 27) {
			} else if (is.getItemDamage() == 28) {
			} else if (is.getItemDamage() == 29) {
			} else if (is.getItemDamage() == 30) {
			} else if (is.getItemDamage() == 31) {
				player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 20*15, 1));
			} else if (is.getItemDamage() == 32) {
				player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 20*15, 1));
			} else if (is.getItemDamage() == 33) {
				player.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 20*15, 1));
			} else if (is.getItemDamage() == 34) {
				player.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 20*15, 1));
			} else if (is.getItemDamage() == 35) {
				player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 20*15, 1));
			} else if (is.getItemDamage() == 36) {
				player.addPotionEffect(new PotionEffect(Potion.heal.id, 1, 1));
			} else if (is.getItemDamage() == 37) {
				player.addPotionEffect(new PotionEffect(Potion.harm.id, 1, 1));
			} else if (is.getItemDamage() == 38) {
				player.addPotionEffect(new PotionEffect(Potion.jump.id, 20*15, 1));
			} else if (is.getItemDamage() == 39) {
				player.addPotionEffect(new PotionEffect(Potion.confusion.id, 20*15, 1));
			} else if (is.getItemDamage() == 40) {
				player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 20*15, 1));
			} else if (is.getItemDamage() == 41) {
				player.addPotionEffect(new PotionEffect(Potion.resistance.id, 20*15, 1));
			} else if (is.getItemDamage() == 42) {
				player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 20*15, 1));
			} else if (is.getItemDamage() == 43) {
				player.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 20*15, 1));
			} else if (is.getItemDamage() == 44) {
				player.addPotionEffect(new PotionEffect(Potion.invisibility.id, 20*15, 1));
			} else if (is.getItemDamage() == 45) {
				player.addPotionEffect(new PotionEffect(Potion.blindness.id, 20*15, 1));
			} else if (is.getItemDamage() == 46) {
				player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 20*15, 1));
			} else if (is.getItemDamage() == 47) {
				player.addPotionEffect(new PotionEffect(Potion.hunger.id, 20*15, 1));
			} else if (is.getItemDamage() == 48) {
				player.addPotionEffect(new PotionEffect(Potion.weakness.id, 20*15, 1));
			} else if (is.getItemDamage() == 49) {
				player.addPotionEffect(new PotionEffect(Potion.poison.id, 20*15, 1));
			} else if (is.getItemDamage() == 50) {
				player.addPotionEffect(new PotionEffect(Potion.wither.id, 20*15, 1));
			} else if (is.getItemDamage() == 51) {
			} else if (is.getItemDamage() == 52) {
			} else if (is.getItemDamage() == 53) {
			} else if (is.getItemDamage() == 54) {
			} else if (is.getItemDamage() == 55) {
			} else if (is.getItemDamage() == 56) {
				player.getFoodStats().addStats(2, 2.0F);
			} else if (is.getItemDamage() == 57) {
			} else if (is.getItemDamage() == 58) {
			} else if (is.getItemDamage() == 59) {
			} else if (is.getItemDamage() == 60) {
			} else if (is.getItemDamage() == 61) {
				player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 20*30, 2));
			} else if (is.getItemDamage() == 62) {
				player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 20*30, 2));
			} else if (is.getItemDamage() == 63) {
				player.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 20*30, 2));
			} else if (is.getItemDamage() == 64) {
				player.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 20*30, 2));
			} else if (is.getItemDamage() == 65) {
				player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 20*30, 2));
			} else if (is.getItemDamage() == 66) {
				player.addPotionEffect(new PotionEffect(Potion.heal.id, 1, 2));
			} else if (is.getItemDamage() == 67) {
				player.addPotionEffect(new PotionEffect(Potion.harm.id, 1, 2));
			} else if (is.getItemDamage() == 68) {
				player.addPotionEffect(new PotionEffect(Potion.jump.id, 20*30, 2));
			} else if (is.getItemDamage() == 69) {
				player.addPotionEffect(new PotionEffect(Potion.confusion.id, 20*30, 2));
			} else if (is.getItemDamage() == 70) {
				player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 20*30, 2));
			} else if (is.getItemDamage() == 71) {
				player.addPotionEffect(new PotionEffect(Potion.resistance.id, 20*30, 2));
			} else if (is.getItemDamage() == 72) {
				player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 20*30, 2));
			} else if (is.getItemDamage() == 73) {
				player.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 20*30, 2));
			} else if (is.getItemDamage() == 74) {
				player.addPotionEffect(new PotionEffect(Potion.invisibility.id, 20*30, 2));
			} else if (is.getItemDamage() == 75) {
				player.addPotionEffect(new PotionEffect(Potion.blindness.id, 20*30, 2));
			} else if (is.getItemDamage() == 76) {
				player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 20*30, 2));
			} else if (is.getItemDamage() == 77) {
				player.addPotionEffect(new PotionEffect(Potion.hunger.id, 20*30, 2));
			} else if (is.getItemDamage() == 78) {
				player.addPotionEffect(new PotionEffect(Potion.weakness.id, 20*30, 2));
			} else if (is.getItemDamage() == 79) {
				player.addPotionEffect(new PotionEffect(Potion.poison.id, 20*30, 2));
			} else if (is.getItemDamage() == 80) {
				player.addPotionEffect(new PotionEffect(Potion.wither.id, 20*30, 2));
			} else if (is.getItemDamage() == 81) {
			} else if (is.getItemDamage() == 82) {
			} else if (is.getItemDamage() == 83) {
			} else if (is.getItemDamage() == 84) {
			} else if (is.getItemDamage() == 85) {
			} else if (is.getItemDamage() == 86) {
				player.getFoodStats().addStats(3, 3.0F);
			} else if (is.getItemDamage() == 87) {
			} else if (is.getItemDamage() == 88) {
			} else if (is.getItemDamage() == 89) {
			} else if (is.getItemDamage() == 90) {
			} else if (is.getItemDamage() == 91) {
				player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 20*10, 3));
			} else if (is.getItemDamage() == 92) {
				player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 20*10, 3));
			} else if (is.getItemDamage() == 93) {
				player.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 20*10, 3));
			} else if (is.getItemDamage() == 94) {
				player.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 20*10, 3));
			} else if (is.getItemDamage() == 95) {
				player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 20*10, 3));
			} else if (is.getItemDamage() == 96) {
				player.addPotionEffect(new PotionEffect(Potion.heal.id, 1, 3));
			} else if (is.getItemDamage() == 97) {
				player.addPotionEffect(new PotionEffect(Potion.harm.id, 1, 3));
			} else if (is.getItemDamage() == 98) {
				player.addPotionEffect(new PotionEffect(Potion.jump.id, 20*10, 3));
			} else if (is.getItemDamage() == 99) {
				player.addPotionEffect(new PotionEffect(Potion.confusion.id, 20*10, 3));
			} else if (is.getItemDamage() == 100) {
				player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 20*10, 3));
			} else if (is.getItemDamage() == 101) {
				player.addPotionEffect(new PotionEffect(Potion.resistance.id, 20*10, 3));
			} else if (is.getItemDamage() == 102) {
				player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 20*10, 3));
			} else if (is.getItemDamage() == 103) {
				player.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 20*10, 3));
			} else if (is.getItemDamage() == 104) {
				player.addPotionEffect(new PotionEffect(Potion.invisibility.id, 20*10, 3));
			} else if (is.getItemDamage() == 105) {
				player.addPotionEffect(new PotionEffect(Potion.blindness.id, 20*10, 3));
			} else if (is.getItemDamage() == 106) {
				player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 20*10, 3));
			} else if (is.getItemDamage() == 107) {
				player.addPotionEffect(new PotionEffect(Potion.hunger.id, 20*10, 3));
			} else if (is.getItemDamage() == 108) {
				player.addPotionEffect(new PotionEffect(Potion.weakness.id, 20*10, 3));
			} else if (is.getItemDamage() == 109) {
				player.addPotionEffect(new PotionEffect(Potion.poison.id, 20*10, 3));
			} else if (is.getItemDamage() == 110) {
				player.addPotionEffect(new PotionEffect(Potion.wither.id, 20*10, 3));
			} else if (is.getItemDamage() == 111) {
			} else if (is.getItemDamage() == 112) {
			} else if (is.getItemDamage() == 113) {
			} else if (is.getItemDamage() == 114) {
			} else if (is.getItemDamage() == 115) {
			} else if (is.getItemDamage() == 116) {
				player.getFoodStats().addStats(4, 4.0F);
			} else if (is.getItemDamage() == 117) {
			} else if (is.getItemDamage() == 118) {
			} else if (is.getItemDamage() == 119) {
			} else if (is.getItemDamage() == 120) {
			} else if (is.getItemDamage() == 121) {
				player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 20*7, 4));
			} else if (is.getItemDamage() == 122) {
				player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 20*7, 4));
			} else if (is.getItemDamage() == 123) {
				player.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 20*7, 4));
			} else if (is.getItemDamage() == 124) {
				player.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 20*7, 4));
			} else if (is.getItemDamage() == 125) {
				player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 20*7, 4));
			} else if (is.getItemDamage() == 126) {
				player.addPotionEffect(new PotionEffect(Potion.heal.id, 1, 4));
			} else if (is.getItemDamage() == 127) {
				player.addPotionEffect(new PotionEffect(Potion.harm.id, 1, 4));
			} else if (is.getItemDamage() == 128) {
				player.addPotionEffect(new PotionEffect(Potion.jump.id, 20*7, 4));
			} else if (is.getItemDamage() == 129) {
				player.addPotionEffect(new PotionEffect(Potion.confusion.id, 20*7, 4));
			} else if (is.getItemDamage() == 130) {
				player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 20*7, 4));
			} else if (is.getItemDamage() == 131) {
				player.addPotionEffect(new PotionEffect(Potion.resistance.id, 20*7, 4));
			} else if (is.getItemDamage() == 132) {
				player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 20*7, 4));
			} else if (is.getItemDamage() == 133) {
				player.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 20*7, 4));
			} else if (is.getItemDamage() == 134) {
				player.addPotionEffect(new PotionEffect(Potion.invisibility.id, 20*7, 4));
			} else if (is.getItemDamage() == 135) {
				player.addPotionEffect(new PotionEffect(Potion.blindness.id, 20*7, 4));
			} else if (is.getItemDamage() == 136) {
				player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 20*7, 4));
			} else if (is.getItemDamage() == 137) {
				player.addPotionEffect(new PotionEffect(Potion.hunger.id, 20*7, 4));
			} else if (is.getItemDamage() == 138) {
				player.addPotionEffect(new PotionEffect(Potion.weakness.id, 20*7, 4));
			} else if (is.getItemDamage() == 139) {
				player.addPotionEffect(new PotionEffect(Potion.poison.id, 20*7, 4));
			} else if (is.getItemDamage() == 140) {
				player.addPotionEffect(new PotionEffect(Potion.wither.id, 20*7, 4));
			} else if (is.getItemDamage() == 141) {
			} else if (is.getItemDamage() == 142) {
			} else if (is.getItemDamage() == 143) {
			} else if (is.getItemDamage() == 144) {
			} else if (is.getItemDamage() == 145) {
			} else if (is.getItemDamage() == 146) {
				player.getFoodStats().addStats(5, 5.0F);
			} else if (is.getItemDamage() == 147) {
			} else if (is.getItemDamage() == 148) {
			} else if (is.getItemDamage() == 149) {
			} else if (is.getItemDamage() == 150) {
			} else if (is.getItemDamage() == 151) {
				player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 20*30, 5));
				player.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 20*30, 1));
			} else if (is.getItemDamage() == 152) {
				player.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 20*30, 5));
				player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 20*30, 1));
			} else if (is.getItemDamage() == 153) {
				player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 20*30, 5));
				player.addPotionEffect(new PotionEffect(Potion.resistance.id, 20*30, 3));
			} else if (is.getItemDamage() == 154) {
				player.addPotionEffect(new PotionEffect(Potion.heal.id, 1, 1));
				player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 20*30, 5));
			} else if (is.getItemDamage() == 155) {
				player.addPotionEffect(new PotionEffect(Potion.resistance.id, 20*30, 5));
				player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 20*50, 3));
				player.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 20*50, 3));
			} else if (is.getItemDamage() == 156) {
				player.addPotionEffect(new PotionEffect(Potion.heal.id, 1, 1));
				player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 1, 1));
				player.getFoodStats().addStats(3, 1.0F);
			} else if (is.getItemDamage() == 157) {
				player.addPotionEffect(new PotionEffect(Potion.harm.id, 1, 1));
				player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 190, 1));
				player.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 170, 1));
				player.addPotionEffect(new PotionEffect(Potion.confusion.id, 260, 1));
				player.addPotionEffect(new PotionEffect(Potion.blindness.id, 20*12, 1));
				player.addPotionEffect(new PotionEffect(Potion.hunger.id, 20*10, 5));
				player.addPotionEffect(new PotionEffect(Potion.weakness.id, 180, 1));
				player.addPotionEffect(new PotionEffect(Potion.poison.id, 20*5, 1));
				player.addPotionEffect(new PotionEffect(Potion.wither.id, 20*5, 1));
			} else if (is.getItemDamage() == 158) {
				player.addPotionEffect(new PotionEffect(Potion.invisibility.id, 20*30, 5));
				player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 20*10, 3));
				player.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 20*10, 3));
			} else if (is.getItemDamage() == 159) {
				if (player.experienceLevel >= 1) {
					player.addExperienceLevel(-1);
					player.addPotionEffect(new PotionEffect(Potion.confusion.id, 160, 1));
					player.addPotionEffect(new PotionEffect(Potion.hunger.id, 20*12, 1));
					player.addPotionEffect(new PotionEffect(Potion.wither.id, 40, 1));
					player.dropPlayerItemWithRandomChoice(new ItemStack(PackStock.proxy.item.medicals, 1, 160), true);
				} else {
					player.dropPlayerItemWithRandomChoice(new ItemStack(PackStock.proxy.item.medicals, 1, 159), true);
				}
			} else if (is.getItemDamage() == 160) {
				player.addExperienceLevel(1);
			} else if (is.getItemDamage() == 161) {
				player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 4500, 2));
			} else if (is.getItemDamage() == 162) {
				player.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 4500, 2));
			} else if (is.getItemDamage() == 163) {
				player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 20*12, 2));
				player.addPotionEffect(new PotionEffect(Potion.resistance.id, 20*12, 1));
			} else if (is.getItemDamage() == 164) {
				player.addPotionEffect(new PotionEffect(Potion.heal.id, 1, 1));
				player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 4500, 2));
				player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 4500, 2));
				player.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 4500, 2));
			} else if (is.getItemDamage() == 165) {
				player.addPotionEffect(new PotionEffect(Potion.resistance.id, 4500, 2));
				player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 4500, 1));
				player.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 4500, 1));
			} else if (is.getItemDamage() == 166) {
				player.addPotionEffect(new PotionEffect(Potion.heal.id, 1, 1));
				player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 4500, 1));
				player.getFoodStats().addStats(4, 1.0F);
			} else if (is.getItemDamage() == 167) {
				player.addPotionEffect(new PotionEffect(Potion.harm.id, 1, 1));
				player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 4000, 1));
				player.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 4000, 1));
				player.addPotionEffect(new PotionEffect(Potion.confusion.id, 4500, 1));
				player.addPotionEffect(new PotionEffect(Potion.blindness.id, 4200, 1));
				player.addPotionEffect(new PotionEffect(Potion.hunger.id, 4300, 1));
				player.addPotionEffect(new PotionEffect(Potion.weakness.id, 4000, 1));
				player.addPotionEffect(new PotionEffect(Potion.poison.id, 4100, 1));
				player.addPotionEffect(new PotionEffect(Potion.wither.id, 20*12, 1));
			} else if (is.getItemDamage() == 168) {
				player.addPotionEffect(new PotionEffect(Potion.invisibility.id, 4500, 1));
				player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 4000, 1));
				player.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 4000, 1));
			} else if (is.getItemDamage() == 169) {
				if (player.experienceLevel >= 1) {
					player.addExperienceLevel(-1);
					player.addPotionEffect(new PotionEffect(Potion.harm.id, 1, 1));
					player.addPotionEffect(new PotionEffect(Potion.confusion.id, 130, 1));
					player.addPotionEffect(new PotionEffect(Potion.hunger.id, 150, 1));
					player.dropPlayerItemWithRandomChoice(new ItemStack(PackStock.proxy.item.medicals, 1, 170), true);
				} else {
					player.dropPlayerItemWithRandomChoice(new ItemStack(PackStock.proxy.item.medicals, 1, 169), true);
				}
			} else if (is.getItemDamage() == 170) {
				player.addExperienceLevel(1);
			} else if (is.getItemDamage() == 171) {
				player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 2000, 5));
				player.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 2000, 1));
			} else if (is.getItemDamage() == 172) {
				player.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 2000, 5));
				player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 2000, 1));
			} else if (is.getItemDamage() == 173) {
				player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 2000, 5));
				player.addPotionEffect(new PotionEffect(Potion.resistance.id, 2000, 3));
			} else if (is.getItemDamage() == 174) {
				player.addPotionEffect(new PotionEffect(Potion.heal.id, 1, 1));
				player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 2000, 5));
				player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 2000, 3));
				player.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 2000, 3));
			} else if (is.getItemDamage() == 175) {
				player.addPotionEffect(new PotionEffect(Potion.resistance.id, 2000, 5));
				player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 2000, 1));
				player.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 2000, 1));
			} else if (is.getItemDamage() == 176) {
				player.addPotionEffect(new PotionEffect(Potion.heal.id, 1, 1));
				player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 1, 1));
				player.getFoodStats().addStats(5, 5.0F);
			} else if (is.getItemDamage() == 177) {
				player.addPotionEffect(new PotionEffect(Potion.harm.id, 1, 1));
				player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 2000, 5));
				player.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 2000, 5));
				player.addPotionEffect(new PotionEffect(Potion.confusion.id, 2000, 5));
				player.addPotionEffect(new PotionEffect(Potion.blindness.id, 2000, 5));
				player.addPotionEffect(new PotionEffect(Potion.hunger.id, 2000, 5));
				player.addPotionEffect(new PotionEffect(Potion.weakness.id, 2000, 5));
				player.addPotionEffect(new PotionEffect(Potion.poison.id, 2000, 5));
				player.addPotionEffect(new PotionEffect(Potion.wither.id, 2000, 5));
			} else if (is.getItemDamage() == 178) {
				player.addPotionEffect(new PotionEffect(Potion.invisibility.id, 2000, 5));
				player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 2000, 5));
				player.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 2000, 5));
			} else if (is.getItemDamage() == 179) {
				if (player.experienceLevel >= 1) {
					player.addExperienceLevel(-1);
					player.addPotionEffect(new PotionEffect(Potion.confusion.id, 90, 1));
					player.addPotionEffect(new PotionEffect(Potion.hunger.id, 20*5, 1));
					player.dropPlayerItemWithRandomChoice(new ItemStack(PackStock.proxy.item.medicals, 1, 180), true);
				} else {
					player.dropPlayerItemWithRandomChoice(new ItemStack(PackStock.proxy.item.medicals, 1, 179), true);
				}
			}
			else if (is.getItemDamage() == 180) {
				player.addExperienceLevel(1);
			} else if (is.getItemDamage() == 181) {
				player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 4000, 6));
				player.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 3000, 1));
			} else if (is.getItemDamage() == 182) {
				player.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 4000, 6));
				player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 3000, 1));
			} else if (is.getItemDamage() == 183) {
				player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 20*12, 6));
				player.addPotionEffect(new PotionEffect(Potion.resistance.id, 20*12, 6));
			} else if (is.getItemDamage() == 184) {
				player.addPotionEffect(new PotionEffect(Potion.heal.id, 3, 3));
				player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 3000, 6));
				player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 2500, 6));
				player.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 2500, 6));
			} else if (is.getItemDamage() == 185) {
				player.addPotionEffect(new PotionEffect(Potion.resistance.id, 20*15, 6));
				player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 20*15, 5));
				player.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 20*15, 5));
			} else if (is.getItemDamage() == 186) {
				player.addPotionEffect(new PotionEffect(Potion.heal.id, 1, 5));
				player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 20*30, 6));
				player.getFoodStats().addStats(6, 6.0F);
			} else if (is.getItemDamage() == 187) {
				player.addPotionEffect(new PotionEffect(Potion.harm.id, 1, 1));
				player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 20*12, 3));
				player.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 20*12, 3));
				player.addPotionEffect(new PotionEffect(Potion.confusion.id, 20*12, 3));
				player.addPotionEffect(new PotionEffect(Potion.blindness.id, 20*12, 3));
				player.addPotionEffect(new PotionEffect(Potion.hunger.id, 20*12, 3));
				player.addPotionEffect(new PotionEffect(Potion.weakness.id, 20*12, 3));
				player.addPotionEffect(new PotionEffect(Potion.poison.id, 20*12, 3));
				player.addPotionEffect(new PotionEffect(Potion.wither.id, 20*12, 3));
			} else if (is.getItemDamage() == 188) {
				player.addPotionEffect(new PotionEffect(Potion.invisibility.id, 5000, 6));
				player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 4000, 5));
				player.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 4000, 5));
			} else if (is.getItemDamage() == 189) {
				if (player.experienceLevel >= 1) {
					player.addExperienceLevel(-1);
					player.addPotionEffect(new PotionEffect(Potion.confusion.id, 50, 1));
					player.dropPlayerItemWithRandomChoice(new ItemStack(PackStock.proxy.item.medicals, 1, 190), true);
				} else {
					player.dropPlayerItemWithRandomChoice(new ItemStack(PackStock.proxy.item.medicals, 1, 189), true);
				}
			} else if (is.getItemDamage() == 190) {
				player.addExperienceLevel(1);

				//----------------------------------------------------------------------------
			} else {/*player.addChatMessage("Error");*/}

		}
		return is;
	}

	public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer player) {
		player.setItemInUse(is, getMaxItemUseDuration(is));
		return is;
	}

	public int getMaxItemUseDuration(ItemStack is) {return 12;}

	public EnumAction getItemUseAction(ItemStack is) {return EnumAction.eat;}

	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack is) {
		return (is.getItemDamage() >=  91 && is.getItemDamage() <=  150);
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister ir) {
		iconArray = new IIcon[medicalNames.length];

		for (int i = 0; i < medicalNames.length; ++i) {
			iconArray[i] = ir.registerIcon("timaxa007:" + "medical/");
		}
	}

}
