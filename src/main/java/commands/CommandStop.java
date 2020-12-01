package commands;

import java.util.logging.Logger;

import commands.interfaces.Command;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class CommandStop implements Command {

	private static Logger logger = Logger.getLogger("CommandStop");

	@Override
	public String getName() {
		return "stop";
	}

	@Override
	public void onCall(MessageReceivedEvent event) {

		MessageChannel channel = event.getChannel();
		Member member = event.getMember();

		boolean isAllowed = false;
		for (Role r : member.getRoles()) {
			if (r.getId().equals("394112698511654912")) {
				isAllowed = true;
			}
		}
		if (isAllowed) {
			event.getJDA().shutdown();
			logger.severe("Der Bot wurde gestoppt.");

		} else {
			channel.sendMessage("Du hast keine Berechtigung f\u00fcr diesen Befehl.").queue();
		}
	}

}
