package timaxa007.pack.stock.item;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import timaxa007.pack.stock.PackStock;
import timaxa007.pack.stock.tile.TileEntityPlants;
import timaxa007.pack.stock.util.Plant;
import timaxa007.pack.stock.util.RegistryPlants;
import timaxa007.pack.conjoint.object.ModifiedItem;
import timaxa007.smt.util.UtilString;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemPlants extends ModifiedItem {
	/*
	@SideOnly(Side.CLIENT) private IIcon icon_a;
	@SideOnly(Side.CLIENT) private IIcon icon_b;
	 */

	public ItemPlants(String tag) {
		super(tag);
		setCreativeTab(PackStock.tab_plant);
		setHasSubtypes(true);
		setMaxDamage(0);
		setTextureName("timaxa007:base_seed");
	}

	public boolean onItemUse(ItemStack is, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		if (!player.canPlayerEdit(x, y, z, side, is)) return false;
		else {
			NBTTagCompound nbt = is.getTagCompound();
			TileEntity te = world.getTileEntity(x, y, z);
			if (nbt != null && te != null && te instanceof TileEntityPlants) {
				TileEntityPlants tile = (TileEntityPlants)te;
				if (RegistryPlants.hasPlant(nbt.getString("Plant")) && !RegistryPlants.hasPlant(tile.getPlant())) {
					//-----------------------------------------------
					if (nbt.hasKey("Plant")) tile.setPlant(nbt.getString("Plant"));
					//-----------------------------------------------
					if (nbt.hasKey("PlantType")) tile.setPlantType(nbt.getString("PlantType"));
					//-----------------------------------------------
					if (nbt.hasKey("PlantParametersMain")) tile.setPlantParametersMain(nbt.getInteger("PlantParametersMain"));
					//-----------------------------------------------
					if (nbt.hasKey("Width")) tile.setWidth(nbt.getByte("Width"));
					if (nbt.hasKey("Height")) tile.setHeight(nbt.getByte("Height"));
					//-----------------------------------------------
					return true;
				}
			}
		}
		return super.onItemUse(is, player, world, x, y, z, side, hitX, hitY, hitZ);
	}

	public String getUnlocalizedName(ItemStack is) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null && nbt.hasKey("Plant"))
			return "plant." + RegistryPlants.getPlant(nbt.getString("Plant")).getName();
		return super.getUnlocalizedName();
	}

	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
		NBTTagCompound nbt = is.getTagCompound();
		if (UtilString.isShiftKeyDown()) {
			if (nbt != null) {
				Plant plant = RegistryPlants.getPlant(nbt.getString("Plant"));
				if (nbt.hasKey("Plant")) list.add("Plant: " + plant.getLocalizedName() + ".");
				if (nbt.hasKey("PlantType")) list.add("PlantType: " + nbt.getString("PlantType") + ".");

				if (nbt.hasKey("PlantParametersMain")) {
					RegistryPlants.PlantParametersMain parameters_main = RegistryPlants.PlantParametersMain.create(nbt.getInteger("PlantParametersMain"));
					list.add(UtilString.getText("Growth_Mach") + ": " + (parameters_main.growth_mach) + ".");
					list.add(UtilString.getText("Growth_Quality") + ": " + (parameters_main.growth_quality) + ".");
					list.add(UtilString.getText("Fertility_Quality") + ": " + (parameters_main.fertility_quality) + ".");
					list.add(UtilString.getText("Fertility_Quantity") + ": " + (parameters_main.fertility_quantity) + ".");
					list.add(UtilString.getText("Resistance") + ": " + (parameters_main.resistance) + ".");
					list.add(UtilString.getText("Protection") + ": " + (parameters_main.protection) + ".");
					list.add(UtilString.getText("Dead_Plant") + ": " + (parameters_main.dead_plant) + ".");
				}

				if (nbt.hasKey("Width")) list.add(UtilString.getText("Width") + ": " + nbt.getByte("Width") + ".");
				if (nbt.hasKey("Height")) list.add(UtilString.getText("Height") + ": " + nbt.getByte("Height") + ".");
			}
		} else list.add(UtilString.hldshiftinf);
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item id, CreativeTabs table, List list) {
		List lst = RegistryPlants.getTagPlants();
		for (int i = 0; i < lst.size(); i++) {
			if (lst.get(i) != null) {
				Plant plant = RegistryPlants.getPlant(lst.get(i).toString());
				if (RegistryPlants.hasPlant(plant)) {
					list.add(addNBT(
							plant.getTag(), 
							plant.getType(), 
							plant.getGrowthMach(), 
							plant.getGrowthQuality(), 
							plant.getFertilityQuality(), 
							plant.getFertilityQuantity(), 
							plant.getResistance(), 
							plant.getProtection(), 
							plant.getDeadPlant()
							));
				}
			}
		}
		//list.add(new ItemStack(id, 1, 0));
	}

	public static ItemStack addNBT(String plant, String plant_type, int growth_mach, int growth_quality, int fertility_quality, int fertility_quantity, int resistance, int protection, boolean dead_plant) {
		return addNBT(plant, plant_type, growth_mach, growth_quality, fertility_quality, fertility_quantity, resistance, protection, dead_plant, 1, 1);
	}

	public static ItemStack addNBT(String plant, String plant_type, int growth_mach, int growth_quality, int fertility_quality, int fertility_quantity, int resistance, int protection, boolean dead_plant, int width, int height) {
		return addNBT(plant, plant_type, RegistryPlants.PlantParametersMain.create(growth_mach, growth_quality, fertility_quality, fertility_quantity, resistance, protection, dead_plant), width, height);
	}

	public static ItemStack addNBT(String plant, String plant_type, RegistryPlants.PlantParametersMain parameters_main, int width, int height) {
		ItemStack is = new ItemStack(PackStock.item.plants);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setString("Plant", plant);
		nbt.setString("PlantType", plant_type);
		nbt.setInteger("PlantParametersMain", parameters_main.getPlantParametersMain());
		nbt.setByte("Width", (byte)width);
		nbt.setByte("Height", (byte)height);
		is.setTagCompound(nbt);
		return is;
	}

	/*
@SideOnly(Side.CLIENT)
public boolean requiresMultipleRenderPasses() {return true;}

public IIcon getIcon(ItemStack is, int pass) {
if (tag != null && nbt.hasKey("Plant") {
if (pass == 0) {
return icon_a;
} else {
return icon_b;
}
} else {
return itemIcon;
}
}
	 */
	/*
@SideOnly(Side.CLIENT)
public void registerIcons(IIconRegister ir) {
super.registerIcons(ir);
itemIcon = ir.registerIcon(getIconString());
//icon_a = ir.registerIcon("timaxa007:base_seed");
//icon_b = ir.registerIcon("timaxa007:base_seed");
}
	 */
}
