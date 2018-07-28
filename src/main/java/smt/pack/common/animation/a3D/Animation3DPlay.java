package smt.pack.common.animation.a3D;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import smt.pack.common.animation.AnimationManager;
import smt.pack.common.animation.Easing;
import smt.pack.common.animation.IKey;

public class Animation3DPlay {

	public IAnimation3D animation;
	public int
	translateX_id,
	translateY_id,
	translateZ_id,
	rotateX_id,
	rotateY_id,
	rotateZ_id;
	public float
	time,
	speed = 1F,
	translateX,
	translateY,
	translateZ,
	rotateX,
	rotateY,
	rotateZ,
	lastTickTranslateX,
	lastTickTranslateY,
	lastTickTranslateZ,
	lastTickRotateX,
	lastTickRotateY,
	lastTickRotateZ;
	public boolean pause;

	public Animation3DPlay(IAnimation3D animation) {
		if (animation == null) return;
		this.animation = animation;
		time = 0F;
		start();
	}

	private void start() {
		translateX_id = 0;
		translateY_id = 0;
		translateZ_id = 0;
		rotateX_id = 0;
		rotateY_id = 0;
		rotateZ_id = 0;
	}

	public void update() {
		if (animation == null) return;

		if (time >= animation.getTimeLine()) {
			time = animation.getTimeLine();
			if (animation.isLoop()) {
				time = -1F;
				start();
			} else {
				pause = true;
			}
		}

		if (time <= animation.getTimeLine()) {

			if (animation.getTranslateX() != null) {
				if (translateX_id + 1 < animation.getTranslateX().length)
					if (animation.getTranslateX()[translateX_id + 1].getTime() <= time)
						++translateX_id;
				lastTickTranslateX = translateX;
				translateX = get(animation.getTranslateX(), translateX_id);
			}

			if (animation.getTranslateY() != null) {
				if (translateY_id + 1 < animation.getTranslateY().length)
					if (animation.getTranslateY()[translateY_id + 1].getTime() <= time)
						++translateY_id;
				lastTickTranslateY = translateY;
				translateY = get(animation.getTranslateY(), translateY_id);
			}

			if (animation.getTranslateZ() != null) {
				if (translateZ_id + 1 < animation.getTranslateZ().length)
					if (animation.getTranslateZ()[translateZ_id + 1].getTime() <= time)
						++translateZ_id;
				lastTickTranslateZ = translateZ;
				translateZ = get(animation.getTranslateZ(), translateZ_id);
			}

			if (animation.getRotateX() != null) {
				if (rotateX_id + 1 < animation.getRotateX().length)
					if (animation.getRotateX()[rotateX_id + 1].getTime() <= time)
						++rotateX_id;
				lastTickRotateX = rotateX;
				rotateX = get(animation.getRotateX(), rotateX_id);
			}

			if (animation.getRotateY() != null) {
				if (rotateY_id + 1 < animation.getRotateY().length)
					if (animation.getRotateY()[rotateY_id + 1].getTime() <= time)
						++rotateY_id;
				lastTickRotateY = rotateY;
				rotateY = get(animation.getRotateY(), rotateY_id);
			}

			if (animation.getRotateZ() != null) {
				if (rotateZ_id + 1 < animation.getRotateZ().length)
					if (animation.getRotateZ()[rotateZ_id + 1].getTime() <= time)
						++rotateZ_id;
				lastTickRotateZ = rotateZ;
				rotateZ = get(animation.getRotateZ(), rotateZ_id);
			}

			if (!pause) time += speed;

		}

	}

	public float get(IKey[] keys, int id) {
		if (keys == null || keys.length <= 0) return 0F;
		if (keys.length == 1) return keys[0].getField();
		if (id + 1 < keys.length) {
			float j = keys[id + 1].getTime() - keys[id].getTime();
			float k = keys[id + 1].getField() - keys[id].getField();
			float l = time - keys[id].getTime();
			return keys[id].getField() + k * Easing.function(keys[id].getEasing(), l / j);
		} else return keys[id].getField();
	}
	/*
	public float get(IKey[] keys, int id) {
		if (keys == null || keys.length <= 0) return 0F;
		if (keys.length == 1) return keys[0].getField();
		if (id + 1 < keys.length) {
			float j = keys[id + 1].getTime() - keys[id].getTime();
			float k = keys[id + 1].getField() - keys[id].getField();
			float l = time - keys[id].getTime();
			float h = (k / j) * l;
			return keys[id].getField() + h;
		} else return keys[id].getField();
	}
	 */
	@SideOnly(Side.CLIENT)
	public void render() {
		render(AnimationManager.parTick);
	}

	@SideOnly(Side.CLIENT)
	public void render(float parTick) {
		if (animation == null) return;
		//if (pause || Minecraft.getMinecraft().isGamePaused()) parTick = 1F;
		GL11.glTranslatef(
				animation.getTranslateX() == null ? 0F : (lastTickTranslateX + (translateX - lastTickTranslateX) * parTick),
				animation.getTranslateY() == null ? 0F : (lastTickTranslateY + (translateY - lastTickTranslateY) * parTick),
				animation.getTranslateZ() == null ? 0F : (lastTickTranslateZ + (translateZ - lastTickTranslateZ) * parTick)
				);
		if (animation.getRotateX() != null) GL11.glRotatef((lastTickRotateX + (rotateX - lastTickRotateX) * parTick), 1, 0, 0);
		if (animation.getRotateY() != null) GL11.glRotatef((lastTickRotateY + (rotateY - lastTickRotateY) * parTick), 0, 1, 0);
		if (animation.getRotateZ() != null) GL11.glRotatef((lastTickRotateZ + (rotateZ - lastTickRotateZ) * parTick), 0, 0, 1);
	}

}
