/*
 * Module 4 Assignment - Generics & Collection Framework
 * Name    : Ansh Tiwari
 * Roll No : 36
 * Q       : Advanced Q2 - Simple banking system using Map<customerId, balance>
 */
package advanced;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q02_BankingSystem {

    private final Map<String, Double> accounts = new HashMap<>();

    void openAccount(String id, double initial) {
        if (accounts.containsKey(id)) { System.out.println("Account " + id + " already exists."); return; }
        accounts.put(id, initial);
        System.out.printf("Account %s opened with balance Rs %.2f%n", id, initial);
    }

    void deposit(String id, double amount) {
        if (!exists(id) || !positive(amount)) return;
        accounts.merge(id, amount, Double::sum);
        System.out.printf("Deposited Rs %.2f. New balance of %s: Rs %.2f%n", amount, id, accounts.get(id));
    }

    void withdraw(String id, double amount) {
        if (!exists(id) || !positive(amount)) return;
        double bal = accounts.get(id);
        if (amount > bal) { System.out.printf("Insufficient balance (Rs %.2f).%n", bal); return; }
        accounts.put(id, bal - amount);
        System.out.printf("Withdrew Rs %.2f. New balance of %s: Rs %.2f%n", amount, id, accounts.get(id));
    }

    void transfer(String from, String to, double amount) {
        if (!exists(from) || !exists(to) || !positive(amount)) return;
        if (accounts.get(from) < amount) { System.out.println("Transfer failed: insufficient balance."); return; }
        accounts.put(from, accounts.get(from) - amount);
        accounts.put(to, accounts.get(to) + amount);
        System.out.printf("Transferred Rs %.2f from %s to %s.%n", amount, from, to);
    }

    void balance(String id) {
        if (exists(id)) System.out.printf("Balance of %s: Rs %.2f%n", id, accounts.get(id));
    }

    void showAll() {
        System.out.println("All accounts:");
        accounts.forEach((id, bal) -> System.out.printf("  %s -> Rs %.2f%n", id, bal));
    }

    private boolean exists(String id) {
        if (!accounts.containsKey(id)) { System.out.println("No account with ID " + id); return false; }
        return true;
    }

    private boolean positive(double amt) {
        if (amt <= 0) { System.out.println("Amount must be positive."); return false; }
        return true;
    }

    public static void main(String[] args) {
        Q02_BankingSystem bank = new Q02_BankingSystem();
        Scanner sc = new Scanner(System.in);
        System.out.println("===== SIMPLE BANK =====");
        while (true) {
            System.out.println("\n1.Open 2.Deposit 3.Withdraw 4.Transfer 5.Balance 6.Show all 7.Exit");
            System.out.print("Enter choice: ");
            if (!sc.hasNextLine()) break;
            try {
                switch (sc.nextLine().trim()) {
                    case "1": bank.openAccount(ask(sc, "Customer ID: "), Double.parseDouble(ask(sc, "Initial deposit: "))); break;
                    case "2": bank.deposit(ask(sc, "Customer ID: "), Double.parseDouble(ask(sc, "Amount: "))); break;
                    case "3": bank.withdraw(ask(sc, "Customer ID: "), Double.parseDouble(ask(sc, "Amount: "))); break;
                    case "4": bank.transfer(ask(sc, "From ID: "), ask(sc, "To ID: "), Double.parseDouble(ask(sc, "Amount: "))); break;
                    case "5": bank.balance(ask(sc, "Customer ID: ")); break;
                    case "6": bank.showAll(); break;
                    case "7": System.out.println("Thank you for banking with us!"); sc.close(); return;
                    default: System.out.println("Invalid choice.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid amount.");
            }
        }
    }

    private static String ask(Scanner sc, String prompt) {
        System.out.print(prompt);
        return sc.nextLine().trim();
    }
}
