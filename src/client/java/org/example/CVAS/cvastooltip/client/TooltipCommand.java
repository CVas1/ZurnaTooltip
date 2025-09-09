package org.example.CVAS.cvastooltip.client;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.text.Text;

public class TooltipCommand {
    
    public static void register(CommandDispatcher<FabricClientCommandSource> dispatcher) {
        dispatcher.register(ClientCommandManager.literal("tooltips")
            .then(ClientCommandManager.literal("stats")
                .executes(TooltipCommand::showStats))
            .then(ClientCommandManager.literal("save")
                .executes(TooltipCommand::forceSave))
            .then(ClientCommandManager.literal("clear")
                .executes(TooltipCommand::clearTooltips))
        );
    }
    
    private static int showStats(CommandContext<FabricClientCommandSource> context) {
        TooltipManager manager = TooltipManager.getInstance();
        int count = manager.getTooltipCount();
        
        context.getSource().sendFeedback(Text.literal("Collected " + count + " unique tooltips"));
        return count;
    }
      private static int forceSave(CommandContext<FabricClientCommandSource> context) {
        TooltipManager manager = TooltipManager.getInstance();
        manager.forceSave();
        
        context.getSource().sendFeedback(Text.literal("Tooltips saved to config/cvastooltip/tooltips.yml"));
        return 1;
    }
    
    private static int clearTooltips(CommandContext<FabricClientCommandSource> context) {
        TooltipManager manager = TooltipManager.getInstance();
        manager.clearTooltips();
        
        context.getSource().sendFeedback(Text.literal("All tooltips cleared"));
        return 1;
    }
}
