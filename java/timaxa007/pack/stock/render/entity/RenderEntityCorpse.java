package timaxa007.pack.stock.render.entity;

import net.minecraft.client.renderer.entity.RenderEntity;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import timaxa007.pack.conjoint.lib.AddTextureModel;
import timaxa007.pack.stock.entity.EntityCorpse;
import timaxa007.pack.stock.render.model.ModelEntityCorpse;


public class RenderEntityCorpse extends RenderEntity {
	
	private static final ModelEntityCorpse model = new ModelEntityCorpse();

	public RenderEntityCorpse() {

	}

	@Override
	public void doRender(Entity entity, double dx, double dy, double dz, float f1, float f2) {
		doRenderEntityCorpse((EntityCorpse)entity, dx, dy, dz, f1, f2);
	}

	private void doRenderEntityCorpse(EntityCorpse entity, double dx, double dy, double dz, float f1, float f2) {
		model.render(entity, 0.001F, 0.001F, 0.001F, 0.001F, 0.001F, 0.001F);
	}

	@Override
	public ResourceLocation getEntityTexture(Entity entity) {
		return AddTextureModel.get("minecraft_planks_oak").getTexture();
	}
}
