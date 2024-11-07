package command;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import main.Main;

public class IncomeCommand {
    public Main main;

    public IncomeCommand(Main main) {
        this.main = main;
    }

    public void visaInkomster(ArrayList<Transaktion> transaktioner) {
        double totalInkomster = 0;
        int year = 0;
        int month = 0;
        Calendar idag = Calendar.getInstance();
        Date endDate;
        Date startDate;
        Date dateIdag;
        System.out.println("Välj tidsperiod:");
        System.out.println("1. Årsvis");
        System.out.println("2. Månadsvis");
        System.out.println("3. Veckovis");
        System.out.println("4. Dagvis");
        System.out.print("Ange ditt val: ");
        Scanner scanner = new Scanner(System.in);
        int period = scanner.nextInt();
        switch (period) {
            case 1:
                totalInkomster = 0;
                year = idag.get(Calendar.YEAR);
                idag.set(Calendar.YEAR, year - 1);
                startDate = idag.getTime();
                System.out.println(startDate);
                idag.set(Calendar.YEAR, year);
                endDate = idag.getTime();
                System.out.println(endDate);
                for (Transaktion transaktion : transaktioner) {
                    if (transaktion.belopp > 0 && transaktion.datum.after(startDate)
                            && transaktion.datum.before(endDate)) {
                        System.out.println("Transaktion: " + transaktion.beskrivning + " | Belopp: "
                                + transaktion.belopp + " SEK | Datum: " + transaktion.datum);
                        totalInkomster += transaktion.belopp;
                    }
                }
                break;
            case 2:
                totalInkomster = 0;
                year = idag.get(Calendar.YEAR);
                month = idag.get(Calendar.MONTH);
                idag.set(Calendar.MONTH, month - 1);
                startDate = idag.getTime();
                idag.set(Calendar.MONTH, month);
                endDate = idag.getTime();
                for (Transaktion transaktion : transaktioner) {
                    if (transaktion.belopp > 0 && transaktion.datum.after(startDate)
                            && transaktion.datum.before(endDate)) {
                        totalInkomster += transaktion.belopp;
                    }
                }
                break;
            case 3:
                totalInkomster = 0;
                dateIdag = idag.getTime();
                idag.setTime(dateIdag);
                idag.set(Calendar.DAY_OF_WEEK, idag.getFirstDayOfWeek());
                startDate = idag.getTime();
                idag.add(idag.WEEK_OF_YEAR, 1);
                endDate = idag.getTime();
                for (Transaktion transaktion : transaktioner) {
                    if (transaktion.belopp > 0 && transaktion.datum.after(startDate)
                            && transaktion.datum.before(endDate)) {
                        totalInkomster += transaktion.belopp;
                    }
                }
                break;
            case 4:
                totalInkomster = 0;
                dateIdag = idag.getTime();
                idag.setTime(dateIdag);
                idag.set(Calendar.HOUR_OF_DAY, 0);
                idag.set(Calendar.MINUTE, 0);
                idag.set(Calendar.SECOND, 0);
                startDate = idag.getTime();
                idag.add(Calendar.DAY_OF_YEAR, 1);
                endDate = idag.getTime();
                for (Transaktion transaktion : transaktioner) {
                    if (transaktion.belopp < 0 && transaktion.datum.after(startDate)
                            && transaktion.datum.before(endDate)) {
                        totalInkomster += transaktion.belopp;
                    }
                }
                break;
        }
        System.out.println("Inkomster: " + totalInkomster + " SEK");
    }
}
