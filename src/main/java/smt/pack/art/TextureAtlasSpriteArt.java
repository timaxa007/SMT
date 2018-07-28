package smt.pack.art;

import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;

public class TextureAtlasSpriteArt extends TextureAtlasSprite {

	public TextureAtlasSpriteArt(String name) {
		super(name);
	}

	@Override
	public boolean load(IResourceManager manager, ResourceLocation location) {
		return false;
	}

}
