package mods.timaxa007.pack.weapon.item;

import java.util.List;

import mods.timaxa007.pack.weapon.PackWeapons;
import mods.timaxa007.pack.weapon.lib.WeaponFor;
import mods.timaxa007.tms.Core;
import mods.timaxa007.tms.util.ItemPrimaryKey;
import mods.timaxa007.tms.util.UtilText;
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
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemWeapons extends ItemPrimaryKey {

	@SideOnly(Side.CLIENT) private IIcon[] icon_tex;
	@SideOnly(Side.CLIENT) private IIcon[] icon_ovl;

	public ItemWeapons(String tag) {
		super(tag);
		setMaxStackSize(1);
		setCreativeTab(PackWeapons.tab_weapons);
		setTextureName("timaxa007:weapons");
	}

	public void onUpdate(ItemStack is, World world, Entity entity, int par4, boolean par5) {
		if (entity instanceof EntityPlayer) {

		}
	}

	@Override
	public void onLeftClickTick(ItemStack is, World world, EntityPlayer player) {
		NBTTagCompound tag = is.getTagCompound();

		if (tag != null) {
			int rtm = 0;

			if (tag.hasKey("Weapon") && tag.hasKey("AmmoAtm")) {
				if (tag.hasKey("RTM")) {
					rtm = (int)tag.getByte("RTM"); 
				} else {
					tag.setByte("RTM", (byte)0);
					rtm = 0;
				}

				rtm += 1;
				if (rtm > 20) rtm = 0;

				if (tag.getInteger("AmmoAtm") > 0) {
					if (isFire(rtm, 2)) {
						if (!world.isRemote) {
							world.playSoundAtEntity(player, "timaxa007:scout_fire-1", 1.0F, 1.0F);
							EntityArrow entityarrow = new EntityArrow(world, player, 2.0F);
							world.spawnEntityInWorld(entityarrow);
							tag.setInteger("AmmoAtm", tag.getInteger("AmmoAtm") - 1);
							if (Core.show_system_info_testing) System.out.println("fire");
						}
					}
				}
				tag.setByte("RTM", (byte)rtm);
			}
			is.setTagCompound(tag);
		}
	}

	@Override
	public void onRightClickTick(ItemStack is, World world, EntityPlayer player) {

	}

	@Override
	public void onLeftClick(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		NBTTagCompound tag = is.getTagCompound();
		if (tag != null) {
			if (tag.hasKey("RTM")) {
				if (!isPress) tag.setByte("RTM", (byte)0);
			}
		}
		//if (tag.hasKey("Weapon") && tag.hasKey("AmmoAtm")) {
		//if (!isPress) tag.removeTag("RTM");

		/*
			if (!world.isRemote && isPress) {
				if (tag.getInteger("AmmoAtm") > 0) {
					world.playSoundAtEntity(player, "timaxa007:ak74_shoot", 1.0F, 1.0F);
					tag.setInteger("AmmoAtm", tag.getInteger("AmmoAtm") - 1);
					if (Core.show_system_info_testing) System.out.println("fire");
				}
			}
		 */
		//is.setTagCompound(tag);
		//}
	}

	@Override
	public void onRightClick(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		NBTTagCompound tag = is.getTagCompound();
		if (!world.isRemote) {
			if (tag != null && tag.hasKey("Aim")) {
				tag.setBoolean("Aim", isPress);
				is.setTagCompound(tag);
				if (Core.show_system_info_testing) System.out.println(isPress ? "onScope" : "offScope");
			}

		}

		//if (isPress) PackWeapons.network.sendTo(new PacketOpenGui(1), (EntityPlayerMP)player);

	}

	@Override
	public void onReload(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		NBTTagCompound tag = is.getTagCompound();
		if (tag != null && tag.hasKey("Weapon")) {
			if (!world.isRemote) {

			} else {
				if (Core.show_system_info_testing) System.out.println("-reload-");
			}

			//tag.setInteger("AmmoAtm", MagazineFor.magazine_list[tag.getInteger("MagazineID")].getSize());
			tag.setInteger("AmmoAtm", 20);
			is.setTagCompound(tag);
		}
	}

	@SideOnly(Side.CLIENT)
	public boolean onModeClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		if (isPress) {
			player.openGui(PackWeapons.instance, PackWeapons.proxy.gui_modify, world, (int)player.posX, (int)player.posY, (int)player.posZ);
			if (Core.show_system_info_testing) System.out.println("-modify-");
			return true;
		}
		return super.onModeClient(is, world, player, isPress);
	}

	public void onMode(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		if (isPress) {
			player.openGui(PackWeapons.instance, PackWeapons.proxy.gui_modify, world, (int)player.posX, (int)player.posY, (int)player.posZ);
			if (Core.show_system_info_testing) System.out.println("-modify-");
		}
	}

	@SideOnly(Side.CLIENT)
	public boolean onModeInTickClient(ItemStack is, World world, EntityPlayer player) {
		if (isRightClick) return true;
		return super.onModeInTickClient(is, world, player);
	}

	public void onModeInTick(ItemStack is, World world, EntityPlayer player) {
		NBTTagCompound tag = is.getTagCompound();
		if (tag.hasKey("ZoomFov")) {
			int get_zoom = tag.getByte("ZoomFov");
			if (get_zoom < 119) {
				tag.setByte("ZoomFov", (byte)(get_zoom + 8));
				is.setTagCompound(tag);
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public boolean onModeOutTickClient(ItemStack is, World world, EntityPlayer player) {
		if (isRightClick) return true;
		return false;
	}

	public void onModeOutTick(ItemStack is, World world, EntityPlayer player) {
		NBTTagCompound tag = is.getTagCompound();
		if (tag.hasKey("ZoomFov")) {
			int get_zoom = tag.getByte("ZoomFov");
			if (get_zoom > -119) {
				tag.setByte("ZoomFov", (byte)(get_zoom - 8));
				is.setTagCompound(tag);
			}
		}
	}
	/*
	@Override
	public void onZoomIn(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		NBTTagCompound tag = is.getTagCompound();
		if (isPress) {
			if (tag.hasKey("ZoomFov")) {
				int get_zoom = tag.getByte("ZoomFov");
				if (get_zoom < 127) {
					tag.setByte("ZoomFov", (byte)(get_zoom + 1));
					is.setTagCompound(tag);
				}
			}
		}
	}

	@Override
	public void onZoomOut(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		NBTTagCompound tag = is.getTagCompound();
		if (isPress) {
			if (tag.hasKey("ZoomFov")) {
				int get_zoom = tag.getByte("ZoomFov");
				if (get_zoom > -127) {
					tag.setByte("ZoomFov", (byte)(get_zoom - 1));
					is.setTagCompound(tag);
				}
			}
		}
	}
	 */
	private boolean isFire(int i, int type) {

		if (type == 20) {switch(i) {default:return true;}}

		if (type == 10) {
			switch(i) {
			case 1:return true;
			case 3:return true;
			case 5:return true;
			case 7:return true;
			case 9:return true;
			case 11:return true;
			case 13:return true;
			case 15:return true;
			case 17:return true;
			case 19:return true;
			default:return false;
			}
		}

		if (type == 5) {
			switch(i) {
			case 1:return true;
			case 5:return true;
			case 9:return true;
			case 13:return true;
			case 17:return true;
			default:return false;
			}
		}

		if (type == 4) {
			switch(i) {
			case 1:return true;
			case 6:return true;
			case 11:return true;
			case 16:return true;
			default:return false;
			}
		}

		if (type == 2) {
			switch(i) {
			case 1:return true;
			case 11:return true;
			default:return false;
			}
		}

		if (type == 1) {
			switch(i) {
			case 1:return true;
			default:return false;
			}
		}

		if (type == -1) {
			switch(i) {
			case 18:return true;
			default:return false;
			}
		}

		return false;
	}

	public boolean onEntitySwing(EntityLivingBase entity, ItemStack is) {
		return true;
	}

	public boolean onLeftClickEntity(ItemStack is, EntityPlayer player, Entity entity) {
		return true;
	}
	/*public void onPlayerStoppedUsing(ItemStack is, World world, EntityPlayer player, int par4) {
		NBTTagCompound tag = is.getTagCompound();
		if (!world.isRemote) {
			if (tag != null && tag.hasKey("Aim")) {
				tag.setBoolean("Aim", false);
				is.setTagCompound(tag);
				System.out.println("off-scope");
			}
		}
	}

	public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer player) {
		NBTTagCompound tag = is.getTagCompound();
		//if (player.capabilities.isCreativeMode || player.inventory.hasItem(Item.arrow.getItem())) {
		player.setItemInUse(is, getMaxItemUseDuration(is));
		//}
		if (!world.isRemote) {
			if (tag != null && tag.hasKey("Aim")) {
				tag.setBoolean("Aim", true);
				is.setTagCompound(tag);
				System.out.println("on-scope");
			}
		}
		return is;
	}*/

	public int getMaxItemUseDuration(ItemStack is) {
		return 72000;
	}

	public EnumAction getItemUseAction(ItemStack is) {
		return EnumAction.none;
	}

	public String getUnlocalizedName(ItemStack is) {
		NBTTagCompound tag = is.getTagCompound();
		if (tag != null && tag.hasKey("Weapon")) {
			return "weapon." + WeaponFor.get(tag.getString("Weapon")).getName();
		}
		return super.getUnlocalizedName();
	}

	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
		NBTTagCompound tag = is.getTagCompound();
		if (UtilText.isShiftKeyDown()) {
			if (tag != null) {

				if (tag.hasKey("Weapon")) {
					list.add("Weapon: " + tag.getString("Weapon") + "/" + WeaponFor.get(tag.getString("Weapon")).getLocalizedName() + ".");
					list.add("Weapon: " + WeaponFor.get(tag.getString("Weapon")).getType() + 
							"/" + WeaponFor.get(tag.getString("Weapon")).getName() + ".");
				}

			}
		} else list.add(UtilText.hldshiftinf);
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item id, CreativeTabs table, List list) {
		for (int i = 0; i < WeaponFor.list.length; i++) {
			if (WeaponFor.list[i] != null) {
				if (WeaponFor.list[i].tag != null) {
					list.add(addTag(WeaponFor.list[i].tag));
				}
			}
		}
		//list.add(new ItemStack(id, 1, 0));
	}

	private static ItemStack addTag(String par1) {
		ItemStack is = new ItemStack(PackWeapons.proxy.item.weapons, 1, 0);
		NBTTagCompound tag = new NBTTagCompound();
		tag.setString("Weapon", par1);

		tag.setBoolean("Aim", false);
		tag.setByte("ZoomFov", (byte)0);

		is.setTagCompound(tag);
		return is;
	}

}
