package org.example.menus;

import org.example.Globals;
import org.example.entity.Account;
import org.example.entity.User;
import org.example.entity.Transaction;

/** Показывает действия, доступные обычному пользователю после входа. */
public class UserMenu {
    private User user;

    // Сохраняем ссылку на вошедшего пользователя для последующих действий меню.
    public UserMenu(User user){
        this.user =user;
    }

    public void launch(){
        // После каждого действия меню показывается снова, пока не выполнится return.
        while (true) {
             System.out.println("Привет "+ user.getUsername());
             System.out.println("Выберите действие");
             System.out.println("1. Создать счет");
             System.out.println("2. Посмотреть счета");
             System.out.println("3. Выйти");
             System.out.println("4. Пополнить счёт");
             System.out.println("5. Снять деньги");
             System.out.println("6. История операций");
              String input = Globals.scanner.nextLine();
              // Ввод читается как строка, поэтому сравниваем с "1", а не с числом 1.
              if (input.equals("1")){
                // Здесь ещё предстоит реализовать создание счёта.
                  System.out.println("Введите валюту: UZS, USD или EUR");
                  String currencyInput = Globals.scanner.nextLine();
                  if (currencyInput.equals("UZS") || currencyInput.equals("USD") || currencyInput.equals("EUR")) {
                      String accountNumber = "№" + Globals.nextAccountNumber;
                      user.getAccounts().add(new Account(accountNumber, currencyInput));
                      System.out.println("Счёт создан");
                      Globals.nextAccountNumber++;
                  } else {
                      System.out.println("Такая валюта не поддерживается");
                  }

              }
              if (input.equals("2")){
                // Здесь ещё предстоит реализовать просмотр счетов.
                  for (Account currentAccount : user.getAccounts()) {
                      System.out.println(
                              currentAccount.getAccountNumber()  + " " +
                              currentAccount.getCurrency() + " " +
                              currentAccount.getBalance()
                      );
                  }

              }
              if (input.equals("3")){
                // Выходим только из этого метода: Main снова покажет меню входа.
                return;
              }
            if (input.equals("4")) {
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
                if (input.equals("5")) {
                System.out.println("Введите номер счёта для снятия:");
                String accountNumberInput = Globals.scanner.nextLine();

                    boolean accountFound = false;
                    for (Account currentAccount : user.getAccounts()) {
                        if (currentAccount.getAccountNumber().equals(accountNumberInput)) {
                            accountFound = true;
                            System.out.println("Счёт найден");
                            System.out.println("Введите сумму:");
                            String amountInput = Globals.scanner.nextLine();

                            System.out.println("Введите комментарий к снятию:");
                            String commentInput = Globals.scanner.nextLine();
                            try {
                                long amount = Long.parseLong(amountInput);
                                currentAccount.withdraw(amount, commentInput);
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
                if (input.equals("6")) {
                System.out.println("Введите номер счёта:");
                String accountNumberInput = Globals.scanner.nextLine();

                boolean accountFound = false;

                for (Account currentAccount : user.getAccounts()) {
                    if (currentAccount.getAccountNumber().equals(accountNumberInput)) {
                        accountFound = true;

                        for (Transaction currentTransaction : currentAccount.getTransactions()) {
                            System.out.println(currentTransaction.getType() + " "
                                    + currentTransaction.getAmount() + " "
                                    +currentTransaction.getComment());
                        }
                    }
                }

                if (!accountFound) {
                    System.out.println("Счёт не найден");
                }
            }

    }
}

}