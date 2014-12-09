package mods.timaxa007.pack.weapon.ri;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

public class ItemRendererWeapons implements IItemRenderer {
private IModelCustom model_arms;
private IModelCustom model_weapon_sniper;
private IModelCustom model_weapon_pistol;

public ItemRendererWeapons() {
model_arms = AdvancedModelLoader.loadModel("/assets/timaxa007/obj/arms.obj");
model_weapon_sniper = AdvancedModelLoader.loadModel("/assets/timaxa007/obj/weapon_sniper.obj");
model_weapon_pistol = AdvancedModelLoader.loadModel("/assets/timaxa007/obj/weapon_pistol.obj");
//automat_test
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
boolean isAim = false;
EntityClientPlayerMP player = Minecraft.getMinecraft().thePlayer;
//Render render = RenderManager.instance.getEntityRenderObject(player);
//RenderPlayer renderplayer = (RenderPlayer)render;

if (tag != null) {
if (tag.hasKey("Aim")) {isAim = tag.getBoolean("Aim");}
}

//if (player.isSwingInProgress) {System.out.println("test");}
/*
if (type == type.EQUIPPED_FIRST_PERSON) {
GL11.glPushMatrix();
//---------------------------------------
GL11.glTranslatef(-0.25F, 1.0F, 0.75F);
GL11.glRotatef(90F, 1.0F, 0.0F, 0.0F);
GL11.glRotatef(35F, 0.0F, 0.0F, 1.0F);
GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
//---------------------------------------
if (isAim) {
GL11.glRotatef(-10F, 0.0F, 0.0F, 1.0F);
GL11.glTranslatef(1.0F, 0.0F, 0.0F);
}
Minecraft.getMinecraft().renderEngine.bindTexture(player.getLocationSkin());
model_arms.renderPart("leftarm");
GL11.glPopMatrix();

GL11.glPushMatrix();
//---------------------------------------
GL11.glTranslatef(-0.25F, 1.0F, 0.75F);
GL11.glRotatef(90F, 1.0F, 0.0F, 0.0F);
GL11.glRotatef(35F, 0.0F, 0.0F, 1.0F);
GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
//---------------------------------------
if (isAim) {
GL11.glRotatef(-10F, 0.0F, 0.0F, 1.0F);
GL11.glTranslatef(1.0F, 0.0F, 0.0F);
}
Minecraft.getMinecraft().renderEngine.bindTexture(player.getLocationSkin());
model_arms.renderPart("rightarm");
GL11.glPopMatrix();
}
*/

if (type == type.EQUIPPED_FIRST_PERSON) {
GL11.glPushMatrix();
//---------------------------------------
GL11.glTranslatef(-0.25F, 1.0F, 0.75F);
GL11.glRotatef(90F, 1.0F, 0.0F, 0.0F);
GL11.glRotatef(35F, 0.0F, 0.0F, 1.0F);
GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
//---------------------------------------
if (isAim) {
GL11.glRotatef(-10F, 0.0F, 0.0F, 1.0F);
GL11.glTranslatef(1.0F, 0.0F, 0.0F);
}
Minecraft.getMinecraft().renderEngine.bindTexture(player.getLocationSkin());
model_arms.renderPart("leftarm");
GL11.glPopMatrix();

GL11.glPushMatrix();
//---------------------------------------
GL11.glTranslatef(-0.25F, 1.0F, 0.75F);
GL11.glRotatef(90F, 1.0F, 0.0F, 0.0F);
GL11.glRotatef(35F, 0.0F, 0.0F, 1.0F);
GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
//---------------------------------------
if (isAim) {
GL11.glRotatef(-10F, 0.0F, 0.0F, 1.0F);
GL11.glTranslatef(1.0F, 0.0F, 0.0F);
}
Minecraft.getMinecraft().renderEngine.bindTexture(player.getLocationSkin());
model_arms.renderPart("rightarm");
GL11.glPopMatrix();
}

//Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("textures/entity/steve.png"));
GL11.glPushMatrix();
if (type == type.EQUIPPED_FIRST_PERSON) {
GL11.glTranslatef(-0.1F, 0.825F, 0.45F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
GL11.glRotatef(135F, 0.0F, 0.0F, 1.0F);
GL11.glTranslatef(0.0F, 0.30F, 0.0F);
if (isAim) {GL11.glTranslatef(0.935F, 0.25F, 0.325F);}
} else if (type == type.INVENTORY) {
GL11.glTranslatef(0.5F, 0.0F, 0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
} else {
GL11.glTranslatef(0.65F, 0.5F, 0.65F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
GL11.glRotatef(-135F, 0.0F, 0.0F, 1.0F);
}
GL11.glScalef(2.0F, 2.0F, 2.0F);
Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("textures/blocks/iron_block.png"));
model_weapon_sniper.renderAll();
GL11.glPopMatrix();

}

}
