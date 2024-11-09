package se.deved.command;

import se.deved.Application;

public class DeleteCommand extends Command{

    public DeleteCommand(Application application) {
        super("delete", "radera en transaktion", application);
    }

    @Override
    public void execute(String[] commandArgs) {
        System.out.println("TODO: delete task");
    }
}
