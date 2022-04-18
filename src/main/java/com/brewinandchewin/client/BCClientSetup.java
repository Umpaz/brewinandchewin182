package com.brewinandchewin.client;

import com.brewinandchewin.client.gui.KegScreen;
import com.brewinandchewin.core.registry.BCContainerTypes;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class BCClientSetup
{
	public static void init(final FMLClientSetupEvent event) {
	//	ItemBlockRenderTypes.setRenderLayer(ModBlocks.WILD_CABBAGES.get(), RenderType.cutout());

		MenuScreens.register(BCContainerTypes.KEG.get(), KegScreen::new);
	}
}
