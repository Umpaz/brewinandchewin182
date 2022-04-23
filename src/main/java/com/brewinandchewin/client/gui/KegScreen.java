package com.brewinandchewin.client.gui;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

import com.brewinandchewin.common.block.entity.container.KegContainer;
import com.brewinandchewin.core.BrewinAndChewin;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import vectorwing.farmersdelight.common.utility.TextUtils;

@ParametersAreNonnullByDefault
public class KegScreen extends AbstractContainerScreen<KegContainer>
{
	private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation(BrewinAndChewin.MODID, "textures/gui/keg.png");
	private static final Rectangle PROGRESS_ARROW = new Rectangle(77, 44, 0, 9);
	private static final Rectangle FRIGID_BAR = new Rectangle(77, 39, 6, 4);
	private static final Rectangle COLD_BAR = new Rectangle(83, 39, 7, 4);
	private static final Rectangle WARM_BAR = new Rectangle(96, 39, 7, 4);
	private static final Rectangle HOT_BAR = new Rectangle(103, 39, 7, 4);

	public KegScreen(KegContainer screenContainer, Inventory inv, Component titleIn) {
		super(screenContainer, inv, titleIn);
		this.leftPos = 0;
		this.topPos = 0;
		this.imageWidth = 176;
		this.imageHeight = 166;
		this.titleLabelX = 28;
	}

	@Override
	public void render(PoseStack ms, final int mouseX, final int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTemperatureTooltip(ms, mouseX, mouseY);
		this.renderMealDisplayTooltip(ms, mouseX, mouseY);
	}
	
	private void renderTemperatureTooltip(PoseStack ms, int mouseX, int mouseY) {
		if (this.isHovering(77, 39, 27, 4, mouseX, mouseY)) {
			List<Component> tooltip = new ArrayList<>();
			String key = "container.cooking_pot." + (this.menu.getTemperature() > -1 ? "heated" : "not_heated");
			tooltip.add(TextUtils.getTranslation(key, menu));
			this.renderComponentTooltip(ms, tooltip, mouseX, mouseY);
		}
	}

	protected void renderMealDisplayTooltip(PoseStack ms, int mouseX, int mouseY) {
		if (this.minecraft != null && this.minecraft.player != null && this.menu.getCarried().isEmpty() && this.hoveredSlot != null && this.hoveredSlot.hasItem()) {
			if (this.hoveredSlot.index == 5) {
				List<Component> tooltip = new ArrayList<>();

				ItemStack mealStack = this.hoveredSlot.getItem();
				tooltip.add(((MutableComponent) mealStack.getItem().getDescription()).withStyle(mealStack.getRarity().color));

				ItemStack containerStack = this.menu.tileEntity.getContainer();
				String container = !containerStack.isEmpty() ? containerStack.getItem().getDescription().getString() : "";

				tooltip.add(TextUtils.getTranslation("container.cooking_pot.served_on", container).withStyle(ChatFormatting.GRAY));

				this.renderComponentTooltip(ms, tooltip, mouseX, mouseY);
			} else {
				this.renderTooltip(ms, this.hoveredSlot.getItem(), mouseX, mouseY);
			}
		}
	}

	@Override
	protected void renderLabels(PoseStack ms, int mouseX, int mouseY) {
		super.renderLabels(ms, mouseX, mouseY);
		this.font.draw(ms, this.playerInventoryTitle, 8.0f, (float) (this.imageHeight - 96 + 2), 4210752);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int mouseX, int mouseY) {
		// Render UI background
		RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
		if (this.minecraft == null)
			return;

		RenderSystem.setShaderTexture(0, BACKGROUND_TEXTURE);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);


		// Render progress arrow
		int l = this.menu.getCookProgressionScaled();
		this.blit(ms, this.leftPos + PROGRESS_ARROW.x, this.topPos + PROGRESS_ARROW.y, 176, 28, l + 1, PROGRESS_ARROW.height);
		
		int temp = this.menu.getTemperature();
		if (temp < -4 && temp > -9) {
			this.blit(ms, this.leftPos + COLD_BAR.x, this.topPos + COLD_BAR.y, 182, 0, COLD_BAR.width, COLD_BAR.height);
		}
		if (temp < -8) {
			this.blit(ms, this.leftPos + FRIGID_BAR.x, this.topPos + FRIGID_BAR.y, 176, 0, FRIGID_BAR.width, FRIGID_BAR.height);
		}
		if (temp > 4 && temp < 9) {
			this.blit(ms, this.leftPos + WARM_BAR.x, this.topPos + WARM_BAR.y, 195, 0, WARM_BAR.width, WARM_BAR.height);
		}
		if (temp > 8) {
			this.blit(ms, this.leftPos + HOT_BAR.x, this.topPos + HOT_BAR.y, 202, 0, HOT_BAR.width, HOT_BAR.height);
		}
	}
}
