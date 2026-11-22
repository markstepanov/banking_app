package org.example.entity;

import java.util.List;
import java.util.ArrayList;
/** Заготовка банковского счёта: номер, валюта и история операций. */
public class Account {

    // Номер — строка: с ним не выполняют арифметику, а ведущие нули могут быть важны.
    private String accountNumber;

    private String currency; // валюта

    // История операций по одному счёту. Пока список не создан и поле равно null.
    private List<Transaction> transaction;

    private long balance;

    public Account(String accountNumber, String currency) {
        this.accountNumber = accountNumber;
        this.currency = currency;
        this.transaction = new ArrayList<>();
    }



    // Связь объектов: пользователь -> его счета -> операции каждого счёта.
    // Создание счетов и работа с историей пока не реализованы.
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getCurrency() {
        return currency;
    }
    public long getBalance() {
        return balance;
    }

    public void deposit(long amount) {
        if (amount <= 0) {
            System.out.println("Сумма пополнения должна быть больше нуля");
            return;
        }

        balance = balance + amount;
        transaction.add(new Transaction(amount, "DEPOSIT", "Пополнение"));
    }
    public void withdraw(long amount, String comment) {

        if (amount <= 0) {
            System.out.println("Сумма снятия должна быть больше нуля");
            return;
        }

        if (amount > balance) {
            System.out.println("Недостаточно денег");
            return;
        }

        if (comment.isBlank()) {
            System.out.println("Укажите комментарий к снятию");
            return;
        }
        balance = balance - amount;
        transaction.add(new Transaction(amount, "WITHDRAWAL", comment));
    }
    public List<Transaction> getTransactions() {
        return transaction;
    }

}
