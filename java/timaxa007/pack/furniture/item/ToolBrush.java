package timaxa007.pack.furniture.item;

import java.util.List;

import timaxa007.pack.furniture.PackFurniture;
import timaxa007.pack.mining.PackMining;
import timaxa007.tms.object.ModifiedItem;
import timaxa007.tms.util.UtilString;
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
