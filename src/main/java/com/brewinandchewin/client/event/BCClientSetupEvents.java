package com.brewinandchewin.client.event;

import com.brewinandchewin.core.BrewinAndChewin;

import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BrewinAndChewin.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class BCClientSetupEvents
{
	public static final ResourceLocation EMPTY_CONTAINER_SLOT_BOWL = new ResourceLocation(BrewinAndChewin.MODID, "item/empty_container_slot_bowl");

	
	@SubscribeEvent
	public static void onStitchEvent(TextureStitchEvent.Pre event) {
		ResourceLocation stitching = event.getAtlas().location();
		if (!stitching.equals(TextureAtlas.LOCATION_BLOCKS)) {
			return;
		}
		event.addSprite(EMPTY_CONTAINER_SLOT_BOWL);
	}
}
