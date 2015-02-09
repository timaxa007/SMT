package mods.timaxa007.pack.furniture.item;

import java.util.List;

import mods.timaxa007.pack.furniture.PackFurniture;
import mods.timaxa007.pack.mining.PackMining;
import mods.timaxa007.tms.util.ModifiedItem;
import mods.timaxa007.tms.util.UtilText;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ToolBrush extends ModifiedItem {

	@SideOnly(Side.CLIENT) private IIcon icon_a;
	@SideOnly(Side.CLIENT) private IIcon icon_b;

	public ToolBrush(String tag) {
		super(tag);
		setCreativeTab(PackMining.tab_tools);
		setMaxStackSize(1);
		setMaxDamage(8);
		setTextureName("timaxa007:colors/tool_brush");
	}

}
