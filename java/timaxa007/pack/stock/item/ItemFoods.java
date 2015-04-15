package timaxa007.pack.stock.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import timaxa007.pack.stock.PackStock;
import timaxa007.pack.stock.lib.FoodForItem;
import timaxa007.tms.CoreTMS;
import timaxa007.tms.util.ModifiedItem;
import timaxa007.tms.util.UtilString;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemFoods extends ModifiedItem {
	/*
	@SideOnly(Side.CLIENT) private IIcon[] icon_tex;
	@SideOnly(Side.CLIENT) private IIcon[] icon_ovl;
	 */
	@SideOnly(Side.CLIENT) private IIcon[][] icon_food;

	public ItemFoods(String tag) {
		super(tag);
		setCreativeTab(PackStock.tab_food);
		setHasSubtypes(true);
		setMaxDamage(0);
		//setTextureName("timaxa007:");
	}
	/*
public enum foods {
Cocoa_powder(1, 0.3F, null, "cocoa_powder", true, 0xE79042, 0xFF0000), 
Flour_wheat(1, 0.1F, new int[][] {{Potion.confusion.id, 20 * 5, 0}}, "flour", false, 0xDDDDDD, 0xFFFFFF), 
Flour_rye(1, 0.1F, new int[][] {{Potion.confusion.id, 20 * 5, 0}}, "flour", false, 0x855A3E, 0xFFFFFF), 
Flour_rise(1, 0.1F, new int[][] {{Potion.confusion.id, 20 * 5, 0}}, "flour", false, 0xFFFFFF, 0xFFFFFF), 

Dough(1, 0.1F, new int[][] {{Potion.confusion.id, 20 * 5, 0}}), 
Batter(1, 0.1F, new int[][] {{Potion.confusion.id, 20 * 5, 0}}), 
Batter_pancake(1, 0.1F, new int[][] {{Potion.confusion.id, 20 * 5, 0}}), 
;
//-----------------------------------------------------------------------------------------------
public enum spices {
Sugar(0.0F), Vanilla(0.0F), Sail(0.0F), 
Ground_paper_black(0.0F), Ground_paper_white(0.0F), Ground_paper_red(0.0F), Ground_paper_chili(0.0F), 
Ground_cinnamon(0.0F), Ground_nutmeg(0.0F), 

Allspice(0.0F), Ginger(0.0F), Canella(0.0F), Curcuma(0.0F), Bay(0.0F), Rosemary(0.0F), Citron(0.0F), Crocus(0.0F), 
	 */
	//-----------------------------------------------------------------------------------------------
	public void onUpdate(ItemStack is, World world, Entity entity, int par4, boolean flag) {
		if (!world.isRemote) {
			NBTTagCompound nbt = is.getTagCompound();
			//-------------------------
			if (nbt == null) {
				nbt = new NBTTagCompound();
				nbt.setByte("Spoilage", (byte)0);
			}
			//-------------------------
			if (nbt != null) {
				if (nbt.hasKey("Spoilage")) {
					if (nbt.getByte("Spoilage") > 126) {
						--is.stackSize;
						/*
					} else if (nbt.getByte("Spoilage") < 0) {
						 */
					} else {
						if (world.getWorldTime() % (20 * 60) == 0) {
							nbt.setByte("Spoilage", (byte)(nbt.getByte("Spoilage") + 1));
						}
					}
				}
			}
			//-------------------------
		}
	}
	//-----------------------------------------------------------------------------------------------
	public ItemStack onEaten(ItemStack is, World world, EntityPlayer player) {
		if (!player.capabilities.isCreativeMode) {--is.stackSize;}
		if (!world.isRemote) {
			//player.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(100.0D);
		}
		return is;
	}

	public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer player) {
		player.setItemInUse(is, getMaxItemUseDuration(is));
		return super.onItemRightClick(is, world, player);
	}

	public int getMaxItemUseDuration(ItemStack is) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null && nbt.hasKey("NameID"))
			return FoodForItem.get(nbt.getString("NameID")).getSpeedOfEating();
		else
			return 64;
	}

	public EnumAction getItemUseAction(ItemStack is) {
		return EnumAction.eat;
	}

	public String getUnlocalizedName(ItemStack is) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null && nbt.hasKey("NameID"))
			return "food." + FoodForItem.get(nbt.getString("NameID")).getShortName();
		return super.getUnlocalizedName();
	}

	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
		NBTTagCompound nbt = is.getTagCompound();
		if (UtilString.isShiftKeyDown()) {
			if (nbt != null) {

				if (nbt.hasKey("NameID")) {
					if (!FoodForItem.isNull(nbt.getString("NameID"))) {
						FoodForItem ffi = FoodForItem.get(nbt.getString("NameID"));

						if (CoreTMS.show_tip_info_testing) {
							list.add("NameID: " + nbt.getString("NameID") + " / [-] ID:" + ffi.id + ".");
						}

						list.add(UtilString.getText("Name") + ": " + ffi.getLocalizedName() + ".");
						list.add(UtilString.getText("Type") + ": " + ffi.getLocalizedType() + ".");

						if (CoreTMS.show_tip_info_testing && nbt.hasKey("Spoilage")) {
							list.add("Spoilage:" + nbt.getByte("Spoilage") + ".");
						}

						if (nbt.hasKey("ColorHex")) {
							int clr = nbt.getInteger("ColorHex");
							list.add(UtilString.getText("Color") + ": " + UtilString.textColors(clr));
						}

					}

				} else {
					list.add("Bag Item is in NameID: " + nbt.getString("NameID") + ".");
				}

				/*
				list.add("Saturation Level: " + foods.valueOf(nbt.getString("NameID")).level + ".");

				if (!nbt.hasKey("Sat")) {
				list.add("Saturation: " + foods.valueOf(nbt.getString("NameID")).sat + ".");
				} else {
				list.add("Saturation*: " + nbt.getFloat("Sat") + ".");
				}

				 */

			}
		} else list.add(UtilString.hldshiftinf);
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item id, CreativeTabs table, List list) {
		for (FoodForItem ffi : FoodForItem.list)
			if (!FoodForItem.isNull(ffi) && UtilString.hasString(ffi.tag))
				list.add(addNBT(ffi.tag));
	}

	public static ItemStack addNBT(String par1) {
		ItemStack is = new ItemStack(PackStock.item.foods, 1, 0);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setString("NameID", par1);
		is.setTagCompound(nbt);
		return is;
	}

	//nbt.setInteger("ColorHex", 0xFF0000);
	//nbt.setFloat("Sat", foods.valueOf(par1).sat);
	//nbt.setString("Ingredient_1", "");
	//nbt.setString("Ingredient_2", "");
	//nbt.setString("Ingredient_3", "");

	@SideOnly(Side.CLIENT)
	public boolean requiresMultipleRenderPasses() {
		return true;
	}

	@SideOnly(Side.CLIENT)
	public int getRenderPasses(int meta) {
		return 4;
	}

	public IIcon getIcon(ItemStack is, int pass) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null && nbt.hasKey("NameID")) {
			FoodForItem ffi = FoodForItem.get(nbt.getString("NameID"));
			if (!FoodForItem.isNull(ffi))
				return icon_food[ffi.id][pass];
			else return itemIcon;
		} else return itemIcon;
	}

	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack is, int pass) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null && nbt.hasKey("NameID")) {

			if (nbt.hasKey("ColorHex")) {
				int clr1 = FoodForItem.get(nbt.getString("NameID")).getColor(pass);
				int r1 = (int)(clr1 >> 16 & 255);int g1 = (int)(clr1 >> 8 & 255);int b1 = (int)(clr1 >> 0 & 255);
				int clr2 = nbt.getInteger("ColorHex");
				int r2 = (int)(clr2 >> 16 & 255);int g2 = (int)(clr2 >> 8 & 255);int b2 = (int)(clr2 >> 0 & 255);
				//int r3 = ((r1 + (r2 * 2)) / 3);int g3 = ((g1 + (g2 * 2)) / 3);int b3 = ((b1 + (b2 * 2)) / 3);
				int r3 = ((r1 + r2) / 2);int g3 = ((g1 + g2) / 2);int b3 = ((b1 + b2) / 2);
				return (int)r3 << 16 | (int)g3 << 8 | (int)b3;
			} else {
				return FoodForItem.get(nbt.getString("NameID")).getColor(pass);
			}

		} else {
			return 16777215;
		}
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister ir) {
		super.registerIcons(ir);
		itemIcon = ir.registerIcon("timaxa007:foods/food");
		icon_food = new IIcon[FoodForItem.list.length][4];
		for (FoodForItem ffi : FoodForItem.list) {
			for (int j = 0; j < 4; j++) {
				if (!FoodForItem.isNull(ffi)) {
					icon_food[ffi.id][j] = ir.registerIcon("timaxa007:" + ffi.getTexture(j));
				} else {
					icon_food[0][j] = itemIcon;
				}
			}
		}
	}

}
