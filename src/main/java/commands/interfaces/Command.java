package commands.interfaces;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public interface Command {

	public String getName();

	public void onCall(MessageReceivedEvent event);

}
