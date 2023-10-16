package cofh.capablecomposters.init;

import cofh.capablecomposters.CapableComposters;
import cofh.capablecomposters.block.entity.ComposterBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.RegistryObject;

import static net.minecraft.world.level.block.Blocks.COMPOSTER;

public class BlockEntityTypes {

    private BlockEntityTypes() {

    }

    public static void register() {

    }

    public static final RegistryObject<BlockEntityType<?>> COMPOSTER_TILE = CapableComposters.BLOCK_ENTITY_TYPES.register("composter", () -> BlockEntityType.Builder.of(ComposterBlockEntity::new, COMPOSTER).build(null));

}
