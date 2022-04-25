package com.brewinandchewin.core.registry;

import com.brewinandchewin.common.item.BoozeItem;
import com.brewinandchewin.common.item.DreadNogItem;
import com.brewinandchewin.core.BrewinAndChewin;
import com.brewinandchewin.core.utility.BCFoods;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BCItems
{
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BrewinAndChewin.MODID);

	//Items
	
	public static final RegistryObject<Item> KEG = ITEMS.register("keg",
			() -> new BlockItem(BCBlocks.KEG.get(), new Item.Properties().stacksTo(1).tab(BrewinAndChewin.CREATIVE_TAB)));

	
	public static final RegistryObject<Item> TANKARD = ITEMS.register("tankard",
			() -> new Item(new Item.Properties().tab(BrewinAndChewin.CREATIVE_TAB)));
	
	public static final RegistryObject<Item> BEER = ITEMS.register("beer",
			() -> new BoozeItem(1, 8, 0.50F, new Item.Properties().craftRemainder(BCItems.TANKARD.get()).tab(BrewinAndChewin.CREATIVE_TAB)));
	public static final RegistryObject<Item> VODKA = ITEMS.register("vodka",
			() -> new BoozeItem(1, 12, 0.75F, new Item.Properties().craftRemainder(BCItems.TANKARD.get()).tab(BrewinAndChewin.CREATIVE_TAB)));
	public static final RegistryObject<Item> MEAD = ITEMS.register("mead",
			() -> new BoozeItem(1, 8, 0.60F, new Item.Properties().food(BCFoods.MEAD).craftRemainder(BCItems.TANKARD.get()).tab(BrewinAndChewin.CREATIVE_TAB)));
	public static final RegistryObject<Item> RICE_WINE = ITEMS.register("rice_wine",
			() -> new BoozeItem(1, 5, 0.40F, new Item.Properties().food(BCFoods.RICE_WINE).craftRemainder(BCItems.TANKARD.get()).tab(BrewinAndChewin.CREATIVE_TAB)));
	public static final RegistryObject<Item> EGG_GROG = ITEMS.register("egg_grog",
			() -> new BoozeItem(1, 0, 0.15F, new Item.Properties().food(BCFoods.EGG_GROG).craftRemainder(BCItems.TANKARD.get()).tab(BrewinAndChewin.CREATIVE_TAB)));
	public static final RegistryObject<Item> STRONGROOT_ALE = ITEMS.register("strongroot_ale",
			() -> new BoozeItem(2, 12, 0.50F, new Item.Properties().food(BCFoods.STRONGROOT_ALE).craftRemainder(BCItems.TANKARD.get()).tab(BrewinAndChewin.CREATIVE_TAB)));
	public static final RegistryObject<Item> SACCHARINE_RUM = ITEMS.register("saccharine_rum",
			() -> new BoozeItem(2, 8, 0.35F, new Item.Properties().food(BCFoods.SACCHARINE_RUM).craftRemainder(BCItems.TANKARD.get()).tab(BrewinAndChewin.CREATIVE_TAB)));
	public static final RegistryObject<Item> PALE_JANE = ITEMS.register("pale_jane",
			() -> new BoozeItem(1, 5, 0.50F, new Item.Properties().food(BCFoods.PALE_JANE).craftRemainder(BCItems.TANKARD.get()).tab(BrewinAndChewin.CREATIVE_TAB)));
	
	public static final RegistryObject<Item> DREAD_NOG = ITEMS.register("dread_nog",
			() -> new DreadNogItem(3, 5, 0.75F, new Item.Properties().craftRemainder(BCItems.TANKARD.get()).tab(BrewinAndChewin.CREATIVE_TAB)));
	
	public static final RegistryObject<Item> SALTY_FOLLY = ITEMS.register("salty_folly",
			() -> new BoozeItem(2, 10, 0.80F, new Item.Properties().food(BCFoods.SALTY_FOLLY).craftRemainder(BCItems.TANKARD.get()).tab(BrewinAndChewin.CREATIVE_TAB)));
	public static final RegistryObject<Item> STEEL_TOE_STOUT = ITEMS.register("steel_toe_stout",
			() -> new BoozeItem(3, 10, 0.65F, new Item.Properties().food(BCFoods.STEEL_TOE_STOUT).craftRemainder(BCItems.TANKARD.get()).tab(BrewinAndChewin.CREATIVE_TAB)));
	public static final RegistryObject<Item> GLITTERING_GRENADINE = ITEMS.register("glittering_grenadine",
			() -> new BoozeItem(1, 5, 0.40F, new Item.Properties().food(BCFoods.GLITTERING_GRENADINE).craftRemainder(BCItems.TANKARD.get()).tab(BrewinAndChewin.CREATIVE_TAB)));
	public static final RegistryObject<Item> BLOODY_MARY = ITEMS.register("bloody_mary",
			() -> new BoozeItem(1, 12, 0.60F, new Item.Properties().food(BCFoods.BLOODY_MARY).craftRemainder(BCItems.TANKARD.get()).tab(BrewinAndChewin.CREATIVE_TAB)));
	public static final RegistryObject<Item> RED_RUM = ITEMS.register("red_rum",
			() -> new BoozeItem(1, 18, 0.50F, new Item.Properties().food(BCFoods.RED_RUM).craftRemainder(BCItems.TANKARD.get()).tab(BrewinAndChewin.CREATIVE_TAB)));
	public static final RegistryObject<Item> WITHERING_DROSS = ITEMS.register("withering_dross",
			() -> new BoozeItem(3, 20, 0.90F, new Item.Properties().food(BCFoods.WITHERING_DROSS).craftRemainder(BCItems.TANKARD.get()).tab(BrewinAndChewin.CREATIVE_TAB)));
	public static final RegistryObject<Item> KOMBUCHA = ITEMS.register("kombucha",
			() -> new BoozeItem(1, 5, 0.40F, new Item.Properties().food(BCFoods.KOMBUHCA).craftRemainder(BCItems.TANKARD.get()).tab(BrewinAndChewin.CREATIVE_TAB)));
	
}
