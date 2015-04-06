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
import timaxa007.module.control_button.api.IActionMouse;
import timaxa007.module.control_button.api.IActionPrimaryKey;
import timaxa007.module.control_button.api.IScope;
import timaxa007.pack.NodePack;
import timaxa007.pack.weapon.PackWeapons;
import timaxa007.pack.weapon.lib.WeaponFor;
import timaxa007.pack.weapon.packet.MessageActionWeapons;
import timaxa007.tms.CoreTMS;
import timaxa007.tms.util.ModifiedItem;
import timaxa007.tms.util.UtilString;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemWeapons extends ModifiedItem implements IActionMouse, IActionPrimaryKey, IScope {

	@SideOnly(Side.CLIENT) public static boolean isLeftClick;
	@SideOnly(Side.CLIENT) public static boolean isRightClick;

	@SideOnly(Side.CLIENT) public static boolean isReload;
	@SideOnly(Side.CLIENT) public static boolean isCharge;
	@SideOnly(Side.CLIENT) public static boolean isMode;
	@SideOnly(Side.CLIENT) public static boolean isAction;
	@SideOnly(Side.CLIENT) public static boolean isModeIn;
	@SideOnly(Side.CLIENT) public static boolean isModeOut;

	@SideOnly(Side.CLIENT) public static int dellay;

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
						dellayUpdate();
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
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onLeftClickTickClient(ItemStack is, World world, EntityPlayer player, int tick) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null && nbt.hasKey("Weapon") && nbt.hasKey("AmmoAtm") && nbt.hasKey("Delay")) {
			int delay = (int)nbt.getByte("Delay");

			if (nbt.getInteger("AmmoAtm") > 0) {
				if (delay == 0 && dellay == 0) {
					//System.out.println("fire1 " + tick);
					dellay = WeaponFor.get(nbt.getString("Weapon")).getDelay();
					PackWeapons.network.sendToServer(new MessageActionWeapons(1));
				}
			}

			is.setTagCompound(nbt);

		}
	}

	@SideOnly(Side.CLIENT)
	public void onLeftClickClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		isLeftClick = isPress;
	}
	//--------------------------------------------------------------------------------------------------------------
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
		isRightClick = isPress;
		PackWeapons.network.sendToServer(new MessageActionWeapons((isPress ? 2 : -2)));
	}
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onReloadTickClient(ItemStack is, World world, EntityPlayer player, int tick) {

	}

	@SideOnly(Side.CLIENT)
	public void onReloadClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		isReload = isPress;
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null && nbt.hasKey("Weapon")) {
			if (isPress) {
				PackWeapons.network.sendToServer(new MessageActionWeapons(3));
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onChargeTickClient(ItemStack is, World world, EntityPlayer player, int tick) {

	}

	@SideOnly(Side.CLIENT)
	public void onChargeClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		isCharge = isPress;
	}
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onModeTickClient(ItemStack is, World world, EntityPlayer player, int tick) {

	}

	@SideOnly(Side.CLIENT)
	public void onModeClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		isMode = isPress;
		PackWeapons.network.sendToServer(new MessageActionWeapons(4));
	}
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onActionTickClient(ItemStack is, World world, EntityPlayer player, int tick) {

	}

	@SideOnly(Side.CLIENT)
	public void onActionClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		isAction = isPress;
	}
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onModeInTickClient(ItemStack is, World world, EntityPlayer player, int tick) {

	}

	@SideOnly(Side.CLIENT)
	public void onModeInClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		isModeIn = isPress;
		if (isPress && isRightClick && !isModeOut)
			PackWeapons.network.sendToServer(new MessageActionWeapons(5));
	}
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onModeOutTickClient(ItemStack is, World world, EntityPlayer player, int tick) {

	}

	@SideOnly(Side.CLIENT)
	public void onModeOutClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		isModeOut = isPress;
		if (isPress && isRightClick && !isModeIn)
			PackWeapons.network.sendToServer(new MessageActionWeapons(6));
	}
	//--------------------------------------------------------------------------------------------------------------
	public void fire(ItemStack is, World world, EntityPlayer player) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null && nbt.hasKey("Weapon") && nbt.hasKey("AmmoAtm") && nbt.hasKey("Delay")) {

			EntityArrow entityarrow = new EntityArrow(world, player, 5.0F);
			world.spawnEntityInWorld(entityarrow);
			nbt.setInteger("AmmoAtm", nbt.getInteger("AmmoAtm") - 1);

			playSound(is, world, player, "fire");

			int delay = (int)nbt.getByte("Delay");

			if (delay == 0) {
				delay = WeaponFor.get(nbt.getString("Weapon")).getDelay();
				nbt.setByte("Delay", (byte)delay);
			}

			is.setTagCompound(nbt);
		}
	}

	@SideOnly(Side.CLIENT)
	public void dellayUpdate() {
		if (dellay > 0) --dellay;
	}

	public void scope(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null && nbt.hasKey("Aim")) {
			nbt.setBoolean("Aim", isPress);
			is.setTagCompound(nbt);
		}
	}

	public void reload(ItemStack is, World world, EntityPlayer player) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null && nbt.hasKey("Weapon")) {
			//nbt.setInteger("AmmoAtm", WeaponFor.get(nbt.getString("Weapon")).getSizeAmmo());
			nbt.setInteger("AmmoAtm", 20);
			playSound(is, world, player, "reload");
			is.setTagCompound(nbt);
		}
	}

	public void mode(ItemStack is, World world, EntityPlayer player) {
		player.openGui(NodePack.instance, PackWeapons.gui_modify, world, (int)player.posX, (int)player.posY, (int)player.posZ);
	}

	public void zoomIn(ItemStack is, World world, EntityPlayer player) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null && nbt.hasKey("ZoomFov")) {
			int get_zoom = nbt.getByte("ZoomFov");
			if (get_zoom <= 112 && get_zoom >= 0)
				nbt.setByte("ZoomFov", (byte)(get_zoom + 8));
		}
	}

	public void zoomOut(ItemStack is, World world, EntityPlayer player) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null && nbt.hasKey("ZoomFov")) {
			int get_zoom = nbt.getByte("ZoomFov");
			if (get_zoom <= 120 && get_zoom >= 8)
				nbt.setByte("ZoomFov", (byte)(get_zoom - 8));
		}
	}

	public void playSound(ItemStack is, World world, EntityPlayer player, String type) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null && nbt.hasKey("Weapon")) {
			WeaponFor weapon = WeaponFor.get(nbt.getString("Weapon"));
			//System.out.println(weapon);
			if (!WeaponFor.isNull(weapon)) {

				String sound = null;
				if (type == "fire") sound = weapon.getSoundFire()[0];
				else if (type == "reload") sound = weapon.getSoundReload()[0];

				if (UtilString.hasString(sound))
					world.playSoundAtEntity(player, sound, 1.0F, 1.0F);

				//System.out.println(sound);
			}
		}
	}

	public boolean onEntitySwing(EntityLivingBase entity, ItemStack is) {return true;}
	public boolean onLeftClickEntity(ItemStack is, EntityPlayer player, Entity entity) {return true;}
	public int getMaxItemUseDuration(ItemStack is) {return 72000;}
	public EnumAction getItemUseAction(ItemStack is) {return EnumAction.none;}

	public String getUnlocalizedName(ItemStack is) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null && nbt.hasKey("Weapon"))
			return "weapon." + WeaponFor.get(nbt.getString("Weapon")).getName();
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

				if (nbt.hasKey("ZoomFov") && CoreTMS.show_tip_info_testing) {
					list.add("ZoomFov:  " + nbt.getByte("ZoomFov") + ".");
				}

				if (nbt.hasKey("Delay") && CoreTMS.show_tip_info_testing) {
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
		ItemStack is = new ItemStack(PackWeapons.item.weapons, 1, 0);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setString("Weapon", par1);

		nbt.setBoolean("Aim", false);
		nbt.setByte("ZoomFov", (byte)0);

		is.setTagCompound(nbt);
		return is;
	}

}
