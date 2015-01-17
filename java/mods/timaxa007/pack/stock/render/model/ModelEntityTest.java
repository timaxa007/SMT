package mods.timaxa007.pack.stock.render.model;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class ModelEntityTest extends ModelBiped {
	
	private static final IModelCustom model = AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/stuff.obj"));

	public ModelEntityTest(float f, boolean b) {
	}

	public ModelEntityTest() {
	}

	public void render(Entity p_78088_1_, float f1, float f2, float f3, float f4, float f5, float f6) {
        GL11.glPushMatrix();
        model.renderAll();;
        GL11.glPopMatrix();
	}

}
