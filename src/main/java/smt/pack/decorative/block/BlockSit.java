package smt.pack.decorative.block;

import java.util.Iterator;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import smt.pack.decorative.SMTDecorative;
import smt.pack.decorative.entity.EntitySit;
import smt.pack.decorative.network.MessageSyncSit;
import smt.pack.decorative.tile.TileEntitySit;

public class BlockSit extends Block implements ITileEntityProvider {

	public BlockSit() {
		super(Material.circuits);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		return new TileEntitySit();
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
		//boolean canSit = true;
		if (!world.isRemote) {
			AxisAlignedBB aabb = getCollisionBoundingBoxFromPool(world, x, y, z);
			List list = world.getEntitiesWithinAABB(Entity.class, aabb);
			Iterator iterator = list.iterator();
			Entity entity = null;
			while(iterator.hasNext()) {
				entity = (Entity)iterator.next();
				if (entity instanceof EntityPlayer && entity != player) {
					EntityPlayer ep = (EntityPlayer)entity;
					//if (player.worldObj.isRemote) {
					if (ep.getDisplayName().length() > 0)
						player.addChatMessage(new ChatComponentText("Игрок " + ep.getDisplayName() + " мешает сесть."));
					else
						player.addChatMessage(new ChatComponentText("Какой-то игрок мешает сесть."));
					//}
					//return true;
				}
				else if (entity instanceof EntityLivingBase && !(entity instanceof EntityPlayer)) {
					EntityLivingBase el = (EntityLivingBase)entity;
					//if (player.worldObj.isRemote) {
					if (el.getCommandSenderName().length() > 0)
						player.addChatMessage(new ChatComponentText("Моб " + el.getCommandSenderName() + " мешает сесть."));
					else
						player.addChatMessage(new ChatComponentText("Какой-то моб мешает сесть."));
					//}
					//return true;
				}
				/*
			else if (entity instanceof EntityItem) {
				EntityItem ei = (EntityItem)entity;
			}
				 */
				else {
					if (player.worldObj.isRemote) player.addChatMessage(new ChatComponentText("Что-то мешает сесть."));
					//return true;
				}
			}

			if (entity == null) {
				EntitySit sit = new EntitySit(world);
				sit.setPosition((double)x + 0.5D, (double)y + 0.5D, (double)z + 0.5D);
				world.spawnEntityInWorld(sit);
				player.mountEntity(sit);
				SMTDecorative.network.sendToDimension(new MessageSyncSit(player, sit), world.provider.dimensionId);
			}
		}
		return true;
		//return super.onBlockActivated(world, x, y, z, player, side, hitX, hitY, hitZ);
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemStack) {
		int l = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		world.setBlockMetadataWithNotify(x, y, z, l, 2);
	}

	@Override
	public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB aabb, List list, Entity entity) {

		float f = 0.125F;

		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.3125F, 1.0F);
		super.addCollisionBoxesToList(world, x, y, z, aabb, list, entity);

		setBlockBounds(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
		super.addCollisionBoxesToList(world, x, y, z, aabb, list, entity);

		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
		super.addCollisionBoxesToList(world, x, y, z, aabb, list, entity);

		setBlockBounds(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		super.addCollisionBoxesToList(world, x, y, z, aabb, list, entity);

		setBlockBounds(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
		super.addCollisionBoxesToList(world, x, y, z, aabb, list, entity);

		setBlockBoundsForItemRender();
	}

	@Override
	public void setBlockBoundsForItemRender() {
		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}

}
