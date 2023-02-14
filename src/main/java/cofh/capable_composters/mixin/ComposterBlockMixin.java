package cofh.capable_composters.mixin;

import cofh.capable_composters.block.entity.ComposterBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;

@Mixin (ComposterBlock.class)
public class ComposterBlockMixin implements EntityBlock {

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {

        return new ComposterBlockEntity(pos, state);
    }

}
