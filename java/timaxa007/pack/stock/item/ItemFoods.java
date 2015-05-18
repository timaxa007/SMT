package timaxa007.pack.stock.item;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import timaxa007.module.colors.util.UtilColor;
import timaxa007.pack.stock.PackStock;
import timaxa007.pack.stock.util.FoodItem;
import timaxa007.pack.stock.util.RegistryFoods;
import timaxa007.smt.CoreSMT;
import timaxa007.smt.object.ModifiedItem;
import timaxa007.smt.util.UtilString;
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
		setTextureName("timaxa007:foods/food");
	}
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
		if (nbt != null && nbt.hasKey("FoodTag"))
			return RegistryFoods.RegistryFoodItem.getFoodItem(nbt.getString("FoodTag")).getSpeedOfEating();
		else
			return 64;
	}

	public EnumAction getItemUseAction(ItemStack is) {
		return EnumAction.eat;
	}

	public String getUnlocalizedName(ItemStack is) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null && nbt.hasKey("FoodTag"))
			return "food." + RegistryFoods.RegistryFoodItem.getFoodItem(nbt.getString("FoodTag")).getName();
		return super.getUnlocalizedName();
	}

	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
		NBTTagCompound nbt = is.getTagCompound();
		if (UtilString.isShiftKeyDown()) {
			if (nbt != null) {

				if (nbt.hasKey("FoodTag")) {
					FoodItem food_item = RegistryFoods.RegistryFoodItem.getFoodItem(nbt.getString("FoodTag"));

					if (RegistryFoods.RegistryFoodItem.hasFoodItem(food_item)) {

						if (CoreSMT.config.show_tip_info_testing) {
							list.add("FoodTag: " + nbt.getString("FoodTag") + ".");
						}

						list.add(UtilString.getText("Name") + ": " + food_item.getLocalizedName() + ".");
						//list.add(UtilString.getText("Type") + ": " + food_item.getLocalizedType() + ".");

						if (CoreSMT.config.show_tip_info_testing && nbt.hasKey("Spoilage")) {
							list.add("Spoilage:" + nbt.getByte("Spoilage") + ".");
						}

						if (nbt.hasKey("ColorHex")) {
							int clr = nbt.getInteger("ColorHex");
							list.add(UtilString.getText("Color") + ": " + UtilColor.textColors(clr));
						}

					}

				} else {
					list.add("Bag Item is in FoodTag: " + nbt.getString("FoodTag") + ".");
				}

				/*
				list.add("Saturation Level: " + foods.valueOf(nbt.getString("FoodTag")).level + ".");

				if (!nbt.hasKey("Sat")) {
				list.add("Saturation: " + foods.valueOf(nbt.getString("FoodTag")).sat + ".");
				} else {
				list.add("Saturation*: " + nbt.getFloat("Sat") + ".");
				}

				 */

			}
		} else list.add(UtilString.hldshiftinf);
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item id, CreativeTabs table, List list) {
		List lst = RegistryFoods.RegistryFoodItem.getTagFoodItems();
		for (int i = 0; i < lst.size(); i++)
			if (lst.get(i) != null && RegistryFoods.RegistryFoodItem.hasFoodItem(lst.get(i).toString()))
				list.add(addNBT(lst.get(i).toString()));
	}

	public static ItemStack addNBT(String par1) {
		ItemStack is = new ItemStack(PackStock.item.foods);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setString("FoodTag", par1);
		is.setTagCompound(nbt);
		return is;
	}

	//nbt.setInteger("ColorHex", 0xFF0000);
	//nbt.setFloat("Sat", foods.valueOf(par1).sat);
	//nbt.setString("Ingredient_1", "");
	//nbt.setString("Ingredient_2", "");
	//nbt.setString("Ingredient_3", "");

	@SideOnly(Side.CLIENT)
	public boolean requiresMultipleRenderPasses() {return true;}

	@SideOnly(Side.CLIENT)
	public int getRenderPasses(int meta) {return 4;}
	/*
	public IIcon getIcon(ItemStack is, int pass) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null && nbt.hasKey("FoodTag")) {
			FoodItem ffi = FoodItem.get(nbt.getString("FoodTag"));
			if (!FoodItem.isNull(ffi))
				return icon_food[ffi.id][pass];
			else return itemIcon;
		} else return itemIcon;
	}

	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack is, int pass) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null && nbt.hasKey("FoodTag")) {
			FoodItem food_item = RegistryFoods.RegistryFoodItem.getFoodItem(nbt.getString("FoodTag"));

			if (nbt.hasKey("ColorHex")) {
				int clr1 = FoodItem.get(nbt.getString("FoodTag")).getColor(pass);
				int r1 = (int)(clr1 >> 16 & 255);int g1 = (int)(clr1 >> 8 & 255);int b1 = (int)(clr1 >> 0 & 255);
				int clr2 = nbt.getInteger("ColorHex");
				int r2 = (int)(clr2 >> 16 & 255);int g2 = (int)(clr2 >> 8 & 255);int b2 = (int)(clr2 >> 0 & 255);
				//int r3 = ((r1 + (r2 * 2)) / 3);int g3 = ((g1 + (g2 * 2)) / 3);int b3 = ((b1 + (b2 * 2)) / 3);
				int r3 = ((r1 + r2) / 2);int g3 = ((g1 + g2) / 2);int b3 = ((b1 + b2) / 2);
				return (int)r3 << 16 | (int)g3 << 8 | (int)b3;
			} else {
				return FoodItem.get(nbt.getString("FoodTag")).getColor(pass);
			}

		} else {
			return 16777215;
		}
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister ir) {
		super.registerIcons(ir);
		itemIcon = ir.registerIcon("timaxa007:foods/food");
		icon_food = new IIcon[FoodItem.list.length][4];
		for (FoodItem ffi : FoodItem.list) {
			for (int j = 0; j < 4; j++) {
				if (!FoodItem.isNull(ffi)) {
					icon_food[ffi.id][j] = ir.registerIcon("timaxa007:" + ffi.getTexture(j));
				} else {
					icon_food[0][j] = itemIcon;
				}
			}
		}
	}
	 */
}
