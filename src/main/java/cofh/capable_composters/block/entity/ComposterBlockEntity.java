package cofh.capable_composters.block.entity;

import cofh.capable_composters.capabilities.ComposterSlot;
import cofh.capable_composters.init.BlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;

public class ComposterBlockEntity extends BlockEntity {

    protected final ComposterSlot itemSlot = new ComposterSlot(this);

    public ComposterBlockEntity(BlockPos blockPos, BlockState state) {

        super(BlockEntityTypes.COMPOSTER_TILE.get(), blockPos, state);
    }

    public void replaceBlockAndUpdate(BlockState newBlockState) {

        if (level != null) {
            level.setBlockAndUpdate(worldPosition, newBlockState);
        }
    }

    @Override
    public void setRemoved() {

        super.setRemoved();
        itemCap.invalidate();
    }

    // region CAPABILITIES
    protected LazyOptional<?> itemCap = LazyOptional.empty();

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {

        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            if (!itemCap.isPresent()) {
                itemCap = LazyOptional.of(() -> itemSlot);
            }
            return itemCap.cast();
        }
        return LazyOptional.empty();
    }
    // endregion
}
