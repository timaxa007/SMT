package timaxa007.smt.core.substance;

public class SubstanceType {

	private String tag;

	@Deprecated
	public SubstanceType() {}

	public SubstanceType(String tag) {
		this.tag = tag;
	}
	//-----------------------------------------------------------------------------------------------
	public String getTag() {return tag;}
	//-----------------------------------------------------------------------------------------------
	public String toString() {
		return "SubstanceType: " + getTag();
	}
	//-----------------------------------------------------------------------------------------------
}
