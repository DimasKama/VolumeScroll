package ru.dimaskama.volumescroll.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import ru.dimaskama.volumescroll.VolumeScroll;

@Mixin(EntityRenderer.class)
abstract class EntityRendererMixin {

    @ModifyVariable(
            method = "renderLabelIfPresent",
            at = @At("HEAD"),
            index = 2,
            argsOnly = true
    )
    private Text modifyNamePlateText(Text text, @Local(argsOnly = true) EntityRenderState state) {
        return VolumeScroll.modifyNamePlateText(state, text);
    }

}
