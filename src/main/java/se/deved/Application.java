package se.deved;

/*

<-----> En personal-finance applikation <----->

Funktionalitet:

I applikationen kan man göra följande:

- Lägga in transaktioner (manuellt; när du exempelvis har köpt något eller fått lön)

- Se alla transaktioner

- Radera transaktioner (manuellt)

- Se nuvarande kontobalans

- Se inkomster och utgifter årsvis, månadsvis, veckovis och dagvis
 */

import java.util.Scanner;


public class Application {

    private MenuManager menuManager;
    private SaveManager saveManager;
    private boolean running;

    public Application() {
        this.menuManager = new SimpleMenuManager(this);
        this.running = true; 
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vill du använda 'list' eller 'file'?");
        if (scanner.nextLine().equalsIgnoreCase("list")) {
            this.saveManager = new ListManager();
        } else {
            this.saveManager = new FileManager();
        }
    }

    public static void main(String[] args) {
        Application application = new Application();

        Scanner scanner = new Scanner(System.in);
        while (application.isRunning()) {
            application.getMenuManager().getCurrentMenu().tryExecuteCommand(scanner.nextLine());
        }
    }

    public MenuManager getMenuManager() {
        return menuManager;
    }

    public boolean isRunning() {
        return running;
    }

    public void stop() {
        this.running = false;
    }

    public SaveManager getTransactionManager() {
        return saveManager;
    }
}