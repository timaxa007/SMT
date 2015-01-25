package mods.timaxa007.pack.weapon.item;

import java.util.List;

import mods.timaxa007.pack.weapon.PackWeapons;
import mods.timaxa007.pack.weapon.lib.WeaponFor;
import mods.timaxa007.pack.weapon.packet.MessageActionWeapons;
import mods.timaxa007.tms.Core;
import mods.timaxa007.tms.util.IScope;
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
			if (current != null && current == is) {
				NBTTagCompound tag = is.getTagCompound();
				if (tag != null) {
					//---------------------------------------------------------------
					if (tag.hasKey("Weapon") && tag.hasKey("AmmoAtm")) {

						int rbt/* = 0*/;
						if (tag.hasKey("RBT")) {
							rbt = (int)tag.getByte("RBT"); 
						} else {
							tag.setByte("RBT", (byte)0);
							rbt = 0;
						}

						if (rbt > 0) --rbt;

						if (isLeftClick) {
							if (tag.getInteger("AmmoAtm") > 0) {
								if (rbt == 0) {
									if (!world.isRemote) {
										PackWeapons.network.sendToServer(new MessageActionWeapons(1));
									}
									rbt = WeaponFor.get(tag.getString("Weapon")).getDelay();
								}
							}
						}
						tag.setByte("RBT", (byte)rbt);
					} else {
						//if (tag.hasKey("RTM")) tag.setByte("RTM", (byte)0);
					}
					//-----------------------------------------------------------------------------------------------
					if (isRightClick && isModeIn && !isModeOut) {
						if (tag.hasKey("ZoomFov")) {
							int get_zoom = tag.getByte("ZoomFov");
							if (get_zoom < 119) {
								tag.setByte("ZoomFov", (byte)(get_zoom + 8));
							}
						}
					}
					//---------------------------------------------------------------
					if (isRightClick && isModeOut && !isModeIn) {
						if (tag.hasKey("ZoomFov")) {
							int get_zoom = tag.getByte("ZoomFov");
							if (get_zoom > -119) {
								tag.setByte("ZoomFov", (byte)(get_zoom - 8));
							}
						}
					}
					//---------------------------------------------------------------
					is.setTagCompound(tag);
				}
			}
		}
	}

	public void onFire(ItemStack is, World world, EntityPlayer player) {
		NBTTagCompound tag = is.getTagCompound();
		if (tag != null) {
			if (tag.hasKey("Weapon") && tag.hasKey("AmmoAtm")) {
				world.playSoundAtEntity(player, WeaponFor.get(tag.getString("Weapon")).getSoundFire()[0], 1.0F, 1.0F);
				EntityArrow entityarrow = new EntityArrow(world, player, 5.0F);
				world.spawnEntityInWorld(entityarrow);
				tag.setInteger("AmmoAtm", tag.getInteger("AmmoAtm") - 1);
				if (Core.show_system_info_testing) System.out.println("fire");
			}
		}
	}

	@Override
	public void onLeftClick(ItemStack is, World world, EntityPlayer player, boolean isPress) {
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

	@SideOnly(Side.CLIENT)
	public boolean onRightClickClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		NBTTagCompound tag = is.getTagCompound();
		if (tag != null && tag.hasKey("Aim")) {
			return true;
		}
		return super.onRightClickClient(is, world, player, isPress);
	}

	@Override
	public void onRightClick(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		NBTTagCompound tag = is.getTagCompound();
		if (tag != null && tag.hasKey("Aim")) {
			tag.setBoolean("Aim", isPress);
			is.setTagCompound(tag);
			if (Core.show_system_info_testing) System.out.println(isPress ? "onScope" : "offScope");
		}
	}

	@SideOnly(Side.CLIENT)
	public boolean onReloadClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		NBTTagCompound tag = is.getTagCompound();
		if (tag != null && tag.hasKey("Weapon")) {
			return true;
		}
		return super.onReloadClient(is, world, player, isPress);
	}

	@Override
	public void onReload(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		NBTTagCompound tag = is.getTagCompound();
		if (tag != null && tag.hasKey("Weapon")) {
			if (isPress) {
				if (!world.isRemote) {
					world.playSoundAtEntity(player, WeaponFor.get(tag.getString("Weapon")).getSoundReload()[0], 1.0F, 1.0F);
				} else {
					if (Core.show_system_info_testing) System.out.println("-reload-");
				}
				//tag.setInteger("AmmoAtm", WeaponFor.get(tag.getString("Weapon")).getSizeAmmo());
				tag.setInteger("AmmoAtm", 20);
			}
			is.setTagCompound(tag);
		}
	}

	@SideOnly(Side.CLIENT)
	public boolean onModeClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		if (isPress) {
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
