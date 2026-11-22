package org.example;

import org.example.entity.User;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

/** Общие данные учебного приложения: список пользователей и чтение ввода из консоли. */
public class Globals {

    // static позволяет обращаться к списку через Globals.users без создания объекта Globals.
    // List.of создаёт список, в который нельзя добавлять или из которого нельзя удалять элементы.
    // Данные находятся только в памяти и при перезапуске создаются заново.
    // Пароли здесь хранятся открыто для учебного примера; в реальном приложении хранят их хеши.
    public static List<User> users = new ArrayList<>(List.of(
            new User("mark", "123", "admin"),
            new User("damir", "222", "user")
    ));

    // Один общий Scanner читает ввод с клавиатуры (System.in).
    // nextLine() в меню получает введённую строку после нажатия Enter.
    public static Scanner scanner = new Scanner(System.in);
    public static long nextAccountNumber = 1;
}
