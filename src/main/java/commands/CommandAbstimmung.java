package commands;

import java.awt.Color;
import java.util.Calendar;
import java.util.Date;

import commands.interfaces.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import storage.Container;

public class CommandAbstimmung implements Command {

	@Override
	public String getName() {
		return "abstimmung";
	}

	@Override
	public void onCall(MessageReceivedEvent event) {

		String messageTextRaw = event.getMessage().getContentRaw();

		for (Role r : event.getMember().getRoles()) {
			if (r.getId().equals("542380089124323359") || r.getId().equals("438074536508784640")
					|| r.getId().equals("456916096587530241") || r.getId().equals("514172638717935635")
					|| r.getId().equals("709848394725851211") || r.getId().equals("529727596942983187")) {
				event.getMessage().delete().queue();
				String[] args = messageTextRaw.split(" ", 4);

				EmbedBuilder embedBuilder = new EmbedBuilder();
				embedBuilder.setFooter("Abstimmung endet");
				Date date = new Date();
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(date);

				if (isNumeric(args[2])) {
					int timer = Integer.parseInt(args[2]);

					calendar.add(Calendar.HOUR_OF_DAY, timer);
					date = calendar.getTime();

					embedBuilder.setTimestamp(date.toInstant());
					embedBuilder.setTitle(args[3]);
				} else {
					calendar.add(Calendar.HOUR_OF_DAY, 48);
					date = calendar.getTime();

					embedBuilder.setTimestamp(date.toInstant());
					args = messageTextRaw.split(" ", 3);
					embedBuilder.setTitle(args[2]);
				}

				embedBuilder.setAuthor(args[1]);
				embedBuilder.setColor(Color.YELLOW);
				embedBuilder.setDescription("\uD83D\uDC4D Ja! \n \n \uD83D\uDC4E Nein! \n \n :fist: Mir egal...");

				event.getGuild().getTextChannelById(485879824540499969L).sendMessage(embedBuilder.build())
						.queue(message -> {
							message.addReaction("U+1F44D").queue();
							message.addReaction("U+1F44E").queue();
							message.addReaction("U+270A").queue();
							Container.ActiveVotings.add(message.getIdLong());
						});
				break;
			}
		}
	}

	private boolean isNumeric(String strNum) {
		if (strNum == null) {
			return false;
		}
		try {
			Double.parseDouble(strNum);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

}
