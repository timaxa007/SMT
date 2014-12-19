package mods.timaxa007.pack.stock.items;

import java.util.List;

import mods.timaxa007.lib.GetColors;
import mods.timaxa007.lib.Option;
import mods.timaxa007.pack.stock.PackStock;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBees extends Item {

	@SideOnly(Side.CLIENT) private IIcon[] icon_a;
	@SideOnly(Side.CLIENT) private IIcon[] icon_b;
	@SideOnly(Side.CLIENT) private IIcon[] icon_c;

	public ItemBees() {
		super();
		setCreativeTab(PackStock.tab_apis);
		setHasSubtypes(true);
		setMaxDamage(0);
		setTextureName("timaxa007:apis/bees_");
		setUnlocalizedName("bees");
	}

	public enum bees {
		Bees_1(GetColors.getHexColors[10], GetColors.getHexColors[15]), 
		Bees_2(GetColors.getHexColors[15], GetColors.getHexColors[10]), 
		Bees_3(0x7F6A00, 0xBF9F00), 
		Bees_4(GetColors.getHexColors[10], GetColors.getHexColors[2]), 
		Bees_5(GetColors.getHexColors[10], GetColors.getHexColors[13]), 
		Bees_6(GetColors.getHexColors[6], GetColors.getHexColors[14]), 
		Bees_7(GetColors.getHexColors[8], GetColors.getHexColors[5]), 
		Bees_8(GetColors.getHexColors[14], GetColors.getHexColors[15]), 
		Bees_9(GetColors.getHexColors[9], GetColors.getHexColors[0]), 
		Bees_b_1(GetColors.getHexColors[0], GetColors.getHexColors[0]), 
		Bees_b_2(GetColors.getHexColors[1], GetColors.getHexColors[4]), 
		Bees_b_3(GetColors.getHexColors[2], GetColors.getHexColors[4]), 
		Bees_b_4(GetColors.getHexColors[3], GetColors.getHexColors[4]), 
		Bees_b_5(GetColors.getHexColors[4], GetColors.getHexColors[0]), 
		Bees_b_6(GetColors.getHexColors[5], GetColors.getHexColors[4]), 
		Bees_b_7(GetColors.getHexColors[6], GetColors.getHexColors[4]), 
		Bees_b_8(GetColors.getHexColors[7], GetColors.getHexColors[4]), 
		Bees_b_9(GetColors.getHexColors[8], GetColors.getHexColors[4]), 
		Bees_b_10(GetColors.getHexColors[9], GetColors.getHexColors[4]), 
		Bees_b_11(GetColors.getHexColors[10], GetColors.getHexColors[4]), 
		Bees_b_12(GetColors.getHexColors[11], GetColors.getHexColors[4]), 
		Bees_b_13(GetColors.getHexColors[12], GetColors.getHexColors[4]), 
		Bees_b_14(GetColors.getHexColors[13], GetColors.getHexColors[4]), 
		Bees_b_15(GetColors.getHexColors[14], GetColors.getHexColors[7]), 
		Bees_b_16(GetColors.getHexColors[15], GetColors.getHexColors[4]), 
		NONE(0xFFFFFF, 0xFFFFFF);

		public static String[] type_bee = new String[] {
			"drone", 
			"princess", 
			"queen"
		};

		private int hex1;
		private int hex2;

		static boolean hasStrCode(String str) {
			for (bees j : bees.values()) {
				if (str.equalsIgnoreCase(j.toString())) {
					return true;
				}
			}
			return false;
		}

		bees(int p_hex1, int p_hex2) {
			//new FluidFake(500 + ordinal()).setName("honey_" + this.toString().toLowerCase()).setType("Liquid").setColor(0xFFFFFF).setTemperatures(16.0F, -10.0F, 100.0F);
			hex1 = p_hex1;
			hex2 = p_hex2;
		}

	}

	public String getUnlocalizedName(ItemStack is) {
		NBTTagCompound tag = is.getTagCompound();
		if (tag != null && tag.hasKey("NameID") && tag.hasKey("TypeBee")) {
			//return super.getUnlocalizedName() + "." + tag.getString("NameID").toLowerCase() + "." + tag.getInteger("TypeBee");
			return super.getUnlocalizedName() + "." + tag.getString("NameID").toLowerCase();
		}
		return super.getUnlocalizedName();
	}

	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
		NBTTagCompound tag = is.getTagCompound();
		if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
			if (tag != null) {
				if (tag.hasKey("NameID")) {
					list.add("NameID: " + tag.getString("NameID") + ".");
				}
				if (tag.hasKey("TypeBee")) {
					list.add("TypeBee: " + tag.getInteger("TypeBee") + ".");
				}
			}
		} else {
			list.add(Option.prshift);
		}
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item id, CreativeTabs table, List list) {
		for (bees j : bees.values()) {
			for (int i = 0; i < bees.type_bee.length; ++i) {
				list.add(addTag(j.toString(), i));
			}
		}
		//list.add(new ItemStack(id, 1, 0));
	}

	private ItemStack addTag(String par1, int par2) {
		ItemStack is = new ItemStack(PackStock.proxy.item_bees, 1, 0);
		NBTTagCompound tag = new NBTTagCompound();
		tag.setString("NameID", par1);
		tag.setInteger("TypeBee", par2);
		is.setTagCompound(tag);
		return is;
	}

	@SideOnly(Side.CLIENT)
	public int getRenderPasses(int metadata) {return 3;}

	@SideOnly(Side.CLIENT)
	public boolean requiresMultipleRenderPasses() {return true;}

	public IIcon getIcon(ItemStack is, int pass) {
		NBTTagCompound tag = is.getTagCompound();
		if (tag != null && tag.hasKey("NameID") && tag.hasKey("TypeBee")) {
			if (pass == 0) {
				return icon_a[tag.getInteger("TypeBee")];
			} else if (pass == 1) {
				return icon_b[tag.getInteger("TypeBee")];
			} else {
				return icon_c[tag.getInteger("TypeBee")];
			}
		} else {
			return itemIcon;
		}
	}

	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack is, int pass) {
		NBTTagCompound tag = is.getTagCompound();
		if (tag != null && tag.hasKey("NameID") && bees.hasStrCode(tag.getString("NameID"))) {
			if (pass == 0) {
				return bees.valueOf(tag.getString("NameID")).hex1;
			} else if (pass == 1) {
				return bees.valueOf(tag.getString("NameID")).hex2;
			} else {
				return 16777215;
			}
		} else {
			return 16777215;
		}
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister ir) {
		super.registerIcons(ir);
		itemIcon = ir.registerIcon(getIconString() + "icon");
		icon_a = new IIcon[bees.type_bee.length];
		icon_b = new IIcon[bees.type_bee.length];
		icon_c = new IIcon[bees.type_bee.length];
		for (int i = 0; i < bees.type_bee.length; ++i) {
			icon_a[i] = ir.registerIcon(getIconString() + bees.type_bee[i] + "_a");
			icon_b[i] = ir.registerIcon(getIconString() + bees.type_bee[i] + "_b");
			icon_c[i] = ir.registerIcon(getIconString() + bees.type_bee[i] + "_c");
		}
	}

}
