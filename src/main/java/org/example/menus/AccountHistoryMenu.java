package org.example.menus;

import org.example.Globals;
import org.example.entity.Account;
import org.example.entity.Transaction;
import org.example.entity.User;

public class AccountHistoryMenu {

    private User user;

    public AccountHistoryMenu(User user){
        this.user = user;
    }


    public void launch(){
        System.out.println("Введите номер счёта:");
        String accountNumberInput = Globals.scanner.nextLine();

        boolean accountFound = false;

        for (Account currentAccount : user.getAccounts()) {
            if (currentAccount.getAccountNumber().equals(accountNumberInput)) {
                accountFound = true;

                for (Transaction currentTransaction : currentAccount.getTransactions()) {
                    System.out.println(currentTransaction.getType() + " "
                            + currentTransaction.getAmount() + " "
                            + currentTransaction.getComment());
                }
            }
        }

        if (!accountFound) {
            System.out.println("Счёт не найден");
        }

    }

}
