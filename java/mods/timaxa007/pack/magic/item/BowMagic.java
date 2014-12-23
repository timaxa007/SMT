package mods.timaxa007.pack.magic.item;

import java.util.List;

import mods.timaxa007.lib.Option;
import mods.timaxa007.pack.magic.PackMagic;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BowMagic extends Item {

	@SideOnly(Side.CLIENT) private IIcon[] iconArray;

	public BowMagic() {
		super();
		setMaxStackSize(1);
		setMaxDamage(1000);
		setCreativeTab(PackMagic.tab_magic);
		setUnlocalizedName("magic.bow");
	}

	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
		if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
			list.add(Option.getText("Material") + ": Wooden.");
			list.add(Option.getText("Type") + ": Magic.");
			list.add("D: " + is.getItemDamage() + "/" + is.getMaxDamage() + ".");
		} else {
			list.add(Option.prshift);
		}
	}

	public void onUpdate(ItemStack is, World world, Entity entity, int par4, boolean par5) {
		if (entity instanceof EntityPlayer) {

		}

	}

	@Override
	public boolean itemInteractionForEntity(ItemStack is, EntityPlayer player, EntityLivingBase entity) {
		if (entity.worldObj.isRemote) {return false;}
		else if (entity instanceof EntityLivingBase) {
			entity.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 20*15, 254));
			entity.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 20*15, 254));
			entity.addPotionEffect(new PotionEffect(Potion.weakness.id, 20*15, 254));
			entity.addPotionEffect(new PotionEffect(Potion.blindness.id, 20*15, 254));
			return true;
		}
		else if (entity instanceof EntityPlayer) {
			entity.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 20*15, 254));
			entity.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 20*15, 254));
			entity.addPotionEffect(new PotionEffect(Potion.weakness.id, 20*15, 254));
			entity.addPotionEffect(new PotionEffect(Potion.blindness.id, 20*15, 254));
			//entity.motionZ = 0.0D;
			//entity.motionZ = 0.0D;
			/*
			entity.removePotionEffect(Potion.moveSlowdown.id);
			entity.removePotionEffect(Potion.digSlowdown.id);
			entity.removePotionEffect(Potion.weakness.id);
			entity.removePotionEffect(Potion.blindness.id);
			 */
			return true;
		} else {
			return false;
		}
	}

	public void onPlayerStoppedUsing(ItemStack is, World world, EntityPlayer player, int par4) {
		int j = getMaxItemUseDuration(is) - par4;
		ArrowLooseEvent event = new ArrowLooseEvent(player, is, j);
		MinecraftForge.EVENT_BUS.post(event);
		if (event.isCanceled()) {return;}
		j = event.charge;
		boolean flag = player.capabilities.isCreativeMode||EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, is) > 0;
		if (flag || player.inventory.hasItem(PackMagic.proxy.item.arrow_mini)) {
			float f = (float)j / 20.0F;
			f = (f * f + f * 2.0F) / 3.0F;
			if ((double)f<0.1D) {return;}
			if (f > 1.0F) {f = 1.0F;}
			/*EntityArrowMini entityarrow = new EntityArrowMini(world, player, f*2.0F);
			if (f == 1.0F) {entityarrow.setIsCritical(true);}
			int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, is);
			if (k>0) {entityarrow.setDamage(entityarrow.getDamage() + (double)k*0.5D+0.5D);}
			int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, is);
			if (l>0) {entityarrow.setKnockbackStrength(l);}
			if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, is)>0) {entityarrow.setFire(100);}
			is.damageItem(1, player);
			world.playSoundAtEntity(player, "random.bow", 1.0F, 1.0F/(itemRand.nextFloat()*0.4F+1.2F)+f*0.5F);
			if (flag) {entityarrow.canBePickedUp = 2;}
			else {player.inventory.consumeInventoryItem(PackMagic.proxy.itemArrowMini.getItem());}
			//if (!world.isRemote) {
			world.spawnEntityInWorld(entityarrow);
			}*/
		}
	}

	public ItemStack onEaten(ItemStack is, World world, EntityPlayer player) {
		return is;
	}

	public int getMaxItemUseDuration(ItemStack is) {
		return 72000;
	}

	public EnumAction getItemUseAction(ItemStack is) {
		return EnumAction.bow;
	}

	public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer player) {
		ArrowNockEvent event = new ArrowNockEvent(player, is);
		MinecraftForge.EVENT_BUS.post(event);
		if (event.isCanceled()) {return event.result;}

		if (player.capabilities.isCreativeMode || player.inventory.hasItem(Items.arrow)) {
			player.setItemInUse(is, getMaxItemUseDuration(is));
		}

		return is;
	}

	public int getItemEnchantability() {return 1;}

	public IIcon getIcon(ItemStack is, int renderPass, EntityPlayer player, ItemStack useItm, int useRem) {
		BowMagic itm = PackMagic.proxy.item.magic_bow;
		if (useItm != null && is.getItem() == itm) {
			int j = is.getMaxItemUseDuration()-useRem;
			if (j >= 18) {return itm.getItemIIconForUseDuration(2);}
			if (j>13) {return itm.getItemIIconForUseDuration(1);}
			if (j>0) {return itm.getItemIIconForUseDuration(0);}
		}
		return getIcon(is, renderPass);
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister ir) {
		super.registerIcons(ir);
		iconArray = new IIcon[3];
		itemIcon = ir.registerIcon("timaxa007:" + "tool/" + "bowMagic");

		for (int i = 0; i < iconArray.length; ++i) {
			iconArray[i] = ir.registerIcon("timaxa007:" + "tool/" + "bowMagic_pull_" + i);
		}
	}

	@SideOnly(Side.CLIENT)
	public IIcon getItemIIconForUseDuration(int par1) {
		return iconArray[par1];
	}

}
