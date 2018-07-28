package smt.pack.common.client.render.entity;

import java.lang.reflect.InvocationTargetException;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import smt.pack.common.entity.EntityCorpse;

public class RenderEntityCorpse extends Render {

	public RenderManager renderManager = RenderManager.instance;
	Entity entityForRender = null;
	NBTTagCompound corpse_nbt = null;

	@Override
	public void doRender(Entity entity, double x, double y, double z, float yaw, float tick) {

		GL11.glPushMatrix();
		GL11.glTranslated(x, y, z);
		if (entity instanceof EntityCorpse) {
			EntityCorpse corpse = (EntityCorpse)entity;
			if (corpse.corpse_class != null) {
				if (corpse_nbt == null || corpse.corpse_nbt != corpse_nbt) {
					corpse_nbt = corpse.corpse_nbt;
					Class clazz = null;
					try {
						clazz = Class.forName(corpse.corpse_class);

							try {
								entityForRender = (Entity)clazz.getConstructor(new Class[] {World.class}).newInstance(new Object[] {entity.worldObj});
							}
							catch (InstantiationException e) {e.printStackTrace();}
							catch (IllegalAccessException e) {e.printStackTrace();}
							catch (IllegalArgumentException e) {e.printStackTrace();}
							catch (InvocationTargetException e) {e.printStackTrace();}
							catch (NoSuchMethodException e) {e.printStackTrace();}
							catch (SecurityException e) {e.printStackTrace();}

					} catch (ClassNotFoundException e1) {e1.printStackTrace();}

					if (entityForRender != null) {
						corpse.corpse_nbt.setShort("HurtTime", (short)0);
						entityForRender.readFromNBT(corpse.corpse_nbt);
					}
				}
				if (entityForRender != null) {
					renderManager.renderEntityWithPosYaw(entityForRender, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
				}
			}
		}
		GL11.glPopMatrix();

	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return null;
	}

}
