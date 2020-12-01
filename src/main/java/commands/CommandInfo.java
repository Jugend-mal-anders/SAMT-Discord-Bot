package commands;

import commands.interfaces.Aliases;
import commands.interfaces.Command;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class CommandInfo implements Command, Aliases {

	@Override
	public String getName() {
		return "info";
	}

	@Override
	public void onCall(MessageReceivedEvent event) {
		event.getChannel().sendMessage("Wir sind LandOfRails! (Info kommt noch...)");
	}

	@Override
	public String[] getAliases() {
		return new String[] { "lor", "landofrails" };
	}

}
