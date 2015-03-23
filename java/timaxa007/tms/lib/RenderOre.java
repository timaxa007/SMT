package timaxa007.tms.lib;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RenderOre extends TileEntitySpecialRenderer {

/**Warning: Not correctly working with sided textured blocks.*/
@Override
public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale) {
Block b = te.getWorldObj().getBlock(te.xCoord, te.yCoord - 1, te.zCoord);
int meta = te.getWorldObj().getBlockMetadata(te.xCoord, te.yCoord - 1, te.zCoord);
/**Texture of block in y - 1.*/
//BufferedImage stone = Block.blockList[b] != null && Block.blockList[b].getIcon(1, meta) != null ? 
//ImageUtils.getImageFrom(ImageUtils.getLocationFrom(Block.blockList[b].getIcon(1, meta).getIconName())) : 
ImageUtils.getImageFrom(ImageUtils.getLocationFrom(Blocks.stone.getIcon(1, meta).getIconName()));
/**Texture of base ore*/
BufferedImage ore = ImageUtils.getImageFrom(new ResourceLocation("timaxa007", "textures/blocks/ore/ore_dust_overlay.png"));
/**Colored Texture of base ore.*/
Image colored  = Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(ore.getSource(), new ImageUtils.ImageColorFilter(/* Color, to paint base ore.*/Color.BLUE, ore)));
/**Draw base ore texture on block -1 texture.*/
//stone.getGraphics().drawImage(colored, 0, 0, 16, 16, null);
/**Drawing block, translating, rotating, coloring.*/

GL11.glPushMatrix();
Tessellator t = Tessellator.instance;
OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 127.0F, 1.0F);


t.startDrawingQuads();
GL11.glTranslated(x + 1.0D, y, z);
GL11.glRotated(270.0D, 0.0D, 1.0D, 0.0D);
GL11.glColor3d(1.0D, 1.0D, 1.0D);

//sidex1
t.addVertexWithUV(0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
t.addVertexWithUV(0.0D, 1.0D, 0.0D, 0.0D, 1.0D);
t.addVertexWithUV(1.0D, 1.0D, 0.0D, 1.0D, 1.0D);
t.addVertexWithUV(1.0D, 0.0D, 0.0D, 1.0D, 0.0D);
//sidex2
t.addVertexWithUV(0.0D, 0.0D, 1.0D, 0.0D, 0.0D);
t.addVertexWithUV(0.0D, 1.0D, 1.0D, 0.0D, 1.0D);
t.addVertexWithUV(0.0D, 1.0D, 0.0D, 1.0D, 1.0D);
t.addVertexWithUV(0.0D, 0.0D, 0.0D, 1.0D, 0.0D);
//sidex3
t.addVertexWithUV(1.0D, 0.0D, 1.0D, 0.0D, 0.0D);
t.addVertexWithUV(1.0D, 1.0D, 1.0D, 0.0D, 1.0D);
t.addVertexWithUV(0.0D, 1.0D, 1.0D, 1.0D, 1.0D);
t.addVertexWithUV(0.0D, 0.0D, 1.0D, 1.0D, 0.0D);
//sidex4
t.addVertexWithUV(1.0D, 0.0D, 0.0D, 0.0D, 0.0D);
t.addVertexWithUV(1.0D, 1.0D, 0.0D, 0.0D, 1.0D);
t.addVertexWithUV(1.0D, 1.0D, 1.0D, 1.0D, 1.0D);
t.addVertexWithUV(1.0D, 0.0D, 1.0D, 1.0D, 0.0D);
//top
t.addVertexWithUV(1.0D, 1.0D, 0.0D, 0.0D, 0.0D);
t.addVertexWithUV(0.0D, 1.0D, 0.0D, 0.0D, 1.0D);
t.addVertexWithUV(0.0D, 1.0D, 1.0D, 1.0D, 1.0D);
t.addVertexWithUV(1.0D, 1.0D, 1.0D, 1.0D, 0.0D);
//down
t.addVertexWithUV(0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
t.addVertexWithUV(1.0D, 0.0D, 0.0D, 0.0D, 1.0D);
t.addVertexWithUV(1.0D, 0.0D, 1.0D, 1.0D, 1.0D);
t.addVertexWithUV(0.0D, 0.0D, 1.0D, 1.0D, 0.0D);
//draw
//Bind Texture From BufferedImage
//ImageUtils.bindTextureFromImage(stone);
t.draw();

GL11.glPopMatrix();

}

}
