package listener;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import storage.Container;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Set;

public class ReactionListener extends ListenerAdapter {

    /**
     * <MessageID, HashMap<EmojiCodepoints, RoleID>>
     */
    private static final HashMap<Long, HashMap<String, Long>> rolesList = new HashMap<Long, HashMap<String, Long>>() {{
        //A L T E R
        put(783057633354580019L, new HashMap<String, Long>() {{
            put("U+31U+fe0fU+20e3", 783067796518469632L);
            put("U+32U+fe0fU+20e3", 783068088969986100L);
            put("U+33U+fe0fU+20e3", 783068123803680800L);
            put("U+34U+fe0fU+20e3", 783068168217821225L);
            put("U+35U+fe0fU+20e3", 783068207874703372L);
            put("U+36U+fe0fU+20e3", 783068243991855125L);
        }});

        //C O L O R
        put(783058774964699197L, new HashMap<String, Long>() {{
            //Rot
            put("U+2764U+fe0f", 783081149094297620L);
            //Orange
            put("U+1f9e1", 783081257570926603L);
            //Grün
            put("U+1f49a", 783081307403976754L);
            //Blau
            put("U+1f499", 783081341352149012L);
            //Violet
            put("U+1f49c", 783081369658982441L);
            //Schwarz
            put("U+1f5a4", 783081406589829162L);
            //Weiß
            put("U+1f90d", 783081455177826355L);
        }});

        //G E N R E
        put(783060401336221739L, new HashMap<String, Long>() {{
            //Action
            put("U+1f4a5", 783077812848164895L);
            //Adventure
            put("U+1f6a3U+200dU+2640U+fe0f", 783077849233489980L);
            //Comedy
            put("U+1f606", 783077873850122240L);
            //Drama
            put("U+1f630", 783077898068295720L);
            //Ecchi
            put("U+1f60f", 783077914559250482L);
            //Harem
            put("U+1f46fU+200dU+2640U+fe0f", 783077934935441450L);
            //Horror
            put("U+1f52a", 783077952270761985L);
            //Mystery
            put("U+1f50d", 783077969723785247L);
            //Romance
            put("U+1f495", 783078009472548876L);
            //Sci-Fi
            put("U+1f4ab", 783078025376956437L);
            //Sports
            put("U+26bd", 783078050685648918L);
            //Thriller
            put("U+1f631", 783078066381258813L);
            //Yaoi
            put("U+1f46c", 783078085040799775L);
            //Yuri
            put("U+1f46d", 783078109128818709L);
        }});

        //G A M E
        put(783063194335707146L, new HashMap<String, Long>() {{
            put("m7", 783075981899989022L);
            put("Among_us_white", 783076036040458301L);
            put("DiamondSword", 783076065656569868L);
            put("Valorant", 783076090893041694L);
            put("overwatch", 783076133444255774L);
        }});
    }};

    /**
     * Static channelID as there is only one channel for rules
     */
    private static final long channelID = 760590649334169657L;

    @Override
    public void onMessageReactionAdd(@Nonnull MessageReactionAddEvent event) {

//        if (event.getTextChannel().equals(event.getGuild().getTextChannelById("760590649334169657"))) {
//            event.getTextChannel().sendMessage(event.getReaction() + event.getReactionEmote().getName()).queue();
//            event.getTextChannel().addReactionById(event.getMessageId(), event.getReactionEmote().getName()).queue();
//        }

        //Roles Management
        Member member = event.getMember();
        Long messageID = event.getMessageIdLong();
        if (member != null && rolesList.containsKey(messageID) && !event.getUser().isBot()) {
            HashMap<String, Long> roles = rolesList.get(messageID);
            try {
                String codepoints = event.getReactionEmote().getAsCodepoints();
                if (roles.containsKey(codepoints)) {
                    event.getGuild().addRoleToMember(member, event.getGuild().getRoleById(roles.get(codepoints))).complete();
                }
            } catch (Exception e) {
                String name = event.getReactionEmote().getName();
                if (roles.containsKey(name)) {
                    event.getGuild().addRoleToMember(member, event.getGuild().getRoleById(roles.get(name))).complete();
                }
            }
        }
    }

    @Override
    public void onMessageReactionRemove(@Nonnull MessageReactionRemoveEvent event) {
        //Roles Management
        Member member = event.getMember();
        Long messageID = event.getMessageIdLong();
        if (member != null && rolesList.containsKey(messageID) && !event.getUser().isBot()) {
            HashMap<String, Long> roles = rolesList.get(messageID);
            try {
                String codepoints = event.getReactionEmote().getAsCodepoints();
                if (roles.containsKey(codepoints)) {
                    event.getGuild().removeRoleFromMember(member, event.getGuild().getRoleById(roles.get(codepoints))).complete();
                }
            } catch (Exception e) {
                String name = event.getReactionEmote().getName();
                if (roles.containsKey(name)) {
                    event.getGuild().removeRoleFromMember(member, event.getGuild().getRoleById(roles.get(name))).complete();
                }
            }
        }
    }

    public static void checkIfReacted() {
        for (Long l : rolesList.keySet()) {
            Message m = Container.getGuild().getTextChannelById(channelID).retrieveMessageById(l).complete();
            Set<String> roles = rolesList.get(l).keySet();
            for (String s : roles) {
                try {
                    m.addReaction(s).complete();
                } catch (Exception e) {
                    m.addReaction(Container.getGuild().getEmotesByName(s, false).get(0)).complete();
                }
            }
        }
    }
}
