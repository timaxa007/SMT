package timaxa007.pack.stock.render.entity;

import timaxa007.pack.stock.entity.EntityTest;
import timaxa007.pack.stock.render.model.ModelEntityTest;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderEntityTest extends RenderBiped {

	private static final ResourceLocation zombieTextures = new ResourceLocation("textures/entity/zombie/zombie.png");
	private ModelEntityTest field_82434_o = new ModelEntityTest();
	private int field_82431_q = 1;
	private static final String __OBFID = "CL_00001037";

	public RenderEntityTest() {
		super(new ModelEntityTest(), 0.5F, 1.0F);
	}

	/**
	 * Queries whether should render the specified pass or not.
	 */
	public int shouldRenderPass(EntityTest entity, int p_77032_2_, float p_77032_3_) {
		func_82427_a(entity);
		return super.shouldRenderPass((EntityLiving)entity, p_77032_2_, p_77032_3_);
	}

	/**
	 * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
	 * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
	 * (Render<T extends Entity) and this method has signature public void func_76986_a(T entity, double d, double d1,
	 * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
	 */
	public void doRender(EntityTest entity, double dx, double dy, double dz, float f1, float f2) {
		func_82427_a(entity);
		super.doRender((EntityLiving)entity, dx, dy, dz, f1, f2);
	}

	/**
	 * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
	 */
	public ResourceLocation getEntityTexture(EntityTest entity) {
		return zombieTextures;
	}

	public void renderEquippedItems(EntityTest entity, float f1) {
		func_82427_a(entity);
		super.renderEquippedItems((EntityLiving)entity, f1);
	}

	private void func_82427_a(EntityTest entity) {
		mainModel = field_82434_o;

		modelBipedMain = (ModelBiped)mainModel;
	}

	public void renderEquippedItems(EntityLiving entity, float f1) {
		renderEquippedItems((EntityTest)entity, f1);
	}

	/**
	 * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
	 */
	public ResourceLocation getEntityTexture(EntityLiving entity) {
		return getEntityTexture((EntityTest)entity);
	}

	/**
	 * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
	 * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
	 * (Render<T extends Entity) and this method has signature public void func_76986_a(T entity, double d, double d1,
	 * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
	 */
	public void doRender(EntityLiving entity, double dx, double dy, double dz, float f1, float f2) {
		doRender((EntityTest)entity, dx, dy, dz, f1, f2);
	}

	/**
	 * Queries whether should render the specified pass or not.
	 */
	public int shouldRenderPass(EntityLiving entity, int p_77032_2_, float p_77032_3_) {
		return shouldRenderPass((EntityTest)entity, p_77032_2_, p_77032_3_);
	}

	/**
	 * Queries whether should render the specified pass or not.
	 */
	public int shouldRenderPass(EntityLivingBase entity, int p_77032_2_, float p_77032_3_) {
		return shouldRenderPass((EntityTest)entity, p_77032_2_, p_77032_3_);
	}

	public void renderEquippedItems(EntityLivingBase entity, float f1) {
		renderEquippedItems((EntityTest)entity, f1);
	}

	/**
	 * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
	 * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
	 * (Render<T extends Entity) and this method has signature public void func_76986_a(T entity, double d, double d1,
	 * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
	 */
	public void doRender(EntityLivingBase entity, double dx, double dy, double dz, float f1, float f2) {
		doRender((EntityTest)entity, dx, dy, dz, f1, f2);
	}

	/**
	 * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
	 */
	public ResourceLocation getEntityTexture(Entity entity) {
		return getEntityTexture((EntityTest)entity);
	}

	/**
	 * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
	 * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
	 * (Render<T extends Entity) and this method has signature public void func_76986_a(T entity, double d, double d1,
	 * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
	 */
	public void doRender(Entity entity, double dx, double dy, double dz, float f1, float f2) {
		doRender((EntityTest)entity, dx, dy, dz, f1, f2);
	}
}