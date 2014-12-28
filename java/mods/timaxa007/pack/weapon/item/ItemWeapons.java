package mods.timaxa007.pack.weapon.item;

import java.util.List;

import mods.timaxa007.lib.Option;
import mods.timaxa007.pack.weapon.PackWeapon;
import mods.timaxa007.pack.weapon.lib.WeaponFor;
import mods.timaxa007.tms.Core;
import mods.timaxa007.tms.util.ItemPrimary;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemWeapons extends ItemPrimary {

	@SideOnly(Side.CLIENT) private IIcon[] icon_tex;
	@SideOnly(Side.CLIENT) private IIcon[] icon_ovl;

	public ItemWeapons() {
		super();
		setMaxStackSize(1);
		setCreativeTab(PackWeapon.tab_weapons);
		setTextureName("timaxa007:weapons");
		setUnlocalizedName("weapons");
	}

	public void onUpdate(ItemStack is, World world, Entity entity, int par4, boolean par5) {
		if (entity instanceof EntityPlayer) {
			if (!(Minecraft.getMinecraft().currentScreen instanceof GuiScreen)) {//GuiContainer
			}
		}
	}

	@Override
	public void onLeftClick(ItemStack is, World world, EntityPlayer player) {
		NBTTagCompound tag = is.getTagCompound();
		if (tag.hasKey("WeaponID") && is.getTagCompound().hasKey("Shooted")) {
			/*int var1 = tag.getInteger("Shooted");
			int var2 = tag.getInteger("AmmoAtm");

			if (var1 > 20) {var1 = 0;}
			if (!Mouse.isButtonDown(0)) {var1 = 0;} else {var1++;}

			if (isFire(var1, 5) && var2 > 0) {
				if (!world.isRemote) {
					world.playSoundAtEntity(player, "timaxa007:ak74_shoot", 1.0F, 1.0F);
					//world.spawnEntityInWorld(new EntityBullet(world, (EntityPlayer)entity, 2.0F));
				} else {
					System.out.println("isFire - n: " + var1);
				}
				tag.setInteger("AmmoAtm", var2 - 1);
			}

			tag.setInteger("Shooted", var1);
			 */
			if (!world.isRemote) {
				if (tag.hasKey("AmmoAtm") && tag.getInteger("AmmoAtm") > 0) {
					world.playSoundAtEntity(player, "timaxa007:ak74_shoot", 1.0F, 1.0F);
					tag.setInteger("AmmoAtm", tag.getInteger("AmmoAtm") - 1);
					if (Core.show_tip_info_testing) System.out.println("fire");
				}
			}

			is.setTagCompound(tag);
		}

	}

	@Override
	public void onRightClick(ItemStack is, World world, EntityPlayer player) {
		NBTTagCompound tag = is.getTagCompound();
		if (!world.isRemote) {
			if (tag != null && tag.hasKey("Aim")) {
				tag.setBoolean("Aim", true);
				is.setTagCompound(tag);
				if (Core.show_tip_info_testing) System.out.println("onScope");
				//System.out.println("on-scope");
			}
		}
	}

	@Override
	public void offRightClick(ItemStack is, World world, EntityPlayer player) {
		NBTTagCompound tag = is.getTagCompound();
		if (!world.isRemote) {
			if (tag != null && tag.hasKey("Aim")) {
				tag.setBoolean("Aim", false);
				is.setTagCompound(tag);
				if (Core.show_tip_info_testing) System.out.println("offScope");
				//System.out.println("off-scope");
			}
		}
	}

	@Override
	public void onReload(ItemStack is, World world, EntityPlayer player) {
		NBTTagCompound tag = is.getTagCompound();
		if (WeaponFor.list[tag.getInteger("WeaponID")] != null) {
			if (!world.isRemote) {

			} else {
				System.out.println("-reload-");
			}

			//tag.setInteger("AmmoAtm", MagazineFor.magazine_list[tag.getInteger("MagazineID")].getSize());
			tag.setInteger("AmmoAtm", 20);
			is.setTagCompound(tag);
		}
	}

	@Override
	public void onCharge(ItemStack is, World world, EntityPlayer player) {
		if (!world.isRemote) {
			player.openGui(PackWeapon.instance, 1, world, (int)player.posX, (int)player.posY, (int)player.posZ);
			System.out.println("-modify-");
		}
	}

	@Override
	public void onMode(ItemStack is, World world, EntityPlayer player) {
		if (Core.show_tip_info_testing) System.out.println("onMode");
	}

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

	public int getMaxItemUseDuration(ItemStack is) {return 72000;}

	public EnumAction getItemUseAction(ItemStack is) {return EnumAction.none;}

	public String getUnlocalizedName(ItemStack is) {
		NBTTagCompound tag = is.getTagCompound();
		if (tag != null && tag.hasKey("WeaponID")) {
			return "weapon." + WeaponFor.list[tag.getInteger("WeaponID")].getName();
		}
		return super.getUnlocalizedName();
	}

	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
		NBTTagCompound tag = is.getTagCompound();
		if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
			if (tag != null) {

				if (tag.hasKey("WeaponID")) {
					list.add("WeaponID: " + tag.getInteger("WeaponID") + "/" + 
							WeaponFor.list[tag.getInteger("WeaponID")].getName() + ".");
				}

			}
		} else {
			list.add(Option.prshift);
		}
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item id, CreativeTabs table, List list) {
		for (int i = 0; i < WeaponFor.list.length; i++) {
			if (WeaponFor.list[i] != null) {
				list.add(addTag(i));
			}
		}
		//list.add(new ItemStack(id, 1, 0));
	}

	private static ItemStack addTag(int par1) {
		ItemStack is = new ItemStack(PackWeapon.proxy.item.weapons, 1, 0);
		NBTTagCompound tag = new NBTTagCompound();
		tag.setInteger("WeaponID", par1);
		tag.setBoolean("Aim", false);
		tag.setInteger("Shooted", 0);

		if (WeaponFor.list[par1].getMagazine() != null) {
			tag.setInteger("MagazineID", WeaponFor.list[par1].getMagazine().id);
			tag.setInteger("AmmoAtm", WeaponFor.list[par1].getMagazine().getSize());
		} 
		if (WeaponFor.list[par1].getAmmo() != null) {
			tag.setInteger("AmmoID", WeaponFor.list[par1].getAmmo().id);
			tag.setInteger("AmmoAtm", WeaponFor.list[par1].getSizeAmmo());
		}

		//tag.setInteger("AmmoID", WeaponFor.list[par1].getAmmo().ammoID);
		/*if (WeaponFor.list[par1].getMagazine() != null) {
			tag.setInteger("MagazineID", WeaponFor.list[par1].getMagazine().magazineID);
		}*/
		//tag.setInteger("MagazineID", par2);
		is.setTagCompound(tag);
		return is;
	}

	@SideOnly(Side.CLIENT)
	public boolean requiresMultipleRenderPasses() {return true;}

	public IIcon getIcon(ItemStack is, int pass) {
		NBTTagCompound tag = is.getTagCompound();
		if (tag != null && tag.hasKey("WeaponID")) {
			if (pass == 0) {
				return icon_tex[tag.getInteger("WeaponID")];
			} else {
				return icon_ovl[tag.getInteger("WeaponID")];
			}
		} else {
			return itemIcon;
		}
	}

	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack is, int pass) {
		NBTTagCompound tag = is.getTagCompound();
		if (tag != null && tag.hasKey("WeaponID")) {
			if (pass == 0) {
				return WeaponFor.list[tag.getInteger("WeaponID")].getColor1();
			} else {
				return WeaponFor.list[tag.getInteger("WeaponID")].getColor2();
			}
		} else {
			return 16777215;
		}
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister ir) {
		super.registerIcons(ir);
		itemIcon = ir.registerIcon("timaxa007:" + "weapons");
		icon_tex = new IIcon[WeaponFor.list.length];
		icon_ovl = new IIcon[WeaponFor.list.length];
		for (int i = 0; i < WeaponFor.list.length; i++) {
			/*if (WeaponFor.list[i] != null) {
				icon_tex[i] = ir.registerIcon("timaxa007:" + "weapons/" + WeaponFor.list[i].getTexture1Name());
				if (WeaponFor.list[i].getTexture2Name() == WeaponFor.list[i].getTexture1Name()) {
					icon_ovl[i] = ir.registerIcon("timaxa007:" + "empty");
				} else {
					icon_ovl[i] = ir.registerIcon("timaxa007:" + "weapons/" + WeaponFor.list[i].getTexture2Name());
				}
			} else {*/
			icon_tex[i] = itemIcon;
			icon_ovl[i] = itemIcon;
			//}
		}
	}

}
