package org.example.CVAS.cvastooltip.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;

public class CvastooltipClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        System.out.println("CvasTooltip mod initialized - tooltip collection started!");
        
        // Initialize the tooltip manager
        TooltipManager.getInstance();
        
        // Register client commands
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> {
            TooltipCommand.register(dispatcher);
        });
    }
}
