package smt.pack.common.client;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraftforge.client.model.obj.Face;
import net.minecraftforge.client.model.obj.GroupObject;
import net.minecraftforge.client.model.obj.TextureCoordinate;
import net.minecraftforge.client.model.obj.Vertex;
import net.minecraftforge.client.model.obj.WavefrontObject;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class UtilModel {

	public static void box(Tessellator tessellator, AxisAlignedBB aabb) {
		box(tessellator, aabb.minX, aabb.minY, aabb.minZ, aabb.maxX, aabb.maxY, aabb.maxZ);
	}

	//Tessellator tessellator = Tessellator.instance;
	//GL11.glDisable(GL11.GL_TEXTURE_2D);
	//GL11.glEnable(GL11.GL_TEXTURE_2D);
	public static void box(Tessellator tessellator, double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
		tessellator.startDrawingQuads();
		//top
		tessellator.addVertex(maxX, maxY, minZ);
		tessellator.addVertex(minX, maxY, minZ);
		tessellator.addVertex(minX, maxY, maxZ);
		tessellator.addVertex(maxX, maxY, maxZ);
		//bottom
		tessellator.addVertex(maxX, minY, maxZ);
		tessellator.addVertex(minX, minY, maxZ);
		tessellator.addVertex(minX, minY, minZ);
		tessellator.addVertex(maxX, minY, minZ);
		//north
		tessellator.addVertex(maxX, minY, minZ);
		tessellator.addVertex(minX, minY, minZ);
		tessellator.addVertex(minX, maxY, minZ);
		tessellator.addVertex(maxX, maxY, minZ);
		//south
		tessellator.addVertex(maxX, maxY, maxZ);
		tessellator.addVertex(minX, maxY, maxZ);
		tessellator.addVertex(minX, minY, maxZ);
		tessellator.addVertex(maxX, minY, maxZ);
		//west
		tessellator.addVertex(minX, maxY, maxZ);
		tessellator.addVertex(minX, maxY, minZ);
		tessellator.addVertex(minX, minY, minZ);
		tessellator.addVertex(minX, minY, maxZ);
		//east
		tessellator.addVertex(maxX, minY, maxZ);
		tessellator.addVertex(maxX, minY, minZ);
		tessellator.addVertex(maxX, maxY, minZ);
		tessellator.addVertex(maxX, maxY, maxZ);

		tessellator.draw();
	}

	public static void boxWithUV(Tessellator tessellator, AxisAlignedBB aabb) {
		boxWithUV(tessellator, aabb.minX, aabb.minY, aabb.minZ, aabb.maxX, aabb.maxY, aabb.maxZ);
	}

	//tessellator.setColorOpaque_I(clr);
	public static void boxWithUV(Tessellator tessellator, double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
		double icon_minX = minX < 0D ? 0D : minX;
		double icon_minY = minY < 0D ? 0D : minY;
		double icon_minZ = minZ < 0D ? 0D : minZ;
		double icon_maxX = maxX > 1D ? 1D : maxX;
		double icon_maxY = maxY > 1D ? 1D : maxY;
		double icon_maxZ = maxZ > 1D ? 1D : maxZ;
		tessellator.startDrawingQuads();
		//Top
		tessellator.addVertexWithUV(maxX, maxY, minZ, icon_maxX, icon_minZ);
		tessellator.addVertexWithUV(minX, maxY, minZ, icon_minX, icon_minZ);
		tessellator.addVertexWithUV(minX, maxY, maxZ, icon_minX, icon_maxZ);
		tessellator.addVertexWithUV(maxX, maxY, maxZ, icon_maxX, icon_maxZ);
		//Bottom
		tessellator.addVertexWithUV(maxX, minY, maxZ, icon_maxX, icon_maxZ);
		tessellator.addVertexWithUV(minX, minY, maxZ, icon_minX, icon_maxZ);
		tessellator.addVertexWithUV(minX, minY, minZ, icon_minX, icon_minZ);
		tessellator.addVertexWithUV(maxX, minY, minZ, icon_maxX, icon_minZ);
		//North
		tessellator.addVertexWithUV(maxX, minY, minZ, icon_minX, icon_maxY);
		tessellator.addVertexWithUV(minX, minY, minZ, icon_maxX, icon_maxY);
		tessellator.addVertexWithUV(minX, maxY, minZ, icon_maxX, icon_minY);
		tessellator.addVertexWithUV(maxX, maxY, minZ, icon_minX, icon_minY);
		//South
		tessellator.addVertexWithUV(maxX, maxY, maxZ, icon_maxX, icon_minY);
		tessellator.addVertexWithUV(minX, maxY, maxZ, icon_minX, icon_minY);
		tessellator.addVertexWithUV(minX, minY, maxZ, icon_minX, icon_maxY);
		tessellator.addVertexWithUV(maxX, minY, maxZ, icon_maxX, icon_maxY);
		//West
		tessellator.addVertexWithUV(minX, maxY, maxZ, icon_maxY, icon_minZ);
		tessellator.addVertexWithUV(minX, maxY, minZ, icon_minY, icon_minZ);
		tessellator.addVertexWithUV(minX, minY, minZ, icon_minY, icon_maxZ);
		tessellator.addVertexWithUV(minX, minY, maxZ, icon_maxY, icon_maxZ);
		//East
		tessellator.addVertexWithUV(maxX, minY, maxZ, icon_minY, icon_maxZ);
		tessellator.addVertexWithUV(maxX, minY, minZ, icon_maxY, icon_maxZ);
		tessellator.addVertexWithUV(maxX, maxY, minZ, icon_maxY, icon_minZ);
		tessellator.addVertexWithUV(maxX, maxY, maxZ, icon_minY, icon_minZ);

		tessellator.draw();
	}

	public static void boxOnIcon(Tessellator tessellator, IIcon icon, AxisAlignedBB aabb) {
		boxOnIcon(tessellator, icon, aabb.minX, aabb.minY, aabb.minZ, aabb.maxX, aabb.maxY, aabb.maxZ);
	}

	//tessellator.setColorOpaque_I(clr);
	public static void boxOnIcon(Tessellator tessellator, IIcon icon, double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
		if (icon == null) return;
		double icon_minX = (minX < 0D ? 0D : minX) * 16D;
		double icon_minY = (minY < 0D ? 0D : minY) * 16D;
		double icon_minZ = (minZ < 0D ? 0D : minZ) * 16D;
		double icon_maxX = (maxX > 1D ? 1D : maxX) * 16D;
		double icon_maxY = (maxY > 1D ? 1D : maxY) * 16D;
		double icon_maxZ = (maxZ > 1D ? 1D : maxZ) * 16D;
		tessellator.startDrawingQuads();
		//Top
		tessellator.addVertexWithUV(maxX, maxY, minZ, 
				(double)icon.getInterpolatedU(icon_maxX),
				(double)icon.getInterpolatedV(icon_minZ)
				);
		tessellator.addVertexWithUV(minX, maxY, minZ, 
				(double)icon.getInterpolatedU(icon_minX),
				(double)icon.getInterpolatedV(icon_minZ)
				);
		tessellator.addVertexWithUV(minX, maxY, maxZ, 
				(double)icon.getInterpolatedU(icon_minX),
				(double)icon.getInterpolatedV(icon_maxZ)
				);
		tessellator.addVertexWithUV(maxX, maxY, maxZ, 
				(double)icon.getInterpolatedU(icon_maxX),
				(double)icon.getInterpolatedV(icon_maxZ)
				);
		//Bottom
		tessellator.addVertexWithUV(maxX, minY, maxZ, 
				(double)icon.getInterpolatedU(icon_maxX),
				(double)icon.getInterpolatedV(icon_maxZ)
				);
		tessellator.addVertexWithUV(minX, minY, maxZ, 
				(double)icon.getInterpolatedU(icon_minX),
				(double)icon.getInterpolatedV(icon_maxZ)
				);
		tessellator.addVertexWithUV(minX, minY, minZ, 
				(double)icon.getInterpolatedU(icon_minX),
				(double)icon.getInterpolatedV(icon_minZ)
				);
		tessellator.addVertexWithUV(maxX, minY, minZ, 
				(double)icon.getInterpolatedU(icon_maxX),
				(double)icon.getInterpolatedV(icon_minZ)
				);
		//North
		tessellator.addVertexWithUV(maxX, minY, minZ, 
				(double)icon.getInterpolatedU(icon_minX),
				(double)icon.getInterpolatedV(icon_maxY)
				);
		tessellator.addVertexWithUV(minX, minY, minZ, 
				(double)icon.getInterpolatedU(icon_maxX),
				(double)icon.getInterpolatedV(icon_maxY)
				);
		tessellator.addVertexWithUV(minX, maxY, minZ, 
				(double)icon.getInterpolatedU(icon_maxX),
				(double)icon.getInterpolatedV(icon_minY)
				);
		tessellator.addVertexWithUV(maxX, maxY, minZ, 
				(double)icon.getInterpolatedU(icon_minX),
				(double)icon.getInterpolatedV(icon_minY)
				);
		//South
		tessellator.addVertexWithUV(maxX, maxY, maxZ, 
				(double)icon.getInterpolatedU(icon_maxX),
				(double)icon.getInterpolatedV(icon_minY)
				);
		tessellator.addVertexWithUV(minX, maxY, maxZ, 
				(double)icon.getInterpolatedU(icon_minX),
				(double)icon.getInterpolatedV(icon_minY)
				);
		tessellator.addVertexWithUV(minX, minY, maxZ, 
				(double)icon.getInterpolatedU(icon_minX),
				(double)icon.getInterpolatedV(icon_maxY)
				);
		tessellator.addVertexWithUV(maxX, minY, maxZ, 
				(double)icon.getInterpolatedU(icon_maxX),
				(double)icon.getInterpolatedV(icon_maxY)
				);
		//West
		tessellator.addVertexWithUV(minX, maxY, maxZ, 
				(double)icon.getInterpolatedU(icon_maxY),
				(double)icon.getInterpolatedV(icon_minZ)
				);
		tessellator.addVertexWithUV(minX, maxY, minZ, 
				(double)icon.getInterpolatedU(icon_minY),
				(double)icon.getInterpolatedV(icon_minZ)
				);
		tessellator.addVertexWithUV(minX, minY, minZ, 
				(double)icon.getInterpolatedU(icon_minY),
				(double)icon.getInterpolatedV(icon_maxZ)
				);
		tessellator.addVertexWithUV(minX, minY, maxZ, 
				(double)icon.getInterpolatedU(icon_maxY),
				(double)icon.getInterpolatedV(icon_maxZ)
				);
		//East
		tessellator.addVertexWithUV(maxX, minY, maxZ, 
				(double)icon.getInterpolatedU(icon_minY),
				(double)icon.getInterpolatedV(icon_maxZ)
				);
		tessellator.addVertexWithUV(maxX, minY, minZ, 
				(double)icon.getInterpolatedU(icon_maxY),
				(double)icon.getInterpolatedV(icon_maxZ)
				);
		tessellator.addVertexWithUV(maxX, maxY, minZ, 
				(double)icon.getInterpolatedU(icon_maxY),
				(double)icon.getInterpolatedV(icon_minZ)
				);
		tessellator.addVertexWithUV(maxX, maxY, maxZ, 
				(double)icon.getInterpolatedU(icon_minY),
				(double)icon.getInterpolatedV(icon_minZ)
				);

		tessellator.draw();
	}

	public static void lines(AxisAlignedBB aabb) {
		lines(aabb.minX, aabb.minY, aabb.minZ, aabb.maxX, aabb.maxY, aabb.maxZ);
	}

	public static void lines(double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
		GL11.glBegin(GL11.GL_LINE_STRIP);

		/*-top-*/
		GL11.glVertex3d(minX, maxY, minZ);//a - 1
		GL11.glVertex3d(maxX, maxY, minZ);//b - 2

		//GL11.glVertex3d(maxX, maxY, minZ);//a - 2
		GL11.glVertex3d(maxX, maxY, maxZ);//b - 3

		//GL11.glVertex3d(maxX, maxY, maxZ);//a - 3
		GL11.glVertex3d(minX, maxY, maxZ);//b - 4

		//GL11.glVertex3d(minX, maxY, maxZ);//a - 4
		GL11.glVertex3d(minX, maxY, minZ);//b - 1

		GL11.glEnd();

		GL11.glBegin(GL11.GL_LINE_STRIP);
		/*-bottom-*/
		GL11.glVertex3d(minX, minY, minZ);//a - 1
		GL11.glVertex3d(maxX, minY, minZ);//b - 2

		//GL11.glVertex3d(maxX, minY, minZ);//a - 2
		GL11.glVertex3d(maxX, minY, maxZ);//b - 3

		//GL11.glVertex3d(maxX, minY, maxZ);//a - 3
		GL11.glVertex3d(minX, minY, maxZ);//b - 4

		//GL11.glVertex3d(minX, minY, maxZ);//a - 4
		GL11.glVertex3d(minX, minY, minZ);//b - 1

		GL11.glEnd();

		GL11.glBegin(GL11.GL_LINES);
		/*-side-/-edge-*/
		GL11.glVertex3d(minX, maxY, minZ);//a
		GL11.glVertex3d(minX, minY, minZ);//b

		GL11.glVertex3d(maxX, maxY, maxZ);//a
		GL11.glVertex3d(maxX, minY, maxZ);//b

		GL11.glVertex3d(maxX, maxY, minZ);//a
		GL11.glVertex3d(maxX, minY, minZ);//b

		GL11.glVertex3d(minX, maxY, maxZ);//a
		GL11.glVertex3d(minX, minY, maxZ);//b

		GL11.glEnd();
	}

	public static void renderAllOnIcon(WavefrontObject obj, IIcon icon, Tessellator tessellator) {
		if (obj.groupObjects.size() > 0)
			for (GroupObject go : obj.groupObjects) {
				renderOnIcon(go, icon, tessellator);
			}
	}

	public static void renderPartOnIcon(WavefrontObject obj, String partName, IIcon icon, Tessellator tessellator) {
		if (obj.groupObjects.size() > 0)
			for (GroupObject go : obj.groupObjects) {
				if (partName.equals(go.name)) {
					renderOnIcon(go, icon, tessellator);
					break;
				} else continue;
			}
	}

	private static void renderOnIcon(GroupObject go, IIcon icon, Tessellator tessellator) {
		tessellator.startDrawing(GL11.GL_TRIANGLES);//GL_QUADS - напоминание.
		for (Face f : go.faces) {
			Vertex vf = f.faceNormal;
			tessellator.setNormal(vf.x, vf.y, vf.z);
			for (int i = 0; i < f.vertices.length; ++i) {
				Vertex v = f.vertices[i];
				if (f.textureCoordinates != null && f.textureCoordinates.length > 0) {
					TextureCoordinate tc = f.textureCoordinates[i];
					tessellator.addVertexWithUV(
							(double)v.x, (double)v.y, (double)v.z,
							(double)icon.getInterpolatedU((double)(tc.u * 16.0F)),
							(double)icon.getInterpolatedV((double)(tc.v * 16.0F))
							);
				} else {
					//Плохо если код доходит до этого.
					tessellator.addVertex((double)v.x, (double)v.y, (double)v.z);
				}
			}
		}
		tessellator.draw();
	}

	// RenderBlocks line 7318
	// UV 0.000 do 1.000 / icon (standard) 16x16 //

	//А теперь придумать как манипулировать Vertex'ами, чтобы получилось типа движущей жидкости.
	//Но скорее всего это будет упорото, если эти слить в едино и работать в разнобой.
	// Это просто такое мне напоминание.

}
