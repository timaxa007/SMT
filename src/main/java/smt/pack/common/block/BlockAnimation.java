package smt.pack.common.block;

import java.util.HashMap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import smt.pack.common.client.gui.GuiAnimation;
import smt.pack.common.tile.TileEntityAnimation;

public class BlockAnimation extends Block  implements smt.pack.common.api.IRegisterItem, net.minecraft.block.ITileEntityProvider {

	public BlockAnimation() {
		super(Material.wood);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		return new TileEntityAnimation();
	}

	@Override
	public int getRenderType() {
		return -1;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		TileEntity tile = world.getTileEntity(x, y, z);
		if (tile instanceof TileEntityAnimation) {
			TileEntityAnimation te = (TileEntityAnimation)tile;
			if (world.isRemote) openGui(te);
			//SMTCommon.proxy.openGui(GuiID.ANIMATION_BLOCK, player);
			return true;
		}
		return super.onBlockActivated(world, x, y, z, player, side, hitX, hitY, hitZ);
	}

	@SideOnly(Side.CLIENT)
	private void openGui(TileEntityAnimation te) {
		Minecraft.getMinecraft().displayGuiScreen(new GuiAnimation(te));
	}

	@Override
	public String getRegisterName() {
		return "block_animation";
	}

	@Override
	public void getRegisterItem(final HashMap<String, ItemStack> map) {
		map.put(getRegisterName(), new ItemStack(this));
	}

}
