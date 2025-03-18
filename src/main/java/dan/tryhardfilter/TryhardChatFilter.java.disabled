package dan.tryhardfilter;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.message.v1.ClientSendMessageEvents;
import java.util.regex.Pattern;

public class TryhardChatFilter implements ClientModInitializer {
    // Case-insensitive regex pattern for "ryan"
    private static final Pattern RYAN_PATTERN = Pattern.compile("\\bryan\\b", Pattern.CASE_INSENSITIVE);

    @Override
    public void onInitializeClient() {
        // Modify outgoing chat messages before they are sent
        ClientSendMessageEvents.MODIFY_CHAT.register((message) -> {
            return RYAN_PATTERN.matcher(message).replaceAll("tryhard");
        });
    }
}
