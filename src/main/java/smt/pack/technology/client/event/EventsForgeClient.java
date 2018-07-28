package smt.pack.technology.client.event;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.culling.Frustrum;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import smt.pack.technology.world.ChunkWireEnergy;
import smt.pack.technology.world.WireLocations;
import smt.pack.technology.world.WorldWireEnergy;

public class EventsForgeClient {

	static final Minecraft mc = Minecraft.getMinecraft();
	static final Frustrum frustrum = new Frustrum();
	static final Tessellator tessellator = Tessellator.instance;

	@SubscribeEvent
	public void renderWire(RenderWorldLastEvent event) {

		WorldWireEnergy wwe = WorldWireEnergy.get(mc.theWorld);

		if (wwe == null) return;

		double posX = mc.thePlayer.lastTickPosX + (mc.thePlayer.posX - mc.thePlayer.lastTickPosX) * (double)event.partialTicks;
		double posY = mc.thePlayer.lastTickPosY + (mc.thePlayer.posY - mc.thePlayer.lastTickPosY) * (double)event.partialTicks;
		double posZ = mc.thePlayer.lastTickPosZ + (mc.thePlayer.posZ - mc.thePlayer.lastTickPosZ) * (double)event.partialTicks;

		frustrum.setPosition(posX, posY, posZ);
		mc.renderGlobal.clipRenderersByFrustum(frustrum, event.partialTicks);

		GL11.glPushMatrix();
		GL11.glTranslated(-posX, -posY, -posZ);

		for (ChunkWireEnergy cwe : wwe.load_chunk_wire_energy) {
			for (WireLocations wl : cwe.wire_loc) {

				if (frustrum.isBoundingBoxInFrustum(wl.getAABB())) {

					GL11.glPushMatrix();
					GL11.glDisable(GL11.GL_TEXTURE_2D);

					GL11.glColor3f(0F, 0.25F, 1F);
					GL11.glBegin(GL11.GL_LINES);
					GL11.glVertex3d(wl.posXa + 0.5, wl.posYa + 0.5, wl.posZa + 0.5);//a
					GL11.glVertex3d(wl.posXb + 0.5, wl.posYb + 0.5, wl.posZb + 0.5);//b
					GL11.glEnd();

					GL11.glEnable(GL11.GL_TEXTURE_2D);
					GL11.glPopMatrix();
				}
			}
		}

		GL11.glPopMatrix();

	}

	/*
	@SubscribeEvent
	public void guiDSC(GuiScreenEvent.DrawScreenEvent event) {
		for (int i = 0; i < Mouse.getButtonCount(); ++i) {
			if (Mouse.isButtonDown(i)) System.out.println("Mouse Button is Down " + i);
		}
		for (int i = 0; i < Keyboard.getKeyCount(); ++i) {
			if (Keyboard.isKeyDown(i)) System.out.println("Keyboard Key is Down " + i);
		}
	}
	 */
	/*
	@SubscribeEvent
	public void selectHighlight(DrawBlockHighlightEvent event) {
		if (event.target != null && event.target.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {

	//dot start
	double ax = event.target.blockX;
	double ay = event.target.blockY;
	double az = event.target.blockZ;

	//dot end
	double bx = event.target.blockX + 1;
	double by = event.target.blockY + 1;
	double bz = event.target.blockZ + 1;

	AxisAlignedBB aabb = AxisAlignedBB.getBoundingBox(ax, ay, az, bx, by, bz).expand(0.01D, 0.01D, 0.01D);

	double x_fix = -(mc.thePlayer.lastTickPosX + (mc.thePlayer.posX - mc.thePlayer.lastTickPosX) * event.parTicks);
	double y_fix = -(mc.thePlayer.lastTickPosY + (mc.thePlayer.posY - mc.thePlayer.lastTickPosY) * event.parTicks);
	double z_fix = -(mc.thePlayer.lastTickPosZ + (mc.thePlayer.posZ - mc.thePlayer.lastTickPosZ) * event.parTicks);

	GL11.glPushMatrix();
	GL11.glTranslated(x_fix, y_fix, z_fix);
	GL11.glEnable(GL11.GL_BLEND);
	GL11.glDisable(GL11.GL_TEXTURE_2D);
	//
	GL11.glColor4f(0.75F, 0.25F, 0.25F, 0.25F);
	Model.box(aabb);
	GL11.glColor4f(0.75F, 0.25F, 0.25F, 0.75F);
	Model.lines(aabb);
	GL11.glColor4f(1F, 1F, 1F, 0F);
	//
	GL11.glEnable(GL11.GL_TEXTURE_2D);
	GL11.glDisable(GL11.GL_BLEND);
	GL11.glPopMatrix();
		}
	}
	 */
	/*
	@SubscribeEvent
	public void getSound(PlaySoundEvent17 event) {
		if (mc != null && mc.thePlayer != null) {
			if (mc.thePlayer.getCurrentArmor(3) != null) {
				event.result = null;
			}
			//event.result = null;
		}
		System.out.println("getSound - " + event.name);
	}
	 */
	/*
	@SubscribeEvent
	public void getSound2(PlaySoundEvent17 event) {
		if (mc != null && mc.thePlayer != null) {
			if (mc.thePlayer.getCurrentEquippedItem() != null) {
				if (event.sound instanceof PositionedSound) {
					PositionedSound ps = (PositionedSound)event.sound;
					event.result = ps;
				}
			}
		}
	}
	 */
}
