package mods.timaxa007.pack.weapon.items;

import java.util.List;

import mods.timaxa007.lib.Option;
import mods.timaxa007.pack.weapon.PackWeapon;
import mods.timaxa007.pack.weapon.lib.MagazineFor;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMagazines extends Item {

	@SideOnly(Side.CLIENT) private IIcon[] icon_tex;
	@SideOnly(Side.CLIENT) private IIcon[] icon_ovl;

	public ItemMagazines() {
		super();
		setMaxStackSize(1);
		setCreativeTab(PackWeapon.proxy.tab_weapons);
		setTextureName("timaxa007:item_magazines");
		setUnlocalizedName("item_magazines");
	}

	public String getUnlocalizedName(ItemStack is) {
		NBTTagCompound tag = is.getTagCompound();
		if (tag != null && tag.hasKey("MagazineID")) {
			return "magazine." + MagazineFor.magazine_list[tag.getInteger("MagazineID")].getName();
		}
		return super.getUnlocalizedName();
	}

	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
		NBTTagCompound tag = is.getTagCompound();
		if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
			if (tag != null) {

				if (tag.hasKey("MagazineID")) list.add("MagazineID: " + tag.getInteger("MagazineID") + ".");

			}
		} else {
			list.add(Option.prshift);
		}
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item id, CreativeTabs table, List list) {
		for (int i = 0; i < MagazineFor.magazine_list.length; i++) {
			if (MagazineFor.magazine_list[i] != null) {
				list.add(addTag(i));
			}
		}
		//list.add(new ItemStack(id, 1, 0));
	}

	private static ItemStack addTag(int par1) {
		ItemStack is = new ItemStack(PackWeapon.proxy.item_magazines, 1, 0);
		NBTTagCompound tag = new NBTTagCompound();
		tag.setInteger("MagazineID", par1);
		is.setTagCompound(tag);
		return is;
	}

	@SideOnly(Side.CLIENT)
	public boolean requiresMultipleRenderPasses() {
		return true;
	}

	public IIcon getIcon(ItemStack is, int pass) {
		NBTTagCompound tag = is.getTagCompound();
		if (tag != null && tag.hasKey("MagazineID")) {
			if (pass == 0) {
				return icon_tex[tag.getInteger("MagazineID")];
			} else {
				return icon_ovl[tag.getInteger("MagazineID")];
			}
		} else {
			return itemIcon;
		}
	}

	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack is, int pass) {
		NBTTagCompound tag = is.getTagCompound();
		if (tag != null && tag.hasKey("MagazineID")) {
			if (pass == 0) {
				return MagazineFor.magazine_list[tag.getInteger("MagazineID")].getColor1();
			} else {
				return MagazineFor.magazine_list[tag.getInteger("MagazineID")].getColor2();
			}
		} else {
			return 16777215;
		}
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister ir) {
		super.registerIcons(ir);
		itemIcon = ir.registerIcon("timaxa007:" + "magazines");
		icon_tex = new IIcon[MagazineFor.magazine_list.length];
		icon_ovl = new IIcon[MagazineFor.magazine_list.length];
		for (int i = 0; i < MagazineFor.magazine_list.length; i++) {
			/*if (MagazineFor.magazine_list[i] != null) {
				icon_tex[i] = ir.registerIcon("timaxa007:" + "magazines/" + MagazineFor.magazine_list[i].getTexture1Name());
				if (MagazineFor.magazine_list[i].getTexture2Name() == MagazineFor.magazine_list[i].getTexture1Name()) {
					icon_ovl[i] = ir.registerIcon("timaxa007:" + "empty");
				} else {
					icon_ovl[i] = ir.registerIcon("timaxa007:" + "magazines/" + MagazineFor.magazine_list[i].getTexture2Name());
				}
			} else {*/
				icon_tex[i] = itemIcon;
				icon_ovl[i] = itemIcon;
				//}
			}
		}

	}
