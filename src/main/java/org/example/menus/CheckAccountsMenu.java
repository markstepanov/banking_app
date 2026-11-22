package org.example.menus;

import org.example.entity.Account;
import org.example.entity.User;

public class CheckAccountsMenu {

    private User user;

    public CheckAccountsMenu(User user){
        this.user = user;
    }



    public void launch(){
        // Здесь ещё предстоит реализовать просмотр счетов.
        for (Account currentAccount : user.getAccounts()) {
            System.out.println(
                    currentAccount.getAccountNumber() + " " +
                            currentAccount.getCurrency() + " " +
                            currentAccount.getBalance()
            );
        }

    }
}
