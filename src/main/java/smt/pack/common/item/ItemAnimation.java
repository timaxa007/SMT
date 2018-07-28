package smt.pack.common.item;

import java.util.HashMap;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemAnimation extends Item implements smt.pack.common.api.IRegisterItem {
	/*
	@SideOnly(CLIENT)
	public Animation3DPlay
	main = null,
	end = null,
	ammo = null,
	ammoR = null,
	aim = null;

	@SideOnly(CLIENT)
	private HashMap<String, IAnimation3D> test = new HashMap<String, IAnimation3D>();

	@SideOnly(CLIENT)
	public static boolean lastRightClick;

	public ItemAnimation() {
		super();
		main = AnimationManager.playAnimation(AnimationManager.playAnimation("pistol_main"));
	}

	@Override
	public void onUpdate(ItemStack itemStack, World world, Entity entity, int slot, boolean isHand) {
		if (world.isRemote) {
			if (!isHand) return;
			Minecraft mc = Minecraft.getMinecraft();

			if (mc.gameSettings.keyBindAttack.getIsKeyPressed() && (end == null || end.time >= 3))
				end = AnimationManager.playAnimation(AnimationManager.playAnimation("pistol_end"));

			if (mc.gameSettings.keyBindUseItem.getIsKeyPressed() && !lastRightClick) {
				aim = new Animation3DPlay(test.get("pistol_aim"));
			}

			if (Mouse.isButtonDown(1) && aim != null)
				if (aim.time == 3) aim.pause = true;
			if (!Mouse.isButtonDown(1) && aim != null)
				if (aim.time == 3) aim.pause = false;

			if (aim != null) {
				aim.update();
			}

			lastRightClick = mc.gameSettings.keyBindUseItem.getIsKeyPressed();


			if (RegKey.reload.isPressed() && ammo == null) {
				ammo = new Animation3DPlay(test.get("pistol_ammo"));
				ammoR = AnimationManager.playAnimation(AnimationManager.playAnimation("pistol_r_ammo"));
			}

			if (main != null) {
				main.update();
				if (main.animation != null && main.time >= main.animation.getTimeLine()) main = null;
			}
			if (end != null) {
				end.update();
				if (end.animation != null && end.time >= end.animation.getTimeLine()) end = null;
			}
			if (ammo != null) {
				ammo.update();
				if (ammo.animation != null && ammo.time >= ammo.animation.getTimeLine()) ammo = null;
			}
		}
	}

	@SideOnly(CLIENT)
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		if (world.isRemote) {
			if (player.isSneaking()) {
				Minecraft.getMinecraft().displayGuiScreen(new GuiAnimation());
			} else {
				//if (test.isEmpty())
				AnimationManager.Loader.loadJsonAnimation3D(test, new ResourceLocation(SMTCommon.MODID, "animations/test.json"));
			}
			//SMTCommon.proxy.openGui(GuiID.ANIMATION_ITEM, player);
		}
		return super.onItemRightClick(itemStack, world, player);
	}
	 */
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
		return true;
	}

	@Override
	public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack) {
		return true;
	}

	@Override
	public String getRegisterName() {
		return "item_animation";
	}

	@Override
	public void getRegisterItem(final HashMap<String, ItemStack> map) {
		map.put(getRegisterName(), new ItemStack(this));
	}

}
