package smt.pack.common.animation;

public enum EasingOld {

	LINEAR,
	IN_OUT_CUBIC,
	IN_OUT_QUINTIC,
	IN_QUINTIC,
	IN_QUARTIC,
	IN_CUBIC,
	IN_QUADRATIC,
	OUT_QUINTIC,
	OUT_QUARTIC,
	OUT_CUBIC,
	OUT_IN_CUBIC,
	OUT_IN_QUARTIC,
	BACK_IN_CUBIC,
	BACK_IN_QUARTIC,
	OUT_BACK_CUBIC,
	OUT_BACK_QUARTIC,
	OUT_ELASTIC_SMALL,
	OUT_ELASTIC_BIG,
	IN_ELASTIC_SMALL,
	IN_ELASTIC_BIG,
	ERROR;

	/**
	t - is the current time - текущее время<br/>
	d - is the total motion duration - общая длительность движения
	**/
	public static float function(EasingOld ease, float t, float d) {
		switch(ease) {
		case LINEAR:
			return t /= d;
		case IN_OUT_CUBIC:{
			float ts = (t /= d) * t;
			float tc = ts * t;
			return -2 * tc + 3 * ts;
		}
		case IN_OUT_QUINTIC:{
			float ts = (t /= d) * t;
			float tc = ts * t;
			return 6 * tc * ts + -15 * ts * ts + 10 * tc;
		}
		case IN_QUINTIC:{
			float ts = (t /= d) * t;
			float tc = ts * t;
			return tc * ts;
		}
		case IN_QUARTIC:{
			float ts = (t /= d) * t;
			return ts * ts;
		}
		case IN_CUBIC:{
			return (t /= d) * t * t;
		}
		case IN_QUADRATIC:{
			return (t /= d) * t;
		}
		case OUT_QUINTIC:{
			float ts = (t /= d) * t;
			float tc = ts * t;
			return tc * ts + -5 * ts * ts + 10 * tc + -10 * ts + 5 * t;
		}
		case OUT_QUARTIC:{
			float ts = (t /= d) * t;
			float tc = ts * t;
			return -1 * ts * ts + 4 * tc + -6 * ts + 4 * t;
		}
		case OUT_CUBIC:{
			float ts = (t /= d) * t;
			float tc = ts * t;
			return tc + -3 * ts + 3 * t;
		}
		case OUT_IN_CUBIC:{
			float ts = (t /= d) * t;
			float tc = ts * t;
			return 4 * tc + -6 * ts + 3 * t;
		}
		case OUT_IN_QUARTIC:{
			float ts = (t /= d) * t;
			float tc = ts * t;
			return 6 * tc + -9 * ts + 4 * t;
		}
		case BACK_IN_CUBIC:{
			float ts = (t /= d) * t;
			float tc = ts * t;
			return 4 * tc + -3 * ts;
		}
		case BACK_IN_QUARTIC:{
			float ts = (t /= d) * t;
			float tc = ts * t;
			return 2 * ts * ts + 2 * tc + -3 * ts;
		}
		case OUT_BACK_CUBIC:{
			float ts = (t /= d) * t;
			float tc = ts * t;
			return 4 * tc + -9 * ts + 6 * t;
		}
		case OUT_BACK_QUARTIC:{
			float ts = (t /= d) * t;
			float tc = ts * t;
			return -2 * ts * ts + 10 * tc + -15 * ts + 8 * t;
		}
		case OUT_ELASTIC_SMALL:{
			float ts = (t /= d) * t;
			float tc = ts * t;
			return 33 * tc * ts + -106 * ts * ts + 126 * tc + -67 * ts + 15 * t;
		}
		case OUT_ELASTIC_BIG:{
			float ts = (t /= d) * t;
			float tc = ts * t;
			return 56 * tc * ts + -175 * ts * ts + 200 * tc + -100 * ts + 20 * t;
		}
		case IN_ELASTIC_SMALL:{
			float ts = (t /= d) * t;
			float tc = ts * t;
			return 33 * tc * ts + -59 * ts * ts + 32 * tc + -5 * ts;
		}
		case IN_ELASTIC_BIG:{
			float ts = (t /= d) * t;
			float tc = ts * t;
			return 56 * tc * ts + -105 * ts * ts + 60 * tc + -10 * ts;
		}
		default:return -1F;
		}

	}

}
