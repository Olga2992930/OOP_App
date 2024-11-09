package se.deved.command;

import se.deved.Application;

public class IncomeCommand extends Command {
    public IncomeCommand(Application application) {
        super("income", "visa inkomster", application);
    }

    @Override
    public void execute(String[] commandArgs) {
     
    }
}
