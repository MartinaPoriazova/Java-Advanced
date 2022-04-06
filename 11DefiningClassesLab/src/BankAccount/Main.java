package BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        Map<Integer, BankAccount> bankAccounts = new HashMap<>();

        while (!command.equals("End")) {
            String[] tokens = command.split("\\s+");
            String commandName = tokens[0];
            String output = null;

            if ("Create".equals(commandName)) {
                BankAccount account = new BankAccount();
                bankAccounts.put(account.getId(), account);
                output = "Account ID" + account.getId() + " created";
            } else if ("Deposit".equals(commandName)) {
                int id = Integer.parseInt(tokens[1]);
                int amount = Integer.parseInt(tokens[2]);

                if (!bankAccounts.containsKey(id)) {
                    output = "Account does not exist";
                } else {
                    bankAccounts.get(id).deposit(amount);
                    output = "Deposited " + amount + " to ID" + id;
                }

            } else if ("SetInterest".equals(commandName)) {
                BankAccount.setInterestRate(Double.parseDouble(tokens[1]));
            } else {
                int id = Integer.parseInt(tokens[1]);
                int years = Integer.parseInt(tokens[2]);

                if (!bankAccounts.containsKey(id)) {
                    output = "Account does not exist";
                } else {
                    double interest = bankAccounts.get(id).getInterest(years);
                    output = String.format("%.2f", interest);
                }
            }

            if (output != null) {
                System.out.println(output);
            }

            command = scanner.nextLine();
        }


    }

}
