package se.deved.command;

import se.deved.Application;

public class ExpensesCommand extends Command {
    public ExpensesCommand(Application application) {
        super("expenses", "visa utgifter", application);
    }

    @Override
    public void execute(String[] commandArgs) {
     
    }
}
