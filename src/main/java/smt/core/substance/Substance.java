package smt.core.substance;

public class Substance {
	//-----------------------------------------------------------------------------------------------
	private String tag;
	private SubstanceType type;
	private int color;
	//-----------------------------------------------------------------------------------------------
	@Deprecated
	public Substance() {}

	public Substance(String tag) {
		this.tag = tag;
	}
	//-----------------------------------------------------------------------------------------------
	public String getTag() {return tag;}

	public Substance setType(SubstanceType type) {
		this.type = type;
		return this;
	}

	public SubstanceType getType() {
		return (type != null ? type : SubstanceRegistry.NONE);
	}

	public Substance setColor(int color) {
		this.color = color;
		return this;
	}

	public int getColor() {return color;}
	//-----------------------------------------------------------------------------------------------
	public String toString() {
		return "Substance: " + (getTag() != null ? getTag() : "[ERROR]");
	}
	//-----------------------------------------------------------------------------------------------
}
