package se.deved.command;

import se.deved.Application;

public class CreateCommand extends Command {

    public CreateCommand(Application application) {
        super("create", "skapa en ny transaktion", application);
    }

    @Override
    public void execute(String[] commandArgs) {
        System.out.println("TODO: Create task");
    }
}
