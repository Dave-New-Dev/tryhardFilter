package dan.tryhardfilter;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class TCommandMod implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> {
            dispatcher.register(ClientCommandManager.literal("t")
                    .then(ClientCommandManager.argument("message", net.minecraft.command.argument.MessageArgumentType.message())
                            .executes(context -> {
                                String message = net.minecraft.command.argument.MessageArgumentType.getMessage(context, "message").getString();
                                message = message.replace("ryan", "tryhard");
                                MinecraftClient.getInstance().player.sendChatMessage(message);
                                return 1;
                            }))
            );
        });
    }
}
