package smt.pack.magic.client.render.tile;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

import smt.pack.magic.SMTMagic;
import smt.pack.magic.tile.TileEntityTeleport;

public class RenederTileEntityTeleport extends TileEntitySpecialRenderer {

	public static final IModelCustom model = AdvancedModelLoader.loadModel(new ResourceLocation(SMTMagic.MODID, "obj/teleport.obj"));
	public static final ResourceLocation
	texture1 = new ResourceLocation(SMTMagic.MODID, "textures/model/01.png"),
	texture2 = new ResourceLocation(SMTMagic.MODID, "textures/model/02.png")
	;

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float parTick) {
		render((TileEntityTeleport)tile, x, y, z, parTick);
	}

	private void render(TileEntityTeleport tile, double x, double y, double z, float parTick) {
		GL11.glPushMatrix();
		GL11.glTranslated(x, y, z);
		GL11.glTranslatef(0.5F, 0.0F, 0.5F);

		boolean isActive = false;

		if (tile != null) {
			isActive = tile.isActive;
		}

		bindTexture(isActive ? texture2 : texture1);
		model.renderAll();
		GL11.glPopMatrix();
	}

}
