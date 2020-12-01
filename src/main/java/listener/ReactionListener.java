package listener;

import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class ReactionListener extends ListenerAdapter {

    @Override
    public void onMessageReactionAdd(@Nonnull MessageReactionAddEvent event) {

//        if (event.getTextChannel().equals(event.getGuild().getTextChannelById("760590649334169657"))) {
//            event.getTextChannel().sendMessage(event.getReaction() + event.getReactionEmote().getName()).queue();
//            event.getTextChannel().addReactionById(event.getMessageId(), event.getReactionEmote().getName()).queue();
//        }

        //Roles Management
        switch (event.getMessageId()) {
            //ALTER
            case "783057633354580019":
                switch (event.getReactionEmote().getAsCodepoints()) {
                    case "U+31U+fe0fU+20e3":
                        event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById(783067796518469632L)).complete();
                        break;
                    case "U+32U+fe0fU+20e3":
                        event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById(783068088969986100L)).complete();
                        break;
                    case "U+33U+fe0fU+20e3":
                        event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById(783068123803680800L)).complete();
                        break;
                    case "U+34U+fe0fU+20e3":
                        event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById(783068168217821225L)).complete();
                        break;
                    case "U+35U+fe0fU+20e3":
                        event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById(783068207874703372L)).complete();
                        break;
                    case "U+36U+fe0fU+20e3":
                        event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById(783068243991855125L)).complete();
                        break;
                }
                break;
            //FABRE
            case "783058774964699197":
                switch (event.getReactionEmote().getAsCodepoints()) {
                    //Rot
                    case "U+2764U+fe0f":
                        event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById(783081149094297620L)).complete();
                        break;
                    //Orange
                    case "U+1f9e1":
                        event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById(783081257570926603L)).complete();
                        break;
                    //Grün
                    case "U+1f49a":
                        event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById(783081307403976754L)).complete();
                        break;
                    //Blau
                    case "U+1f499":
                        event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById(783081341352149012L)).complete();
                        break;
                    //Violet
                    case "U+1f49c":
                        event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById(783081369658982441L)).complete();
                        break;
                    //Schwarz
                    case "U+1f5a4":
                        event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById(783081406589829162L)).complete();
                        break;
                    //Weiß
                    case "U+1f90d":
                        event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById(783081455177826355L)).complete();
                        break;
                }
                break;
            //GENRE
            case "783060401336221739":
                switch (event.getReactionEmote().getAsCodepoints()) {
                    //Action
                    case "U+1f4a5":
                        event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById(783077812848164895L)).complete();
                        break;
                    //Adventure
                    case "U+1f6a3U+200dU+2640U+fe0f":
                        event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById(783077849233489980L)).complete();
                        break;
                    //Comedy
                    case "U+1f606":
                        event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById(783077873850122240L)).complete();
                        break;
                    //Drama
                    case "U+1f630":
                        event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById(783077898068295720L)).complete();
                        break;
                    //Ecchi
                    case "U+1f60f":
                        event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById(783077914559250482L)).complete();
                        break;
                    //Harem
                    case "U+1f46fU+200dU+2640U+fe0f":
                        event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById(783077934935441450L)).complete();
                        break;
                    //Horror
                    case "U+1f52a":
                        event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById(783077952270761985L)).complete();
                        break;
                    //Mystery
                    case "U+1f50d":
                        event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById(783077969723785247L)).complete();
                        break;
                    //Romance
                    case "U+1f495":
                        event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById(783078009472548876L)).complete();
                        break;
                    //Sci-Fi
                    case "U+1f4ab":
                        event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById(783078025376956437L)).complete();
                        break;
                    //Sports
                    case "U+26bd":
                        event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById(783078050685648918L)).complete();
                        break;
                    //Thriller
                    case "U+1f631":
                        event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById(783078066381258813L)).complete();
                        break;
                    //Yaoi
                    case "U+1f46c":
                        event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById(783078085040799775L)).complete();
                        break;
                    //Yuri
                    case "U+1f46d":
                        event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById(783078109128818709L)).complete();
                        break;
                }
                break;
            //GAME
            case "783063194335707146":
                switch (event.getReactionEmote().getName()) {
                    case "m7":
                        event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById(783075981899989022L)).complete();
                        break;
                    case "Among_us_white":
                        event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById(783076036040458301L)).complete();
                        break;
                    case "DiamondSword":
                        event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById(783076065656569868L)).complete();
                        break;
                    case "Valorant":
                        event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById(783076090893041694L)).complete();
                        break;
                    case "overwatch":
                        event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById(783076133444255774L)).complete();
                        break;
                }
                break;
        }
    }

    @Override
    public void onMessageReactionRemove(@Nonnull MessageReactionRemoveEvent event) {
        //Roles Management
        switch (event.getMessageId()) {
            //ALTER
            case "783057633354580019":
                switch (event.getReactionEmote().getAsCodepoints()) {
                    case "U+31U+fe0fU+20e3":
                        event.getGuild().removeRoleFromMember(event.getMember(), event.getGuild().getRoleById(783067796518469632L)).complete();
                        break;
                    case "U+32U+fe0fU+20e3":
                        event.getGuild().removeRoleFromMember(event.getMember(), event.getGuild().getRoleById(783068088969986100L)).complete();
                        break;
                    case "U+33U+fe0fU+20e3":
                        event.getGuild().removeRoleFromMember(event.getMember(), event.getGuild().getRoleById(783068123803680800L)).complete();
                        break;
                    case "U+34U+fe0fU+20e3":
                        event.getGuild().removeRoleFromMember(event.getMember(), event.getGuild().getRoleById(783068168217821225L)).complete();
                        break;
                    case "U+35U+fe0fU+20e3":
                        event.getGuild().removeRoleFromMember(event.getMember(), event.getGuild().getRoleById(783068207874703372L)).complete();
                        break;
                    case "U+36U+fe0fU+20e3":
                        event.getGuild().removeRoleFromMember(event.getMember(), event.getGuild().getRoleById(783068243991855125L)).complete();
                        break;
                }
                break;
            //FABRE
            case "783058774964699197":
                switch (event.getReactionEmote().getAsCodepoints()) {
                    //Rot
                    case "U+2764U+fe0f":
                        event.getGuild().removeRoleFromMember(event.getMember(), event.getGuild().getRoleById(783081149094297620L)).complete();
                        break;
                    //Orange
                    case "U+1f9e1":
                        event.getGuild().removeRoleFromMember(event.getMember(), event.getGuild().getRoleById(783081257570926603L)).complete();
                        break;
                    //Grün
                    case "U+1f49a":
                        event.getGuild().removeRoleFromMember(event.getMember(), event.getGuild().getRoleById(783081307403976754L)).complete();
                        break;
                    //Blau
                    case "U+1f499":
                        event.getGuild().removeRoleFromMember(event.getMember(), event.getGuild().getRoleById(783081341352149012L)).complete();
                        break;
                    //Violet
                    case "U+1f49c":
                        event.getGuild().removeRoleFromMember(event.getMember(), event.getGuild().getRoleById(783081369658982441L)).complete();
                        break;
                    //Schwarz
                    case "U+1f5a4":
                        event.getGuild().removeRoleFromMember(event.getMember(), event.getGuild().getRoleById(783081406589829162L)).complete();
                        break;
                    //Weiß
                    case "U+1f90d":
                        event.getGuild().removeRoleFromMember(event.getMember(), event.getGuild().getRoleById(783081455177826355L)).complete();
                        break;
                }
                break;
            //GENRE
            case "783060401336221739":
                switch (event.getReactionEmote().getAsCodepoints()) {
                    //Action
                    case "U+1f4a5":
                        event.getGuild().removeRoleFromMember(event.getMember(), event.getGuild().getRoleById(783077812848164895L)).complete();
                        break;
                    //Adventure
                    case "U+1f6a3U+200dU+2640U+fe0f":
                        event.getGuild().removeRoleFromMember(event.getMember(), event.getGuild().getRoleById(783077849233489980L)).complete();
                        break;
                    //Comedy
                    case "U+1f606":
                        event.getGuild().removeRoleFromMember(event.getMember(), event.getGuild().getRoleById(783077873850122240L)).complete();
                        break;
                    //Drama
                    case "U+1f630":
                        event.getGuild().removeRoleFromMember(event.getMember(), event.getGuild().getRoleById(783077898068295720L)).complete();
                        break;
                    //Ecchi
                    case "U+1f60f":
                        event.getGuild().removeRoleFromMember(event.getMember(), event.getGuild().getRoleById(783077914559250482L)).complete();
                        break;
                    //Harem
                    case "U+1f46fU+200dU+2640U+fe0f":
                        event.getGuild().removeRoleFromMember(event.getMember(), event.getGuild().getRoleById(783077934935441450L)).complete();
                        break;
                    //Horror
                    case "U+1f52a":
                        event.getGuild().removeRoleFromMember(event.getMember(), event.getGuild().getRoleById(783077952270761985L)).complete();
                        break;
                    //Mystery
                    case "U+1f50d":
                        event.getGuild().removeRoleFromMember(event.getMember(), event.getGuild().getRoleById(783077969723785247L)).complete();
                        break;
                    //Romance
                    case "U+1f495":
                        event.getGuild().removeRoleFromMember(event.getMember(), event.getGuild().getRoleById(783078009472548876L)).complete();
                        break;
                    //Sci-Fi
                    case "U+1f4ab":
                        event.getGuild().removeRoleFromMember(event.getMember(), event.getGuild().getRoleById(783078025376956437L)).complete();
                        break;
                    //Sports
                    case "U+26bd":
                        event.getGuild().removeRoleFromMember(event.getMember(), event.getGuild().getRoleById(783078050685648918L)).complete();
                        break;
                    //Thriller
                    case "U+1f631":
                        event.getGuild().removeRoleFromMember(event.getMember(), event.getGuild().getRoleById(783078066381258813L)).complete();
                        break;
                    //Yaoi
                    case "U+1f46c":
                        event.getGuild().removeRoleFromMember(event.getMember(), event.getGuild().getRoleById(783078085040799775L)).complete();
                        break;
                    //Yuri
                    case "U+1f46d":
                        event.getGuild().removeRoleFromMember(event.getMember(), event.getGuild().getRoleById(783078109128818709L)).complete();
                        break;
                }
                break;
            //GAME
            case "783063194335707146":
                switch (event.getReactionEmote().getName()) {
                    case "m7":
                        event.getGuild().removeRoleFromMember(event.getMember(), event.getGuild().getRoleById(783075981899989022L)).complete();
                        break;
                    case "Among_us_white":
                        event.getGuild().removeRoleFromMember(event.getMember(), event.getGuild().getRoleById(783076036040458301L)).complete();
                        break;
                    case "DiamondSword":
                        event.getGuild().removeRoleFromMember(event.getMember(), event.getGuild().getRoleById(783076065656569868L)).complete();
                        break;
                    case "Valorant":
                        event.getGuild().removeRoleFromMember(event.getMember(), event.getGuild().getRoleById(783076090893041694L)).complete();
                        break;
                    case "overwatch":
                        event.getGuild().removeRoleFromMember(event.getMember(), event.getGuild().getRoleById(783076133444255774L)).complete();
                        break;
                }
                break;
        }
    }
}
