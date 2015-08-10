package timaxa007.pack.item.item;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import timaxa007.pack.item.PackItem;
import timaxa007.smt.object.ModifiedItem;
import timaxa007.smt.util.UtilSMT;

public class ToolHammer extends ModifiedItem {
	/*
	@SideOnly(Side.CLIENT) private IIcon[] icon_tex;
	@SideOnly(Side.CLIENT) private IIcon[] icon_ovl;
	 */
	public ToolHammer(String tag) {
		super(tag);
		setCreativeTab(PackItem.tab_items);
		setNoRepair();
		setMaxStackSize(1);
		setMaxDamage(10);
		setContainerItem(this);
		setTextureName("timaxa007:tool/hammer");
	}

	public boolean onItemUse(ItemStack is, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		if (!player.canPlayerEdit(x, y, z, side, is)) return false;
		else {
			Block block = world.getBlock(x, y, z);
			//-------------------------------------
			if (block == Blocks.coal_block) {
				ItemStack coal = new ItemStack(Items.coal, 8 + world.rand.nextInt(2));
				UtilSMT.UtilWorld.breakupBlock(world, x, y, z, coal);
				is.damageItem(1, player);
				return true;
			}
			//-------------------------------------
		}
		return super.onItemUse(is, player, world, x, y, z, side, hitX, hitY, hitZ);
	}

	public ItemStack getContainerItem(ItemStack is) {
		System.out.println("craft");
		if (is.getItemDamage() >= 0) {
			is.setItemDamage(is.getItemDamage() + 1);
			return is;
		}
		return super.getContainerItem(is);
	}
	/*
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister ir) {
		super.registerIcons(ir);

		itemIcon = ir.registerIcon("timaxa007:colors/tool_airbrush");

		icon_tex = new IIcon[airbrush_type.length];
		icon_ovl = new IIcon[airbrush_type.length];

		for (int i = 0; i < airbrush_type.length; i++) {
			icon_tex[i] = ir.registerIcon(getIconString());
			icon_ovl[i] = ir.registerIcon(getIconString() + "_overlay");
		}
	}
	 */
}
