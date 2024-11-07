package command;

import java.util.ArrayList;
import java.util.Date;

public class TransaktionsManager {
    private static ArrayList<Transaktion> transaktioner = new ArrayList<>();

    public void läggTillTransaktion(String beskrivning, double belopp, Date datum) {
        Transaktion transaktion = new Transaktion(beskrivning, belopp, datum);
        transaktioner.add(transaktion);
        System.out.println("Du är klar med transaktionen.");
    }

    public void visaAllaTransaktioner() {
        if (transaktioner.isEmpty()) {
            System.out.println("Transaktionslistan är tom.");
        } else {
            System.out.println("Alla transaktioner:");
            for (int i = 0; i < transaktioner.size(); i++) {
                System.out.print((i + 1) + ". ");
                transaktioner.get(i).visaTransaktion();
            }
        }
    }

    public double beräknaSaldo() {
        double saldo = 0;
        for (Transaktion transaktion : transaktioner) {
            saldo += transaktion.getBelopp();
        }
        return saldo;
    }

    public void visaSaldo() {
        double saldo = beräknaSaldo();
        System.out.println("Nuvarande saldo på kontot är: " + saldo + " kr");
    }

    public static ArrayList<Transaktion> getTransaktioner() {
        return transaktioner;
    }
}
