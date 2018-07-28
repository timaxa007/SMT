package smt.pack.common.animation.a3D;

import smt.pack.common.animation.IKey;

public interface IAnimation3D {

	float getTimeLine();
	boolean isLoop();

	IKey[] getTranslateX();
	IKey[] getTranslateY();
	IKey[] getTranslateZ();
	
	IKey[] getRotateX();
	IKey[] getRotateY();
	IKey[] getRotateZ();

}
