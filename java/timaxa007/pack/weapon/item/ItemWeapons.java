package timaxa007.pack.weapon.item;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import timaxa007.module.control_button.api.IScope;
import timaxa007.module.control_button.trash.ItemPrimaryKey;
import timaxa007.pack.weapon.PackWeapons;
import timaxa007.pack.weapon.lib.WeaponFor;
import timaxa007.pack.weapon.packet.MessageActionWeapons;
import timaxa007.tms.Core;
import timaxa007.tms.util.UtilString;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemWeapons extends ItemPrimaryKey implements IScope {

	@SideOnly(Side.CLIENT) private IIcon[] icon_tex;
	@SideOnly(Side.CLIENT) private IIcon[] icon_ovl;

	public ItemWeapons(String tag) {
		super(tag);
		setMaxStackSize(1);
		setMaxDamage(1024);
		setNoRepair();
		setCreativeTab(PackWeapons.tab_weapons);
		setTextureName("timaxa007:weapons");
	}

	@Override
	public void onUpdate(ItemStack is, World world, Entity entity, int par4, boolean par5) {
		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)entity;
			ItemStack current = player.getCurrentEquippedItem();
			NBTTagCompound nbt = is.getTagCompound();
			if (nbt != null) {

				if (nbt.hasKey("Delay")) {
					int delay = (int)nbt.getByte("Delay"); 

					if (delay > 0) {
						--delay;
						nbt.setByte("Delay", (byte)delay);
						is.setTagCompound(nbt);
					}

				} else {
					nbt.setByte("Delay", (byte)0);
					is.setTagCompound(nbt);
				}

			}
		}
	}

	@SideOnly(Side.CLIENT)
	public void onLeftClickTickClient(ItemStack is, World world, EntityPlayer player, int tick) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null && nbt.hasKey("Weapon") && nbt.hasKey("AmmoAtm") && nbt.hasKey("Delay")) {
			int delay = (int)nbt.getByte("Delay");

			if (nbt.getInteger("AmmoAtm") > 0) {
				if (delay == 0) {
					//if (Core.show_system_info_testing) System.out.println("fire1 " + tick);
					PackWeapons.network.sendToServer(new MessageActionWeapons(1));
					dellay(nbt);
				}
			}

			is.setTagCompound(nbt);

		}
	}

	@SideOnly(Side.CLIENT)
	public void onLeftClickClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		super.onLeftClickClient(is, world, player, isPress);
	}

	public void fire(ItemStack is, World world, EntityPlayer player) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null && nbt.hasKey("Weapon") && nbt.hasKey("AmmoAtm") && nbt.hasKey("Delay")) {

			if (Core.show_system_info_testing) System.out.println("fire");
			world.playSoundAtEntity(player, WeaponFor.get(nbt.getString("Weapon")).getSoundFire()[0], 1.0F, 1.0F);
			EntityArrow entityarrow = new EntityArrow(world, player, 5.0F);
			world.spawnEntityInWorld(entityarrow);
			nbt.setInteger("AmmoAtm", nbt.getInteger("AmmoAtm") - 1);

			dellay(nbt);

			is.setTagCompound(nbt);
		}
	}

	public void dellay(NBTTagCompound nbt) {
		if (nbt != null && nbt.hasKey("Weapon") && nbt.hasKey("Delay")) {

			int delay = (int)nbt.getByte("Delay");

			if (delay == 0) {
				delay = WeaponFor.get(nbt.getString("Weapon")).getDelay();
				nbt.setByte("Delay", (byte)delay);
			}

		}
	}

	@SideOnly(Side.CLIENT)
	public void onRightClickTickClient(ItemStack is, World world, EntityPlayer player, int tick) {
		/*
		if (isModeIn && !isModeOut)
			PackWeapons.network.sendToServer(new MessageActionWeapons(5, true));
		if (isModeOut && !isModeIn)
			PackWeapons.network.sendToServer(new MessageActionWeapons(6, true));
		 */
	}

	@SideOnly(Side.CLIENT)
	public void onRightClickClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		super.onRightClickClient(is, world, player, isPress);
		PackWeapons.network.sendToServer(new MessageActionWeapons((isPress ? 2 : -2)));
	}

	public void scope(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null && nbt.hasKey("Aim")) {
			nbt.setBoolean("Aim", isPress);
			is.setTagCompound(nbt);
			if (Core.show_system_info_testing) System.out.println(isPress ? "onScope" : "offScope");
		}
	}

	@SideOnly(Side.CLIENT)
	public void onReloadClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		super.onReloadClient(is, world, player, isPress);
		PackWeapons.network.sendToServer(new MessageActionWeapons(3));
	}

	public void reload(ItemStack is, World world, EntityPlayer player) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null && nbt.hasKey("Weapon")) {
			world.playSoundAtEntity(player, WeaponFor.get(nbt.getString("Weapon")).getSoundReload()[0], 1.0F, 1.0F);
			if (Core.show_system_info_testing) System.out.println("-reload-");
			//nbt.setInteger("AmmoAtm", WeaponFor.get(nbt.getString("Weapon")).getSizeAmmo());
			nbt.setInteger("AmmoAtm", 20);
			is.setTagCompound(nbt);
		}
	}

	@SideOnly(Side.CLIENT)
	public void onModeClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		super.onModeClient(is, world, player, isPress);
		PackWeapons.network.sendToServer(new MessageActionWeapons(4));
	}

	public void mode(ItemStack is, World world, EntityPlayer player) {
		player.openGui(PackWeapons.instance, PackWeapons.proxy.gui_modify, world, (int)player.posX, (int)player.posY, (int)player.posZ);
		if (Core.show_system_info_testing) System.out.println("-modify-");
	}

	@SideOnly(Side.CLIENT)
	public void onModeInClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		super.onModeInClient(is, world, player, isPress);
		if (isPress && isRightClick && !isModeOut)
			PackWeapons.network.sendToServer(new MessageActionWeapons(5));
	}

	@SideOnly(Side.CLIENT)
	public void onModeOutClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		super.onModeOutClient(is, world, player, isPress);
		if (isPress && isRightClick && !isModeIn)
			PackWeapons.network.sendToServer(new MessageActionWeapons(6));
	}

	public void zoomIn(ItemStack is, World world, EntityPlayer player) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null && nbt.hasKey("ZoomFov")) {
			int get_zoom = nbt.getByte("ZoomFov");
			if (get_zoom < 119) {
				nbt.setByte("ZoomFov", (byte)(get_zoom + 8));
			}
		}
	}

	public void zoomOut(ItemStack is, World world, EntityPlayer player) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null && nbt.hasKey("ZoomFov")) {
			int get_zoom = nbt.getByte("ZoomFov");
			if (get_zoom > -119) {
				nbt.setByte("ZoomFov", (byte)(get_zoom - 8));
			}
		}
	}

	public boolean onEntitySwing(EntityLivingBase entity, ItemStack is) {
		return true;
	}

	public boolean onLeftClickEntity(ItemStack is, EntityPlayer player, Entity entity) {
		return true;
	}

	public int getMaxItemUseDuration(ItemStack is) {
		return 72000;
	}

	public EnumAction getItemUseAction(ItemStack is) {
		return EnumAction.none;
	}

	public String getUnlocalizedName(ItemStack is) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null && nbt.hasKey("Weapon")) {
			return "weapon." + WeaponFor.get(nbt.getString("Weapon")).getName();
		}
		return super.getUnlocalizedName();
	}

	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
		NBTTagCompound nbt = is.getTagCompound();
		if (UtilString.isShiftKeyDown()) {
			if (nbt != null) {

				if (nbt.hasKey("Weapon")) {
					list.add("Weapon: " + nbt.getString("Weapon") + "/" + WeaponFor.get(nbt.getString("Weapon")).getLocalizedName() + ".");
					list.add("Weapon: " + WeaponFor.get(nbt.getString("Weapon")).getType() + 
							"/" + WeaponFor.get(nbt.getString("Weapon")).getName() + ".");
				}

				if (nbt.hasKey("AmmoAtm")) {
					list.add("AmmoAtm:  " + nbt.getInteger("AmmoAtm") + ".");
				}

				if (nbt.hasKey("ZoomFov") && Core.show_tip_info_testing) {
					list.add("ZoomFov:  " + nbt.getByte("ZoomFov") + ".");
				}

				if (nbt.hasKey("Delay") && Core.show_tip_info_testing) {
					list.add("Delay:  " + nbt.getByte("Delay") + ".");
				}

			}
		} else list.add(UtilString.hldshiftinf);
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item id, CreativeTabs table, List list) {
		for (int i = 0; i < WeaponFor.list.length; i++) {
			if (WeaponFor.list[i] != null) {
				if (WeaponFor.list[i].tag != null) {
					list.add(addNBT(WeaponFor.list[i].tag));
				}
			}
		}
		//list.add(new ItemStack(id, 1, 0));
	}

	public static ItemStack addNBT(String par1) {
		ItemStack is = new ItemStack(PackWeapons.proxy.item.weapons, 1, 0);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setString("Weapon", par1);

		nbt.setBoolean("Aim", false);
		nbt.setByte("ZoomFov", (byte)0);

		is.setTagCompound(nbt);
		return is;
	}

}
