package storage;

import net.dv8tion.jda.api.entities.Guild;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Container {

    private Container() {

    }

    //Bot Command indicator
    public static String indicator = "!";

    // Dateien
    public static final File VotingFile = new File("./VotingList.txt");
    public static final File SensitiveDataFile = new File("./Sensitive-data");
    public static final File CommandIdeas = new File("./CommandIdeas.txt");

    // Abstimmungen
    public static final List<Long> ActiveVotings = new ArrayList<>();

    // Guild
    private static Guild guild;

    public static Guild getGuild() {
        return guild;
    }

    public static void setGuild(Guild g) {
        guild = g;
    }

    //Spreadsheet ID
//    public static String spreadsheetId;
//    public static Sheets sheetsService;
}
