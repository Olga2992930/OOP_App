package command;

public abstract class Command {
    private String name;
    private String description;

    public Command(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public abstract void execute(String[] commandArgs);

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
