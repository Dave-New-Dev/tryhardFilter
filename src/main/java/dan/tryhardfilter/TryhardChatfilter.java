package dan.tryhardfilter;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.message.v1.ClientSendMessageEvents;
import net.minecraft.text.Text;

public class TryhardChatfilter implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // Register the chat modification event
        ClientSendMessageEvents.MODIFY_CHAT.register((message) -> {
            // Replace all variations of "foo" with "bar"
            return message.replaceAll("(?i)\\bfoo\\b", "bar");
        });
    }
}
