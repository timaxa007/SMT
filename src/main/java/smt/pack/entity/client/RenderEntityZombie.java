package smt.pack.entity.client;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderEntityZombie extends RenderBiped {

	public RenderEntityZombie() {
		super(new ModelBiped(), 0.5F);
	}

	private static final ResourceLocation textureLocation = new ResourceLocation("textures/entity/test.png");

	public ResourceLocation getEntityTexture(EntityLiving entity) {
		return textureLocation ;
	}

}
