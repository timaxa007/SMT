package smt.pack.common.client;

import java.io.File;
import java.util.HashMap;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.ImageBufferDownload;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StringUtils;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.common.MinecraftForge;

import com.mojang.authlib.minecraft.MinecraftProfileTexture;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class RenderSkin {
	public static String skinurl = "http://MinecraftSkins/%s.png";
	public static String capeurl = "http://MinecraftCloaks/%s.png";
	public HashMap renderedSkins = new HashMap();
	public HashMap renderedCape = new HashMap();
	Minecraft mc;

	@Mod.EventHandler
	public void load(FMLInitializationEvent event) {
		this.mc = Minecraft.getMinecraft();
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void onRenderPlayer(RenderPlayerEvent.Pre event) {
		EntityPlayer entity = event.entityPlayer;
		String name = entity.getCommandSenderName();
		if (!this.renderedSkins.containsKey(name)) {
			ResourceLocation skin = getSkin(name);
			((AbstractClientPlayer)entity).func_152121_a(MinecraftProfileTexture.Type.SKIN, skin);

			this.renderedSkins.put(name, skin);
		}
		else {
			((AbstractClientPlayer)entity).func_152121_a(MinecraftProfileTexture.Type.SKIN, (ResourceLocation)this.renderedSkins.get(name));
		}
		if (!this.renderedCape.containsKey(name)) {
			ResourceLocation cape = getCloak(name);
			((AbstractClientPlayer)entity).func_152121_a(MinecraftProfileTexture.Type.CAPE, cape);
			this.renderedCape.put(name, cape);
		} else {
			((AbstractClientPlayer)entity).func_152121_a(MinecraftProfileTexture.Type.CAPE, (ResourceLocation)this.renderedCape.get(name));
		}
	}

	@SubscribeEvent
	public void onRenderPlayer(RenderHandEvent event) {
		event.setCanceled(true);
		EntityPlayer entity = this.mc.thePlayer;

		String name = entity.getCommandSenderName();
		if (!this.renderedSkins.containsKey(name)) {
			ResourceLocation skin = getSkin(name);
			((AbstractClientPlayer)entity).func_152121_a(MinecraftProfileTexture.Type.SKIN, skin);
			this.renderedSkins.put(name, skin);
		} else {
			((AbstractClientPlayer)entity).func_152121_a(MinecraftProfileTexture.Type.SKIN, (ResourceLocation)this.renderedSkins.get(name));
		}
		event.setCanceled(false);
	}

	public static ResourceLocation getSkin(String name) {
		ResourceLocation skin = new ResourceLocation("patchskins/" + StringUtils.stripControlCodes(name));
		TextureManager var2 = Minecraft.getMinecraft().renderEngine;
		ITextureObject var3 = var2.getTexture(skin);
		if (var3 == null) {
			ThreadDownloadImageData var31 = new ThreadDownloadImageData((File)null, String.format(skinurl, new Object[] { StringUtils.stripControlCodes(name) }), AbstractClientPlayer.locationStevePng, new ImageBufferDownload());
			var2.loadTexture(skin, var31);
		}
		return skin;
	}

	public static ResourceLocation getCloak(String name) {
		ResourceLocation cloak = new ResourceLocation("patchcloaks/" + StringUtils.stripControlCodes(name));
		TextureManager var2 = Minecraft.getMinecraft().renderEngine;
		ITextureObject var3 = var2.getTexture(cloak);
		if (var3 == null) {
			ThreadDownloadImageData var31 = new ThreadDownloadImageData((File)null, String.format(capeurl, new Object[] { StringUtils.stripControlCodes(name) }), (ResourceLocation)null, new ImageBufferDownload());
			var2.loadTexture(cloak, var31);
		}
		return cloak;
	}

}
