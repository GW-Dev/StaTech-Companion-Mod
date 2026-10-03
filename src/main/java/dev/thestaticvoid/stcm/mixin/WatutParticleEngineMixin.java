package dev.thestaticvoid.stcm.mixin;

import net.minecraft.client.Camera;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.renderer.LightTexture;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(targets = "com.corosus.watut.client.CustomParticleEngine")
public class WatutParticleEngineMixin {

    @Inject(
        method = "render(Lnet/minecraft/client/renderer/LightTexture;Lnet/minecraft/client/Camera;F)V",
        at = @At("TAIL"),
        cancellable = true
    )
    private void onRenderParticles(LightTexture lightTexture, Camera camera, float partialTick, CallbackInfo ci) {
    // Inject to fix the WATUT #73 issue per https://github.com/Corosauce/WATUT/issues/73#issuecomment-4079913003
        RenderSystem.depthMask(true);
        RenderSystem.disableBlend();
        lightTexture.turnOffLightLayer();
    }
}