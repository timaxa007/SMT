package timaxa007.pack.stock.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import timaxa007.tms.util.UtilString;

public class TileEntityPlants extends TileEntity {

	private String plant;
	private String plant_type;

	//private Plants.PlantParametersMain parameters_main;
	//private Plants.PlantParametersSecondary parameters_secondary;

	private int growth;
	private int fertility;
	private int resistance;

	private int width;
	private int height;

	private String style;

	public TileEntityPlants() {
		plant = "";
		plant_type = "";
		//parameters_main = Plants.PlantParametersMain.createParameters(0, 0, 0);
		//parameters_secondary = Plants.PlantParametersSecondary.createParameters(0, 0, 0);
		growth = 0;
		fertility = 0;
		resistance = 0;
		width = 0;
		height = 0;
		style = "";
	}

	public void setPlant(String plant) {this.plant = plant;}
	public String getPlant() {return plant;}

	public void setPlantType(String plant_type) {this.plant_type = plant_type;}
	public String getPlantType() {return plant_type;}

	public void setGrowth(int growth) {this.growth = growth;}
	public int getGrowth() {return growth;}

	public void setFertility(int fertility) {this.fertility = fertility;}
	public int getFertility() {return fertility;}

	public void setResistance(int resistance) {this.resistance = resistance;}
	public int getResistance() {return resistance;}

	public void setWidth(int width) {this.width = width;}
	public int getWidth() {return width;}

	public void setHeight(int height) {this.height = height;}
	public int getHeight() {return height;}

	public void setStyle(String style) {this.style = style;}
	public String getStyle() {return style;}

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
		/*
		if (nbt.hasKey("PlantParametersMain")) 
			parameters_main.createParameters(nbt.getInteger("PlantParametersMain"));
		if (nbt.hasKey("PlantParametersSecondary")) 
			parameters_secondary.createParameters(nbt.getInteger("PlantParametersSecondary"));
		 */
		if (nbt.hasKey("Growth")) growth = (int)nbt.getByte("Growth");
		if (nbt.hasKey("Fertility")) fertility = (int)nbt.getByte("Fertility");
		if (nbt.hasKey("Resistance")) resistance = (int)nbt.getByte("Resistance");

		if (nbt.hasKey("Width")) width = (int)nbt.getByte("Width");
		if (nbt.hasKey("Height")) height = (int)nbt.getByte("Height");
		if (nbt.hasKey("Style")) style = nbt.getString("Style"); else style = "";
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);

		if (UtilString.hasString(plant)) nbt.setString("Plant", plant);
		if (UtilString.hasString(plant_type)) nbt.setString("PlantType", plant_type);

		//nbt.setInteger("PlantParametersMain", parameters_main.parameters_plant_main);
		//nbt.setInteger("PlantParametersSecondary", parameters_secondary.parameters_plant_secondary);

		nbt.setByte("Growth", (byte)growth);
		nbt.setByte("Fertility", (byte)fertility);
		nbt.setByte("Resistance", (byte)resistance);

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