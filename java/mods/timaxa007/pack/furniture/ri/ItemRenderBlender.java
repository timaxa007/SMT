package mods.timaxa007.pack.furniture.ri;

import mods.timaxa007.lib.TileTexture;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

public class ItemRenderBlender implements IItemRenderer {
	private static final IModelCustom mdl1 = AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/blender.obj"));

	public ItemRenderBlender() {
		
	}

	@Override
	public boolean handleRenderType(ItemStack is, ItemRenderType type) {
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack is, ItemRendererHelper helper) {
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack is, Object... data) {
		NBTTagCompound tag = is.getTagCompound();
		/*
		int tex=tag.getInteger("Type");
		int tc=tag.getInteger("TypeCap");
		int thnd=tag.getInteger("TypeHandler");
		int tbx=tag.getInteger("TypeBox");
		int tgls=tag.getInteger("TypeGlass");
		int tvml=tag.getInteger("TypeSize");
		int vml=tag.getInteger("Size");
		 */
		int vml = 10;
		//---------------------------------------------
		GL11.glPushMatrix();
		GL11.glTranslatef(0.5F, 0.0F, 0.5F);
		GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);

		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", TileTexture.tt));//tbx
		mdl1.renderPart("box01");
		GL11.glPopMatrix();
		//---------------------------------------------
		GL11.glPushMatrix();
		GL11.glTranslatef(0.5F, 0.0F, 0.5F);
		GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);

		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", TileTexture.tt));//
		mdl1.renderPart("button0");
		mdl1.renderPart("button1");
		mdl1.renderPart("button2");
		mdl1.renderPart("button3");
		GL11.glPopMatrix();
		//---------------------------------------------
		GL11.glPushMatrix();
		GL11.glTranslatef(0.5F, 0.0F, 0.5F);
		GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);

		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", TileTexture.tt));//tc
		mdl1.renderPart("cap");
		GL11.glPopMatrix();
		//---------------------------------------------
		GL11.glPushMatrix();
		GL11.glTranslatef(0.5F, 0.0F, 0.5F);
		GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);

		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", TileTexture.tt));//thnd
		mdl1.renderPart("handler");
		GL11.glPopMatrix();
		//---------------------------------------------
		GL11.glPushMatrix();
		GL11.glTranslatef(0.5F, 0.0F, 0.5F);
		GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);

		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", TileTexture.tt));//
		mdl1.renderPart("blade");
		GL11.glPopMatrix();
		//---------------------------------------------
		if ((vml>0)&&(vml<11)) {
			GL11.glPushMatrix();
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			GL11.glTranslatef(0.5F, 0.0F, 0.5F);
			GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
			GL11.glScalef(0.999F, 0.999F, 0.999F);
			/*
			switch(tvml) {
			case 0:GL11.glColor4f(0.1F, 0.1F, 0.1F, 1.0F);break;
			case 1:GL11.glColor4f(0.0F, 0.0F, 255.0F, 1.0F);break;
			case 2:GL11.glColor4f(1.0F, 0.5F, 0.0F, 1.0F);break;
			case 3:GL11.glColor4f(0.0F, 0.5F, 0.5F, 1.0F);break;
			case 4:GL11.glColor4f(0.25F, 0.25F, 0.25F, 1.0F);break;
			case 5:GL11.glColor4f(0.0F, 0.5F, 0.0F, 1.0F);break;
			case 6:GL11.glColor4f(0.0F, 1.0F, 1.0F, 1.0F);break;
			case 7:GL11.glColor4f(0.75F, 0.75F, 0.75F, 1.0F);break;
			case 8:GL11.glColor4f(0.0F, 0.5F, 0.0F, 1.0F);break;
			case 9:GL11.glColor4f(1.0F, 0.0F, 1.0F, 1.0F);break;
			case 10:GL11.glColor4f(1.0F, 0.5F, 0.0F, 1.0F);break;
			case 11:GL11.glColor4f(1.0F, 0.5F, 0.5F, 1.0F);break;
			case 12:GL11.glColor4f(0.5F, 0.0F, 1.0F, 1.0F);break;
			case 13:GL11.glColor4f(1.0F, 0.0F, 0.0F, 1.0F);break;
			case 14:GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);break;
			case 15:GL11.glColor4f(1.0F, 1.0F, 0.0F, 1.0F);break;
			default:GL11.glColor4f(0.0F, 0.0F, 0.0F, 1.0F);break;
			}
			 */
			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/blocks/waterStatic_no.png"));//tvml

			switch(vml) {
			case 1:mdl1.renderPart("luqid_1");break;
			case 2:mdl1.renderPart("luqid_2");break;
			case 3:mdl1.renderPart("luqid_3");break;
			case 4:mdl1.renderPart("luqid_4");break;
			case 5:mdl1.renderPart("luqid_5");break;
			case 6:mdl1.renderPart("luqid_6");break;
			case 7:mdl1.renderPart("luqid_7");break;
			case 8:mdl1.renderPart("luqid_8");break;
			case 9:mdl1.renderPart("luqid_9");break;
			case 10:mdl1.renderPart("luqid_10");break;
			default:mdl1.renderPart("luqid_10");break;
			}

			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			GL11.glDisable(GL11.GL_BLEND);
			GL11.glPopMatrix();
		}
		//---------------------------------------------
		GL11.glPushMatrix();
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE);
		GL11.glTranslatef(0.5F, 0.0F, 0.5F);
		GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
		GL11.glTranslatef(0.0F, 0.0F, 0.001F);
		/*
		switch(tgls) {
		case 0:GL11.glColor4f(0.1F, 0.1F, 0.1F, 1.0F);break;
		case 1:GL11.glColor4f(0.0F, 0.0F, 255.0F, 1.0F);break;
		case 2:GL11.glColor4f(1.0F, 0.5F, 0.0F, 1.0F);break;
		case 3:GL11.glColor4f(0.0F, 0.5F, 0.5F, 1.0F);break;
		case 4:GL11.glColor4f(0.25F, 0.25F, 0.25F, 1.0F);break;
		case 5:GL11.glColor4f(0.0F, 0.5F, 0.0F, 1.0F);break;
		case 6:GL11.glColor4f(0.0F, 1.0F, 1.0F, 1.0F);break;
		case 7:GL11.glColor4f(0.75F, 0.75F, 0.75F, 1.0F);break;
		case 8:GL11.glColor4f(0.0F, 0.5F, 0.0F, 1.0F);break;
		case 9:GL11.glColor4f(1.0F, 0.0F, 1.0F, 1.0F);break;
		case 10:GL11.glColor4f(1.0F, 0.5F, 0.0F, 1.0F);break;
		case 11:GL11.glColor4f(1.0F, 0.5F, 0.5F, 1.0F);break;
		case 12:GL11.glColor4f(0.5F, 0.0F, 1.0F, 1.0F);break;
		case 13:GL11.glColor4f(1.0F, 0.0F, 0.0F, 1.0F);break;
		case 14:GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);break;
		case 15:GL11.glColor4f(1.0F, 1.0F, 0.0F, 1.0F);break;
		default:GL11.glColor4f(0.0F, 0.0F, 0.0F, 1.0F);break;
		}
		 */
		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/blocks/glassBlender.png"));
		//Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/blocks/glass"+GetColors.getNameColors[tgls]+".png"));
		//Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("minecraft", "textures/blocks/glass.png"));
		mdl1.renderPart("glass");
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glPopMatrix();
		//---------------------------------------------

	}

}
