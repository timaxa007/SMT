package timaxa007.pack.stock.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import timaxa007.module.forbidden.api.ITileEntityOwner;
import timaxa007.pack.stock.util.Plant;
import timaxa007.pack.stock.util.RegistryPlants;
import timaxa007.pack.stock.util.RegistryPlants.PlantParametersMain;
import timaxa007.smt.util.UtilString;

public class TileEntityPlants extends TileEntity implements ITileEntityOwner {

	private String plant;
	private String plant_type;

	private RegistryPlants.PlantParametersMain parameters_plant_main;
	private int width;
	private int height;

	private String style;
	private String owner;

	public TileEntityPlants() {
		this.plant = "";
		this.plant_type = "";
		this.parameters_plant_main = RegistryPlants.PlantParametersMain.create(0x00000000);
		this.width = 0;
		this.height = 0;
		this.style = "";
		owner = "";
	}

	public void setPlant(String plant) {this.plant = plant;}
	public String getPlant() {return plant;}

	public void setPlantType(String plant_type) {this.plant_type = plant_type;}
	public String getPlantType() {return plant_type;}

	public void setPlantParametersMain(int growth_mach, int growth_quality, int fertility_quality, int fertility_quantity, int resistance, int protection, boolean dead_plant) {
		this.parameters_plant_main = RegistryPlants.PlantParametersMain.create(growth_mach, growth_quality, fertility_quality, fertility_quantity, resistance, protection, dead_plant);
	}

	public void setPlantParametersMain(int parameters_plant_main) {
		this.parameters_plant_main = RegistryPlants.PlantParametersMain.create(parameters_plant_main);
	}

	public void setPlantParametersMain(PlantParametersMain parameters_plant_main) {
		this.parameters_plant_main = parameters_plant_main;
	}

	public RegistryPlants.PlantParametersMain getPlantParametersMain() {return parameters_plant_main;}

	public void setGrowthMach(int growth_mach) {getPlantParametersMain().editGrowthMach(growth_mach);}
	public void setGrowthQuality(int growth_quality) {getPlantParametersMain().editGrowthQuality(growth_quality);}
	public void setFertilityQuality(int fertility_quality) {getPlantParametersMain().editFertilityQuality(fertility_quality);}
	public void setFertilityQuantity(int fertility_quantity) {getPlantParametersMain().editFertilityQuantity(fertility_quantity);}
	public void setResistance(int resistance) {getPlantParametersMain().editResistance(resistance);}
	public void setProtection(int protection) {getPlantParametersMain().editProtection(protection);}
	public void setDeadPlant(boolean dead_plant) {getPlantParametersMain().editDeadPlant(dead_plant);}

	public int getGrowthMach() {return getPlantParametersMain().growth_mach;}
	public int getGrowthQuality() {return getPlantParametersMain().growth_quality;}
	public int getFertilityQuality() {return getPlantParametersMain().fertility_quality;}
	public int getFertilityQuantity() {return getPlantParametersMain().fertility_quantity;}
	public int getResistance() {return getPlantParametersMain().resistance;}
	public int getProtection() {return getPlantParametersMain().protection;}
	public boolean getDeadPlant() {return getPlantParametersMain().dead_plant;}

	public void setWidth(int width) {this.width = width;}
	public int getWidth() {return width;}

	public void setHeight(int height) {this.height = height;}
	public int getHeight() {return height;}

	public void setStyle(String style) {this.style = style;}
	public String getStyle() {return style;}

	public void setOwner(String username) {owner = username;}
	public String getOwner() {return owner;}

	public void updateEntity() {
		TileEntity te = worldObj.getTileEntity(xCoord, yCoord, zCoord);
		if (te != null && te instanceof TileEntityPlants) {
			TileEntityPlants tile = (TileEntityPlants)te;
			if (worldObj.getWorldTime() % (20 * 1) == 0) {
				if (RegistryPlants.hasPlant(getPlant())) {

					if (tile.getGrowthMach() < RegistryPlants.PlantParametersMain.GrowthMachMax)
						tile.setGrowthMach(tile.getGrowthMach() + 1);

					if (tile.getGrowthQuality() < RegistryPlants.PlantParametersMain.GrowthQualityMax)
						tile.setGrowthQuality(tile.getGrowthQuality() + 1);

					if (tile.getFertilityQuality() < RegistryPlants.PlantParametersMain.FertilityQualityMax)
						tile.setFertilityQuality(tile.getFertilityQuality() + 1);

					if (tile.getFertilityQuantity() < RegistryPlants.PlantParametersMain.FertilityQuantityMax)
						tile.setFertilityQuantity(tile.getFertilityQuantity() + 1);

					if (tile.getResistance() < RegistryPlants.PlantParametersMain.ResistanceMax)
						tile.setResistance(tile.getResistance() + 1);

					if (tile.getProtection() < RegistryPlants.PlantParametersMain.ProtectionMax)
						tile.setProtection(tile.getProtection() + 1);

					tile.setDeadPlant(!tile.getDeadPlant());
				}
			}
		}
		//parameters_main = Plants.PlantParametersMain.create(growth, fertility, resistance);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		if (nbt.hasKey("Plant")) plant = nbt.getString("Plant"); else plant = "";
		if (nbt.hasKey("PlantType")) plant_type = nbt.getString("PlantType"); else plant = "";

		if (nbt.hasKey("PlantParametersMain")) setPlantParametersMain(nbt.getInteger("PlantParametersMain"));
		/*if (nbt.hasKey("PlantParametersSecondary")) 
			parameters_secondary.create(nbt.getInteger("PlantParametersSecondary"));*/
		if (nbt.hasKey("Width")) width = (int)nbt.getByte("Width");
		if (nbt.hasKey("Height")) height = (int)nbt.getByte("Height");
		if (nbt.hasKey("Style")) style = nbt.getString("Style"); else style = "";
		if (nbt.hasKey("Owner")) owner = nbt.getString("Owner");
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);

		if (UtilString.hasString(plant)) nbt.setString("Plant", plant);
		if (UtilString.hasString(plant_type)) nbt.setString("PlantType", plant_type);

		nbt.setInteger("PlantParametersMain", parameters_plant_main.getPlantParametersMain());
		//nbt.setInteger("PlantParametersSecondary", parameters_secondary.parameters_plant_secondary);

		nbt.setByte("Width", (byte)width);
		nbt.setByte("Height", (byte)height);

		if (UtilString.hasString(style)) nbt.setString("Style", style);
		if (UtilString.hasString(owner)) nbt.setString("Owner", owner);
	}

	public Packet getDescriptionPacket() {
		NBTTagCompound nbt = new NBTTagCompound();
		writeToNBT(nbt);
		return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 0, nbt);
	}

	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
		readFromNBT(packet.func_148857_g());
	}

}
