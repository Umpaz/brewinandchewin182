package com.brewinandchewin.core.registry;

import com.brewinandchewin.common.item.BoozeItem;
import com.brewinandchewin.core.BrewinAndChewin;
import com.brewinandchewin.core.utility.BCFoods;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@SuppressWarnings("unused")
public class BCItems
{
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BrewinAndChewin.MODID);

	// Items
	public static final RegistryObject<Item> KEG = ITEMS.register("keg",
			() -> new BlockItem(BCBlocks.KEG.get(), new Item.Properties().stacksTo(1).tab(BrewinAndChewin.CREATIVE_TAB)));

	
	public static final RegistryObject<Item> BEER = ITEMS.register("beer",
			() -> new BoozeItem(1, 0.25, 300, new Item.Properties().tab(BrewinAndChewin.CREATIVE_TAB)));
	public static final RegistryObject<Item> VODKA = ITEMS.register("vodka",
			() -> new BoozeItem(1, 0.75, 600, new Item.Properties().tab(BrewinAndChewin.CREATIVE_TAB)));
	public static final RegistryObject<Item> MEAD = ITEMS.register("mead",
			() -> new BoozeItem(1, 0.5, 240, new Item.Properties().tab(BrewinAndChewin.CREATIVE_TAB)));
	public static final RegistryObject<Item> RICE_WINE = ITEMS.register("rice_wine",
			() -> new BoozeItem(1, 0.25, 180, new Item.Properties().tab(BrewinAndChewin.CREATIVE_TAB)));
	public static final RegistryObject<Item> EGG_GROG = ITEMS.register("egg_grog",
			() -> new BoozeItem(1, 0.25, 30, new Item.Properties().tab(BrewinAndChewin.CREATIVE_TAB)));
	public static final RegistryObject<Item> STRONGROOT_ALE = ITEMS.register("strongroot_ale",
			() -> new BoozeItem(2, 0.25, 300, new Item.Properties().tab(BrewinAndChewin.CREATIVE_TAB)));
	public static final RegistryObject<Item> SACCHARINE_RUM = ITEMS.register("saccharine_rum",
			() -> new BoozeItem(2, 0.25, 480, new Item.Properties().tab(BrewinAndChewin.CREATIVE_TAB)));
	public static final RegistryObject<Item> PALE_JANE = ITEMS.register("pale_jane",
			() -> new BoozeItem(1, 0.25, 360, new Item.Properties().tab(BrewinAndChewin.CREATIVE_TAB)));
	public static final RegistryObject<Item> DREAD_NOG = ITEMS.register("dread_nog",
			() -> new BoozeItem(3, 0.75, 300, new Item.Properties().tab(BrewinAndChewin.CREATIVE_TAB)));
	public static final RegistryObject<Item> SALTY_FOLLY = ITEMS.register("salty_folly",
			() -> new BoozeItem(2, 0.5, 600, new Item.Properties().tab(BrewinAndChewin.CREATIVE_TAB)));
	public static final RegistryObject<Item> STEEL_TOE_STOUT = ITEMS.register("steel_toe_stout",
			() -> new BoozeItem(3, 0, 600, new Item.Properties().tab(BrewinAndChewin.CREATIVE_TAB)));
	public static final RegistryObject<Item> GLITTERING_GRENDALINE = ITEMS.register("gliterring_grendaline",
			() -> new BoozeItem(1, 1, 180, new Item.Properties().tab(BrewinAndChewin.CREATIVE_TAB)));
	public static final RegistryObject<Item> BLOODY_MARY = ITEMS.register("bloody_mary",
			() -> new BoozeItem(1, 2, 720, new Item.Properties().tab(BrewinAndChewin.CREATIVE_TAB)));
	public static final RegistryObject<Item> RED_RUM = ITEMS.register("red_rum",
			() -> new BoozeItem(2, 1, 1080, new Item.Properties().tab(BrewinAndChewin.CREATIVE_TAB)));
	public static final RegistryObject<Item> WITHERING_DROSS = ITEMS.register("withering_dross",
			() -> new BoozeItem(3, 4, 1200, new Item.Properties().tab(BrewinAndChewin.CREATIVE_TAB)));
	public static final RegistryObject<Item> KOMBUCHA = ITEMS.register("kombucha",
			() -> new BoozeItem(1, 1, 300, new Item.Properties().tab(BrewinAndChewin.CREATIVE_TAB)));


}
