package timaxa007.pack.stock.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import timaxa007.module.fluids.util.Fluid;
import timaxa007.module.fluids.util.RegistryFluids;
import timaxa007.pack.stock.PackStock;
import timaxa007.smt.object.ModifiedItem;
import timaxa007.smt.util.UtilString;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemDrinks extends ModifiedItem {

	@SideOnly(Side.CLIENT) private IIcon[] icon_tex;
	@SideOnly(Side.CLIENT) private IIcon[] icon_ovl;

	public static final Fluid TEST1 = new Fluid("test1").setColor(0xFF0000);
	public static final Fluid TEST2 = new Fluid("test2").setColor(0x0000FF).setNutriment(2, 1.0F, 3, 2.0F);
	public static final Fluid TEST3 = new Fluid("test3").setColor(0x00FF00).setFoodStat(2, 1.0F);
	public static final Fluid TEST4 = new Fluid("test4").setColor(0xFF00FF).setDrinkStat(3, 2.0F);

	public ItemDrinks(String tag) {
		super(tag);
		setCreativeTab(PackStock.tab_food);
		setHasSubtypes(true);
		setMaxDamage(0);
		RegistryFluids.registerFluid(TEST1);
		RegistryFluids.registerFluid(TEST2);
		RegistryFluids.registerFluid(TEST3);
		RegistryFluids.registerFluid(TEST4);
		RegistryFluids.registerFluid(new Fluid("test5").setColor(0xFFFF00).setDrinkStat(1, 0.5F).setSafeDrink(false).setSpeedDrinking(64));
	}
	//tea - flower, tea, 
	//boiled, hot, normal, 
	public enum drinks {Bottle;}
	/*
Water(0.0F, 0xFFFFFF), 
Tea(0.0F, 0xFFFFFF), 
Coffee(0.0F, 0xFFFFFF), 
Milk(0.0F, 0xFFFFFF), 
Cacao(0.0F, 0xFFFFFF), 
Juice_of_apples(0.0F, 0xFFFFFF), 
Milkshake(0.0F, 0xFFFFFF), 
Lemonade(0.0F, 0xFFFFFF), 
	 */
	public ItemStack onEaten(ItemStack is, World world, EntityPlayer player) {
		NBTTagCompound nbt = is.getTagCompound();
		if (!player.capabilities.isCreativeMode) {--is.stackSize;}
		if (!world.isRemote) {
			if (nbt != null && nbt.hasKey("FluidTag")) {
				Fluid fluid = RegistryFluids.getFluid(nbt.getString("FluidTag"));
				player.getFoodStats().addStats(fluid.getFoodLevel(), fluid.getFoodSaturation());
				//player.statDrink().addStats(fluid.getDrinkLevel(), fluid.getThirstQuenching());
				//player.statFood().addStats(fluid.getFoodLevel(), fluid.getFoodSaturation());
			}
		}
		return is;
	}

	public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer player) {
		//world.playSoundAtEntity(player, "timaxa007:vodka", 1.0F, 1.0F);
		player.setItemInUse(is, getMaxItemUseDuration(is));
		return super.onItemRightClick(is, world, player);
	}

	public int getMaxItemUseDuration(ItemStack is) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null && nbt.hasKey("FluidTag")) {
			Fluid fluid = RegistryFluids.getFluid(nbt.getString("FluidTag"));
			return fluid.getSpeedDrinking();
		} else return 32;
	}

	public EnumAction getItemUseAction(ItemStack is) {
		return EnumAction.drink;
	}

	public String getUnlocalizedName(ItemStack is) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null && nbt.hasKey("FluidTag")) {
			Fluid fluid = RegistryFluids.getFluid(nbt.getString("FluidTag"));
			return "fluid." + fluid.getName();
		}
		return super.getUnlocalizedName();
	}

	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
		NBTTagCompound nbt = is.getTagCompound();
		if (UtilString.isShiftKeyDown()) {
			if (nbt != null) {

				if (nbt.hasKey("NameID")) {
					list.add("NameID: " + nbt.getString("NameID") + ".");
				}

				if (nbt.hasKey("FluidTag")) {
					Fluid fluid = RegistryFluids.getFluid(nbt.getString("FluidTag"));
					list.add(UtilString.getText("Name") + ": " + fluid.getLocalizedName() + ".");
					list.add("Stat: drink - (" + fluid.getDrinkLevel() + ", " + fluid.getThirstQuenching() + 
							") / food - (" + fluid.getFoodLevel() + ", " + fluid.getFoodSaturation() + ").");
				}

			}
		} else list.add(UtilString.hldshiftinf);
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item id, CreativeTabs table, List list) {
		for (drinks j1 : drinks.values()) {
			List lst = RegistryFluids.getListFluids();
			for (int i = 0; i < lst.size(); ++i) {
				if (lst.get(i) != null) {
					Fluid fluid = RegistryFluids.getFluid(lst.get(i).toString());
					if (RegistryFluids.hasFluid(fluid)/* && fluid.isNutriment()*/)
						list.add(addNBT(j1.toString(), fluid.getTag()));
				}
			}

		}
	}

	public static ItemStack addNBT(String par1, String par2) {
		ItemStack is = new ItemStack(PackStock.item.drinks);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setString("NameID", par1);
		nbt.setString("FluidTag", par2);
		is.setTagCompound(nbt);
		return is;
	}

	@SideOnly(Side.CLIENT)
	public boolean requiresMultipleRenderPasses() {return true;}

	public IIcon getIcon(ItemStack is, int pass) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null && nbt.hasKey("NameID")) {
			if (pass == 0) {
				return icon_tex[drinks.valueOf(nbt.getString("NameID")).ordinal()];
			} else {
				return icon_ovl[drinks.valueOf(nbt.getString("NameID")).ordinal()];
			}
		} else {
			return itemIcon;
		}
	}

	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack is, int renderPass) {
		NBTTagCompound nbt = is.getTagCompound();
		if (renderPass == 0) {
			/*if (nbt != null && nbt.hasKey("NameID")) {
				return drinks.valueOf(nbt.getString("NameID")).hex1;
			} else return 0xFFFFFF;*/
			return 0xFFFFFF;
		} else {
			if (nbt != null && nbt.hasKey("FluidTag")) {
				return RegistryFluids.getFluid(nbt.getString("FluidTag")).getColor();
			} else return 0xFFFFFF;
		}
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister ir) {
		super.registerIcons(ir);
		itemIcon = ir.registerIcon("timaxa007:" + "drinks/" + "drink");
		icon_tex = new IIcon[drinks.values().length];
		icon_ovl = new IIcon[drinks.values().length];
		for (drinks j : drinks.values()) {
			//icon_tex[j.ordinal()] = ir.registerIcon("timaxa007:" + "drinks/" + j.toString().toLowerCase());
			//icon_ovl[j.ordinal()] = ir.registerIcon("timaxa007:" + "empty");
			icon_tex[j.ordinal()] = ir.registerIcon("timaxa007:" + "kitchenware/" + "proof_big");
			icon_ovl[j.ordinal()] = ir.registerIcon("timaxa007:" + "kitchenware/" + "proof_big" + "_overlay");
		}
	}

}
