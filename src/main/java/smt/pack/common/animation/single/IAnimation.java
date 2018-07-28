package smt.pack.common.animation.single;

import smt.pack.common.animation.IKey;

public interface IAnimation {

	float getTimeLine();
	boolean isLoop();

	IKey[] getTranslate();
	
	IKey[] getRotate();

}
