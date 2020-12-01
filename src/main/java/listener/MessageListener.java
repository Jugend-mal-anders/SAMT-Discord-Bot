package listener;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nonnull;

import commands.handler.CommandList;
import commands.interfaces.Aliases;
import commands.interfaces.Command;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import storage.Container;

public class MessageListener extends ListenerAdapter {

	// private static final Logger logger = Logger.getLogger("MessageListener");
	private CommandList commandList = new CommandList();
	public static final String COMMANDPREFIX = "!";

	@Override
	public void onMessageReceived(@Nonnull MessageReceivedEvent event) {
		String messageTextRaw = event.getMessage().getContentRaw();

		if (event.getChannel().getId().equals("485879824540499969") && !event.getAuthor().isBot()
				&& !event.getMessage().getContentRaw().contains("abstimmung")) {
			event.getMessage().delete().queue();
			event.getChannel()
					.sendMessage("Bitte in " + event.getGuild().getTextChannelById(394116521447915521L).getAsMention()
							+ " \u00fcber die aktuellen Abstimmungen diskutieren. Danke :)")
					.complete().delete().queueAfter(10, TimeUnit.SECONDS);
		}

		// Überprüfen ob Befehl
		if (messageTextRaw.startsWith(COMMANDPREFIX)) {

			String cmd = messageTextRaw.substring(1);
			boolean called = false;
			for (Command c : commandList.getCommands()) {
				if (cmd.matches("^" + c.getName() + "(\\s.*|$)")) {
					c.onCall(event);
					called = true;
				} else if (c instanceof Aliases) {
					Aliases a = (Aliases) c;
					if (startsWith(cmd, a.getAliases())) {
						c.onCall(event);
						called = true;
					}
				}

			}

			if (!called) {

				// TODO Implement Databases

				if (!Container.CommandIdeas.exists()) {
					try {
						Container.CommandIdeas.createNewFile();
					} catch (final IOException e) {
						e.printStackTrace();
					}
				}
				try (FileWriter fw = new FileWriter(Container.CommandIdeas, true);
						BufferedWriter bw = new BufferedWriter(fw);
						PrintWriter out = new PrintWriter(bw)) {
					out.println(messageTextRaw);
				} catch (IOException e) {
					e.printStackTrace();
				}
				event.getChannel().sendMessage(
						"Diesen Befehl gibt es noch nicht. Er wurde zur Liste hinzugef\u00fcgt und wird vielleicht irgendwann mit eingebaut :)")
						.queue();
			}

			// Restart
//            if (messageTextRaw.contains("restart")) {
//                boolean isAllowed = false;
//                for (Role r : member.getRoles()) {
//                    if (r.getId().equals("394112698511654912")) {
//                        isAllowed = true;
//                    }
//                }
//                if (isAllowed) {
//                    event.getJDA().shutdown();
//                } else {
//                    channel.sendMessage("Du hast keine Berechtigung f\u00fcr diesen Befehl.").queue();
//                }
//            }

		}
	}

	private boolean startsWith(String target, String[] array) {
		for (String s : array) {
			if (target.matches("^" + s + "(\\s.*|$)"))
				return true;
		}
		return false;
	}

}
