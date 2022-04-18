package com.brewinandchewin.core.registry;

import java.util.function.ToIntFunction;

import com.brewinandchewin.common.block.KegBlock;
import com.brewinandchewin.core.BrewinAndChewin;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BCBlocks
{
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, BrewinAndChewin.MODID);

	//Blocks

	// Workstations
	public static final RegistryObject<Block> KEG = BLOCKS.register("keg", KegBlock::new);

	private static ToIntFunction<BlockState> litBlockEmission(int level) {
		return (state) -> state.getValue(BlockStateProperties.LIT) ? level : 0;
	}
}
