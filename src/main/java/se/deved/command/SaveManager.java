package se.deved.command;

import se.deved.Transaction;

public interface SaveManager {
    void save(Transaction transaction);
    void remove(Transaction transaction);
    Transaction getByTitle(String beskrivning);
}
