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
import timaxa007.gui.HandlerGui;
import timaxa007.module.control_button.api.IActionMouse;
import timaxa007.module.control_button.api.IActionPrimaryKey;
import timaxa007.module.control_button.api.IScope;
import timaxa007.module.control_button.api.IUpdateClient;
import timaxa007.pack.weapon.PackWeapon;
import timaxa007.pack.weapon.packet.MessageActionWeapons;
import timaxa007.pack.weapon.util.RegistryWeapons;
import timaxa007.pack.weapon.util.Weapon;
import timaxa007.smt.CoreSMT;
import timaxa007.smt.util.UtilString;
import timaxa007.pack.conjoint.object.ModifiedItem;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemWeapons extends ModifiedItem implements 
IActionMouse, IActionPrimaryKey, 
IScope, 
IUpdateClient
{
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT) public static boolean isLeftClick;
	@SideOnly(Side.CLIENT) public static boolean isRightClick;

	@SideOnly(Side.CLIENT) public static boolean isReload;
	@SideOnly(Side.CLIENT) public static boolean isCharge;
	@SideOnly(Side.CLIENT) public static boolean isMode;
	@SideOnly(Side.CLIENT) public static boolean isAction;
	@SideOnly(Side.CLIENT) public static boolean isModeIn;
	@SideOnly(Side.CLIENT) public static boolean isModeOut;

	@SideOnly(Side.CLIENT) public static int delay;

	@SideOnly(Side.CLIENT) private IIcon[] icon_tex;
	@SideOnly(Side.CLIENT) private IIcon[] icon_ovl;
	//--------------------------------------------------------------------------------------------------------------
	public ItemWeapons(String tag) {
		super(tag);
		setMaxStackSize(1);
		setMaxDamage(1024);
		setNoRepair();
		setCreativeTab(PackWeapon.tab_weapons);
		setTextureName("timaxa007:weapons");
	}
	//--------------------------------------------------------------------------------------------------------------
	@Override
	public void onUpdate(ItemStack is, World world, Entity entity, int par4, boolean par5) {
		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)entity;
			ItemStack current = player.getCurrentEquippedItem();
			NBTTagCompound nbt = is.getTagCompound();
			if (nbt != null) {
				//delayUpdate();
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public void updateClient(ItemStack is, World world, EntityPlayer player) {
		if (delay > 0) --delay;
		//else if (delay < 0) ++delay;
	}

	@SideOnly(Side.CLIENT)
	public void delayUpdate() {
		if (delay > 0) --delay;
	}
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onLeftClickTickClient(ItemStack is, World world, EntityPlayer player, int tick) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null && nbt.hasKey("Weapon") && nbt.hasKey("AmmoAtm")) {

			if (nbt.getInteger("AmmoAtm") > 0) {
				if (delay == 0) {
					//System.out.println("fire1 " + tick);
					delay = RegistryWeapons.RegistryWeapon.getWeapon(nbt.getString("Weapon")).getDelay();
					System.out.println(delay);
					PackWeapon.network.sendToServer(new MessageActionWeapons(1));
				}
			}

			is.setTagCompound(nbt);

		}
	}

	@SideOnly(Side.CLIENT)
	public void onLeftClickClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		isLeftClick = isPress;
	}

	public void fire(ItemStack is, World world, EntityPlayer player) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null && nbt.hasKey("Weapon") && nbt.hasKey("AmmoAtm")) {

			if (nbt.getInteger("AmmoAtm") > 0) {
				EntityArrow entityarrow = new EntityArrow(world, player, 5.0F);
				world.spawnEntityInWorld(entityarrow);
				nbt.setInteger("AmmoAtm", nbt.getInteger("AmmoAtm") - 1);

				playSound(is, world, player, "fire");
			}
			is.setTagCompound(nbt);
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onRightClickTickClient(ItemStack is, World world, EntityPlayer player, int tick) {
		/*
		if (isModeIn && !isModeOut)
			PackWeapon.network.sendToServer(new MessageActionWeapons(5, true));
		if (isModeOut && !isModeIn)
			PackWeapon.network.sendToServer(new MessageActionWeapons(6, true));
		 */
	}

	@SideOnly(Side.CLIENT)
	public void onRightClickClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		isRightClick = isPress;
		PackWeapon.network.sendToServer(new MessageActionWeapons((isPress ? 2 : -2)));
	}

	public void scope(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null && nbt.hasKey("Aim")) {
			nbt.setBoolean("Aim", isPress);
			is.setTagCompound(nbt);
		}
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
				PackWeapon.network.sendToServer(new MessageActionWeapons(3));
			}
		}
	}

	public void reload(ItemStack is, World world, EntityPlayer player) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null && nbt.hasKey("Weapon")) {
			Weapon weapon = RegistryWeapons.RegistryWeapon.getWeapon(nbt.getString("Weapon"));
			nbt.setInteger("AmmoAtm", weapon.getMaxAmountAmmo());
			playSound(is, world, player, "reload");
			is.setTagCompound(nbt);
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
		PackWeapon.network.sendToServer(new MessageActionWeapons(4));
	}

	public void mode(ItemStack is, World world, EntityPlayer player) {
		HandlerGui.openGui(HandlerGui.GuiID.MODIFY_WEAPON, player);
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
		if (tick > 10 && isRightClick && !isModeOut)
			if (tick % 4 == 0)
				PackWeapon.network.sendToServer(new MessageActionWeapons(5));
	}

	@SideOnly(Side.CLIENT)
	public void onModeInClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		isModeIn = isPress;
		if (isPress && isRightClick && !isModeOut)
			PackWeapon.network.sendToServer(new MessageActionWeapons(5));
	}

	public void zoomIn(ItemStack is, World world, EntityPlayer player) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null && nbt.hasKey("ZoomFov")) {
			int get_zoom = nbt.getByte("ZoomFov");
			if (get_zoom <= 112 && get_zoom >= 0)
				nbt.setByte("ZoomFov", (byte)(get_zoom + 8));
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onModeOutTickClient(ItemStack is, World world, EntityPlayer player, int tick) {
		if (tick > 10 && isRightClick && !isModeIn)
			if (tick % 4 == 0)
				PackWeapon.network.sendToServer(new MessageActionWeapons(6));
	}

	@SideOnly(Side.CLIENT)
	public void onModeOutClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		isModeOut = isPress;
		if (isPress && isRightClick && !isModeIn)
			PackWeapon.network.sendToServer(new MessageActionWeapons(6));
	}

	public void zoomOut(ItemStack is, World world, EntityPlayer player) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null && nbt.hasKey("ZoomFov")) {
			int get_zoom = nbt.getByte("ZoomFov");
			if (get_zoom <= 120 && get_zoom >= 8)
				nbt.setByte("ZoomFov", (byte)(get_zoom - 8));
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	public void playSound(ItemStack is, World world, EntityPlayer player, String type) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null && nbt.hasKey("Weapon")) {
			Weapon weapon = RegistryWeapons.RegistryWeapon.getWeapon(nbt.getString("Weapon"));
			//System.out.println(weapon);
			if (RegistryWeapons.RegistryWeapon.hasWeapon(weapon)) {

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
			return "weapon." + RegistryWeapons.RegistryWeapon.getWeapon(nbt.getString("Weapon")).getName();
		return super.getUnlocalizedName();
	}

	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
		NBTTagCompound nbt = is.getTagCompound();
		if (UtilString.isShiftKeyDown()) {
			if (nbt != null) {

				if (nbt.hasKey("Weapon")) {
					Weapon weapon = RegistryWeapons.RegistryWeapon.getWeapon(nbt.getString("Weapon"));
					list.add("Weapon: " + nbt.getString("Weapon") + "/" + weapon + ".");
					list.add("Weapon: " + weapon.getType() + "/" + weapon.getName() + ".");
				}

				if (nbt.hasKey("AmmoAtm")) {
					list.add("AmmoAtm: " + nbt.getInteger("AmmoAtm") + ".");
				}

				if (nbt.hasKey("ZoomFov") && CoreSMT.config.show_tip_info_testing) {
					list.add("ZoomFov: " + nbt.getByte("ZoomFov") + ".");
				}

			}
		} else list.add(UtilString.hldshiftinf);
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item id, CreativeTabs table, List list) {
		List lst = RegistryWeapons.RegistryWeapon.getTagWeapons();
		for (int i = 0; i < lst.size(); i++) {
			if (lst.get(i) != null)
				list.add(addNBT(lst.get(i).toString()));
		}
		//list.add(new ItemStack(id, 1, 0));
	}

	public static ItemStack addNBT(String par1) {
		ItemStack is = new ItemStack(PackWeapon.item.weapon, 1, 0);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setString("Weapon", par1);

		nbt.setBoolean("Aim", false);
		//nbt.setByte("ZoomFov", (byte)0);

		is.setTagCompound(nbt);
		return is;
	}

}
