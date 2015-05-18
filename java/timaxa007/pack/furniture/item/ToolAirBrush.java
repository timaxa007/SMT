package timaxa007.pack.furniture.item;

import java.util.List;

import timaxa007.pack.furniture.tile.TileEntityClothBlocks;
import timaxa007.pack.furniture.tile.TileEntityGlassBlocks;
import timaxa007.pack.furniture.tile.TileEntityGroundBlocks;
import timaxa007.pack.furniture.tile.TileEntityMetalBlocks;
import timaxa007.pack.furniture.tile.TileEntityRockBlocks;
import timaxa007.pack.furniture.tile.TileEntitySandBlocks;
import timaxa007.pack.furniture.tile.TileEntityWoodBlocks;
import timaxa007.pack.mining.PackMining;
import timaxa007.smt.object.ModifiedItem;
import timaxa007.smt.util.UtilString;
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

public class ToolAirBrush extends ModifiedItem {

	@SideOnly(Side.CLIENT) private IIcon[] icon_tex;
	@SideOnly(Side.CLIENT) private IIcon[] icon_ovl;

	public ToolAirBrush(String tag) {
		super(tag);
		setCreativeTab(PackMining.tab_tools);
		setMaxStackSize(1);
		setMaxDamage(10000);
		setTextureName("timaxa007:colors/tool_airbrush");
	}

}
