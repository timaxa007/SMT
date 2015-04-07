package timaxa007.tms.util;

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
	public static Minecraft mc = Minecraft.getMinecraft();
	//-----------------------------------------------------------------------------------------------
	public static class UtilBlock {

		public static void RegBlock(Block[] blocks) {
			for (Block block : blocks) RegBlock(block);
		}

		public static void RegBlock(Block block) {
			if (block != null) {
				if (block instanceof ModifiedBlock)
					GameRegistry.registerBlock(block, "block_" + ((ModifiedBlock)block).getTag());
			}
		}

		public static void RegBlock(Block block, Class<? extends ItemBlock> item) {
			if (block != null) {
				if (block instanceof ModifiedBlock)
					GameRegistry.registerBlock(block, item, "block_" + ((ModifiedBlock)block).getTag());
			}
		}

		public static void RegTE(Class<? extends TileEntity> te[]) {
			for (Class<? extends TileEntity> tile : te) RegTE(tile);
		}

		public static void RegTE(Class<? extends TileEntity> te) {
			if (te != null) {
				String tag = te.toString();

				if (tag.startsWith("TileEntity")) 
					tag.replaceFirst("^TileEntity*", "tile_entity_").toLowerCase();
				else if (tag.startsWith("TE")) 
					tag.replaceFirst("^TE*", "tile_entity_").toLowerCase();
				else ;

				GameRegistry.registerTileEntity(te, tag);
			}
		}
	}
	//-----------------------------------------------------------------------------------------------
	public static class UtilItem {

		public static void RegItem(Item[] items) {
			for (Item item : items) RegItem(item);
		}

		public static void RegItem(Item item) {
			if (item != null) {
				if (item instanceof ModifiedItem)
					GameRegistry.registerItem(item, "item_" + ((ModifiedItem)item).getTag());
				else if (item instanceof ModifiedItemArmor)
					GameRegistry.registerItem(item, "item_" + ((ModifiedItemArmor)item).getTag());
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

		public static void dropItem(World world, int x, int y, int z, ItemStack is) {
			if (world != null && is != null) {
				if (!world.isRemote/* && world.getGameRules().getGameRuleBooleanValue("doTileDrops")*/) {
					EntityItem entityitem = new EntityItem(world, (double)x + 0.5D, (double)y + 0.5D, (double)z + 0.5D, is);
					entityitem.delayBeforeCanPickup = 10;
					world.spawnEntityInWorld(entityitem);
				}
			}
		}

	}
	//-----------------------------------------------------------------------------------------------
	public static class LookOBJ {

		private static MovingObjectPosition objectMouseOver;

		public static MovingObjectPosition getMouseOver(float fasc, boolean interact) {
			return getMouseOver(fasc, (double)mc.playerController.getBlockReachDistance(), interact);
		}

		public static MovingObjectPosition getMouseOver(float fasc, double dist, boolean interact) {
			if (mc.renderViewEntity != null) {
				if (mc.theWorld != null) {
					double d0 = dist;
					objectMouseOver = mc.renderViewEntity.rayTrace(d0, fasc);
					Vec3 vec3 = mc.renderViewEntity.getPosition(fasc);

					if (objectMouseOver != null) {
						d0 = objectMouseOver.hitVec.distanceTo(vec3);
					}

					Vec3 vec31 = mc.renderViewEntity.getLook(fasc);
					Vec3 vec32 = vec3.addVector(vec31.xCoord * d0, vec31.yCoord * d0, vec31.zCoord * d0);
					Entity pointedEntity = null;
					Vec3 vec33 = null;
					float f1 = 1.0F;
					List list = mc.theWorld.getEntitiesWithinAABBExcludingEntity(mc.renderViewEntity, mc.renderViewEntity.boundingBox.addCoord(vec31.xCoord * d0, vec31.yCoord * d0, vec31.zCoord * d0).expand((double)f1, (double)f1, (double)f1));

					for (int i = 0; i < list.size(); ++i) {
						Entity entity = (Entity)list.get(i);

						float f2 = entity.getCollisionBorderSize();
						AxisAlignedBB axisalignedbb = entity.boundingBox.expand((double)f2, (double)f2, (double)f2);
						MovingObjectPosition movingobjectposition = axisalignedbb.calculateIntercept(vec3, vec32);

						pointedEntity = entity;
						vec33 = movingobjectposition == null ? vec3 : movingobjectposition.hitVec;
					}

					return new MovingObjectPosition(pointedEntity, vec33);
				}
			}
			return null;
		}

	}
	//-----------------------------------------------------------------------------------------------
	public static boolean isServerSide() {
		return FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER;
	}

	public static boolean isClientSide() {
		return FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT;
	}

	/*public static boolean isGUI(String str) {
		if (!(Minecraft.getMinecraft().currentScreen instanceof GuiScreen)) {//GuiContainer
			return true;
		}
		return false;
	}*/

}
