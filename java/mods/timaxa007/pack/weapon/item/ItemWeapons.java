package mods.timaxa007.pack.weapon.item;

import java.util.List;

import mods.timaxa007.pack.weapon.PackWeapons;
import mods.timaxa007.pack.weapon.lib.WeaponFor;
import mods.timaxa007.pack.weapon.packet.MessageActionWeapons;
import mods.timaxa007.tms.Core;
import mods.timaxa007.tms.util.IScope;
import mods.timaxa007.tms.util.ItemPrimaryKey;
import mods.timaxa007.tms.util.UtilString;
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
				NBTTagCompound nbt = is.getTagCompound();
				if (nbt != null) {
					//---------------------------------------------------------------
					if (nbt.hasKey("Weapon") && nbt.hasKey("AmmoAtm")) {

						int rbt/* = 0*/;
						if (nbt.hasKey("RBT")) {
							rbt = (int)nbt.getByte("RBT"); 
						} else {
							nbt.setByte("RBT", (byte)0);
							rbt = 0;
						}

						if (rbt > 0) --rbt;

						if (isLeftClick) {
							if (nbt.getInteger("AmmoAtm") > 0) {
								if (rbt == 0) {
									if (!world.isRemote) {
										PackWeapons.network.sendToServer(new MessageActionWeapons(1));
									}
									rbt = WeaponFor.get(nbt.getString("Weapon")).getDelay();
								}
							}
						}
						nbt.setByte("RBT", (byte)rbt);
					} else {
						//if (nbt.hasKey("RTM")) nbt.setByte("RTM", (byte)0);
					}
					//-----------------------------------------------------------------------------------------------
					if (isRightClick && isModeIn && !isModeOut) {
						if (nbt.hasKey("ZoomFov")) {
							int get_zoom = nbt.getByte("ZoomFov");
							if (get_zoom < 119) {
								nbt.setByte("ZoomFov", (byte)(get_zoom + 8));
							}
						}
					}
					//---------------------------------------------------------------
					if (isRightClick && isModeOut && !isModeIn) {
						if (nbt.hasKey("ZoomFov")) {
							int get_zoom = nbt.getByte("ZoomFov");
							if (get_zoom > -119) {
								nbt.setByte("ZoomFov", (byte)(get_zoom - 8));
							}
						}
					}
					//---------------------------------------------------------------
					is.setTagCompound(nbt);
				}
			}
		}
	}

	public void onFire(ItemStack is, World world, EntityPlayer player) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null) {
			if (nbt.hasKey("Weapon") && nbt.hasKey("AmmoAtm")) {
				//world.playSoundAtEntity(player, WeaponFor.get(nbt.getString("Weapon")).getSoundFire()[0], 1.0F, 1.0F);
				EntityArrow entityarrow = new EntityArrow(world, player, 5.0F);
				world.spawnEntityInWorld(entityarrow);
				nbt.setInteger("AmmoAtm", nbt.getInteger("AmmoAtm") - 1);
				if (Core.show_system_info_testing) System.out.println("fire");
			}
		}
	}

	@Override
	public void onLeftClick(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		//if (nbt.hasKey("Weapon") && nbt.hasKey("AmmoAtm")) {
		//if (!isPress) nbt.removeTag("RTM");

		/*
			if (!world.isRemote && isPress) {
				if (nbt.getInteger("AmmoAtm") > 0) {
					world.playSoundAtEntity(player, "timaxa007:ak74_shoot", 1.0F, 1.0F);
					nbt.setInteger("AmmoAtm", nbt.getInteger("AmmoAtm") - 1);
					if (Core.show_system_info_testing) System.out.println("fire");
				}
			}
		 */
		//is.setTagCompound(nbt);
		//}
	}

	@SideOnly(Side.CLIENT)
	public boolean onRightClickClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null && nbt.hasKey("Aim")) {
			return true;
		}
		return super.onRightClickClient(is, world, player, isPress);
	}

	@Override
	public void onRightClick(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null && nbt.hasKey("Aim")) {
			nbt.setBoolean("Aim", isPress);
			is.setTagCompound(nbt);
			if (Core.show_system_info_testing) System.out.println(isPress ? "onScope" : "offScope");
		}
	}

	@SideOnly(Side.CLIENT)
	public boolean onReloadClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null && nbt.hasKey("Weapon")) {
			return true;
		}
		return super.onReloadClient(is, world, player, isPress);
	}

	@Override
	public void onReload(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null && nbt.hasKey("Weapon")) {
			if (isPress) {
				if (!world.isRemote) {
					//world.playSoundAtEntity(player, WeaponFor.get(nbt.getString("Weapon")).getSoundReload()[0], 1.0F, 1.0F);
				} else {
					if (Core.show_system_info_testing) System.out.println("-reload-");
				}
				//nbt.setInteger("AmmoAtm", WeaponFor.get(nbt.getString("Weapon")).getSizeAmmo());
				nbt.setInteger("AmmoAtm", 20);
			}
			is.setTagCompound(nbt);
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
		NBTTagCompound nbt = is.getTagCompound();
		if (isPress) {
			if (nbt.hasKey("ZoomFov")) {
				int get_zoom = nbt.getByte("ZoomFov");
				if (get_zoom < 127) {
					nbt.setByte("ZoomFov", (byte)(get_zoom + 1));
					is.setTagCompound(nbt);
				}
			}
		}
	}

	@Override
	public void onZoomOut(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		NBTTagCompound nbt = is.getTagCompound();
		if (isPress) {
			if (nbt.hasKey("ZoomFov")) {
				int get_zoom = nbt.getByte("ZoomFov");
				if (get_zoom > -127) {
					nbt.setByte("ZoomFov", (byte)(get_zoom - 1));
					is.setTagCompound(nbt);
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
		NBTTagCompound nbt = is.getTagCompound();
		if (!world.isRemote) {
			if (nbt != null && nbt.hasKey("Aim")) {
				nbt.setBoolean("Aim", false);
				is.setTagCompound(nbt);
				System.out.println("off-scope");
			}
		}
	}

	public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer player) {
		NBTTagCompound nbt = is.getTagCompound();
		//if (player.capabilities.isCreativeMode || player.inventory.hasItem(Item.arrow.getItem())) {
		player.setItemInUse(is, getMaxItemUseDuration(is));
		//}
		if (!world.isRemote) {
			if (nbt != null && nbt.hasKey("Aim")) {
				nbt.setBoolean("Aim", true);
				is.setTagCompound(nbt);
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
