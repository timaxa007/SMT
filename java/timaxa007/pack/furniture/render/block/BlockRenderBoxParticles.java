package timaxa007.pack.furniture.render.block;

import timaxa007.pack.furniture.tile.TileEntityBoxParticles;
import timaxa007.tms.lib.AddTextureModel;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

public class BlockRenderBoxParticles extends TileEntitySpecialRenderer {
	private static final IModelCustom model = AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/boxparticle.obj"));

	public BlockRenderBoxParticles() {

	}

	public void renderTileEntityAt(TileEntity te, double dx, double dy, double dz, float f) {
		renderTileEntity((TileEntityBoxParticles)te, dx, dy, dz, f);
	}

	private void renderTileEntity(TileEntityBoxParticles te, double dx, double dy, double dz, float f) {
		String tex = "";
		int rot = 0;

		if (te != null) {
			tex = te.getStyle();
			rot = te.getRot();
		}

		GL11.glPushMatrix();
		GL11.glTranslated(dx, dy, dz);
		GL11.glTranslatef(0.5F, 0.0F, 0.5F);
		GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);

		switch(rot) {
		case 0:GL11.glRotatef(-180F, 0F, 0F, 1F);break;
		case 3:GL11.glRotatef(-90F, 0F, 0F, 1F);break;
		case 2:GL11.glRotatef(0F, 0F, 0F, 1F);break;
		case 1:GL11.glRotatef(90F, 0F, 0F, 1F);break;
		default:GL11.glRotatef(0F, 0F, 0F, 1F);break;
		}

		bindTexture(AddTextureModel.get(tex).getTexture());

		model.renderAll();

		GL11.glPopMatrix();

	}

}
