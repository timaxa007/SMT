package smt.pack.common.animation.a2D;

import smt.pack.common.animation.IKey;

public interface IAnimation2D {

	float getTimeLine();
	boolean isLoop();

	IKey[] getTranslateX();
	IKey[] getTranslateY();
	
	IKey[] getRotateX();
	IKey[] getRotateY();

}
