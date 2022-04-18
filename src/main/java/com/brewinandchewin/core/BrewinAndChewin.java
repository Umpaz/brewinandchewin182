package com.brewinandchewin.core;

import javax.annotation.Nonnull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.brewinandchewin.client.BCClientSetup;
import com.brewinandchewin.common.crafting.KegRecipe;
import com.brewinandchewin.core.registry.BCBlockEntityTypes;
import com.brewinandchewin.core.registry.BCBlocks;
import com.brewinandchewin.core.registry.BCContainerTypes;
import com.brewinandchewin.core.registry.BCItems;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import vectorwing.farmersdelight.common.crafting.CuttingBoardRecipe;
import vectorwing.farmersdelight.common.registry.ModBlocks;

@Mod(BrewinAndChewin.MODID)
@Mod.EventBusSubscriber(modid = BrewinAndChewin.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BrewinAndChewin
{
	public static final String MODID = "brewinandchewin";
	public static final CreativeModeTab CREATIVE_TAB = new CreativeModeTab(BrewinAndChewin.MODID)	{
		@Nonnull
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(ModBlocks.STOVE.get());
		}
	};
		
	public static final Logger LOGGER = LogManager.getLogger();
	public static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
	
	public BrewinAndChewin() {
		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

		//modEventBus.addListener(CommonSetup::init);
		modEventBus.addListener(BCClientSetup::init);
		modEventBus.addGenericListener(RecipeSerializer.class, this::registerRecipeSerializers);

		//ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Configuration.COMMON_CONFIG);
		//ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Configuration.CLIENT_CONFIG);

		BCItems.ITEMS.register(modEventBus);
		BCBlocks.BLOCKS.register(modEventBus);
		BCBlockEntityTypes.TILES.register(modEventBus);
		BCContainerTypes.CONTAINER_TYPES.register(modEventBus);

		MinecraftForge.EVENT_BUS.register(this);
	}

	private void registerRecipeSerializers(RegistryEvent.Register<RecipeSerializer<?>> event) {

		event.getRegistry().register(KegRecipe.SERIALIZER);
	}
}
