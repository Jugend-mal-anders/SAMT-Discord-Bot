package commands;

import commands.interfaces.Command;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.MessageHistory;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class CommandRemove implements Command {

	@Override
	public String getName() {
		return "remove";
	}

	@Override
	public void onCall(MessageReceivedEvent event) {

		MessageChannel channel = event.getChannel();
		String messageTextRaw = event.getMessage().getContentRaw();
		TextChannel textChannel = event.getTextChannel();
		Member member = event.getMember();

		boolean isAllowed = false;
		for (Role r : member.getRoles()) {
			if (r.getId().equals("394112698511654912")) {
				isAllowed = true;
			}
		}
		if (isAllowed) {
			String[] args = messageTextRaw.split(" ");
			if (args.length == 1) {
				channel.sendMessage("Gib eine Anzahl an zu l\u00f6schenden Nachrichten an. (!remove 5)").queue();
			} else {
				event.getMessage().delete().complete();
				MessageHistory mh = new MessageHistory(textChannel);
				textChannel.deleteMessages(mh.retrievePast(Integer.parseInt(args[1])).complete()).queue();
			}
		} else {
			channel.sendMessage("Du hast keine Berechtigung f\u00fcr diesen Befehl.").queue();
		}
	}

}
