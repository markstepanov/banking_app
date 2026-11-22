package org.example.menus;

import org.example.Globals;
import org.example.entity.Role;
import org.example.entity.User;

import java.util.Optional;


/** Запрашивает логин и пароль, затем ищет совпадение в общем списке пользователей. */
public class LoginMenu {

    public void register() {
        System.out.println("Придумайте логин:");
        String loginInput = Globals.scanner.nextLine();

        System.out.println("Придумайте пароль:");
        String passwordInput = Globals.scanner.nextLine();
        boolean loginExists = false;

        for (User currentUser : Globals.users) {
            if (currentUser.getUsername().equals(loginInput)) {
                loginExists = true;
                System.out.println("Этот логин уже занят");
            }
        }
        if (!loginExists) {
            Globals.users.add(new User(loginInput, passwordInput, Role.USER));
            System.out.println("Регистрация завершена");
        }
    }


    public Optional<User> login(){
        System.out.println("Здавствуйте! Пожалуйста введите логин:");
        System.out.println("Напишите exit чтобы выйти");
        String loginInput = Globals.scanner.nextLine();

        if (loginInput.equals("exit")){
            // Завершает всё приложение. Код 0 означает обычное завершение.
            System.exit(0);
        }


        System.out.println("Введите пароль:");
        System.out.println("Напишите exit чтобы выйти");
        String passwordInput= Globals.scanner.nextLine();

        if (passwordInput.equals("exit")){
            // Завершает всё приложение. Код 0 означает обычное завершение.
            System.exit(0);
        }

        // Индексы списка начинаются с 0. size() — количество пользователей.
        // После каждой проверки i++ увеличивает индекс на 1.
        for (int i = 0; i < Globals.users.size(); i++){
            // get(i) берёт пользователя с текущим индексом из списка.
            User currentUser = Globals.users.get(i);
            // && требует совпадения обоих условий: и логина, и пароля.
            if (currentUser.getUsername().equals(loginInput)
                    && currentUser.getPassword().equals(passwordInput)
            ){
                // return завершает метод launch() и передаёт пользователя в Main.
                return Optional.of(currentUser);

            }

        }
        return Optional.empty();
    }

    public User launch(){
        // Если данные не подошли, цикл начнёт попытку входа заново.
        while (true){

            System.out.println("1. Войти");
            System.out.println("2. Зарегистрироваться");
            System.out.println("Напишите exit чтобы выйти");
            String input = Globals.scanner.nextLine();

            if (input.equals("exit")){
                // Завершает всё приложение. Код 0 означает обычное завершение.
                System.exit(0);
            }

            if (input.equals("2")) {
                register();
                continue;
            }
            if (input.equals("1")) {
                Optional<User> userOptional =  login();
                if (userOptional.isPresent()){
                    return userOptional.get();
                }
            }


        }
    }



}
