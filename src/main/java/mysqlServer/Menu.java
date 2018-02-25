package mysqlServer;


import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Scanner;

public class Menu {
    private User user;
    private String comand;

    public String getComand() {
        return comand;
    }

    public void setComand() {
        this.comand = new Scanner(System.in).nextLine();
    }

    public Menu() {
        startMenuText();
        startMenu();
    }
    public void startMenuText(){
        System.out.println("Войти :[LOGIN]");
        System.out.println("Зарегистрироваться :[REGISTER]");
        System.out.println("Выйти :[EXIT]");
    }
    public void startMenu() {
        while (true) {
            setComand();
            switch (comand) {
                case "LOGIN":
                    checkUserScan();
                    user.login();
                    if(user.getError()==null){
                        menuUser();
                    }
                    System.out.println(user.getError());
                    break;
                case "REGISTER":
                    menuRegister();
                    break;
                case "EXIT":
                    return;
                default:
                    System.out.println("Введена не верная команда!");
                    break;
            }
        }
    }

    public void checkUserScan(){
        System.out.println("Введите логин :");
        Scanner scanner = new Scanner(System.in);
        String login = scanner.nextLine();
        System.out.println("Введите пароль :");
        String password = scanner.nextLine();
        user = new User(login, password);
    }

    public void menuUser() {
        System.out.println("Новый диалог :[NEW_DIALOG]");
        System.out.println("Диалоги :[DIALOG]");
        System.out.println("Назад :[BACKWARD]");
        System.out.println("Выйти :[EXIT]");
        while (true) {//тут должно быть условие что логин и пароль введены верно
            setComand();
            switch (comand) {
                case "NEW_DIALOG":

                    break;
                case "DIALOG":
                    //System.out.println(user.getDialog());
                    break;
                case "BACKWARD":
                    startMenuText();
                    startMenu();
                    break;
                case "EXIT":
                    return;
                default:
                    System.out.println("Команда введена не верно!");
                    break;
            }
        }
    }

    public void menuRegister() {
        checkUserScan();
        user.register();
        //условие что логин свободен и логин и пароль (введены коректно длина символов символы и т.д.)
        //если регистрация прошла успешно то перенаправить
        System.out.println("Пользователь успешно зарегистрирован.");
        this.comand = "LOGIN";
        startMenu();
    }

    public void userDialog(){
        //должен отображать тикущие диалоги
    }



}
