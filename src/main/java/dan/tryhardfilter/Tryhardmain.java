package dan.tryhardfilter;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.message.v1.ClientSendMessageEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Pattern;

public class Tryhardmain implements ModInitializer {
	public static final String MOD_ID = "tryhardfilter";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
    public void onInitialize() {
        LOGGER.info("Wsg world (●'◡'●)"); //logger 👍

        ClientSendMessageEvents.MODIFY_CHAT.register((message) -> {
// old code using case-sensitive finding
//            if (message.contains("ryan")) {
//                message = message.replaceAll("(?i)ryan","tryhard");
//                return message;
//            }

            // new code using case-insensitive finding (using pattern is more performant than setting to lower case)
            if (Pattern.compile(Pattern.quote("ryan"), Pattern.CASE_INSENSITIVE).matcher(message).find()) {
                message = message.replaceAll("(?i)ryan","tryhard");
                return message;
            }
            return message;
        });
    }
}



;