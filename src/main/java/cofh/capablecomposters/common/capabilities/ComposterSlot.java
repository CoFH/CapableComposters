package cofh.capablecomposters.common.capabilities;

import cofh.capablecomposters.common.block.entity.ComposterBlockEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.items.IItemHandler;
import org.jetbrains.annotations.NotNull;

public class ComposterSlot implements IItemHandler {

    protected final ComposterBlockEntity blockEntity;

    public ComposterSlot(ComposterBlockEntity blockEntity) {

        this.blockEntity = blockEntity;
    }

    // region IItemHandler
    @Override
    public int getSlots() {

        return 1;
    }

    @Override
    public @NotNull ItemStack getStackInSlot(int slot) {

        if (blockEntity.isRemoved()) {
            return ItemStack.EMPTY;
        }
        if (blockEntity.getBlockState().getValue(ComposterBlock.LEVEL) == ComposterBlock.READY) {
            return new ItemStack(Items.BONE_MEAL);
        }
        return ItemStack.EMPTY;
    }

    @Override
    public @NotNull ItemStack insertItem(int slot, @NotNull ItemStack stack, boolean simulate) {

        return stack;
    }

    @Override
    public @NotNull ItemStack extractItem(int slot, int amount, boolean simulate) {

        ItemStack item = getStackInSlot(0);
        if (blockEntity.isRemoved() || slot > 0 || amount <= 0 || item.isEmpty()) {
            return ItemStack.EMPTY;
        }
        if (!simulate) {
            blockEntity.replaceBlockAndUpdate(Blocks.COMPOSTER.defaultBlockState());
        }
        return item.copy();
    }

    @Override
    public int getSlotLimit(int slot) {

        return 1;
    }

    @Override
    public boolean isItemValid(int slot, @NotNull ItemStack stack) {

        return false;
    }
    // endregion
}
