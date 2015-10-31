package timaxa007.module.substance;

public class Substance {

	private String tag;

	@Deprecated
	public Substance() {}

	public Substance(String tag) {
		this.tag = tag;
	}

	public String getTag() {return tag;}
	
	public String toString() {
		return "Substance: " + getTag();
	}

}
