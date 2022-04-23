package com.brewinandchewin.core.registry;

import com.brewinandchewin.core.BrewinAndChewin;

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

	
	//public static final RegistryObject<Item> YELLOW_TEA_LEAVES = ITEMS.register("yellow_tea_leaves",
		//	() -> new Item(new Item.Properties().tab(BrewinAndChewin.CREATIVE_TAB)));
}
