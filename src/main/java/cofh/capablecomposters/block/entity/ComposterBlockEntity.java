package cofh.capablecomposters.block.entity;

import cofh.capablecomposters.capabilities.ComposterSlot;
import cofh.capablecomposters.init.BlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;

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

        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            if (!itemCap.isPresent()) {
                itemCap = LazyOptional.of(() -> itemSlot);
            }
            return itemCap.cast();
        }
        return LazyOptional.empty();
    }
    // endregion
}
