package commands.handler;

import commands.interfaces.Command;

import java.util.ArrayList;
import java.util.List;

public class CommandList {

    private List<Command> commands = new ArrayList<>();

    public CommandList() {
//		commands.add(new CommandAbstimmung());
//		commands.add(new CommandAFK());
//		commands.add(new CommandFunCommands());
//		commands.add(new CommandHelp());
//		commands.add(new CommandIdea());
//		commands.add(new CommandInfo());
//		commands.add(new CommandRemove());
//		commands.add(new CommandStop());
//		commands.add(new CommandTest());
    }

    public List<Command> getCommands() {
        return commands;
    }

}
