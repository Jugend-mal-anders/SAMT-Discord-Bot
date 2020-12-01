package commands;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ThreadLocalRandom;

import commands.interfaces.Aliases;
import commands.interfaces.Command;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class CommandFunCommands implements Command, Aliases {

	private Map<String, String> map = new HashMap<>();

	private void refreshMap() {
		map.clear();
		// @formatter:off
		map.put("fish", "https://media.discordapp.net/attachments/625373674286874665/628653269790490665/618747043854155776.gif");
		map.put("bee", "https://media.discordapp.net/attachments/494702234744127498/634442208291979285/aaaaaaaaaaa.gif");
		map.put("duck", "https://i.gifer.com/XOsX.gif");
		map.put("train", "https://cdn.discordapp.com/attachments/314814038662053888/712807142931038239/ezgif.com-video-to-gif_1.gif");
		map.put("tram", this.getTram());
		map.put("cat", "https://media.discordapp.net/attachments/669158942139613186/740009211391377432/45452.gif");
		map.put("cat2", "https://media.discordapp.net/attachments/730561686590717964/740596417390706788/5f2ac03410bd0496934562.gif");
		map.put("fuck", "https://tenor.com/view/wtf-haha-flirty-fuck-smile-gif-15931510");
		// @formatter:on
	}

	@Override
	public String[] getAliases() {
		return new String[] { "fish", "bee", "duck", "train", "tram", "cat", "cat2", "fuck" };
	}

	@Override
	public String getName() {
		return "fish";
	}

	@Override
	public void onCall(MessageReceivedEvent event) {

		// Eventuell bessere Methode aussuchen? :/
		refreshMap();

		String messageTextRaw = event.getMessage().getContentRaw();
		String cmd = messageTextRaw.substring(1);

		for (Entry<String, String> entry : map.entrySet()) {
			if (cmd.matches("^" + entry.getKey() + "(\\s.*|$)"))
				event.getGuild().getTextChannelById(532648338391040031L).sendMessage(entry.getValue()).queue();
		}

	}

	private String getTram() {
		// @formatter:off
		switch (ThreadLocalRandom.current().nextInt(1, 4 + 1)) {
			case 1:
				return "https://media1.tenor.com/images/6ae61031c768f8e2980908bd1a67b850/tenor.gif?itemid=14228705";
			case 2:
				return "https://media.giphy.com/media/Tl2u4yXA90vQs/giphy.gif";
			case 3:
				return "https://media.giphy.com/media/80QxoQtZb4Gli/giphy.gif";
			case 4:
				return "https://iruntheinternet.com/lulzdump/images/gifs/gandalf-stopping-tram-train-shall-not-pass-1387281258e.gif";
			default:
				return "Error Random Tram";
		}
		// @formatter:on
	}
}
