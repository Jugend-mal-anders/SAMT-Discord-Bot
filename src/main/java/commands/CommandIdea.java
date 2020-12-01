package commands;

import javax.annotation.Nonnull;

import commands.interfaces.Command;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class CommandIdea implements Command {

	@Override
	public String getName() {
		return "idea";
	}

	@Override
	public void onCall(@Nonnull MessageReceivedEvent event) {

		MessageChannel channel = event.getChannel();
		String messageTextRaw = event.getMessage().getContentRaw();

		String[] args = messageTextRaw.split(" ", 3);
		if (args.length < 3) {
			channel.sendMessage("__Please enter a server.__ \n"
					+ "If you have a general suggestion choose \"all\", if the suggestion applies to a specific server choose between \"tc\", \"znd\", \"ir\" or \"rtm\". For example, the command should look like this: \"!idea **all** *Idea*\".")
					.queue();
		} else {

			Long channelId = null;
			String team = null;

			switch (args[1].toLowerCase()) {
			case "all":
				channelId = 625701271051042905L;
				team = ".";
				break;
			case "tc":
				channelId = 518535634923814936L;
				team = " of Traincraft.";
				break;
			case "znd":
				channelId = 709848903540801586L;
				team = " of Zora no Densha.";
				break;
			case "ir":
				channelId = 530331487241764884L;
				team = " of Immersive Railroading.";
				break;
			case "rtm":
				channelId = 530331723238473728L;
				team = " of Real Train Mod.";
				break;
			default:
				channelId = null;
				team = null;
			}

			if (channelId != null) {

				event.getGuild().getTextChannelById(channelId)
						.sendMessage("**Idee von:** " + event.getAuthor().getAsMention() + "\n \n" + args[2])
						.queue(message -> {
							message.addReaction(event.getGuild().getEmoteById(640284218974273546L)).queue();
							message.addReaction(event.getGuild().getEmoteById(640284247084498965L)).queue();
						});
				event.getChannel()
						.sendMessage("Thank you very much for your suggestion " + event.getAuthor().getAsMention()
								+ "! It was successfully forwarded to the entire team" + team)
						.queue();

			}
		}

	}

}
