package org.example.entity;

/** Одна операция по счёту: пополнение (DEPOSIT) или снятие (WITHDRAWAL). */
public class Transaction {


    private String type; // DEPOSIT, WITHDRAWAL
    
    // Целое число для суммы. Единицу измерения (например, копейки) ещё нужно определить.
    private long amount;

    private String comment;


    // Перед сохранением данных конструктор проверяет, допустима ли операция.
    public Transaction(long amount, String type,String comment){
        // throw прерывает создание объекта и сообщает об ошибке вызывающему коду.
        if (amount <= 0) {
            throw new RuntimeException("кол-во всегда должно быть положительным");
        }

        // ВНИМАНИЕ: в текущем условии ошибка. || означает «или», ! означает «не».
        // Любая ненулевая строка отличается хотя бы от одного из двух типов, поэтому
        // исключение будет выброшено даже для DEPOSIT и WITHDRAWAL. Здесь нужен &&.
        // При type == null вызов type.equals(...) также завершится исключением.
        if (!type.equals("DEPOSIT") && !type.equals("WITHDRAWAL")) {
            throw new RuntimeException("тип транзакции не поддерживается");
        }

        this.type = type;
        this.amount = amount;
        this.comment = comment;
    }
    public String getType() {
        return type;
    }

    public long getAmount() {
        return amount;
    }

    public String getComment() {
        return comment;
    }
}
