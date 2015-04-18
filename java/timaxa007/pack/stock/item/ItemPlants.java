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
import timaxa007.pack.stock.lib.Plants;
import timaxa007.pack.stock.tile.TileEntityPlants;
import timaxa007.tms.util.ModifiedItem;
import timaxa007.tms.util.UtilString;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemPlants extends ModifiedItem {
	/*
@SideOnly(Side.CLIENT) private IIcon icon_a;
@SideOnly(Side.CLIENT) private IIcon icon_b;
	 */
	//Crop
	//Stem
	//Herbal
	//Shrub
	//Squash

	public static Plants stem_raspberry = new Plants("raspberry").setType("Stem").setTexture("raspberry").setPlantStats(3, 2, 1).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);

	public static Plants stem_pineapple = new Plants("pineapple").setType("Stem").setTexture("pineapple").setPlantStats(3, 2, 1).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);

	public static Plants stem_bamboo = new Plants("bamboo").setType("Stem").setTexture("bamboo").setPlantStats(3, 2, 1).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);

	public static Plants herbal_spice_leaf = new Plants("spice_leaf").setType("Herbal").setTexture("spice_leaf").setPlantStats(3, 2, 1).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);

	//Cactus

	public static Plants cactus_01 = new Plants("cactus_01").setType("Cactus").setTexture("01").setPlantStats(3, 2, 1).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);

	//Mushroom
	public static Plants mushroom_brown = new Plants("mushroom_brown").setName("brown").setType("Mushroom").setTexture("brown").setPlantStats(2, 2, 2).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static Plants mushroom_red = new Plants("mushroom_red").setName("red").setType("Mushroom").setTexture("red").setPlantStats(2, 2, 2).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static Plants mushroom_nether_wart = new Plants("mushroom_nether_wart").setName("nether_wart").setType("Mushroom").setTexture("nether_wart").setPlantStats(2, 2, 2).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static Plants mushroom_nether_red = new Plants("mushroom_nether_red").setName("nether_red").setType("Mushroom").setTexture("nether_red").setPlantStats(2, 2, 2).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	//Flower
	public static Plants flower_tulip = new Plants("flower_tulip").setName("tulip").setType("Flower").setTexture("tulip").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static Plants flower_squill = new Plants("flower_squill").setName("squill").setType("Flower").setTexture("squill").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static Plants flower_carnation = new Plants("flower_carnation").setName("carnation").setType("Flower").setTexture("carnation").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static Plants flower_daisy = new Plants("flower_daisy").setName("daisy").setType("Flower").setTexture("daisy").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static Plants flower_hydrangea = new Plants("flower_hydrangea").setName("hydrangea").setType("Flower").setTexture("hydrangea").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static Plants flower_chamomile = new Plants("flower_chamomile").setName("chamomile").setType("Flower").setTexture("chamomile").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static Plants flower_aconite = new Plants("flower_aconite").setName("aconite").setType("Flower").setTexture("aconite").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static Plants flower_lavender = new Plants("flower_lavender").setName("lavender").setType("Flower").setTexture("lavender").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);

	//Sapling

	public static Plants tree_oak = new Plants("tree_oak").setName("oak").setType("Tree").setTexture("oak").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static Plants tree_birch = new Plants("tree_birch").setName("birch").setType("Tree").setTexture("birch").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static Plants tree_jungle = new Plants("tree_jungle").setName("jungle").setType("Tree").setTexture("jungle").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static Plants tree_spruce = new Plants("tree_spruce").setName("spruce").setType("Tree").setTexture("spruce").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);

	public static Plants tree_walnut = new Plants("tree_walnut").setName("walnut").setType("Tree").setTexture("walnut").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);

	public static Plants tree_nutmeg = new Plants("tree_nutmeg").setName("nutmeg").setType("Tree").setTexture("nutmeg").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);

	public static Plants tree_mango = new Plants("tree_mango").setName("mango").setType("Tree").setTexture("mango").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);

	public static Plants tree_vanilla = new Plants("tree_vanilla").setName("vanilla").setType("Tree").setTexture("vanilla").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);

	public static Plants tree_rowan = new Plants("tree_rowan").setName("rowan").setType("Tree").setTexture("rowan").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);

	public static Plants tree_pine = new Plants("tree_pine").setName("pine").setType("Tree").setTexture("pine").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static Plants tree_willow = new Plants("tree_willow").setName("willow").setType("Tree").setTexture("willow").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static Plants tree_maple = new Plants("tree_maple").setName("maple").setType("Tree").setTexture("maple").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static Plants tree_lipa = new Plants("tree_lipa").setName("lipa").setType("Tree").setTexture("lipa").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static Plants tree_elm = new Plants("tree_elm").setName("elm").setType("Tree").setTexture("elm").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static Plants tree_larch = new Plants("tree_larch").setName("larch").setType("Tree").setTexture("larch").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static Plants tree_aspen = new Plants("tree_aspen").setName("aspen").setType("Tree").setTexture("aspen").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static Plants tree_fir = new Plants("tree_fir").setName("fir").setType("Tree").setTexture("fir").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static Plants tree_poplar = new Plants("tree_poplar").setName("poplar").setType("Tree").setTexture("poplar").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static Plants tree_ash = new Plants("tree_ash").setName("ash").setType("Tree").setTexture("ash").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static Plants tree_cedar = new Plants("tree_cedar").setName("cedar").setType("Tree").setTexture("cedar").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static Plants tree_beech = new Plants("tree_beech").setName("beech").setType("Tree").setTexture("beech").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static Plants tree_chestnut = new Plants("tree_chestnut").setName("chestnut").setType("Tree").setTexture("chestnut").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);

	public static Plants palma_coconut = new Plants("palma_coconut").setName("coconut").setType("Palma").setTexture("coconut").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static Plants palma_banana = new Plants("palma_banana").setName("banana").setType("Palma").setTexture("banana").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);

	public static Plants tree_colored_black = new Plants("tree_colored_black").setName("colored_black").setType("Tree").setTexture("black").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static Plants tree_colored_blue = new Plants("tree_colored_blue").setName("colored_blue").setType("Tree").setTexture("blue").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static Plants tree_colored_brown = new Plants("tree_colored_brown").setName("colored_brown").setType("Tree").setTexture("brown").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static Plants tree_colored_cyan = new Plants("tree_colored_cyan").setName("colored_cyan").setType("Tree").setTexture("cyan").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static Plants tree_colored_gray = new Plants("tree_colored_gray").setName("colored_gray").setType("Tree").setTexture("gray").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static Plants tree_colored_green = new Plants("tree_colored_green").setName("colored_green").setType("Tree").setTexture("green").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static Plants tree_colored_light_blue = new Plants("tree_colored_light_blue").setName("colored_light_blue").setType("Tree").setTexture("light_blue").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static Plants tree_colored_light_gray = new Plants("tree_colored_light_gray").setName("colored_light_gray").setType("Tree").setTexture("light_gray").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static Plants tree_colored_light_green = new Plants("tree_colored_light_green").setName("colored_light_green").setType("Tree").setTexture("light_green").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static Plants tree_colored_magenta = new Plants("tree_colored_magenta").setName("colored_magenta").setType("Tree").setTexture("magenta").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static Plants tree_colored_orange = new Plants("tree_colored_orange").setName("colored_orange").setType("Tree").setTexture("orange").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static Plants tree_colored_pink = new Plants("tree_colored_pink").setName("colored_pink").setType("Tree").setTexture("pink").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static Plants tree_colored_purple = new Plants("tree_colored_purple").setName("colored_purple").setType("Tree").setTexture("purple").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static Plants tree_colored_red = new Plants("tree_colored_red").setName("colored_red").setType("Tree").setTexture("red").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static Plants tree_colored_white = new Plants("tree_colored_white").setName("colored_white").setType("Tree").setTexture("white").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static Plants tree_colored_yellow = new Plants("tree_colored_yellow").setName("colored_yellow").setType("Tree").setTexture("yellow").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);

	public static Plants sapling_colored_oil_red = new Plants("sapling_colored_oil_red").setName("colored_oil_red").setType("Tree").setTexture("oil_red").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);

	public static Plants crop_coral  = new Plants("crop_coral").setName("coral").setType("Herbal Water").setTexture("coral").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static Plants crop_kelp = new Plants("crop_kelp").setName("kelp").setType("Herbal Water").setTexture("kelp").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);

	public ItemPlants(String tag) {
		super(tag);
		setCreativeTab(PackStock.tab_plant);
		setHasSubtypes(true);
		setMaxDamage(0);
		setTextureName("timaxa007:base_seed");
	}

	public boolean onItemUse(ItemStack is, EntityPlayer player, World world, int x, int y, int z, int meta, float hitX, float hitY, float hitZ) {
		if (!player.canPlayerEdit(x, y, z, meta, is)) {return false;}
		else {

			NBTTagCompound nbt = is.getTagCompound();
			TileEntity te = world.getTileEntity(x, y, z);
			if (nbt != null && te != null && te instanceof TileEntityPlants) {
				TileEntityPlants tile = (TileEntityPlants)te;
				//-----------------------------------------------
				if (nbt.hasKey("Plant"))
					if (!UtilString.hasString(tile.getPlant()))
						tile.setPlant(nbt.getString("Plant"));
				//-----------------------------------------------
				if (nbt.hasKey("PlantType"))
					if (!UtilString.hasString(tile.getPlantType()))
						tile.setPlant(nbt.getString("PlantType"));
				//-----------------------------------------------
				if (nbt.hasKey("Growth")) tile.setGrowth(nbt.getByte("Growth"));
				if (nbt.hasKey("Fertility")) tile.setFertility(nbt.getByte("Fertility"));
				if (nbt.hasKey("Resistance")) tile.setResistance(nbt.getByte("Resistance"));
				//-----------------------------------------------
				if (nbt.hasKey("Width")) tile.setWidth(nbt.getByte("Width"));
				if (nbt.hasKey("Height")) tile.setHeight(nbt.getByte("Height"));
				//-----------------------------------------------
				return true;
			} else return false;
		}
	}

	public String getUnlocalizedName(ItemStack is) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null && nbt.hasKey("Plant")) {
			return "plant." + Plants.get(nbt.getString("Plant")).getName();
		}
		return super.getUnlocalizedName();
	}

	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
		NBTTagCompound nbt = is.getTagCompound();
		if (UtilString.isShiftKeyDown()) {
			if (nbt != null) {
				if (nbt.hasKey("Plant")) list.add("Plant: " + nbt.getString("Plant") + ".");
				if (nbt.hasKey("PlantType")) list.add("PlantType: " + nbt.getString("PlantType") + ".");
				if (nbt.hasKey("Growth")) list.add("Growth: " + nbt.getByte("Growth") + ".");
				if (nbt.hasKey("Fertility")) list.add("Fertility: " + nbt.getByte("Fertility") + ".");
				if (nbt.hasKey("Resistance")) list.add("Resistance: " + nbt.getByte("Resistance") + ".");
				if (nbt.hasKey("Width")) list.add("Width: " + nbt.getByte("Width") + ".");
				if (nbt.hasKey("Height")) list.add("Height: " + nbt.getByte("Height") + ".");
			}
		} else list.add(UtilString.hldshiftinf);
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item id, CreativeTabs table, List list) {
		for (Plants plant : Plants.list) {
			if (plant != null) {
				list.add(addNBT(
						plant.tag, 
						plant.getType(), 
						plant.getGrowth(), 
						plant.getFertility(), 
						plant.getResistance()
						));
			}
		}
		//list.add(new ItemStack(id, 1, 0));
	}

	public static ItemStack addNBT(String par1, String par2, int par3, int par4, int par5) {
		ItemStack is = new ItemStack(PackStock.item.plants, 1, 0);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setString("Plant", par1);
		nbt.setString("PlantType", par2);
		nbt.setByte("Growth", (byte)par3);
		nbt.setByte("Fertility", (byte)par4);
		nbt.setByte("Resistance", (byte)par5);
		nbt.setByte("Width", (byte)1);
		nbt.setByte("Height", (byte)1);
		is.setTagCompound(nbt);
		return is;
	}

	/*
@SideOnly(Side.CLIENT)
public boolean requiresMultipleRenderPasses() {return true;}

public IIcon getIcon(ItemStack is, int pass) {
if (tag != null && nbt.hasKey("Plant")) {
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
