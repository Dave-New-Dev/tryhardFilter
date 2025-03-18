package dan.tryhardfilter;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.minecraft.client.MinecraftClient;
import com.mojang.brigadier.arguments.StringArgumentType;

public class TryhardChatcmd implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> {
            dispatcher.register(ClientCommandManager.literal("t")
                    .then(ClientCommandManager.argument("message", StringArgumentType.greedyString())
                            .executes(context -> {
                                String message = StringArgumentType.getString(context, "message");
                                message = message.replace("ryan", "tryhard");

                                MinecraftClient client = MinecraftClient.getInstance();
                                if (client.player != null) {
                                    client.player.networkHandler.sendChatMessage(message);
                                }
                                return 1;
                            }))
            );
        });
    }
}


