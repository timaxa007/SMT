package mods.timaxa007.pack.weapon.item;

import java.util.List;

import mods.timaxa007.lib.Option;
import mods.timaxa007.pack.weapon.PackWeapons;
import mods.timaxa007.pack.weapon.lib.AmmoFor;
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

public class ItemAmmos extends Item {

	@SideOnly(Side.CLIENT) private IIcon[] icon_tex;
	@SideOnly(Side.CLIENT) private IIcon[] icon_ovl;

	public ItemAmmos() {
		super();
		setMaxStackSize(1);
		setCreativeTab(PackWeapons.tab_weapons);
		setTextureName("timaxa007:item_ammos");
		setUnlocalizedName("item_ammos");
	}

	public String getUnlocalizedName(ItemStack is) {
		NBTTagCompound tag = is.getTagCompound();
		if (tag != null && tag.hasKey("AmmoID")) {
			return "ammo." + AmmoFor.list[tag.getInteger("AmmoID")].getName();
		}
		return super.getUnlocalizedName();
	}

	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
		NBTTagCompound tag = is.getTagCompound();
		if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
			if (tag != null) {

				if (tag.hasKey("AmmoID")) list.add("AmmoID: " + tag.getInteger("AmmoID") + ".");

			}
		} else {
			list.add(Option.prshift);
		}
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item id, CreativeTabs table, List list) {
		for (int i = 0; i < AmmoFor.list.length; i++) {
			if (AmmoFor.list[i] != null) {
				list.add(addTag(i));
			}
		}
		//list.add(new ItemStack(id, 1, 0));
	}

	private static ItemStack addTag(int par1) {
		ItemStack is = new ItemStack(PackWeapons.proxy.item.ammos, 1, 0);
		NBTTagCompound tag = new NBTTagCompound();
		tag.setInteger("AmmoID", par1);
		is.setTagCompound(tag);
		return is;
	}

	@SideOnly(Side.CLIENT)
	public boolean requiresMultipleRenderPasses() {
		return true;
	}

	public IIcon getIcon(ItemStack is, int pass) {
		NBTTagCompound tag = is.getTagCompound();
		if (tag != null && tag.hasKey("AmmoID")) {
			if (pass == 0) {
				return icon_tex[tag.getInteger("AmmoID")];
			} else {
				return icon_ovl[tag.getInteger("AmmoID")];
			}
		} else {
			return itemIcon;
		}
	}

	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack is, int pass) {
		NBTTagCompound tag = is.getTagCompound();
		if (tag != null && tag.hasKey("AmmoID")) {
			if (pass == 0) {
				return AmmoFor.list[tag.getInteger("AmmoID")].getColor1();
			} else {
				return AmmoFor.list[tag.getInteger("AmmoID")].getColor2();
			}
		} else {
			return 16777215;
		}
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister ir) {
		super.registerIcons(ir);
		itemIcon = ir.registerIcon("timaxa007:" + "ammos");
		icon_tex = new IIcon[AmmoFor.list.length];
		icon_ovl = new IIcon[AmmoFor.list.length];
		for (int i = 0; i < AmmoFor.list.length; i++) {
			/*if (AmmoFor.list[i] != null) {
				icon_tex[i] = ir.registerIcon("timaxa007:" + "ammos/" + AmmoFor.list[i].getTexture1Name());
				if (AmmoFor.list[i].getTexture2Name() == AmmoFor.list[i].getTexture1Name()) {
					icon_ovl[i] = ir.registerIcon("timaxa007:" + "empty");
				} else {
					icon_ovl[i] = ir.registerIcon("timaxa007:" + "ammos/" + AmmoFor.list[i].getTexture2Name());
				}
			} else {*/
			icon_tex[i] = itemIcon;
			icon_ovl[i] = itemIcon;
			//}
		}
	}

}
