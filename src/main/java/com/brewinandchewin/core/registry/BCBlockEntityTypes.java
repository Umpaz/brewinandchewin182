package com.brewinandchewin.core.registry;

import com.brewinandchewin.common.block.entity.KegBlockEntity;
import com.brewinandchewin.core.BrewinAndChewin;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BCBlockEntityTypes
{
	public static final DeferredRegister<BlockEntityType<?>> TILES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, BrewinAndChewin.MODID);

	public static final RegistryObject<BlockEntityType<KegBlockEntity>> KEG = TILES.register("keg",
			() -> BlockEntityType.Builder.of(KegBlockEntity::new, BCBlocks.KEG.get()).build(null));

}
