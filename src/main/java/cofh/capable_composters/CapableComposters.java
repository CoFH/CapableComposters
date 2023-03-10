package cofh.capable_composters;

import cofh.capable_composters.init.BlockEntityTypes;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod (CapableComposters.MOD_ID)
public class CapableComposters {

    public static final String MOD_ID = "capable_composters";

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, MOD_ID);

    public CapableComposters() {

        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        BLOCK_ENTITY_TYPES.register(modEventBus);

        BlockEntityTypes.register();
    }

}
