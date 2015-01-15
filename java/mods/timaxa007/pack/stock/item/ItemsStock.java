package mods.timaxa007.pack.stock.item;

import java.util.List;

import mods.timaxa007.lib.Option;
import mods.timaxa007.pack.stock.PackStock;
import mods.timaxa007.pack.stock.lib.ItemForStock;
import mods.timaxa007.tms.util.ItemFixReg;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemsStock extends ItemFixReg {

	@SideOnly(Side.CLIENT) private IIcon[] icon_tex;
	@SideOnly(Side.CLIENT) private IIcon[] icon_ovl;

	public ItemsStock(String tag) {
		super(tag);
		setCreativeTab(PackStock.tab_stock);
		setTextureName("timaxa007:");
	}

	public void onUpdate(ItemStack is, World world, Entity entity, int par4, boolean flag) {
		if (!world.isRemote) {
			if (entity instanceof EntityLivingBase) {
				if (((EntityLivingBase)entity).getActivePotionEffect(Potion.regeneration) != null) {
					//((EntityLivingBase)entity).removePotionEffect(Potion.regeneration.id);
				} else {
					//((EntityLivingBase)entity).addPotionEffect(new PotionEffect(Potion.regeneration.id, 10, 3));
				}
			}
		}
	}

	public String getUnlocalizedName(ItemStack is) {
		NBTTagCompound tag = is.getTagCompound();
		if (tag != null && tag.hasKey("NameID")) {
			return super.getUnlocalizedName() + "." + ItemForStock.list[ItemForStock.getID_tag(tag.getString("NameID"))].getName();
		} else if (tag != null && tag.hasKey("ItemID")) {
			return super.getUnlocalizedName() + "." + ItemForStock.list[tag.getInteger("ItemID")].getName();
		}
		return super.getUnlocalizedName();
	}

	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
		NBTTagCompound tag = is.getTagCompound();
		if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
			if (tag != null) {
				//-------------------------------------------------------------------------------------
				if (tag.hasKey("NameID")) {
					if (ItemForStock.list[ItemForStock.getID_tag(tag.getString("NameID"))] != null) {
						list.add("NameID: " + tag.getString("NameID") + " / [-] ID: " + ItemForStock.getID_tag(tag.getString("NameID")) + ".");
						if (ItemForStock.list[ItemForStock.getID_tag(tag.getString("NameID"))].getType() != "none") {
							list.add(Option.getText("Type") + ": " + ItemForStock.list[ItemForStock.getID_tag(tag.getString("NameID"))].getLocalizedType() + ".");
						}
					} else {
						list.add("Bag Item is in NameID: " + tag.getString("NameID") + ".");
					}
				}
				//-------------------------------------------------------------------------------------
				if (tag.hasKey("ItemID")) {
					if (ItemForStock.list[tag.getInteger("ItemID")] != null) {
						if (ItemForStock.list[tag.getInteger("ItemID")].tag != null) {
							list.add("NameID: " + ItemForStock.list[tag.getInteger("ItemID")].tag + " [-] / ID: " + tag.getInteger("ItemID") + ".");
						}
						if (ItemForStock.list[tag.getInteger("ItemID")].getType() != "none") {
							list.add(Option.getText("Type") + ": " + ItemForStock.list[tag.getInteger("ItemID")].getLocalizedType() + ".");
						}
					} else {
						list.add("Bag Item is in ItemID: " + tag.getInteger("ItemID") + ".");
					}
				}
				//-------------------------------------------------------------------------------------
			}
		} else {
			list.add(Option.prshift);
		}
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item id, CreativeTabs table, List list) {
		for (int i = 1; i < ItemForStock.list.length; i++) {
			if (ItemForStock.list[i] != null && ItemForStock.list[i].tag != "") {
				list.add(addTag(ItemForStock.list[i].tag));
			} else if (ItemForStock.list[i] != null && ItemForStock.list[i].tag == "") {
				list.add(addTag(i));
			}
		}
		//list.add(new ItemStack(id, 1, 0));
	}

	private static ItemStack addTag(String par1) {
		ItemStack is = new ItemStack(PackStock.proxy.item.items_for_stock, 1, 0);
		NBTTagCompound tag = new NBTTagCompound();
		tag.setString("NameID", par1);
		is.setTagCompound(tag);
		return is;
	}

	private static ItemStack addTag(int par1) {
		ItemStack is = new ItemStack(PackStock.proxy.item.items_for_stock, 1, 0);
		NBTTagCompound tag = new NBTTagCompound();
		tag.setInteger("ItemID", par1);
		is.setTagCompound(tag);
		return is;
	}

	@SideOnly(Side.CLIENT)
	public boolean requiresMultipleRenderPasses() {return true;}

	public IIcon getIcon(ItemStack is, int pass) {
		NBTTagCompound tag = is.getTagCompound();
		if (tag != null && tag.hasKey("NameID")) {
			if (pass == 0) {
				return icon_tex[ItemForStock.getID_tag(tag.getString("NameID"))];
			} else {
				return icon_ovl[ItemForStock.getID_tag(tag.getString("NameID"))];
			}
		} else if (tag != null && tag.hasKey("ItemID")) {
			if (pass == 0) {
				return icon_tex[tag.getInteger("ItemID")];
			} else {
				return icon_ovl[tag.getInteger("ItemID")];
			}
		} else {
			return itemIcon;
		}
	}

	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack is, int pass) {
		NBTTagCompound tag = is.getTagCompound();
		if (tag != null && tag.hasKey("NameID")) {
			if (pass == 0) {
				return ItemForStock.list[ItemForStock.getID_tag(tag.getString("NameID"))].getColor1();
			} else {
				return ItemForStock.list[ItemForStock.getID_tag(tag.getString("NameID"))].getColor2();
			}
		} else if (tag != null && tag.hasKey("ItemID")) {
			if (pass == 0) {
				return ItemForStock.list[tag.getInteger("ItemID")].getColor1();
			} else {
				return ItemForStock.list[tag.getInteger("ItemID")].getColor2();
			}
		} else {
			return 16777215;
		}
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister ir) {
		super.registerIcons(ir);
		itemIcon = ir.registerIcon(getIconString() + "testItem");
		icon_tex = new IIcon[ItemForStock.list.length];
		icon_ovl = new IIcon[ItemForStock.list.length];
		for (int i = 0; i < ItemForStock.list.length; i++) {
			if (ItemForStock.list[i] != null) {
				icon_tex[i] = ir.registerIcon(getIconString() + ItemForStock.list[i].getTexture1());
				if (ItemForStock.list[i].getTexture2() == ItemForStock.list[i].getTexture1()) {
					icon_ovl[i] = ir.registerIcon(getIconString() + "empty");
				} else {
					icon_ovl[i] = ir.registerIcon(getIconString() + ItemForStock.list[i].getTexture2());
				}
			} else {
				icon_tex[i] = itemIcon;
				icon_ovl[i] = itemIcon;
			}
		}
	}

}
