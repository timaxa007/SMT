package smt.pack.common.animation;

import net.minecraftforge.common.MinecraftForge;

//https://github.com/component/ease/blob/master/index.js
public enum Easing {

	LINEAR,
	IN_OUAD,
	OUT_OUAD,
	IN_OUT_OUAD,
	IN_CUBE,
	OUT_CUBE,
	IN_OUT_CUBE,
	IN_QUART,
	OUT_QUART,
	IN_OUT_QUART,
	IN_QUINT,
	OUT_QUINT,
	IN_OUT_QUINT,
	IN_SINE,
	OUT_SINE,
	IN_OUT_SINE,
	IN_EXPO,
	OUT_EXPO,
	IN_OUT_EXPO,
	IN_CIRC,
	OUT_CIRC,
	IN_OUT_CIRC,
	IN_BACK,
	OUT_BACK,
	IN_OUT_BACK,
	IN_BOUNCE,
	OUT_BOUNCE,
	IN_OUT_BOUNCE,
	IN_ELASTIC,
	OUT_ELASTIC,
	IN_OUT_ELASTIC,
	ERROR;

	public static final float function(Easing ease, float n) {
		switch(ease) {
		case LINEAR:
			return n;
		case IN_OUAD:
			return n * n;
		case OUT_OUAD:
			return n * (2F - n);
		case IN_OUT_OUAD:
			n *= 2F;
			if (n < 1F) return 0.5F * n * n;
			return - 0.5F * (--n * (n - 2F) - 1F);
		case IN_CUBE:
			return n * n * n;
		case OUT_CUBE:
			return --n * n * n + 1F;
		case IN_OUT_CUBE:
			n *= 2F;
			if (n < 1F) return 0.5F * n * n * n;
			return 0.5F * ((n -= 2F) * n * n + 2F);
		case IN_QUART:
			return n * n * n * n;
		case OUT_QUART:
			return 1F - (--n * n * n * n);
		case IN_OUT_QUART:
			n *= 2F;
			if (n < 1F) return 0.5F * n * n * n * n;
			return -0.5F * ((n -= 2F) * n * n * n - 2F);
		case IN_QUINT:
			return n * n * n * n * n;
		case OUT_QUINT:
			return --n * n * n * n * n + 1F;
		case IN_OUT_QUINT:
			n *= 2F;
			if (n < 1F) return 0.5F * n * n * n * n * n;
			return 0.5F * ((n -= 2F) * n * n * n * n + 2F);
		case IN_SINE:
			return 1F - (float)Math.cos(n * Math.PI / 2D);
		case OUT_SINE:
			return (float)Math.sin(n * Math.PI / 2D);
		case IN_OUT_SINE:
			return .5F * (1F - (float)Math.cos(Math.PI * n));
		case IN_EXPO:
			return 0F == n ? 0F : (float)Math.pow(1024, n - 1);
		case OUT_EXPO:
			return 1 == n ? n : 1 - (float)Math.pow(2, -10 * n);
		case IN_OUT_EXPO:
			if (n == 0F) return 0F;
			if (n == 1F) return 1F;
			if ((n *= 2F) < 1) return .5F * (float)Math.pow(1024, n - 1);
			return .5F * (-(float)Math.pow(2, -10 * (n - 1)) + 2);
		case IN_CIRC:
			return 1F - (float)Math.sqrt(1D - n * n);
		case OUT_CIRC:
			return (float)Math.sqrt(1F - (--n * n));
		case IN_OUT_CIRC:
			n *= 2F;
			if (n < 1F) return -0.5F * ((float)Math.sqrt(1D - n * n) - 1F);
			return 0.5F * ((float)Math.sqrt(1 - (n -= 2) * n) + 1F);
		case IN_BACK:{
			float s = 1.70158F;
			return n * n * ((s + 1F) * n - s);
		}
		case OUT_BACK:{
			float s = 1.70158F;
			return --n * n * ((s + 1F) * n + s) + 1F;
		}
		case IN_OUT_BACK:{
			float s = 1.70158F * 1.525F;
			if ((n *= 2F) < 1F) return 0.5F * (n * n * ((s + 1F) * n - s));
			return 0.5F * ((n -= 2F) * n * ((s + 1F) * n + s) + 2F);
		}
		case IN_BOUNCE:
			return 1F - function(Easing.OUT_BOUNCE, 1F - n);
		case OUT_BOUNCE:
			if (n < (1F / 2.75F)) {
				return 7.5625F * n * n;
			} else if (n < (2F / 2.75F)) {
				return 7.5625F * (n -= (1.5 / 2.75F)) * n + 0.75F;
			} else if (n < (2.5F / 2.75F)) {
				return 7.5625F * (n -= (2.25F / 2.75F)) * n + 0.9375F;
			} else {
				return 7.5625F * (n -= (2.625F / 2.75F)) * n + 0.984375F;
			}
		case IN_OUT_BOUNCE:
			if (n < .5F) return function(Easing.IN_BOUNCE, n * 2F) * .5F;
			return function(Easing.OUT_BOUNCE, n * 2F - 1F) * .5F + .5F;
		case IN_ELASTIC:{
			float s, a = 0.1F, p = 0.4F;
			if (n == 0F) return 0F;
			if (n == 1F) return 1F;
			if (a < 1) {a = 1; s = p / 4F;}
			else s = (float)(p * Math.asin(1F / a) / (2F * Math.PI));
			return (float) - (a * Math.pow(2, 10 * (n -= 1)) * Math.sin((n - s) * (2 * Math.PI) / p));
		}
		case OUT_ELASTIC:{
			float s, a = 0.1F, p = 0.4F;
			if (n == 0F) return 0F;
			if (n == 1F) return 1F;
			if (a < 1) { a = 1; s = p / 4; }
			else s = (float) (p * Math.asin(1 / a) / (2F * Math.PI));
			return (float) (a * Math.pow(2, - 10 * n) * Math.sin((n - s) * (2 * Math.PI) / p) + 1);
		}
		case IN_OUT_ELASTIC:{
			float s, a = 0.1F, p = 0.4F;
			if (n == 0F) return 0F;
			if (n == 1F) return 1F;
			if (a < 1) { a = 1; s = p / 4; }
			else s = (float) (p * Math.asin(1 / a) / (2 * Math.PI));
			if ((n *= 2) < 1) return (float) (- 0.5 * (a * Math.pow(2, 10 * (n -= 1)) * Math.sin((n - s) * (2 * Math.PI) / p)));
			return (float) (a * Math.pow(2, -10 * (n -= 1)) * Math.sin((n - s) * (2 * Math.PI) / p) * 0.5 + 1);
		}
		default:return -1F;
		}
	}

	public static final Easing getEasing(String key) {
		EasingEvent event = new EasingEvent.Pre(key);
		MinecraftForge.EVENT_BUS.post(event);
		if (event.isCanceled()) return event.result;

		Easing result;
		if (key.equals("IN_OUAD") || key.equals("inOuad")) result = IN_OUAD;
		else if (key.equals("OUT_OUAD") || key.equals("outOuad")) result = OUT_OUAD;
		else if (key.equals("IN_OUT_OUAD") || key.equals("inOutOuad")) result = IN_OUT_OUAD;
		else if (key.equals("IN_CUBE") || key.equals("inCube")) result = IN_CUBE;
		else if (key.equals("OUT_CUBE") || key.equals("outCube")) result = OUT_CUBE;
		else if (key.equals("IN_OUT_CUBE") || key.equals("inOutCube")) result = IN_OUT_CUBE;
		else if (key.equals("IN_QUART") || key.equals("inQuart")) result = IN_QUART;
		else if (key.equals("OUT_QUART") || key.equals("outQuart")) result = OUT_QUART;
		else if (key.equals("IN_OUT_QUART") || key.equals("inOutQuart")) result = IN_OUT_QUART;
		else if (key.equals("IN_QUINT") || key.equals("inQuint")) result = IN_QUINT;
		else if (key.equals("OUT_QUINT") || key.equals("outQuint")) result = OUT_QUINT;
		else if (key.equals("IN_OUT_QUINT") || key.equals("inOutQuint")) result = IN_OUT_QUINT;
		else if (key.equals("IN_SINE") || key.equals("inSine")) result = IN_SINE;
		else if (key.equals("OUT_SINE") || key.equals("outSine")) result = OUT_SINE;
		else if (key.equals("IN_OUT_SINE") || key.equals("inOutSine")) result = IN_OUT_SINE;
		else if (key.equals("IN_EXPO") || key.equals("inExpo")) result = IN_EXPO;
		else if (key.equals("OUT_EXPO") || key.equals("outExpo")) result = OUT_EXPO;
		else if (key.equals("IN_OUT_EXPO") || key.equals("inOutExpo")) result = IN_OUT_EXPO;
		else if (key.equals("IN_CIRC") || key.equals("inCirc")) result = IN_CIRC;
		else if (key.equals("OUT_CIRC") || key.equals("outCirc")) result = OUT_CIRC;
		else if (key.equals("IN_OUT_CIRC") || key.equals("inOutCirc")) result = IN_OUT_CIRC;
		else if (key.equals("IN_BACK") || key.equals("inBack")) result = IN_BACK;
		else if (key.equals("OUT_BACK") || key.equals("outBack")) result = OUT_BACK;
		else if (key.equals("IN_OUT_BACK") || key.equals("inOutBack")) result = IN_OUT_BACK;
		else if (key.equals("IN_BOUNCE") || key.equals("inBounce")) result = IN_BOUNCE;
		else if (key.equals("OUT_BOUNCE") || key.equals("outBounce")) result = OUT_BOUNCE;
		else if (key.equals("IN_OUT_BOUNCE") || key.equals("inOutBounce")) result = IN_OUT_BOUNCE;
		else if (key.equals("IN_ELASTIC") || key.equals("inElastic")) result = IN_ELASTIC;
		else if (key.equals("OUT_ELASTIC") || key.equals("outElastic")) result = OUT_ELASTIC;
		else if (key.equals("IN_OUT_ELASTIC") || key.equals("inOutElastic")) result = IN_OUT_ELASTIC;
		else result = LINEAR;

		event = new EasingEvent.Post(key, result);
		MinecraftForge.EVENT_BUS.post(event);
		return event.result;
	}

}
