package smt.pack.technology.client.gui;

import java.util.ArrayList;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import smt.pack.technology.SMTTechnology;
import smt.pack.technology.api.IElectricItem;
import smt.pack.technology.tile.TileEntityElectricBoxAccumulator;

@SideOnly(Side.CLIENT)
public class ElectricBoxAccumulatorGuiContainer extends net.minecraft.client.gui.inventory.GuiContainer {

	private static final ResourceLocation guiTextures =
			new ResourceLocation(SMTTechnology.MODID, "textures/gui/container/electric_block_accumulator.png");
	private TileEntityElectricBoxAccumulator te;
	private ArrayList<String> list_text_energy = new ArrayList<String>();
	private ArrayList<String> list_text_temperature = new ArrayList<String>();

	public ElectricBoxAccumulatorGuiContainer(InventoryPlayer invPlayer, TileEntityElectricBoxAccumulator tile) {
		super(new smt.pack.technology.inventory.ElectricBoxAccumulatorContainer(invPlayer, tile));
		te = tile;
		xSize = 176;
		ySize = 174;

	}

	@Override
	public void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		int posX = (this.width - this.xSize) / 2;
		int posY = (this.height - this.ySize) / 2;
		int mouseXoffset = mouseX - posX;
		int mouseYoffset = mouseY - posY;
		if (te != null) {
			String s = te.hasCustomName() ? te.getName() : StatCollector.translateToLocal(te.getName());
			fontRendererObj.drawString(s, xSize / 2 - fontRendererObj.getStringWidth(s) / 2, 3, 4210752);
			//fontRendererObj.drawString("Energy: " + te.energy + "/" + te.energyMax, 8, 37, 0xC6C6C6);
			//StatCollector.translateToLocal
		}
		fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, ySize - 94, 4210752);

		if (mouseXoffset >= 160 && mouseYoffset >= 15 && mouseXoffset <= 166 && mouseYoffset <= 66) {
			//drawCreativeTabHoveringText(list, mouseXoffset, mouseYoffset);
			list_text_energy.clear();
			list_text_energy.add("Energy:");
			list_text_energy.add("  " + String.format("%.2f", scaled(te.getEnergy(), te.getEnergyMax(), 100F)) + "%");
			list_text_energy.add("  " + te.getEnergy() + "/" + te.getEnergyMax() + ".");
			drawHoveringText(list_text_energy, mouseXoffset, mouseYoffset, mc.fontRenderer);
		}

		if (mouseXoffset >= 148 && mouseYoffset >= 15 && mouseXoffset <= 154 && mouseYoffset <= 66) {
			list_text_energy.clear();
			list_text_energy.add("Temperature:");
			list_text_energy.add("  " + te.temperature + ".");
			drawHoveringText(list_text_energy, mouseXoffset, mouseYoffset, mc.fontRenderer);
		}

	}

	@Override
	public void drawGuiContainerBackgroundLayer(float parTick, int mouseX, int mouseY) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.getTextureManager().bindTexture(guiTextures);
		int k = (width - xSize) / 2;
		int l = (height - ySize) / 2;
		int mouseXoffset = mouseX - k;
		int mouseYoffset = mouseY - l;
		drawTexturedModalRect(k, l, 0, 0, xSize, ySize);

		if (te != null) {

			//System.out.println(mouseXoffset + "/" + mouseYoffset);

			{
				ItemStack slot0 = te.getInventory().getStackInSlot(0);
				if (slot0 != null) {
					boolean eng0 = slot0.getItem() instanceof IElectricItem;
					if (!eng0) GL11.glColor4f(1.0F, 0.0F, 0.0F, 1.0F);
					drawTexturedModalRect(k + 7, l + 14, 176, 52, 18, 18);
					if (!eng0) GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
				}
			}

			{
				ItemStack slot1 = te.getInventory().getStackInSlot(1);
				if (te.getInventory().getStackInSlot(1) != null) {
					boolean eng1 = slot1.getItem() instanceof IElectricItem;
					if (!eng1) GL11.glColor4f(1.0F, 0.0F, 0.0F, 1.0F);
					drawTexturedModalRect(k + 7, l + 50, 176, 52, 18, 18);
					if (!eng1) GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
				}
			}

			{
				boolean flag1 = false;
				int scl1 = (int)scaled(te.getEnergy(), te.getEnergyMax(), 52F);
				if (!flag1) {
					scl1 /= 3;
					scl1 *= 3;
				}
				drawTexturedModalRect(k + 160, l + 15 - scl1 + 52, 176, 0 - scl1 + 52, 8, 52 + scl1 - 52);
				if (!flag1) drawTexturedModalRect(k + 160, l + 15, 184, 0, 8, 52);

			}

			{
				boolean flag2 = false;
				//int scl2 = (int)(((float)te.energy / (float)te.energyMax) * 52F);
				if (!flag2) {
					//scl2 /= 3;
					//scl2 *= 3;
				}
				drawTexturedModalRect(k + 149, l + 15, 192, 0, 6, 52);
				if (!flag2) drawTexturedModalRect(k + 149, l + 15, 198, 0, 6, 52);

			}

		}

		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	}

	public static float scaled(int min, int max, float scale) {
		return (float)min / (float)max * scale;
	}
	/*
	public void drawtInfo(List list) {
		if (!list.isEmpty()) {
			GL11.glDisable(GL12.GL_RESCALE_NORMAL);
			RenderHelper.disableStandardItemLighting();
			GL11.glDisable(GL11.GL_LIGHTING);
			GL11.glDisable(GL11.GL_DEPTH_TEST);
			int k = 0;
			Iterator iterator = list.iterator();

			while (iterator.hasNext()) {
				String s = (String)iterator.next();
				int l = font.getStringWidth(s);

				if (l > k) {
					k = l;
				}
			}

			int j2 = p_146283_2_ + 12;
			int k2 = p_146283_3_ - 12;
			int i1 = 8;

            if (list.size() > 1)
            {
                i1 += 2 + (list.size() - 1) * 10;
            }

            if (j2 + k > this.width)
            {
                j2 -= 28 + k;
            }

            if (k2 + i1 + 6 > this.height)
            {
                k2 = this.height - i1 - 6;
            }

            this.zLevel = 300.0F;
            itemRender.zLevel = 300.0F;
            int j1 = -267386864;
            this.drawGradientRect(j2 - 3, k2 - 4, j2 + k + 3, k2 - 3, j1, j1);
            this.drawGradientRect(j2 - 3, k2 + i1 + 3, j2 + k + 3, k2 + i1 + 4, j1, j1);
            this.drawGradientRect(j2 - 3, k2 - 3, j2 + k + 3, k2 + i1 + 3, j1, j1);
            this.drawGradientRect(j2 - 4, k2 - 3, j2 - 3, k2 + i1 + 3, j1, j1);
            this.drawGradientRect(j2 + k + 3, k2 - 3, j2 + k + 4, k2 + i1 + 3, j1, j1);
            int k1 = 1347420415;
            int l1 = (k1 & 16711422) >> 1 | k1 & -16777216;
            this.drawGradientRect(j2 - 3, k2 - 3 + 1, j2 - 3 + 1, k2 + i1 + 3 - 1, k1, l1);
            this.drawGradientRect(j2 + k + 2, k2 - 3 + 1, j2 + k + 3, k2 + i1 + 3 - 1, k1, l1);
            this.drawGradientRect(j2 - 3, k2 - 3, j2 + k + 3, k2 - 3 + 1, k1, k1);
            this.drawGradientRect(j2 - 3, k2 + i1 + 2, j2 + k + 3, k2 + i1 + 3, l1, l1);

            for (int i2 = 0; i2 < list.size(); ++i2)
            {
                String s1 = (String)list.get(i2);
                fontRendererObj.drawStringWithShadow(s1, j2, k2, -1);

                if (i2 == 0)
                {
                    k2 += 2;
                }

                k2 += 10;
            }

            this.zLevel = 0.0F;
            itemRender.zLevel = 0.0F;
            GL11.glEnable(GL11.GL_LIGHTING);
            GL11.glEnable(GL11.GL_DEPTH_TEST);
            RenderHelper.enableStandardItemLighting();
            GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        }
	}
	 */
}
