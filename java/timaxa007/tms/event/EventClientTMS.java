package timaxa007.tms.event;


public class EventClientTMS {
	//--------------------------------------------------------------------------------------------------------------
	/*@SubscribeEvent
	public void look1(FogDensity e) {
		e.density = 0.025F;
	}*/
	//--------------------------------------------------------------------------------------------------------------
	/*@SubscribeEvent
	public void look2(RenderFogEvent e) {
		if(e.entity.isPotionActive(Potion.damageBoost.id)) {
			float f1 = 5.0F;
			int j = e.entity.getActivePotionEffect(Potion.damageBoost).getDuration();

			if (j < 20) {
				f1 = 5.0F + (e.farPlaneDistance - 5.0F) * (1.0F - (float)j / 20.0F);
			}

			GL11.glFogi(GL11.GL_FOG_MODE, GL11.GL_LINEAR);

			if (e.fogMode < 0) {
				GL11.glFogf(GL11.GL_FOG_START, 0.0F);
				GL11.glFogf(GL11.GL_FOG_END, f1 * 0.8F);
			} else {
				GL11.glFogf(GL11.GL_FOG_START, f1 * 0.25F);
				GL11.glFogf(GL11.GL_FOG_END, f1);
			}

			if (GLContext.getCapabilities().GL_NV_fog_distance) {
				GL11.glFogi(34138, 34139);
			}
		}
	}*/
	//--------------------------------------------------------------------------------------------------------------
	/*@SubscribeEvent
	public void fogDistance(RenderFogEvent e) {
		if(e.entity.worldObj.provider instanceof WorldProviderSurface) {
			float f1 = e.farPlaneDistance;

			if (e.fogMode < 0) {
				GL11.glFogf(GL11.GL_FOG_START, f1);
				GL11.glFogf(GL11.GL_FOG_END, f1);
			} else {
				GL11.glFogf(GL11.GL_FOG_START, 2.0F);
				GL11.glFogf(GL11.GL_FOG_END, 5.0F);
			}

		}
	}*/
	//--------------------------------------------------------------------------------------------------------------
}
