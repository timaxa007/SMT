package smt.pack.common.animation;

import javax.annotation.Nonnull;

import cpw.mods.fml.common.eventhandler.Cancelable;
import cpw.mods.fml.common.eventhandler.Event;

public abstract class EasingEvent extends Event {

	final String key;
	@Nonnull public Easing result;

	public EasingEvent(String key, Easing result) {
		this.key = key;
		this.result = (result == null ? Easing.ERROR : result);
	}

	@Cancelable
	public static final class Pre extends EasingEvent {

		public Pre(String key) {
			super(key, Easing.LINEAR);
		}

	}

	public static final class Post extends EasingEvent {

		public Post(String key, Easing result) {
			super(key, result);
		}

	}

}
