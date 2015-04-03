package timaxa007.pack.stock.item;

import java.util.List;

import timaxa007.pack.stock.PackStock;
import timaxa007.pack.stock.lib.ItemForStock;
import timaxa007.tms.util.ModifiedItem;
import timaxa007.tms.util.UtilString;
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
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemsStock extends ModifiedItem {

	@SideOnly(Side.CLIENT) private IIcon[] icon_tex;
	@SideOnly(Side.CLIENT) private IIcon[] icon_ovl;

	public ItemsStock(String tag) {
		super(tag);
		setCreativeTab(PackStock.tab_stock);
		setTextureName("timaxa007:");
		setTextureName("timaxa007:icon/stock");
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
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null && nbt.hasKey("NameID")) {
			return super.getUnlocalizedName() + "." + ItemForStock.list[ItemForStock.getID_tag(nbt.getString("NameID"))].getName();
		} else if (nbt != null && nbt.hasKey("ItemID")) {
			return super.getUnlocalizedName() + "." + ItemForStock.list[nbt.getInteger("ItemID")].getName();
		}
		return super.getUnlocalizedName();
	}

	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
		NBTTagCompound nbt = is.getTagCompound();
		if (UtilString.isShiftKeyDown()) {
			if (nbt != null) {
				//-------------------------------------------------------------------------------------
				if (nbt.hasKey("NameID")) {
					if (ItemForStock.list[ItemForStock.getID_tag(nbt.getString("NameID"))] != null) {
						list.add("NameID: " + nbt.getString("NameID") + " / [-] ID: " + ItemForStock.getID_tag(nbt.getString("NameID")) + ".");
						if (ItemForStock.list[ItemForStock.getID_tag(nbt.getString("NameID"))].getType() != "none") {
							list.add(UtilString.getText("Type") + ": " + ItemForStock.list[ItemForStock.getID_tag(nbt.getString("NameID"))].getLocalizedType() + ".");
						}
					} else {
						list.add("Bag Item is in NameID: " + nbt.getString("NameID") + ".");
					}
				}
				//-------------------------------------------------------------------------------------
				if (nbt.hasKey("ItemID")) {
					if (ItemForStock.list[nbt.getInteger("ItemID")] != null) {
						if (ItemForStock.list[nbt.getInteger("ItemID")].tag != null) {
							list.add("NameID: " + ItemForStock.list[nbt.getInteger("ItemID")].tag + " [-] / ID: " + nbt.getInteger("ItemID") + ".");
						}
						if (ItemForStock.list[nbt.getInteger("ItemID")].getType() != "none") {
							list.add(UtilString.getText("Type") + ": " + ItemForStock.list[nbt.getInteger("ItemID")].getLocalizedType() + ".");
						}
					} else {
						list.add("Bag Item is in ItemID: " + nbt.getInteger("ItemID") + ".");
					}
				}
				//-------------------------------------------------------------------------------------
			}
		} else {
			list.add(UtilString.hldshiftinf);
		}
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item id, CreativeTabs table, List list) {
		for (int i = 1; i < ItemForStock.list.length; i++) {
			if (ItemForStock.list[i] != null && ItemForStock.list[i].tag != "") {
				list.add(addNBT(ItemForStock.list[i].tag));
			} else if (ItemForStock.list[i] != null && ItemForStock.list[i].tag == "") {
				list.add(addNBT(i));
			}
		}
		//list.add(new ItemStack(id, 1, 0));
	}

	public static ItemStack addNBT(String par1) {
		ItemStack is = new ItemStack(PackStock.item.items_for_stock, 1, 0);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setString("NameID", par1);
		is.setTagCompound(nbt);
		return is;
	}

	public static ItemStack addNBT(int par1) {
		ItemStack is = new ItemStack(PackStock.item.items_for_stock, 1, 0);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setInteger("ItemID", par1);
		is.setTagCompound(nbt);
		return is;
	}

	@SideOnly(Side.CLIENT)
	public boolean requiresMultipleRenderPasses() {return true;}

	public IIcon getIcon(ItemStack is, int pass) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null && nbt.hasKey("NameID")) {
			if (pass == 0) {
				return icon_tex[ItemForStock.getID_tag(nbt.getString("NameID"))];
			} else {
				return icon_ovl[ItemForStock.getID_tag(nbt.getString("NameID"))];
			}
		} else if (nbt != null && nbt.hasKey("ItemID")) {
			if (pass == 0) {
				return icon_tex[nbt.getInteger("ItemID")];
			} else {
				return icon_ovl[nbt.getInteger("ItemID")];
			}
		} else {
			return itemIcon;
		}
	}

	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack is, int pass) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null && nbt.hasKey("NameID")) {
			if (pass == 0) {
				return ItemForStock.list[ItemForStock.getID_tag(nbt.getString("NameID"))].getColor1();
			} else {
				return ItemForStock.list[ItemForStock.getID_tag(nbt.getString("NameID"))].getColor2();
			}
		} else if (nbt != null && nbt.hasKey("ItemID")) {
			if (pass == 0) {
				return ItemForStock.list[nbt.getInteger("ItemID")].getColor1();
			} else {
				return ItemForStock.list[nbt.getInteger("ItemID")].getColor2();
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
