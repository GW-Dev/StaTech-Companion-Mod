package dev.thestaticvoid.stcm.mixin;

import net.minecraft.client.Camera;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.renderer.LightTexture;
import com.corosus.watut.client.CustomParticleEngine;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CustomParticleEngine.class)
public class WatutParticleEngineMixin {
    @Inject(
        method = "render(Lnet/minecraft/client/renderer/LightTexture;Lnet/minecraft/client/Camera;F)V",
        at = @At("TAIL"),
        cancellable = true,
        remap = false
    )
    private void onRenderParticles(LightTexture lightTexture, Camera camera, float partialTick, CallbackInfo ci) {
    // Inject to fix the WATUT issue #73 per https://github.com/Corosauce/WATUT/issues/73#issuecomment-4079913003
        RenderSystem.enableCull();
    }
}