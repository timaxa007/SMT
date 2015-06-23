package timaxa007.pack.item.block;

import net.minecraft.block.material.Material;
import timaxa007.smt.object.ModifiedBlock;

public class BlockData extends ModifiedBlock {

	private String sub_tag;
	//private String name;
	private int color_hex;
	private String texture;

	public BlockData(String tag, Material material) {
		super(tag, material);
		this.sub_tag = tag;
	}

	public String getSubTag() {return sub_tag;}
	/*
	public BlockData setName(String name) {this.name = name;return this;}
	public String getName() {return name;}
	 */
	public BlockData setColor(int color_hex) {this.color_hex = color_hex;return this;}
	public int getColor() {return color_hex;}

	public BlockData setTexture(String texture) {this.texture = texture;return this;}
	public String getTexture() {return texture;}

	public String toString() {
		return "BlockData: " + getTag() + ", " + getSubTag() + ".";
	}

}
