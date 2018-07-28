package smt.pack.common.block;

import java.util.HashMap;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import smt.pack.common.SMTCommon;
import smt.pack.common.client.render.ListRender;
import smt.pack.common.tile.TileEntityCommonTest;

public class BlockBlocksCommon extends Block implements smt.pack.common.api.IRegisterItem, net.minecraft.block.ITileEntityProvider {

	public BlockBlocksCommon() {
		super(Material.wood);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		return new TileEntityCommonTest();
	}

	@Override
	public int getRenderType() {
		return ListRender.block_blocks_common_renderID;
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
		if (tile instanceof TileEntityCommonTest) {
			TileEntityCommonTest te = (TileEntityCommonTest)tile;
			ItemStack displayItem = te.getDisplayItem();
			if (displayItem == null) {
				ItemStack current = player.getCurrentEquippedItem();
				if (current != null) {
					te.setDisplayItem(current);
					//world.setBlockMetadataWithNotify(x, y, z, current.getItem().getMetadata(current.getItemDamage()), 3);
				}
			} else {
				dropBlockAsItem(world, x, y, z, displayItem);
				te.setDisplayItem(null);
				//world.setBlockMetadataWithNotify(x, y, z, 0, 3);
			}
			return true;
		}
		return super.onBlockActivated(world, x, y, z, player, side, hitX, hitY, hitZ);
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
		float f = 0.125F;
		return AxisAlignedBB.getBoundingBox((double)x, (double)y, (double)z, (double)(x + 1), (double)((float)(y + 1) - f), (double)(z + 1));
	}

	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
		if (!world.isRemote && entity instanceof EntityPlayer) {
			MinecraftServer.getServer().getCommandManager().executeCommand(MinecraftServer.getServer(), "spawnpoint " + ((EntityPlayer)entity).getCommandSenderName());
			//MinecraftServer.getServer().getCommandManager().executeCommand((EntityPlayer)entity, "heal");
		}
	}

	@Override
	public String getRegisterName() {
		return "block_blocks_common";
	}

	@Override
	public void getRegisterItem(final HashMap<String, ItemStack> map) {
		map.put(getRegisterName(), new ItemStack(this));
	}

}
