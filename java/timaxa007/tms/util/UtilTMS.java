package timaxa007.tms.util;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import timaxa007.tms.object.ModifiedBlock;
import timaxa007.tms.object.ModifiedItem;
import timaxa007.tms.object.ModifiedItemArmor;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;

public class UtilTMS {
	public static Minecraft mc = Minecraft.getMinecraft();
	//-----------------------------------------------------------------------------------------------
	public static class UtilBlock {

		public static void RegBlock(Block... blocks) {
			for (Block block : blocks) {
				if (block != null) {
					if (block instanceof ModifiedBlock)
						GameRegistry.registerBlock(block, "block_" + ((ModifiedBlock)block).getTag());
				}
			}
		}

		public static void RegBlock(Block block, Class<? extends ItemBlock> item) {
			if (block != null) {
				if (block instanceof ModifiedBlock)
					GameRegistry.registerBlock(block, item, "block_" + ((ModifiedBlock)block).getTag());
			}
		}

		public static void RegTE(Class<? extends TileEntity>... te) {
			for (Class<? extends TileEntity> tile : te) {
				if (tile != null) {
					String tag = tile.toString();

					if (tag.startsWith("TileEntity")) 
						tag.replaceFirst("^TileEntity*", "tile_entity_").toLowerCase();
					else if (tag.startsWith("TE")) 
						tag.replaceFirst("^TE*", "tile_entity_").toLowerCase();
					else ;

					GameRegistry.registerTileEntity(tile, tag);
				}
			}
		}

	}
	//-----------------------------------------------------------------------------------------------
	public static class UtilItem {

		public static void RegItem(Item... items) {
			for (Item item : items) {
				if (item != null) {
					if (item instanceof ModifiedItem)
						GameRegistry.registerItem(item, "item_" + ((ModifiedItem)item).getTag());
					else if (item instanceof ModifiedItemArmor)
						GameRegistry.registerItem(item, "item_" + ((ModifiedItemArmor)item).getTag());
				}
			}
		}

	}
	//-----------------------------------------------------------------------------------------------
	public static class UtilEntity {

		public static void RegEntity() {

		}

	}
	//-----------------------------------------------------------------------------------------------
	public static class UtilWorld {

		/**Vec3.createVectorHelper(entity.posX, entity.posY, entity.posZ);**/
		public static void dropItem(World world, Vec3 vec3, ItemStack is) {
			dropItem(world, vec3.xCoord, vec3.yCoord, vec3.zCoord, is);
		}

		/* && world.getGameRules().getGameRuleBooleanValue("doTileDrops")*/
		public static void dropItem(World world, int x, int y, int z, ItemStack is) {
			dropItem(world, (double)x + 0.5D, (double)y + 0.5D, (double)z + 0.5D, is);
		}

		public static void dropItem(World world, double x, double y, double z, ItemStack is) {
			if (world != null && is != null) {
				if (!world.isRemote) {
					EntityItem entityitem = new EntityItem(world, x, y, z, is);
					entityitem.delayBeforeCanPickup = 10;
					world.spawnEntityInWorld(entityitem);
				}
			}
		}

	}
	//-----------------------------------------------------------------------------------------------
	public static class LookOBJ {
		//-------------------------------
		public static MovingObjectPosition look() {
			return look(1.0F, false);
		}

		public static MovingObjectPosition look(boolean interact) {
			return look(1.0F, interact);
		}

		public static MovingObjectPosition look(double dist) {
			return look(1.0F, dist, false);
		}

		public static MovingObjectPosition look(double dist, boolean interact) {
			return look(1.0F, dist, interact);
		}

		public static MovingObjectPosition look(float fasc, boolean interact) {
			double dist = (double)mc.playerController.getBlockReachDistance();
			return look(fasc, dist, interact);
		}

		public static MovingObjectPosition look(float fasc, double dist, boolean interact) {
			MovingObjectPosition entity = entity(fasc, dist, interact);
			return ((entity != null && entity.entityHit != null) ? 
					entity(fasc, dist, interact) : block(fasc, dist, interact));
		}
		//-------------------------------
		public static MovingObjectPosition entity() {
			return entity(1.0F, false);
		}

		public static MovingObjectPosition entity(boolean interact) {
			return entity(1.0F, interact);
		}

		public static MovingObjectPosition entity(double dist) {
			return entity(dist, false);
		}

		public static MovingObjectPosition entity(double dist, boolean interact) {
			return entity(1.0F, dist, interact);
		}

		public static MovingObjectPosition entity(float fasc, boolean interact) {
			return entity(fasc, (double)mc.playerController.getBlockReachDistance(), interact);
		}

		public static MovingObjectPosition entity(float fasc, double dist, boolean interact) {
			if (mc.renderViewEntity != null && mc.theWorld != null) {

				Entity pointedEntity = null;
				double d0 = dist;
				MovingObjectPosition objectMouseOver = mc.renderViewEntity.rayTrace(d0, fasc);
				double d1 = d0;
				Vec3 vec3 = mc.renderViewEntity.getPosition(fasc);

				d0 = d1;

				if (objectMouseOver != null) {
					d1 = objectMouseOver.hitVec.distanceTo(vec3);
				}

				Vec3 vec31 = mc.renderViewEntity.getLook(fasc);
				Vec3 vec32 = vec3.addVector(vec31.xCoord * d0, vec31.yCoord * d0, vec31.zCoord * d0);
				pointedEntity = null;
				Vec3 vec33 = null;
				float f1 = 1.0F;
				List list = mc.theWorld.getEntitiesWithinAABBExcludingEntity(mc.renderViewEntity, mc.renderViewEntity.boundingBox.addCoord(vec31.xCoord * d0, vec31.yCoord * d0, vec31.zCoord * d0).expand((double)f1, (double)f1, (double)f1));
				double d2 = d1;

				for (int i = 0; i < list.size(); ++i) {
					Entity entity = (Entity)list.get(i);

					if (entity.canBeCollidedWith() || interact) {
						float f2 = entity.getCollisionBorderSize();
						AxisAlignedBB axisalignedbb = entity.boundingBox.expand((double)f2, (double)f2, (double)f2);
						MovingObjectPosition movingobjectposition = axisalignedbb.calculateIntercept(vec3, vec32);

						if (axisalignedbb.isVecInside(vec3)) {
							if (0.0D < d2 || d2 == 0.0D) {
								pointedEntity = entity;
								vec33 = movingobjectposition == null ? vec3 : movingobjectposition.hitVec;
								d2 = 0.0D;
							}
						}
						else if (movingobjectposition != null) {
							double d3 = vec3.distanceTo(movingobjectposition.hitVec);

							if (d3 < d2 || d2 == 0.0D) {
								if (entity == mc.renderViewEntity.ridingEntity && !entity.canRiderInteract()) {
									if (d2 == 0.0D) {
										pointedEntity = entity;
										vec33 = movingobjectposition.hitVec;
									}
								} else {
									pointedEntity = entity;
									vec33 = movingobjectposition.hitVec;
									d2 = d3;
								}
							}
						}
					}
				}

				return new MovingObjectPosition(pointedEntity, vec33);
			}
			return null;
		}
		//-------------------------------
		public static MovingObjectPosition block() {
			return block(1.0F, false);
		}

		public static MovingObjectPosition block(boolean interact) {
			return block(1.0F, interact);
		}

		public static MovingObjectPosition block(double dist) {
			return block(dist, false);
		}

		public static MovingObjectPosition block(double dist, boolean interact) {
			return block(1.0F, dist, interact);
		}

		public static MovingObjectPosition block(float fasc, boolean interact) {
			return block(fasc, (double)mc.playerController.getBlockReachDistance(), interact);
		}

		public static MovingObjectPosition block(float fasc, double dist, boolean interact) {
			if (mc.renderViewEntity != null && mc.theWorld != null) {

				Vec3 vec3 = mc.renderViewEntity.getPosition(fasc);
				Vec3 vec31 = mc.renderViewEntity.getLook(fasc);
				Vec3 vec32 = vec3.addVector(vec31.xCoord * dist, vec31.yCoord * dist, vec31.zCoord * dist);

				MovingObjectPosition movingobjectposition = mc.theWorld.rayTraceBlocks(vec3, vec32, interact);

				return movingobjectposition;
			}
			return null;
		}
		//-------------------------------
	}
	//-----------------------------------------------------------------------------------------------
	public static String isSide() {
		return (isServerSide() ? "Server" : (isClientSide() ? "Client" : "None"));
	}

	public static boolean isServerSide() {
		return FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER;
	}

	public static boolean isClientSide() {
		return FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT;
	}

	public static World getWorldClient() {
		return FMLClientHandler.instance().getWorldClient();

	}

	public static EntityPlayer getPlayerClient() {
		return FMLClientHandler.instance().getClientPlayerEntity();
	}

	/*public static boolean isGUI(String str) {
		if (!(Minecraft.getMinecraft().currentScreen instanceof GuiScreen)) {//GuiContainer
			return true;
		}
		return false;
	}*/

}
