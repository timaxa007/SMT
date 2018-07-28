package smt.pack.common.client.gui.creating_gui;

public enum Orientation {
	LEFT_TOP,		//---0_0
	CENTER_TOP,		//---x/2_0
	RIGHT_TOP,		//---x_0

	LEFT_CENTER,	//---0_y/2
	CENTER,			//---x/2_y/2
	RIGHT_CENTER,	//---x_y/2

	LEFT_BOTTON,	//---0_y
	CENTER_BOTTON,	//---x/2_y
	RIGHT_BOTTON;	//---x_y

	public boolean isTop() {
		switch(this) {
		case LEFT_TOP:
		case CENTER_TOP:
		case RIGHT_TOP:
			return true;
		default:return false;
		}
	}

	public boolean isBotton() {
		switch(this) {
		case LEFT_BOTTON:
		case CENTER_BOTTON:
		case RIGHT_BOTTON:
			return true;
		default:return false;
		}
	}

	public boolean isLeft() {
		switch(this) {
		case LEFT_TOP:
		case LEFT_CENTER:
		case LEFT_BOTTON:
			return true;
		default:return false;
		}
	}

	public boolean isRight() {
		switch(this) {
		case RIGHT_TOP:
		case RIGHT_CENTER:
		case RIGHT_BOTTON:
			return true;
		default:return false;
		}
	}

}
