package commands;

import java.awt.Color;

import commands.interfaces.Aliases;
import commands.interfaces.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class CommandHelp implements Command, Aliases {

	@Override
	public String[] getAliases() {
		return new String[] { "commands", "hilfe" };
	}

	@Override
	public String getName() {
		return "help";
	}

	@Override
	public void onCall(MessageReceivedEvent event) {

		MessageChannel channel = event.getChannel();
		Member member = event.getMember();

		boolean isOwner = false;
		@SuppressWarnings("unused")
		boolean canStartPoll = false;
		for (Role r : member.getRoles()) {
			if (r.getId().equals("394112698511654912")) {
				isOwner = true;
			}
			if (r.getId().equals("542380089124323359") || r.getId().equals("438074536508784640")
					|| r.getId().equals("456916096587530241") || r.getId().equals("514172638717935635")
					|| r.getId().equals("709848394725851211") || r.getId().equals("529727596942983187")) {
				canStartPoll = true;
			}
		}

		final EmbedBuilder helpEmbed = new EmbedBuilder();
		helpEmbed.setColor(Color.RED);
		helpEmbed.setTitle("LandOfRails Help page");
		helpEmbed.setDescription("All commands of the LandOfRails discord bot.");
		helpEmbed.addBlankField(false);
		helpEmbed.addField("General commands:", "", false);
		helpEmbed.addField("!idea [all|tc|znd|ir|rtm] <message>", "Submit an idea for our servers :)", true);
		helpEmbed.addField("!afk", "Work in progress", true);
		helpEmbed.addField("!info", "About the LandOfRails Server (WIP)", true);
		helpEmbed.addField("!help", "This help page :)", true);
		helpEmbed.addField("Fun Commands:", "", false);
		helpEmbed.addField("!fish", "Fish GIF", true);
		helpEmbed.addField("!bee", "Minecraft bee", true);
		helpEmbed.addField("!duck", "Duck GIF", true);
		helpEmbed.addField("!train", "Railroad GIF", true);
		helpEmbed.addField("!tram", "One of 4 Tram GIF's", true);
		helpEmbed.addField("!cat[2]", "Cat GIF", true);
		helpEmbed.addField("!fuck", "Cursed.", true);

		if (isOwner) {
			helpEmbed.addBlankField(false);
			helpEmbed.addField("Owner Commands:", "", false);
			helpEmbed.addField("!remove [anzahl]", "L\u00f6sche [anzahl] Nachrichten", true);
			helpEmbed.addField("!stop", "Stoppe den Bot", true);
		}

		/*
		 * if(canStartPoll) { helpEmbed.addBlankField(false);
		 * helpEmbed.addField("Poll Command(s):", "", false);
		 * helpEmbed.addField("abstimmung", "Keine ahnung wie der krams geht lul",
		 * true); // @MarkenJaden Musst du machen }
		 */

		channel.sendMessage(helpEmbed.build()).queue();

	}

}
