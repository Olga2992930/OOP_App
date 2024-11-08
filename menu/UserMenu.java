package menu;

import command.CreateCommand;
import command.DeleteCommand;

public class UserMenu extends Menu {
    public UserMenu() {
    registerCommand(new CreateCommand());
    registerCommand(new DeleteCommand());
    }
}