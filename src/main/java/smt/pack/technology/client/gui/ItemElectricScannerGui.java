package smt.pack.technology.client.gui;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import smt.pack.technology.SMTTechnology;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ItemElectricScannerGui extends GuiScreen {

	private static final ResourceLocation scannerGuiTextures = new ResourceLocation(SMTTechnology.MODID, "textures/gui/scanner.png");
	
	private int
	xSize = 176,
	ySize = 166,
	metadata = 0;

	private GuiButton
	btn_close,
	btn_left,
	btn_right
	;

	Block block = null;
	ItemStack item_for_scan = null;

	public ItemElectricScannerGui(MovingObjectPosition mop) {
		if (mop == null) return;
		Minecraft mc = Minecraft.getMinecraft();
		switch(mop.typeOfHit) {
		case BLOCK:{
			Block block = mc.theWorld.getBlock(mop.blockX, mop.blockY, mop.blockZ);
			this.block = block;
			int metadata = mc.theWorld.getBlockMetadata(mop.blockX, mop.blockY, mop.blockZ);
			this.metadata = metadata;
			Item item = Item.getItemFromBlock(block);
			if (item != null) metadata = item.getMetadata(metadata);//block.getDamageValue(world, x, y, z)
			item_for_scan = block.getPickBlock(mop, mc.theWorld, mop.blockX, mop.blockY, mop.blockZ, mc.thePlayer);
			break;
		}
		case ENTITY:{
			if (mop.entityHit instanceof EntityItem)
				item_for_scan = ((EntityItem)mop.entityHit).getEntityItem().copy();
			break;
		}
		default:break;
		}
	}

	public ItemElectricScannerGui(ItemStack ifs) {
		item_for_scan = ifs;
	}

	public ItemElectricScannerGui(Block block, int blockMetadata) {
		Item item = Item.getItemFromBlock(block);
		if (item != null) metadata = item.getMetadata(blockMetadata);
		item_for_scan = new ItemStack(block, 1, metadata);
		//Blocks.redstone_wire - is bad Render = crash.
	}

	@Override
	public void initGui() {
		//Keyboard.enableRepeatEvents(true);
		buttonList.clear();
		int posX = (this.width - this.xSize) / 2;
		int posY = (this.height - this.ySize) / 2;
		/*StatCollector.translateToLocal(SMTTechnology.MODID + ".button.close")*/
		buttonList.add(btn_close = new GuiButton(0, posX + xSize - 20 - 4, posY + 4, 20, 20, "x"));
		buttonList.add(btn_left = new GuiButton(1, (width / 2) - 22, posY + ySize - 24, 20, 20, "<"));
		buttonList.add(btn_right = new GuiButton(2, (width / 2) + 2, posY + ySize - 24, 20, 20, ">"));
	}

	@Override
	public void onGuiClosed() {
		//Keyboard.enableRepeatEvents(false);
	}

	@Override
	public void updateScreen() {

	}

	@Override
	public void actionPerformed(GuiButton button) {
		if (button.enabled) {
			if (button.id == 0) mc.displayGuiScreen((GuiScreen)null);
		}
	}

	@Override
	public void keyTyped(char symbol, int key) {
		System.out.println(" - " + key + " - " + symbol);
		if (key == 1) actionPerformed(btn_close);
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float parTick) {
		drawDefaultBackground();

		int posX = (this.width - this.xSize) / 2;
		int posY = (this.height - this.ySize) / 2;

		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.getTextureManager().bindTexture(scannerGuiTextures);
		drawTexturedModalRect(posX, posY, 0, 0, xSize, ySize);

		super.drawScreen(mouseX, mouseY, parTick);

		//RenderHelper.disableStandardItemLighting();
		drawString(fontRendererObj, (item_for_scan != null ? item_for_scan.getDisplayName():
			StatCollector.translateToLocal(SMTTechnology.MODID + ".text.item_for_scan_not_found")
				), posX + 26, posY + 9, 16777215);
		drawString(fontRendererObj, "001", posX + 9, posY + 18 + 11 * 1, 16777215);
		drawString(fontRendererObj, "002", posX + 9, posY + 18 + 11 * 2, 16777215);
		drawString(fontRendererObj, "003", posX + 9, posY + 18 + 11 * 3, 16777215);
		//RenderHelper.enableGUIStandardItemLighting();

		if (item_for_scan != null) {
			itemRender.zLevel = 100.0F;
			itemRender.renderItemAndEffectIntoGUI(fontRendererObj, mc.getTextureManager(), item_for_scan, posX + 6, posY + 6);
			itemRender.zLevel = 0.0F;
			if (mouseX > posX + 6 && mouseX < posX + 6 + 16 && mouseY > posY + 6 && mouseY < posY + 6 + 16)
				renderToolTip(item_for_scan, mouseX, mouseY);
		}

	}

}