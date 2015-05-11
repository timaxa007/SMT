package timaxa007.pack.stock.item;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import timaxa007.pack.stock.PackStock;
import timaxa007.pack.stock.lib.ReceivingNutriment;
import timaxa007.tms.object.ModifiedItem;
import timaxa007.tms.util.UtilInteger;
import timaxa007.tms.util.UtilString;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMedicals extends ModifiedItem {

	@SideOnly(Side.CLIENT) private IIcon[] iconArray;

	public ItemMedicals(String tag) {
		super(tag);
		setCreativeTab(PackStock.tab_medical);
		setHasSubtypes(true);
		setMaxDamage(0);
	}
	/*
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int meta) {
		return iconArray[meta];
	}
	 */
	/*
	public String getUnlocalizedName(ItemStack is) {
		int i = MathHelper.clamp_int(is.getItemDamage(), 0, (medicalNames.length)-1);
		return super.getUnlocalizedName() + "." + medicalNames[i];
	}
	 */
	public ItemStack onEaten(ItemStack is, World world, EntityPlayer player) {
		if (!player.capabilities.isCreativeMode) {--is.stackSize;}
		//if (!world.isRemote) {
		
		ReceivingNutriment.addEffectPlayer(is, player);
		/*
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
				//player.addExperience(1);
				//player.addExperienceLevel(1);
				//player.dropPlayerItem(new ItemStack(PackStock.itemMedicals, 1, 3));

				player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 20*5, 0));
				player.getFoodStats().addStats(1, 1.0F)
				player.addExperienceLevel(1);

				if (player.experienceLevel >= 1) {
					player.addExperienceLevel(-1);
					player.addPotionEffect(new PotionEffect(Potion.confusion.id, 50, 1));
					player.dropPlayerItemWithRandomChoice(new ItemStack(PackStock.item.medicals, 1, 190), true);
				} else {
					player.dropPlayerItemWithRandomChoice(new ItemStack(PackStock.item.medicals, 1, 189), true);
				}
			} else if (is.getItemDamage() == 190) {
				player.addExperienceLevel(1);

				//----------------------------------------------------------------------------
			} else {/*player.addChatMessage("Error");
		 */
		//}
		return is;
	}

	public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer player) {
		player.setItemInUse(is, getMaxItemUseDuration(is));
		return super.onItemRightClick(is, world, player);
	}

	public int getMaxItemUseDuration(ItemStack is) {
		return 12;
	}

	public EnumAction getItemUseAction(ItemStack is) {
		return EnumAction.eat;
	}

	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack is) {
		return false;
	}

	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
		NBTTagCompound nbt = is.getTagCompound();
		if (UtilString.isShiftKeyDown()) {
			if (nbt != null) {
			}
		} else list.add(UtilString.hldshiftinf);
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item id, CreativeTabs table, List list) {
		if (PackStock.item.medicals_be) {
			for (int i = 0; i < Potion.potionTypes.length; i++) {
				if (Potion.potionTypes[i] != null) {
					for (int j = 0; j < 4; j++) list.add(addNBT(i, 60, j));
					list.add(addNBT(i, 60, 255));
				}
			}
		}
		/*for(int j = 0; j < medicalNames.length; ++j) {
			list.add(new ItemStack(id, 1, j));
		}*/
	}

	public static ItemStack addNBT(int id, int time, int lvl) {
		ItemStack is = new ItemStack(PackStock.item.medicals);
		NBTTagCompound nbt = new NBTTagCompound();
		ReceivingNutriment.addEffect(nbt, id, time, lvl);
		is.setTagCompound(nbt);
		return is;
	}

	/*
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister ir) {
		iconArray = new IIcon[medicalNames.length];

		for (int i = 0; i < medicalNames.length; ++i) {
			iconArray[i] = ir.registerIcon("timaxa007:" + "medical/");
		}
	}
	 */
}
