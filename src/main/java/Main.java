import handler.TimerTasks;
import listener.MessageListener;
import listener.ReactionListener;
import listener.ServerListener;
import listener.StartStopListener;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import storage.Container;

import javax.annotation.Nonnull;
import javax.security.auth.login.LoginException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Scanner;
import java.util.logging.Logger;

public class Main implements EventListener {

    private static Logger logger = Logger.getLogger("Main");

    public static void main(String[] args) throws LoginException, GeneralSecurityException, IOException {

        String sensitiveData = "";
        try (Scanner s = new Scanner(Container.SensitiveDataFile);) {
            while (s.hasNext()) {
                sensitiveData = sensitiveData + s.next() + " ";
            }
        } catch (final FileNotFoundException e) {
            e.printStackTrace();
        }
        String[] sensitiveDataSplitted = sensitiveData.split(" ");

        //Google sheets stuff
        //Container.sheetsService = GoogleAuthorizeUtil.getSheetsService();
        //Container.spreadsheetId = sensitiveDataSplitted[2];

        //Init Discord Bot
        String token = sensitiveDataSplitted[0];
        JDABuilder builder = JDABuilder.createDefault(token);
        builder.addEventListeners(new Main());
        builder.addEventListeners(new MessageListener());
        builder.addEventListeners(new ServerListener());
        builder.addEventListeners(new ReactionListener());
        builder.addEventListeners(new StartStopListener());
        builder.setActivity(Activity.watching("Ich bin noch neu :)"));

        // Daten laden
        //LocalSafeHandler.loadData();

        // Start
        builder.build();

        // Flyway (Databases)
        // Flyway flyway = Flyway.configure().dataSource("landofrails.net",
        // "discord-bot", sensitiveDataSplitted[1]).load();
        // flyway.migrate();

        // TimerTasks starten
        TimerTasks tt = new TimerTasks();
        tt.checkActiveVotings();
    }

    @Override
    public void onEvent(@Nonnull GenericEvent event) {
        if (event instanceof Main) {
            logger.info("API is ready!");
        }
    }
}
