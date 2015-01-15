package mods.timaxa007.pack.furniture.item;

import java.util.List;

import mods.timaxa007.lib.GetColors;
import mods.timaxa007.lib.Option;
import mods.timaxa007.pack.furniture.PackFurniture;
import mods.timaxa007.pack.mining.PackMining;
import mods.timaxa007.tms.util.ItemFixReg;
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

public class ItemPaintCan extends ItemFixReg {

	@SideOnly(Side.CLIENT) private IIcon icon_a;
	@SideOnly(Side.CLIENT) private IIcon icon_b;

	public static final String[] paintCanColorType = new String[] {
		"PaintCanBlack", 
		"PaintCanBlue", 
		"PaintCanBrown", 
		"PaintCanCyan", 
		"PaintCanGray", 
		"PaintCanGreen", 
		"PaintCanLightBlue", 
		"PaintCanLightGray", 
		"PaintCanLightGreen", 
		"PaintCanMagenta", 
		"PaintCanOrange", 
		"PaintCanPink", 
		"PaintCanPurple", 
		"PaintCanRed", 
		"PaintCanWhite", 
		"PaintCanYellow"
	};

	public ItemPaintCan(String tag) {
		super(tag);
		setMaxStackSize(1);
		setMaxDamage(15);
		setCreativeTab(PackMining.tab_tools);
	}

	public String getUnlocalizedName(ItemStack is) {
		NBTTagCompound tag = is.getTagCompound();
		if (tag != null && tag.hasKey("Color"))
			return super.getUnlocalizedName() + "." + paintCanColorType[tag.getInteger("Color")];
		else
			return super.getUnlocalizedName();
	}

	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
		NBTTagCompound tag = is.getTagCompound();
		if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
			list.add(Option.getText("Type") + ": Tool / Brush.");
			if (tag != null) {
				if (tag.hasKey("Color"))
					list.add(Option.getText("Color") + ": " + Option.GetColors(tag.getInteger("Color"), "a") + ".");
			}
		} else list.add(Option.prshift);
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item id, CreativeTabs table, List list) {
		for (int j = 0; j < 16; ++j) {
			list.add(addTag(j));
		}
		//list.add(new ItemStack(PackFurniture.proxy.item_paint_can, 1, 0));
	}

	private static ItemStack addTag(int par1) {
		ItemStack is = new ItemStack(PackFurniture.proxy.item.paint_can);
		NBTTagCompound tag = new NBTTagCompound();
		tag.setInteger("Color", par1);
		//tag.setInteger("HexColor", GetColors.getHexColors[par2]);
		is.setTagCompound(tag);
		return is;
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int meta) {
		return icon_b;
	}

	@SideOnly(Side.CLIENT)
	public boolean requiresMultipleRenderPasses() {
		return true;
	}

	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack is, int renderPass) {
		NBTTagCompound tag = is.getTagCompound();
		if (renderPass == 0) {
			return 16777215;
		} else {
			if (tag != null && tag.hasKey("Color"))
				return GetColors.getHexColors[tag.getInteger("Color")];
			else 
				return 16777215;
		}
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamageForRenderPass(int meta, int pass) {
		return pass > 0 ? (pass == 0 ? icon_b : icon_a) : super.getIconFromDamageForRenderPass(meta, pass);
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister ir) {
		super.registerIcons(ir);
		icon_a = ir.registerIcon("timaxa007:" + "colors/paint_can" + "_overlay");
		icon_b = ir.registerIcon("timaxa007:" + "colors/paint_can");
	}

}
