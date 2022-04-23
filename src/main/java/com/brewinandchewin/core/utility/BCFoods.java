package com.brewinandchewin.core.utility;

import net.minecraft.world.food.FoodProperties;

public class BCFoods
{
	// Drinks (mostly for effects)
	public static final FoodProperties BEER = (new FoodProperties.Builder())
			.build();
	
	public static final FoodProperties KIMCHI = (new FoodProperties.Builder())
			.nutrition(5).saturationMod(0.6F).build();
	public static final FoodProperties JERKY = (new FoodProperties.Builder())
			.nutrition(4).saturationMod(0.4F)
			.fast().build();
	public static final FoodProperties PICLKED_PICKLES = (new FoodProperties.Builder())
			.nutrition(6).saturationMod(0.3F).build();
	public static final FoodProperties KIPPERS = (new FoodProperties.Builder())
			.nutrition(5).saturationMod(0.7F).build();
	public static final FoodProperties COCOA_FUDGE = (new FoodProperties.Builder())
			.nutrition(6).saturationMod(0.8F).build();
	
	
	
	// Bowl Foods
//	public static final FoodProperties BLACK_COD = (new FoodProperties.Builder())
			//.nutrition(10).saturationMod(0.9f)
			//.effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 3600, 0), 1.0F)
			//.effect(() -> new MobEffectInstance(FREffects.CAFFEINATED.get(), 600, 0), 1.0F).build();
	
}
