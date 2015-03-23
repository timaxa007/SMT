package mods.timaxa007.tms.lib;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RGBImageFilter;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.util.ResourceLocation;

/**@author Dragon2488; Simple utils for images manipulations.*/
public class ImageUtils {

private ImageUtils() {}

/**Get Resource location from block texture name.
 * Excample block texture name: stone, mod:block, etc
 * Warning: Not correctly working with another mods. WIP.*/
public static ResourceLocation getLocationFrom(String name) {
int i = name.lastIndexOf(':');
if (i != -1) {
String modid = name.substring(0, i);
return new ResourceLocation(modid, "textures/blocks/" + name + ".png");
} else return new ResourceLocation("minecraft", "textures/blocks/" + name + ".png");

}

/**Get image from resource location.*/
public static BufferedImage getImageFrom(ResourceLocation source) {
InputStream s = null;
try {
s = Minecraft.getMinecraft().getResourceManager().getResource(source).getInputStream();
return ImageIO.read(s);
} catch (IOException e) {
return new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
}
finally {if (s != null) try {s.close();} catch (Exception e) {e.printStackTrace();}}
}

public static void bindTextureFromImage(Image image) {
TextureUtil.uploadTextureImageAllocate(TextureUtil.glGenTextures(), toBufferedImage(image), false, false);
}

/**Transfroming Image to BufferedImage*/
public static BufferedImage toBufferedImage(Image img) {
if (img instanceof BufferedImage) return (BufferedImage) img;
BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
Graphics2D bGr = bimage.createGraphics();
bGr.drawImage(img, 0, 0, null);
bGr.dispose();
return bimage;
}

/**Filter to color images.*/
public static class ImageColorFilter extends RGBImageFilter {

private Color paint;
private BufferedImage image;

public ImageColorFilter(Color paint1, BufferedImage image1) {
paint = paint1;
image = image1;
}

@Override
public int filterRGB(int x, int y, int rgb) {
int pixel = image.getRGB(x, y);
if (pixel != 16777215) return paint.getRGB();
else return rgb;
}
}
}
