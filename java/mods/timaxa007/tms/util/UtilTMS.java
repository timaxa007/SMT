package mods.timaxa007.tms.util;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;

public class UtilTMS {

	//Minecraft mc = Minecraft.getMinecraft();

	public static class UtilBlock {

		public static void RegBlock(Block block) {
			GameRegistry.registerBlock(block, block.getUnlocalizedName());
		}

		@Deprecated
		public static void RegBlock(Block block, Class<? extends ItemBlock> item) {
			GameRegistry.registerBlock(block, item, block.getUnlocalizedName());
		}

		@Deprecated
		public static void RegTE(Class<? extends TileEntity> te) {
			GameRegistry.registerTileEntity(te, te.toString());
		}

	}

	public static class UtilItem {

		public static void RegItem(Item item) {
			GameRegistry.registerItem(item, item.getUnlocalizedName());
		}

	}

	public static class UtilEntity {

		public static void RegEntity() {

		}

	}

	public static class UtilWorld {

		public static void dropItem(World world, int x, int y, int z, ItemStack is) {
			if (!world.isRemote/* && world.getGameRules().getGameRuleBooleanValue("doTileDrops")*/) {
				EntityItem entityitem = new EntityItem(world, (double)x + 0.5D, (double)y + 0.5D, (double)z + 0.5D, is);
				entityitem.delayBeforeCanPickup = 10;
				world.spawnEntityInWorld(entityitem);
			}
		}

	}

	public static class LookOBJ {

		public static MovingObjectPosition getEntityDistance() {
			MovingObjectPosition obj_entity = getEntityOBJDistance();
			if (obj_entity != null && obj_entity.typeOfHit == MovingObjectPosition.MovingObjectType.ENTITY && obj_entity.entityHit != null) {
				return getEntityOBJDistance();
			}
			return null;
		}

		public static MovingObjectPosition getEntityOBJDistance() {
			return getEntityOBJDistance(255.0D);
		}

		public static MovingObjectPosition getEntityDistance(double dis) {
			MovingObjectPosition obj_entity = getEntityOBJDistance(dis);
			if (obj_entity != null && obj_entity.typeOfHit == MovingObjectPosition.MovingObjectType.ENTITY && obj_entity.entityHit != null) {
				return getEntityOBJDistance(dis);
			}
			return null;
		}

		public static MovingObjectPosition getEntityOBJDistance(double dis) {
			Minecraft mc = Minecraft.getMinecraft();
			if (mc.theWorld != null) {
				if (mc.renderViewEntity != null) {
					Entity /*mc.*/entity_hit = null;
					double d0 = dis;
					MovingObjectPosition /*mc.*/objectMouseOver = mc.renderViewEntity.rayTrace(dis, 1.0F);
					double d1 = d0;
					Vec3 vec3 = mc.renderViewEntity.getPosition(1.0F);

					d0 = d1;

					if (/*mc.*/objectMouseOver != null) {
						d1 = /*mc.*/objectMouseOver.hitVec.distanceTo(vec3);
					}

					Vec3 vec31 = mc.renderViewEntity.getLook(1.0F);
					Vec3 vec32 = vec3.addVector(vec31.xCoord * d0, vec31.yCoord * d0, vec31.zCoord * d0);
					entity_hit = null;
					Vec3 vec33 = null;
					float f1 = 1.0F;
					List list = mc.theWorld.getEntitiesWithinAABBExcludingEntity(mc.renderViewEntity, mc.renderViewEntity.boundingBox.addCoord(vec31.xCoord * d0, vec31.yCoord * d0, vec31.zCoord * d0).expand((double)f1, (double)f1, (double)f1));
					double d2 = d1;

					for (int i = 0; i < list.size(); ++i) {
						Entity entity = (Entity)list.get(i);

						//if (entity.canBeCollidedWith()) {
						float f2 = entity.getCollisionBorderSize();
						AxisAlignedBB axisalignedbb = entity.boundingBox.expand((double)f2, (double)f2, (double)f2);
						MovingObjectPosition movingobjectposition = axisalignedbb.calculateIntercept(vec3, vec32);
						entity_hit = entity;

						if (axisalignedbb.isVecInside(vec3)) {
							if (0.0D < d2 || d2 == 0.0D) {
								vec33 = movingobjectposition == null ? vec3 : movingobjectposition.hitVec;
								d2 = 0.0D;
							}
						}
						else if (movingobjectposition != null) {
							double d3 = vec3.distanceTo(movingobjectposition.hitVec);
							//if (entity == mc.renderViewEntity.ridingEntity && !entity.canRiderInteract()) {
							vec33 = movingobjectposition.hitVec;
						}
						//}
					}

					return new MovingObjectPosition(entity_hit, vec33);

					/*if (pointedEntity instanceof EntityLivingBase || pointedEntity instanceof EntityItemFrame) {
						mc.pointedEntity = pointedEntity;
					}*/

				}
			}
			return null;
		}

	}

	public static boolean isServerSide() {
		return FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER;
	}

	public static boolean isClientSide() {
		return FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT;
	}

	public static boolean hasString(String str) {
		return str != null && str.length() > 0;
	}

	/*public static boolean isGUI(String str) {
		if (!(Minecraft.getMinecraft().currentScreen instanceof GuiScreen)) {//GuiContainer
			return true;
		}
		return false;
	}*/

}
