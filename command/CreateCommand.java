package command;

public class CreateCommand extends Command {

    public CreateCommand() {
        super("create", "create transaction");
    }

    @Override
    public void execute(String[] commandArgs) {
        System.out.println("Create transaction");
    }
}
