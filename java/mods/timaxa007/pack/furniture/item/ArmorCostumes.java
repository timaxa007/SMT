package mods.timaxa007.pack.furniture.item;

import java.util.List;

import mods.timaxa007.pack.furniture.PackFurniture;
import mods.timaxa007.tms.util.ModifiedItemArmor;
import mods.timaxa007.tms.util.UtilString;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ArmorCostumes extends ModifiedItemArmor {

	@SideOnly(Side.CLIENT) private IIcon[] icon_tex;
	@SideOnly(Side.CLIENT) private IIcon[] icon_ovl;

	public static String[] armor_type_name = new String[] {
		"helmet", 
		"shirt", 
		"pants", 
		"boot"
	};

	public ArmorCostumes(String tag, ArmorMaterial par2, int par3, int par4) {
		super(tag, par2, par3, par4);
		setCreativeTab(PackFurniture.tab_furniture);
	}

	public enum costumes {
		Cow(), 
		Mooshroom(), 
		Sheep(), 
		Creeper(), 
		Zombie(), 
		Zombie_pigman(), 
		Skeleton(), 
		Wither_skeleton(), 
		Blaze(), 
		Enderman(), 
		Spider(), 
		Spider_cave(), 
		NONE();

		private String texture;
		private boolean pass;
		private int hex1;
		private int hex2;

		static boolean hasStrCode(String str) {
			for (costumes j : costumes.values()) {
				if (str.equalsIgnoreCase(j.toString())) {
					return true;
				}
			}
			return false;
		}

		costumes() {
			texture = toString().toLowerCase();
			pass = false;
			hex1 = 0xFFFFFF;
			hex2 = 0xFFFFFF;
		}

	}

	public void onArmorTickUpdate(World world, EntityPlayer player, ItemStack is) {

	}

	public String getUnlocalizedName(ItemStack is) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null && nbt.hasKey("NameID"))
			return super.getUnlocalizedName() + "." + nbt.getString("NameID").toLowerCase();
		return super.getUnlocalizedName();
	}

	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
		NBTTagCompound nbt = is.getTagCompound();
		if (UtilString.isShiftKeyDown()) {
			if (nbt != null) {
				if (nbt.hasKey("NameID"))
					list.add("NameID: " + nbt.getString("NameID") + ".");
			}
		} else list.add(UtilString.hldshiftinf);
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item id, CreativeTabs table, List list) {
		for (costumes j : costumes.values()) {
			list.add(addNBT(id, j.toString()));
		}
		//list.add(new ItemStack(id, 1, 0));
	}

	private ItemStack addNBT(Item id, String par2) {
		ItemStack is = new ItemStack(id, 1, 0);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setString("NameID", par2);
		is.setTagCompound(nbt);
		return is;
	}

	public String getArmorTexture(ItemStack is, Entity entity, int slot, String type) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null && nbt.hasKey("NameID") && costumes.hasStrCode(nbt.getString("NameID")))
			return "timaxa007:textures/armor/" + nbt.getString("NameID") + "_" + (armorType == 2 ? 2 : 1) + ".png";
		else
			return "timaxa007:textures/armor/none_1.png";
	}

	public IIcon getIcon(ItemStack is, int pass) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null && nbt.hasKey("NameID") && costumes.hasStrCode(nbt.getString("NameID"))) {
			if (pass == 0)
				return icon_tex[costumes.valueOf(nbt.getString("NameID")).ordinal()];
			else
				return icon_ovl[costumes.valueOf(nbt.getString("NameID")).ordinal()];
		} else return itemIcon;
	}

	@SideOnly(Side.CLIENT)
	public boolean requiresMultipleRenderPasses() {
		return true;
	}

	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack is, int pass) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null && nbt.hasKey("NameID") && costumes.hasStrCode(nbt.getString("NameID"))) {
			if (pass == 0)
				return costumes.valueOf(nbt.getString("NameID")).hex1;
			else
				return costumes.valueOf(nbt.getString("NameID")).hex2;
		} else return 16777215;
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister ir) {
		super.registerIcons(ir);
		itemIcon = ir.registerIcon("timaxa007:" + "armor/" + "armor");
		icon_tex = new IIcon[costumes.values().length];
		icon_ovl = new IIcon[costumes.values().length];
		for (costumes j : costumes.values()) {
			icon_tex[j.ordinal()] = ir.registerIcon("timaxa007:" + "armor/" + j.texture + "_" + armorType);
			if (j.pass) {
				icon_ovl[j.ordinal()] = ir.registerIcon("timaxa007:" + "armor/" + j.texture + "_" + armorType + "_overlay");
			} else {
				icon_ovl[j.ordinal()] = ir.registerIcon("timaxa007:" + "empty");
			}
		}
	}

}
