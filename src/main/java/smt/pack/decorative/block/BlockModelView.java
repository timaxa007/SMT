package smt.pack.decorative.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import smt.pack.decorative.client.gui.GuiModelView;
import smt.pack.decorative.tile.TileEntityModelView;

public class BlockModelView extends Block implements net.minecraft.block.ITileEntityProvider {

	public BlockModelView() {
		super(Material.iron);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		return new TileEntityModelView();
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
		if (!player.capabilities.isCreativeMode) return super.onBlockActivated(world, x, y, z, player, side, hitX, hitY, hitZ);
		TileEntity tile = world.getTileEntity(x, y, z);
		if (tile instanceof TileEntityModelView) {
			TileEntityModelView te = (TileEntityModelView)tile;
			if (!world.isRemote) {
				System.out.println("translate - " + te.translateX + " - " + te.translateY + " - " + te.translateZ);
				System.out.println("rotate - " + te.rotateX + " - " + te.rotateY + " - " + te.rotateZ);
				System.out.println("scale - " + te.scaleX + " - " + te.scaleY + " - " + te.scaleZ);
			} else openGui(te);

			return true;
		}
		return super.onBlockActivated(world, x, y, z, player, side, hitX, hitY, hitZ);
	}

	@SideOnly(Side.CLIENT)
	private void openGui(TileEntityModelView te) {
		Minecraft.getMinecraft().displayGuiScreen(new GuiModelView(te));
	}

}
