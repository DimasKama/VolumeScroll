package ru.dimaskama.volumescroll.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.Mouse;
import org.joml.Vector2i;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.dimaskama.volumescroll.VolumeScroll;

@Mixin(Mouse.class)
abstract class MouseMixin {

    @Inject(
            method = "onMouseScroll",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/network/ClientPlayerEntity;isSpectator()Z"
            ),
            cancellable = true
    )
    private void handleMouseScroll(CallbackInfo ci, @Local Vector2i vector) {
        if (VolumeScroll.handleScroll(vector)) {
            ci.cancel();
        }
    }

}
