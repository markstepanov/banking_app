package org.example.menus;

import org.example.Globals;
import org.example.entity.Account;
import org.example.entity.User;
public class DepositAccountMenu {


    private User user;

    public  DepositAccountMenu(User user){
        this.user = user;
    }


    public void lauch(){
        System.out.println("Введите номер счёта для пополнения:");
        String accountNumberInput = Globals.scanner.nextLine();

        boolean accountFound = false;

        for (Account currentAccount : user.getAccounts()) {
            if (currentAccount.getAccountNumber().equals(accountNumberInput)) {
                accountFound = true;
                System.out.println("Счёт найден");

                System.out.println("Введите сумму:");
                String amountInput = Globals.scanner.nextLine();
                try {
                    long amount = Long.parseLong(amountInput);
                    currentAccount.deposit(amount);
                    System.out.println("Текущий баланс: " + currentAccount.getBalance());
                } catch (NumberFormatException e) {
                    System.out.println("Введите целое число, например 500");
                }
            }
        }

        if (!accountFound) {
            System.out.println("Счёт не найден");
        }

    }


}
