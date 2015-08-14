package timaxa007.pack.techno.render.entity;

import timaxa007.pack.conjoint.lib.AddTextureModel;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderEntityElectricRobot extends RenderLiving {

	public RenderEntityElectricRobot(ModelBase model, float f) {
		super(model, f);
		shadowSize = 0.5F;
	}

	@Override
	public ResourceLocation getEntityTexture(Entity entity) {
		return AddTextureModel.get("minecraft_planks_oak").getTexture();
	}

}
