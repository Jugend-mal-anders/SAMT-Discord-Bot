package commands;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import commands.interfaces.Command;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class CommandAFK implements Command {

	@Override
	public String getName() {
		return "afk";
	}

	@SuppressWarnings("unused")
	@Override
	public void onCall(MessageReceivedEvent event) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime now = LocalDateTime.now();

		event.getChannel().sendMessage("[WIP] Kommt demnächst..").queue();

		// TODO
	}

}
