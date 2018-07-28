package smt.pack.common.animation.a3D;

import smt.pack.common.animation.Easing;
import smt.pack.common.animation.IKey;

public final class Animation3D implements IAnimation3D {

	private final float time_line;
	private final boolean loop;
	private final Key[]
			translateX_line,
			translateY_line,
			translateZ_line,
			rotateX_line,
			rotateY_line,
			rotateZ_line;

	public Animation3D(final float time_line, final boolean loop,
			final Key[] translateX_line,
			final Key[] translateY_line,
			final Key[] translateZ_line,
			final Key[] rotateX_line,
			final Key[] rotateY_line,
			final Key[] rotateZ_line
			) {
		this.time_line = time_line;
		this.loop = loop;
		this.translateX_line = translateX_line;
		this.translateY_line = translateY_line;
		this.translateZ_line = translateZ_line;
		this.rotateX_line = rotateX_line;
		this.rotateY_line = rotateY_line;
		this.rotateZ_line = rotateZ_line;
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
		return translateX_line;
	}

	@Override
	public IKey[] getTranslateY() {
		return translateY_line;
	}

	@Override
	public IKey[] getTranslateZ() {
		return translateZ_line;
	}

	@Override
	public IKey[] getRotateX() {
		return rotateX_line;
	}

	@Override
	public IKey[] getRotateY() {
		return rotateY_line;
	}

	@Override
	public IKey[] getRotateZ() {
		return rotateZ_line;
	}

	public static final class Key implements IKey {

		private final float time, field;
		public final Easing ease;

		public Key(final float time, final float field) {
			this.time = time;
			this.field = field;
			this.ease = Easing.LINEAR;
		}

		public Key(final float time, final float field, final Easing easing) {
			this.time = time;
			this.field = field;
			this.ease = easing;
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
