package org.example.CVAS.cvastooltip.mixin.client;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import org.example.CVAS.cvastooltip.client.TooltipManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(Screen.class)
public class ScreenMixin {
    
    @Inject(method = "renderTooltip", at = @At("HEAD"))
    private void captureTooltipTexts(DrawContext context, List<Text> lines, int x, int y, CallbackInfo ci) {
        TooltipManager.getInstance().addTooltip(lines);
    }
}
