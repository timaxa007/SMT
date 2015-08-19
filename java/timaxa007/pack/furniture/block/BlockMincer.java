package timaxa007.pack.furniture.block;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import timaxa007.gui.HandlerGui;
import timaxa007.pack.furniture.PackFurniture;
import timaxa007.pack.furniture.tile.TileEntityMincer;
import timaxa007.pack.conjoint.object.ModifiedBlock;

public class BlockMincer extends ModifiedBlock implements ITileEntityProvider {

	public BlockMincer(String tag) {
		super(tag, Material.iron);
		setStepSound(soundTypeMetal);
		setCreativeTab(PackFurniture.tab_furniture);
		setHardness(0.5F);
		setBlockTextureName("iron_block");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {return new TileEntityMincer(world);}

	public int getRenderType() {return PackFurniture.render.block_mincer_modelID;}
	public boolean isOpaqueCube() {return false;}
	public boolean renderAsNormalBlock() {return false;}

	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
		int i1 = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		world.setBlock(x, y, z, this, i1, 3);
		/*if (is.hasDisplayName() {
		((TileEntityMincer)world.getTileEntity(x, y, z)).setGuiDisplayName(is.getDisplayName());
		}*/
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		TileEntity te = world.getTileEntity(x, y, z);
		if (te == null || player.isSneaking()) return false;
		if (te != null && te instanceof TileEntityMincer) {
			HandlerGui.openGui(HandlerGui.GuiID.MINCER, player);
			return true;
		}
		return super.onBlockActivated(world, x, y, z, player, side, hitX, hitY, hitZ);
	}

}
