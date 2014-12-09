package mods.timaxa007.pack.techno.ri;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

public class ItemRenderBlockChip implements IItemRenderer {
private IModelCustom mdl1;

public ItemRenderBlockChip() {
mdl1=AdvancedModelLoader.loadModel("/assets/timaxa007/obj/chip01.obj");
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
int tex=0;
//int tmdl=0;

if(tag!=null) {
if(tag.hasKey("Type")) {tex=tag.getInteger("Type");}
//if(tag.hasKey("Size")) {tmdl=tag.getInteger("Size");}
}

GL11.glPushMatrix();
GL11.glTranslatef(0.5F, 0.0F, 0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);

Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("minecraft", "textures/blocks/comparator_off.png"));
this.mdl1.renderPart("base");
Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("minecraft", "textures/blocks/redstone_block.png"));
this.mdl1.renderPart("chip");
Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("minecraft", "textures/blocks/iron_block.png"));
this.mdl1.renderPart("leg_l1");
this.mdl1.renderPart("leg_l2");
this.mdl1.renderPart("leg_l3");
this.mdl1.renderPart("leg_l4");
this.mdl1.renderPart("leg_l5");
this.mdl1.renderPart("leg_r1");
this.mdl1.renderPart("leg_r2");
this.mdl1.renderPart("leg_r3");
this.mdl1.renderPart("leg_r4");
this.mdl1.renderPart("leg_r5");


GL11.glPopMatrix();
}

}
