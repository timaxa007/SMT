package mods.timaxa007.pack.stock.items;

import java.util.List;

import mods.timaxa007.lib.Option;
import mods.timaxa007.pack.stock.PackStock;
import mods.timaxa007.pack.stock.lib.GerminationPlants;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemGerminationPlants extends Item {
	/*
@SideOnly(Side.CLIENT) private IIcon icon_a;
@SideOnly(Side.CLIENT) private IIcon icon_b;
	 */
	//Crop
	//Stem
	//Herbal
	//Shrub
	//Squash

	public static GerminationPlants stem_raspberry = new GerminationPlants("stem_raspberry").setName("raspberry").setType("Stem").setTexture("raspberry").setPlantStats(3, 2, 1).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);

	public static GerminationPlants stem_pineapple = new GerminationPlants("stem_pineapple").setName("pineapple").setType("Stem").setTexture("pineapple").setPlantStats(3, 2, 1).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);

	public static GerminationPlants stem_bamboo = new GerminationPlants("stem_bamboo").setName("bamboo").setType("Stem").setTexture("bamboo").setPlantStats(3, 2, 1).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);

	public static GerminationPlants herbal_spice_leaf = new GerminationPlants("herbal_spice_leaf").setName("spice_leaf").setType("Herbal").setTexture("spice_leaf").setPlantStats(3, 2, 1).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);

	//Cactus

	public static GerminationPlants cactus_01 = new GerminationPlants("cactus_01").setName("01").setType("Cactus").setTexture("01").setPlantStats(3, 2, 1).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);

	//Mushroom
	public static GerminationPlants mushroom_brown = new GerminationPlants("mushroom_brown").setName("brown").setType("Mushroom").setTexture("brown").setPlantStats(2, 2, 2).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static GerminationPlants mushroom_red = new GerminationPlants("mushroom_red").setName("red").setType("Mushroom").setTexture("red").setPlantStats(2, 2, 2).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static GerminationPlants mushroom_nether_wart = new GerminationPlants("mushroom_nether_wart").setName("nether_wart").setType("Mushroom").setTexture("nether_wart").setPlantStats(2, 2, 2).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static GerminationPlants mushroom_nether_red = new GerminationPlants("mushroom_nether_red").setName("nether_red").setType("Mushroom").setTexture("nether_red").setPlantStats(2, 2, 2).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	//Flower
	public static GerminationPlants flower_tulip = new GerminationPlants("flower_tulip").setName("tulip").setType("Flower").setTexture("tulip").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static GerminationPlants flower_squill = new GerminationPlants("flower_squill").setName("squill").setType("Flower").setTexture("squill").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static GerminationPlants flower_carnation = new GerminationPlants("flower_carnation").setName("carnation").setType("Flower").setTexture("carnation").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static GerminationPlants flower_daisy = new GerminationPlants("flower_daisy").setName("daisy").setType("Flower").setTexture("daisy").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static GerminationPlants flower_hydrangea = new GerminationPlants("flower_hydrangea").setName("hydrangea").setType("Flower").setTexture("hydrangea").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static GerminationPlants flower_chamomile = new GerminationPlants("flower_chamomile").setName("chamomile").setType("Flower").setTexture("chamomile").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static GerminationPlants flower_aconite = new GerminationPlants("flower_aconite").setName("aconite").setType("Flower").setTexture("aconite").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static GerminationPlants flower_lavender = new GerminationPlants("flower_lavender").setName("lavender").setType("Flower").setTexture("lavender").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);

	//Sapling

	public static GerminationPlants tree_oak = new GerminationPlants("tree_oak").setName("oak").setType("Tree").setTexture("oak").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static GerminationPlants tree_birch = new GerminationPlants("tree_birch").setName("birch").setType("Tree").setTexture("birch").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static GerminationPlants tree_jungle = new GerminationPlants("tree_jungle").setName("jungle").setType("Tree").setTexture("jungle").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static GerminationPlants tree_spruce = new GerminationPlants("tree_spruce").setName("spruce").setType("Tree").setTexture("spruce").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);

	public static GerminationPlants tree_walnut = new GerminationPlants("tree_walnut").setName("walnut").setType("Tree").setTexture("walnut").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);

	public static GerminationPlants tree_nutmeg = new GerminationPlants("tree_nutmeg").setName("nutmeg").setType("Tree").setTexture("nutmeg").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);

	public static GerminationPlants tree_mango = new GerminationPlants("tree_mango").setName("mango").setType("Tree").setTexture("mango").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);

	public static GerminationPlants tree_vanilla = new GerminationPlants("tree_vanilla").setName("vanilla").setType("Tree").setTexture("vanilla").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);

	public static GerminationPlants tree_rowan = new GerminationPlants("tree_rowan").setName("rowan").setType("Tree").setTexture("rowan").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);

	public static GerminationPlants tree_pine = new GerminationPlants("tree_pine").setName("pine").setType("Tree").setTexture("pine").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static GerminationPlants tree_willow = new GerminationPlants("tree_willow").setName("willow").setType("Tree").setTexture("willow").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static GerminationPlants tree_maple = new GerminationPlants("tree_maple").setName("maple").setType("Tree").setTexture("maple").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static GerminationPlants tree_lipa = new GerminationPlants("tree_lipa").setName("lipa").setType("Tree").setTexture("lipa").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static GerminationPlants tree_elm = new GerminationPlants("tree_elm").setName("elm").setType("Tree").setTexture("elm").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static GerminationPlants tree_larch = new GerminationPlants("tree_larch").setName("larch").setType("Tree").setTexture("larch").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static GerminationPlants tree_aspen = new GerminationPlants("tree_aspen").setName("aspen").setType("Tree").setTexture("aspen").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static GerminationPlants tree_fir = new GerminationPlants("tree_fir").setName("fir").setType("Tree").setTexture("fir").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static GerminationPlants tree_poplar = new GerminationPlants("tree_poplar").setName("poplar").setType("Tree").setTexture("poplar").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static GerminationPlants tree_ash = new GerminationPlants("tree_ash").setName("ash").setType("Tree").setTexture("ash").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static GerminationPlants tree_cedar = new GerminationPlants("tree_cedar").setName("cedar").setType("Tree").setTexture("cedar").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static GerminationPlants tree_beech = new GerminationPlants("tree_beech").setName("beech").setType("Tree").setTexture("beech").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static GerminationPlants tree_chestnut = new GerminationPlants("tree_chestnut").setName("chestnut").setType("Tree").setTexture("chestnut").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);

	public static GerminationPlants palma_coconut = new GerminationPlants("palma_coconut").setName("coconut").setType("Palma").setTexture("coconut").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static GerminationPlants palma_banana = new GerminationPlants("palma_banana").setName("banana").setType("Palma").setTexture("banana").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);

	public static GerminationPlants tree_colored_black = new GerminationPlants("tree_colored_black").setName("colored_black").setType("Tree").setTexture("black").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static GerminationPlants tree_colored_blue = new GerminationPlants("tree_colored_blue").setName("colored_blue").setType("Tree").setTexture("blue").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static GerminationPlants tree_colored_brown = new GerminationPlants("tree_colored_brown").setName("colored_brown").setType("Tree").setTexture("brown").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static GerminationPlants tree_colored_cyan = new GerminationPlants("tree_colored_cyan").setName("colored_cyan").setType("Tree").setTexture("cyan").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static GerminationPlants tree_colored_gray = new GerminationPlants("tree_colored_gray").setName("colored_gray").setType("Tree").setTexture("gray").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static GerminationPlants tree_colored_green = new GerminationPlants("tree_colored_green").setName("colored_green").setType("Tree").setTexture("green").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static GerminationPlants tree_colored_light_blue = new GerminationPlants("tree_colored_light_blue").setName("colored_light_blue").setType("Tree").setTexture("light_blue").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static GerminationPlants tree_colored_light_gray = new GerminationPlants("tree_colored_light_gray").setName("colored_light_gray").setType("Tree").setTexture("light_gray").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static GerminationPlants tree_colored_light_green = new GerminationPlants("tree_colored_light_green").setName("colored_light_green").setType("Tree").setTexture("light_green").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static GerminationPlants tree_colored_magenta = new GerminationPlants("tree_colored_magenta").setName("colored_magenta").setType("Tree").setTexture("magenta").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static GerminationPlants tree_colored_orange = new GerminationPlants("tree_colored_orange").setName("colored_orange").setType("Tree").setTexture("orange").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static GerminationPlants tree_colored_pink = new GerminationPlants("tree_colored_pink").setName("colored_pink").setType("Tree").setTexture("pink").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static GerminationPlants tree_colored_purple = new GerminationPlants("tree_colored_purple").setName("colored_purple").setType("Tree").setTexture("purple").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static GerminationPlants tree_colored_red = new GerminationPlants("tree_colored_red").setName("colored_red").setType("Tree").setTexture("red").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static GerminationPlants tree_colored_white = new GerminationPlants("tree_colored_white").setName("colored_white").setType("Tree").setTexture("white").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static GerminationPlants tree_colored_yellow = new GerminationPlants("tree_colored_yellow").setName("colored_yellow").setType("Tree").setTexture("yellow").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);

	public static GerminationPlants sapling_colored_oil_red = new GerminationPlants("sapling_colored_oil_red").setName("colored_oil_red").setType("Tree").setTexture("oil_red").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);

	public static GerminationPlants crop_coral  = new GerminationPlants("crop_coral").setName("coral").setType("Herbal Water").setTexture("coral").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static GerminationPlants crop_kelp = new GerminationPlants("crop_kelp").setName("kelp").setType("Herbal Water").setTexture("kelp").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);

	public ItemGerminationPlants() {
		super();
		setCreativeTab(PackStock.proxy.tab_plant);
		setHasSubtypes(true);
		setMaxDamage(0);
		setTextureName("timaxa007:base_seed");
		setUnlocalizedName("ger_plant");
	}
/*
	public boolean onItemUse(ItemStack is, EntityPlayer player, World world, int x, int y, int z, int meta, float hitX, float hitY, float hitZ) {
		if (!player.canPlayerEdit(x, y, z, meta, is)) {return false;}
		else {

			TileEntity te = world.getTileEntity(x, y, z);
			NBTTagCompound tag = is.getTagCompound();
			if (te != null && te instanceof TEGerminationPlants) {

				if (tag != null) {
					if (((TEGerminationPlants)te).getPlant() == 0) {
						((TEGerminationPlants)te).setPlant(tag.getInteger("PlantID"));
					}
					return true;
				} else {
					//((TEGrower)te).plant = 0;
					return false;
				}
			} else {
				return false;
			}
		}
	}
*/
/*
	public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer player) {
		if (world.isRemote && tag != null) {
			if (tag.hasKey("PlantID")) {player.addChatMessage(" - " + tag.getInteger("PlantID"));}
			if (tag.hasKey("PlantType")) {player.addChatMessage(" - " + tag.getString("PlantType"));}
			if (tag.hasKey("Growth")) {player.addChatMessage(" - " + tag.getInteger("Growth"));}
			if (tag.hasKey("Fertility")) {player.addChatMessage(" - " + tag.getInteger("Fertility"));}
			if (tag.hasKey("Resistance")) {player.addChatMessage(" - " + tag.getInteger("Resistance"));}
		}
		return is;
	}
*/
	public String getUnlocalizedName(ItemStack is) {
		NBTTagCompound tag = is.getTagCompound();
		if (tag != null && tag.hasKey("PlantID")) {
			return "plant." + GerminationPlants.plant_list[tag.getInteger("PlantID")].getName();
		}
		return super.getUnlocalizedName();
	}

	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
		NBTTagCompound tag = is.getTagCompound();
		if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
			if (tag != null) {
				if (tag.hasKey("PlantID")) list.add("PlantID: " + tag.getInteger("PlantID") + ".");
				if (tag.hasKey("PlantType")) list.add("PlantType: " + tag.getString("PlantType") + ".");
				if (tag.hasKey("Growth")) list.add("Growth: " + tag.getInteger("Growth") + ".");
				if (tag.hasKey("Fertility")) list.add("Fertility: " + tag.getInteger("Fertility") + ".");
				if (tag.hasKey("Resistance")) list.add("Resistance: " + tag.getInteger("Resistance") + ".");
			}
		} else {
			list.add(Option.prshift);
		}
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item id, CreativeTabs table, List list) {
		for (int i = 0; i < GerminationPlants.plant_list.length; ++i) {
			if (GerminationPlants.plant_list[i] != null) {
				list.add(addTag(
						i, 
						GerminationPlants.plant_list[i].getType(), 
						GerminationPlants.plant_list[i].getGrowth(), 
						GerminationPlants.plant_list[i].getFertility(), 
						GerminationPlants.plant_list[i].getResistance()
						));
			}
		}
		//list.add(new ItemStack(id, 1, 0));
	}

	public static ItemStack addTag(int par1, String par2, int par3, int par4, int par5) {
		ItemStack is = new ItemStack(PackStock.proxy.item_germination_plants, 1, 0);
		NBTTagCompound tag = new NBTTagCompound();
		tag.setInteger("PlantID", par1);
		tag.setString("PlantType", par2);
		tag.setInteger("Growth", par3);
		tag.setInteger("Fertility", par4);
		tag.setInteger("Resistance", par5);
		is.setTagCompound(tag);
		return is;
	}

	/*
@SideOnly(Side.CLIENT)
public boolean requiresMultipleRenderPasses() {return true;}

public IIcon getIcon(ItemStack is, int pass) {
if (tag != null && tag.hasKey("PlantID")) {
if (pass == 0) {
return icon_a;
} else {
return icon_b;
}
} else {
return itemIcon;
}
}

@SideOnly(Side.CLIENT)
public int getColorFromItemStack(ItemStack is, int pass) {
if (tag != null && tag.hasKey("PlantID") && base_seed.hasStrCode(tag.getInteger("PlantID"))) {
if (pass == 0) {
return base_seed.valueOf(tag.getInteger("PlantID")).hex1;
} else {
return base_seed.valueOf(tag.getInteger("PlantID")).hex2;
}
} else {
return 16777215;
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
