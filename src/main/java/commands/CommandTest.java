package commands;

import commands.interfaces.Aliases;
import commands.interfaces.Command;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class CommandTest implements Command, Aliases {

	@Override
	public String[] getAliases() {
		return new String[] { "test2", "test3" };
	}

	@Override
	public String getName() {
		return "test";
	}

	@Override
	public void onCall(MessageReceivedEvent event) {
		event.getChannel().sendMessage("Ok.").queue();
	}

}
