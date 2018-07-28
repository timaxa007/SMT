package smt.pack.common.animation.a3D;

import smt.pack.common.animation.Easing;
import smt.pack.common.animation.IKey;

public final class Animation3DCustom implements IAnimation3D {

	public float time_line;
	public boolean loop;
	public KeyCustom[]
			translateX,
			translateY,
			translateZ,
			rotateX,
			rotateY,
			rotateZ;

	public Animation3DCustom(float time_line, boolean loop,
			KeyCustom[] translateX,
			KeyCustom[] translateY,
			KeyCustom[] translateZ,
			KeyCustom[] rotateX,
			KeyCustom[] rotateY,
			KeyCustom[] rotateZ
			) {
		this.time_line = time_line;
		this.loop = loop;
		this.translateX = translateX;
		this.translateY = translateY;
		this.translateZ = translateZ;
		this.rotateX = rotateX;
		this.rotateY = rotateY;
		this.rotateZ = rotateZ;
	}

	public Animation3D toAnimation() {
		return new Animation3D(time_line, loop,
				toAnimationKey(translateX),
				toAnimationKey(translateY),
				toAnimationKey(translateZ),
				toAnimationKey(rotateX),
				toAnimationKey(rotateY),
				toAnimationKey(rotateZ));
	}

	public Animation3D.Key[] toAnimationKey(KeyCustom[] key) {
		if (key == null) return null;
		Animation3D.Key[] keyF = new Animation3D.Key[key.length];
		for (int i = 0; i < key.length; ++i) keyF[i] = toAnimationKey(key[i]);
		return keyF;
	}

	public Animation3D.Key toAnimationKey(KeyCustom key) {
		if (key == null) return null;
		return new Animation3D.Key(key.getTime(), key.getField());
	}

	@Override
	public float getTimeLine() {
		return time_line;
	}

	@Override
	public boolean isLoop() {
		return loop;
	}

	@Override
	public IKey[] getTranslateX() {
		return translateX;
	}

	@Override
	public IKey[] getTranslateY() {
		return translateY;
	}

	@Override
	public IKey[] getTranslateZ() {
		return translateZ;
	}

	@Override
	public IKey[] getRotateX() {
		return rotateX;
	}

	@Override
	public IKey[] getRotateY() {
		return rotateY;
	}

	@Override
	public IKey[] getRotateZ() {
		return rotateZ;
	}

	public static final class KeyCustom implements IKey {

		public float time, field;
		public Easing ease;

		public KeyCustom(float time, float field) {
			this.time = time;
			this.field = field;
			this.ease = Easing.LINEAR;
		}

		public KeyCustom(float time, float field, Easing easing) {
			this.time = time;
			this.field = field;
			this.ease = easing;
		}

		public Animation3D.Key toKey() {
			return new Animation3D.Key(time, field);
		}

		@Override
		public float getTime() {
			return time;
		}

		@Override
		public float getField() {
			return field;
		}

		@Override
		public Easing getEasing() {
			return ease;
		}

	}

}
