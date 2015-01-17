package mods.timaxa007.pack.furniture.item;

import java.util.List;

import mods.timaxa007.lib.GetColors;
import mods.timaxa007.pack.furniture.tile.TileEntityClothBlocks;
import mods.timaxa007.pack.furniture.tile.TileEntityGlassBlocks;
import mods.timaxa007.pack.furniture.tile.TileEntityGroundBlocks;
import mods.timaxa007.pack.furniture.tile.TileEntityMetalBlocks;
import mods.timaxa007.pack.furniture.tile.TileEntityRockBlocks;
import mods.timaxa007.pack.furniture.tile.TileEntitySandBlocks;
import mods.timaxa007.pack.furniture.tile.TileEntityWoodBlocks;
import mods.timaxa007.pack.mining.PackMining;
import mods.timaxa007.tms.util.ItemFixReg;
import mods.timaxa007.tms.util.UtilText;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ToolAirBrush extends ItemFixReg {

	@SideOnly(Side.CLIENT) private IIcon[] icon_tex;
	@SideOnly(Side.CLIENT) private IIcon[] icon_ovl;

	public static final String[] airbrush_type = new String[] {
		"easy", 
		"normal", 
		"hard"
	};

	public static final String[] airbrush_mode = new String[] {
		"1:1", 
		"1:2", 
		"1:4", 
		"1:8", 
		"1:16", 
		"radial"
	};
	/*
	public static final String[] airbrushColorType = new String[] {
	"AirBrushBlack", 
	"AirBrushBlue", 
	"AirBrushBrown", 
	"AirBrushCyan", 
	"AirBrushGray", 
	"AirBrushGreen", 
	"AirBrushLightBlue", 
	"AirBrushLightGray", 
	"AirBrushLightGreen", 
	"AirBrushMagenta", 
	"AirBrushOrange", 
	"AirBrushPink", 
	"AirBrushPurple", 
	"AirBrushRed", 
	"AirBrushWhite", 
	"AirBrushYellow"
	};
	 */
	public ToolAirBrush(String tag) {
		super(tag);
		setCreativeTab(PackMining.tab_tools);
		setMaxStackSize(1);
		setMaxDamage(10000);
		setTextureName("timaxa007:colors/tool_airbrush");
	}

	public boolean onItemUse(ItemStack is, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		if (!player.canPlayerEdit(x, y, z, side, is)) {
			return false;
		} else {
			TileEntity te = world.getTileEntity(x, y, z);
			NBTTagCompound tag = is.getTagCompound();

			if (tag != null && tag.hasKey("ColorHex2")) {
				if (te != null && te instanceof TileEntityRockBlocks) {
					((TileEntityRockBlocks)te).setColorBlock(tag.getInteger("ColorHex2"));
					is.damageItem(1, player);
					return true;
				} else if (te != null && te instanceof TileEntityGlassBlocks) {
					((TileEntityGlassBlocks)te).setColorBlock(tag.getInteger("ColorHex2"));
					is.damageItem(1, player);
					return true;
				} else if (te != null && te instanceof TileEntityWoodBlocks) {
					((TileEntityWoodBlocks)te).setColorBlock(tag.getInteger("ColorHex2"));
					is.damageItem(1, player);
					return true;
				} else if (te != null && te instanceof TileEntityGroundBlocks) {
					((TileEntityGroundBlocks)te).setColorBlock(tag.getInteger("ColorHex2"));
					is.damageItem(1, player);
					return true;
				} else if (te != null && te instanceof TileEntitySandBlocks) {
					((TileEntitySandBlocks)te).setColorBlock(tag.getInteger("ColorHex2"));
					is.damageItem(1, player);
					return true;
				} else if (te != null && te instanceof TileEntityClothBlocks) {
					((TileEntityClothBlocks)te).setColorBlock(tag.getInteger("ColorHex2"));
					is.damageItem(1, player);
					return true;
				} else if (te != null && te instanceof TileEntityMetalBlocks) {
					((TileEntityMetalBlocks)te).setColorBlock(tag.getInteger("ColorHex2"));
					is.damageItem(1, player);
					return true;
				} else return false;
			} else return false;
			/*
			} else if (i1 == Block.dirt || i1 == Block.grass || i1 == Block.mycelium) {
			Block block = Block.tilledField;
			world.playSoundEffect((double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), block.stepSound.getStepSound(), (block.stepSound.getVolume()+1.0F) / 2.0F, block.stepSound.getPitch() * 0.8F);

			world.setBlock(x, y, z, block);
			is.damageItem(1, player);

			return true;
			 */
		}
	}

	@SideOnly(Side.CLIENT)
	public boolean isFull3D() {return true;}

	public String getUnlocalizedName(ItemStack is) {
		NBTTagCompound tag = is.getTagCompound();
		if (tag != null && tag.hasKey("Type")) {
			return super.getUnlocalizedName() + "." + airbrush_type[(int)tag.getByte("Type")];
		} else {
			return super.getUnlocalizedName();
		}
	}

	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
		NBTTagCompound tag = is.getTagCompound();
		if (UtilText.isShiftKeyDown()) {
			list.add(UtilText.getText("Type") + ": Tool / AirBrush.");
			if (tag != null) {
				if (tag.hasKey("ColorHex1"))
					list.add(UtilText.getText("Color") + " 1: #" + tag.getInteger("ColorHex1") + ".");
				if (tag.hasKey("ColorHex2"))
					list.add(UtilText.getText("Color") + " 2: #" + tag.getInteger("ColorHex2") + ".");
			}
		} else list.add(UtilText.hldshiftinf);
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item id, CreativeTabs table, List list) {
		for (int i = 0; i < airbrush_type.length; ++i) {
			for (int j2 = 0; j2 < 16; ++j2) {
				int j1 = 0xFFFFFF;
				list.add(addTag(id, i, j1, GetColors.getHexColors[j2]));
			}
		}
		//list.add(new ItemStack(id, 1, 0));
	}

	private static ItemStack addTag(Item par1, int par2, int par3, int par4) {
		ItemStack is = new ItemStack(par1, 1, 0);
		NBTTagCompound tag = new NBTTagCompound();
		tag.setByte("Type", (byte)par2);
		tag.setInteger("ColorHex1", par3);
		tag.setInteger("ColorHex2", par4);
		is.setTagCompound(tag);
		return is;
	}

	@SideOnly(Side.CLIENT)
	public boolean requiresMultipleRenderPasses() {
		return true;
	}

	public IIcon getIcon(ItemStack is, int pass) {
		NBTTagCompound tag = is.getTagCompound();
		if (tag != null && tag.hasKey("Type")) {
			if (pass == 0) {
				return icon_tex[(int)tag.getByte("Type")];
			} else {
				return icon_ovl[(int)tag.getByte("Type")];
			}
		} else return itemIcon;
	}

	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack is, int pass) {
		NBTTagCompound tag = is.getTagCompound();
		if (pass == 0) {
			if (tag != null && tag.hasKey("ColorHex1")) 
				return tag.getInteger("ColorHex1");
			else 
				return 16777215;
		} else {
			if (tag != null && tag.hasKey("ColorHex2")) 
				return tag.getInteger("ColorHex2");
			else
				return 16777215;
		}
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister ir) {
		super.registerIcons(ir);

		itemIcon = ir.registerIcon(getIconString());

		icon_tex = new IIcon[airbrush_type.length];
		icon_ovl = new IIcon[airbrush_type.length];

		for (int i = 0; i < airbrush_type.length; i++) {
			icon_tex[i] = ir.registerIcon(getIconString());
			icon_ovl[i] = ir.registerIcon(getIconString() + "_overlay");
		}
	}

}
