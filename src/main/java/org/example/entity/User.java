package org.example.entity;

import java.util.ArrayList;
import java.util.List;

/** Пользователь банка: учётные данные, роль и принадлежащие ему счета. */
public class User {

    // private скрывает поля от прямого доступа из других классов.
    private String username;

    private String password;

    private Role role;


    // List<Account> означает список объектов Account: у пользователя может быть несколько счетов.
    private List<Account> accounts;



    // Конструктор вызывается при new User(...), чтобы задать начальное состояние объекта.
    public User(String username, String password, Role role) {
        // this.username — поле объекта, username — параметр этого конструктора.
        this.username = username;
        this.password = password;
        this.role = role;
        // Каждый пользователь получает собственный пустой изменяемый список счетов.
        this.accounts = new ArrayList<>();
    }

    // Методы get... возвращают значения закрытых полей, а set... изменяют их.
    public Role getRole() {

        return role;
    }

    public void setRole(Role role) {

        this.role = role;
    }

    public String getUsername() {

        return this.username;
    }

    public void setUsername(String username) {

        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Account> getAccounts() {
        return accounts;
    }
}
