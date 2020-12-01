package handler;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.MessageReaction;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.exceptions.ErrorResponseException;
import storage.Container;

import java.awt.*;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;

public class TimerTasks {

    private static final Logger logger = Logger.getLogger("TimerTask");

    public void checkActiveVotings() {
        TimerTask repeatedTask = new TimerTask() {
            @Override
            public void run() {
                TextChannel textChannel = Container.getGuild().getTextChannelById(485879824540499969L);
                for (int i = 0; i < Container.ActiveVotings.size(); i++) {
                    Long id = Container.ActiveVotings.get(i);
                    logger.info("Nachricht (" + id + ") wird ¸berpr¸ft...");
                    try {
                        Message m = textChannel.retrieveMessageById(id).complete();
                        OffsetDateTime odt = null;
                        for (MessageEmbed me : m.getEmbeds()) {
                            odt = me.getTimestamp();
                        }
                        if (ChronoUnit.SECONDS.between(odt.toInstant(), Instant.now()) > 1) {
                            // Abstimmung schlie√üen
                            for (MessageEmbed me : m.getEmbeds()) {
                                EmbedBuilder embedBuilder = new EmbedBuilder();
                                embedBuilder.setFooter("Abstimmung beendet.");
                                embedBuilder.setTitle(me.getTitle());
                                embedBuilder.setAuthor(me.getAuthor().getName());

                                // Count reactions
                                int pos = 0;
                                int neg = 0;
                                int idk = 0;
                                for (MessageReaction mr : m.getReactions()) {
                                    if (mr.getReactionEmote().getAsCodepoints().equalsIgnoreCase("U+1F44D")) {
                                        pos = mr.getCount() - 1;
                                    } else if (mr.getReactionEmote().getAsCodepoints().equalsIgnoreCase("U+1F44E")) {
                                        neg = mr.getCount() - 1;
                                    } else if (mr.getReactionEmote().getAsCodepoints().equalsIgnoreCase("U+270A")) {
                                        idk = mr.getCount() - 1;
                                    }
                                }
                                if ((pos + neg + idk) >= 15) {
                                    // Check which color
                                    if (pos > neg) {
                                        embedBuilder.setColor(Color.GREEN);
                                    } else {
                                        embedBuilder.setColor(Color.RED);
                                    }

                                    embedBuilder.setDescription("\uD83D\uDC4D Ja! = **" + (pos)
                                            + "** \n \n \uD83D\uDC4E Nein! = **" + (neg)
                                            + "** \n \n :fist: Mir egal... = **" + (idk) + "**");
                                    m.editMessage(embedBuilder.build()).queue();
                                    m.clearReactions().complete();

                                    // Nachricht aus Liste entfernen
                                    logger.info("Abstimmung (" + id + ") beendet.");
                                    Container.ActiveVotings.remove(i);
                                    i--;
                                }
                            }
                        }
                    } catch (ErrorResponseException e) {
                        logger.severe("Nachricht nicht mehr gefunden. \n " + id + " wird aus der Liste gel√∂scht...");
                        Container.ActiveVotings.remove(i);
                        i--;
                    }
                }
            }
        };
        Timer timer = new Timer("Timer");

        long delay = 1000L;
        long period = 1000L * 60L * 10L;
        timer.scheduleAtFixedRate(repeatedTask, delay, period);
    }

}
