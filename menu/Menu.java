package menu;

import java.util.ArrayList;
import java.util.List;

import command.Command;
import command.CommandManager;

public abstract class Menu implements CommandManager {
    
    private List<Command> commands = new ArrayList<>();

    @Override
    public void registerCommand(Command command) {
        this.commands.add(command);
    }

    @Override
    public void tryExecuteCommand(String input) {
        if (input.isBlank())
        throw new IllegalArgumentException("Input must not be empty.");

        String[] commandArgs = input.split(" ");
        String commandName = commandArgs[0];

        for (Command command : commands) {
            if (command.getName().equalsIgnoreCase(commandName)) {
                command.execute(commandArgs);
                return;
            }
        }
    }

    
}
