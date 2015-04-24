package timaxa007.pack.stock.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import timaxa007.pack.stock.lib.Plants;
import timaxa007.tms.util.UtilString;

public class TileEntityPlants extends TileEntity {

	private String plant;
	private String plant_type;

	//private Plants.PlantParametersMain parameters_main;
	//private Plants.PlantParametersSecondary parameters_secondary;

	private int growth;
	private int fertility;
	private int resistance;
	private int protection;

	private int width;
	private int height;

	private String style;

	public TileEntityPlants() {
		this.plant = "";
		this.plant_type = "";
		//this.parameters_main = Plants.PlantParametersMain.create(0, 0, 0);
		//this.parameters_secondary = Plants.PlantParametersSecondary.create(0, 0, 0);
		this.growth = 0;
		this.fertility = 0;
		this.resistance = 0;
		this.protection = 0;
		this.width = 0;
		this.height = 0;
		this.style = "";
	}

	public void setPlant(String plant) {this.plant = plant;}
	public String getPlant() {return plant;}

	public void setPlantType(String plant_type) {this.plant_type = plant_type;}
	public String getPlantType() {return plant_type;}

	public void setPlantParametersMain(int parameters_main) {
		Plants.PlantParametersMain parameters_main2 = Plants.PlantParametersMain.create(parameters_main);
		this.growth = parameters_main2.growth;
		this.fertility = parameters_main2.fertility;
		this.resistance = parameters_main2.resistance;
		this.protection = parameters_main2.protection;
	}

	public void setPlantParametersMain(int growth, int fertility, int resistance, int protection) {
		this.growth = growth;
		this.fertility = fertility;
		this.resistance = resistance;
		this.protection = protection;
	}

	public Plants.PlantParametersMain getPlantParametersMain() {
		Plants.PlantParametersMain parameters_main = 
				Plants.PlantParametersMain.create(this.growth, this.fertility, this.resistance, this.protection);
		return parameters_main;
	}
	/*
	public int getGrowth() {return parameters_main.growth;}
	public int getFertility() {return parameters_main.fertility;}
	public int getResistance() {return parameters_main.resistance;}
	 */

	public void setGrowth(int growth) {
		if (growth <= 0) this.growth = 0;
		else if (growth >= 255) this.growth = 255;
		else this.growth = growth;
	}
	public int getGrowth() {return growth;}

	public void setFertility(int fertility) {
		if (fertility <= 0) this.fertility = 0;
		else if (fertility >= 255) this.fertility = 255;
		else this.fertility = fertility;
	}
	public int getFertility() {return fertility;}

	public void setResistance(int resistance) {
		if (resistance <= 0) this.resistance = 0;
		else if (resistance >= 16) this.resistance = 16;
		else this.resistance = resistance;
	}
	public int getResistance() {return resistance;}

	public void setProtection(int protection) {
		if (protection <= 0) this.protection = 0;
		else if (protection >= 16) this.protection = 16;
		else this.protection = protection;
	}
	public int getProtection() {return protection;}

	public void setWidth(int width) {this.width = width;}
	public int getWidth() {return width;}

	public void setHeight(int height) {this.height = height;}
	public int getHeight() {return height;}

	public void setStyle(String style) {this.style = style;}
	public String getStyle() {return style;}

	public void updateEntity() {
		if (worldObj.getWorldTime() % (20 * 10) == 0) {
			setFertility(++fertility);
		}
		//parameters_main = Plants.PlantParametersMain.create(growth, fertility, resistance);
	}
	/*
	public void updateEntity() {
		int updt = 1;

		if (getTypePlant() == 1) {
			if (worldObj.getWorldTime() % (20 * updt) == 0 && getGrowing() <= 8) {
				setGrowing(getGrowing() + 1);
			}
		}
		//-------------------------------------------------------------------------------
		if (getTypePlant() == 2) {

			if (worldObj.getWorldTime() % (20 * updt) == 0 && getHeight() < 16) {
				setHeight(getHeight() + 1);
			}

			TileEntity teb = worldObj.getTileEntity(xCoord, yCoord - 1, zCoord);

			if (worldObj.getWorldTime() % (20 * 10 * updt) == 0 && getThickness() <= 8) {
				if (teb != null && teb instanceof TileEntityPlants) {
					if (((TileEntityPlants)teb).getThickness() > getThickness()) {
						setThickness(getThickness() + 1);
					}
				} else if (teb == null) {
					setThickness(getThickness() + 1);
				} else {;}

			}

			if (!worldObj.isRemote && worldObj.getWorldTime() % (20 * updt) == 0 &&
					(worldObj.isAirBlock(xCoord, yCoord + 1, zCoord) || worldObj.getBlock(xCoord, yCoord + 1, zCoord) == Block.leaves) &&
					getHeight() == 16) {
				worldObj.setBlock(xCoord, yCoord + 1, zCoord, PackStock.block__plants);
				TileEntityPlants tes = new TileEntityPlants();
				tes.setTypePlant(getTypePlant());
				tes.setPlant(getPlant());
				tes.setSticks(0);
				tes.setHeight(1);
				tes.setThickness(1);
				worldObj.setTileEntity(xCoord, yCoord + 1, zCoord, tes);
			}

		}
		//-------------------------------------------------------------------------------
		//if (!worldObj.isRemote) {}

	}

	public void updateEntity() {
		int updt = 1;

		if (worldObj.getWorldTime() % (20 * updt) == 0 && getHeight() <= 8) {
			setHeight(getHeight() + 1);
		}

		//if (getPlantType() == "Tree") {System.out.println(" + ");}
	}
	 */
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		if (nbt.hasKey("Plant")) plant = nbt.getString("Plant"); else plant = "";
		if (nbt.hasKey("PlantType")) plant_type = nbt.getString("PlantType"); else plant = "";

		if (nbt.hasKey("PlantParametersMain")) {
			Plants.PlantParametersMain parameters_main = Plants.PlantParametersMain.create(nbt.getInteger("PlantParametersMain"));
			this.growth = parameters_main.growth;
			this.fertility = parameters_main.fertility;
			this.resistance = parameters_main.resistance;
			this.protection = parameters_main.protection;
		}
		/*if (nbt.hasKey("PlantParametersSecondary")) 
			parameters_secondary.create(nbt.getInteger("PlantParametersSecondary"));*/
		if (nbt.hasKey("Width")) width = (int)nbt.getByte("Width");
		if (nbt.hasKey("Height")) height = (int)nbt.getByte("Height");
		if (nbt.hasKey("Style")) style = nbt.getString("Style"); else style = "";
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);

		if (UtilString.hasString(plant)) nbt.setString("Plant", plant);
		if (UtilString.hasString(plant_type)) nbt.setString("PlantType", plant_type);

		Plants.PlantParametersMain parameters_main = 
				Plants.PlantParametersMain.create(this.growth, this.fertility, this.resistance, this.protection);
		nbt.setInteger("PlantParametersMain", parameters_main.getPlantParametersMain());
		//nbt.setInteger("PlantParametersSecondary", parameters_secondary.parameters_plant_secondary);

		nbt.setByte("Width", (byte)width);
		nbt.setByte("Height", (byte)height);

		if (UtilString.hasString(style)) nbt.setString("Style", style);
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
