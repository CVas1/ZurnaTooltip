package org.example.CVAS.cvastooltip.mixin.client;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HandledScreen.class)
public class HandledScreenMixin {
    
    @Inject(method = "drawMouseoverTooltip", at = @At("HEAD"))
    private void onDrawMouseoverTooltip(DrawContext context, int x, int y, CallbackInfo ci) {
        // This mixin is mainly used as a hook point
        // The actual tooltip capturing will be done by ItemStackMixin
        // when getTooltip is called on ItemStack
    }
}
