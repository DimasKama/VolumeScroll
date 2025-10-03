package ru.dimaskama.volumescroll.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.state.PlayerEntityRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.dimaskama.volumescroll.VolumeScroll;

@Mixin(PlayerEntityRenderer.class)
abstract class PlayerEntityRendererMixin {

    @Inject(method = "renderLabelIfPresent(Lnet/minecraft/client/render/entity/state/PlayerEntityRenderState;Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/command/OrderedRenderCommandQueue;Lnet/minecraft/client/render/state/CameraRenderState;)V", at = @At("HEAD"))
    private void modifyNamePlateText(CallbackInfo ci, @Local(argsOnly = true) PlayerEntityRenderState state) {
        VolumeScroll.modifyNamePlateText(state);
    }

}
