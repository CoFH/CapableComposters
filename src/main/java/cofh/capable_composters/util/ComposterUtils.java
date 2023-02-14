package cofh.capable_composters.util;

import net.minecraft.core.BlockPos;
import net.minecraft.core.dispenser.DispenseItemBehavior;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.state.BlockState;

public class ComposterUtils {

    private ComposterUtils() {

    }

    // region DISPENSER LOGIC
    public static DispenseItemBehavior dispenseCompostable(DispenseItemBehavior defaultReturn) {

        return (source, item) -> {

            ServerLevel level = source.getLevel();
            BlockPos pos = source.getPos().relative(source.getBlockState().getValue(DispenserBlock.FACING));
            BlockState state = level.getBlockState(pos);

            if (state.getBlock() instanceof ComposterBlock) {
                BlockState newState = ComposterBlock.insertItem(state, level, item, pos);
                if (state != newState && newState.getValue(ComposterBlock.LEVEL) == 7) {
                    level.levelEvent(1500, pos, 1);
                }
                return item;
            }
            return defaultReturn.dispense(source, item);
        };
    }
    // endregion
}
