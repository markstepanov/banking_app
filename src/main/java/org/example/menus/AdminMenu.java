package org.example.menus;

import org.example.entity.User;

/** Заготовка меню администратора; доступные действия ещё не реализованы. */
public class AdminMenu {


    private static final String ADD_USER = "1";
    private static final String USER_LIST = "2";
    private static final String BLOCK_USER = "3";
    private static final String UNBLOCK_USER = "4";
    private static final String PROMOTE_USER = "4";
    private static final String EXIT = "5";


    private User user;

    // Конструктор запоминает, для какого администратора создано меню.
    public AdminMenu(User user){
        this.user = user;
    }


    public void launch(){
        while (true) {
            System.out.println(ADD_USER + ". Добавить пользователя");
            System.out.println();
            System.out.println();
            System.out.println();

        }
    }





}
