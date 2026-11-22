package org.example.menus;

import org.example.Globals;
import org.example.entity.Account;
import org.example.entity.User;
import org.example.entity.Transaction;

/**
 * Показывает действия, доступные обычному пользователю после входа.
 */
public class UserMenu {


    private static final String ACCOUNT_CREATION = "1";
    private static final String CHECK_ACCOUNTS = "2";
    private static final String DEPOSIT_ACCOUNT = "3";
    private static final String WITHDRAWAL_ACCOUNT = "4";
    private static final String ACCOUNT_HISTORY = "5";
    private static final String EXIT = "6";

    private User user;

    public UserMenu(User user) {
        this.user = user;
    }

    public void launch() {
        // После каждого действия меню показывается снова, пока не выполнится return.
        while (true) {
            System.out.println("Привет " + user.getUsername());
            System.out.println("Выберите действие");
            System.out.println(ACCOUNT_CREATION +". Создать счет");
            System.out.println(CHECK_ACCOUNTS + ". Посмотреть счета");
            System.out.println(DEPOSIT_ACCOUNT + ". Пополнить счёт");
            System.out.println(WITHDRAWAL_ACCOUNT + ". Снять деньги");
            System.out.println(ACCOUNT_HISTORY + ". История операций");
            System.out.println(EXIT + ". Выйти");
            String input = Globals.scanner.nextLine();


            // Ввод читается как строка, поэтому сравниваем с "1", а не с числом 1.
            if (input.equals(ACCOUNT_CREATION)) {
                AccountCreationMenu accountCreationMenu = new AccountCreationMenu(user);
                accountCreationMenu.launch();
            } else if (input.equals(CHECK_ACCOUNTS)) {
                CheckAccountsMenu checkAccountsMenu = new CheckAccountsMenu(user);
                checkAccountsMenu.launch();
            } else if (input.equals(DEPOSIT_ACCOUNT)) {
                DepositAccountMenu depositAccountMenu = new DepositAccountMenu(user);
                depositAccountMenu.lauch();
            } else if (input.equals(WITHDRAWAL_ACCOUNT)) {
                WithdrawalAccountMenu withdrawalAccountMenu = new WithdrawalAccountMenu(user);
                withdrawalAccountMenu.launch();
            } else if (input.equals(ACCOUNT_HISTORY)) {
                AccountHistoryMenu accountHistoryMenu = new AccountHistoryMenu(user);
                accountHistoryMenu.launch();
            } else if (input.equals(EXIT)) {
                // Выходим только из этого метода: Main снова покажет меню входа.
                return;
            }

        }
    }

}