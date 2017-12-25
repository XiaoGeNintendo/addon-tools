package com.hhs.xgn.AddonTools.client.gui;

import com.hhs.xgn.AddonTools.AddonTools;
import com.hhs.xgn.AddonTools.gui.ReturnerContainer;
import com.hhs.xgn.AddonTools.utils.i18nHelper;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
@SideOnly(Side.CLIENT)
public class ReturnerGuiContainer extends GuiContainer {

	 private static final String TEXTURE_PATH = AddonTools.modid + ":" + "textures/gui/container/gui_returner.png";
	 private static final ResourceLocation TEXTURE = new ResourceLocation(TEXTURE_PATH);
	public ReturnerGuiContainer(Container p_i1072_1_) {
		super(p_i1072_1_);
		this.xSize = 176;
        this.ySize = 156;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0F, 1.0F, 1.0F);

        this.mc.getTextureManager().bindTexture(TEXTURE);
        int offsetX = (this.width - this.xSize) / 2, offsetY = (this.height - this.ySize) / 2;

        this.drawTexturedModalRect(offsetX, offsetY, 0, 0, this.xSize, this.ySize);

	}
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		String title = i18nHelper.translate("container.returner.title");
        this.fontRendererObj.drawString(title, (this.xSize - this.fontRendererObj.getStringWidth(title)) / 2, 6, 0x404040);
	}
}
