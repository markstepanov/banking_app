package org.example.menus;

import org.example.Globals;
import org.example.entity.Account;
import org.example.entity.User;

public class AccountCreationMenu {


    private User user;


    public AccountCreationMenu(User user){
        this.user = user;
    }


    public void launch(){
        System.out.println("Введите валюту: UZS, USD или EUR");
        String currencyInput = Globals.scanner.nextLine();
        if (currencyInput.equals("UZS") || currencyInput.equals("USD") || currencyInput.equals("EUR")) {
            String accountNumber = String.valueOf(Globals.nextAccountNumber);
            user.getAccounts().add(new Account(accountNumber, currencyInput));
            System.out.println("Счёт создан");
            Globals.nextAccountNumber++;
        } else {
            System.out.println("Такая валюта не поддерживается");
        }
    }
}
