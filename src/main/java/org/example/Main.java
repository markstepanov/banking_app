package org.example;

import org.example.entity.User;
import org.example.menus.AdminMenu;
import org.example.menus.LoginMenu;
import org.example.menus.UserMenu;



/** Запускает приложение и выбирает меню по роли вошедшего пользователя. */
public class Main {

    // Точка входа: с этого метода начинается выполнение программы.
    static void main() {
        // Бесконечный цикл снова показывает вход после выхода из пользовательского меню.
        while (true) {
            LoginMenu loginMenu = new LoginMenu();
            // launch() возвращает найденного пользователя только после успешного входа.
            User user = loginMenu.launch();


            switch (user.getRole()){
                case USER-> {
                    UserMenu userMenu=new UserMenu(user);
                    userMenu.launch();
                }
                case ADMIN -> {
                    AdminMenu adminMenu = new AdminMenu(user);
                    adminMenu.launch();

                }
            }
        }




            // equals сравнивает содержимое строк. Роль определяет доступное меню.
//            if (user.getRole().equals("admin")){
//                // Меню администратора пока не подключено: выполнение вернётся к входу.
//
//            }
//
//            if (user.getRole().equals("user")){
//                // Передаём пользователя в меню, чтобы оно знало, кто сейчас вошёл.
//            }
//            }
//

    }



}
