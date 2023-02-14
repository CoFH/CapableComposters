package cofh.capable_composters.mixin;

import cofh.capable_composters.util.ComposterUtils;
import net.minecraft.core.dispenser.DispenseItemBehavior;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.DispenserBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin (DispenserBlock.class)
public abstract class DispenserBlockMixin {

    @Inject (method = "getDispenseMethod", at = @At ("TAIL"), cancellable = true)
    private void getDispenseMethod(ItemStack stack, CallbackInfoReturnable<DispenseItemBehavior> callback) {

        if (ComposterBlock.COMPOSTABLES.getFloat(stack.getItem()) > 0.0F) {
            DispenseItemBehavior defaultReturn = callback.getReturnValue();
            callback.setReturnValue(ComposterUtils.dispenseCompostable(defaultReturn));
        }
    }

}
