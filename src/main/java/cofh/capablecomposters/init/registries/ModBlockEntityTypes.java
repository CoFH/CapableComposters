package cofh.capablecomposters.init.registries;

import cofh.capablecomposters.CapableComposters;
import cofh.capablecomposters.common.block.entity.ComposterBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.RegistryObject;

import static net.minecraft.world.level.block.Blocks.COMPOSTER;

public class ModBlockEntityTypes {

    private ModBlockEntityTypes() {

    }

    public static void register() {

    }

    public static final RegistryObject<BlockEntityType<?>> COMPOSTER_TILE = CapableComposters.BLOCK_ENTITY_TYPES.register("composter", () -> BlockEntityType.Builder.of(ComposterBlockEntity::new, COMPOSTER).build(null));

}
